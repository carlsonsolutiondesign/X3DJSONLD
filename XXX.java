import java.util.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.CubeMapTexturing.*;
import org.web3d.x3d.jsail.EnvironmentalEffects.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Grouping.*;
import org.web3d.x3d.jsail.Navigation.*;
import org.web3d.x3d.jsail.Scripting.*;
import org.web3d.x3d.jsail.Shaders.*;
import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.jsail.Texturing.*;
import org.web3d.x3d.jsail.Time.*;

// Javadoc annotations follow, see below for source.
/**
 * <p> 3 prismatic spheres </p>
 <p> Related links: XXX.java source, <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html" target="_blank">X3D Resources</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a> and <a href="http://www.web3d.org/x3d/content/X3dTooltips.html" target="_blank">X3D Tooltips</a>. </p>
	<table style="color:black; border:0px solid; border-spacing:10px 0px;" summary="Scene Metadata">
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center; padding:10px 0px;"><i>meta tags</i></td>
			<td style="text-align:left;   padding:10px 0px;">XXX&nbsp; Document Metadata </td>
		</tr>

		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> title </i> </td>
			<td> <a href="http://coderextreme.net/X3DJSONLD/bub.x3d">bub.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> creator </i> </td>
			<td> John Carlson </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> description </i> </td>
			<td> 3 prismatic spheres </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> generator </i> </td>
			<td> X3D-Edit, <a href="https://savage.nps.edu/X3D-Edit" target="_blank">https://savage.nps.edu/X3D-Edit</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> identifier </i> </td>
			<td> <a href="http://coderextreme.net/X3DJSONLD/bub.x3d" target="_blank">http://coderextreme.net/X3DJSONLD/bub.x3d</a> </td>
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

public class XXX
{
  /** Default constructor to create this object. */
  public XXX ()
  {
    initialize();
  }
	
  /** Create and initialize the X3D model. */
  public final void initialize()
  {
  x3dModel = new X3DObject().setProfile("Immersive").setVersion("3.3")
  .setHead(new headObject()
    .addMeta(new metaObject().setName("title").setContent("bub.x3d"))
    .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
    .addMeta(new metaObject().setName("description").setContent("3 prismatic spheres"))
    .addMeta(new metaObject().setName("generator").setContent("X3D-Edit, https://savage.nps.edu/X3D-Edit"))
    .addMeta(new metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/bub.x3d")))
  .setScene(new SceneObject()
    .addChild(new NavigationInfoObject())
    .addChild(new BackgroundObject().setBackUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_back.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_back.png\"")).setBottomUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_bottom.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_bottom.png\"")).setFrontUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_front.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_front.png\"")).setLeftUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_left.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_left.png\"")).setRightUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_right.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_right.png\"")).setTopUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_top.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_top.png\"")))
    .addChild(new ViewpointObject().setPosition(0.0f,0.0f,20.0f).setDescription("Look at the bubbles flying"))
    .addChild(new ProtoDeclareObject().setName("Bubble")
      .setProtoBody(new ProtoBodyObject()
        .addChild(new TransformObject("transform")
          .addChild(new ShapeObject("myShape")
            .setAppearance(new AppearanceObject()
              .setMaterial(new MaterialObject().setSpecularColor(0.5f,0.5f,0.5f).setDiffuseColor(0.7f,0.7f,0.7f))
              .setShaders(new ComposedShaderObject("cobweb").setLanguage("GLSL")
                .addParts(new ShaderPartObject().setUrl(new MFStringObject("\"cobweb.vs\" \"http://coderextreme.net/X3DJSONLD/cobweb.vs\"")))
                .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject("\"pc_bubbles.fs\" \"http://coderextreme.net/X3DJSONLD/pc.fs\"")))
                .addField(new fieldObject().setAccessType("inputOutput").setName("cube").setType("SFNode")
                  .addChild(new ComposedCubeMapTextureObject().setUSE("texture")))
                .addField(new fieldObject().setAccessType("inputOutput").setName("chromaticDispertion").setType("SFVec3f").setValue("0.98 1 1.033"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("bias").setType("SFFloat").setValue("0.5"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("scale").setType("SFFloat").setValue("0.5"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("power").setType("SFFloat").setValue("2.0")))
              .setTexture(new ComposedCubeMapTextureObject("texture")
                .addTexture(new ImageTextureObject().setUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_back.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_back.png\"")))
                .addTexture(new ImageTextureObject().setUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_bottom.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_bottom.png\"")))
                .addTexture(new ImageTextureObject().setUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_front.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_front.png\"")))
                .addTexture(new ImageTextureObject().setUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_left.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_left.png\"")))
                .addTexture(new ImageTextureObject().setUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_right.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_right.png\"")))
                .addTexture(new ImageTextureObject().setUrl(new MFStringObject("\"cubemap/all_probes/stpeters_cross/stpeters_top.png\" \"http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_top.png\""))))
              .addComments("  ")
              .addComments(" <ComposedShader DEF='gl' language=\"GLSL\"> ")
              .addComments(" <field name='cube' type='SFInt32' accessType=\"inputOutput\" value='0'/> ")
              .addComments(" <field name='chromaticDispertion' type='SFVec3f' accessType=\"inputOutput\" value='0.98 1.0 1.033'/> ")
              .addComments(" <field name='bias' type='SFFloat' accessType=\"inputOutput\" value='0.5'/> ")
              .addComments(" <field name='scale' type='SFFloat' accessType=\"inputOutput\" value='0.5'/> ")
              .addComments(" <field name='power' type='SFFloat' accessType=\"inputOutput\" value='2.0'/> ")
              .addComments("  ")
              .addComments(" <ShaderPart url='\"gl.vs\" \"http://coderextreme.net/X3DJSONLD/gl.vs\"' type='VERTEX'></ShaderPart> ")
              .addComments(" <ShaderPart url='\"pc_bubbles.fs\" \"http://coderextreme.net/X3DJSONLD/pc_bubbles.fs\"' type='FRAGMENT'></ShaderPart> ")
              .addComments(" </ComposedShader> ")
              .addComments(" <ComposedShader DEF='freewrl' language=\"GLSL\"> ")
              .addComments(" <field name='fw_textureCoodGenType' type='SFInt32' accessType=\"inputOutput\" value='0'/> ")
              .addComments(" <field name='chromaticDispertion' type='SFVec3f' accessType=\"inputOutput\" value='0.98 1.0 1.033'/> ")
              .addComments(" <field name='bias' type='SFFloat' accessType=\"inputOutput\" value='0.5'/> ")
              .addComments(" <field name='scale' type='SFFloat' accessType=\"inputOutput\" value='0.5'/> ")
              .addComments(" <field name='power' type='SFFloat' accessType=\"inputOutput\" value='2.0'/> ")
              .addComments("  ")
              .addComments(" <ShaderPart url='\"freewrl.vs\" \"http://coderextreme.net/X3DJSONLD/freewrl.vs\"' type='VERTEX'></ShaderPart> ")
              .addComments(" <ShaderPart url='\"pc_bubbles.fs\" \"http://coderextreme.net/X3DJSONLD/pc_bubbles.fs\"' type='FRAGMENT'></ShaderPart> ")
              .addComments(" </ComposedShader> ")
              .addComments(" <ComposedShader DEF='x3dom' language=\"GLSL\"> ")
              .addComments(" <field name='cube' type='SFInt32' accessType=\"inputOutput\" value='0'/> ")
              .addComments(" <field name='chromaticDispertion' type='SFVec3f' accessType=\"inputOutput\" value='0.98 1.0 1.033'/> ")
              .addComments(" <field name='bias' type='SFFloat' accessType=\"inputOutput\" value='0.5'/> ")
              .addComments(" <field name='scale' type='SFFloat' accessType=\"inputOutput\" value='0.5'/> ")
              .addComments(" <field name='power' type='SFFloat' accessType=\"inputOutput\" value='2.0'/> ")
              .addComments("  ")
              .addComments(" <ShaderPart url='\"x3dom.vs\" \"http://coderextreme.net/X3DJSONLD/x3dom.vs\"' type='VERTEX'></ShaderPart> ")
              .addComments(" <ShaderPart url='\"pc_bubbles.fs\" \"http://coderextreme.net/X3DJSONLD/pc_bubbles.fs\"' type='FRAGMENT'></ShaderPart> ")
              .addComments(" </ComposedShader> ")
              .addComments(" <ComposedShader DEF='instant' language=\"GLSL\"> ")
              .addComments(" <field name='cube' type='SFInt32' accessType=\"inputOutput\" value='0'/> ")
              .addComments(" <field name='chromaticDispertion' type='SFVec3f' accessType=\"inputOutput\" value='0.98 1.0 1.033'/> ")
              .addComments(" <field name='bias' type='SFFloat' accessType=\"inputOutput\" value='0.5'/> ")
              .addComments(" <field name='scale' type='SFFloat' accessType=\"inputOutput\" value='0.5'/> ")
              .addComments(" <field name='power' type='SFFloat' accessType=\"inputOutput\" value='2.0'/> ")
              .addComments("  ")
              .addComments(" <ShaderPart url='\"instant.vs\" \"http://coderextreme.net/X3DJSONLD/instant.vs\"' type='VERTEX'></ShaderPart> ")
              .addComments(" <ShaderPart url='\"pc_bubbles.fs\" \"http://coderextreme.net/X3DJSONLD/pc_bubbles.fs\"' type='FRAGMENT'></ShaderPart> ")
              .addComments(" </ComposedShader> "))
            .setGeometry(new SphereObject())))
        .addChild(new ScriptObject("Bounce")
          .addField(new fieldObject().setAccessType("inputOutput").setName("translation").setType("SFVec3f").setValue("0 0 0"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("velocity").setType("SFVec3f").setValue("0 0 0"))
          .addField(new fieldObject().setAccessType("inputOnly").setName("set_fraction").setType("SFTime")))
        .addChild(new TimeSensorObject("TourTime").setCycleInterval(0.15).setLoop(true))
        .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("cycleTime").setToNode("Bounce").setToField("set_fraction"))
        .addChild(new ROUTEObject().setFromNode("Bounce").setFromField("translation_changed").setToNode("transform").setToField("set_translation"))))
    .addChild(new ProtoInstanceObject().setName("Bubble"))
    .addChild(new ProtoInstanceObject().setName("Bubble"))
    .addChild(new ProtoInstanceObject().setName("Bubble")));
  }
  // end of initialize() method
			
  /** The initialized model object, created within initialize() method. */
  private X3DObject x3dModel;
  
  /** Provide a shallow copy of the X3D model.
   * @return XXX model
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
		XXX testObject = new XXX();
		System.out.println ("XXX execution self-validation test results: " + testObject.validateSelf());
	}
}
