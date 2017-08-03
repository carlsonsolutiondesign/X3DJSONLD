package net.x3djsonld.data;

import java.util.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Navigation.*;
import org.web3d.x3d.jsail.Rendering.*;
import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.jsail.Texturing.*;

// Javadoc annotations follow, see below for source.
/**
 * <p> Test of browser ability to map the entire portion of an PixelTexture onto an IndexedFaceSet geometry. Four equal sized red (bottom left), green (bottom right) yellow (top left) and white (top right) squares in the pixel texture map all the faces of the cube. </p>
 <p> Related links: <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole.java">indexedfaceset_pixeltexture_whole.java</a> source, <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_wholeIndex.html" target="_top">indexedfaceset_pixeltexture_whole catalog page</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html" target="_blank">X3D Resources</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>, and <a href="http://www.web3d.org/x3d/content/X3dTooltips.html" target="_blank">X3D Tooltips</a>. </p>
	<table style="color:black; border:0px solid; border-spacing:10px 0px;" summary="Scene Metadata">
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center; padding:10px 0px;"><i>meta tags</i></td>
			<td style="text-align:left;   padding:10px 0px;">&nbsp; Document Metadata </td>
		</tr>

		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> title </i> </td>
			<td> <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole.x3d">indexedfaceset_pixeltexture_whole.x3d</a> </td>
		</tr>
		<tr style="color:burntorange">
			<td style="text-align:right; vertical-align: text-top;"> <i> warning </i> </td>
			<td> file did not transform to vrml97 </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> Image </i> </td>
			<td> <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole-front.jpg">indexedfaceset_pixeltexture_whole-front.jpg</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> Image </i> </td>
			<td> <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole-rear.jpg">indexedfaceset_pixeltexture_whole-rear.jpg</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> Image </i> </td>
			<td> <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole-top.jpg">indexedfaceset_pixeltexture_whole-top.jpg</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> Image </i> </td>
			<td> <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole-bottom.jpg">indexedfaceset_pixeltexture_whole-bottom.jpg</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> Image </i> </td>
			<td> <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole-left.jpg">indexedfaceset_pixeltexture_whole-left.jpg</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> Image </i> </td>
			<td> <a href="../../../../GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole-right.jpg">indexedfaceset_pixeltexture_whole-right.jpg</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> reference </i> </td>
			<td> <a href="http://www.nist.gov/vrml.html" target="_blank">http://www.nist.gov/vrml.html</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> reference </i> </td>
			<td> <a href="http://www.itl.nist.gov/div897/ctg/vrml/vrml.html" target="_blank">http://www.itl.nist.gov/div897/ctg/vrml/vrml.html</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> creator </i> </td>
			<td> <a href="http://www.itl.nist.gov/div897/ctg/vrml/members.html" target="_blank">http://www.itl.nist.gov/div897/ctg/vrml/members.html</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> disclaimer </i> </td>
			<td> This file was provided by the National Institute of Standards and Technology, and is part of the X3D Conformance Test Suite, available at <a href="http://www.nist.gov/vrml.html" target="_blank">http://www.nist.gov/vrml.html</a> The information contained within this file is provided for use in establishing conformance to the ISO VRML97 Specification. Conformance to this test does not imply recommendation or endorsement by the National Institute of Standards and Technology. This software can be redistributed and/or modified freely provided that any derivative works bear some notice that they are derived from it, and any modified versions bear some notice that they have been modified. </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> info </i> </td>
			<td> Correct definition and compliance of this conformance scene is maintained by the X3D Working Group, <a href="http://www.web3d.org/working-groups/x3d" target="_blank">http://www.web3d.org/working-groups/x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> translator </i> </td>
			<td> Michael Kass NIST, Don Brutzman NPS </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> translated </i> </td>
			<td> 21 January 2001 </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> modified </i> </td>
			<td> 13 January 2014 </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> description </i> </td>
			<td> Test of browser ability to map the entire portion of an PixelTexture onto an IndexedFaceSet geometry. Four equal sized red (bottom left), green (bottom right) yellow (top left) and white (top right) squares in the pixel texture map all the faces of the cube. </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> identifier </i> </td>
			<td> <a href="http://www.web3d.org/x3d/content/examples/ConformanceNist/GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole.x3d" target="_blank">http://www.web3d.org/x3d/content/examples/ConformanceNist/GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> generator </i> </td>
			<td> Vrml97ToX3dNist, <a href="http://ovrt.nist.gov/v2_x3d.html" target="_blank">http://ovrt.nist.gov/v2_x3d.html</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> generator </i> </td>
			<td> X3D-Edit 3.3, <a href="https://savage.nps.edu/X3D-Edit" target="_blank">https://savage.nps.edu/X3D-Edit</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> license </i> </td>
			<td> <a href="../../../../GeometricProperties/TextureCoordinate/../../license.html">../../license.html</a> </td>
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

	* @author http://www.itl.nist.gov/div897/ctg/vrml/members.html
 */

