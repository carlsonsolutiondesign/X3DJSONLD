package net.x3djsonld.data;

import java.util.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.CubeMapTexturing.*;
import org.web3d.x3d.jsail.EnvironmentalEffects.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Grouping.*;
import org.web3d.x3d.jsail.Interpolation.*;
import org.web3d.x3d.jsail.Navigation.*;
import org.web3d.x3d.jsail.Scripting.*;
import org.web3d.x3d.jsail.Shaders.*;
import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.jsail.Texturing.*;
import org.web3d.x3d.jsail.Time.*;

// Javadoc annotations follow, see below for source.
/**
 * <p> not sure what this is. </p>
 <p> Related links: bubbles.java source, <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html" target="_blank">X3D Resources</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a> and <a href="http://www.web3d.org/x3d/content/X3dTooltips.html" target="_blank">X3D Tooltips</a>. </p>
	<table style="color:black; border:0px solid; border-spacing:10px 0px;" summary="Scene Metadata">
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center; padding:10px 0px;"><i>meta tags</i></td>
			<td style="text-align:left;   padding:10px 0px;">net.x3djsonld.data.bubbles&nbsp; Document Metadata </td>
		</tr>

		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> title </i> </td>
			<td> <a href="https://coderextreme.net/X3DJSONLD/bubbles.x3d">bubbles.x3d</a> </td>
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
			<td> <a href="https://coderextreme.net/X3DJSONLD/bubbles.x3d" target="_blank">https://coderextreme.net/X3DJSONLD/bubbles.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> description </i> </td>
			<td> not sure what this is </td>
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
		stylesheet to create Java source code from an <code>.x3d</code> scene.
	</p>

	* @author John Carlson
 */

public class bubbles
{
  /** Default constructor to create this object. */
  public bubbles ()
  {
    initialize();
  }
	
