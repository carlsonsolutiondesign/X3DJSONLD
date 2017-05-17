package net.x3djsonld;

import java.util.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.CubeMapTexturing.*;
import org.web3d.x3d.jsail.EnvironmentalEffects.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Grouping.*;
import org.web3d.x3d.jsail.Navigation.*;
import org.web3d.x3d.jsail.Shaders.*;
import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.jsail.Texturing.*;

// Javadoc annotations follow, see below for source.
/**
 * <p> a sphere. </p>
 <p> Related links: geo.java source, <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html" target="_blank">X3D Resources</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a> and <a href="http://www.web3d.org/x3d/content/X3dTooltips.html" target="_blank">X3D Tooltips</a>. </p>
	<table style="color:black; border:0px solid; border-spacing:10px 0px;" summary="Scene Metadata">
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center; padding:10px 0px;"><i>meta tags</i></td>
			<td style="text-align:left;   padding:10px 0px;">net.x3djsonld.geo&nbsp; Document Metadata </td>
		</tr>

		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> title </i> </td>
			<td> <a href="http://coderextreme.net/X3DJSONLD/geo.x3d">geo.x3d</a> </td>
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
			<td> <a href="http://coderextreme.net/X3DJSONLD/geo.x3d" target="_blank">http://coderextreme.net/X3DJSONLD/geo.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> description </i> </td>
			<td> a sphere </td>
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

public class geo
{
  /** Default constructor to create this object. */
  public geo ()
  {
    initialize();
  }
	
  /** Create and initialize the X3D model. */
  public final void initialize()
  {
  x3dModel = new X3DObject().setProfile("Immersive").setVersion("3.3")
  .setHead(new headObject()
    .addMeta(new metaObject().setName("title").setContent("geo.x3d"))
    .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
    .addMeta(new metaObject().setName("generator").setContent("manual"))
    .addMeta(new metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/geo.x3d"))
    .addMeta(new metaObject().setName("description").setContent("a sphere")))
  .setScene(new SceneObject()
    .addChild(new NavigationInfoObject().setType(new MFStringObject("\"EXAMINE\"")))
    .addChild(new ViewpointObject("Tour").setDescription("Tour Views"))
    .addChild(new ViewpointObject().setDescription("sphere in road").setPosition(0.0f,0.0f,4.0f))
    .addChild(new BackgroundObject().setBackUrl(new MFStringObject("\"bBK.png\" \"http://coderextreme.net/bug/bBK.png\"")).setBottomUrl(new MFStringObject("\"bBT.png\" \"http://coderextreme.net/bug/bBT.png\"")).setFrontUrl(new MFStringObject("\"bFR.png\" \"http://coderextreme.net/bug/bFR.png\"")).setLeftUrl(new MFStringObject("\"bLF.png\" \"http://coderextreme.net/bug/bLF.png\"")).setRightUrl(new MFStringObject("\"bRT.png\" \"http://coderextreme.net/bug/bRT.png\"")).setTopUrl(new MFStringObject("\"bTP.png\" \"http://coderextreme.net/bug/bTP.png\"")))
    .addChild(new TransformObject("Rose01")
      .addChild(new ShapeObject()
        .setGeometry(new SphereObject())
        .setAppearance(new AppearanceObject("_01_-_Default")
          .setMaterial(new MaterialObject().setSpecularColor(0.5f,0.5f,0.5f).setDiffuseColor(0.7f,0.7f,0.7f))
          .setTexture(new ComposedCubeMapTextureObject()
            .setBack(new ImageTextureObject().setUrl(new MFStringObject("\"bBK.png\" \"http://coderextreme.net/bug/bBK.png\"")))
            .setBottom(new ImageTextureObject().setUrl(new MFStringObject("\"bBT.png\" \"http://coderextreme.net/bug/bBT.png\"")))
            .setFront(new ImageTextureObject().setUrl(new MFStringObject("\"bFR.png\" \"http://coderextreme.net/bug/bFR.png\"")))
            .setLeft(new ImageTextureObject().setUrl(new MFStringObject("\"bLF.png\" \"http://coderextreme.net/bug/bLF.png\"")))
            .setRight(new ImageTextureObject().setUrl(new MFStringObject("\"bRT.png\" \"http://coderextreme.net/bug/bRT.png\"")))
            .setTop(new ImageTextureObject().setUrl(new MFStringObject("\"bTP.png\" \"http://coderextreme.net/bug/bTP.png\""))))
          .addShaders(new ComposedShaderObject("cobweb").setLanguage("GLSL")
            .addField(new fieldObject().setAccessType("inputOutput").setName("cube").setType("SFInt32").setValue("0"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("chromaticDispertion").setType("SFVec3f").setValue("0.98 1 1.033"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("bias").setType("SFFloat").setValue("0.5"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("scale").setType("SFFloat").setValue("0.5"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("power").setType("SFFloat").setValue("2"))
            .addParts(new ShaderPartObject().setUrl(new MFStringObject("\"cobweb.vs\" \"http://coderextreme.net/X3DJSONLD/cobweb.vs\"")))
            .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject("\"pc_bubbles.fs\" \"http://coderextreme.net/X3DJSONLD/pc_bubbles.fs\""))))
          .addShaders(new ComposedShaderObject("x3dom").setLanguage("GLSL")
            .addField(new fieldObject().setAccessType("inputOutput").setName("cube").setType("SFInt32").setValue("0"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("chromaticDispertion").setType("SFVec3f").setValue("0.98 1 1.033"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("bias").setType("SFFloat").setValue("0.5"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("scale").setType("SFFloat").setValue("0.5"))
            .addField(new fieldObject().setAccessType("inputOutput").setName("power").setType("SFFloat").setValue("2"))
            .addParts(new ShaderPartObject().setUrl(new MFStringObject("\"x3dom.vs\" \"http://coderextreme.net/X3DJSONLD/x3dom.vs\"")))
            .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject("\"pc_bubbles.fs\" \"http://coderextreme.net/X3DJSONLD/pc_bubbles.fs\""))))))));
  }
  // end of initialize() method

  /** The initialized model object, created within initialize() method. */
  private X3DObject x3dModel;
  
  /** Provide a shallow copy of the X3D model.
   * @return geo model
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
		geo testObject = new geo();
		System.out.println ("geo execution self-validation test results: " + testObject.validateSelf());
	}
}