public class indexedfaceset_pixeltexture_whole
{
  /** Default constructor to create this object. */
  public indexedfaceset_pixeltexture_whole ()
  {
    initialize();
  }
	
  /** Create and initialize the X3D model for this object. */
  public final void initialize()
  {
  x3dModel = new X3DObject().setProfile("Interchange").setVersion("3.0")
  .setHead(new headObject()
    .addMeta(new metaObject().setName("title").setContent("indexedfaceset_pixeltexture_whole.x3d"))
    .addMeta(new metaObject().setName("warning").setContent("file did not transform to vrml97"))
    .addMeta(new metaObject().setName("Image").setContent("indexedfaceset_pixeltexture_whole-front.jpg"))
    .addMeta(new metaObject().setName("Image").setContent("indexedfaceset_pixeltexture_whole-rear.jpg"))
    .addMeta(new metaObject().setName("Image").setContent("indexedfaceset_pixeltexture_whole-top.jpg"))
    .addMeta(new metaObject().setName("Image").setContent("indexedfaceset_pixeltexture_whole-bottom.jpg"))
    .addMeta(new metaObject().setName("Image").setContent("indexedfaceset_pixeltexture_whole-left.jpg"))
    .addMeta(new metaObject().setName("Image").setContent("indexedfaceset_pixeltexture_whole-right.jpg"))
    .addMeta(new metaObject().setName("reference").setContent("http://www.nist.gov/vrml.html"))
    .addMeta(new metaObject().setName("reference").setContent("http://www.itl.nist.gov/div897/ctg/vrml/vrml.html"))
    .addMeta(new metaObject().setName("creator").setContent("http://www.itl.nist.gov/div897/ctg/vrml/members.html"))
    .addMeta(new metaObject().setName("disclaimer").setContent("This file was provided by the National Institute of Standards and Technology, and is part of the X3D Conformance Test Suite, available at http://www.nist.gov/vrml.html The information contained within this file is provided for use in establishing conformance to the ISO VRML97 Specification. Conformance to this test does not imply recommendation or endorsement by the National Institute of Standards and Technology. This software can be redistributed and/or modified freely provided that any derivative works bear some notice that they are derived from it, and any modified versions bear some notice that they have been modified."))
    .addMeta(new metaObject().setName("info").setContent("Correct definition and compliance of this conformance scene is maintained by the X3D Working Group, http://www.web3d.org/working-groups/x3d"))
    .addMeta(new metaObject().setName("translator").setContent("Michael Kass NIST, Don Brutzman NPS"))
    .addMeta(new metaObject().setName("translated").setContent("21 January 2001"))
    .addMeta(new metaObject().setName("modified").setContent("13 January 2014"))
    .addMeta(new metaObject().setName("description").setContent("Test of browser ability to map the entire portion of an PixelTexture onto an IndexedFaceSet geometry. Four equal sized red (bottom left), green (bottom right) yellow (top left) and white (top right) squares in the pixel texture map all the faces of the cube."))
    .addMeta(new metaObject().setName("identifier").setContent("http://www.web3d.org/x3d/content/examples/ConformanceNist/GeometricProperties/TextureCoordinate/indexedfaceset_pixeltexture_whole.x3d"))
    .addMeta(new metaObject().setName("generator").setContent("Vrml97ToX3dNist, http://ovrt.nist.gov/v2_x3d.html"))
    .addMeta(new metaObject().setName("generator").setContent("X3D-Edit 3.3, https://savage.nps.edu/X3D-Edit"))
    .addMeta(new metaObject().setName("license").setContent("../../license.html")))
  .setScene(new SceneObject()
    .addChild(new ViewpointObject().setDescription("Front View"))
    .addChild(new ViewpointObject().setDescription("Rear View").setPosition(0.0f,0.0f,-10.0f).setOrientation(0.0f,1.0f,0.0f,3.14f))
    .addChild(new ViewpointObject().setDescription("Top View").setPosition(0.0f,10.0f,0.0f).setOrientation(1.0f,0.0f,0.0f,-1.57f))
    .addChild(new ViewpointObject().setDescription("Bottom View").setPosition(0.0f,-10.0f,0.0f).setOrientation(1.0f,0.0f,0.0f,1.57f))
    .addChild(new ViewpointObject().setDescription("Right View").setOrientation(0.0f,1.0f,0.0f,1.57f).setPosition(10.0f,0.0f,0.0f))
    .addChild(new ViewpointObject().setDescription("Left View").setPosition(-10.0f,0.0f,0.0f).setOrientation(0.0f,1.0f,0.0f,-1.57f))
    .addChild(new NavigationInfoObject().setType(new MFStringObject("\"EXAMINE\"")))
    .addChild(new ShapeObject()
      .setAppearance(new AppearanceObject()
        .setMaterial(new MaterialObject())
        .setTexture(new PixelTextureObject().setImage(new int[] {2,2,4,0xFF0000FF,0x00FF00FF,0xFFFFFFFF,0xFFFF00FF})))
      .setGeometry(new IndexedFaceSetObject().setCreaseAngle(0.5f).setColorPerVertex(false).setTexCoordIndex(new int[] {0,1,3,2,-1,0,1,3,2,-1,0,1,3,2,-1,0,1,3,2,-1,0,1,3,2,-1,0,1,3,2,-1}).setCoordIndex(new int[] {0,1,3,2,-1,4,5,7,6,-1,6,7,1,0,-1,2,3,5,4,-1,6,0,2,4,-1,1,7,5,3,-1})
        .setColor(new ColorObject().setColor(new MFColorObject(new float[] {0.0f,1.0f,0.0f,0.0f,1.0f,0.0f,0.0f,1.0f,0.0f,0.0f,1.0f,0.0f,0.0f,1.0f,0.0f,0.0f,1.0f,0.0f})))
        .setCoord(new CoordinateObject().setPoint(new MFVec3fObject(new float[] {-2.0f,1.0f,1.0f,-2.0f,-1.0f,1.0f,2.0f,1.0f,1.0f,2.0f,-1.0f,1.0f,2.0f,1.0f,-1.0f,2.0f,-1.0f,-1.0f,-2.0f,1.0f,-1.0f,-2.0f,-1.0f,-1.0f})))
        .setTexCoord(new TextureCoordinateObject().setPoint(new MFVec2fObject(new float[] {0.0f,1.0f,0.0f,0.0f,1.0f,1.0f,1.0f,0.0f}))))));
  }
  // end of initialize() method

  /** The initialized model object, created within initialize() method. */
  private X3DObject x3dModel;
  
  /** Provide a 
   * <a href="https://dzone.com/articles/java-copy-shallow-vs-deep-in-which-you-will-swim" target="_blank">shallow copy</a>
   * of the X3D model.
   * @see <a href="http://www.web3d.org/specifications/java/javadoc/org/web3d/x3d/jsail/Core/X3DObject.html">X3DObject</a>
   * @return indexedfaceset_pixeltexture_whole model
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
		X3DObject exampleObject = new indexedfaceset_pixeltexture_whole().getX3dModel();
		
		exampleObject.handleArguments(argv);
		System.out.print("indexedfaceset_pixeltexture_whole self-validation test results: ");
		String validationResults = exampleObject.validationReport();
		System.out.println(validationResults);
	}
}
