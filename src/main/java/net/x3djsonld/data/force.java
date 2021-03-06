package net.x3djsonld.data;

import java.util.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Grouping.*;
import org.web3d.x3d.jsail.Interpolation.*;
import org.web3d.x3d.jsail.PointingDeviceSensor.*;
import org.web3d.x3d.jsail.Scripting.*;
import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.jsail.Text.*;
import org.web3d.x3d.jsail.Time.*;

// Javadoc annotations follow, see below for source.
/**
 * <p> beginnings of a force directed graph in 3D. </p>
 <p> Related links: force.java source, <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html" target="_blank">X3D Resources</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>, and <a href="http://www.web3d.org/x3d/content/X3dTooltips.html" target="_blank">X3D Tooltips</a>. </p>
	<table style="color:black; border:0px solid; border-spacing:10px 0px;" summary="Scene Metadata">
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center; padding:10px 0px;"><i>meta tags</i></td>
			<td style="text-align:left;   padding:10px 0px;">net.x3djsonld.data.force&nbsp; Document Metadata </td>
		</tr>

		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> creator </i> </td>
			<td> John W Carlson </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> created </i> </td>
			<td> December 13 2015 </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> title </i> </td>
			<td> <a href="https://coderextreme.net/X3DJSONLD/force.x3d">force.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> identifier </i> </td>
			<td> <a href="https://coderextreme.net/X3DJSONLD/force.x3d" target="_blank">https://coderextreme.net/X3DJSONLD/force.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> description </i> </td>
			<td> beginnings of a force directed graph in 3D </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> generator </i> </td>
			<td> Vim, X3D-Edit, <a href="https://savage.nps.edu/X3D-Edit" target="_blank">https://savage.nps.edu/X3D-Edit</a> </td>
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

	* @author John W Carlson
 */

public class force
{
  /** Default constructor to create this object. */
  public force ()
  {
    initialize();
  }
	
