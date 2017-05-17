from jnius import autoclass
from X3Dautoclass import *
X3D0 =  X3DObject().setProfile("Immersive").setVersion("3.3")
head1 = headObject()
meta2 = metaObject().setName("title").setContent("x3dconnectorProto")
head1.addMeta(meta2)
meta3 = metaObject().setName("creator").setContent("Lost, Doug Sanden I think")
head1.addMeta(meta3)
meta4 = metaObject().setName("generator").setContent("manual")
head1.addMeta(meta4)
meta5 = metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/x3dconnectorProto.x3d")
head1.addMeta(meta5)
meta6 = metaObject().setName("description").setContent("a generic proto to connect two objects")
head1.addMeta(meta6)
X3D0.setHead(head1)
Scene7 = SceneObject()
Viewpoint8 = ViewpointObject().setPosition([0,0,5]).setDescription("Only Viewpoint")
Scene7.addChild(Viewpoint8)
Background9 = BackgroundObject().setSkyColor([0.4,0.4,0.4])
Scene7.addChild(Background9)
Transform10 = TransformObject().setDEF("G1")
Shape11 = ShapeObject()
Appearance12 = AppearanceObject()
Material13 = MaterialObject().setDiffuseColor([0.7,0.2,0.2])
Appearance12.setMaterial(Material13)
Shape11.setAppearance(Appearance12)
Sphere14 = SphereObject().setRadius(0.1)
Shape11.setGeometry(Sphere14)
Transform10.addChild(Shape11)
PlaneSensor15 = PlaneSensorObject().setDescription("Grab to move").setDEF("PS1")
Transform10.addChild(PlaneSensor15)
ROUTE16 = ROUTEObject().setFromNode("PS1").setFromField("translation_changed").setToNode("G1").setToField("set_translation")
Transform10.addChild(ROUTE16)
Scene7.addChild(Transform10)
Transform17 = TransformObject().setDEF("G2").setTranslation([1,-1,0.01])
Shape18 = ShapeObject()
Appearance19 = AppearanceObject()
Material20 = MaterialObject().setDiffuseColor([0.2,0.7,0.2])
Appearance19.setMaterial(Material20)
Shape18.setAppearance(Appearance19)
Sphere21 = SphereObject().setRadius(0.1)
Shape18.setGeometry(Sphere21)
Transform17.addChild(Shape18)
PlaneSensor22 = PlaneSensorObject().setDescription("Grab to move").setDEF("PS2")
Transform17.addChild(PlaneSensor22)
ROUTE23 = ROUTEObject().setFromNode("PS2").setFromField("translation_changed").setToNode("G2").setToField("set_translation")
Transform17.addChild(ROUTE23)
Scene7.addChild(Transform17)
Transform24 = TransformObject().setDEF("G3").setTranslation([1,1,0.01])
Shape25 = ShapeObject()
Appearance26 = AppearanceObject()
Material27 = MaterialObject().setDiffuseColor([0.2,0.7,0.2])
Appearance26.setMaterial(Material27)
Shape25.setAppearance(Appearance26)
Sphere28 = SphereObject().setRadius(0.1)
Shape25.setGeometry(Sphere28)
Transform24.addChild(Shape25)
PlaneSensor29 = PlaneSensorObject().setDescription("Grab to move").setDEF("PS3")
Transform24.addChild(PlaneSensor29)
ROUTE30 = ROUTEObject().setFromNode("PS3").setFromField("translation_changed").setToNode("G3").setToField("set_translation")
Transform24.addChild(ROUTE30)
Scene7.addChild(Transform24)
Transform31 = TransformObject().setDEF("G4").setTranslation([-1,1,0.01])
Shape32 = ShapeObject()
Appearance33 = AppearanceObject()
Material34 = MaterialObject().setDiffuseColor([0.2,0.7,0.2])
Appearance33.setMaterial(Material34)
Shape32.setAppearance(Appearance33)
Sphere35 = SphereObject().setRadius(0.1)
Shape32.setGeometry(Sphere35)
Transform31.addChild(Shape32)
PlaneSensor36 = PlaneSensorObject().setDescription("Grab to move").setDEF("PS4")
Transform31.addChild(PlaneSensor36)
ROUTE37 = ROUTEObject().setFromNode("PS4").setFromField("translation_changed").setToNode("G4").setToField("set_translation")
Transform31.addChild(ROUTE37)
Scene7.addChild(Transform31)
Transform38 = TransformObject().setDEF("C1")
Shape39 = ShapeObject()
Appearance40 = AppearanceObject()
Material41 = MaterialObject().setDiffuseColor([0.2,0.7,0.7]).setTransparency(0.5)
Appearance40.setMaterial(Material41)
Shape39.setAppearance(Appearance40)
Cylinder42 = CylinderObject().setRadius(0.05)
Shape39.setGeometry(Cylinder42)
Transform38.addChild(Shape39)
Scene7.addChild(Transform38)
Transform43 = TransformObject().setDEF("C2")
Shape44 = ShapeObject()
Appearance45 = AppearanceObject()
Material46 = MaterialObject().setDiffuseColor([0.2,0.7,0.7]).setTransparency(0.5)
Appearance45.setMaterial(Material46)
Shape44.setAppearance(Appearance45)
Cylinder47 = CylinderObject().setRadius(0.05)
Shape44.setGeometry(Cylinder47)
Transform43.addChild(Shape44)
Scene7.addChild(Transform43)
Transform48 = TransformObject().setDEF("C3")
Shape49 = ShapeObject()
Appearance50 = AppearanceObject()
Material51 = MaterialObject().setDiffuseColor([0.2,0.7,0.7]).setTransparency(0.5)
Appearance50.setMaterial(Material51)
Shape49.setAppearance(Appearance50)
Cylinder52 = CylinderObject().setRadius(0.05)
Shape49.setGeometry(Cylinder52)
Transform48.addChild(Shape49)
Scene7.addChild(Transform48)
ProtoDeclare53 = ProtoDeclareObject().setName("x3dconnector")
ProtoInterface54 = ProtoInterfaceObject()
field55 = fieldObject().setType(fieldObject.TYPE_SFNODE).setName("startnode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
ProtoInterface54.addField(field55)
field56 = fieldObject().setType(fieldObject.TYPE_SFNODE).setName("endnode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
ProtoInterface54.addField(field56)
field57 = fieldObject().setType(fieldObject.TYPE_SFNODE).setName("connectornode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
ProtoInterface54.addField(field57)
field58 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("set_startpoint").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY)
ProtoInterface54.addField(field58)
field59 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("set_endpoint").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY)
ProtoInterface54.addField(field59)
ProtoDeclare53.setProtoInterface(ProtoInterface54)
ProtoBody60 = ProtoBodyObject()
Script61 = ScriptObject().setDEF("S1")
field62 = fieldObject().setType(fieldObject.TYPE_SFNODE).setName("startnode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
Script61.addField(field62)
field63 = fieldObject().setType(fieldObject.TYPE_SFNODE).setName("endnode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
Script61.addField(field63)
field64 = fieldObject().setType(fieldObject.TYPE_SFNODE).setName("connectornode").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY)
Script61.addField(field64)
field65 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("set_startpoint").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY)
Script61.addField(field65)
field66 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("set_endpoint").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY)
Script61.addField(field66)
IS67 = ISObject()
connect68 = connectObject().setNodeField("startnode").setProtoField("startnode")
IS67.addConnect(connect68)
connect69 = connectObject().setNodeField("endnode").setProtoField("endnode")
IS67.addConnect(connect69)
connect70 = connectObject().setNodeField("connectornode").setProtoField("connectornode")
IS67.addConnect(connect70)
connect71 = connectObject().setNodeField("set_startpoint").setProtoField("set_startpoint")
IS67.addConnect(connect71)
connect72 = connectObject().setNodeField("set_endpoint").setProtoField("set_endpoint")
IS67.addConnect(connect72)
Script61.setIS(IS67)

