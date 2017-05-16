from jnius import autoclass
from X3Dautoclass import *
X3D0 =  X3DObject().setProfile("Interchange").setVersion("3.3")
head1 = headObject()
meta2 = metaObject().setName("title").setContent("sphere.x3d")
head1.addMeta(meta2)
meta3 = metaObject().setName("creator").setContent("John Carlson")
head1.addMeta(meta3)
meta4 = metaObject().setName("generator").setContent("manual")
head1.addMeta(meta4)
meta5 = metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/sphere.x3d")
head1.addMeta(meta5)
meta6 = metaObject().setName("description").setContent("a sphere")
head1.addMeta(meta6)
X3D0.setHead(head1)
Scene7 = SceneObject()
Group8 = GroupObject()
Shape9 = ShapeObject()
Appearance10 = AppearanceObject()
Material11 = MaterialObject().setDiffuseColor([1,1,1])
Appearance10.setMaterial(Material11)
Shape9.setAppearance(Appearance10)
Sphere12 = SphereObject()
Shape9.setGeometry(Sphere12)
Group8.addChild(Shape9)
Scene7.addChild(Group8)
X3D0.setScene(Scene7)

X3D0.toFileX3D("../new/json/sphere.new.x3d")