  /** Create and initialize the X3D model for this object. */
  public final void initialize()
  {
  x3dModel = new X3DObject().setProfile("Immersive").setVersion("3.3")
  .setHead(new headObject()
    .addMeta(new metaObject().setName("creator").setContent("John W Carlson"))
    .addMeta(new metaObject().setName("created").setContent("December 13 2015"))
    .addMeta(new metaObject().setName("title").setContent("force.x3d"))
    .addMeta(new metaObject().setName("identifier").setContent("https://coderextreme.net/X3DJSONLD/force.x3d"))
    .addMeta(new metaObject().setName("description").setContent("beginnings of a force directed graph in 3D"))
    .addMeta(new metaObject().setName("generator").setContent("Vim, X3D-Edit, https://savage.nps.edu/X3D-Edit")))
  .setScene(new SceneObject()
    .addChild(new ProtoDeclareObject().setName("node")
      .setProtoInterface(new ProtoInterfaceObject()
        .addField(new fieldObject().setAccessType("inputOutput").setName("position").setType("SFVec3f").setValue("0 0 0")))
      .setProtoBody(new ProtoBodyObject()
        .addChild(new GroupObject()
          .addChild(new TransformObject("transform")
            .setIS(new ISObject()
              .addConnect(new connectObject().setNodeField("translation").setProtoField("position")))
            .addChild(new ShapeObject()
              .setGeometry(new SphereObject())
              .setAppearance(new AppearanceObject()
                .setMaterial(new MaterialObject().setDiffuseColor(1.0f,0.0f,0.0f))))
            .addChild(new TransformObject().setTranslation(1.0f,0.0f,0.0f)
              .addChild(new ShapeObject()
                .setGeometry(new TextObject().setString(new MFStringObject("\"Node\""))
                  .setFontStyle(new FontStyleObject().setJustify(new MFStringObject("\"MIDDLE\" \"MIDDLE\"")).setSize(5f)))
                .setAppearance(new AppearanceObject()
                  .setMaterial(new MaterialObject().setDiffuseColor(0.0f,0.0f,1.0f))))))
          .addChild(new PositionInterpolatorObject("NodePosition").setKeyValue(new MFVec3fObject(new float[] {0.0f,0.0f,0.0f,0.0f,5.0f,0.0f})).setKey(new float[] {0.0f,1.0f}))
          .addChild(new ScriptObject("MoveBall").setSourceCode(
"<![CDATA[" + "\n" +
"\n" + 
"\n" + 
"ecmascript:" + "\n" + 
"					function set_cycle(value) {" + "\n" + 
"                                                old = translation;" + "\n" + 
"						translation = new SFVec3f(Math.random()*100-50, Math.random()*100-50, Math.random()*100-50);" + "\n" + 
"                                                keyValue = new MFVec3f([old, translation]);" + "\n" + 
"						// Browser.println(translation);" + "\n" + 
"					}" + "\n" + "]]>"
)
            .addField(new fieldObject().setAccessType("inputOutput").setName("translation").setType("SFVec3f").setValue("50 50 0"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("old").setType("SFVec3f").setValue("0 0 0"))
            .addField(new fieldObject().setAccessType("inputOnly").setName("set_cycle").setType("SFTime"))
            .addField(new fieldObject().setAccessType("outputOnly").setName("keyValue").setType("MFVec3f")))
          .addChild(new TimeSensorObject("nodeClock").setCycleInterval(3).setLoop(true))
          .addChild(new ROUTEObject().setFromNode("nodeClock").setFromField("cycleTime").setToNode("MoveBall").setToField("set_cycle"))
          .addChild(new ROUTEObject().setFromNode("nodeClock").setFromField("fraction_changed").setToNode("NodePosition").setToField("set_fraction"))
          .addChild(new ROUTEObject().setFromNode("MoveBall").setFromField("keyValue").setToNode("NodePosition").setToField("keyValue"))
          .addChild(new ROUTEObject().setFromNode("NodePosition").setFromField("value_changed").setToNode("transform").setToField("set_translation")))))
    .addChild(new ProtoDeclareObject().setName("cylinder")
      .setProtoInterface(new ProtoInterfaceObject()
        .addField(new fieldObject().setAccessType("inputOnly").setName("set_positionA").setType("SFVec3f"))
        .addField(new fieldObject().setAccessType("inputOnly").setName("set_positionB").setType("SFVec3f")))
      .setProtoBody(new ProtoBodyObject()
        .addChild(new GroupObject()
          .addChild(new ShapeObject()
            .setGeometry(new ExtrusionObject("extrusion").setSpine(new MFVec3fObject(new float[] {0.0f,-50.0f,0.0f,0.0f,50.0f,0.0f})).setCreaseAngle(0.785f).setCrossSection(extrusion_7_40_crossSection))
            .setAppearance(new AppearanceObject()
              .setMaterial(new MaterialObject().setDiffuseColor(0.0f,1.0f,0.0f))))
          .addChild(new ScriptObject("MoveCylinder").setSourceCode(
"<![CDATA[" + "\n" +
"\n" + 
"\n" + 
"ecmascript:" + "\n" + 
"\n" + 
"                function set_endA(value) {" + "\n" + 
"		    if (typeof spine === 'undefined') {" + "\n" + 
"		        spine = new MFVec3f([value, value]);" + "\n" + 
"		    } else {" + "\n" + 
"		        spine = new MFVec3f([value, spine[1]]);" + "\n" + 
"		    }" + "\n" + 
"                }" + "\n" + 
"                " + "\n" + 
"                function set_endB(value) {" + "\n" + 
"		    if (typeof spine === 'undefined') {" + "\n" + 
"		        spine = new MFVec3f([value, value]);" + "\n" + 
"		    } else {" + "\n" + 
"		        spine = new MFVec3f([spine[0], value]);" + "\n" + 
"		    }" + "\n" + 
"                }" + "\n" + 
"                " + "\n" + 
"                function set_spine(value) {" + "\n" + 
"                    spine = value;" + "\n" + 
"                }" + "\n" + "]]>"
)
            .addField(new fieldObject().setAccessType("inputOutput").setName("spine").setType("MFVec3f").setValue("0 -50 0 0 50 0"))
            .addField(new fieldObject().setAccessType("inputOnly").setName("set_endA").setType("SFVec3f"))
            .addField(new fieldObject().setAccessType("inputOnly").setName("set_endB").setType("SFVec3f"))
            .setIS(new ISObject()
              .addConnect(new connectObject().setNodeField("set_endA").setProtoField("set_positionA"))
              .addConnect(new connectObject().setNodeField("set_endB").setProtoField("set_positionB"))))
          .addChild(new ROUTEObject().setFromNode("MoveCylinder").setFromField("spine").setToNode("extrusion").setToField("set_spine")))))
    .addChild(new TransformObject("HoldsContent").setScale(0.1f,0.1f,0.1f)
      .addChild(new PlaneSensorObject("clickGenerator").setDescription("click on background to add nodes, click on nodes to add links").setMinPosition(-50.0f,-50.0f).setMaxPosition(50.0f,50.0f))
      .addChild(new ProtoInstanceObject("nodeA", "node").setDEF("nodeA").setName("node")
        .addFieldValue(new fieldValueObject().setName("position").setValue("0.0 0.0 0.0")))
      .addChild(new ProtoInstanceObject("nodeB", "node").setDEF("nodeB").setName("node")
        .addFieldValue(new fieldValueObject().setName("position").setValue("50.0 50.0 50.0")))
      .addChild(new ProtoInstanceObject("nodeC", "node").setDEF("nodeC").setName("node")
        .addFieldValue(new fieldValueObject().setName("position").setValue("-50.0 -50.0 -50.0")))
      .addChild(new ProtoInstanceObject("nodeD", "node").setDEF("nodeD").setName("node")
        .addFieldValue(new fieldValueObject().setName("position").setValue("50.0 50.0 -50.0")))
      .addChild(new ProtoInstanceObject("linkA", "cylinder").setDEF("linkA").setName("cylinder")
        .addFieldValue(new fieldValueObject().setName("set_positionA").setValue("0 0 0"))
        .addFieldValue(new fieldValueObject().setName("set_positionB").setValue("50 50 50")))
      .addChild(new ProtoInstanceObject("linkB", "cylinder").setDEF("linkB").setName("cylinder")
        .addFieldValue(new fieldValueObject().setName("set_positionA").setValue("0 0 0"))
        .addFieldValue(new fieldValueObject().setName("set_positionB").setValue("-50 -50 -50")))
      .addChild(new ProtoInstanceObject("linkC", "cylinder").setDEF("linkC").setName("cylinder")
        .addFieldValue(new fieldValueObject().setName("set_positionA").setValue("50 50 50"))
        .addFieldValue(new fieldValueObject().setName("set_positionB").setValue("50 50 -50"))))
    .addChild(new ScriptObject("clickHandler").setSourceCode(
"<![CDATA[" + "\n" +
"\n" + 
"	" + "\n" + 
"ecmascript:" + "\n" + 
"	function add_node(value) {" + "\n" + 
"                // Browser.print('hey ', counter);" + "\n" + 
"                counter = counter++;" + "\n" + 
"		Browser.appendTo(Browser.getDocument().querySelector(\"field [name=ModifiableNode]\")," + "\n" + 
"			{ \"ProtoInstance\":" + "\n" + 
"				{ \"@name\":\"node\"," + "\n" + 
"				  \"@DEF\":\"node'+counter+'\"," + "\n" + 
"				  \"fieldValue\": [" + "\n" + 
"					{" + "\n" + 
"						 \"@name\":\"position\"," + "\n" + 
"						 \"@value\":[0.0,0.0,0.0]" + "\n" + 
"					}" + "\n" + 
"				  ]" + "\n" + 
"				}" + "\n" + 
"			});" + "\n" + 
"                " + "\n" + 
"        }" + "\n" + "]]>"
)
      .addField(new fieldObject().setAccessType("inputOutput").setName("counter").setType("SFInt32").setValue("0"))
      .addField(new fieldObject().setAccessType("outputOnly").setName("node_changed").setType("SFNode"))
      .addField(new fieldObject().setAccessType("inputOnly").setName("add_node").setType("SFBool").setValue("false"))
      .addComments(new String[] {"",
"            <field name=\"ModifiableNode\" type=\"SFNode\" accessType=\"inputOutput\">",
"                <Transform USE=\"HoldsContent\"/>",
"            </field>"}))
    .addChild(new ROUTEObject().setFromNode("clickGenerator").setFromField("isActive").setToNode("clickHandler").setToField("add_node"))
    .addChild(new ROUTEObject().setFromNode("nodeA").setFromField("position").setToNode("linkA").setToField("set_positionA"))
    .addChild(new ROUTEObject().setFromNode("nodeB").setFromField("position").setToNode("linkA").setToField("set_positionB"))
    .addChild(new ROUTEObject().setFromNode("nodeA").setFromField("position").setToNode("linkB").setToField("set_positionA"))
    .addChild(new ROUTEObject().setFromNode("nodeC").setFromField("position").setToNode("linkB").setToField("set_positionB"))
    .addChild(new ROUTEObject().setFromNode("nodeA").setFromField("position").setToNode("linkC").setToField("set_positionA"))
    .addChild(new ROUTEObject().setFromNode("nodeD").setFromField("position").setToNode("linkC").setToField("set_positionB")));
  }
  // end of initialize() method

	/** Large attribute array: Extrusion DEF='extrusion' crossSection field, scene-graph level=7, element #40, 34 total numbers made up of 17 2-tuple values */
	private MFVec2fObject extrusion_7_40_crossSection = new MFVec2fObject() /* splitting up long array to improve readability */
	.append(new MFVec2fObject(new float[] {1.00f,0.00f,0.92f,-0.38f,0.71f,-0.71f,0.38f,-0.92f,0.00f,-1.00f,-0.38f,-0.92f,-0.71f,-0.71f,-0.92f,-0.38f,-1.00f,-0.00f,-0.92f,0.38f}))
	.append(new MFVec2fObject(new float[] {-0.71f,0.71f,-0.38f,0.92f,0.00f,1.00f,0.38f,0.92f,0.71f,0.71f,0.92f,0.38f,1.00f,0.00f}));

  /** The initialized model object, created within initialize() method. */
  private X3DObject x3dModel;
  
  /** Provide a 
   * <a href="https://dzone.com/articles/java-copy-shallow-vs-deep-in-which-you-will-swim" target="_blank">shallow copy</a>
   * of the X3D model.
   * @see <a href="http://www.web3d.org/specifications/java/javadoc/org/web3d/x3d/jsail/Core/X3DObject.html">X3DObject</a>
   * @return force model
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
        X3DObject exampleObject = new force().getX3dModel();

        exampleObject.handleArguments(argv);
        System.out.print("force self-validation test results: ");
        String validationResults = exampleObject.validationReport();
        System.out.println(validationResults);
    }
}