Script61.setSourceCode("ecmascript:\n"+
"            function recompute(startpoint,endpoint){\n"+
"	        if (typeof endpoint === 'undefined') {\n"+
"			return;\n"+
"		}\n"+
"                var dif = endpoint.subtract(startpoint);\n"+
"                var dist = dif.length()*.5;\n"+
"                var dif2 = dif.multiply(.5);\n"+
"                var norm = dif.normalize();\n"+
"                var trans = startpoint.add(dif2);\n"+
"                connectornode.scale = new SFVec3f(1.0,dist,1.0);\n"+
"                connectornode.translation = trans;\n"+
"                connectornode.rotation = new SFRotation(new SFVec3f(0.0,1.0,0.0),norm);\n"+
"                //Browser.print('norm='+norm.toString());\n"+
"                //Browser.print('rotation='+rotation.toString());\n"+
"            }\n"+
"            function initialize(){\n"+
"                recompute(startnode.translation,endnode.translation);\n"+
"            }\n"+
"            function set_startpoint(val,t){\n"+
"                recompute(val,endnode.translation);\n"+
"            }\n"+
"            function set_endpoint(val,t){\n"+
"                recompute(startnode.translation,val);\n"+
"            }\n"+
"")
ProtoBody60.addChild(Script61)
ProtoDeclare53.setProtoBody(ProtoBody60)
Scene7.addChild(ProtoDeclare53)
ProtoInstance73 = ProtoInstanceObject().setName("x3dconnector").setDEF("connector1")
fieldValue74 = fieldValueObject().setName("startnode")
Transform75 = TransformObject().setUSE("G1")
fieldValue74.addChild(Transform75)
ProtoInstance73.addFieldValue(fieldValue74)
fieldValue76 = fieldValueObject().setName("endnode")
Transform77 = TransformObject().setUSE("G2")
fieldValue76.addChild(Transform77)
ProtoInstance73.addFieldValue(fieldValue76)
fieldValue78 = fieldValueObject().setName("connectornode")
Transform79 = TransformObject().setUSE("C1")
fieldValue78.addChild(Transform79)
ProtoInstance73.addFieldValue(fieldValue78)
fieldValue80 = fieldValueObject().setName("set_startpoint")
ProtoInstance73.addFieldValue(fieldValue80)
fieldValue81 = fieldValueObject().setName("set_endpoint")
ProtoInstance73.addFieldValue(fieldValue81)
Scene7.addChild(ProtoInstance73)
ProtoInstance82 = ProtoInstanceObject().setName("x3dconnector").setDEF("connector2")
fieldValue83 = fieldValueObject().setName("startnode")
Transform84 = TransformObject().setUSE("G1")
fieldValue83.addChild(Transform84)
ProtoInstance82.addFieldValue(fieldValue83)
fieldValue85 = fieldValueObject().setName("endnode")
Transform86 = TransformObject().setUSE("G3")
fieldValue85.addChild(Transform86)
ProtoInstance82.addFieldValue(fieldValue85)
fieldValue87 = fieldValueObject().setName("connectornode")
Transform88 = TransformObject().setUSE("C2")
fieldValue87.addChild(Transform88)
ProtoInstance82.addFieldValue(fieldValue87)
fieldValue89 = fieldValueObject().setName("set_startpoint")
ProtoInstance82.addFieldValue(fieldValue89)
fieldValue90 = fieldValueObject().setName("set_endpoint")
ProtoInstance82.addFieldValue(fieldValue90)
Scene7.addChild(ProtoInstance82)
ProtoInstance91 = ProtoInstanceObject().setName("x3dconnector").setDEF("connector3")
fieldValue92 = fieldValueObject().setName("startnode")
Transform93 = TransformObject().setUSE("G1")
fieldValue92.addChild(Transform93)
ProtoInstance91.addFieldValue(fieldValue92)
fieldValue94 = fieldValueObject().setName("endnode")
Transform95 = TransformObject().setUSE("G4")
fieldValue94.addChild(Transform95)
ProtoInstance91.addFieldValue(fieldValue94)
fieldValue96 = fieldValueObject().setName("connectornode")
Transform97 = TransformObject().setUSE("C3")
fieldValue96.addChild(Transform97)
ProtoInstance91.addFieldValue(fieldValue96)
fieldValue98 = fieldValueObject().setName("set_startpoint")
ProtoInstance91.addFieldValue(fieldValue98)
fieldValue99 = fieldValueObject().setName("set_endpoint")
ProtoInstance91.addFieldValue(fieldValue99)
Scene7.addChild(ProtoInstance91)
ROUTE100 = ROUTEObject().setFromNode("G1").setFromField("translation_changed").setToNode("connector1").setToField("set_startpoint")
Scene7.addChild(ROUTE100)
ROUTE101 = ROUTEObject().setFromNode("G2").setFromField("translation_changed").setToNode("connector1").setToField("set_endpoint")
Scene7.addChild(ROUTE101)
ROUTE102 = ROUTEObject().setFromNode("G1").setFromField("translation_changed").setToNode("connector2").setToField("set_startpoint")
Scene7.addChild(ROUTE102)
ROUTE103 = ROUTEObject().setFromNode("G3").setFromField("translation_changed").setToNode("connector2").setToField("set_endpoint")
Scene7.addChild(ROUTE103)
ROUTE104 = ROUTEObject().setFromNode("G1").setFromField("translation_changed").setToNode("connector3").setToField("set_startpoint")
Scene7.addChild(ROUTE104)
ROUTE105 = ROUTEObject().setFromNode("G4").setFromField("translation_changed").setToNode("connector3").setToField("set_endpoint")
Scene7.addChild(ROUTE105)
X3D0.setScene(Scene7)

X3D0.toFileX3D("../out/orig/x3dconnectorProto.new.x3d")
