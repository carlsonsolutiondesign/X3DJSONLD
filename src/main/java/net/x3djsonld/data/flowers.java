package net.x3djsonld.data;

import java.util.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.CubeMapTexturing.*;
import org.web3d.x3d.jsail.EnvironmentalEffects.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Grouping.*;
import org.web3d.x3d.jsail.Navigation.*;
import org.web3d.x3d.jsail.Rendering.*;
import org.web3d.x3d.jsail.Scripting.*;
import org.web3d.x3d.jsail.Shaders.*;
import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.jsail.Sound.*;
import org.web3d.x3d.jsail.Texturing.*;
import org.web3d.x3d.jsail.Time.*;

// Javadoc annotations follow, see below for source.
/**
 * <p> 5 or more prismatic flowers. </p>
 <p> Related links: flowers.java source, <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html" target="_blank">X3D Resources</a>, <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>, and <a href="http://www.web3d.org/x3d/content/X3dTooltips.html" target="_blank">X3D Tooltips</a>. </p>
	<table style="color:black; border:0px solid; border-spacing:10px 0px;" summary="Scene Metadata">
		<tr style="background-color:silver; border-color:silver;">
			<td style="text-align:center; padding:10px 0px;"><i>meta tags</i></td>
			<td style="text-align:left;   padding:10px 0px;">net.x3djsonld.data.flowers&nbsp; Document Metadata </td>
		</tr>

		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> title </i> </td>
			<td> <a href="https://coderextreme.net/X3DJSONLD/flowers.x3d">flowers.x3d</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> creator </i> </td>
			<td> John Carlson </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> description </i> </td>
			<td> 5 or more prismatic flowers </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> generator </i> </td>
			<td> X3D-Edit, <a href="https://savage.nps.edu/X3D-Edit" target="_blank">https://savage.nps.edu/X3D-Edit</a> </td>
		</tr>
		<tr>
			<td style="text-align:right; vertical-align: text-top;"> <i> identifier </i> </td>
			<td> <a href="https://coderextreme.net/X3DJSONLD/flowers.x3d" target="_blank">https://coderextreme.net/X3DJSONLD/flowers.x3d</a> </td>
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

public class flowers
{
  /** Default constructor to create this object. */
  public flowers ()
  {
    initialize();
  }
	
  /** Create and initialize the X3D model for this object. */
  public final void initialize()
  {
  x3dModel = new X3DObject().setProfile("Immersive").setVersion("3.3")
  .setHead(new headObject()
    .addComponent(new componentObject().setName("Shaders").setLevel(1))
    .addComponent(new componentObject().setName("CubeMapTexturing").setLevel(1))
    .addMeta(new metaObject().setName("title").setContent("flowers.x3d"))
    .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
    .addMeta(new metaObject().setName("description").setContent("5 or more prismatic flowers"))
    .addMeta(new metaObject().setName("generator").setContent("X3D-Edit, https://savage.nps.edu/X3D-Edit"))
    .addMeta(new metaObject().setName("identifier").setContent("https://coderextreme.net/X3DJSONLD/flowers.x3d")))
  .setScene(new SceneObject()
    .addChild(new NavigationInfoObject())
    .addChild(new BackgroundObject().setBackUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_back.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_back.png\"")).setBottomUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_bottom.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_bottom.png\"")).setFrontUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_front.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_front.png\"")).setLeftUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_left.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_left.png\"")).setRightUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_right.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_right.png\"")).setTopUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_top.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_top.png\"")))
    .addChild(new ProtoDeclareObject().setName("flower")
      .setProtoBody(new ProtoBodyObject()
        .addChild(new TransformObject("transform")
          .addChild(new ShapeObject()
            .setAppearance(new AppearanceObject()
              .setMaterial(new MaterialObject().setSpecularColor(.5f,.5f,.5f).setDiffuseColor(.7f,.7f,.7f))
              .setTexture(new ComposedCubeMapTextureObject("texture")
                .setBack(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_back.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_back.png\"")))
                .setBottom(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_bottom.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_bottom.png\"")))
                .setFront(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_front.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_front.png\"")))
                .setLeft(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_left.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_left.png\"")))
                .setRight(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_right.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_right.png\"")))
                .setTop(new ImageTextureObject().setUrl(new MFStringObject("\"../resources/images/all_probes/stpeters_cross/stpeters_top.png\" \"https://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_top.png\""))))
              .addShaders(new ComposedShaderObject().setLanguage("GLSL")
                .addField(new fieldObject().setAccessType("inputOutput").setName("xxxcube").setType("SFInt32").setValue("0"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("cube").setType("SFNode")
                  .addChild(new ComposedCubeMapTextureObject().setUSE("texture")))
                .addField(new fieldObject().setAccessType("inputOutput").setName("chromaticDispertion").setType("SFVec3f").setValue("0.98 1.0 1.033"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("bias").setType("SFFloat").setValue("0.5"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("scale").setType("SFFloat").setValue("0.5"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("power").setType("SFFloat").setValue("2.0"))
                .addParts(new ShaderPartObject().setUrl(new MFStringObject("\"../shaders/common.vs\" \"https://coderextreme.net/X3DJSONLD/shaders/common.vs\"")))
                .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject("\"../shaders/gl_flowers_chromatic.fs\" \"https://coderextreme.net/X3DJSONLD/shaders/gl_flowers_chromatic.fs\""))))
              .addShaders(new ComposedShaderObject().setLanguage("GLSL")
                .addField(new fieldObject().setAccessType("inputOutput").setName("xxxcube").setType("SFInt32").setValue("0"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("cube").setType("SFNode")
                  .addChild(new ComposedCubeMapTextureObject().setUSE("texture")))
                .addField(new fieldObject().setAccessType("inputOutput").setName("chromaticDispertion").setType("SFVec3f").setValue("0.98 1.0 1.033"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("bias").setType("SFFloat").setValue("0.5"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("scale").setType("SFFloat").setValue("0.5"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("power").setType("SFFloat").setValue("2.0"))
                .addParts(new ShaderPartObject().setUrl(new MFStringObject("\"../shaders/x3dom.vs\" \"https://coderextreme.net/X3DJSONLD/shaders/x3dom.vs\"")))
                .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject("\"../shaders/pc_bubbles.fs\" \"https://coderextreme.net/X3DJSONLD/shaders/pc_bubbles.fs\""))))
              .addShaders(new ComposedShaderObject("shader").setLanguage("GLSL")
                .addField(new fieldObject().setAccessType("inputOutput").setName("xxxcube").setType("SFInt32").setValue("0"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("cube").setType("SFNode")
                  .addChild(new ComposedCubeMapTextureObject().setUSE("texture")))
                .addField(new fieldObject().setAccessType("inputOutput").setName("chromaticDispertion").setType("SFVec3f").setValue("0.98 1.0 1.033"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("bias").setType("SFFloat").setValue("10"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("scale").setType("SFFloat").setValue("10"))
                .addField(new fieldObject().setAccessType("inputOutput").setName("power").setType("SFFloat").setValue("2.0"))
                .addParts(new ShaderPartObject().setUrl(new MFStringObject("\"../shaders/cobweb.vs\" \"https://coderextreme.net/X3DJSONLD/shaders/cobweb.vs\"")))
                .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject("\"../shaders/pc_bubbles.fs\" \"https://coderextreme.net/X3DJSONLD/shaders/pc_bubbles.fs\"")))))
            .addComments(new String[] {"",
"			<Sphere></Sphere>"})
            .setGeometry(new IndexedFaceSetObject("Orbit").setDEF("Orbit").setConvex(false)
              .setCoord(new CoordinateObject("OrbitCoordinates")))))
        .addChild(new ScriptObject("Bounce").setSourceCode(
"<![CDATA[" + "\n" +
"\n" + 
"ecmascript:" + "\n" + 
"			function newBubble() {" + "\n" + 
"			    translation = new SFVec3f(0, 0, 0);" + "\n" + 
"			    velocity = new SFVec3f(" + "\n" + 
"			    	Math.random() - 0.5," + "\n" + 
"				Math.random() - 0.5," + "\n" + 
"				Math.random() - 0.5);" + "\n" + 
"			}" + "\n" + 
"			function set_fraction() {" + "\n" + 
"			    translation = new SFVec3f(" + "\n" + 
"			    	translation.x + velocity.x," + "\n" + 
"				translation.y + velocity.y," + "\n" + 
"				translation.z + velocity.z);" + "\n" + 
"			    if (Math.abs(translation.x) > 10) {" + "\n" + 
"					newBubble();" + "\n" + 
"			    } else if (Math.abs(translation.y) > 10) {" + "\n" + 
"					newBubble();" + "\n" + 
"			    } else if (Math.abs(translation.z) > 10) {" + "\n" + 
"					newBubble();" + "\n" + 
"			    } else {" + "\n" + 
"					velocity = new SFVec3f(" + "\n" + 
"						velocity.x + Math.random() * 0.2 - 0.1," + "\n" + 
"						velocity.y + Math.random() * 0.2 - 0.1," + "\n" + 
"						velocity.z + Math.random() * 0.2 - 0.1" + "\n" + 
"					);" + "\n" + 
"			    }" + "\n" + 
"			    animate_flowers();" + "\n" + 
"			}" + "\n" + 
"\n" + 
"			function initialize() {" + "\n" + 
"			     var cis = [];" + "\n" + 
"			     newBubble();" + "\n" + 
"			     resolution = 100;" + "\n" + 
"			     updateCoordinates(resolution);" + "\n" + 
"			     for ( i = 0; i < resolution-1; i++) {" + "\n" + 
"				for ( j = 0; j < resolution-1; j++) {" + "\n" + 
"				     cis.push(i*resolution+j);" + "\n" + 
"				     cis.push(i*resolution+j+1);" + "\n" + 
"				     cis.push((i+1)*resolution+j+1);" + "\n" + 
"				     cis.push((i+1)*resolution+j);" + "\n" + 
"				     cis.push(-1);" + "\n" + 
"				}" + "\n" + 
"			    }" + "\n" + 
"			     coordIndexes = new MFInt32(cis);" + "\n" + 
"			}" + "\n" + 
"\n" + 
"			function updateCoordinates(resolution) {" + "\n" + 
"			     theta = 0.0;" + "\n" + 
"			     phi = 0.0;" + "\n" + 
"			     delta = (2 * 3.141592653) / (resolution-1);" + "\n" + 
"			     var crds = [];" + "\n" + 
"			     for ( i = 0; i < resolution; i++) {" + "\n" + 
"				for ( j = 0; j < resolution; j++) {" + "\n" + 
"					rho = a + b * Math.cos(c * theta) * Math.cos(d * phi);" + "\n" + 
"					crds.push(new SFVec3f(" + "\n" + 
"						rho * Math.cos(phi) * Math.cos(theta)," + "\n" + 
"						rho * Math.cos(phi) * Math.sin(theta)," + "\n" + 
"						rho * Math.sin(phi)" + "\n" + 
"					));" + "\n" + 
"					theta += delta;" + "\n" + 
"				}" + "\n" + 
"				phi += delta;" + "\n" + 
"				coordinates = new MFVec3f(crds);" + "\n" + 
"			     }" + "\n" + 
"			}" + "\n" + 
"\n" + 
"			function animate_flowers(fraction, eventTime) {" + "\n" + 
"				choice = Math.floor(Math.random() * 4);" + "\n" + 
"				switch (choice) {" + "\n" + 
"				case 0:" + "\n" + 
"					a += Math.random() * 0.2 - 0.1;" + "\n" + 
"					break;" + "\n" + 
"				case 1:" + "\n" + 
"					b += Math.random() * 0.2 - 0.1;" + "\n" + 
"					break;" + "\n" + 
"				case 2:" + "\n" + 
"					c += Math.random() * 2 - 1;" + "\n" + 
"					break;" + "\n" + 
"				case 3:" + "\n" + 
"					d += Math.random() * 2 - 1;" + "\n" + 
"					break;" + "\n" + 
"				}" + "\n" + 
"				if (a > 1) {" + "\n" + 
"					a =  0.5;" + "\n" + 
"				}" + "\n" + 
"				if (b > 1) {" + "\n" + 
"					b =  0.5;" + "\n" + 
"				}" + "\n" + 
"				if (c < 1) {" + "\n" + 
"					c =  4;" + "\n" + 
"				}" + "\n" + 
"				if (d < 1) {" + "\n" + 
"					d =  4;" + "\n" + 
"				}" + "\n" + 
"				if (c > 10) {" + "\n" + 
"					c = 4;" + "\n" + 
"				}" + "\n" + 
"				if (d > 10) {" + "\n" + 
"					d = 4;" + "\n" + 
"				}" + "\n" + 
"				resolution = 100;" + "\n" + 
"				updateCoordinates(resolution);" + "\n" + 
"			}" + "\n" + "]]>"
)
          .addField(new fieldObject().setAccessType("inputOutput").setName("translation").setType("SFVec3f").setValue("0 0 0"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("velocity").setType("SFVec3f").setValue("0 0 0"))
          .addField(new fieldObject().setAccessType("inputOnly").setName("set_fraction").setType("SFTime"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("coordinates").setType("MFVec3f"))
          .addField(new fieldObject().setAccessType("outputOnly").setName("coordIndexes").setType("MFInt32"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("a").setType("SFFloat").setValue("0.5"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("b").setType("SFFloat").setValue("0.5"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("c").setType("SFFloat").setValue("3"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("d").setType("SFFloat").setValue("3"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("tdelta").setType("SFFloat").setValue("0.5"))
          .addField(new fieldObject().setAccessType("inputOutput").setName("pdelta").setType("SFFloat").setValue("0.5")))
        .addChild(new TimeSensorObject("TourTime").setCycleInterval(0.150).setLoop(true))
        .addChild(new TimeSensorObject("SongTime").setLoop(true))
        .addChild(new SoundObject().setMaxBack(100f).setMaxFront(100f).setMinBack(20f).setMinFront(20f)
          .setSource(new AudioClipObject("AudioClip").setDescription("Chandubabamusic #1").setUrl(new MFStringObject("\"../resources/chandubabamusic1.wav\""))))
        .addChild(new ROUTEObject().setFromNode("SongTime").setFromField("cycleTime").setToNode("AudioClip").setToField("startTime"))
        .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("cycleTime").setToNode("Bounce").setToField("set_fraction"))
        .addChild(new ROUTEObject().setFromNode("Bounce").setFromField("translation").setToNode("transform").setToField("set_translation"))
        .addComments(new String[] {"",
"		<ROUTE fromField=\"coordIndexes\" fromNode=\"Bounce\" toField=\"set_coordIndex\" toNode=\"Orbit\"/>",
"		<ROUTE fromField=\"coordinates\" fromNode=\"Bounce\" toField=\"set_point\" toNode=\"OrbitCoordinates\"/>"})))
    .addChild(new TransformObject()
      .addChild(new ProtoInstanceObject().setName("flower"))
      .addComments(new String[] {"",
"            <ProtoInstance name=\"flower\"/>",
"            <ProtoInstance name=\"flower\"/>"})));
  }
  // end of initialize() method

  /** The initialized model object, created within initialize() method. */
  private X3DObject x3dModel;
  
  /** Provide a 
   * <a href="https://dzone.com/articles/java-copy-shallow-vs-deep-in-which-you-will-swim" target="_blank">shallow copy</a>
   * of the X3D model.
   * @see <a href="http://www.web3d.org/specifications/java/javadoc/org/web3d/x3d/jsail/Core/X3DObject.html">X3DObject</a>
   * @return flowers model
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
        X3DObject exampleObject = new flowers().getX3dModel();

        exampleObject.handleArguments(argv);
        System.out.print("flowers self-validation test results: ");
        String validationResults = exampleObject.validationReport();
        System.out.println(validationResults);
    }
}
