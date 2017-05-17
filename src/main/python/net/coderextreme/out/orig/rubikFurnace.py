from jnius import autoclass
from X3Dautoclass import *
X3D0 =  X3DObject().setProfile("Immersive").setVersion("3.3")
head1 = headObject()
meta2 = metaObject().setName("title").setContent("rubikFurnace.x3d")
head1.addMeta(meta2)
meta3 = metaObject().setName("creator").setContent("John Carlson")
head1.addMeta(meta3)
meta4 = metaObject().setName("generator").setContent("manual")
head1.addMeta(meta4)
meta5 = metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/rubikFurnace.x3d")
head1.addMeta(meta5)
meta6 = metaObject().setName("description").setContent("a green rubik cube")
head1.addMeta(meta6)
X3D0.setHead(head1)
Scene7 = SceneObject()
NavigationInfo8 = NavigationInfoObject().setType(["EXAMINE"])
Scene7.addChild(NavigationInfo8)
Viewpoint9 = ViewpointObject().setDescription("Rubiks Cube on Fire").setPosition([0,0,12])
Scene7.addChild(Viewpoint9)
ProtoDeclare10 = ProtoDeclareObject().setName("anyShape")
ProtoInterface11 = ProtoInterfaceObject()
field12 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("xtranslation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0")
ProtoInterface11.addField(field12)
field13 = fieldObject().setType(fieldObject.TYPE_MFNODE).setName("myShape").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT)
Shape14 = ShapeObject()
Sphere15 = SphereObject()
Shape14.setGeometry(Sphere15)
Appearance16 = AppearanceObject()
Material17 = MaterialObject().setDiffuseColor([1,1,1])
Appearance16.setMaterial(Material17)
Shape14.setAppearance(Appearance16)
field13.addChild(Shape14)
ProtoInterface11.addField(field13)
ProtoDeclare10.setProtoInterface(ProtoInterface11)
ProtoBody18 = ProtoBodyObject()
Transform19 = TransformObject()
IS20 = ISObject()
connect21 = connectObject().setNodeField("translation").setProtoField("xtranslation")
IS20.addConnect(connect21)
connect22 = connectObject().setNodeField("children").setProtoField("myShape")
IS20.addConnect(connect22)
Transform19.setIS(IS20)
ProtoBody18.addChild(Transform19)
ProtoDeclare10.setProtoBody(ProtoBody18)
Scene7.addChild(ProtoDeclare10)
ProtoDeclare23 = ProtoDeclareObject().setName("three")
ProtoInterface24 = ProtoInterfaceObject()
field25 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("ytranslation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0")
ProtoInterface24.addField(field25)
field26 = fieldObject().setType(fieldObject.TYPE_MFNODE).setName("myShape").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT)
Shape27 = ShapeObject()
Sphere28 = SphereObject()
Shape27.setGeometry(Sphere28)
Appearance29 = AppearanceObject()
Material30 = MaterialObject().setDiffuseColor([1,1,1])
Appearance29.setMaterial(Material30)
Shape27.setAppearance(Appearance29)
field26.addChild(Shape27)
ProtoInterface24.addField(field26)
ProtoDeclare23.setProtoInterface(ProtoInterface24)
ProtoBody31 = ProtoBodyObject()
Transform32 = TransformObject()
IS33 = ISObject()
connect34 = connectObject().setNodeField("translation").setProtoField("ytranslation")
IS33.addConnect(connect34)
Transform32.setIS(IS33)
ProtoInstance35 = ProtoInstanceObject().setName("anyShape")
fieldValue36 = fieldValueObject().setName("xtranslation").setValue("0 0 0")
ProtoInstance35.addFieldValue(fieldValue36)
IS37 = ISObject()
connect38 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS37.addConnect(connect38)
ProtoInstance35.setIS(IS37)
Transform32.addChild(ProtoInstance35)
ProtoInstance39 = ProtoInstanceObject().setName("anyShape")
fieldValue40 = fieldValueObject().setName("xtranslation").setValue("2 0 0")
ProtoInstance39.addFieldValue(fieldValue40)
IS41 = ISObject()
connect42 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS41.addConnect(connect42)
ProtoInstance39.setIS(IS41)
Transform32.addChild(ProtoInstance39)
ProtoInstance43 = ProtoInstanceObject().setName("anyShape")
fieldValue44 = fieldValueObject().setName("xtranslation").setValue("-2 0 0")
ProtoInstance43.addFieldValue(fieldValue44)
IS45 = ISObject()
connect46 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS45.addConnect(connect46)
ProtoInstance43.setIS(IS45)
Transform32.addChild(ProtoInstance43)
ProtoBody31.addChild(Transform32)
ProtoDeclare23.setProtoBody(ProtoBody31)
Scene7.addChild(ProtoDeclare23)
ProtoDeclare47 = ProtoDeclareObject().setName("nine")
ProtoInterface48 = ProtoInterfaceObject()
field49 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("ztranslation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0")
ProtoInterface48.addField(field49)
field50 = fieldObject().setType(fieldObject.TYPE_MFNODE).setName("myShape").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT)
Shape51 = ShapeObject()
Sphere52 = SphereObject()
Shape51.setGeometry(Sphere52)
Appearance53 = AppearanceObject()
Material54 = MaterialObject().setDiffuseColor([1,1,1])
Appearance53.setMaterial(Material54)
Shape51.setAppearance(Appearance53)
field50.addChild(Shape51)
ProtoInterface48.addField(field50)
ProtoDeclare47.setProtoInterface(ProtoInterface48)
ProtoBody55 = ProtoBodyObject()
Transform56 = TransformObject()
IS57 = ISObject()
connect58 = connectObject().setNodeField("translation").setProtoField("ztranslation")
IS57.addConnect(connect58)
Transform56.setIS(IS57)
ProtoInstance59 = ProtoInstanceObject().setName("three")
fieldValue60 = fieldValueObject().setName("ytranslation").setValue("0 0 0")
ProtoInstance59.addFieldValue(fieldValue60)
IS61 = ISObject()
connect62 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS61.addConnect(connect62)
ProtoInstance59.setIS(IS61)
Transform56.addChild(ProtoInstance59)
ProtoInstance63 = ProtoInstanceObject().setName("three")
fieldValue64 = fieldValueObject().setName("ytranslation").setValue("0 2 0")
ProtoInstance63.addFieldValue(fieldValue64)
IS65 = ISObject()
connect66 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS65.addConnect(connect66)
ProtoInstance63.setIS(IS65)
Transform56.addChild(ProtoInstance63)
ProtoInstance67 = ProtoInstanceObject().setName("three")
fieldValue68 = fieldValueObject().setName("ytranslation").setValue("0 -2 0")
ProtoInstance67.addFieldValue(fieldValue68)
IS69 = ISObject()
connect70 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS69.addConnect(connect70)
ProtoInstance67.setIS(IS69)
Transform56.addChild(ProtoInstance67)
ProtoBody55.addChild(Transform56)
ProtoDeclare47.setProtoBody(ProtoBody55)
Scene7.addChild(ProtoDeclare47)
ProtoDeclare71 = ProtoDeclareObject().setName("twentyseven")
ProtoInterface72 = ProtoInterfaceObject()
field73 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("ttranslation").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0 0 0")
ProtoInterface72.addField(field73)
field74 = fieldObject().setType(fieldObject.TYPE_MFNODE).setName("myShape").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT)
Shape75 = ShapeObject()
Sphere76 = SphereObject()
Shape75.setGeometry(Sphere76)
Appearance77 = AppearanceObject()
Material78 = MaterialObject().setDiffuseColor([1,1,1])
Appearance77.setMaterial(Material78)
Shape75.setAppearance(Appearance77)
field74.addChild(Shape75)
ProtoInterface72.addField(field74)
ProtoDeclare71.setProtoInterface(ProtoInterface72)
ProtoBody79 = ProtoBodyObject()
Transform80 = TransformObject()
IS81 = ISObject()
connect82 = connectObject().setNodeField("translation").setProtoField("ttranslation")
IS81.addConnect(connect82)
Transform80.setIS(IS81)
ProtoInstance83 = ProtoInstanceObject().setName("nine")
fieldValue84 = fieldValueObject().setName("ztranslation").setValue("0 0 0")
ProtoInstance83.addFieldValue(fieldValue84)
IS85 = ISObject()
connect86 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS85.addConnect(connect86)
ProtoInstance83.setIS(IS85)
Transform80.addChild(ProtoInstance83)
ProtoInstance87 = ProtoInstanceObject().setName("nine")
fieldValue88 = fieldValueObject().setName("ztranslation").setValue("0 0 2")
ProtoInstance87.addFieldValue(fieldValue88)
IS89 = ISObject()
connect90 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS89.addConnect(connect90)
ProtoInstance87.setIS(IS89)
Transform80.addChild(ProtoInstance87)
ProtoInstance91 = ProtoInstanceObject().setName("nine")
fieldValue92 = fieldValueObject().setName("ztranslation").setValue("0 0 -2")
ProtoInstance91.addFieldValue(fieldValue92)
IS93 = ISObject()
connect94 = connectObject().setNodeField("myShape").setProtoField("myShape")
IS93.addConnect(connect94)
ProtoInstance91.setIS(IS93)
Transform80.addChild(ProtoInstance91)
ProtoBody79.addChild(Transform80)
ProtoDeclare71.setProtoBody(ProtoBody79)
Scene7.addChild(ProtoDeclare71)
ProtoInstance95 = ProtoInstanceObject().setName("twentyseven")
fieldValue96 = fieldValueObject().setName("ttranslation").setValue("0 0 0")
ProtoInstance95.addFieldValue(fieldValue96)
fieldValue97 = fieldValueObject().setName("myShape")
Shape98 = ShapeObject()
Box99 = BoxObject().setSize([1,1,1])
Shape98.setGeometry(Box99)
Appearance100 = AppearanceObject()
Material101 = MaterialObject().setDiffuseColor([0,1,0])
Appearance100.setMaterial(Material101)
Shape98.setAppearance(Appearance100)
fieldValue97.addChild(Shape98)
ProtoInstance95.addFieldValue(fieldValue97)
Scene7.addChild(ProtoInstance95)
X3D0.setScene(Scene7)

X3D0.toFileX3D("../out/orig/rubikFurnace.new.x3d")
