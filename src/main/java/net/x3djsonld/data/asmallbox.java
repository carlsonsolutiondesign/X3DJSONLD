package net.x3djsonld.data;

import java.util.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Grouping.*;
import org.web3d.x3d.jsail.Shape.*;

// Javadoc annotations follow, see below for source.
/**
 * <p> a box. </p>
 <p> Related links: asmallbox.java source, <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html" target="_blank">X3D Resources</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>, and <a href="http://www.web3d.org/x3d/content/X3dTooltips.html" target="_blank">X3D Tooltips</a>. </p>
	<table style="color:black; border:0px solid; border-spacing:10px 0px;" summary="Scene Metadata">
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center; padding:10px 0px;"><i>meta tags</i></td>
			<td style="text-align:left;   padding:10px 0px;">net.x3djsonld.data.asmallbox&nbsp; Document Metadata </td>
		</tr>

		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> title </i> </td>
			<td> <a href="https://coderextreme.net/X3DJSONLD/abox.x3d">abox.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> creator </i> </td>
			<td> John Carlson </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> generator </i> </td>
			<td> manual </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> identifier </i> </td>
			<td> <a href="https://coderextreme.net/X3DJSONLD/abox.x3d" target="_blank">https://coderextreme.net/X3DJSONLD/abox.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> description </i> </td>
			<td> a box </td>
		</tr>
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center;" colspan="2">  &nbsp; </td>
		</tr>
	</table>

	<p>
		This program uses the
		<a href="http://www.web3d.org/specifications/java/X3DJSAIL.html" target="_blank">X3D Java Scene Access Interface Library (X3DJSAIL)</a>.
		It has been produced using the 
		<a href="http://www.web3d.org/x3d/stylesheets/X3dToJava.xslt" target="_blank">X3dToJava.xslt</a>
		stylesheet to create Java source code from an <code>.x3d</code> model.
	</p>

	* @author John Carlson
 */

public class asmallbox
{
  /** Default constructor to create this object. */
  public asmallbox ()
  {
    initialize();
  }
	
  /** Create and initialize the X3D model for this object. */
  public final void initialize()
  {
  x3dModel = new X3DObject().setProfile("Immersive").setVersion("3.3")
  .setHead(new headObject()
    .addMeta(new metaObject().setName("title").setContent("abox.x3d").setDir("").setHttp_equiv("").setLang("").setScheme(""))
    .addMeta(new metaObject().setName("creator").setContent("John Carlson").setDir("").setHttp_equiv("").setLang("").setScheme(""))
    .addMeta(new metaObject().setName("generator").setContent("manual").setDir("").setHttp_equiv("").setLang("").setScheme(""))
    .addMeta(new metaObject().setName("identifier").setContent("https://coderextreme.net/X3DJSONLD/abox.x3d").setDir("").setHttp_equiv("").setLang("").setScheme(""))
    .addMeta(new metaObject().setName("description").setContent("a box").setDir("").setHttp_equiv("").setLang("").setScheme("")))
  .setScene(new SceneObject()
    .addChild(new ProtoDeclareObject().setName("anyShape").setAppinfo("").setDocumentation("")
      .setProtoInterface(new ProtoInterfaceObject()
        .addField(new fieldObject().setAccessType("inputOutput").setName("myShape").setType("MFNode").setValue("").setAppinfo("").setDocumentation("")
          .addChild(new ShapeObject()
            .setGeometry(new SphereObject()))))
      .setProtoBody(new ProtoBodyObject()
        .addChild(new TransformObject()
          .setIS(new ISObject()
            .addConnect(new connectObject().setNodeField("children").setProtoField("myShape"))))))
    .addChild(new ProtoDeclareObject().setName("one").setAppinfo("").setDocumentation("")
      .setProtoInterface(new ProtoInterfaceObject()
        .addField(new fieldObject().setAccessType("inputOutput").setName("myShape").setType("MFNode").setValue("").setAppinfo("").setDocumentation("")
          .addChild(new ShapeObject()
            .setGeometry(new CylinderObject()))))
      .setProtoBody(new ProtoBodyObject()
        .addChild(new TransformObject()
          .addChild(new ProtoInstanceObject().setName("anyShape")
            .setIS(new ISObject()
              .addConnect(new connectObject().setNodeField("myShape").setProtoField("myShape")))))))
    .addChild(new ProtoInstanceObject().setName("one")
      .addFieldValue(new fieldValueObject().setName("myShape").setValue("")
        .addChild(new ShapeObject()
          .setGeometry(new BoxObject().setSize(0.125f,0.125f,0.125f))))));
  }
  // end of initialize() method

  /** The initialized model object, created within initialize() method. */
  private X3DObject x3dModel;
  
  /** Provide a 
   * <a href="https://dzone.com/articles/java-copy-shallow-vs-deep-in-which-you-will-swim" target="_blank">shallow copy</a>
   * of the X3D model.
   * @see <a href="http://www.web3d.org/specifications/java/javadoc/org/web3d/x3d/jsail/Core/X3DObject.html">X3DObject</a>
   * @return asmallbox model
   */
  public X3DObject getX3dModel()
  {	  
	  return x3dModel;
  }
	   
    /** Default main() method provided for test purposes.
     * @param argv input parameters
	 * @see <a href="http://www.web3d.org/specifications/java/javadoc/org/web3d/x3d/jsail/Core/X3DObject.html#handleArguments-java.lang.String:A-">X3DObject.handleArguments(argv)</a>
	 * @see <a href="http://www.web3d.org/specifications/java/javadoc/org/web3d/x3d/jsail/Core/X3DObject.html#validationReport--">X3DObject.validationReport()</a>
     */
    public static void main(String argv[])
    {
        X3DObject exampleObject = new asmallbox().getX3dModel();

        exampleObject.handleArguments(argv);
        System.out.print("asmallbox self-validation test results: ");
        String validationResults = exampleObject.validationReport();
        System.out.println(validationResults);
    }
}
