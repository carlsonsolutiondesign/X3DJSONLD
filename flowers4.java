import org.web3d.x3d.jsail.*;
import org.web3d.x3d.jsail.CADGeometry.*;
import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.jsail.CubeMapTexturing.*;
import org.web3d.x3d.jsail.DIS.*;
import org.web3d.x3d.jsail.EnvironmentalEffects.*;
import org.web3d.x3d.jsail.EnvironmentalSensor.*;
import org.web3d.x3d.jsail.EventUtilities.*;
import org.web3d.x3d.jsail.Followers.*;
import org.web3d.x3d.jsail.Geometry2D.*;
import org.web3d.x3d.jsail.Geometry3D.*;
import org.web3d.x3d.jsail.Geospatial.*;
import org.web3d.x3d.jsail.Grouping.*;
import org.web3d.x3d.jsail.HAnim.*;
import org.web3d.x3d.jsail.Interpolation.*;
import org.web3d.x3d.jsail.KeyDeviceSensor.*;
import org.web3d.x3d.jsail.Layering.*;
import org.web3d.x3d.jsail.Layout.*;
import org.web3d.x3d.jsail.Lighting.*;
import org.web3d.x3d.jsail.NURBS.*;
import org.web3d.x3d.jsail.Navigation.*;
import org.web3d.x3d.jsail.Networking.*;
import org.web3d.x3d.jsail.ParticleSystems.*;
import org.web3d.x3d.jsail.Picking.*;
import org.web3d.x3d.jsail.PointingDeviceSensor.*;
import org.web3d.x3d.jsail.Rendering.*;
import org.web3d.x3d.jsail.RigidBodyPhysics.*;
import org.web3d.x3d.jsail.Scripting.*;
import org.web3d.x3d.jsail.Shaders.*;
import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.jsail.Sound.*;
import org.web3d.x3d.jsail.Text.*;
import org.web3d.x3d.jsail.Texturing3D.*;
import org.web3d.x3d.jsail.Texturing.*;
import org.web3d.x3d.jsail.Time.*;
import org.web3d.x3d.jsail.VolumeRendering.*;
import org.web3d.x3d.jsail.fields.*;
import org.web3d.x3d.sai.*;
import org.web3d.x3d.sai.CADGeometry.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.sai.CubeMapTexturing.*;
import org.web3d.x3d.sai.DIS.*;
import org.web3d.x3d.sai.EnvironmentalEffects.*;
import org.web3d.x3d.sai.EnvironmentalSensor.*;
import org.web3d.x3d.sai.EventUtilities.*;
import org.web3d.x3d.sai.Followers.*;
import org.web3d.x3d.sai.Geometry2D.*;
import org.web3d.x3d.sai.Geometry3D.*;
import org.web3d.x3d.sai.Geospatial.*;
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.HAnim.*;
import org.web3d.x3d.sai.Interpolation.*;
import org.web3d.x3d.sai.KeyDeviceSensor.*;
import org.web3d.x3d.sai.Layering.*;
import org.web3d.x3d.sai.Layout.*;
import org.web3d.x3d.sai.Lighting.*;
import org.web3d.x3d.sai.NURBS.*;
import org.web3d.x3d.sai.Navigation.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.ParticleSystems.*;
import org.web3d.x3d.sai.Picking.*;
import org.web3d.x3d.sai.PointingDeviceSensor.*;
import org.web3d.x3d.sai.Rendering.*;
import org.web3d.x3d.sai.RigidBodyPhysics.*;
import org.web3d.x3d.sai.Scripting.*;
import org.web3d.x3d.sai.Shaders.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Sound.*;
import org.web3d.x3d.sai.Text.*;
import org.web3d.x3d.sai.Texturing3D.*;
import org.web3d.x3d.sai.Texturing.*;
import org.web3d.x3d.sai.Time.*;
import org.web3d.x3d.sai.VolumeRendering.*;
public class flowers4 {
  public static void main(String[] args) {
    ConfigurationProperties.setShowDefaultAttributes(true);
    ConfigurationProperties.setXsltEngine(ConfigurationProperties.XSLT_ENGINE_nativeJava);
    ConfigurationProperties.setDeleteIntermediateFiles(false);
    new flowers4().initialize().toFileJSON("flowers4.new.json");
    }
    public X3DObject initialize() {
      return new X3DObject().setProfile("Immersive").setVersion("3.3")
      .setHead(new headObject()
        .addMeta(new metaObject().setName("title").setContent("flowers4.x3d"))
        .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
        .addMeta(new metaObject().setName("generator").setContent("manual"))
        .addMeta(new metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/flowers4.x3d"))
        .addMeta(new metaObject().setName("description").setContent("an animated flower")))
      .setScene(new SceneObject()
        .addChild(new NavigationInfoObject())
        .addChild(new BackgroundObject().setBackUrl(new MFStringObject(MFString0())).setBottomUrl(new MFStringObject(MFString1())).setFrontUrl(new MFStringObject(MFString2())).setLeftUrl(new MFStringObject(MFString3())).setRightUrl(new MFStringObject(MFString4())).setTopUrl(new MFStringObject(MFString5())))
        .addChild(new ViewpointObject().setPosition(new float[] {0f,0f,40f}).setDescription("Transparent rose"))
        .addChild(new TransformObject().setDEF("Rose01")
          .addChild(new ShapeObject()
            .setAppearance(new AppearanceObject().setDEF("_01_-_Default")
              .setMaterial(new MaterialObject().setDiffuseColor(new float[] {0.7f,0.7f,0.7f}).setSpecularColor(new float[] {0.5f,0.5f,0.5f}))
              .setTexture(new ComposedCubeMapTextureObject()
                .setTop(new ImageTextureObject().setUrl(new MFStringObject(MFString6())))
                .setTop(new ImageTextureObject().setUrl(new MFStringObject(MFString7())))
                .setTop(new ImageTextureObject().setUrl(new MFStringObject(MFString8())))
                .setTop(new ImageTextureObject().setUrl(new MFStringObject(MFString9())))
                .setTop(new ImageTextureObject().setUrl(new MFStringObject(MFString10())))
                .setTop(new ImageTextureObject().setUrl(new MFStringObject(MFString11()))))
              .addShaders(new ComposedShaderObject().setDEF("ComposedShader").setLanguage("GLSL")
                .addField(new fieldObject().setName("cube").setType(fieldObject.TYPE_SFINT32).setAccessType("inputOutput").setValue("0"))
                .addField(new fieldObject().setName("chromaticDispersion").setAccessType("inputOutput").setType(fieldObject.TYPE_SFVEC3F).setValue("0.98 1 1.033"))
                .addField(new fieldObject().setName("bias").setType(fieldObject.TYPE_SFFLOAT).setAccessType("inputOutput").setValue("0.5"))
                .addField(new fieldObject().setName("scale").setType(fieldObject.TYPE_SFFLOAT).setAccessType("inputOutput").setValue("0.5"))
                .addField(new fieldObject().setName("power").setType(fieldObject.TYPE_SFFLOAT).setAccessType("inputOutput").setValue("2"))
                .addParts(new ShaderPartObject().setUrl(new MFStringObject(MFString12())).setType("VERTEX"))
                .addParts(new ShaderPartObject().setUrl(new MFStringObject(MFString13())).setType("FRAGMENT"))))
            .addComments(new CommentsBlock("Sphere/"))
            .setGeometry(new IndexedFaceSetObject().setDEF("Orbit")
              .setCoord(new CoordinateObject().setDEF("OrbitCoordinates")))))
        .addChild(new ScriptObject().setDEF("OrbitScript")
          .addField(new fieldObject().setName("set_fraction").setAccessType("inputOnly").setType(fieldObject.TYPE_SFFLOAT))
          .addField(new fieldObject().setName("coordinates").setAccessType("inputOutput").setType(fieldObject.TYPE_MFVEC3F))
          .addField(new fieldObject().setName("coordIndexes").setAccessType("inputOutput").setType(fieldObject.TYPE_MFINT32))
          .setSourceCode("ecmascript:\n"+
"\n"+
"var e = 5;\n"+
"var f = 5;\n"+
"var g = 5;\n"+
"var h = 5;\n"+
"\n"+
"function initialize() {\n"+
"     resolution = 100;\n"+
"     updateCoordinates(resolution);\n"+
"     if (typeof coordIndexes == 'undefined' || coordIndexes == null) {\n"+
"     	coordIndexes = new MFInt32();\n"+
"     }\n"+
"     ci = 0;\n"+
"     for ( i = 0; i < resolution-1; i++) {\n"+
"     	for ( j = 0; j < resolution-1; j++) {\n"+
"	     coordIndexes[ci] = i*resolution+j;\n"+
"	     coordIndexes[ci+1] = i*resolution+j+1;\n"+
"	     coordIndexes[ci+2] = (i+1)*resolution+j+1;\n"+
"	     coordIndexes[ci+3] = (i+1)*resolution+j;\n"+
"	     coordIndexes[ci+4] = -1;\n"+
"	     ci += 5;\n"+
"	}\n"+
"    }\n"+
"}\n"+
"\n"+
"function updateCoordinates(resolution) {\n"+
"     theta = 0.0;\n"+
"     phi = 0.0;\n"+
"     delta = (2 * 3.141592653) / (resolution-1);\n"+
"     if (typeof coordinates == 'undefined' || coordinates == null) {\n"+
"     	coordinates = new MFVec3f();\n"+
"     }\n"+
"     for ( i = 0; i < resolution; i++) {\n"+
"     	for ( j = 0; j < resolution; j++) {\n"+
"		rho = e + f * Math.cos(g * theta) * Math.cos(h * phi);\n"+
"		coordinates[i*resolution+j] = new SFVec3f();\n"+
"		coordinates[i*resolution+j][0] = rho * Math.cos(phi) * Math.cos(theta);\n"+
"		coordinates[i*resolution+j][1] = rho * Math.cos(phi) * Math.sin(theta);\n"+
"		coordinates[i*resolution+j][2] = rho * Math.sin(phi);\n"+
"		theta += delta;\n"+
"	}\n"+
"	phi += delta;\n"+
"     }\n"+
"}\n"+
"\n"+
"function set_fraction(fraction, eventTime) {\n"+
"	choice = Math.floor(Math.random() * 4);\n"+
"	switch (choice) {\n"+
"	case 0:\n"+
"		e += Math.floor(Math.random() * 2) * 2 - 1;\n"+
"		break;\n"+
"	case 1:\n"+
"		f += Math.floor(Math.random() * 2) * 2 - 1;\n"+
"		break;\n"+
"	case 2:\n"+
"		g += Math.floor(Math.random() * 2) * 2 - 1;\n"+
"		break;\n"+
"	case 3:\n"+
"		h += Math.floor(Math.random() * 2) * 2 - 1;\n"+
"		break;\n"+
"	}\n"+
"	if (f < 1) {\n"+
"		f = 10;\n"+
"	}\n"+
"	if (g < 1) {\n"+
"		g = 4;\n"+
"	}\n"+
"	if (h < 1) {\n"+
"		h = 4;\n"+
"	}\n"+
"	resolution = 100;\n"+
"	updateCoordinates(resolution);\n"+
"}\n"+
""))
        .addChild(new TimeSensorObject().setDEF("Clock").setCycleInterval(16).setLoop(true))
        .addChild(new ROUTEObject().setFromField("coordIndexes").setFromNode("OrbitScript").setToField("set_coordIndex").setToNode("Orbit"))
        .addChild(new ROUTEObject().setFromField("coordinates").setFromNode("OrbitScript").setToField("set_point").setToNode("OrbitCoordinates"))
        .addChild(new ROUTEObject().setFromField("fraction_changed").setFromNode("Clock").setToField("set_fraction").setToNode("OrbitScript")))      ;
    }
private MFStringObject MFString0() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_back.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_back.png"})
;
}
private MFStringObject MFString1() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_bottom.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_bottom.png"})
;
}
private MFStringObject MFString2() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_front.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_front.png"})
;
}
private MFStringObject MFString3() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_left.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_left.png"})
;
}
private MFStringObject MFString4() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_right.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_right.png"})
;
}
private MFStringObject MFString5() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_top.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_top.png"})
;
}
private MFStringObject MFString6() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_back.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_back.png"})
;
}
private MFStringObject MFString7() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_bottom.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_bottom.png"})
;
}
private MFStringObject MFString8() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_front.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_front.png"})
;
}
private MFStringObject MFString9() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_left.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_left.png"})
;
}
private MFStringObject MFString10() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_right.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_right.png"})
;
}
private MFStringObject MFString11() {
  return new MFStringObject( new String[] {"cubemap/all_probes/uffizi_cross/uffizi_top.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/uffizi_cross/uffizi_top.png"})
;
}
private MFStringObject MFString12() {
  return new MFStringObject( new String[] {"x3dom.vs","http://coderextreme.net/X3DJSONLD/x3dom.vs"})
;
}
private MFStringObject MFString13() {
  return new MFStringObject( new String[] {"pc_bubbles.fs","http://coderextreme.net/X3DJSONLD/pc_bubbles.fs"})
;
}
}
