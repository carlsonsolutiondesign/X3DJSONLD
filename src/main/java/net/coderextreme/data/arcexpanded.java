package net.coderextreme.data;
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
public class arcexpanded {
  public static void main(String[] args) {
    ConfigurationProperties.setShowDefaultAttributes(true);
    ConfigurationProperties.setXsltEngine(ConfigurationProperties.XSLT_ENGINE_nativeJava);
    ConfigurationProperties.setDeleteIntermediateFiles(false);
    new arcexpanded().initialize().toFileJSON("../data/arcexpanded.new.json");
    }
    public X3DObject initialize() {
      X3DObject X3D0 =  new X3DObject().setProfile("Immersive").setVersion("3.3")
      .setHead(new headObject()
        .addMeta(new metaObject().setName("title").setContent("arc.x3d"))
        .addMeta(new metaObject().setName("creator").setContent("John Carlson"))
        .addMeta(new metaObject().setName("generator").setContent("manual"))
        .addMeta(new metaObject().setName("identifier").setContent("https://coderextreme.net/X3DJSONLD/arc.x3d"))
        .addMeta(new metaObject().setName("description").setContent("an attempt to implement an arc in a graph")))
      .setScene(new SceneObject()
        .addChild(new ViewpointObject().setPosition(new float[] {0f,0f,5f}).setDescription("a moving graph"))
        .addChild(new BackgroundObject().setSkyColor(new MFColorObject(new MFColor0().getArray())))
        .addChild(new TransformObject().setDEF("cylinder1")
          .addChild(new ShapeObject()
            .setAppearance(new AppearanceObject()
              .setMaterial(new MaterialObject().setDiffuseColor(new float[] {0.2f,0.7f,0.7f})))
            .setGeometry(new CylinderObject().setRadius(0.1f))))
        .addComments(new CommentsBlock("from doug sanden"))
        .addChild(new TransformObject().setDEF("DECLpoint_start_node").setTranslation(new float[] {0f,0f,0f})
          .addChild(new ShapeObject()
            .setGeometry(new SphereObject().setRadius(0.1f))
            .setAppearance(new AppearanceObject()
              .setMaterial(new MaterialObject().setDiffuseColor(new float[] {1f,0f,0f}))))
          .addChild(new PositionInterpolatorObject().setDEF("DECLpoint_start_PI1").setKey(new MFFloatObject(new MFFloat1().getArray())).setKeyValue(new MFVec3fObject(new MFVec3f2().getArray())))
          .addChild(new ScriptObject().setDEF("DECLpoint_start_MB1")
            .addField(new fieldObject().setType("SFVec3f").setName("translation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0"))
            .addField(new fieldObject().setType("SFVec3f").setName("old").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0"))
            .addField(new fieldObject().setType("SFTime").setName("set_location").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY))
            .addField(new fieldObject().setType("MFVec3f").setName("keyValue").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY))
            .setSourceCode("\n"+
"\n"+
"ecmascript:\n"+
"		function set_location(value) {\n"+
"                    old = translation;\n"+
"		    translation = new SFVec3f(Math.random()*10-5, Math.random()*10-5, Math.random()*10-5);\n"+
"                    keyValue = new MFVec3f([old, translation]);\n"+
"		    // Browser.println(translation);\n"+
"		}\n"+
""))
          .addChild(new TimeSensorObject().setDEF("DECLpoint_start_CL1").setCycleInterval(3d).setLoop(true))
          .addChild(new ROUTEObject().setFromNode("DECLpoint_start_CL1").setFromField("cycleTime").setToNode("DECLpoint_start_MB1").setToField("set_location"))
          .addChild(new ROUTEObject().setFromNode("DECLpoint_start_CL1").setFromField("fraction_changed").setToNode("DECLpoint_start_PI1").setToField("set_fraction"))
          .addChild(new ROUTEObject().setFromNode("DECLpoint_start_MB1").setFromField("keyValue").setToNode("DECLpoint_start_PI1").setToField("keyValue"))
          .addChild(new ROUTEObject().setFromNode("DECLpoint_start_PI1").setFromField("value_changed").setToNode("DECLpoint_start_node").setToField("set_translation")))
        .addChild(new TransformObject().setDEF("DECLpoint_end_node").setTranslation(new float[] {0f,0f,0f})
          .addChild(new ShapeObject()
            .setGeometry(new SphereObject().setRadius(0.1f))
            .setAppearance(new AppearanceObject()
              .setMaterial(new MaterialObject().setDiffuseColor(new float[] {1f,0f,0f}))))
          .addChild(new PositionInterpolatorObject().setDEF("DECLpoint_end_PI1").setKey(new MFFloatObject(new MFFloat3().getArray())).setKeyValue(new MFVec3fObject(new MFVec3f4().getArray())))
          .addChild(new ScriptObject().setDEF("DECLpoint_end_MB1")
            .addField(new fieldObject().setType("SFVec3f").setName("translation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0"))
            .addField(new fieldObject().setType("SFVec3f").setName("old").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0"))
            .addField(new fieldObject().setType("SFTime").setName("set_location").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY))
            .addField(new fieldObject().setType("MFVec3f").setName("keyValue").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY))
            .setSourceCode("\n"+
"\n"+
"ecmascript:\n"+
"		function set_location(value) {\n"+
"                    old = translation;\n"+
"		    translation = new SFVec3f(Math.random()*10-5, Math.random()*10-5, Math.random()*10-5);\n"+
"                    keyValue = new MFVec3f([old, translation]);\n"+
"		    // Browser.println(translation);\n"+
"		}\n"+
""))
          .addChild(new TimeSensorObject().setDEF("DECLpoint_end_CL1").setCycleInterval(3d).setLoop(true))
          .addChild(new ROUTEObject().setFromNode("DECLpoint_end_CL1").setFromField("cycleTime").setToNode("DECLpoint_end_MB1").setToField("set_location"))
          .addChild(new ROUTEObject().setFromNode("DECLpoint_end_CL1").setFromField("fraction_changed").setToNode("DECLpoint_end_PI1").setToField("set_fraction"))
          .addChild(new ROUTEObject().setFromNode("DECLpoint_end_MB1").setFromField("keyValue").setToNode("DECLpoint_end_PI1").setToField("keyValue"))
          .addChild(new ROUTEObject().setFromNode("DECLpoint_end_PI1").setFromField("value_changed").setToNode("DECLpoint_end_node").setToField("set_translation")))
        .addChild(new ScriptObject().setDEF("DECLx3dconnector_connector1_S1")
          .addField(new fieldObject().setType("SFNode").setName("startnode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
            .addChild(new TransformObject().setDEF("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_node").setUSE("DECLpoint_start")
              .addChild(new ShapeObject()
                .setGeometry(new SphereObject().setRadius(0.1f))
                .setAppearance(new AppearanceObject()
                  .setMaterial(new MaterialObject().setDiffuseColor(new float[] {1f,0f,0f}))))
              .addChild(new PositionInterpolatorObject().setDEF("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_PI1").setKey(new MFFloatObject(new MFFloat5().getArray())).setKeyValue(new MFVec3fObject(new MFVec3f6().getArray())))
              .addChild(new ScriptObject().setDEF("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_MB1")
                .addField(new fieldObject().setType("SFVec3f").setName("translation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("50 50 0"))
                .addField(new fieldObject().setType("SFVec3f").setName("old").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0"))
                .addField(new fieldObject().setType("SFTime").setName("set_location").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY))
                .addField(new fieldObject().setType("MFVec3f").setName("keyValue").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY))
                .setSourceCode("\n"+
"\n"+
"ecmascript:\n"+
"		function set_location(value) {\n"+
"                    old = translation;\n"+
"		    translation = new SFVec3f(Math.random()*10-5, Math.random()*10-5, Math.random()*10-5);\n"+
"                    keyValue = new MFVec3f([old, translation]);\n"+
"		    // Browser.println(translation);\n"+
"		}\n"+
""))
              .addChild(new TimeSensorObject().setDEF("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_CL1").setCycleInterval(3d).setLoop(true))
              .addChild(new ROUTEObject().setFromNode("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_CL1").setFromField("cycleTime").setToNode("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_MB1").setToField("set_location"))
              .addChild(new ROUTEObject().setFromNode("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_CL1").setFromField("fraction_changed").setToNode("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_PI1").setToField("set_fraction"))
              .addChild(new ROUTEObject().setFromNode("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_MB1").setFromField("keyValue").setToNode("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_PI1").setToField("keyValue"))
              .addChild(new ROUTEObject().setFromNode("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_PI1").setFromField("value_changed").setToNode("DECLx3dconnector_connector1_FIELDstartnode_DECLpoint_INSTANCE_node").setToField("set_translation"))))
          .addField(new fieldObject().setType("SFNode").setName("endnode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
            .addChild(new TransformObject().setDEF("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_node").setUSE("DECLpoint_end")
              .addChild(new ShapeObject()
                .setGeometry(new SphereObject().setRadius(0.1f))
                .setAppearance(new AppearanceObject()
                  .setMaterial(new MaterialObject().setDiffuseColor(new float[] {1f,0f,0f}))))
              .addChild(new PositionInterpolatorObject().setDEF("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_PI1").setKey(new MFFloatObject(new MFFloat7().getArray())).setKeyValue(new MFVec3fObject(new MFVec3f8().getArray())))
              .addChild(new ScriptObject().setDEF("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_MB1")
                .addField(new fieldObject().setType("SFVec3f").setName("translation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("50 50 0"))
                .addField(new fieldObject().setType("SFVec3f").setName("old").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0"))
                .addField(new fieldObject().setType("SFTime").setName("set_location").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY))
                .addField(new fieldObject().setType("MFVec3f").setName("keyValue").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY))
                .setSourceCode("\n"+
"\n"+
"ecmascript:\n"+
"		function set_location(value) {\n"+
"                    old = translation;\n"+
"		    translation = new SFVec3f(Math.random()*10-5, Math.random()*10-5, Math.random()*10-5);\n"+
"                    keyValue = new MFVec3f([old, translation]);\n"+
"		    // Browser.println(translation);\n"+
"		}\n"+
""))
              .addChild(new TimeSensorObject().setDEF("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_CL1").setCycleInterval(3d).setLoop(true))
              .addChild(new ROUTEObject().setFromNode("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_CL1").setFromField("cycleTime").setToNode("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_MB1").setToField("set_location"))
              .addChild(new ROUTEObject().setFromNode("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_CL1").setFromField("fraction_changed").setToNode("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_PI1").setToField("set_fraction"))
              .addChild(new ROUTEObject().setFromNode("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_MB1").setFromField("keyValue").setToNode("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_PI1").setToField("keyValue"))
              .addChild(new ROUTEObject().setFromNode("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_PI1").setFromField("value_changed").setToNode("DECLx3dconnector_connector1_FIELDendnode_DECLpoint_INSTANCE1000_node").setToField("set_translation"))))
          .addField(new fieldObject().setType("SFNode").setName("connectornode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
            .addChild(new TransformObject().setUSE("cylinder1")))
          .addField(new fieldObject().setType("SFVec3f").setName("set_startpoint").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY))
          .addField(new fieldObject().setType("SFVec3f").setName("set_endpoint").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY))
          .setSourceCode("\n"+
"            ecmascript:\n"+
"            \n"+
"        function recompute(startpoint,endpoint){\n"+
"	    if (typeof endpoint === 'undefined') {\n"+
"		return;\n"+
"	    }\n"+
"            var dif = endpoint.subtract(startpoint);\n"+
"            var dist = dif.length()*0.5;\n"+
"            var dif2 = dif.multiply(0.5);\n"+
"            var norm = dif.normalize();\n"+
"            var transl = startpoint.add(dif2);\n"+
"	    return {\n"+
"		    scale : new SFVec3f(1.0,dist,1.0),\n"+
"		    translation : transl,\n"+
"		    rotation : new SFRotation(new SFVec3f(0.0,1.0,0.0),norm)\n"+
"	    	    // rotation : new x3dom.fields.Quaternion.rotateFromTo(new SFVec3f(0.0,1.0,0.0), norm)\n"+
"	    };\n"+
"	}\n"+
"	function recompute_and_route(startpoint, endpoint) {\n"+
"	      var trafo = recompute(startpoint, endpoint);\n"+
"	      connectornode.translation = trafo.translation;\n"+
"	      connectornode.rotation = trafo.rotation;\n"+
"	      connectornode.scale = trafo.scale;\n"+
"	}\n"+
"        function initialize(){\n"+
"            recompute_and_route(startnode.translation,endnode.translation);\n"+
"        }\n"+
"        function set_startpoint(val,t){\n"+
"            recompute_and_route(val,endnode.translation);\n"+
"        }\n"+
"        function set_endpoint(val,t){\n"+
"            recompute_and_route(startnode.translation,val);\n"+
"        }\n"+
""))
        .addChild(new ROUTEObject().setFromNode("DECLpoint_start_DECLpoint_start_MB1").setFromField("translation").setToNode("DECLx3dconnector_connector1_DECLx3dconnector_connector1_S1").setToField("set_startpoint"))
        .addChild(new ROUTEObject().setFromNode("DECLpoint_end_DECLpoint_end_MB1").setFromField("translation").setToNode("DECLx3dconnector_connector1_DECLx3dconnector_connector1_S1").setToField("set_endpoint")))      ;
    return X3D0;
    }
protected class MFColor0 {
  protected MFColorObject getArray() {
    return new MFColorObject(new float[] {0.4f,0.4f,0.4f});
  }
}
protected class MFFloat1 {
  protected MFFloatObject getArray() {
    return new MFFloatObject(new float[] {0f,1f});
  }
}
protected class MFVec3f2 {
  protected MFVec3fObject getArray() {
    return new MFVec3fObject(new float[] {0f,0f,0f,0f,5f,0f});
  }
}
protected class MFFloat3 {
  protected MFFloatObject getArray() {
    return new MFFloatObject(new float[] {0f,1f});
  }
}
protected class MFVec3f4 {
  protected MFVec3fObject getArray() {
    return new MFVec3fObject(new float[] {0f,0f,0f,0f,5f,0f});
  }
}
protected class MFFloat5 {
  protected MFFloatObject getArray() {
    return new MFFloatObject(new float[] {0f,1f});
  }
}
protected class MFVec3f6 {
  protected MFVec3fObject getArray() {
    return new MFVec3fObject(new float[] {0f,0f,0f,0f,5f,0f});
  }
}
protected class MFFloat7 {
  protected MFFloatObject getArray() {
    return new MFFloatObject(new float[] {0f,1f});
  }
}
protected class MFVec3f8 {
  protected MFVec3fObject getArray() {
    return new MFVec3fObject(new float[] {0f,0f,0f,0f,5f,0f});
  }
}
}
