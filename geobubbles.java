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
public class geobubbles {
  public static void main(String[] args) {
    ConfigurationProperties.setShowDefaultAttributes(true);
    ConfigurationProperties.setXsltEngine(ConfigurationProperties.XSLT_ENGINE_nativeJava);
    ConfigurationProperties.setDeleteIntermediateFiles(false);
    new geobubbles().initialize().toFileJSON("geobubbles.new.json");
    }
    public X3DObject initialize() {
      return new X3DObject().setProfile("Immersive").setVersion("3.3")
      .setHead(new headObject()
        .addComponent(new componentObject().setName("Geospatial").setLevel(1))
        .addMeta(new metaObject().setName("title").setContent("geobubbles.x3d"))
        .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
        .addMeta(new metaObject().setName("generator").setContent("manual"))
        .addMeta(new metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/geobubbles.x3d"))
        .addMeta(new metaObject().setName("description").setContent("geo bubbles")))
      .setScene(new SceneObject()
        .addComments(new CommentsBlock("Viewpoint DEF='Tour' position='0 0 4' orientation='1 0 0 0' description='Tour Views'/"))
        .addComments(new CommentsBlock("PositionInterpolator DEF='TourPosition' key='0 1' keyValue='-0.5 -0.5 4 -0.5 0.5 4'/"))
        .addChild(new GeoViewpointObject().setDEF("Tour").setPosition(new double[] {0d,0d,4d}).setOrientation(new float[] {1f,0f,0f,0f}).setDescription("Tour Views"))
        .addChild(new BackgroundObject().setBackUrl(new MFStringObject(MFString0())).setBottomUrl(new MFStringObject(MFString1())).setFrontUrl(new MFStringObject(MFString2())).setLeftUrl(new MFStringObject(MFString3())).setRightUrl(new MFStringObject(MFString4())).setTopUrl(new MFStringObject(MFString5())))
        .addChild(new TransformObject()
          .addChild(new ShapeObject()
            .setGeometry(new SphereObject())
            .setAppearance(new AppearanceObject()
              .setMaterial(new MaterialObject().setDiffuseColor(new float[] {0.7f,0.7f,0.7f}).setSpecularColor(new float[] {0.5f,0.5f,0.5f})))))
        .addChild(new TimeSensorObject().setDEF("TourTime").setCycleInterval(5).setLoop(true))
        .addChild(new GeoPositionInterpolatorObject().setDEF("TourPosition").setKey(new MFFloatObject(MFFloat6())).setKeyValue(new MFVec3dObject(MFVec3d7())))
        .addChild(new ScriptObject().setDEF("RandomTourTime")
          .addField(new fieldObject().setName("set_cycle").setAccessType("inputOnly").setType(fieldObject.TYPE_SFTIME))
          .addField(new fieldObject().setName("val").setAccessType("inputOutput").setType(fieldObject.TYPE_SFFLOAT).setValue("0"))
          .addField(new fieldObject().setName("positions").setAccessType("inputOutput").setType(fieldObject.TYPE_MFVEC3D).setValue("0.0015708 0 4 0 0.0015708 4"))
          .addField(new fieldObject().setName("position").setAccessType("inputOutput").setType(fieldObject.TYPE_MFVEC3D).setValue("0.0015708 0 4 0 0.0015708 4"))
          .setSourceCode("ecmascript:\n"+
"\n"+
"               function set_cycle(value) {\n"+
"                        var cartesianMult = -150;  // -150 if cartesian, 1 if geo\n"+
"                        var ov = val;\n"+
"			// Browser.print('old '+ov);\n"+
"                        do {\n"+
"                                val = Math.floor(Math.random()*2);\n"+
"                                var vc = val;\n"+
"                                positions[vc] = new SFVec3d(Math.round(Math.random()*2)*0.0015708*cartesianMult, Math.round(Math.random()*2)*0.0015708*cartesianMult, 4);\n"+
"                        } while ( positions[ov][0] === positions[vc][0] && positions[ov][1] === positions[vc][1] && positions[ov][2] === positions[vc][2]);\n"+
"			// Browser.println(positions[ov]);\n"+
"			// Browser.println(positions[vc]);\n"+
"                        position = new MFVec3d();\n"+
"                        position[0] = new SFVec3d(positions[ov][0],positions[ov][1],positions[ov][2]);\n"+
"                        position[1] = new SFVec3d(positions[vc][0],positions[vc][1],positions[vc][2]);\n"+
"               }\n"+
""))
        .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("cycleTime").setToNode("RandomTourTime").setToField("set_cycle"))
        .addChild(new ROUTEObject().setFromNode("RandomTourTime").setFromField("position").setToNode("TourPosition").setToField("keyValue"))
        .addChild(new ROUTEObject().setFromNode("TourTime").setFromField("fraction_changed").setToNode("TourPosition").setToField("set_fraction"))
        .addChild(new ROUTEObject().setFromNode("TourPosition").setFromField("value_changed").setToNode("Tour").setToField("set_position")))      ;
    }
private MFStringObject MFString0() {
  return new MFStringObject( new String[] {"cubemap/BK.png","http://coderextreme.net/X3DJSONLD/cubemap/BK.png"})
;
}
private MFStringObject MFString1() {
  return new MFStringObject( new String[] {"cubemap/BT.png","http://coderextreme.net/X3DJSONLD/cubemap/BT.png"})
;
}
private MFStringObject MFString2() {
  return new MFStringObject( new String[] {"cubemap/FR.png","http://coderextreme.net/X3DJSONLD/cubemap/FR.png"})
;
}
private MFStringObject MFString3() {
  return new MFStringObject( new String[] {"cubemap/LF.png","http://coderextreme.net/X3DJSONLD/cubemap/LF.png"})
;
}
private MFStringObject MFString4() {
  return new MFStringObject( new String[] {"cubemap/RT.png","http://coderextreme.net/X3DJSONLD/cubemap/RT.png"})
;
}
private MFStringObject MFString5() {
  return new MFStringObject( new String[] {"cubemap/TP.png","http://coderextreme.net/X3DJSONLD/cubemap/TP.png"})
;
}
private MFFloatObject MFFloat6() {
  return new MFFloatObject( new float[] {0f,1f})
;
}
private MFVec3dObject MFVec3d7() {
  return new MFVec3dObject( new double[] {0.0015708d,0d,4d,0d,0.0015708d,4d})
;
}
}
