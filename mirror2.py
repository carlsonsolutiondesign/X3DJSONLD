from jnius import autoclass
from X3Dautoclass import *
X3D0 =  X3DObject().setProfile("Immersive").setVersion("3.3")
head1 = headObject()
meta2 = metaObject().setName("title").setContent("mirro2.x3d")
head1.addMeta(meta2)
meta3 = metaObject().setName("creator").setContent("John Carlson")
head1.addMeta(meta3)
meta4 = metaObject().setName("generator").setContent("manual")
head1.addMeta(meta4)
meta5 = metaObject().setName("identifier").setContent("http://coderextreme.net/X3DJSONLD/mirro2.x3d")
head1.addMeta(meta5)
meta6 = metaObject().setName("description").setContent("a mirrored sphere")
head1.addMeta(meta6)
meta7 = metaObject().setName("translated").setContent("10 May 2017")
head1.addMeta(meta7)
meta8 = metaObject().setName("generator").setContent("X3dToJson.xslt, http://www.web3d.org/x3d/stylesheets/X3dToJson.html")
head1.addMeta(meta8)
meta9 = metaObject().setName("reference").setContent("X3D JSON encoding: http://www.web3d.org/wiki/index.php/X3D_JSON_Encoding")
head1.addMeta(meta9)
meta10 = metaObject().setName("translated").setContent("10 May 2017")
head1.addMeta(meta10)
meta11 = metaObject().setName("generator").setContent("X3DJSONLD: https://github.com/coderextreme/X3DJSONLD")
head1.addMeta(meta11)
X3D0.setHead(head1)
Scene12 = SceneObject()
Viewpoint13 = ViewpointObject().setPosition([0,5,100]).setDescription("Switch background and cubemap texture")
Scene12.addChild(Viewpoint13)
Background14 = BackgroundObject().setDEF("cube").setLeftUrl(["cubemap/all_probes/beach_cross/beach_left.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_left.png"]).setRightUrl(["cubemap/all_probes/beach_cross/beach_right.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_right.png"]).setFrontUrl(["cubemap/all_probes/beach_cross/beach_front.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_front.png"]).setBackUrl(["cubemap/all_probes/beach_cross/beach_back.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_back.png"]).setTopUrl(["cubemap/all_probes/beach_cross/beach_top.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_top.png"]).setBottomUrl(["cubemap/all_probes/beach_cross/beach_bottom.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_bottom.png"])
Scene12.addChild(Background14)
Transform15 = TransformObject()
Shape16 = ShapeObject()
Appearance17 = AppearanceObject()
Material18 = MaterialObject().setDiffuseColor([0.7,0.7,0.7]).setSpecularColor([0.5,0.5,0.5])
Appearance17.setMaterial(Material18)
ComposedCubeMapTexture19 = ComposedCubeMapTextureObject()
ImageTexture20 = ImageTextureObject().setDEF("backShader").setUrl(["cubemap/all_probes/beach_cross/beach_back.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_back.png"])
ComposedCubeMapTexture19.setBack(ImageTexture20)
ImageTexture21 = ImageTextureObject().setDEF("bottomShader").setUrl(["cubemap/all_probes/beach_cross/beach_bottom.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_bottom.png"])
ComposedCubeMapTexture19.setBottom(ImageTexture21)
ImageTexture22 = ImageTextureObject().setDEF("frontShader").setUrl(["cubemap/all_probes/beach_cross/beach_front.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_front.png"])
ComposedCubeMapTexture19.setFront(ImageTexture22)
ImageTexture23 = ImageTextureObject().setDEF("leftShader").setUrl(["cubemap/all_probes/beach_cross/beach_left.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_left.png"])
ComposedCubeMapTexture19.setLeft(ImageTexture23)
ImageTexture24 = ImageTextureObject().setDEF("rightShader").setUrl(["cubemap/all_probes/beach_cross/beach_right.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_right.png"])
ComposedCubeMapTexture19.setRight(ImageTexture24)
ImageTexture25 = ImageTextureObject().setDEF("topShader").setUrl(["cubemap/all_probes/beach_cross/beach_top.png","http://coderextreme.net/cubemap/all_probes/beach_cross/beach_top.png"])
ComposedCubeMapTexture19.setTop(ImageTexture25)
Appearance17.setTexture(ComposedCubeMapTexture19)
ComposedShader26 = ComposedShaderObject().setDEF("cobweb").setLanguage("GLSL")

