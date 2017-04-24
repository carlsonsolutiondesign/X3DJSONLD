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
public class force {
  public static void main(String[] args) {
    ConfigurationProperties.setShowDefaultAttributes(true);
    ConfigurationProperties.setXsltEngine(ConfigurationProperties.XSLT_ENGINE_nativeJava);
    ConfigurationProperties.setDeleteIntermediateFiles(false);
    new force().initialize().toFileJSON("force.new.json");
    }
    public X3DObject initialize() {
      return new X3DObject().setProfile("Immersive").setVersion("3.3")
      .setHead(new headObject()
        .addMeta(new metaObject().setName("creator").setContent("John W Carlson"))
        .addMeta(new metaObject().setName("created").setContent("December 13 2015"))
        .addMeta(new metaObject().setName("title").setContent("force.x3d"))
        .addMeta(new metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/force.x3d"))
        .addMeta(new metaObject().setName("description").setContent("beginnings of a force directed graph in 3D"))
        .addMeta(new metaObject().setName("generator").setContent("Vim, X3D-Edit, https://savage.nps.edu/X3D-Edit")))
      .setScene(new SceneObject()
        .addChild(new ProtoDeclareObject().setName("node")
          .setProtoInterface(new ProtoInterfaceObject()
            .addField(new fieldObject().setName("position").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setType(fieldObject.TYPE_SFVEC3F).setValue("0 0 0")))
          .setProtoBody(new ProtoBodyObject()
            .addChild(new TransformObject().setDEF("transform")
              .setIS(new ISObject()
                .addConnect(new connectObject().setNodeField("translation").setProtoField("position")))
              .addChild(new ShapeObject()
                .setGeometry(new SphereObject())
                .setAppearance(new AppearanceObject()
                  .setMaterial(new MaterialObject().setDiffuseColor(new float[] {1f,0f,0f}))))
              .addChild(new TransformObject().setTranslation(new float[] {1f,0f,0f})
                .addChild(new ShapeObject()
                  .setGeometry(new TextObject().setString(new MFStringObject(new MFString0().getArray()))
                    .setFontStyle(new FontStyleObject().setJustify(new MFStringObject(new MFString1().getArray())).setSize(5f)))
                  .setAppearance(new AppearanceObject()
                    .setMaterial(new MaterialObject().setDiffuseColor(new float[] {0f,0f,1f}))))))
            .addChild(new PositionInterpolatorObject().setDEF("NodePosition").setKey(new MFFloatObject(new MFFloat2().getArray())).setKeyValue(new MFVec3fObject(new MFVec3f3().getArray())))
            .addChild(new ScriptObject().setDEF("MoveBall")
              .addField(new fieldObject().setName("translation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setType(fieldObject.TYPE_SFVEC3F).setValue("50 50 0"))
              .addField(new fieldObject().setName("old").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setType(fieldObject.TYPE_SFVEC3F).setValue("0 0 0"))
              .addField(new fieldObject().setName("set_cycle").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY).setType(fieldObject.TYPE_SFTIME))
              .addField(new fieldObject().setName("keyValue").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY).setType(fieldObject.TYPE_MFVEC3F))
              .setSourceCode("ecmascript:\n"+
"					function set_cycle(value) {\n"+
"                                                old = translation;\n"+
"						translation = new SFVec3f(Math.random()*100-50, Math.random()*100-50, Math.random()*100-50);\n"+
"                                                keyValue = new MFVec3f(old, translation);\n"+
"						// Browser.println(translation);\n"+
"					}\n"+
""))
            .addChild(new TimeSensorObject().setDEF("nodeClock").setCycleInterval(3d).setLoop(true))
            .addChild(new ROUTEObject().setFromNode("nodeClock").setFromField("cycleTime").setToNode("MoveBall").setToField("set_cycle"))
            .addChild(new ROUTEObject().setFromNode("nodeClock").setFromField("fraction_changed").setToNode("NodePosition").setToField("set_fraction"))
            .addChild(new ROUTEObject().setFromNode("MoveBall").setFromField("keyValue").setToNode("NodePosition").setToField("keyValue"))
            .addChild(new ROUTEObject().setFromNode("NodePosition").setFromField("value_changed").setToNode("transform").setToField("set_translation"))))
        .addChild(new ProtoDeclareObject().setName("cylinder")
          .setProtoInterface(new ProtoInterfaceObject()
            .addField(new fieldObject().setName("positionA").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY).setType(fieldObject.TYPE_SFVEC3F))
            .addField(new fieldObject().setName("positionB").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY).setType(fieldObject.TYPE_SFVEC3F)))
          .setProtoBody(new ProtoBodyObject()
            .addChild(new ShapeObject()
              .setGeometry(new ExtrusionObject().setDEF("extrusion").setCreaseAngle(0.785f).setCrossSection(new MFVec2fObject(new MFVec2f4().getArray())).setSpine(new MFVec3fObject(new MFVec3f5().getArray())))
              .setAppearance(new AppearanceObject()
                .setMaterial(new MaterialObject().setDiffuseColor(new float[] {0f,1f,0f}))))
            .addChild(new ScriptObject().setDEF("MoveCylinder")
              .addField(new fieldObject().setName("spine").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setType(fieldObject.TYPE_MFVEC3F).setValue("0 -50 0 0 50 0"))
              .addField(new fieldObject().setName("set_endA").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY).setType(fieldObject.TYPE_SFVEC3F))
              .addField(new fieldObject().setName("set_endB").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY).setType(fieldObject.TYPE_SFVEC3F))
              .setIS(new ISObject()
                .addConnect(new connectObject().setNodeField("set_endA").setProtoField("positionA"))
                .addConnect(new connectObject().setNodeField("set_endB").setProtoField("positionB")))
              .setSourceCode("ecmascript:\n"+
"\n"+
"                function set_endA(value) {\n"+
"		    if (typeof spine === 'undefined') {\n"+
"		        spine = new MFVec3f(value, value);\n"+
"		    } else {\n"+
"		        spine = new MFVec3f(value, spine[1]);\n"+
"		    }\n"+
"                }\n"+
"                \n"+
"                function set_endB(value) {\n"+
"		    if (typeof spine === 'undefined') {\n"+
"		        spine = new MFVec3f(value, value);\n"+
"		    } else {\n"+
"		        spine = new MFVec3f(spine[0], value);\n"+
"		    }\n"+
"                }\n"+
"                \n"+
"                function set_spine(value) {\n"+
"                    spine = value;\n"+
"                }\n"+
""))
            .addChild(new ROUTEObject().setFromNode("MoveCylinder").setFromField("spine").setToNode("extrusion").setToField("set_spine"))))
        .addChild(new TransformObject().setDEF("HoldsContent").setScale(new float[] {0.1f,0.1f,0.1f})
          .addChild(new PlaneSensorObject().setDEF("clickGenerator").setMinPosition(new float[] {-50f,-50f}).setMaxPosition(new float[] {50f,50f}).setDescription("click on background to add nodes, click on nodes to add links"))
          .addChild(new ProtoInstanceObject().setName("node").setDEF("nodeA")
            .addFieldValue(new fieldValueObject().setName("position").setValue("0 0 0")))
          .addChild(new ProtoInstanceObject().setName("node").setDEF("nodeB")
            .addFieldValue(new fieldValueObject().setName("position").setValue("50 50 50")))
          .addChild(new ProtoInstanceObject().setName("node").setDEF("nodeC")
            .addFieldValue(new fieldValueObject().setName("position").setValue("-50 -50 -50")))
          .addChild(new ProtoInstanceObject().setName("node").setDEF("nodeD")
            .addFieldValue(new fieldValueObject().setName("position").setValue("50 50 -50")))
          .addChild(new ProtoInstanceObject().setName("cylinder").setDEF("linkA")
            .addFieldValue(new fieldValueObject().setName("positionA").setValue("0 0 0"))
            .addFieldValue(new fieldValueObject().setName("positionB").setValue("50 50 50")))
          .addChild(new ProtoInstanceObject().setName("cylinder").setDEF("linkB")
            .addFieldValue(new fieldValueObject().setName("positionA").setValue("0 0 0"))
            .addFieldValue(new fieldValueObject().setName("positionB").setValue("-50 -50 -50")))
          .addChild(new ProtoInstanceObject().setName("cylinder").setDEF("linkC")
            .addFieldValue(new fieldValueObject().setName("positionA").setValue("50 50 50"))
            .addFieldValue(new fieldValueObject().setName("positionB").setValue("50 50 -50"))))
        .addChild(new ScriptObject().setDEF("clickHandler")
          .addField(new fieldObject().setName("counter").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0").setType(fieldObject.TYPE_SFINT32))
          .addField(new fieldObject().setName("node_changed").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY).setType(fieldObject.TYPE_SFNODE))
          .addField(new fieldObject().setName("add_node").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY).setValue("0").setType(fieldObject.TYPE_SFBOOL))
          .addField(new fieldObject().setName("ModifiableNode").setType(fieldObject.TYPE_SFNODE).setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
            .addChild(new TransformObject().setUSE("HoldsContent")))
          .setSourceCode("ecmascript:\n"+
"	function add_node(value) {\n"+
"                // Browser.print('hey ', counter);\n"+
"                counter = counter++;\n"+
"		Browser.appendTo(Browser.getDocument().getElementById(\"MN\"),\n"+
"			{ \"ProtoInstance\":\n"+
"				{ \"@name\":\"node\",\n"+
"				  \"@DEF\":\"node'+counter+'\",\n"+
"				  \"fieldValue\": [\n"+
"					{\n"+
"						 \"@name\":\"position\",\n"+
"						 \"@value\":[0.0,0.0,0.0]\n"+
"					}\n"+
"				  ]\n"+
"				}\n"+
"			});\n"+
"                \n"+
"        }\n"+
""))
        .addChild(new ROUTEObject().setFromNode("clickGenerator").setFromField("isActive").setToNode("clickHandler").setToField("add_node"))
        .addChild(new ROUTEObject().setFromNode("nodeA").setFromField("position").setToNode("linkA").setToField("positionA"))
        .addChild(new ROUTEObject().setFromNode("nodeB").setFromField("position").setToNode("linkA").setToField("positionB"))
        .addChild(new ROUTEObject().setFromNode("nodeA").setFromField("position").setToNode("linkB").setToField("positionA"))
        .addChild(new ROUTEObject().setFromNode("nodeC").setFromField("position").setToNode("linkB").setToField("positionB"))
        .addChild(new ROUTEObject().setFromNode("nodeA").setFromField("position").setToNode("linkC").setToField("positionA"))
        .addChild(new ROUTEObject().setFromNode("nodeD").setFromField("position").setToNode("linkC").setToField("positionB")))      ;
    }
protected class MFString0 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"Node"});
  }
}
protected class MFString1 {
  protected MFStringObject getArray() {
    return new MFStringObject(new java.lang.String[] {"MIDDLE","MIDDLE"});
  }
}
protected class MFFloat2 {
  protected MFFloatObject getArray() {
    return new MFFloatObject(new float[] {0f,1f});
  }
}
protected class MFVec3f3 {
  protected MFVec3fObject getArray() {
    return new MFVec3fObject(new float[] {0f,0f,0f,0f,5f,0f});
  }
}
protected class MFVec2f4 {
  protected MFVec2fObject getArray() {
    return new MFVec2fObject(new float[] {1f,0f,0.92f,-0.38f,0.71f,-0.71f,0.38f,-0.92f,0f,-1f,-0.38f,-0.92f,-0.71f,-0.71f,-0.92f,-0.38f,-1f,0f,-0.92f,0.38f,-0.71f,0.71f,-0.38f,0.92f,0f,1f,0.38f,0.92f,0.71f,0.71f,0.92f,0.38f,1f,0f});
  }
}
protected class MFVec3f5 {
  protected MFVec3fObject getArray() {
    return new MFVec3fObject(new float[] {0f,-50f,0f,0f,50f,0f});
  }
}
}
