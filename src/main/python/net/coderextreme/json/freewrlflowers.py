from jnius import autoclass
from X3Dautoclass import *
X3D0 =  X3DObject().setProfile("Immersive").setVersion("3.3")
head1 = headObject()
meta2 = metaObject().setName("title").setContent("sphereflowers.x3d")
head1.addMeta(meta2)
meta3 = metaObject().setName("creator").setContent("John Carlson")
head1.addMeta(meta3)
meta4 = metaObject().setName("description").setContent("5 or more prismatic flowers")
head1.addMeta(meta4)
meta5 = metaObject().setName("generator").setContent("X3D-Edit, https://savage.nps.edu/X3D-Edit")
head1.addMeta(meta5)
meta6 = metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/sphereflowers.x3d")
head1.addMeta(meta6)
X3D0.setHead(head1)
Scene7 = SceneObject()
NavigationInfo8 = NavigationInfoObject()
Scene7.addChild(NavigationInfo8)
Background9 = BackgroundObject().setBackUrl(["cubemap/all_probes/stpeters_cross/stpeters_back.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_back.png"]).setBottomUrl(["cubemap/all_probes/stpeters_cross/stpeters_bottom.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_bottom.png"]).setFrontUrl(["cubemap/all_probes/stpeters_cross/stpeters_front.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_front.png"]).setLeftUrl(["cubemap/all_probes/stpeters_cross/stpeters_left.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_left.png"]).setRightUrl(["cubemap/all_probes/stpeters_cross/stpeters_right.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_right.png"]).setTopUrl(["cubemap/all_probes/stpeters_cross/stpeters_top.png","http://coderextreme.net/X3DJSONLD/cubemap/all_probes/stpeters_cross/stpeters_top.png"])
Scene7.addChild(Background9)
Group10 = GroupObject()
ExternProtoDeclare11 = ExternProtoDeclareObject().setName("FlowerProto").setUrl(["flowerproto.x3d#FlowerProto"])
field12 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("vertex").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT)
ExternProtoDeclare11.addField(field12)
field13 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("fragment").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT)
ExternProtoDeclare11.addField(field13)
Group10.addChild(ExternProtoDeclare11)
ProtoDeclare14 = ProtoDeclareObject().setName("flower")
ProtoBody15 = ProtoBodyObject()
Group16 = GroupObject()
ProtoInstance17 = ProtoInstanceObject().setName("FlowerProto")
fieldValue18 = fieldValueObject().setName("vertex").setValue("\"freewrl_flowers_chromatic.vs\"")
ProtoInstance17.addFieldValue(fieldValue18)
fieldValue19 = fieldValueObject().setName("fragment").setValue("\"freewrl.fs\"")
ProtoInstance17.addFieldValue(fieldValue19)
Group16.addChild(ProtoInstance17)
ProtoBody15.addChild(Group16)
ProtoDeclare14.setProtoBody(ProtoBody15)
Group10.addChild(ProtoDeclare14)
ProtoInstance20 = ProtoInstanceObject().setName("flower")
Group10.addChild(ProtoInstance20)
ProtoInstance21 = ProtoInstanceObject().setName("flower")
Group10.addChild(ProtoInstance21)
ProtoInstance22 = ProtoInstanceObject().setName("flower")
Group10.addChild(ProtoInstance22)
ProtoInstance23 = ProtoInstanceObject().setName("flower")
Group10.addChild(ProtoInstance23)
ProtoInstance24 = ProtoInstanceObject().setName("flower")
Group10.addChild(ProtoInstance24)
ProtoInstance25 = ProtoInstanceObject().setName("flower")
Group10.addChild(ProtoInstance25)
Scene7.addChild(Group10)
X3D0.setScene(Scene7)

X3D0.toFileX3D("../new/json/freewrlflowers.new.x3d")