ComposedShader26.addComments(CommentsBlock("http://hypertextbook.com/facts/2005/JustinChe.shtml"))
field27 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("chromaticDispertion").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.98 1 1.033")
ComposedShader26.addField(field27)
field28 = fieldObject().setType(fieldObject.TYPE_SFINT32).setName("cube").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0")
ComposedShader26.addField(field28)
field29 = fieldObject().setType(fieldObject.TYPE_SFFLOAT).setName("bias").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5")
ComposedShader26.addField(field29)
field30 = fieldObject().setType(fieldObject.TYPE_SFFLOAT).setName("scale").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5")
ComposedShader26.addField(field30)
field31 = fieldObject().setType(fieldObject.TYPE_SFFLOAT).setName("power").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("2")
ComposedShader26.addField(field31)
ShaderPart32 = ShaderPartObject().setType("VERTEX").setUrl(["cobweb.vs","http://coderextreme.net/X3DJSONLD/cobweb.vs"])
ComposedShader26.addParts(ShaderPart32)
ShaderPart33 = ShaderPartObject().setType("FRAGMENT").setUrl(["mix.fs","http://coderextreme.net/X3DJSONLD/mix.fs"])
ComposedShader26.addParts(ShaderPart33)
Appearance17.addShaders(ComposedShader26)
ComposedShader34 = ComposedShaderObject().setDEF("x3dom").setLanguage("GLSL")