  /** Create and initialize the X3D model. */
  public final void initialize()
  {
  x3dModel = new X3DObject().setProfile("Immersive").setVersion("3.3")
  .setHead(new headObject()
    .addComponent(new componentObject().setName("EnvironmentalEffects").setLevel(1))
    .addComponent(new componentObject().setName("EnvironmentalEffects").setLevel(3))
    .addMeta(new metaObject().setName("title").setContent("bubbles.x3d"))
    .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
    .addMeta(new metaObject().setName("generator").setContent("manual"))
    .addMeta(new metaObject().setName("identifier").setContent("https://coderextreme.net/X3DJSONLD/bubbles.x3d"))
    .addMeta(new metaObject().setName("description").setContent("not sure what this is")))
  .setScene(new SceneObject()
    .addChild(new NavigationInfoObject().setType(new MFStringObject("\"EXAMINE\"")))
    .addChild(new ViewpointObject("Tour").setDescription("Tour Views"))
    .addChild(new ViewpointObject().setDescription("sphere in road").setPosition(0.0f,0.0f,4.0f))
    .addChild(new BackgroundObject().setBackUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_back.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_back.png\"")).setBottomUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_bottom.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_bottom.png\"")).setFrontUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_front.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_front.png\"")).setLeftUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_left.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_left.png\"")).setRightUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_right.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_right.png\"")).setTopUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_top.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_top.png\"")))
    .addChild(new TransformObject("Rose01")
      .addChild(new ShapeObject()
        .setGeometry(new SphereObject())
        .setAppearance(new AppearanceObject("_01_-_Default")
          .setMaterial(new MaterialObject().setSpecularColor(0.5f,0.5f,0.5f).setDiffuseColor(0.7f,0.7f,0.7f))
          .setTexture(new ComposedCubeMapTextureObject()
            .setBack(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_back.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_back.png\"")))
            .setBottom(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_bottom.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_bottom.png\"")))
            .setFront(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_front.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_front.png\"")))
            .setLeft(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_left.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_left.png\"")))
            .setRight(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_right.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_right.png\"")))
            .setTop(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/uffizi_cross/uffizi_top.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/uffizi_cross/uffizi_top.png\""))))
          .addShaders(new ComposedShaderObject("cobweb").setLanguage("GLSL")
            .addField(new fieldObject().setAccessType("inputOutput").setName("cube").setType("SFInt32").setValue("0"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("chromaticDispertion").setType("SFVec3f").setValue("0.98 1 1.033"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("bias").setType("SFFloat").setValue("0.5"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("scale").setType("SFFloat").setValue("0.5"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("power").setType("SFFloat").setValue("2"))
            .addParts(new ShaderPartObject().setUrl(new MFStringObject("\"../shaders/cobweb.vs\" \"https://coderextreme.net/X3DJSONLD/shaders/cobweb.vs\"")))
            .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject("\"../shaders/pc_bubbles.fs\" \"https://coderextreme.net/X3DJSONLD/shaders/pc_bubbles.fs\""))))
          .addShaders(new ComposedShaderObject("x3dom").setLanguage("GLSL")
            .addField(new fieldObject().setAccessType("inputOutput").setName("cube").setType("SFInt32").setValue("0"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("chromaticDispertion").setType("SFVec3f").setValue("0.98 1 1.033"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("bias").setType("SFFloat").setValue("0.5"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("scale").setType("SFFloat").setValue("0.5"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("power").setType("SFFloat").setValue("2"))
            .addParts(new ShaderPartObject().setUrl(new MFStringObject("\"../shaders/x3dom.vs\" \"https://coderextreme.net/X3DJSONLD/shaders/x3dom.vs\"")))
            .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject("\"../shaders/pc_bubbles.fs\" \"https://coderextreme.net/X3DJSONLD/shaders/pc_bubbles.fs\"")))))))
    .addChild(new TimeSensorObject("TourTime").setCycleInterval(5).setLoop(true))
    .addChild(new PositionInterpolatorObject("TourPosition").setKeyValue(new MFVec3fObject(new float[] {0.0f,0.0f,10.0f,0.0f,0.0f,-10.0f})).setKey(new float[] {0.0f,1.0f}))
    .addChild(new OrientationInterpolatorObject("TourOrientation").setKey(new float[] {0.0f,1.0f}).setKeyValue(new MFRotationObject(new float[] {0.0f,1.0f,0.0f,0.0f,0.0f,1.0f,0.0f,3.1416f})))
    .addChild(new ScriptObject("RandomTourTime").setSourceCode(
"<![CDATA[" + "\n" +
"ecmascript:" + "\n" + 
"               function set_cycle(value) {" + "\n" + 
"                        //var positions = [[0, 0, 10], [-10, 0, 0], [0, 0, -10], [10, 0, 0], [0, 0, 10], [0, 10, 0], [0, 0, 10], [0, -10, 0], [0, 0, 10]];" + "\n" + 
"                        //var orientations = [[0, 1, 0, 0], [0, 1, 0, -1.57], [0, 1, 0, 3.14], [0, 1, 0, 1.57], [0, 1, 0, 0] [1, 0, 0, -1.57], [0, 1, 0, 0], [1, 0, 0, 1.57], [0, 1, 0, 0]];" + "\n" + 
"                        //Browser.println(lastKey);" + "\n" + 
"                        var ov = lastKey;" + "\n" + 
"                        // Browser.println(ov);      " + "\n" + 
"                        //Browser.println(positions.length);                  " + "\n" + 
"                        do {" + "\n" + 
"                            lastKey = Math.round(Math.random()*(positions.length-1));" + "\n" + 
"                        } while (lastKey === ov);" + "\n" + 
"                        // Browser.println(lastKey);" + "\n" + 
"                        var vc = lastKey;" + "\n" + 
"                        " + "\n" + 
"                        // Browser.println(orientations[ov]);" + "\n" + 
"                        // Browser.println(orientations[vc]);" + "\n" + 
"                        orientation = new MFRotation();" + "\n" + 
"                        orientation[0] = new SFRotation(orientations[ov][0], orientations[ov][1], orientations[ov][2], orientations[ov][3]);" + "\n" + 
"                        orientation[1] = new SFRotation(orientations[vc][0], orientations[vc][1], orientations[vc][2], orientations[vc][3]);" + "\n" + 
"                        // Browser.println(positions[ov]);" + "\n" + 
"                        // Browser.println(positions[vc]);" + "\n" + 
"                        position = new MFVec3f();" + "\n" + 
"                        position[0] = new SFVec3f(positions[ov][0],positions[ov][1],positions[ov][2]);" + "\n" + 
"                        position[1] = new SFVec3f(positions[vc][0],positions[vc][1],positions[vc][2]);" + "\n" + 
"                    // }" + "\n" + 
"               }" + "]]>"
)
      .addField(new fieldObject().setAccessType("inputOnly").setName("set_cycle").setType("SFTime"))
      .addField(new fieldObject().setAccessType("inputOutput").setName("lastKey").setType("SFFloat").setValue("0"))
      .addField(new fieldObject().setAccessType("inputOutput").setName("orientations").setType("MFRotation").setValue("0 1 0 0 0 1 0 -1.57 0 1 0 3.14 0 1 0 1.57 0 1 0 0 1 0 0 -1.57 0 1 0 0 1 0 0 1.57 0 1 0 0"))
      .addField(new fieldObject().setAccessType("inputOutput").setName("positions").setType("MFVec3f").setValue("0 0 10 -10 0 0 0 0 -10 10 0 0 0 0 10 0 10 0 0 0 10 0 -10 0 0 0 10"))
      .addField(new fieldObject().setAccessType("outputOnly").setName("position").setType("MFVec3f"))
      .addField(new fieldObject().setAccessType("outputOnly").setName("orientation").setType("MFRotation")))
    .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("cycleTime").setToNode("RandomTourTime").setToField("set_cycle"))
    .addChild(new ROUTEObject().setFromNode("RandomTourTime").setFromField("orientation").setToNode("TourOrientation").setToField("keyValue"))
    .addChild(new ROUTEObject().setFromNode("RandomTourTime").setFromField("position").setToNode("TourPosition").setToField("keyValue"))
    .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("fraction_changed").setToNode("TourOrientation").setToField("set_fraction"))
    .addChild(new ROUTEObject().setFromNode("TourOrientation").setFromField("value_changed").setToNode("Tour").setToField("set_orientation"))
    .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("fraction_changed").setToNode("TourPosition").setToField("set_fraction"))
    .addChild(new ROUTEObject().setFromNode("TourPosition").setFromField("value_changed").setToNode("Tour").setToField("set_position")));
  }
  // end of initialize() method

  /** The initialized model object, created within initialize() method. */
  private X3DObject x3dModel;
  
  /** Provide a shallow copy of the X3D model.
   * @return bubbles model
   */
  public X3DObject getX3dModel()
  {	  
	  return x3dModel;
  }
  
  /** Indicate X3DJSAIL validation results for this X3D model.
   * @return validation results plus exception information, if any
   */
  public String validateSelf()
  {
	String       metaResult = new String();
	String validationResult = new String();
	String  exceptionResult = new String();
	try
	{
		initialize();
		
		if ((getX3dModel() == null) || (getX3dModel().getHead() == null))
		{
			validationResult = "empty scene, nothing to validate. " + x3dModel.validate();
			return validationResult;
		}
		// first list informational meta elements of interest
		for (metaObject meta : getX3dModel().getHead().getMetaList())
		{
			if (meta.getName().equals(metaObject.NAME_ERROR) ||
				meta.getName().equals(metaObject.NAME_WARNING) ||
				meta.getName().equals(metaObject.NAME_HINT) ||
				meta.getName().equals(metaObject.NAME_INFO) ||
				meta.getName().equals(metaObject.NAME_TODO))
			{
				metaResult += meta.toStringX3D();
			}
		}
		validationResult += x3dModel.validate(); // walk entire tree to validate correctness
	}
	catch (Exception e)
	{
		exceptionResult = e.getMessage(); // report exception failures, if any
	}
	if  (metaResult.isEmpty() && exceptionResult.isEmpty() && validationResult.isEmpty())
	     return "success";
	else
	{
		String returnMessage = metaResult;
		if  (!exceptionResult.isEmpty() && !validationResult.isEmpty())
			returnMessage += "\n*** ";
		returnMessage += exceptionResult;
		if  (exceptionResult.isEmpty() && !validationResult.isEmpty())
			returnMessage = "\n" + returnMessage; // skip line before meta tags, etc.
		returnMessage += validationResult;
		return returnMessage;
	}
  }
    /** Default main() method provided for test purposes.
     * @param argv input parameters
     */
    public static void main(String argv[])
    {
		bubbles testObject = new bubbles();
		System.out.println ("bubbles execution self-validation test results: " + testObject.validateSelf());
	}
}