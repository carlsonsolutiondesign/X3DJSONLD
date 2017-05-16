from jnius import autoclass
from X3Dautoclass import *
X3D0 =  X3DObject().setProfile("Immersive").setVersion("3.0")
head1 = headObject()
meta2 = metaObject().setName("title").setContent("TextExamples.x3d")
head1.addMeta(meta2)
meta3 = metaObject().setName("description").setContent("Show different escape-character text examples for embedded quotation marks.")
head1.addMeta(meta3)
meta4 = metaObject().setName("creator").setContent("Don Brutzman")
head1.addMeta(meta4)
meta5 = metaObject().setName("created").setContent("7 April 2001")
head1.addMeta(meta5)
meta6 = metaObject().setName("modified").setContent("26 April 2016")
head1.addMeta(meta6)
meta7 = metaObject().setName("warning").setContent("Note that X3D Canonicalization (C14N) will scrub alternate XML character representations, be careful to check original encoding into version control.")
head1.addMeta(meta7)
meta8 = metaObject().setName("warning").setContent("Usually this source document needs to be inspected and edited using a plain-text editor in order to see the differences in these XML-equivalent text representations.")
head1.addMeta(meta8)
meta9 = metaObject().setName("identifier").setContent("http://www.web3d.org/x3d/content/examples/Basic/development/TextExamples.x3d")
head1.addMeta(meta9)
meta10 = metaObject().setName("generator").setContent("X3D-Edit 3.3, https://savage.nps.edu/X3D-Edit")
head1.addMeta(meta10)
meta11 = metaObject().setName("license").setContent("../license.html")
head1.addMeta(meta11)
X3D0.setHead(head1)
Scene12 = SceneObject()
Transform13 = TransformObject().setTranslation([0,2,0])
Shape14 = ShapeObject()
Text15 = TextObject().setString(["Compare special character escaping"])
FontStyle16 = FontStyleObject().setDEF("testFontStyle").setJustify(["MIDDLE","MIDDLE"]).setSize(0.8)
Text15.setFontStyle(FontStyle16)
Shape14.setGeometry(Text15)
Appearance17 = AppearanceObject().setDEF("LightBlueAppearance")
Material18 = MaterialObject().setDiffuseColor([0.1,0.7,0.7])
Appearance17.setMaterial(Material18)
Shape14.setAppearance(Appearance17)
Transform13.addChild(Shape14)
Scene12.addChild(Transform13)
Transform19 = TransformObject().setTranslation([-3,0,0])
Shape20 = ShapeObject()
Text21 = TextObject().setString(["I don't think so","","he said \"Hi\""])
FontStyle22 = FontStyleObject().setUSE("testFontStyle")
Text21.setFontStyle(FontStyle22)
Shape20.setGeometry(Text21)
Appearance23 = AppearanceObject().setUSE("LightBlueAppearance")
Shape20.setAppearance(Appearance23)
Transform19.addChild(Shape20)
Scene12.addChild(Transform19)
Transform24 = TransformObject().setTranslation([3,0,0])
Shape25 = ShapeObject()
Text26 = TextObject().setString(["I don't think so","","he said \"Hi\""])
FontStyle27 = FontStyleObject().setUSE("testFontStyle")
Text26.setFontStyle(FontStyle27)
Shape25.setGeometry(Text26)
Appearance28 = AppearanceObject().setUSE("LightBlueAppearance")
Shape25.setAppearance(Appearance28)
Transform24.addChild(Shape25)
Scene12.addChild(Transform24)
X3D0.setScene(Scene12)

X3D0.toFileX3D("../new/json/TextExamples.new.x3d")
