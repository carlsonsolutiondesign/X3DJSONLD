from jnius import autoclass
from X3Dautoclass import *
X3D0 =  X3DObject().setProfile("Immersive").setVersion("3.0")
head1 = headObject()
meta2 = metaObject().setName("title").setContent("ExtrusionHeart.x3d")
head1.addMeta(meta2)
meta3 = metaObject().setName("description").setContent("Simple extrusion of a Valentine heart.")
head1.addMeta(meta3)
meta4 = metaObject().setName("creator").setContent("Class participants in course Introduction to VRML/X3D.")
head1.addMeta(meta4)
meta5 = metaObject().setName("created").setContent("14 February 2001")
head1.addMeta(meta5)
meta6 = metaObject().setName("modified").setContent("27 November 2015")
head1.addMeta(meta6)
meta7 = metaObject().setName("identifier").setContent("http://www.web3d.org/x3d/content/examples/Basic/course/ExtrusionHeart.x3d")
head1.addMeta(meta7)
meta8 = metaObject().setName("generator").setContent("X3D-Edit 3.3, https://savage.nps.edu/X3D-Edit")
head1.addMeta(meta8)
meta9 = metaObject().setName("license").setContent("../license.html")
head1.addMeta(meta9)
X3D0.setHead(head1)
Scene10 = SceneObject()
Viewpoint11 = ViewpointObject().setDescription("Extrusion Heart").setOrientation([1,0,0,1.57]).setPosition([0,-4,0])
Scene10.addChild(Viewpoint11)
Transform12 = TransformObject().setTranslation([0,-0.5,0])
Shape13 = ShapeObject()
Extrusion14 = ExtrusionObject().setCreaseAngle(3.14159).setCrossSection([0,0.8,0.2,1,0.7,0.95,1,0.5,0.8,0,0.5,-0.3,0,-0.7,-0.5,-0.3,-0.8,0,-1,0.5,-0.7,0.95,-0.2,1,0,0.8]).setScale([0.01,0.01,0.8,0.8,1,1,0.8,0.8,0.01,0.01]).setSolid(False).setSpine([0,0,0,0,0.1,0,0,0.5,0,0,0.9,0,0,1,0])
Shape13.setGeometry(Extrusion14)
Appearance15 = AppearanceObject()
Material16 = MaterialObject().setDiffuseColor([0.8,0.3,0.3])
Appearance15.setMaterial(Material16)
Shape13.setAppearance(Appearance15)
Transform12.addChild(Shape13)
Scene10.addChild(Transform12)
X3D0.setScene(Scene10)

X3D0.toFileX3D("../new/json/ExtrusionHeart.new.x3d")