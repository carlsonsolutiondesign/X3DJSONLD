<?xml version="1.0" encoding="UTF-8"?>
<!--
Copyright (c) 2001-2015 held by the author(s).  All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer
      in the documentation and/or other materials provided with the
      distribution.
    * Neither the names of the Naval Postgraduate School (NPS)
      Modeling Virtual Environments and Simulation (MOVES) Institute
      (http://www.nps.edu and http://www.MovesInstitute.org)
      nor the names of its contributors may be used to endorse or
      promote products derived from this software without specific
      prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
-->
<!--
  <head>
   <meta name="title"       content="X3dToJson.xslt"/>
   <meta name="author"      content="Don Brutzman"/>
   <meta name="contributor" content="John Carlson provided lots of design guidance and co-development support"/>
   <meta name="created"     content="8 October 2014"/>
   <meta name="description" content="XSLT stylesheet to convert X3D source into JSON syntax."/>
   <meta name="reference"   content="http://www.web3d.org/x3d/stylesheets/X3dToJson.html"/>
   <meta name="reference"   content="http://www.web3d.org/wiki/index.php/X3D_JSON_Encoding"/>
   <meta name="reference"   content="http://www.freeformatter.com/xml-to-json-converter.html"/>
   <meta name="reference"   content="http://json.org"/>
   <meta name="reference"   content="http://www.ecma-international.org/publications/files/ECMA-ST/ECMA-404.pdf"/>
   <meta name="reference"   content="http://www.w3.org/TR/xslt"/>
   <meta name="reference"   content="XML Spy, http://www.xmlspy.com"/>
   <meta name="reference"   content="SAXON XML Toolkit, http://saxon.sourceforge.net"/>
   <meta name="generator"   content="X3D-Edit 3.3, https://savage.nps.edu/X3D-Edit"/>
   <meta name="identififer" content="http://www.web3d.org/x3d/stylesheets/X3dToJson.xslt"/>
   <meta name="reference"   content="https://sourceforge.net/p/x3d/code/HEAD/tree/www.web3d.org/x3d/stylesheets/X3dToJson.xslt"/>
   <meta name="license"     content="license.html"/>
  </head>
--> 
<!--
=======================================================================
  X3D JSON Design Considerations and X3dToJson.xslt Converter Status

  http://www.web3d.org/x3d/stylesheets/X3dToJson.html
=======================================================================
-->

<xsl:stylesheet version="2.0" exclude-result-prefixes="ds saxon"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ds="http://www.w3.org/2000/09/xmldsig#"
                xmlns:saxon="http://icl.com/saxon" saxon:trace="no">
    <!--        
                xmlns="http://www.w3.org/TR/xhtml1/strict"
                xmlns:fn="http://www.w3.org/2005/xpath-functions" -->
                
    <xsl:param name="stripComments"><xsl:text>false</xsl:text></xsl:param>
    <xsl:param name="stripDefaultAttributes"><xsl:text>true</xsl:text></xsl:param>
    <xsl:param name="indentEnabled"><xsl:text>true</xsl:text></xsl:param>
    <xsl:param name="sourceText"><xsl:text>strings</xsl:text></xsl:param> <!-- escaped | strings | plaintext -->
    <xsl:param name="traceEnabled" ><xsl:text>false</xsl:text></xsl:param>
    <xsl:param name="traceScripts" ><xsl:text>false</xsl:text></xsl:param>
        
    <xsl:output method="text" encoding="UTF-8"/> <!-- output methods: xml html text -->
    
    <!-- encodings references -->
    <!-- http://www.sagehill.net/docbookxsl/SpecialChars.html -->
    <!-- http://stackoverflow.com/questions/9328882/encoding-special-chars-in-xslt-output -->
    <!-- http://stackoverflow.com/questions/4901133/json-and-escaping-characters -->
    
    <!-- global variables: none -->
    
    <xsl:template match="/"> <!-- process root of input document -->

        <!-- no commenting mechanism proved in JSON specification. -->
                
        <xsl:apply-templates select="X3D | comment()"> <!-- process top-level X3D element and comments. DOCTYPE dropped. -->
            <xsl:with-param name="indent"><xsl:text>0</xsl:text></xsl:with-param>
        </xsl:apply-templates>
        
    </xsl:template>

    <xsl:template name="comments-elements-ROUTEs"> <!-- rule to process all child comments, elements and ROUTEs (X3D nodes and scene-graph structure statements) -->
        <xsl:param name="indent"><xsl:text>0</xsl:text></xsl:param>

        <!-- each child element is represented in a JSON array of JSON objects -->
        
        <!-- process entire set of immediate-child peers in an ordered fashion:  comments first, field/fieldValue next, IS next, elements next, ROUTEs last -->
        <xsl:variable name="allContainedCommentsElements">
            <!-- order gets shuffled a bit due to JSON unique-key requirements -->
            <xsl:apply-templates select="comment()">
                <xsl:with-param name="indent" select="$indent"/>
            </xsl:apply-templates>
            <xsl:apply-templates select="*">
                <!-- listed in reverse order -->
                <xsl:sort select="    (local-name() = 'ROUTE')"/>
                <xsl:sort select="not((local-name() = 'ROUTE') or (local-name() = 'IS') or (local-name() = 'field') or (local-name() = 'fieldValue'))"/>
                <xsl:sort select="    (local-name() = 'IS')"/>
                <xsl:sort select="    (local-name() = 'field')"/>
                <xsl:sort select="    (local-name() = 'fieldValue')"/>
                <xsl:with-param name="indent" select="$indent"/>
            </xsl:apply-templates>
        </xsl:variable>
        
        <!-- remove final comma -->
        <xsl:value-of select="substring($allContainedCommentsElements,1,string-length($allContainedCommentsElements)-1)"/>
        
    </xsl:template>

    <xsl:template match="*"> <!-- rule to process each element (X3D nodes and scene-graph structure statements) -->
        <xsl:param name="indent"><xsl:text>0</xsl:text></xsl:param>
        <xsl:call-template name="trace">
            <xsl:with-param name="message"><xsl:text></xsl:text></xsl:with-param>
            <xsl:with-param name="element" select="local-name()"/>
            <xsl:with-param name="name"    select="@name"/>
            <xsl:with-param name="DEF"     select="@DEF"/>
            <xsl:with-param name="USE"     select="@USE"/>
            <xsl:with-param name="indent" select="$indent"/>
        </xsl:call-template>
        
        <xsl:variable name="elementName" select="local-name()"/>
        
        <xsl:choose>
            <!-- ============================================================================================ -->
            <xsl:when test="($elementName = 'ProtoInterface')">
                <!-- ignore this marker element itself, simply process contained nodes -->
                <xsl:apply-templates select="* | comment()"> <!-- node() includes CDATA text -->
                    <xsl:with-param name="indent" select="$indent"/>
                </xsl:apply-templates>
            </xsl:when>
            <!-- ============================================================================================ -->
            <xsl:when test="($elementName = 'X3D')       or ($elementName = 'head')       or ($elementName = 'Scene')     or
                            ($elementName = 'component') or ($elementName = 'meta')       or ($elementName = 'unit')      or 
                            ($elementName = 'IS')        or ($elementName = 'connect')    or ($elementName = 'ROUTE')     or
                            ($elementName = 'field')     or ($elementName = 'fieldValue') or ($elementName = 'ProtoBody') or
                            ($elementName = 'IMPORT')    or ($elementName = 'EXPORT')">
                <!-- special statements: scene-graph structure element may have attributes, contains arrays, NOT surrounded by {squiggly brackets} -->
                
                <!-- if first of multiple siblings, process all at once -->
                <xsl:if test="not(preceding-sibling::*[local-name() = $elementName])">
                    <!-- first peer of its kind, found no preceding siblings with same name -->
                 
                    <!-- special case: scene-graph top-level structure element -->
                    <xsl:choose>
                        <xsl:when test="($elementName='X3D')">
                            <xsl:text>{ </xsl:text>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text>&#10;</xsl:text>
                            <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>
                        </xsl:otherwise>
                    </xsl:choose>    

                    <xsl:text>"</xsl:text>
                    <xsl:value-of select="$elementName"/>
                    <xsl:text>"</xsl:text>
                    <xsl:text>:</xsl:text><!-- [scene-graph structure element contains keys -->
                    
                    <!-- special case: scene-graph structure elements -->
                    <xsl:choose>
                        <xsl:when test="($elementName='X3D')">
                            <!-- all set already -->
                        </xsl:when>
                        <xsl:when test="($elementName='head') or ($elementName='Scene') or ($elementName='ProtoBody') or ($elementName='IS')">
                            <xsl:if test="(count(@*) = 0)">
                                <xsl:text> {</xsl:text>
                            </xsl:if>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text> [</xsl:text>
                        </xsl:otherwise>
                    </xsl:choose>
                    
                    <xsl:for-each select="(self::* | following-sibling::*[local-name() = $elementName])">
                        <!-- process all elements of this type at once -->
                
                        <!-- process attributes for this element, if any -->
                        <xsl:if test="@*">
                            <xsl:choose>
                                <xsl:when test="($elementName='X3D')">
                                    <xsl:text> </xsl:text>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:text>&#10;</xsl:text>
                                    <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent+2"/></xsl:call-template>
                                </xsl:otherwise>
                            </xsl:choose>
                            <xsl:text>{</xsl:text><!-- attributes + follow-on nodes in scene-graph structure array -->
                            <xsl:call-template name="attributes">
                                <xsl:with-param name="indent"><xsl:value-of select="$indent+2"/></xsl:with-param>
                            </xsl:call-template>
                        </xsl:if>
                        
                        <xsl:call-template name="comments-elements-ROUTEs">
                            <xsl:with-param name="indent"><xsl:value-of select="$indent+4"/></xsl:with-param>
                        </xsl:call-template>

                        <xsl:if test="@*">
                            <xsl:text>&#10;</xsl:text>
                            <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent+2"/></xsl:call-template>
                            <xsl:text>}</xsl:text><!-- attributes + follow-on nodes in scene-graph structure array -->
                        </xsl:if>
                        
                        <!-- commas separate objects in this array.  do not terminate with comma. -->
                        <xsl:if test="(last() > position())"> 
                            <xsl:text>,</xsl:text>
                        </xsl:if>
                    </xsl:for-each>
                    
                    <!-- special case: scene-graph structure elements -->
                    <xsl:choose>
                        <xsl:when test="($elementName='X3D')">
                            <!-- all set already -->
                        </xsl:when>
                        <xsl:when test="($elementName='head') or ($elementName='Scene') or ($elementName='ProtoBody') or ($elementName='IS')">
                            <xsl:if test="(count(@*) = 0)">
                                <xsl:text>&#10;</xsl:text>
                                <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>
                                <xsl:text>}</xsl:text>
                            </xsl:if>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text>&#10;</xsl:text>
                            <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>
                            <xsl:text>]</xsl:text>
                        </xsl:otherwise>
                    </xsl:choose>
                    
                    <!-- special case: scene-graph top-level structure element -->
                    <xsl:choose>
                        <xsl:when test="($elementName='X3D')">
                            <xsl:text>&#10;</xsl:text>
                            <xsl:text>}</xsl:text>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text>,</xsl:text>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:if> <!-- initial sibling -->
            </xsl:when>
            <!-- ============================================================================================ -->
            <xsl:otherwise>
                <!-- base case: simple element, optional attributes, accessed by containerField -->
                
                <xsl:variable name="fieldName">
                    <xsl:choose>
                        <!-- ProtoDeclare and ExternProtoDeclare names are encoded with children nodes -->
                        <xsl:when test="($elementName = 'ProtoDeclare') or ($elementName = 'ExternProtoDeclare')">
                            <!-- <xsl:value-of select="$elementName"/>  similarly to containerField names, each contains an array-->
                            <xsl:text>children</xsl:text>
                        </xsl:when>
                        <!-- ProtoBody handled by previous rule, not needed here -->
                        <xsl:when test="string-length(@containerField) > 0">
                            <xsl:value-of select="@containerField"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text>childNodeFieldNameNotFound</xsl:text>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:variable>
                
                <!-- if first of multiple siblings, process all at once -->
                <xsl:if test="not(preceding-sibling::*[@containerField = $fieldName] | 
                                  preceding-sibling::ProtoDeclare      [$fieldName = 'children'] | 
                                  preceding-sibling::ExternProtoDeclare[$fieldName = 'children'])">
                    <!-- first peer of its kind, found no preceding siblings with same name -->
                    
                    <xsl:text>&#10;</xsl:text>
                    <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>

                    <xsl:if test="not(local-name() = 'ProtoBody')">
                        <xsl:text>"</xsl:text>
                        <xsl:text>-</xsl:text><!-- visual assist, TODO determine if part of final pattern -->

                        <xsl:value-of select="$fieldName"/>
                        <xsl:text>"</xsl:text>
                        <xsl:text>:[</xsl:text><!-- children containerField -->
                    </xsl:if>

                    <xsl:for-each select="(self::* | following-sibling::*[@containerField = $fieldName] | 
                                           following-sibling::ProtoDeclare      [$fieldName = 'children'] | 
                                           following-sibling::ExternProtoDeclare[$fieldName = 'children'])">
                        <!-- greedy algorithm to process all elements of this field type at once -->
                        <!-- base case: simple element, optional attributes, accessed by containerField -->
                        <xsl:text>&#10;</xsl:text>
                        <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent+2"/></xsl:call-template>
                        <xsl:text>{</xsl:text><!-- base case: simple element inside containerField -->
                        <xsl:text> </xsl:text>
                        <xsl:text>"</xsl:text>
                        <xsl:value-of select="local-name()"/> <!-- $elementName not working?? -->
                        <xsl:text>"</xsl:text>
                        <xsl:text>:</xsl:text>

                        <!-- process attributes for this element, if any -->
                        <xsl:if test="@*">
                            <xsl:text>&#10;</xsl:text>
                            <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent+4"/></xsl:call-template>
                            <xsl:text>{</xsl:text><!-- attributes array for otherwise case (followed by additional contained nodes, if any) -->
                            <xsl:call-template name="attributes">
                                <xsl:with-param name="indent" select="$indent+4"/>
                            </xsl:call-template>
                        </xsl:if>
                        
                        <xsl:if test="* | comment()"> <!-- node() includes CDATA text -->
                            <!-- each child element is represented in a JSON array of JSON objects -->
                            <xsl:call-template name="comments-elements-ROUTEs">
                                <xsl:with-param name="indent"><xsl:value-of select="$indent+6"/></xsl:with-param>
                            </xsl:call-template>
                        </xsl:if>
                        
                        <!-- process contained child text(), looking for source code -->
                        <xsl:if test="(string-length(normalize-space(.)) > 0) and not(normalize-space(.) = ' ')">
                            <!-- add comma separator if field/IS/connect definitions are preceding and this is indeed the node containing source code (rather than a descendant) -->
                            <xsl:if test="((local-name() = 'Script') or (local-name() = 'ShaderPart') or (local-name() = 'ShaderProgram'))">
                                <xsl:if test="node()">
                                    <xsl:text>,</xsl:text>
                                </xsl:if>
                                <xsl:text>&#10;</xsl:text>
                                <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent+6"/></xsl:call-template>
                                <xsl:apply-templates select="text()"/> <!-- Script/ShaderPart/ShaderProgram #sourceText -->
                            </xsl:if>
                        </xsl:if>

                        <xsl:if test="@*">
                            <xsl:text>&#10;</xsl:text>
                            <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent+4"/></xsl:call-template>
                            <xsl:text>}</xsl:text><!-- attributes array for otherwise case (followed by additional contained nodes, if any) -->
                        </xsl:if>

                        <xsl:text>&#10;</xsl:text>
                        <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent+2"/></xsl:call-template>
                        <xsl:text>}</xsl:text><!-- base case: simple element inside containerField -->

                        <!-- commas separate objects in this array.  do not terminate with comma. -->
                        <xsl:if test="(last() > position())"> 
                            <xsl:text>,</xsl:text>
                        </xsl:if>
                    </xsl:for-each>
                
                    <xsl:if test="not(local-name() = 'ProtoBody')">
                        <xsl:text>&#10;</xsl:text>
                        <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>
                        <xsl:text>]</xsl:text><!-- children containerField -->
                    </xsl:if>

                    <!-- <xsl:if test="parent::Scene or parent::ProtoBody or (not(../@*) and not(../preceding-sibling::comment()))">
                    <xsl:text>&#10;</xsl:text>
                    <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>
                        <xsl:text>}</xsl:text>base case: brackets outside containerField
                    </xsl:if> -->

                    <xsl:text>,</xsl:text>
                </xsl:if> <!-- initial sibling -->

            </xsl:otherwise>
            <!-- ============================================================================================ -->
        </xsl:choose>
        
    </xsl:template> <!-- end match="*" -->

    <xsl:template match="comment()">
        <xsl:param name="indent"><xsl:text>0</xsl:text></xsl:param>
        <xsl:param name="stripComments"><xsl:value-of select="$stripComments"/></xsl:param>

        <xsl:call-template name="trace">
            <xsl:with-param name="message">
                <xsl:text>$stripComments=</xsl:text>
                <xsl:value-of select="$stripComments"/>
                <xsl:text>, </xsl:text>
                <xsl:value-of select="normalize-space(.)"/>
            </xsl:with-param>
            <xsl:with-param name="element"><xsl:text>#comment</xsl:text></xsl:with-param>
            <xsl:with-param name="indent" select="$indent"/>
            <xsl:with-param name="traceEnabled"><xsl:text>false</xsl:text></xsl:with-param>
        </xsl:call-template>
        
        <xsl:if test="not($stripComments = 'true') and (count(preceding-sibling::comment()) = 0)">

            <!-- "#comment" is used as key for this JSON object, similar to ROUTE or other containerField values, which collects an array of JSON strings -->

            <xsl:text>&#10;</xsl:text>
            <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>
            <!-- <xsl:if test="parent::Scene or parent::ProtoBody or not(../@*)">
                <xsl:text>{ </xsl:text>base case: brackets outside comment
            </xsl:if> -->
            <xsl:text>"</xsl:text>
            <xsl:text>#comment</xsl:text> <!-- comment prefix -->
            <xsl:value-of select="name()"/>
            <xsl:text>"</xsl:text>
            <xsl:text>:[</xsl:text>
            
            <xsl:variable name="allCommentsStringArray">
                <!-- greedily put all peer comments in this array of strings -->
                <xsl:for-each select="self::comment() | following-sibling::comment()">
                    <xsl:text>&#10;</xsl:text>
                    <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent+2"/></xsl:call-template>
                    <xsl:text>"</xsl:text>
                    <!--  escaped quote requires preceding backslash in JSON encoding -->
                    <xsl:call-template name="escape-special-characters-quotes-recurse">
                        <xsl:with-param name="inputString" select="."/>
                        <xsl:with-param name="inputType"><xsl:text>SFString</xsl:text></xsl:with-param>
                    </xsl:call-template>
                    <xsl:text>"</xsl:text>
                    <xsl:text>,</xsl:text>
                </xsl:for-each>
            </xsl:variable>
            <!-- strip trailing comma -->
            <xsl:value-of select="substring($allCommentsStringArray,1,string-length($allCommentsStringArray)-1)"/>
            
            <xsl:text>&#10;</xsl:text>
            <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>
            <xsl:text>]</xsl:text>
            <!-- <xsl:if test="parent::Scene or parent::ProtoBody or not(../@*)">
                <xsl:text>&#10;</xsl:text>
                <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>
                <xsl:text>}</xsl:text>base case: brackets outside comment
            </xsl:if> -->
            <xsl:text>,</xsl:text>
        </xsl:if>
    </xsl:template> <!-- match="comment()" -->

    <xsl:template name="attributes"> <!-- rule to process all attributes -->
        <xsl:param name="indent"><xsl:text>0</xsl:text></xsl:param>

        <xsl:variable name="allAttributesString">
            <xsl:apply-templates select="@*">
                <xsl:sort select="not(local-name() = 'name')"/>
                <xsl:sort select="   (local-name() = 'name')"/>
                <xsl:with-param name="indent" select="$indent+2"/>
            </xsl:apply-templates>
        </xsl:variable>
        <!-- strip final comma, when follow-on element(s) or comment(s) are contained -->
        <xsl:choose>
            <xsl:when test="* | comment()"> <!-- node() includes CDATA text -->
                <xsl:value-of select="$allAttributesString"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="substring($allAttributesString,1,string-length($allAttributesString)-1)"/>
            </xsl:otherwise>
        </xsl:choose>
        
    </xsl:template> <!-- end match="attributes" -->

    <xsl:template match="@*"> <!-- rule to process each @attribute -->
        <xsl:param name="isComment"><xsl:text>false</xsl:text></xsl:param>
        <xsl:param name="indent"><xsl:text>0</xsl:text></xsl:param>

        <!-- an attribute is handled as a JSON "@name":_value_ pair with appropriate type matching -->
 
        <xsl:variable name="normalizedValue" select="normalize-space(string(.))"/>
        
        <!-- Detect and suppress default attribute values -->
        
        <xsl:variable name="notDefaultAttributeValue">
            <xsl:call-template name="not-default-attribute-value">
            </xsl:call-template>
        </xsl:variable>
        
        <!-- eliminate default attribute values (based on parameter setting) otherwise they will all appear in output  -->
        <xsl:if test="(string-length($notDefaultAttributeValue) > 0) or 
                      (local-name()='DEF') or (local-name()='USE')">
        
            <xsl:variable name="attributeName"     select="local-name()"/>
            <xsl:variable name="fieldValueName"    select="../@name"/>
            <xsl:variable name="protoInstanceName" select="(../../@name)"/>
            <xsl:variable name="fieldValueType1"   select="      //ProtoDeclare[@name = $protoInstanceName][1]/ProtoInterface/field[@name=$fieldValueName][1]/@type"/>
            <xsl:variable name="fieldValueType2"   select="//ExternProtoDeclare[@name = $protoInstanceName][1]               /field[@name=$fieldValueName][1]/@type"/>
            <!-- only one of these should be available -->
            <xsl:variable name="fieldValueType"    select="concat($fieldValueType1,$fieldValueType2)"/>
            <!-- debug
            <xsl:if test="(string-length($protoInstanceName) > 0) and ($attributeName = 'value')">
                <xsl:message>
                    <xsl:text>$protoInstanceName=</xsl:text>
                    <xsl:value-of select="$protoInstanceName"/>
                    <xsl:text>, fieldValue $attributeName=</xsl:text>
                    <xsl:value-of select="$attributeName"/>
                    <xsl:text>, $fieldValueName=</xsl:text>
                    <xsl:value-of select="$fieldValueName"/>
                    <xsl:text>, $normalizedValue=</xsl:text>
                    <xsl:value-of select="$normalizedValue"/>
                    <xsl:text>, @name=</xsl:text>
                    <xsl:value-of select="local-name(//*[contains(local-name(),'ProtoDeclare')][@name = $protoInstanceName])"/>
                    <xsl:text>, @type=</xsl:text>
                    <xsl:value-of select="//*[contains(local-name(),'ProtoDeclare')][@name = $protoInstanceName]//field[@name=$fieldValueName]/@type"/>
                    <xsl:text>, $fieldValueType=</xsl:text>
                    <xsl:value-of select="$fieldValueType"/>
                </xsl:message>
            </xsl:if>
            -->
            
            <!-- common processing for each attribute -->
            <!--  escaped quote requires preceding backslash in JSON encoding
            <xsl:variable name="normalizedSFStringEmbeddedQuotes">
                <xsl:call-template name="escape-special-characters-quotes-recurse">
                  <xsl:with-param name="inputString" select="normalize-space(.)"/>
                  <xsl:with-param name="inputType"><xsl:text>SFString</xsl:text></xsl:with-param>
                </xsl:call-template>
            </xsl:variable> -->
            <xsl:variable name="containsQuote"        select="contains($normalizedValue, '&quot;')"/>
            <xsl:variable name="containsEscapedQuote" select="contains($normalizedValue,'\&quot;')"/>
            <xsl:variable name="normalizedFloats">
                <xsl:call-template name="insert-leading-trailing-zeroes-recurse">
                  <xsl:with-param name="inputString" select="normalize-space(translate($normalizedValue, ',', ' '))"/>
                </xsl:call-template>
            </xsl:variable>
            
            <!-- now process attribute value.  if this attribute is part of a USE node, then only output USE, containerField, class attributes. -->
            <xsl:if test="(string-length(../@USE) = 0) or (local-name()='USE') or 
                          (local-name()='containerField') or (local-name()='class') or
                          (local-name(..)='X3D') and ((local-name()='profile') or (local-name()='version'))">
                <xsl:text>&#10;</xsl:text>
                <xsl:call-template name="print-indent"><xsl:with-param name="indent" select="$indent"/></xsl:call-template>

                <xsl:text>"</xsl:text>
                <xsl:text>@</xsl:text> <!-- attribute prefix -->
                <xsl:value-of select="name()"/>
                <xsl:text>"</xsl:text>
                <xsl:text>:</xsl:text>
                <xsl:choose>
                    <!-- deterministic rules first: use type information for normalizing text or numbers or booleans -->
                    <xsl:when test="($normalizedValue='true') or ($normalizedValue='false') or 
                                    ((local-name()='value') and ((../@type='SFBool') or (contains(local-name(../..),'ProtoDeclare') and ($fieldValueType='SFBool'))))">
                        <!-- single boolean -->
                        <xsl:value-of select="$normalizedValue"/>
                    </xsl:when>
                    <xsl:when test="((local-name()='value') and ((../@type='MFBool') or (contains(local-name(../..),'ProtoDeclare') and ($fieldValueType='MFBool')))) or
                                    ((local-name(..)='BooleanSequencer')    and (local-name()='keyValue')) or
                                    ((local-name(..)='MetadataBoolean')     and (local-name()='value')) or
                                    ((local-name(..)='CADLayer')            and (local-name()='visible')) or
                                    ((local-name(..)='SegmentedVolumeData') and (local-name()='segmentEnabled'))">
                        <!-- boolean array -->
                        <xsl:text>[</xsl:text>
                        <!--  array values require comma between values in JSON encoding -->
                        <xsl:call-template name="insert-commas-recurse">
                          <xsl:with-param name="inputString" select="$normalizedValue"/>
                          <xsl:with-param name="inputType"><xsl:text>MFBool</xsl:text></xsl:with-param>
                        </xsl:call-template>
                        <xsl:text>]</xsl:text>
                    </xsl:when>
                    <xsl:when test="(((local-name()='value') and ((../@type='SFString') or (contains(local-name(../..),'ProtoDeclare') and ($fieldValueType='SFString')))) or
                                      (local-name()='DEF')        or (local-name()='USE')           or (local-name()='class')   or (local-name()='containerField') or
                                      (local-name()='fromField')  or (local-name()='fromNode')      or (local-name()='toField') or (local-name()='toNode')         or
                                      (local-name()='appinfo')    or (local-name()='description')   or (local-name()='name')    or (local-name()='accessType')     or 
                                      (local-name()='content')    or (local-name()='documentation') or
                                     ((local-name()='type') and not(local-name(..)='NavigationInfo')) and
                                     not(local-name()='url') or ends-with(local-name(),'Url'))">
                        <!-- single string -->
                        <xsl:text>"</xsl:text>
                        <!--  escaped quote requires preceding backslash in JSON encoding -->
                        <xsl:call-template name="escape-special-characters-quotes-recurse">
                          <xsl:with-param name="inputString" select="$normalizedValue"/>
                          <xsl:with-param name="inputType"><xsl:text>SFString</xsl:text></xsl:with-param>
                        </xsl:call-template>
                        <xsl:text>"</xsl:text>
                    </xsl:when>
                    <xsl:when test="((local-name()='value') and ((../@type='MFString') or (contains(local-name(../..),'ProtoDeclare') and ($fieldValueType='MFString')))) or
                                     (local-name()='url') or ends-with(local-name(),'Url') or (local-name()='geoSystem') or
                                    ((local-name(..)='Text')                and (local-name()='string')) or
                                    ((local-name(..)='Anchor')              and (local-name()='parameter')) or
                            (contains(local-name(..),'FontStyle')           and ((local-name()='family') or (local-name()='justify'))) or
                                    ((local-name(..)='MetadataString')      and (local-name()='value')) or
                                    ((local-name(..)='MultiTexture')        and ((local-name()='function') or (local-name()='mode') or (local-name()='source'))) or
                                    ((local-name(..)='NavigationInfo')      and ((local-name()='type') or (local-name()='transitionType'))) or
                                    ((local-name(..)='WorldInfo')           and (local-name()='info')) or
                                    ((local-name(..)='GeoMetadata')         and (local-name()='summary')) or
                                    ((local-name(..)='HAnimHumanoid')       and (local-name()='info')) or
                                    ((local-name(..)='Layout')              and ((local-name()='align') or (local-name()='offsetUnits') or (local-name()='scaleMode') or (local-name()='sizeUnits'))) or
                                    ((local-name(..)='CollisionCollection') and (local-name()='appliedParameters')) or
                                    ((local-name(..)='GeoViewpoint')        and (local-name()='navType')) or
                                     (local-name()='objectType')">
                        <!-- string array -->
                        <xsl:text>[</xsl:text>
                        
                        <xsl:variable name="escape-special-characters-quotes-recurse-result">
                            <xsl:call-template name="escape-special-characters-quotes-recurse">
                                <xsl:with-param name="inputString" select="$normalizedValue"/>
                                <xsl:with-param name="inputType"><xsl:text>MFString</xsl:text></xsl:with-param>
                            </xsl:call-template>
                        </xsl:variable>
                        <!-- debug
                        <xsl:message>
                            <xsl:text>$escape-special-characters-quotes-recurse-result=</xsl:text>
                            <xsl:value-of select="$escape-special-characters-quotes-recurse-result"/>
                        </xsl:message>
                        -->
                        <xsl:variable name="insert-commas-recurse-result">
                            <xsl:call-template name="insert-commas-recurse">
                                <xsl:with-param name="inputString">
                                    <xsl:call-template name="escape-special-characters-quotes-recurse">
                                        <xsl:with-param name="inputString" select="$escape-special-characters-quotes-recurse-result"/>
                                        <xsl:with-param name="inputType"><xsl:text>MFString</xsl:text></xsl:with-param>
                                    </xsl:call-template>
                                </xsl:with-param>
                                <xsl:with-param name="inputType"><xsl:text>MFString</xsl:text></xsl:with-param>
                            </xsl:call-template>
                        </xsl:variable>
                        <!-- debug
                        <xsl:message>
                            <xsl:text>$insert-commas-recurse-result=</xsl:text>
                            <xsl:value-of select="$insert-commas-recurse-result"/>
                        </xsl:message>
                        -->
                        <xsl:choose>
                            <xsl:when test="not(starts-with($normalizedValue,'&quot;')) and not(ends-with($normalizedValue,'&quot;'))">
                                <xsl:text>&quot;</xsl:text>
                                <xsl:value-of select="$escape-special-characters-quotes-recurse-result"/>
                                <xsl:text>&quot;</xsl:text>     
                                <xsl:call-template name="trace">
                                    <xsl:with-param name="message">
                                        <xsl:text>: wrapped missing &quot;quote marks&quot; around single-string value for MFString @</xsl:text>
                                        <xsl:value-of select="local-name()"/>
                                        <xsl:text>... be sure to fix source file!</xsl:text>
                                        <xsl:if test="($traceScripts = 'true')">
                                            <xsl:text>&#10;</xsl:text>
                                            <xsl:value-of select="."/>
                                        </xsl:if>
                                    </xsl:with-param>
                                    <xsl:with-param name="element" select="local-name(..)"/>
                                    <xsl:with-param name="name"    select="../@name"/>
                                    <xsl:with-param name="DEF"     select="../@DEF"/>
                                    <xsl:with-param name="USE"     select="../@USE"/>
                                    <xsl:with-param name="traceEnabled"><xsl:text>true</xsl:text></xsl:with-param><!-- override -->
                                </xsl:call-template>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:value-of select="$insert-commas-recurse-result"/>
                            </xsl:otherwise>
                        </xsl:choose>

                        <xsl:text>]</xsl:text>
                    </xsl:when>
                    <xsl:when test="(local-name()='value') and ((../@type='SFInt32')        or (../@type='SFFloat') or
                                    (contains(local-name(../..),'ProtoDeclare') and ($fieldValueType='SFInt32') or ($fieldValueType='SFFloat')))">
                        <!-- single number -->
                        <xsl:value-of select="$normalizedFloats"/>
                    </xsl:when>
                    <xsl:when test="((local-name()='value') and 
                                     (             (../@type='MFInt32') or                   (../@type='MFFloat') or 
                                        starts-with(../@type,'SFVec')   or        starts-with(../@type,'MFVec')   or
                                           contains(../@type,'Color')   or           contains(../@type,'Matrix'))  or
                                     (contains(local-name(../..),'ProtoDeclare') and 
                                     (      ($fieldValueType='MFInt32') or            ($fieldValueType='MFFloat') or 
                                 starts-with($fieldValueType,'SFVec')   or starts-with($fieldValueType,'MFVec')   or
                                    contains($fieldValueType,'Color')   or    contains($fieldValueType,'Matrix'))))">
                        <!-- number array -->
                        <xsl:text>[</xsl:text>
                        <!--  array values require comma between values in JSON encoding -->
                        <xsl:call-template name="insert-commas-recurse">
                            <xsl:with-param name="inputString" select="$normalizedFloats"/>
                            <xsl:with-param name="inputType"><xsl:text>[number]</xsl:text></xsl:with-param>
                        </xsl:call-template>
                        <xsl:text>]</xsl:text>
                    </xsl:when>
                    <!-- heuristic rules next -->
                    <xsl:when test="(local-name()='address') or 
                                    (local-name()='multicastRelayHost') or
                                    ((string-length(translate($normalizedValue,'.','')) + 3 = (string-length($normalizedValue))) and not(contains($normalizedValue,' ')))">
                        <!-- string for IP address -->
                        <xsl:text>"</xsl:text>
                        <xsl:value-of select="$normalizedValue"/>
                        <xsl:text>"</xsl:text>
                    </xsl:when>
                    <xsl:when test="not(contains($normalizedValue,' ')) and (string-length(normalize-space(translate($normalizedValue,'0123456789+-Ee.,',''))) = 0)">
                        <!-- single number -->
                        <xsl:value-of select="$normalizedFloats"/>
                    </xsl:when>
                    <xsl:when test="(string-length(normalize-space(translate($normalizedValue,'0123456789+-Ee.,',''))) = 0)">
                        <!-- number array -->
                        <xsl:text>[</xsl:text>
                        <!--  array values require comma between values in JSON encoding -->
                        <xsl:call-template name="insert-commas-recurse">
                            <xsl:with-param name="inputString" select="$normalizedFloats"/>
                            <xsl:with-param name="inputType"><xsl:text>[number]</xsl:text></xsl:with-param>
                        </xsl:call-template>
                        <xsl:text>]</xsl:text>
                    </xsl:when>
                    <xsl:when test="($containsQuote and not($containsEscapedQuote)) and 
                                     not((local-name(..)='meta') or (local-name()='description'))">
                                    <!-- TODO list SFString values that might contain a quote mark -->
                        <!-- string array -->
                        <xsl:text>[</xsl:text>
                        <xsl:call-template name="insert-commas-recurse">
                            <xsl:with-param name="inputString">
                                <xsl:call-template name="escape-less-than-characters-recurse">
                                    <xsl:with-param name="inputString" select="$normalizedValue"/>
                                </xsl:call-template>
                            </xsl:with-param>
                            <xsl:with-param name="inputType"><xsl:text>MFString</xsl:text></xsl:with-param>
                        </xsl:call-template>
                        <xsl:text>]</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <!-- single string -->
                        <xsl:text>"</xsl:text>
                        <!--  escaped quote requires preceding backslash in JSON encoding -->
                        <xsl:call-template name="escape-special-characters-quotes-recurse">
                            <xsl:with-param name="inputString" select="$normalizedValue"/>
                            <xsl:with-param name="inputType"><xsl:text>SFString</xsl:text></xsl:with-param>
                        </xsl:call-template>
                        <xsl:text>"</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>

                <xsl:text>,</xsl:text>
            </xsl:if>
        </xsl:if>
        
    </xsl:template> <!-- end match="@*" -->

    <xsl:template match="text()"> <!-- rule to isolate stray text -->
    
        <xsl:choose>
            <xsl:when test="(string-length(normalize-space(.)) > 0) and not(normalize-space(.) = ' ')">
                <xsl:variable name="elementName" select="local-name(..)"/>
                <!-- TODO also look for namespace of parent element so that XML Security and other compound-document elements get reported -->
                <xsl:variable name="textMessage">
                    <xsl:choose>
                        <xsl:when test="($elementName = 'Script') or ($elementName = 'ShaderPart') or ($elementName = 'ShaderProgram')">
                            <xsl:text> contains CDATA source-code text, copied as "#sourceText" using &quot;</xsl:text>
                            <xsl:value-of select="$sourceText"/>
                            <xsl:text>&quot; mode</xsl:text>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text> contains stray text</xsl:text>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:variable>
        
                <xsl:call-template name="trace">
                    <xsl:with-param name="message">
                        <xsl:if test="($traceScripts = 'true')">
                            <xsl:text>&#10;</xsl:text>
                            <xsl:value-of select="."/>
                        </xsl:if>
                    </xsl:with-param>
                    <xsl:with-param name="element" select="$elementName"/>
                    <xsl:with-param name="name"    select="../@name"/>
                    <xsl:with-param name="DEF"     select="../@DEF"/>
                    <xsl:with-param name="USE"     select="../@USE"/>
                    <xsl:with-param name="traceEnabled"><xsl:text>true</xsl:text></xsl:with-param><!-- override -->
                </xsl:call-template>
                
                <!-- "#sourceText" is used as key for this JSON object, similar to #comment, but note that there is no array of source JSON strings -->
                
                <xsl:text>"</xsl:text>
                <xsl:text>#sourceText</xsl:text> <!-- comment prefix -->
                <xsl:value-of select="name()"/>
                <xsl:text>"</xsl:text>
                <xsl:text>:</xsl:text>
                
                <xsl:variable name="sourceStringText">
                    <xsl:call-template name="escape-quotes-recurse">
                        <xsl:with-param name="inputString">
                            <xsl:call-template name="omit-leading-trailing-whitespace">
                                <xsl:with-param name="inputString" select="."/>
                            </xsl:call-template>
                        </xsl:with-param>
                    </xsl:call-template>
                </xsl:variable>

                <!-- json, jslint insist on \n instead of newline characters, since humans are less important than machine dogma. -->
                <!-- output options for embedded source:  escaped | strings | plaintext -->
                <xsl:choose>
                    <xsl:when test="($sourceText = 'escaped')">
                        <xsl:text>[</xsl:text>
                        <xsl:text>"</xsl:text>
                        <xsl:call-template name="replace-newlines-recurse">
                            <xsl:with-param name="inputString">
                                <xsl:call-template name="replace-tabs-recurse">
                                    <xsl:with-param name="inputString" select="$sourceStringText"/>
                                </xsl:call-template>
                            </xsl:with-param>
                        </xsl:call-template>
                        <xsl:text>"</xsl:text>
                        <xsl:text>]</xsl:text>
                    </xsl:when>
                    <xsl:when test="($sourceText = 'plaintext')">
                        <xsl:text>[</xsl:text>
                        <xsl:text>&#10;</xsl:text>
                        <xsl:text>"</xsl:text>
                        <xsl:value-of select="$sourceStringText"/> <!-- newline and tab characters unmodified -->
                        <xsl:text>"</xsl:text>
                        <xsl:text>]</xsl:text>
                        <xsl:text>&#10;</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:if test="not($sourceText = 'strings')">
                            <xsl:message>
                                <xsl:text>illegal value for $sourceText=</xsl:text>
                                <xsl:value-of select="$sourceText"/>
                                <xsl:text>, allowed values are escaped | strings | plaintext.  Using default $sourceText=strings</xsl:text>
                            </xsl:message>
                        </xsl:if>
                        <xsl:text>[</xsl:text>
                        <xsl:call-template name="split-text-block-into-string-array">
                            <xsl:with-param name="inputString">
                                <xsl:call-template name="replace-tabs-recurse">
                                    <xsl:with-param name="inputString" select="$sourceStringText"/>
                                </xsl:call-template>
                            </xsl:with-param>
                        </xsl:call-template>
                        <xsl:text>&#10;</xsl:text>
                        <xsl:text>]</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:when>
            <xsl:otherwise>
                <!-- ignore -->
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <!-- print-indent keeps track of indenting level -->
    <xsl:template name="print-indent">
      <xsl:param name="indent"><xsl:text>0</xsl:text></xsl:param>
      <xsl:if test="($indentEnabled = 'true') and ($indent > 0)">
        <xsl:text> </xsl:text>
        <xsl:call-template name="print-indent">
          <xsl:with-param name="indent" select="$indent - 1"/>
        </xsl:call-template>
      </xsl:if>
    </xsl:template>
    
    <xsl:template name="escape-special-characters-quotes-recurse">
        <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- already normalized white space -->
        <xsl:param name="inputType"><xsl:text>false</xsl:text></xsl:param>
        
        <xsl:call-template name="escape-quotes-recurse">
            <xsl:with-param name="inputType"><xsl:value-of select="$inputType"/></xsl:with-param>
            <xsl:with-param name="inputString">
                <xsl:call-template name="escape-less-than-characters-recurse">
                    <xsl:with-param name="inputString">
                        <xsl:call-template name="escape-greater-than-characters-recurse">
                            <xsl:with-param name="inputString" select="normalize-space($inputString)"/>
                        </xsl:call-template>
                    </xsl:with-param>
                </xsl:call-template>
            </xsl:with-param>
        </xsl:call-template>
    </xsl:template>

    <xsl:template name="escape-quotes-recurse">
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- already normalized white space -->
      <xsl:param name="inputType"><xsl:text>false</xsl:text></xsl:param>

      <!-- debug
      <xsl:message>
          <xsl:value-of select="local-name()"/>
          <xsl:text>:</xsl:text>
          <xsl:variable name="reentry" select="$inputString"/>
          <xsl:value-of select="$reentry"/>
          <xsl:text> [inputType=</xsl:text>
          <xsl:value-of select="$inputType"/>
          <xsl:text>]</xsl:text>
      </xsl:message> -->
      
      <!--  escaped quote " within an SFString value requires a preceding backslash \ in JSON encoding. -->
      <!--  must be careful not to escape "delimiting" "quotes" in MFString array. -->
      <xsl:choose>
        <!-- no quote, all done -->
        <xsl:when test="not(contains($inputString,'&quot;'))">
          <!-- <xsl:message><xsl:text>[1]</xsl:text></xsl:message> -->
          <xsl:value-of select="$inputString"/>
        </xsl:when>
        <!-- comment: unescaped quote needs \ escape character inserted, no quote delimiter remaining -->
        <xsl:when test="self::comment() and contains($inputString,'&quot;')">
          <!-- <xsl:message><xsl:text>[2]</xsl:text></xsl:message> -->
          <xsl:value-of select="substring-before($inputString,'&quot;')"/>
          <xsl:text>\&quot;</xsl:text>
          <xsl:call-template name="escape-quotes-recurse">
              <xsl:with-param name="inputString" select="substring-after($inputString,'&quot;')"/>
              <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
        </xsl:when>
        <!-- SFString with quoted value -->
        <xsl:when test="($inputType = 'SFString') and starts-with($inputString,'&quot;')">
          <!-- <xsl:message><xsl:text>[3]</xsl:text></xsl:message> -->
          <xsl:text>\&quot;</xsl:text>
          <xsl:call-template name="escape-quotes-recurse">
              <xsl:with-param name="inputString" select="substring($inputString,2,string-length($inputString) - 1)"/>
              <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
        </xsl:when>
        <!-- starting and ending quotes indicate outer delimeters of MFString array -->
        <xsl:when test="starts-with($inputString,'&quot;') and ends-with($inputString,'&quot;')">
          <!-- <xsl:message><xsl:text>[4]</xsl:text></xsl:message> -->
          <xsl:text>&quot;</xsl:text>
          <xsl:call-template name="escape-quotes-recurse">
              <xsl:with-param name="inputString" select="substring($inputString,2,string-length($inputString) - 2)"/>
              <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
          <xsl:text>&quot;</xsl:text>
        </xsl:when>
        <!-- strings: skip past escaped quote character \" (a literal value, not a delimiter) then recurse to process remainder -->
        <xsl:when test="contains($inputString,'\&quot;') and (string-length(substring-before($inputString,'&quot;')) > string-length(substring-before($inputString,'\&quot;')))">
          <!-- <xsl:message><xsl:text>[5]</xsl:text></xsl:message> -->
          <xsl:value-of select="substring-before($inputString,'\&quot;')"/>
          <xsl:text>\&quot;</xsl:text>
          <xsl:call-template name="escape-quotes-recurse">
              <xsl:with-param name="inputString" select="substring-after($inputString,'\&quot;')"/>
              <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
        </xsl:when>
        <!-- MFString value next contains quotes delimiter between SFString array elements, but check no preceding unescaped quote -->
        <xsl:when test="($inputType = 'MFString') and contains($inputString,'&quot; &quot;') and (string-length(substring-before($inputString,'&quot;')) >= string-length(substring-before($inputString,'&quot; &quot;')))">
          <!-- <xsl:message><xsl:text>[6]</xsl:text></xsl:message> -->
          <xsl:value-of select="substring-before($inputString,'&quot; &quot;')"/>
          <xsl:text>&quot; &quot;</xsl:text>          
          <xsl:call-template name="escape-quotes-recurse">
              <xsl:with-param name="inputString" select="substring-after($inputString,'&quot; &quot;')"/>
              <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
        </xsl:when>
        <!-- unescaped quote needs \ escape character inserted, occurs before quotes delimiter -->
        <xsl:when test="($inputType = 'MFString') and contains($inputString,'&quot; &quot;') and (string-length(substring-before($inputString,'&quot; &quot;')) > string-length(substring-before($inputString,'&quot;')))">
          <!-- <xsl:message><xsl:text>[7]</xsl:text></xsl:message> -->
          <xsl:value-of select="substring-before($inputString,'&quot;')"/>
          <xsl:text>\&quot;</xsl:text>
          <xsl:call-template name="escape-quotes-recurse">
              <xsl:with-param name="inputString" select="substring-after($inputString,'&quot;')"/>
              <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
        </xsl:when>
        <!-- unescaped quote needs \ escape character inserted, no quote delimiter remaining -->
        <xsl:when test="contains($inputString,'&quot;')">
          <!-- <xsl:message><xsl:text>[8]</xsl:text></xsl:message> -->
          <xsl:value-of select="substring-before($inputString,'&quot;')"/>
          <xsl:text>\&quot;</xsl:text>
          <xsl:call-template name="escape-quotes-recurse">
              <xsl:with-param name="inputString" select="substring-after($inputString,'&quot;')"/>
              <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
        </xsl:when>
        <!-- remaining case: all done -->
        <xsl:otherwise>
          <!-- <xsl:message><xsl:text>[9]</xsl:text></xsl:message> -->
          <xsl:value-of select="$inputString"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <xsl:template name="omit-leading-trailing-whitespace">
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- not normalized white space  -->
      <!-- debug <xsl:message><xsl:text>omit-leading-trailing-whitespace</xsl:text></xsl:message> -->
      <xsl:choose>
        <!-- space &nbsp; \t \n \r respectively -->
        <xsl:when test="starts-with($inputString,' ')     or starts-with($inputString,'&#160;') or
                        starts-with($inputString,'&#09;') or starts-with($inputString,'&#x0A;') or
                        starts-with($inputString,'&#x0D;')">
          <xsl:call-template name="omit-leading-trailing-whitespace">
              <xsl:with-param name="inputString" select="substring($inputString,2)"/>
          </xsl:call-template>
        </xsl:when>
        <!-- space &nbsp; \t \n \r respectively -->
        <xsl:when test="  ends-with($inputString,' ')     or   ends-with($inputString,'&#160;') or
                          ends-with($inputString,'&#09;') or   ends-with($inputString,'&#x0A;') or
                          ends-with($inputString,'&#x0D;')">
          <xsl:call-template name="omit-leading-trailing-whitespace">
              <xsl:with-param name="inputString" select="substring($inputString,1,(string-length($inputString)-1))"/>
          </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
            <!-- done -->
          <xsl:value-of select="$inputString"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <xsl:template name="escape-less-than-characters-recurse">
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- already normalized white space -->
      <xsl:choose>
        <xsl:when test="not(contains($inputString,'&lt;'))">
          <xsl:value-of select="$inputString"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="substring-before($inputString,'&lt;')"/>
          <xsl:text>&lt;</xsl:text>
          <xsl:call-template name="escape-less-than-characters-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,'&lt;')"/>
          </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <xsl:template name="replace-newlines-recurse">
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- not normalized white space -->
      <xsl:choose>
        <xsl:when test="not(contains($inputString,'&#x0A;'))">
          <xsl:value-of select="$inputString"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="substring-before($inputString,'&#x0A;')"/>
          <xsl:text>\n</xsl:text>
          <xsl:call-template name="replace-newlines-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,'&#x0A;')"/>
          </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <xsl:template name="replace-tabs-recurse">
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- not normalized white space -->
      <xsl:choose>
        <xsl:when test="not(contains($inputString,'&#x09;'))">
          <xsl:value-of select="$inputString"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="substring-before($inputString,'&#x09;')"/>
          <xsl:text>\t</xsl:text>
          <xsl:call-template name="replace-tabs-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,'&#x09;')"/>
          </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <xsl:template name="escape-greater-than-characters-recurse">
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- already normalized white space -->
      <xsl:choose>
        <xsl:when test="not(contains($inputString,'&gt;'))">
          <xsl:value-of select="$inputString"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="substring-before($inputString,'&gt;')"/>
          <xsl:text>&gt;</xsl:text>
          <xsl:call-template name="escape-less-than-characters-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,'&gt;')"/>
          </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <xsl:template name="insert-commas-recurse">
      <!-- insert commas before space characters between array values -->
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- already normalized white space -->
      <xsl:param name="inputType"><xsl:text>false</xsl:text></xsl:param>
      <xsl:choose>
        <!-- no space, all done -->
        <xsl:when test="not(contains($inputString,' '))">
          <xsl:value-of select="$inputString"/>
        </xsl:when>
        <!-- strings: skip past escaped quote character \" (a literal value, not a delimiter) then recurse to process first unescaped quote character " -->
        <xsl:when test="contains($inputString,'\&quot;') and (string-length(substring-before($inputString,'&quot;')) > string-length(substring-before($inputString,'\&quot;')))">
          <xsl:value-of select="substring-before($inputString,'\&quot;')"/>
          <xsl:text>\&quot;</xsl:text>
          <xsl:call-template name="insert-commas-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,'\&quot;')"/>
            <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
        </xsl:when>
        <!-- insert commas after next contained SFString within an MFString array -->
        <xsl:when test="contains($inputString,'&quot; &quot;')">
          <xsl:value-of select="substring-before($inputString,'&quot; &quot;')"/>
          <xsl:text>&quot;,&quot;</xsl:text>
          <xsl:call-template name="insert-commas-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,'&quot; &quot;')"/>
            <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
        </xsl:when>
        <!-- do not insert commas within string types -->
        <xsl:when test="($inputType = 'true')">
          <!-- all done -->
          <xsl:value-of select="$inputString"/>
        </xsl:when>
        <!-- other values: has spaces, type is non SFString/MFString array; replace space characters with commas directly -->
        <xsl:otherwise>
            <xsl:value-of select="translate($inputString,' ',',')"/>
          <!--
          <xsl:value-of select="substring-before($inputString,' ')"/>
          <xsl:text>,</xsl:text>
          <xsl:call-template name="insert-commas-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,' ')"/>
            <xsl:with-param name="inputType"   select="$inputType"/>
          </xsl:call-template>
          -->
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <xsl:template name="split-text-block-into-string-array">
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- not normalized white space -->
      <xsl:choose>
        <!-- no line feed, all done -->
        <xsl:when test="not(contains($inputString,'&#x0A;'))">
          <xsl:text>&#10;</xsl:text>
          <xsl:text>"</xsl:text>
          <xsl:value-of select="$inputString"/>
          <xsl:text>"</xsl:text>
        </xsl:when>
        <xsl:otherwise>
          <xsl:text>&#10;</xsl:text>
          <xsl:text>"</xsl:text>
          <xsl:value-of select="substring-before($inputString,'&#x0A;')"/>
          <xsl:text>",</xsl:text>
          <xsl:call-template name="split-text-block-into-string-array">
            <xsl:with-param name="inputString" select="substring-after($inputString,'&#x0A;')"/>
          </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <xsl:template name="insert-leading-trailing-zeroes-recurse">
        <!-- insert leading zeroes before float values starting with decimal point; omit leading + signs -->
      <xsl:param name="inputString"><xsl:text></xsl:text></xsl:param> <!-- already normalized white space -->
      <xsl:choose>
        <!-- starts with decimal point, insert 0, more to follow -->
        <xsl:when test="starts-with($inputString,'.') and contains($inputString,' ')">
          <xsl:text>0</xsl:text>
          <xsl:value-of select="substring-before($inputString,' ')"/>
          <xsl:text> </xsl:text>
          <xsl:call-template name="insert-leading-trailing-zeroes-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,' ')"/>
          </xsl:call-template>
        </xsl:when>
        <!-- starts with decimal point, insert 0, all done -->
        <xsl:when test="starts-with($inputString,'.')">
          <xsl:text>0</xsl:text>
          <xsl:value-of select="$inputString"/>
        </xsl:when>
        <!-- starts with decimal point, insert 0, more to follow -->
        <xsl:when test="starts-with($inputString,'+')">
          <xsl:call-template name="insert-leading-trailing-zeroes-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,'+')"/>
          </xsl:call-template>
        </xsl:when>
        <!-- starts with minus sign and decimal point, insert 0, more to follow -->
        <xsl:when test="starts-with($inputString,'-.') and contains($inputString,' ')">
          <xsl:text>-0</xsl:text>
          <xsl:value-of select="substring-before(substring($inputString,2),' ')"/>
          <xsl:text> </xsl:text>
          <xsl:call-template name="insert-leading-trailing-zeroes-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,' ')"/>
          </xsl:call-template>
        </xsl:when>
        <!-- starts with minus sign and decimal point, insert 0, all done -->
        <xsl:when test="starts-with($inputString,'-.')">
          <xsl:text>-0</xsl:text>
          <xsl:value-of select="substring($inputString,2)"/>
        </xsl:when>
        <!-- doesn't start with decimal point, more to follow -->
        <xsl:when test="contains($inputString,' ')">
          <xsl:value-of select="substring-before($inputString,' ')"/>
          <xsl:if test="ends-with(substring-before($inputString,' '),'.')">
              <!-- append 0 after trailing decimal point -->
              <xsl:text>0</xsl:text>
          </xsl:if>
          <xsl:text> </xsl:text>
          <xsl:call-template name="insert-leading-trailing-zeroes-recurse">
            <xsl:with-param name="inputString" select="substring-after($inputString,' ')"/>
          </xsl:call-template>
        </xsl:when>
        <!-- doesn't start with decimal point, all done -->
        <xsl:otherwise>
          <xsl:value-of select="$inputString"/>
          <xsl:if test="ends-with($inputString,'.')">
              <!-- append 0 after trailing decimal point -->
              <xsl:text>0</xsl:text>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <!-- trace messsages on console -->
    <xsl:template name="trace">
      <xsl:param name="message"><xsl:text></xsl:text></xsl:param>
      <xsl:param name="element"><xsl:text></xsl:text></xsl:param>
      <xsl:param name="name"><xsl:text></xsl:text></xsl:param>
      <xsl:param name="DEF"><xsl:text></xsl:text></xsl:param>
      <xsl:param name="USE"><xsl:text></xsl:text></xsl:param>
      <xsl:param name="indent"><xsl:text>0</xsl:text></xsl:param>
      <xsl:param name="traceEnabled" select="$traceEnabled"/>
      
      <xsl:if test="($traceEnabled = 'true')">
        <xsl:variable name="fullMessage">
            <xsl:call-template name="print-indent">
                <xsl:with-param name="indent" select="$indent - 1"/>
            </xsl:call-template>
            <xsl:if test="(string-length($element) > 0)">
                <xsl:text> </xsl:text>
                <xsl:value-of select="$element"/>
            </xsl:if>
            <xsl:if test="(string-length($name) > 0)">
                <xsl:text> </xsl:text>
                <xsl:value-of select="$name"/>
            </xsl:if>
            <xsl:if test="(string-length($DEF) > 0)">
                <xsl:text> </xsl:text>
                <xsl:value-of select="$DEF"/>
            </xsl:if>
            <xsl:if test="(string-length($USE) > 0)">
                <xsl:text> </xsl:text>
                <xsl:text>USE </xsl:text>
                <xsl:value-of select="$USE"/>
            </xsl:if>
            <xsl:value-of select="$message"/>
        </xsl:variable>
        <xsl:if test="(string-length(normalize-space($fullMessage)) > 0)">
            <xsl:message><xsl:value-of select="$fullMessage"/></xsl:message>
        </xsl:if>
      </xsl:if>
    </xsl:template>

    <xsl:template name="not-default-attribute-value"> <!-- rule to filter out default attribute values -->
                
        <!-- this block of tests is used identically in X3dToXhtml.xslt X3dToHtml.xslt X3dToVrml97.xslt X3dTidy.xslt X3dToX3dom.xslt X3dUnwrap.xslt X3dWrap.xslt and X3dToJson.xslt -->
        <!-- check values with/without .0 suffix since these are string checks and autogenerated/DOM output might have either -->
        <!-- do not check ProtoInstances or natively defined nodes, since they might have different user-defined defaults -->
        <!-- tool-bug workaround:  split big boolean queries into pieces to avoid overloading the Xalan/lotusxml query buffer -->
        <xsl:variable name="notImplicitEvent1"
                      select="not(local-name(..)='AudioClip'	and	(local-name()='duration_changed' or local-name()='elapsedTime' or local-name()='isPaused' or local-name()='isActive')) and
                      not(contains(local-name(..),'Interpolator') and (local-name()='set_fraction' or local-name()='value_changed')) and
                      not(contains(local-name(..),'Sequencer')    and (local-name()='set_fraction' or local-name()='value_changed' or local-name()='previous' or local-name()='next')) and
                      not(local-name(..)='Background'	and	(local-name()='set_bind' or local-name()='bindTime' or local-name()='isBound')) and
                      not(local-name(..)='Collision' and (local-name()='isActive' or local-name()='collideTime')) and
                      not(local-name(..)='CylinderSensor' and	(local-name()='isActive' or local-name()='isOver' or local-name()='rotation' or local-name()='trackPoint_changed')) and
                      not(local-name(..)='ElevationGrid'	and	local-name()='set_height') and
                      not((local-name(..)='Extrusion') and starts-with(local-name(),'set_')) and
                      not(((local-name(..)='IndexedFaceSet') or contains(local-name(..),'TriangleFanSet') or contains(local-name(..),'TriangleSet') or contains(local-name(..),'TriangleStripSet') or contains(local-name(..),'QuadSet')) and starts-with(local-name(),'set_') and contains(local-name(),'ndex')) and
                      not(local-name(..)='IndexedLineSet' and	 local-name()='lineWidth') and
                      not(local-name(..)='MovieTexture' and	(local-name()='duration_changed' or local-name()='elapsedTime' or local-name()='isPaused' or local-name()='isActive')) and
                      not(local-name(..)='NavigationInfo' and	(local-name()='set_bind' or local-name()='bindTime' or local-name()='isBound'))
                      " />
        <xsl:variable name="notImplicitEvent2"
                      select="not(local-name(..)='PointSet'	and	 local-name()='pointSize') and
                      not(local-name(..)='PlaneSensor' and	(local-name()='isActive' or local-name()='isOver' or local-name()='translation_changed' or local-name()='trackPoint_changed')) and
                      not(local-name(..)='ProximitySensor' and (local-name()='isActive' or local-name()='position' or local-name()='orientation' or
                      local-name()='enterTime' or local-name()='exitTime')) and
                      not(local-name(..)='SphereSensor' and	(local-name()='isActive' or local-name()='rotation' or local-name()='trackPoint_changed')) and
                      not(local-name(..)='TimeSensor'	and	(local-name()='isActive' or local-name()='elapsedTime' or local-name()='isPaused' or local-name()='cycleTime' or local-name()='set_fraction' or
                      local-name()='time')) and
                      not(local-name(..)='TouchSensor' and	(local-name()='isActive' or local-name()='isOver' or local-name()='hitNormal_changed' or
                      local-name()='touchTime' or local-name()='hitPoint_changed' or local-name()='hitTexCoord_changed')) and
                      not(local-name(..)='Viewpoint'	  and	(local-name()='set_bind' or local-name()='bindTime' or local-name()='isBound' or local-name()='examine')) and
                      not(local-name(..)='GeoViewpoint' and	(local-name()='set_bind' or local-name()='bindTime' or local-name()='isBound' or local-name()='examine'))
                      " />
        <xsl:variable name="notImplicitEvent3"
                      select="not(local-name(..)='BooleanTrigger'	and	(local-name()='set_triggerTime' or local-name()='triggerTrue')) and
                      not(local-name(..)='IntegerTrigger'	and	(local-name()='set_boolean' or local-name()='triggerValue'))
                      " />
        <xsl:variable name="notDefaultFieldValue1"
                      select="not( local-name()='bboxCenter'	and	(.='0 0 0' or .='0.0 0.0 0.0')) and
                      not( local-name()='bboxSize'	and	(.='-1 -1 -1' or .='-1.0 -1.0 -1.0')) and
                      not( local-name(..)='AudioClip'	and
                      ((local-name()='loop' and .='false') or
                      (local-name()='pitch' and (.='1' or .='1.0')) or
                      (local-name()='startTime' and (.='0' or .='0.0')) or
                      (local-name()='stopTime' and (.='0' or .='0.0')) or
                      (local-name()='pauseTime' and (.='0' or .='0.0')) or
                      (local-name()='resumeTime'  and (.='0' or .='0.0')))) and
                      not(((local-name(..)='Background') or (local-name(..)='TextureBackground')) and ((local-name()='skyColor' and (.='0 0 0' or .='0.0 0.0 0.0')) or (local-name()='transparency' and (.='0' or .='0.0')))) and
                      not( local-name(..)='Billboard'	and local-name()='axisOfRotation' and (.='0 1 0' or .='0.0 1.0 0.0')) and
                      not( local-name(..)='BooleanToggle' and local-name()='toggle' and .='false') and
                      not( local-name(..)='Box'	and ((local-name()='size' and (.='2 2 2' or .='2.0 2.0 2.0')) or (local-name()='solid' and .='true'))) and
                      not( local-name(..)='Collision'	and local-name()='enabled' and .='true') and
                      not( local-name(..)='Cone' and	((local-name()='bottomRadius' and (.='1' or .='1.0')) or
                      (local-name()='height' and (.='2' or .='2.0')) or
                      (local-name()='side' and .='true') or
                      (local-name()='solid' and .='true') or
        (local-name()='bottom' and .='true')))"/>
        <xsl:variable name="notDefaultFieldValue1a"
                      select="not( local-name(..)='Cylinder' and
                      ((local-name()='height' and (.='2' or .='2.0')) or
                      (local-name()='radius' and (.='1' or .='1.0')) or
                      (local-name()='bottom' and .='true') or
                      (local-name()='side' and .='true') or
                      (local-name()='solid' and .='true') or
                      (local-name()='top' and .='true'))) and
                      not( local-name(..)='CylinderSensor' and
                      ((local-name()='autoOffset' and .='true') or
                      (local-name()='enabled' and .='true') or
                      (local-name()='diskAngle' and .='0.26179167') or
                      (local-name()='offset' and (.='0' or .='0.0')) or
                      (local-name()='maxAngle' and (.='-1' or .='-1.0')) or
                      (local-name()='minAngle' and (.='0' or .='0.0'))))" />
        <xsl:variable name="notDefaultFieldValue2"
                      select="not( local-name(..)='DirectionalLight' and
                      ((local-name()='ambientIntensity' and (.='0' or .='0.0')) or
                      (local-name()='color' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                      (local-name()='direction' and (.='0 0 -1' or .='0.0 0.0 -1.0')) or
                      (local-name()='global' and .='false') or
                      (local-name()='intensity' and (.='1' or .='1.0')) or
                      (local-name()='on' and .='true'))) and
                      not((local-name(..)='ElevationGrid' or local-name(..)='GeoElevationGrid') and
                      ((local-name()='ccw' and .='true') or
                      (local-name()='colorPerVertex' and .='true') or
                      (local-name()='normalPerVertex' and .='true') or
                      (local-name()='solid' and .='true') or
                      (local-name()='xDimension' and (.='0' or .='0.0')) or
                      (local-name()='xSpacing' and (.='1' or .='1.0')) or
                      (local-name()='zDimension' and (.='0' or .='0.0')) or
                      (local-name()='zSpacing' and (.='1' or .='1.0')) or
                      (local-name()='creaseAngle' and (.='0' or .='0.0')))) and
                      not( local-name(..)='Extrusion'	and
                      ((local-name()='beginCap' and .='true') or
                      (local-name()='ccw' and .='true') or
                      (local-name()='convex' and .='true') or
                      (local-name()='endCap' and .='true') or
                      (local-name()='solid' and .='true') or
                      (local-name()='creaseAngle' and (.='0' or .='0.0')) or
                      (local-name()='orientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                      (local-name()='scale' and (.='1 1' or .='1.0 1.0')) or
                      (local-name()='crossSection' and .='1 1, 1 -1, -1 -1, -1 1, 1 1') or
                      (local-name()='crossSection' and .='1 1 1 -1 -1 -1 -1 1 1 1') or
                      (local-name()='spine' and .='0 0 0, 0 1 0') or
                      (local-name()='spine' and .='0 0 0 0 1 0')))" />
        <xsl:variable name="notDefaultFieldValue3"
                      select="not( local-name(..)='Fog' and 	((local-name()='color' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                      (local-name()='visibilityRange' and (.='0' or .='0.0')) or
                      (local-name()='fogType' and .='LINEAR'))) and
                      not( local-name(..)='FontStyle'	and
                      ((local-name()='horizontal' and .='true') or
                      (local-name()='leftToRight' and .='true') or
                      (local-name()='topToBottom' and .='true') or
                      (local-name()='size' and (.='1' or .='1.0')) or
                      (local-name()='spacing' and (.='1' or .='1.0')) or
                      (local-name()='family' and .='&quot;SERIF&quot;') or
                      (local-name()='justify' and .='&quot;BEGIN&quot;') or
                      (local-name()='style' and .='PLAIN'))) and
                      not( local-name(..)='ImageTexture' and
                      ((local-name()='repeatS' and .='true') or
                      (local-name()='repeatT' and .='true'))) and
                      not(((local-name(..)='IndexedFaceSet') or contains(local-name(..),'TriangleFanSet') or contains(local-name(..),'TriangleSet') or contains(local-name(..),'TriangleStripSet') or contains(local-name(..),'QuadSet')) and
                      ((local-name()='ccw' and .='true') or
                      (local-name()='colorPerVertex' and .='true') or
                      (local-name()='convex' and .='true') or
                      (local-name()='normalPerVertex' and .='true') or
                      (local-name()='solid' and .='true') or
                      (local-name()='creaseAngle' and (.='0' or .='0.0')))) and
                      not( local-name(..)='IndexedLineSet' and local-name()='colorPerVertex' and .='true') and
                      not( local-name(..)='Inline' and local-name()='load' and .='true') and
                      not( local-name(..)='LoadSensor' and
                      ((local-name()='enabled' and .='true') or
                      (local-name()='timeOut' and (.='0' or .='0.0')))) and
                      not( local-name(..)='LOD'	and	((local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or (local-name()='forceTransitions' and .='false'))) and
                      not(((local-name(..)='Material') or (local-name(..)='TwoSidedMaterial'))	and
                      ((local-name()='ambientIntensity' and .='0.2') or
                      (local-name()='diffuseColor' and .='0.8 0.8 0.8') or
                      (local-name()='emissiveColor' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='shininess' and .='0.2') or
                      (local-name()='specularColor' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='transparency' and (.='0' or .='0.0')))) and
                      not( local-name(..)='TwoSidedMaterial'	and
                      ((local-name()='backAmbientIntensity' and .='0.2') or
                      (local-name()='backDiffuseColor' and .='0.8 0.8 0.8') or
                      (local-name()='backEmissiveColor' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='backShininess' and .='0.2') or
                      (local-name()='backSpecularColor' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='backTransparency' and (.='0' or .='0.0'))))" />
        <xsl:variable name="notDefaultFieldValue4"
                      select="not( local-name(..)='MovieTexture' and
                      ((local-name()='loop' and .='false') or
                      (local-name()='speed' and (.='1' or .='1.0')) or
                      (local-name()='startTime' and (.='0' or .='0.0')) or
                      (local-name()='stopTime' and (.='0' or .='0.0')) or
                      (local-name()='pauseTime' and (.='0' or .='0.0')) or
                      (local-name()='resumeTime'  and (.='0' or .='0.0')) or
                      (local-name()='repeatS' and .='true') or
                      (local-name()='repeatT' and .='true'))) and
                      not( local-name(..)='NavigationInfo' and
                      ((local-name()='avatarSize' and .='0.25 1.6 0.75') or
                      (local-name()='headlight' and .='true') or
                      (local-name()='speed' and (.='1' or .='1.0')) or
                      (local-name()='transitionTime' and (.='1' or .='1.0')) or
                      (local-name()='transitionType' and (.='&quot;LINEAR&quot;')) or
					  (local-name()='type' and (.='&quot;EXAMINE&quot; &quot;ANY&quot;')) or
                      (local-name()='visibilityLimit' and (.='0' or .='0.0')))) and
                      not( local-name(..)='PixelTexture' and
                      ((local-name()='repeatS' and .='true') or
                      (local-name()='repeatT' and .='true') or
                      (local-name()='image' and (.='0 0 0' or .='0.0 0.0 0.0')))) and
                      not( local-name(..)='PlaneSensor' and
                      ((local-name()='autoOffset' and .='true') or
                      (local-name()='enabled' and .='true') or
                      (local-name()='maxPosition' and (.='-1 -1' or .='-1.0 -1.0')) or
                      (local-name()='minPosition' and (.='0 0' or .='0.0 0.0')) or
                      (local-name()='offset' and (.='0 0 0' or .='0.0 0.0 0.0')))) and
                      not( local-name(..)='PointLight' and
                      ((local-name()='ambientIntensity' and (.='0' or .='0.0'))or
                      (local-name()='attenuation' and (.='1 0 0' or .='1.0 0.0 0.0')) or
                      (local-name()='color' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                      (local-name()='global' and .='true') or
                      (local-name()='intensity' and (.='1' or .='1.0')) or
                      (local-name()='location' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='on' and .='true') or
                      (local-name()='radius' and (.='100' or .='100.0'))))" />
        <xsl:variable name="notDefaultFieldValue5"
                      select="not( local-name(..)='ProximitySensor' and
                      ((local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='size' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='enabled' and .='true'))) and
                      not( local-name(..)='Script' and ((local-name()='directOutput' and .='false') or
                      (local-name()='mustEvaluate' and .='false'))) and
                      not( local-name(..)='Sound' and ((local-name()='direction' and (.='0 0 1' or .='0.0 0.0 1.0')) or
                      (local-name()='intensity' and (.='1' or .='1.0')) or
                      (local-name()='location' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='priority' and (.='0' or .='0.0')) or
                      (local-name()='maxBack' and (.='10' or .='10.0')) or
                      (local-name()='maxFront' and (.='10' or .='10.0')) or
                      (local-name()='minBack' and (.='1' or .='1.0'))  or
                      (local-name()='minFront' and (.='1' or .='1.0')) or
                      (local-name()='spatialize' and .='true'))) and
                      not( local-name(..)='Sphere' and ((local-name()='radius' and (.='1' or .='1.0')) or (local-name()='solid' and .='true'))) and
                      not( local-name(..)='SphereSensor' and
                      ((local-name()='autoOffset' and .='true') or
                      (local-name()='enabled' and .='true') or
                      (local-name()='offset' and (.='0 1 0 0' or .='0.0 1.0 0.0 0.0')) and
                      not( local-name(..)='Switch' and ../IS/connect[@nodeField='whichChoice'])))" />
        <!-- Switch whichChoice='-1' is very significant and somewhat counterintuitive/nonobvious, so otherwise show it. -->
        <!--	  and not( local-name(..)='Switch' and  local-name()='whichChoice' and (.='-1' or .='-1.0')) -->
        <xsl:variable name="notDefaultFieldValue6"
                      select="not( local-name(..)='SpotLight'	and
                      ((local-name()='ambientIntensity' and (.='0' or .='0.0')) or
                      (local-name()='attenuation' and (.='1 0 0' or .='1.0 0.0 0.0')) or
                      (local-name()='beamWidth' and ((.='0.785398') or (.='0.7854') or (.='.785398') or (.='.7854'))) or
                      (local-name()='color' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                      (local-name()='cutOffAngle' and (.='1.5708' or .='1.570796')) or
                      (local-name()='direction' and (.='0 0 -1' or .='0.0 0.0 -1.0')) or
                      (local-name()='global' and .='true') or
                      (local-name()='intensity' and (.='1' or .='1.0')) or
                      (local-name()='location' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='on' and .='true') or
                      (local-name()='radius' and (.='100' or .='100.0')))) and
                      not( local-name(..)='Text'   and ((local-name()='maxExtent' and (.='0' or .='0.0')) or (local-name()='solid' and (.='false')))) and
                      not( local-name(..)='TextureTransform' and
                      ((local-name()='center' and (.='0 0' or .='0.0 0.0')) or
                      (local-name()='rotation' and (.='0' or .='0.0')) or
                      (local-name()='scale' and (.='1 1' or .='1.0 1.0')) or
                      (local-name()='translation' and (.='0 0' or .='0.0 0.0'))))" />
        <xsl:variable name="notDefaultFieldValue7"
                      select="not( local-name(..)='TimeSensor' and
                      ((local-name()='cycleInterval' and (.='1' or .='1.0')) or
                      (local-name()='enabled' and .='true') or
                      (local-name()='startTime' and (.='0' or .='0.0')) or
                      (local-name()='stopTime' and (.='0' or .='0.0')) or
                      (local-name()='pauseTime' and (.='0' or .='0.0')) or
                      (local-name()='resumeTime'  and (.='0' or .='0.0')) or
                      (local-name()='loop' and .='false'))) and
                      not( local-name(..)='TouchSensor' and
                      local-name()='enabled' and .='true') and
                      not( ((local-name(..)='Transform') or (local-name(..)='EspduTransform') or (local-name(..)='GeoTransform')) and
                      ((local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or
					  (local-name()='rotation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                      (local-name()='scale' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                      (local-name()='scaleOrientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                      (local-name()='translation' and (.='0 0 0' or .='0.0 0.0 0.0')))) and
                      not( local-name(..)='Viewpoint' and
                      ((local-name()='centerOfRotation' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='fieldOfView' and ((.='0.785398') or (.='0.7854') or (.='.785398') or (.='.7854'))) or
                      (local-name()='jump' and .='true') or
                      (local-name()='orientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                      (local-name()='retainUserOffsets' and (.='false')) or
                      (local-name()='position' and (.='0 0 10' or .='0.0 0.0 10.0')))) and
                      not( local-name(..)='VisibilitySensor' and
                      ((local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='enabled' and .='true') or
                      (local-name()='size' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='enterTime' and (.='0' or .='0.0')) or
                      (local-name()='exitTime'  and (.='0' or .='0.0')) or
                      (local-name()='isActive' and .='false')))" />
        <xsl:variable name="notDefaultFieldValue8"
                      select="not( local-name(..)='FillProperties' and
                      (((local-name()='filled' and .='true') or
                      (local-name()='hatched' and .='true') or
                      local-name()='hatchStyle' and (.='1' or .='1.0')) or
                      (local-name()='hatchColor' and (.='1 1 1' or .='1.0 1.0 1.0')))) and
                      not( local-name(..)='LineProperties' and
                      ((local-name()='applied' and .='true') or
                      (local-name()='linetype' and (.='1')) or
                      (local-name()='linewidthScaleFactor' and (.='0' or .='0.0')))) and
                      not( local-name(..)='ClipPlane' and
                      ((local-name()='enabled' and .='true') or
                      (local-name()='plane' and (.='0 1 0 0' or .='0.0 1.0 0.0 0.0')))) and
                      not( local-name(..)='ViewpointGroup' and
                      ((local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='displayed' and .='true') or
                      (local-name()='retainUserOffsets' and .='false') or
                      (local-name()='size' and (.='0 0 0' or .='0.0 0.0 0.0'))))" />
        <xsl:variable name="notDefaultFieldValue9"
                      select="not( local-name(..)='MultiTexture' and
                      ((local-name()='alpha' and (.='1' or .='1.0')) or
                      (local-name()='color' and (.='1 1 1' or .='1.0 1.0 1.0')))) and
                      not( local-name(..)='TextureCoordinateGenerator' and
                      ((local-name()='mode' and .='SPHERE'))) and
                      not((local-name(..)='ComposedTexture3D' or local-name(..)='ImageTexture3D' or local-name(..)='PixelTexture3D') and
                      ((local-name()='repeatS' or local-name()='repeatT' or local-name()='repeatR') and .='false')) and
                      not( local-name(..)='PixelTexture3D' and
                      (local-name()='image' and (.='0 0 0 0')))" />
        <xsl:variable name="notDefaultContainerField1"
                      select="not((local-name()='containerField' and .='children')	and
                      (contains(local-name(..),'Interpolator') or
                      contains(local-name(..),'Light') or
                      contains(local-name(..),'Sensor') or
                      local-name(..)='Anchor' or
                      local-name(..)='Background' or
                      local-name(..)='Billboard' or
                      local-name(..)='Collision' or
                      local-name(..)='Fog' or
                      local-name(..)='Group' or
                      local-name(..)='Inline' or
                      local-name(..)='LOD' or
                      local-name(..)='NavigationInfo' or
                      local-name(..)='Script' or
                      local-name(..)='Shape' or
                      local-name(..)='Sound' or
                      local-name(..)='Switch' or
                      local-name(..)='TextureBackground' or
                      local-name(..)='Transform' or
                      local-name(..)='Viewpoint' or
                      local-name(..)='WorldInfo' or
                      local-name(..)='ProtoInstance')) and
                      not((local-name()='containerField' and .='geometry')	and
                      (local-name(..)='Box' or
                      local-name(..)='Cone' or
                      local-name(..)='Cylinder' or
                      local-name(..)='ElevationGrid' or
                      local-name(..)='GeoElevationGrid' or
                      local-name(..)='Extrusion' or
                      local-name(..)='IndexedFaceSet' or
                      local-name(..)='IndexedLineSet' or
                      local-name(..)='PointSet' or
                      local-name(..)='Sphere' or
                      local-name(..)='Text' or
                      local-name(..)='XvlShell'))" />
        <xsl:variable name="notDefaultContainerField2"
                      select="not((local-name()='containerField' and .='source')	and (local-name(..)='AudioClip')) and
                      not((local-name()='containerField' and .='appearance')	and (local-name(..)='Appearance')) and
                      not((local-name()='containerField' and .='material')	and ((local-name(..)='Material') or (local-name(..)='TwoSidedMaterial'))) and
                      not((local-name()='containerField' and .='color')	and (local-name(..)='Color' or local-name(..)='ColorRGBA')) and
                      not((local-name()='containerField' and .='coord')	and ((local-name(..)='Coordinate') or (local-name(..)='CoordinateDouble') or (local-name(..)='GeoCoordinate'))) and
                      not((local-name()='containerField' and .='normal')	and (local-name(..)='Normal')) and
                      not((local-name()='containerField' and .='texture')	and (local-name(..)='ImageTexture' or local-name(..)='PixelTexture' or local-name(..)='MovieTexture' or local-name(..)='MultiTexture' or local-name(..)='ComposedTexture3D' or local-name(..)='ImageTexture3D' or local-name(..)='PixelTexture3D')) and
                      not((local-name()='containerField' and .='fontStyle')	and (local-name(..)='FontStyle')) and
                      not((local-name()='containerField' and .='texCoord')	and (local-name(..)='TextureCoordinate' or local-name(..)='TextureCoordinateGenerator')) and
                      not((local-name()='containerField' and .='textureTransform')	and (local-name(..)='TextureTransform'))" />
        <xsl:variable name="notDefaultContainerField3"
                      select="not((local-name()='containerField' and .='geometry')	and
                      ((local-name(..)='Arc2D') or (local-name(..)='ArcClose2D') or (local-name(..)='Circle2D') or (local-name(..)='Disk2D') or (local-name(..)='Polyline2D') or (local-name(..)='Polypoint2D') or (local-name(..)='Rectangle2D') or (local-name(..)='TriangleSet2D') or contains(local-name(..),'QuadSet'))) and
                      not((local-name()='containerField' and .='voxels')	and
                      ((local-name(..)='IsoSurfaceVolumeData') or (local-name(..)='SegmentedVolumeData') or (local-name(..)='VolumeData'))) and
                      not((local-name()='containerField' and .='renderStyle')	and
                      ((local-name(..)='BlendedVolumeStyle') or (local-name(..)='BoundaryEnhancementVolumeStyle') or (local-name(..)='CartoonVolumeStyle') or (local-name(..)='ComposedVolumeStyle') or (local-name(..)='EdgeEnhancementVolumeStyle') or (local-name(..)='OpacityMapVolumeStyle') or (local-name(..)='ProjectionVolumeStyle') or (local-name(..)='ShadedVolumeStyle') or (local-name(..)='SilhouetteEnhancementVolumeStyle') or (local-name(..)='ToneMappedVolumeStyle')))" />
        <xsl:variable name="notDefaultCAD"
                      select="not((local-name(..)='CADAssembly' or local-name(..)='CADFace' or local-name(..)='CADLayer') and
                      ((local-name()='containerField' and (.='children')) or
                       (local-name()='bboxCenter' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='bboxSize' and (.='-1 -1 -1' or .='-1.0 -1.0 -1.0')))) and
                      not(local-name(..)='CADPart' and
                      ((local-name()='containerField' and (.='children')) or
                       (local-name()='bboxCenter' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='bboxSize' and (.='-1 -1 -1' or .='-1.0 -1.0 -1.0')) or
                       (local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or
					   (local-name()='rotation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0 1 0 0.0'  or .='0 0 1 0.0' or .='0.0 1.0 0.0 0.0')) or
                       (local-name()='scale' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                       (local-name()='scaleOrientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='translation' and (.='0 0 0' or .='0.0 0.0 0.0'))))" />
        <xsl:variable name="notDefaultDIS1"
                      select="not((local-name(..)='EspduTransform' or contains(local-name(..),'Pdu')) and
                      ((starts-with(local-name(),'is')) or
                      (local-name()='address' and (.='localhost')) or
                      (local-name()='enabled' and (.='true')) or
                      (local-name()='networkMode' and (.='standAlone')) or
                      (local-name()='rtpHeaderExpected' and (.='false')) or
                      (local-name()='readInterval'  and (.='.1' or .='0.1')) or
                      (local-name()='writeInterval'  and (.='1' or .='1.0')) or
                      (((local-name()='applicationID') or (local-name()='munitionApplicationID') or (local-name()='whichGeometry')) and (.='1')) or
                      ((contains(local-name(),'ntityID') or contains(local-name(),'iteID') or (local-name()='applicationID')) and (.='0')) or
                      ((local-name()='port' or local-name()='multicastRelayPort' or local-name()='fireMissionIndex') and (.='0'))))" />
        <!-- ='' ='1' '' geoCoords='0 0 0' geoSystem='"GD" "WE"' '1' munitionSiteID='0' ='' '0' '0' -->
        <xsl:variable name="notDefaultDIS2"
                      select="not(local-name(..)='EspduTransform' and
                      ((((local-name()='collisionType') or (local-name()='detonationResult')) and (.='0')) or
                      (((local-name()='detonationLocation') or (local-name()='detonationRelativeLocation'))  and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='eventApplicationID'  and (.='1')) or
                      (((local-name()='eventEntityID') or (local-name()='eventNumber') or (local-name()='eventSiteID'))  and (.='0')) or
                      ((local-name()='fired1' or local-name()='fired2') and (.='false')) or
                      (local-name()='deadReckoning'  and (.='0')) or
                      ((local-name()='articulationParameterCount' or local-name()='entityCategory' or local-name()='entitySubCategory' or local-name()='entityCountry' or local-name()='entityDomain' or local-name()='entityExtra' or local-name()='entityKind' or local-name()='entitySpecific' or local-name()='firingRange' or local-name()='firingRate' or local-name()='fuse' or local-name()='warhead' or local-name()='forceID' or local-name()='munitionQuantity') and (.='0')) or
                      ((local-name()='linearVelocity' or local-name()='linearAcceleration' or local-name()='munitionStartPoint' or local-name()='munitionEndPoint') and (.='0 0 0'))))" />
        <xsl:variable name="notDefaultDIS3"
                      select="not(local-name(..)='ReceiverPdu' and 
                      (((local-name()='radioID' or local-name()='receiverState' or starts-with(local-name(),'transmitter')) and (.='0')) or
                      (local-name()='receivedPower'  and (.='0' or .='0.0')))) and
                      not(local-name(..)='SignalPdu' and
                      (((local-name()='radioID' or local-name()='encodingScheme' or local-name()='tdlType' or local-name()='sampleRate' or local-name()='samples' or local-name()='dataLength') and (.='0')))) and
                      not(local-name(..)='TransmitterPdu' and
                      (((local-name()='radioID' or starts-with(local-name(),'antennaPattern') or starts-with(local-name(),'crypto') or local-name()='frequency' or local-name()='inputSource' or local-name()='lengthOfModulationParameters' or starts-with(local-name(),'modulationType') or starts-with(local-name(),'radioEntityType') or local-name()='transmitFrequencyBandwidth' or local-name()='transmitState') and (.='0')) or
                      ((local-name()='power' or local-name()='transmitFrequencyBandwidth') and (.='0' or .='0.0')) or
                      ((contains(local-name(),'ntennaLocation') and (.='0 0 0')))))" />
        <xsl:variable name="notDefaultDIS4"
                      select="not(local-name(..)='DISEntityManager' and
                      (((local-name()='applicationID') and (.='1')) or
                      ((local-name()='port' or local-name()='siteID') and (.='0')))) and
                      not(local-name(..)='DISEntityTypeMapping' and 
                      ((local-name()='containerField') and (.='mapping')) or
                      ((local-name()='category' or local-name()='country' or local-name()='domain' or local-name()='extra' or local-name()='kind' or local-name()='specific' or local-name()='subcategory') and (.='0')))" />
        <xsl:variable name="notDefaultGeo"
                      select="not((starts-with(local-name(..),'Geo') or (local-name(..)='EspduTransform') or contains(local-name(..),'Pdu')) and ((local-name()='geoCoords' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='geoSystem' and (translate(.,',','')='&quot;GD&quot; &quot;WE&quot;')))) and
                      not(local-name(..)='GeoLOD' 	  and local-name()='range' and (.='10' or .='10.0')) and
                      not(local-name(..)='GeoViewpoint' and
                      ((local-name()='speedFactor' and (.='1' or .='1.0')) or
                       (local-name()='headlight' and (.='true')) or
                       (local-name()='jump' and (.='true')) or
                       (local-name()='navType' and (.='&quot;EXAMINE&quot; &quot;ANY&quot;')) or
                       (local-name()='orientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='position' and (.='0 0 100000' or .='0.0 0.0 100000.0')) or
                      (local-name()='fieldOfView' and (.='0.785398' or .='.785398' or .='0.7854' or .='.7854')))) and
                      not((local-name(..)='GeoCoordinate' or local-name(..)='GeoOrigin') and
                      ((local-name()='rotateYUp' and (.='false')) or
                      (local-name()='containerField' and (.='geoOrigin')) or
                      (local-name()='geoSystem' and (translate(.,',','')='&quot;GD&quot; &quot;WE&quot;'))))" />
        <xsl:variable name="notDefaultHAnim1"
                      select="not( local-name(..)='HAnimJoint' and
                      ((local-name()='containerField' and (.='children')) or
                       (local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='limitOrientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='rotation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='scale' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                       (local-name()='scaleOrientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='stiffness' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='translation' and (.='0 0 0' or .='0.0 0.0 0.0')))) and
                      not( local-name(..)='HAnimSegment' and
                      ((local-name()='containerField' and (.='children')) or
                       (local-name()='bboxCenter' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='bboxSize' and (.='-1 -1 -1' or .='-1.0 -1.0 -1.0')) or
                       (local-name()='centerOfMass' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='mass' and (.='0' or .='0.0')) or
                       (local-name()='momentsOfInertia' and
                        (.='0 0 0 0 0 0 0 0 0' or .='0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0')))) and
                      not( local-name(..)='HAnimSite' and
                      ((local-name()='containerField' and (.='children')) or
                       (local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='rotation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='scale' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                       (local-name()='scaleOrientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='translation' and (.='0 0 0' or .='0.0 0.0 0.0'))))" />
        <xsl:variable name="notDefaultHAnim2"
                      select="not( local-name(..)='HAnimHumanoid' and
                      ((local-name()='containerField' and (.='children')) or
                       (local-name()='bboxCenter' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='bboxSize' and (.='-1 -1 -1' or .='-1.0 -1.0 -1.0')) or
                       (local-name()='center' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                       (local-name()='rotation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='scale' and (.='1 1 1' or .='1.0 1.0 1.0')) or
                       (local-name()='scaleOrientation' and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')) or
                       (local-name()='translation' and (.='0 0 0' or .='0.0 0.0 0.0'))))" />
        <xsl:variable name="notDefaultNurbs"
                      select="not((local-name(..)='NurbsCurve' or local-name(..)='NurbsCurve2D') and
                      ((local-name()='tessellation' and (.='0')) or
                      (local-name()='closed' and (.='false')) or
                      (local-name()='order' and (.='3')))) and
                      not(local-name(..)='NurbsSet' and
                      ((local-name()='tessellationScale' and (.='1' or .='1.0')) or 
                      (local-name()='bboxCenter'	and	(.='0 0 0' or .='0.0 0.0 0.0')) or
                      ( local-name()='bboxSize'	and	(.='-1 -1 -1' or .='-1.0 -1.0 -1.0')))) and
                      not((local-name(..)='NurbsOrientationInterpolator' or local-name(..)='NurbsPositionInterpolator') and
                      ((local-name()='order' and (.='3' or .='3.0')))) and
                      not((local-name(..)='NurbsSurface' or local-name(..)='NurbsPatchSurface' or local-name(..)='NurbsTextureSurface' or local-name(..)='NurbsTrimmedSurface') and
                      ((local-name()='uTessellation' and (.='0')) or
                      (local-name()='vTessellation' and (.='0')) or
                      (local-name()='uDimension' and (.='0')) or
                      (local-name()='vDimension' and (.='0')) or
                      (local-name()='uOrder' and (.='3')) or
                      (local-name()='vOrder' and (.='3')) or
                      (local-name()='solid' and (.='true')) or
                      ((local-name()='uClosed' or local-name()='vClosed') and (.='false')))) and
                      not((local-name(..)='NurbsSurfaceInterpolator' or local-name(..)='NurbsTextureCoordinate') and
                      ((local-name()='uDimension' and (.='0')) or
                      (local-name()='vDimension' and (.='0')) or
                      (local-name()='uOrder' and (.='3')) or
                      (local-name()='vOrder' and (.='3')))) and
                      not((local-name(..)='NurbsCurve' or local-name(..)='NurbsSwungSurface') and
                      ((local-name()='ccw' or local-name()='solid') and (.='true')))" />
        <xsl:variable name="notDefaultGeometry2D"
                      select="not((local-name(..)='Arc2D' or local-name(..)='ArcClose2D') and
                      ((local-name()='startAngle' and (.='0' or .='0.0')) or
                       (local-name()='endAngle' and (.='1.5708' or .='1.570796')) or
                       (local-name()='radius' and (.='1' or .='1.0')) or
                       (local-name()='solid' and (.='false')))) and
                      not(local-name(..)='Circle2D' and
                      ((local-name()='radius' and (.='1' or .='1.0')))) and
                      not(local-name(..)='Disk2D' and
                      ((local-name()='innerRadius' and (.='0' or .='0.0')) or
                       (local-name()='outerRadius' and (.='1' or .='1.0')) or
                       (local-name()='solid' and (.='false')))) and
                      not((local-name(..)='Rectangle2D') and
                      ((local-name()='size' and ((.='2 2') or (.='2.0 2.0'))) or
                       (local-name()='solid' and (.='false')))) and
                      not((local-name(..)='TriangleSet2D') and
                      ((local-name()='solid' and (.='false'))))" />
        <xsl:variable name="notDefaultVolume"
                      select="not(((local-name(..)='IsoSurfaceVolumeData') or (local-name(..)='SegmentedVolumeData') or (local-name(..)='VolumeData'))	and
                      ((local-name()='dimensions' and (.='1 1 1' or .='1.0 1.0 1.0')) or 
                      (local-name()='bboxCenter'	and	(.='0 0 0' or .='0.0 0.0 0.0')) or
                      ( local-name()='bboxSize'	and	(.='-1 -1 -1' or .='-1.0 -1.0 -1.0')))) and
                      not((local-name(..)='IsoSurfaceVolumeData')	and
                      ((local-name()='contourStepSize' or local-name()='surfaceTolerance') and (.='0' or .='0.0'))) and
                      not(((local-name(..)='BlendedVolumeStyle') or (local-name(..)='BoundaryEnhancementVolumeStyle') or (local-name(..)='CartoonVolumeStyle') or (local-name(..)='ComposedVolumeStyle') or (local-name(..)='EdgeEnhancementVolumeStyle') or (local-name(..)='OpacityMapVolumeStyle') or (local-name(..)='ProjectionVolumeStyle') or (local-name(..)='ShadedVolumeStyle') or (local-name(..)='SilhouetteEnhancementVolumeStyle') or (local-name(..)='ToneMappedVolumeStyle')) and
                      (local-name()='enabled' and .='true')) and
                      not((local-name(..)='BlendedVolumeStyle')	and
                      (((local-name()='weightConstant1' or local-name()='weightConstant2') and (.='.5' or .='0.5')) or
                       ((local-name()='weightFunction1' or local-name()='weightFunction2') and (.='CONSTANT')))) and
                      not((local-name(..)='BoundaryEnhancementVolumeStyle')	and
                      (((local-name()='boundaryOpacity') and (.='.9' or .='0.9')) or
                       ((local-name()='opacityFactor') and (.='2' or .='2.0')) or
                       ((local-name()='retainedOpacity') and (.='.2' or .='0.2')))) and
                      not((local-name(..)='CartoonVolumeStyle')	and
                      (((local-name()='colorSteps') and (.='4')) or
                       ((local-name()='orthogonalColor') and (.='1 1 1 1' or .='1.0 1.0 1.0 1.0')) or
                       ((local-name()='parallelColor') and (.='0 0 0 1' or .='0.0 0.0 0.0 1.0')))) and
                      not((local-name(..)='EdgeEnhancementVolumeStyle')	and
                      (((local-name()='gradientThreshold') and (.='.4' or .='0.4')) or
                       ((local-name()='edgeColor') and (.='0 0 0 1' or .='0.0 0.0 0.0 1.0')))) and
                      not((local-name(..)='IsoSurfaceVolumeData')	and
                      (((local-name()='surfaceTolerance') and (.='0' or .='0.0')))) and
                      not((local-name(..)='ProjectionVolumeStyle')	and
                      (((local-name()='intensityThreshold') and (.='0' or .='0.0')) or
                       ((local-name()='type') and (.='MAX')))) and
                      not((local-name(..)='ShadedVolumeStyle')	and
                      (((local-name()='lighting' or local-name()='shadows') and (.='false')) or
                       ((local-name()='phaseFunction') and (.='Henyey-Greenstein')))) and
                      not((local-name(..)='SilhouetteEnhancementVolumeStyle')	and
                      (((local-name()='silhouetteBoundaryOpacity') and (.='0' or .='0.0')) or
                       ((local-name()='silhouetteRetainedOpacity') and (.='1' or .='1.0')) or
                       ((local-name()='silhouetteSharpness') and (.='.5' or .='0.5')))) and
                      not((local-name(..)='ToneMappedVolumeStyle')	and
                      (((local-name()='colorSteps') and (.='4')) or
                       ((local-name()='coolColor') and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0')) or
                       ((local-name()='warmColor') and (.='1 1 0 0' or .='1.0 1.0 0.0 0.0'))))" />
        <xsl:variable name="notDefaultFollower"
                      select="not(contains(local-name(..),'Chaser') and
                      ((local-name()='duration' and (.='1' or .='1.0')))) and
                      not(contains(local-name(..),'Damper') and
                      ((local-name()='tau' and (.='.3' or .='0.3')) or
                      (local-name()='tolerance' and (.='-1' or .='-1.0')) or
                      (local-name()='order ' and (.='3')))) and
                      not((local-name(..)='ColorChaser' or local-name(..)='ColorDamper') and
                      ((local-name()='initialDestination' and (.='.8 .8 .8' or .='0.8 0.8 0.8')) or
                      (local-name()='initialValue' and (.='.8 .8 .8' or .='0.8 0.8 0.8')))) and
                      not((local-name(..)='CoordinateChaser' or local-name(..)='CoordinateDamper' or local-name(..)='PositionChaser' or local-name(..)='PositionDamper') and
                      ((local-name()='initialDestination' and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='initialValue' and (.='0 0 0' or .='0.0 0.0 0.0')))) and
                      not((local-name(..)='PositionChaser2D' or local-name(..)='PositionDamper2D') and
                      ((local-name()='initialDestination' and (.='0 0' or .='0.0 0.0')) or
                      (local-name()='initialValue' and (.='0 0' or .='0.0 0.0')))) and
                      not((local-name(..)='OrientationChaser' or local-name(..)='OrientationDamper') and
                      ((local-name()='initialDestination' and (.='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 0 1 0' or .='0.0 0.0 1.0 0.0')) or
                      (local-name()='initialValue' and (.='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 0 1 0' or .='0.0 0.0 1.0 0.0')))) and
                      not((local-name(..)='ScalarChaser' or local-name(..)='ScalerDamper') and
                      ((local-name()='initialDestination' and (.='0' or .='0.0')) or
                      (local-name()='initialValue' and (.='0' or .='0.0'))))" />
        <xsl:variable name="notDefaultShader"
                      select="not((local-name(..)='FloatVertexAttribute') and
                      ((local-name()='numComponents' and (.='4')))) and
                      not((local-name(..)='ShaderPart' or local-name(..)='ShaderProgram') and
                      ((local-name()='type' and (.='VERTEX'))))" />
        <xsl:variable name="notDefaultRigidBodyPhysics"
                      select="not((local-name(..)='CollidableOffset' or local-name(..)='CollidableShape') and
                      (((local-name()='enabled') and (.='true')) or
                      ((local-name()='rotation') and (.='0 0 1 0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0.0 0.0 1.0 0.0')) or
                      ((local-name()='translation') and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      ((local-name()='bboxCenter')	and	(.='0 0 0' or .='0.0 0.0 0.0')) or
                      ((local-name()='bboxSize')	and	(.='-1 -1 -1' or .='-1.0 -1.0 -1.0')))) and
                      not((local-name(..)='CollisionSpace') and
                      ((local-name()='enabled' and (.='true')) or
                      (local-name()='useGeometry' and (.='false')) or
                      (local-name()='bboxCenter'	and	(.='0 0 0' or .='0.0 0.0 0.0')) or
                      (local-name()='bboxSize'	and	(.='-1 -1 -1' or .='-1.0 -1.0 -1.0')))) and
                      not((local-name(..)='BallJoint' or local-name(..)='DoubleAxisHingeJoint' or local-name(..)='MotorJoint' or local-name(..)='SingleAxisHingeJoint' or local-name(..)='SliderJoint' or local-name(..)='UniversalJoint') and
                      ((local-name()='forceOutput')	and	(.='&quot;NONE&quot;'))) and
                      not((local-name(..)='BallJoint') and
                      ((local-name()='anchorPoint')	and	(.='0 0 0' or .='0.0 0.0 0.0'))) and
                      not((local-name(..)='CollisionCollection') and
                      (((local-name()='appliedParameters') and (.='&quot;BOUNCE&quot;')) or
                      ((local-name()='bounce') and (.='0' or .='0.0')) or
                      ((local-name()='enabled') and (.='true')) or
                      ((local-name()='frictionCoefficients' or local-name()='slipFactors' or local-name()='surfaceSpeed') and (.='0 0' or .='0.0 0.0')) or
                      ((local-name()='minBounceSpeed') and (.='.1' or .='0.1')) or
                      ((local-name()='softnessConstantForceMix') and (.='.0001' or .='0.0001')) or
                      ((local-name()='softnessErrorCorrection') and (.='.8' or .='0.8')))) and
                      not((local-name(..)='CollisionSensor') and
                      (local-name()='enabled' and .='true')) and
                      not((local-name(..)='Contact') and
                      (((local-name()='appliedParameters') and (.='&quot;BOUNCE&quot;')) or
                      ((local-name()='bounce' or local-name()='depth' or local-name()='minbounceSpeed') and (.='0' or .='0.0')) or
                      ((local-name()='contactNormal') and (.='0 1 0' or .='0.0 1.0 0.0')) or
                      ((local-name()='frictionCoefficients' or local-name()='slipCoefficients' or local-name()='surfaceSpeed') and (.='0 0' or .='0.0 0.0')) or
                      ((local-name()='frictionDirection') and (.='0 1 0' or .='0.0 1.0 0.0')) or
                      ((local-name()='position') and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      ((local-name()='softnessConstantForceMix') and (.='.0001' or .='0.0001')) or
                      ((local-name()='softnessErrorCorrection') and (.='.8' or .='0.8')))) and
                      not((local-name(..)='DoubleAxisHingeJoint') and
                      (((local-name()='anchorPoint' or local-name()='axis1' or local-name()='axis2') and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      ((local-name()='desiredAngularVelocity1' or local-name()='desiredAngularVelocity2' or local-name()='maxTorque1' or local-name()='maxTorque2' or local-name()='stopBounce1' or local-name()='suspensionForce') and (.='0' or .='0.0')) or
                      ((local-name()='maxAngle1') and (.= '3.1416' or .= '3.14159' or .= '3.141593' or .= '3.1415926' or .= '3.14159263' or .= '3.141592653')) or
                      ((local-name()='minAngle1') and (.='-3.1416' or .='-3.14159' or .='-3.141593' or .='-3.1415926' or .='-3.14159263' or .='-3.141592653')) or
                      ((local-name()='stopConstantForceMix1') and (.='.0001' or .='0.0001')) or
                      ((local-name()='stopErrorCorrection1' or local-name()='suspensionErrorCorrection') and (.='.8' or .='0.8')))) and
                      not((local-name(..)='MotorJoint') and
                      (((local-name()='axis1Angle' or local-name()='axis2Angle' or local-name()='axis3Angle' or local-name()='axis1Torque' or local-name()='axis2Torque' or local-name()='axis3Torque' or local-name()='stop1Bounce' or local-name()='stop2Bounce' or local-name()='stop3Bounce') and (.='0' or .='0.0')) or
                      ((local-name()='stop1ErrorCorrection' or local-name()='stop2ErrorCorrection' or local-name()='stop3ErrorCorrection') and (.='.8' or .='0.8')) or
                      ((local-name()='motor1Axis' or local-name()='motor2Axis' or local-name()='motor3Axis') and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      ((local-name()='enabledAxes') and (.='1')) or
                      ((local-name()='autoCalc') and (.='false')))) and
                      not((local-name(..)='RigidBody') and
                      (((local-name()='angularDampingFactor') and (.='.001' or .='0.001')) or
                      ((local-name()='angularVelocity' or local-name()='centerOfMass' or local-name()='finiteRotationAxis' or local-name()='linearVelocity' or local-name()='position') and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      ((local-name()='disableAngularSpeed' or local-name()='disableLinearSpeed' or local-name()='disableTime') and (.='0' or .='0.0')) or
                      ((local-name()='mass') and (.='1' or .='1.0')) or
                      ((local-name()='enabled' or local-name()='useGlobalGravity') and (.='true')) or
                      ((local-name()='autoDamp' or local-name()='autoDisable' or local-name()='fixed' or local-name()='useFiniteRotation') and (.='false')) or
                      ((local-name()='inertia') and (.='1 0 0 0 1 0 0 0 1' or .='1.0 0 0 0 1.0 0 0 0 1.0' or .='1.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0')) or
                      ((local-name()='linearDampingFactor') and (.='.001' or .='0.001')) or
                      ((local-name()='orientation') and (.='0 0 1 0' or .='0.0 0.0 1.0 0.0' or .='0 1 0 0' or .='0.0 1.0 0.0 0.0' or .='0 1 0 0.0'  or .='0 0 1 0.0')))) and
                      not((local-name(..)='RigidBodyCollection') and
                      (((local-name()='autoDisable' or local-name()='preferAccuracy') and (.='false')) or
                      ((local-name()='enabled') and (.='true')) or
                      ((local-name()='constantForceMix') and (.='.0001' or .='0.0001')) or
                      ((local-name()='contactSurfaceThickness' or local-name()='disableAngularSpeed' or local-name()='disableLinearSpeed' or local-name()='disableTime') and (.='0' or .='0.0')) or
                      ((local-name()='errorCorrection') and (.='.8' or .='0.8')) or
                      ((local-name()='gravity') and (.='0 -9.8 0' or .='0.0 -9.8 0.0')) or
                      ((local-name()='iterations') and (.='10')) or
                      ((local-name()='maxCorrectionSpeed') and (.='-1' or .='-1.0')))) and
                      not((local-name(..)='SingleAxisHingeJoint') and
                      (((local-name()='anchorPoint' or local-name()='axis') and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      ((local-name()='maxAngle') and (.= '3.1416' or .= '3.14159' or .= '3.141593' or .= '3.1415926' or .= '3.14159263' or .= '3.141592653')) or
                      ((local-name()='minAngle') and (.='-3.1416' or .='-3.14159' or .='-3.141593' or .='-3.1415926' or .='-3.14159263' or .='-3.141592653')) or
                      ((local-name()='stopBounce') and (.='0' or .='0.0')) or
                      ((local-name()='stopErrorCorrection') and (.='.8' or .='0.8')))) and
                      not((local-name(..)='SliderJoint') and
                      (((local-name()='axis') and (.='0 1 0' or .='0.0 1.0 0.0')) or
                      ((local-name()='maxSeparation' or local-name()='stopErrorCorrection') and (.='1' or .='1.0')) or
                      ((local-name()='minSeparation' or local-name()='sliderForce' or local-name()='stopBounce') and (.='0' or .='0.0')) or
                      ((local-name()='stopErrorCorrection') and (.='1' or .='1.0')))) and
                      not((local-name(..)='UniversalJoint') and
                      (((local-name()='anchorPoint' or local-name()='axis1' or local-name()='axis2') and (.='0 0 0' or .='0.0 0.0 0.0')) or
                      ((local-name()='stopBounce1' or local-name()='stop2Bounce') and (.='0' or .='0.0')) or
                      ((local-name()='stop1ErrorCorrection' or local-name()='stop2ErrorCorrection') and (.='.8' or .='0.8'))))" />
        <xsl:variable name="notFieldSpace"
                      select="not(local-name(..)='field'  and	(local-name()='space' or local-name()='xml:space')) and
                      not(local-name(..)='Script' and	(local-name()='space' or local-name()='xml:space'))" />
        
        <!-- provide attribute output only if it is not a default value, or if scene has a digital signature -->
        <!-- note that if digital signature is present, all attributes are included (including default values) and
                       order of attributes may change, but that should be OK according to Post Schema Validation Infoset (PSVI) -->
                <xsl:variable name="notDefaultValue" select="
                (count(//ds:Signature) > 0) or
                (
                $notImplicitEvent1 and
                $notImplicitEvent2 and
                $notImplicitEvent3 and
                $notDefaultFieldValue1 and
                $notDefaultFieldValue1a and
                $notDefaultFieldValue2 and
                $notDefaultFieldValue3 and
                $notDefaultFieldValue4 and
                $notDefaultFieldValue5 and
                $notDefaultFieldValue6 and
                $notDefaultFieldValue7 and
                $notDefaultFieldValue8 and
                $notDefaultFieldValue9 and
                $notDefaultCAD         and
                $notDefaultDIS1        and
                $notDefaultDIS2        and
                $notDefaultDIS3        and
                $notDefaultDIS4        and
                $notDefaultGeo         and
                $notDefaultHAnim1      and
                $notDefaultHAnim2      and
                $notDefaultNurbs       and
                $notDefaultGeometry2D  and
                $notDefaultVolume      and
                $notDefaultFollower    and
                $notDefaultShader      and
                $notDefaultRigidBodyPhysics and
                $notDefaultContainerField1  and
                $notDefaultContainerField2  and
                $notDefaultContainerField3  and
                not(local-name()='containerField' and .='') and
                not(local-name()='class' and .='') and
                $notFieldSpace and
                not(contains(local-name(),'set_')) and
                not(contains(local-name(),'_changed')) and
                .)" />
        <!-- debug
        <xsl:message>
            <xsl:value-of select="local-name(..)"/>
            <xsl:text> @</xsl:text>
            <xsl:value-of select="local-name()"/>
            <xsl:text>=</xsl:text>
            <xsl:value-of select="."/>
            <xsl:text>, isDefaultValue: </xsl:text>
            <xsl:value-of select="not($notDefaultValue)"/>
        </xsl:message> -->
        
        <xsl:if test="$notDefaultValue or not($stripDefaultAttributes='true') or (local-name()='ROUTE') or (local-name()='field') or (local-name()='fieldValue')">
            <xsl:value-of select="."/> <!-- return non-default value, empty otherwise if $stripDefaultAttributes=false -->
        </xsl:if>
        
    </xsl:template> <!-- end name="not-default-attribute-value" -->

</xsl:stylesheet>