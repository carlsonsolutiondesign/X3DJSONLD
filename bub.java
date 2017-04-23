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
public class bub {
  public static void main(String[] args) {
    ConfigurationProperties.setShowDefaultAttributes(true);
    ConfigurationProperties.setXsltEngine(ConfigurationProperties.XSLT_ENGINE_nativeJava);
    ConfigurationProperties.setDeleteIntermediateFiles(false);
    new bub().initialize().toFileJSON("bub.new.json");
    }
    public X3DObject initialize() {
      return new X3DObject().setProfile("Immersive").setVersion("3.3")
      .setHead(new headObject()
        .addMeta(new metaObject().setName("title").setContent("bub.x3d"))
        .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
        .addMeta(new metaObject().setName("description").setContent("3 prismatic spheres"))
        .addMeta(new metaObject().setName("generator").setContent("X3D-Edit, https://savage.nps.edu/X3D-Edit"))
        .addMeta(new metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/bub.x3d")))
      .setScene(new SceneObject()
        .addChild(new NavigationInfoObject())
        .addChild(new BackgroundObject().setBackUrl(new MFStringObject(new MFString0().getArray())).setBottomUrl(new MFStringObject(new MFString1().getArray())).setFrontUrl(new MFStringObject(new MFString2().getArray())).setLeftUrl(new MFStringObject(new MFString3().getArray())).setRightUrl(new MFStringObject(new MFString4().getArray())).setTopUrl(new MFStringObject(new MFString5().getArray())))
        .addChild(new ViewpointObject().setPosition(new float[] {0f,0f,20f}))
        .addChild(new ProtoDeclareObject().setName("Bubble")
          .setProtoBody(new ProtoBodyObject()
            .addChild(new TransformObject().setDEF("transform")
              .addChild(new ShapeObject().setDEF("myShape")
                .setAppearance(new AppearanceObject()
                  .setMaterial(new MaterialObject().setDiffuseColor(new float[] {0.7f,0.7f,0.7f}).setSpecularColor(new float[] {0.5f,0.5f,0.5f}))
                  .setTexture(new ComposedCubeMapTextureObject()
                    .setTop(new ImageTextureObject().setUrl(new MFStringObject(new MFString6().getArray())))
                    .setTop(new ImageTextureObject().setUrl(new MFStringObject(new MFString7().getArray())))
                    .setTop(new ImageTextureObject().setUrl(new MFStringObject(new MFString8().getArray())))
                    .setTop(new ImageTextureObject().setUrl(new MFStringObject(new MFString9().getArray())))
                    .setTop(new ImageTextureObject().setUrl(new MFStringObject(new MFString10().getArray())))
                    .setTop(new ImageTextureObject().setUrl(new MFStringObject(new MFString11().getArray()))))
                  .addShaders(new ComposedShaderObject().setDEF("gl").setLanguage("GLSL")
                    .addField(new fieldObject().setName("cube").setType(fieldObject.TYPE_SFINT32).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0"))
                    .addField(new fieldObject().setName("chromaticDispertion").setType(fieldObject.TYPE_SFVEC3F).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.98 1 1.033"))
                    .addField(new fieldObject().setName("bias").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("scale").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("power").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("2"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString12().getArray())).setType("VERTEX"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString13().getArray())).setType("FRAGMENT")))
                  .addShaders(new ComposedShaderObject().setDEF("freewrl").setLanguage("GLSL")
                    .addField(new fieldObject().setName("fw_textureCoodGenType").setType(fieldObject.TYPE_SFINT32).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0"))
                    .addField(new fieldObject().setName("chromaticDispertion").setType(fieldObject.TYPE_SFVEC3F).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.98 1 1.033"))
                    .addField(new fieldObject().setName("bias").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("scale").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("power").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("2"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString14().getArray())).setType("VERTEX"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString15().getArray())).setType("FRAGMENT")))
                  .addShaders(new ComposedShaderObject().setDEF("x3dom").setLanguage("GLSL")
                    .addField(new fieldObject().setName("cube").setType(fieldObject.TYPE_SFINT32).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0"))
                    .addField(new fieldObject().setName("chromaticDispertion").setType(fieldObject.TYPE_SFVEC3F).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.98 1 1.033"))
                    .addField(new fieldObject().setName("bias").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("scale").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("power").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("2"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString16().getArray())).setType("VERTEX"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString17().getArray())).setType("FRAGMENT")))
                  .addShaders(new ComposedShaderObject().setDEF("instant").setLanguage("GLSL")
                    .addField(new fieldObject().setName("cube").setType(fieldObject.TYPE_SFINT32).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0"))
                    .addField(new fieldObject().setName("chromaticDispertion").setType(fieldObject.TYPE_SFVEC3F).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.98 1 1.033"))
                    .addField(new fieldObject().setName("bias").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("scale").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("power").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("2"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString18().getArray())).setType("VERTEX"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString19().getArray())).setType("FRAGMENT")))
                  .addShaders(new ComposedShaderObject().setDEF("cobweb").setLanguage("GLSL")
                    .addField(new fieldObject().setName("x3d_CubeMapTexture").setType(fieldObject.TYPE_SFINT32).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0"))
                    .addField(new fieldObject().setName("chromaticDispertion").setType(fieldObject.TYPE_SFVEC3F).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.98 1 1.033"))
                    .addField(new fieldObject().setName("bias").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("scale").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5"))
                    .addField(new fieldObject().setName("power").setType(fieldObject.TYPE_SFFLOAT).setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("2"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString20().getArray())).setType("VERTEX"))
                    .addParts(new ShaderPartObject().setUrl(new MFStringObject(new MFString21().getArray())).setType("FRAGMENT"))))
                .setGeometry(new SphereObject())))
            .addChild(new ScriptObject().setDEF("Bounce")
              .addField(new fieldObject().setName("translation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setType(fieldObject.TYPE_SFVEC3F).setValue("0 0 0"))
              .addField(new fieldObject().setName("velocity").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setType(fieldObject.TYPE_SFVEC3F).setValue("0 0 0"))
              .addField(new fieldObject().setName("fraction").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY).setType(fieldObject.TYPE_SFTIME))
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
"			}\n"+
""))
            .addChild(new TimeSensorObject().setDEF("TourTime").setCycleInterval(0.15).setLoop(true))
            .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("cycleTime").setToNode("Bounce").setToField("fraction"))
            .addChild(new ROUTEObject().setFromNode("Bounce").setFromField("translation").setToNode("transform").setToField("translation"))))
        .addChild(new ProtoInstanceObject().setName("Bubble"))
        .addChild(new ProtoInstanceObject().setName("Bubble"))
        .addChild(new ProtoInstanceObject().setName("Bubble")))      ;
    }
protected class MFString0 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/BK.png","http://coderextreme.net/X3DJSONLD/cubemap/BK.png"});
  }
}
protected class MFString1 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/BT.png","http://coderextreme.net/X3DJSONLD/cubemap/BT.png"});
  }
}
protected class MFString2 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/FR.png","http://coderextreme.net/X3DJSONLD/cubemap/FR.png"});
  }
}
protected class MFString3 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/LF.png","http://coderextreme.net/X3DJSONLD/cubemap/LF.png"});
  }
}
protected class MFString4 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/RT.png","http://coderextreme.net/X3DJSONLD/cubemap/RT.png"});
  }
}
protected class MFString5 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/TP.png","http://coderextreme.net/X3DJSONLD/cubemap/TP.png"});
  }
}
protected class MFString6 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/BK.png","http://coderextreme/X3DJSONLD/cubemap/BK.png"});
  }
}
protected class MFString7 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/BT.png","http://coderextreme/X3DJSONLD/cubemap/BT.png"});
  }
}
protected class MFString8 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/FR.png","http://coderextreme/X3DJSONLD/cubemap/FR.png"});
  }
}
protected class MFString9 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/LF.png","http://coderextreme/X3DJSONLD/cubemap/LF.png"});
  }
}
protected class MFString10 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/RT.png","http://coderextreme/X3DJSONLD/cubemap/RT.png"});
  }
}
protected class MFString11 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cubemap/TP.png","http://coderextreme/X3DJSONLD/cubemap/TP.png"});
  }
}
protected class MFString12 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"gl.vs","http://coderextreme.net/X3DJSONLD/gl.vs"});
  }
}
protected class MFString13 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"pc_bubbles.fs","http://coderextreme.net/X3DJSONLD/pc_bubbles.fs"});
  }
}
protected class MFString14 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"freewrl.vs","http://coderextreme.net/X3DJSONLD/freewrl.vs"});
  }
}
protected class MFString15 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"pc_bubbles.fs","http://coderextreme.net/X3DJSONLD/pc_bubbles.fs"});
  }
}
protected class MFString16 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"x3dom.vs","http://coderextreme.net/X3DJSONLD/x3dom.vs"});
  }
}
protected class MFString17 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"pc_bubbles.fs","http://coderextreme.net/X3DJSONLD/pc_bubbles.fs"});
  }
}
protected class MFString18 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"instant.vs","http://coderextreme.net/X3DJSONLD/instant.vs"});
  }
}
protected class MFString19 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"pc_bubbles.fs","http://coderextreme.net/X3DJSONLD/pc_bubbles.fs"});
  }
}
protected class MFString20 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cobweb.vs","http://coderextreme.net/X3DJSONLD/cobweb.vs"});
  }
}
protected class MFString21 {
  protected MFStringObject getArray() {
    return new MFStringObject(new String[] {"cobweb_bubbles.fs","http://coderextreme.net/X3DJSONLD/cobweb_bubbles.fs"});
  }
}
}