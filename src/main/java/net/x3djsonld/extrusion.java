package net.x3djsonld;

import java.util.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Grouping.*;
import org.web3d.x3d.jsail.Scripting.*;
import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.jsail.Time.*;

// Javadoc annotations follow, see below for source.
/**
 * <p> beginnings of a force directed graph in 3D. </p>
 <p> Related links: extrusion.java source, <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html" target="_blank">X3D Resources</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a> and <a href="http://www.web3d.org/x3d/content/X3dTooltips.html" target="_blank">X3D Tooltips</a>. </p>
	<table style="color:black; border:0px solid; border-spacing:10px 0px;" summary="Scene Metadata">
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center; padding:10px 0px;"><i>meta tags</i></td>
			<td style="text-align:left;   padding:10px 0px;">net.x3djsonld.extrusion&nbsp; Document Metadata </td>
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
			<td> <a href="http://coderextreme.net/X3DJSONLD/force.x3d">force.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> identifier </i> </td>
			<td> <a href="http://coderextreme.net/X3DJSONLD/force.x3d" target="_blank">http://coderextreme.net/X3DJSONLD/force.x3d</a> </td>
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
		stylesheet to create Java source code from an <code>.x3d</code> scene.
	</p>

	* @author John W Carlson
 */

public class extrusion
{
  /** Default constructor to create this object. */
  public extrusion ()
  {
    initialize();
  }
	
  /** Create and initialize the X3D model. */
  public final void initialize()
  {
  x3dModel = new X3DObject().setProfile("Immersive").setVersion("3.3")
  .setHead(new headObject()
    .addMeta(new metaObject().setName("creator").setContent("John W Carlson"))
    .addMeta(new metaObject().setName("created").setContent("December 13 2015"))
    .addMeta(new metaObject().setName("title").setContent("force.x3d"))
    .addMeta(new metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/force.x3d"))
    .addMeta(new metaObject().setName("description").setContent("beginnings of a force directed graph in 3D"))
    .addMeta(new metaObject().setName("generator").setContent("Vim, X3D-Edit, https://savage.nps.edu/X3D-Edit")))
  .setScene(new SceneObject()
    .addChild(new GroupObject()
      .addChild(new ShapeObject()
        .setGeometry(new ExtrusionObject("extrusion").setSpine(new MFVec3fObject(new float[] {-50.0f,-50.0f,0.0f,50.0f,50.0f,0.0f})).setCreaseAngle(0.785f).setCrossSection(extrusion_5_8_crossSection))
        .setAppearance(new AppearanceObject()
          .setMaterial(new MaterialObject().setDiffuseColor(0.0f,1.0f,0.0f))))
      .addChild(new TimeSensorObject("TourTime").setLoop(true))
      .addChild(new ScriptObject("MoveCylinder").setSourceCode(
"<![CDATA[" + "\n" +
"\n" + 
"\n" + 
"ecmascript:" + "\n" + 
"\n" + 
"                function set_cycle(value) {" + "\n" + 
"                        Browser.print(value);" + "\n" + 
"                        var endA = new SFVec3f(spine[0][0]*Math.random()*2, spine[0][1]*Math.random()*2, spine[0][2]*Math.random()*2);" + "\n" + 
"                        var endB = new SFVec3f(spine[1][0]*Math.random()*2, spine[1][1]*Math.random()*2, spine[1][2]*Math.random()*2);" + "\n" + 
"		        spine = new MFVec3f(endA, endB);" + "\n" + 
"                }" + "\n" + 
"                function set_spine(value) {" + "\n" + 
"                    spine = value;" + "\n" + 
"                }" + "\n" + "]]>"
)
        .addField(new fieldObject().setAccessType("inputOnly").setName("set_cycle").setType("SFTime"))
        .addField(new fieldObject().setAccessType("inputOutput").setName("spine").setType("MFVec3f").setValue("-50 -50 0 50 50 0")))
      .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("cycleTime").setToNode("MoveCylinder").setToField("set_cycle"))
      .addChild(new ROUTEObject().setFromNode("MoveCylinder").setFromField("spine").setToNode("extrusion").setToField("set_spine"))));
  }
  // end of initialize() method

	/** Large attribute array: Extrusion DEF='extrusion' crossSection field, scene-graph level=5, element #8, 34 total numbers made up of 17 2-tuple values */
	private MFVec2fObject extrusion_5_8_crossSection = new MFVec2fObject() /* splitting up long array to improve readability */
	.append(new MFVec2fObject(new float[] {1.00f,0.00f,0.92f,-0.38f,0.71f,-0.71f,0.38f,-0.92f,0.00f,-1.00f,-0.38f,-0.92f,-0.71f,-0.71f,-0.92f,-0.38f,-1.00f,-0.00f,-0.92f,0.38f}))
	.append(new MFVec2fObject(new float[] {-0.71f,0.71f,-0.38f,0.92f,0.00f,1.00f,0.38f,0.92f,0.71f,0.71f,0.92f,0.38f,1.00f,0.00f}));

  /** The initialized model object, created within initialize() method. */
  private X3DObject x3dModel;
  
  /** Provide a shallow copy of the X3D model.
   * @return extrusion model
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
		extrusion testObject = new extrusion();
		System.out.println ("extrusion execution self-validation test results: " + testObject.validateSelf());
	}
}