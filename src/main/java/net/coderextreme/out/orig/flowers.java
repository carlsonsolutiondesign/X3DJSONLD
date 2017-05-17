package net.coderextreme.out.orig;
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
public class flowers {
  public static void main(String[] args) {
    ConfigurationProperties.setShowDefaultAttributes(true);
    ConfigurationProperties.setXsltEngine(ConfigurationProperties.XSLT_ENGINE_nativeJava);
    ConfigurationProperties.setDeleteIntermediateFiles(false);
    new flowers().initialize().toFileJSON("../out/orig/flowers.new.json");
    }
    public X3DObject initialize() {
ProtoInstanceObject ProtoInstance0 = null;
ProtoInstanceObject ProtoInstance1 = null;
ProtoInstanceObject ProtoInstance2 = null;
      X3DObject X3D0 =  new X3DObject().setProfile("Immersive").setVersion("3.3")
      .setHead(new headObject()
        .addMeta(new metaObject().setName("title").setContent("flowers.x3d"))
        .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
        .addMeta(new metaObject().setName("description").setContent("5 or more prismatic flowers"))
        .addMeta(new metaObject().setName("generator").setContent("X3D-Edit, https://savage.nps.edu/X3D-Edit"))
        .addMeta(new metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/flowers.x3d")))
      .setScene(new SceneObject()
        .addChild(new NavigationInfoObject())
        .addChild(new BackgroundObject().setBackUrl(new MFStringObject(new MFString0().getArray())).setBottomUrl(new MFStringObject(new MFString1().getArray())).setFrontUrl(new MFStringObject(new MFString2().getArray())).setLeftUrl(new MFStringObject(new MFString3().getArray())).setRightUrl(new MFStringObject(new MFString4().getArray())).setTopUrl(new MFStringObject(new MFString5().getArray())))
        .addChild(new ProtoDeclareObject().setName("flower")
          .setProtoBody(new ProtoBodyObject()
            .addChild(new TransformObject().setDEF("transform")
              .addChild(new ShapeObject()
                .setAppearance(new AppearanceObject()
                  .setMaterial(new MaterialObject().setDiffuseColor(new float[] {0.7f,0.7f,0.7f}).setSpecularColor(new float[] {0.5f,0.5f,0.5f}))
                  .setTexture(new ComposedCubeMapTextureObject().setDEF("texture")
                    .setBack(new ImageTextureObject().setUrl(new MFStringObject(new MFString6().getArray())))
                    .setBottom(new ImageTextureObject().setUrl(new MFStringObject(new MFString7().getArray())))
                    .setFront(new ImageTextureObject().setUrl(new MFStringObject(new MFString8().getArray())))
                    .setLeft(new ImageTextureObject().setUrl(new MFStringObject(new MFString9().getArray())))
                    .setRight(new ImageTextureObject().setUrl(new MFStringObject(new MFString10().getArray())))
                    .setTop(new ImageTextureObject().setUrl(new MFStringObject(new MFString11().getArray()))))
                  .addShaders(new ComposedShaderObject().setDEF("shader").setLanguage("GLSL")
                    .addField(new fieldObject().setType("SFInt32").setName("xxxcube").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0"))
                    .addField(new fieldObject().setType("SFNode").setName("cube").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT)
                      .addChild(new ComposedCubeMapTextureObject().setUSE("texture")))
                    .addField(new fieldObject().setType("SFVec3f").setName("chromaticDispertion").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.98 1 1.033"))
                    .addField(new fieldObject().setType("SFFloat").setName("bias").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("10"))
                    .addField(new fieldObject().setType("SFFloat").setName("scale").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("10"))
                    .addField(new fieldObject().setType("SFFloat").setName("power").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("2"))
                    .addParts(new ShaderPartObject().setType("VERTEX").setUrl(new MFStringObject(new MFString12().getArray())))
                    .addParts(new ShaderPartObject().setType("FRAGMENT").setUrl(new MFStringObject(new MFString13().getArray())))))
                .setGeometry(new IndexedFaceSetObject().setDEF("Orbit")
                  .setCoord(new CoordinateObject().setDEF("OrbitCoordinates")))))
            .addChild(new ScriptObject().setDEF("Bounce")
              .addField(new fieldObject().setType("SFVec3f").setName("translation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0"))
              .addField(new fieldObject().setType("SFVec3f").setName("velocity").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0"))
              .addField(new fieldObject().setType("SFTime").setName("set_fraction").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY))
              .addField(new fieldObject().setType("MFVec3f").setName("coordinates").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT))
              .addField(new fieldObject().setType("MFInt32").setName("coordIndexes").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT))
              .addField(new fieldObject().setType("SFFloat").setName("a").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
              .addField(new fieldObject().setType("SFFloat").setName("b").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
              .addField(new fieldObject().setType("SFFloat").setName("c").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("3"))
              .addField(new fieldObject().setType("SFFloat").setName("d").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("3"))
              .addField(new fieldObject().setType("SFFloat").setName("tdelta").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
              .addField(new fieldObject().setType("SFFloat").setName("pdelta").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
              .setSourceCode("ecmascript:\n"+
"			function set_translation(value) {\n"+
"				translation = value;\n"+
"			}\n"+
"			function translation_changed() {\n"+
"				return translation;\n"+
"			}\n"+
"			function initialize() {\n"+
"			    translation = new SFVec3f(0, 0, 0);\n"+
"			    velocity = new SFVec3f(\n"+
"			    	Math.random() - 0.5,\n"+
"				Math.random() - 0.5,\n"+
"				Math.random() - 0.5);\n"+
"			}\n"+
"			function set_fraction() {\n"+
"			    translation = new SFVec3f(\n"+
"			    	translation[0] + velocity[0],\n"+
"				translation[1] + velocity[1],\n"+
"				translation[2] + velocity[2]);\n"+
"			    for (var j = 0; j <= 2; j++) {\n"+
"				    if (Math.abs(translation[j]) > 10) {\n"+
"					initialize();\n"+
"				    } else {\n"+
"					velocity[0] += Math.random() * 0.2 - 0.1;\n"+
"					velocity[1] += Math.random() * 0.2 - 0.1;\n"+
"					velocity[2] += Math.random() * 0.2 - 0.1;\n"+
"				    }\n"+
"			    }\n"+
"			    animate_flowers();\n"+
"			}\n"+
"\n"+
"			function initialize() {\n"+
"			     resolution = 100;\n"+
"			     updateCoordinates(resolution);\n"+
"			     if (typeof coordIndexes == 'undefined' || coordIndexes == null) {\n"+
"				coordIndexes = new MFInt32();\n"+
"			     }\n"+
"			     ci = 0;\n"+
"			     for ( i = 0; i < resolution-1; i++) {\n"+
"				for ( j = 0; j < resolution-1; j++) {\n"+
"				     coordIndexes[ci] = i*resolution+j;\n"+
"				     coordIndexes[ci+1] = i*resolution+j+1;\n"+
"				     coordIndexes[ci+2] = (i+1)*resolution+j+1;\n"+
"				     coordIndexes[ci+3] = (i+1)*resolution+j;\n"+
"				     coordIndexes[ci+4] = -1;\n"+
"				     ci += 5;\n"+
"				}\n"+
"			    }\n"+
"			}\n"+
"\n"+
"			function updateCoordinates(resolution) {\n"+
"			     theta = 0.0;\n"+
"			     phi = 0.0;\n"+
"			     delta = (2 * 3.141592653) / (resolution-1);\n"+
"			     if (typeof coordinates == 'undefined' || coordinates == null) {\n"+
"				coordinates = new MFVec3f();\n"+
"			     }\n"+
"			     for ( i = 0; i < resolution; i++) {\n"+
"				for ( j = 0; j < resolution; j++) {\n"+
"					rho = a + b * Math.cos(c * theta) * Math.cos(d * phi);\n"+
"					coordinates[i*resolution+j] = new SFVec3f();\n"+
"					coordinates[i*resolution+j][0] = rho * Math.cos(phi) * Math.cos(theta);\n"+
"					coordinates[i*resolution+j][1] = rho * Math.cos(phi) * Math.sin(theta);\n"+
"					coordinates[i*resolution+j][2] = rho * Math.sin(phi);\n"+
"					theta += delta;\n"+
"				}\n"+
"				phi += delta;\n"+
"			     }\n"+
"			}\n"+
"\n"+
"			function animate_flowers(fraction, eventTime) {\n"+
"				choice = Math.floor(Math.random() * 4);\n"+
"				switch (choice) {\n"+
"				case 0:\n"+
"					a += Math.random() * 0.2 - 0.1;\n"+
"					break;\n"+
"				case 1:\n"+
"					b += Math.random() * 0.2 - 0.1;\n"+
"					break;\n"+
"				case 2:\n"+
"					c += Math.random() * 2 - 1;\n"+
"					break;\n"+
"				case 3:\n"+
"					d += Math.random() * 2 - 1;\n"+
"					break;\n"+
"				}\n"+
"				if (a > 1) {\n"+
"					a =  0.5;\n"+
"				}\n"+
"				if (b > 1) {\n"+
"					b =  0.5;\n"+
"				}\n"+
"				if (c < 1) {\n"+
"					c =  4;\n"+
"				}\n"+
"				if (d < 1) {\n"+
"					d =  4;\n"+
"				}\n"+
"				if (c > 10) {\n"+
"					c = 4;\n"+
"				}\n"+
"				if (d > 10) {\n"+
"					d = 4;\n"+
"				}\n"+
"				resolution = 100;\n"+
"				updateCoordinates(resolution);\n"+
"			}\n"+
""))
            .addChild(new TimeSensorObject().setDEF("TourTime").setCycleInterval(0.15d).setLoop(true))
            .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("cycleTime").setToNode("Bounce").setToField("set_fraction"))
            .addChild(new ROUTEObject().setFromNode("Bounce").setFromField("translation_changed").setToNode("transform").setToField("set_translation"))
            .addChild(new ROUTEObject().setFromField("coordIndexes").setFromNode("Bounce").setToField("set_coordIndex").setToNode("Orbit"))
            .addChild(new ROUTEObject().setFromField("coordinates").setFromNode("Bounce").setToField("set_point").setToNode("OrbitCoordinates"))))
        .addChild(new TransformObject()
          .addChild(ProtoInstance0 = new ProtoInstanceObject().setName("flower"))
          .addChild(ProtoInstance1 = new ProtoInstanceObject().setName("flower"))
          .addChild(ProtoInstance2 = new ProtoInstanceObject().setName("flower"))))      ;
    return X3D0;
    }
protected class MFString0 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_back.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_back.png"});
  }
}
protected class MFString1 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_bottom.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_bottom.png"});
  }
}
protected class MFString2 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_front.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_front.png"});
  }
}
protected class MFString3 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_left.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_left.png"});
  }
}
protected class MFString4 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_right.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_right.png"});
  }
}
protected class MFString5 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_top.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_top.png"});
  }
}
protected class MFString6 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_back.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_back.png"});
  }
}
protected class MFString7 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_bottom.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_bottom.png"});
  }
}
protected class MFString8 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_front.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_front.png"});
  }
}
protected class MFString9 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_left.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_left.png"});
  }
}
protected class MFString10 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_right.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_right.png"});
  }
}
protected class MFString11 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"images/all_probes/stpeters_cross/stpeters_top.png","http://coderextreme.net/X3DJSONLD/images/all_probes/stpeters_cross/stpeters_top.png"});
  }
}
protected class MFString12 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"cobweb.vs","http://coderextreme.net/X3DJSONLD/cobweb.vs"});
  }
}
protected class MFString13 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"pc_bubbles.fs","http://coderextreme.net/X3DJSONLD/pc_bubbles.fs"});
  }
}
}