ComposedShader34.addComments(CommentsBlock("http://hypertextbook.com/facts/2005/JustinChe.shtml"))
field35 = fieldObject().setType(fieldObject.TYPE_SFVEC3F).setName("chromaticDispertion").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.98 1 1.033")
ComposedShader34.addField(field35)
field36 = fieldObject().setType(fieldObject.TYPE_SFINT32).setName("cube").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0")
ComposedShader34.addField(field36)
field37 = fieldObject().setType(fieldObject.TYPE_SFFLOAT).setName("bias").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5")
ComposedShader34.addField(field37)
field38 = fieldObject().setType(fieldObject.TYPE_SFFLOAT).setName("scale").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("0.5")
ComposedShader34.addField(field38)
field39 = fieldObject().setType(fieldObject.TYPE_SFFLOAT).setName("power").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("2")
ComposedShader34.addField(field39)
ShaderPart40 = ShaderPartObject().setType("VERTEX").setUrl(["x3dom.vs","http://coderextreme.net/X3DJSONLD/x3dom.vs"])
ComposedShader34.addParts(ShaderPart40)
ShaderPart41 = ShaderPartObject().setType("FRAGMENT").setUrl(["mix.fs","http://coderextreme.net/X3DJSONLD/mix.fs"])
ComposedShader34.addParts(ShaderPart41)
Appearance17.addShaders(ComposedShader34)
Shape16.setAppearance(Appearance17)
Sphere42 = SphereObject().setRadius(30)
Shape16.setGeometry(Sphere42)
Transform15.addChild(Shape16)
Script43 = ScriptObject().setDEF("UrlSelector").setDirectOutput(True)
field44 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("frontUrls").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY).setValue("\"cubemap/all_probes/beach_cross/beach_front.png\" \"cubemap/all_probes/building_cross/building_front.png\" \"cubemap/all_probes/campus_cross/campus_front.png\" \"cubemap/all_probes/galileo_cross/galileo_front.png\" \"cubemap/all_probes/grace_cross/grace_front.png\" \"cubemap/all_probes/kitchen_cross/kitchen_front.png\" \"cubemap/all_probes/rnl_cross/rnl_front.png\" \"cubemap/all_probes/stpeters_cross/stpeters_front.png\" \"cubemap/all_probes/uffizi_cross/uffizi_front.png\"")
Script43.addField(field44)
field45 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("backUrls").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY).setValue("\"cubemap/all_probes/beach_cross/beach_back.png\" \"cubemap/all_probes/building_cross/building_back.png\" \"cubemap/all_probes/campus_cross/campus_back.png\" \"cubemap/all_probes/galileo_cross/galileo_back.png\" \"cubemap/all_probes/grace_cross/grace_back.png\" \"cubemap/all_probes/kitchen_cross/kitchen_back.png\" \"cubemap/all_probes/rnl_cross/rnl_back.png\" \"cubemap/all_probes/stpeters_cross/stpeters_back.png\" \"cubemap/all_probes/uffizi_cross/uffizi_back.png\"")
Script43.addField(field45)
field46 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("leftUrls").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY).setValue("\"cubemap/all_probes/beach_cross/beach_left.png\" \"cubemap/all_probes/building_cross/building_left.png\" \"cubemap/all_probes/campus_cross/campus_left.png\" \"cubemap/all_probes/galileo_cross/galileo_left.png\" \"cubemap/all_probes/grace_cross/grace_left.png\" \"cubemap/all_probes/kitchen_cross/kitchen_left.png\" \"cubemap/all_probes/rnl_cross/rnl_left.png\" \"cubemap/all_probes/stpeters_cross/stpeters_left.png\" \"cubemap/all_probes/uffizi_cross/uffizi_left.png\"")
Script43.addField(field46)
field47 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("rightUrls").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY).setValue("\"cubemap/all_probes/beach_cross/beach_right.png\" \"cubemap/all_probes/building_cross/building_right.png\" \"cubemap/all_probes/campus_cross/campus_right.png\" \"cubemap/all_probes/galileo_cross/galileo_right.png\" \"cubemap/all_probes/grace_cross/grace_right.png\" \"cubemap/all_probes/kitchen_cross/kitchen_right.png\" \"cubemap/all_probes/rnl_cross/rnl_right.png\" \"cubemap/all_probes/stpeters_cross/stpeters_right.png\" \"cubemap/all_probes/uffizi_cross/uffizi_right.png\"")
Script43.addField(field47)
field48 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("topUrls").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY).setValue("\"cubemap/all_probes/beach_cross/beach_top.png\" \"cubemap/all_probes/building_cross/building_top.png\" \"cubemap/all_probes/campus_cross/campus_top.png\" \"cubemap/all_probes/galileo_cross/galileo_top.png\" \"cubemap/all_probes/grace_cross/grace_top.png\" \"cubemap/all_probes/kitchen_cross/kitchen_top.png\" \"cubemap/all_probes/rnl_cross/rnl_top.png\" \"cubemap/all_probes/stpeters_cross/stpeters_top.png\" \"cubemap/all_probes/uffizi_cross/uffizi_top.png\"")
Script43.addField(field48)
field49 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("bottomUrls").setAccessType(fieldObject.ACCESSTYPE_INITIALIZEONLY).setValue("\"cubemap/all_probes/beach_cross/beach_bottom.png\" \"cubemap/all_probes/building_cross/building_bottom.png\" \"cubemap/all_probes/campus_cross/campus_bottom.png\" \"cubemap/all_probes/galileo_cross/galileo_bottom.png\" \"cubemap/all_probes/grace_cross/grace_bottom.png\" \"cubemap/all_probes/kitchen_cross/kitchen_bottom.png\" \"cubemap/all_probes/rnl_cross/rnl_bottom.png\" \"cubemap/all_probes/stpeters_cross/stpeters_bottom.png\" \"cubemap/all_probes/uffizi_cross/uffizi_bottom.png\"")
Script43.addField(field49)
field50 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("front_changed").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY)
Script43.addField(field50)
field51 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("back_changed").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY)
Script43.addField(field51)
field52 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("left_changed").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY)
Script43.addField(field52)
field53 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("right_changed").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY)
Script43.addField(field53)
field54 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("top_changed").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY)
Script43.addField(field54)
field55 = fieldObject().setType(fieldObject.TYPE_MFSTRING).setName("bottom_changed").setAccessType(fieldObject.ACCESSTYPE_OUTPUTONLY)
Script43.addField(field55)
field56 = fieldObject().setType(fieldObject.TYPE_SFFLOAT).setName("set_fraction").setAccessType(fieldObject.ACCESSTYPE_INPUTONLY)
Script43.addField(field56)
field57 = fieldObject().setType(fieldObject.TYPE_SFINT32).setName("old").setAccessType(fieldObject.ACCESSTYPE_INPUTOUTPUT).setValue("-1")
Script43.addField(field57)

Script43.setSourceCode("ecmascript:\n"+
"        function set_fraction( f, tm ) {\n"+
"	    var side = Math.floor(f*frontUrls.length);\n"+
"	    if (side > frontUrls.length-1) {\n"+
"	    	side = 0;\n"+
"	    }\n"+
"	    if (side != old) {\n"+
"	    	    // Browser.print(f+\" \"+side);\n"+
"	    	    old = side;\n"+
"		    front_changed[0] = frontUrls[side];\n"+
"		    back_changed[0] = backUrls[side];\n"+
"		    left_changed[0] = leftUrls[side];\n"+
"		    right_changed[0] = rightUrls[side];\n"+
"		    top_changed[0] = topUrls[side];\n"+
"		    bottom_changed[0] = bottomUrls[side];\n"+
"            }\n"+
"        }\n"+
"")
Transform15.addChild(Script43)
TimeSensor58 = TimeSensorObject().setDEF("Clock").setCycleInterval(45).setLoop(True)
Transform15.addChild(TimeSensor58)
ROUTE59 = ROUTEObject().setFromNode("Clock").setFromField("fraction_changed").setToNode("UrlSelector").setToField("set_fraction")
Transform15.addChild(ROUTE59)
ROUTE60 = ROUTEObject().setFromNode("UrlSelector").setFromField("front_changed").setToNode("cube").setToField("frontUrl")
Transform15.addChild(ROUTE60)
ROUTE61 = ROUTEObject().setFromNode("UrlSelector").setFromField("back_changed").setToNode("cube").setToField("backUrl")
Transform15.addChild(ROUTE61)
ROUTE62 = ROUTEObject().setFromNode("UrlSelector").setFromField("left_changed").setToNode("cube").setToField("leftUrl")
Transform15.addChild(ROUTE62)
ROUTE63 = ROUTEObject().setFromNode("UrlSelector").setFromField("right_changed").setToNode("cube").setToField("rightUrl")
Transform15.addChild(ROUTE63)
ROUTE64 = ROUTEObject().setFromNode("UrlSelector").setFromField("top_changed").setToNode("cube").setToField("topUrl")
Transform15.addChild(ROUTE64)
ROUTE65 = ROUTEObject().setFromNode("UrlSelector").setFromField("bottom_changed").setToNode("cube").setToField("bottomUrl")
Transform15.addChild(ROUTE65)
ROUTE66 = ROUTEObject().setFromNode("UrlSelector").setFromField("front_changed").setToNode("frontShader").setToField("url")
Transform15.addChild(ROUTE66)
ROUTE67 = ROUTEObject().setFromNode("UrlSelector").setFromField("back_changed").setToNode("backShader").setToField("url")
Transform15.addChild(ROUTE67)
ROUTE68 = ROUTEObject().setFromNode("UrlSelector").setFromField("left_changed").setToNode("leftShader").setToField("url")
Transform15.addChild(ROUTE68)
ROUTE69 = ROUTEObject().setFromNode("UrlSelector").setFromField("right_changed").setToNode("rightShader").setToField("url")
Transform15.addChild(ROUTE69)
ROUTE70 = ROUTEObject().setFromNode("UrlSelector").setFromField("top_changed").setToNode("topShader").setToField("url")
Transform15.addChild(ROUTE70)
ROUTE71 = ROUTEObject().setFromNode("UrlSelector").setFromField("bottom_changed").setToNode("bottomShader").setToField("url")
Transform15.addChild(ROUTE71)
Scene12.addChild(Transform15)
X3D0.setScene(Scene12)

X3D0.toFileX3D("mirror2.new.x3d")