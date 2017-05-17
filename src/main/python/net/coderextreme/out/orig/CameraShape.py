from jnius import autoclass
from X3Dautoclass import *
X3D0 =  X3DObject().setProfile("Interactive").setVersion("3.1")
head1 = headObject()
meta2 = metaObject().setName("title").setContent("SimpleCamera.x3d")
head1.addMeta(meta2)
meta3 = metaObject().setName("description").setContent("Simple video camera shape")
head1.addMeta(meta3)
meta4 = metaObject().setName("creator").setContent("Jeff Weekley and Don Brutzman")
head1.addMeta(meta4)
meta5 = metaObject().setName("created").setContent("2 June 2009")
head1.addMeta(meta5)
meta6 = metaObject().setName("translated").setContent("2 June 2009")
head1.addMeta(meta6)
meta7 = metaObject().setName("modified").setContent("13 January 2014")
head1.addMeta(meta7)
meta8 = metaObject().setName("reference").setContent("CameraExamples.x3d")
head1.addMeta(meta8)
meta9 = metaObject().setName("identifier").setContent("http://www.web3d.org/x3d/content/examples/Basic/development/SimpleCamera.x3d")
head1.addMeta(meta9)
meta10 = metaObject().setName("generator").setContent("Vrml97ToX3dNist, http://ovrt.nist.gov/v2_x3d.html")
head1.addMeta(meta10)
meta11 = metaObject().setName("generator").setContent("X3D-Edit 3.3, https://savage.nps.edu/X3D-Edit")
head1.addMeta(meta11)
meta12 = metaObject().setName("license").setContent("../../license.html")
head1.addMeta(meta12)
X3D0.setHead(head1)
Scene13 = SceneObject()
WorldInfo14 = WorldInfoObject().setInfo(["VRML2.0 created with Version 1.3, from Alias Maya 2008"]).setTitle("SimpleCamera.x3d")
Scene13.addChild(WorldInfo14)
Viewpoint15 = ViewpointObject().setDEF("CameraShapeView").setDescription("Camera view, over the shoulder").setPosition([0,0.75,3])
Scene13.addChild(Viewpoint15)
Viewpoint16 = ViewpointObject().setDescription("Camera view through lens").setPosition([0,0,0])
Scene13.addChild(Viewpoint16)
Viewpoint17 = ViewpointObject().setDescription("Camera view from right side").setOrientation([0,1,0,1.5708]).setPosition([12,0,-4])
Scene13.addChild(Viewpoint17)
Viewpoint18 = ViewpointObject().setDescription("Camera view from above").setOrientation([1,0,0,-1.5708]).setPosition([0,15,-5])
Scene13.addChild(Viewpoint18)
Viewpoint19 = ViewpointObject().setDescription("Camera view from left side").setOrientation([0,1,0,-1.5708]).setPosition([-12,0,-4])
Scene13.addChild(Viewpoint19)
Transform20 = TransformObject().setScale([0.1,0.1,0.1]).setTranslation([0,-0.165,0.02])
Switch21 = SwitchObject().setWhichChoice(-1)
Shape22 = ShapeObject()
Appearance23 = AppearanceObject().setDEF("CameraAppearance")
Material24 = MaterialObject().setDEF("lambert1_0").setAmbientIntensity(0.25).setDiffuseColor([0.372322,0.371574,0.373173]).setShininess(0.02).setSpecularColor([0.890909,0.887832,0.890909])

Material24.addComments(CommentsBlock("Universal Media Library: Metals 30"))
Appearance23.setMaterial(Material24)
Shape22.setAppearance(Appearance23)
Switch21.addChild(Shape22)
Shape25 = ShapeObject()
IndexedFaceSet26 = IndexedFaceSetObject().setDEF("pCylinder1_0Geo").setConvex(False).setCoordIndex([0,1,13,12,-1,1,2,14,13,-1,2,3,15,14,-1,3,4,16,15,-1,4,5,17,16,-1,5,6,18,17,-1,6,7,19,18,-1,7,8,20,19,-1,8,9,21,20,-1,9,10,22,21,-1,10,11,23,22,-1,11,0,12,23,-1,1,0,24,-1,2,1,24,-1,3,2,24,-1,4,3,24,-1,5,4,24,-1,6,5,24,-1,7,6,24,-1,8,7,24,-1,9,8,24,-1,10,9,24,-1,11,10,24,-1,0,11,24,-1,12,13,25,-1,13,14,25,-1,14,15,25,-1,15,16,25,-1,16,17,25,-1,17,18,25,-1,18,19,25,-1,19,20,25,-1,20,21,25,-1,21,22,25,-1,22,23,25,-1,23,12,25,-1]).setCreaseAngle(0.7854)
Coordinate27 = CoordinateObject().setDEF("pCylinder1GeoPoints").setPoint([-0.36,-2.39,-0.26,-0.36,-1.77,-0.89,-0.36,0,-1.7,-0.36,0.85,-1.47,-0.36,1.47,-0.85,-0.36,1.7,0,-0.36,1.47,0.85,-0.36,-0.07,2.05,-0.36,-0.92,2.28,-0.36,-1.77,2.05,-0.36,-2.39,1.43,-0.36,-2.62,0.58,0.36,-2.39,-0.26,0.36,-1.77,-0.89,0.36,0,-1.7,0.36,0.85,-1.47,0.36,1.47,-0.85,0.36,1.7,0,0.36,1.47,0.85,0.36,-0.07,2.05,0.36,-0.92,2.28,0.36,-1.77,2.05,0.36,-2.39,1.43,0.36,-2.62,0.58,-0.36,-0.46,0.31,0.36,-0.46,0.31])
IndexedFaceSet26.setCoord(Coordinate27)
Shape25.setGeometry(IndexedFaceSet26)
Appearance28 = AppearanceObject().setUSE("CameraAppearance")
Shape25.setAppearance(Appearance28)
Switch21.addChild(Shape25)
Shape29 = ShapeObject()
IndexedFaceSet30 = IndexedFaceSetObject().setDEF("pCube1_0Geo").setConvex(False).setCoordIndex([0,1,13,12,-1,2,3,25,24,-1,4,5,11,10,-1,6,7,19,18,-1,1,29,31,13,-1,6,18,23,14,-1,8,9,3,2,-1,10,11,15,14,-1,9,30,25,3,-1,10,21,16,4,-1,12,13,9,8,-1,13,31,30,9,-1,14,23,21,10,-1,14,15,7,6,-1,16,17,5,4,-1,18,19,29,28,-1,22,19,7,15,-1,23,18,28,27,-1,17,20,11,5,-1,16,21,26,24,-1,20,22,15,11,-1,21,23,27,26,-1,24,25,17,16,-1,31,29,19,22,-1,25,30,20,17,-1,30,31,22,20,-1,28,29,1,0,-1,27,28,0,12,-1,24,26,8,2,-1,26,27,12,8,-1]).setCreaseAngle(0.7854)
Coordinate31 = CoordinateObject().setDEF("pCube1GeoPoints").setPoint([-1.03,-1.26,3,1.03,-1.26,3,-1.03,1.74,3,1.03,1.74,3,-0.78,1.21,-3,0.78,1.21,-3,-0.78,-1.3,-3,0.78,-1.3,-3,-1.03,0.27,3,1.03,0.27,3,-0.78,0.27,-3.43,0.78,0.27,-3.43,-1.03,-0.99,3,1.03,-0.99,3,-0.78,-1.05,-3.43,0.78,-1.05,-3.43,-0.79,1.56,-2.76,0.79,1.56,-2.76,-0.79,-1.56,-2.76,0.79,-1.56,-2.76,1.13,0.27,-2.76,-1.13,0.27,-2.76,1.13,-1.31,-2.76,-1.13,-1.31,-2.76,-1.02,1.73,2.69,1.02,1.73,2.69,-1.36,0.27,2.69,-1.36,-1.45,2.69,-1.02,-1.73,2.69,1.02,-1.73,2.69,1.36,0.27,2.69,1.36,-1.45,2.69])
IndexedFaceSet30.setCoord(Coordinate31)
Shape29.setGeometry(IndexedFaceSet30)
Appearance32 = AppearanceObject().setUSE("CameraAppearance")
Shape29.setAppearance(Appearance32)
Switch21.addChild(Shape29)
Shape33 = ShapeObject()
IndexedFaceSet34 = IndexedFaceSetObject().setDEF("pPipe1_0Geo").setConvex(False).setCoordIndex([1,0,144,145,-1,2,1,145,146,-1,3,2,146,147,-1,4,3,147,148,-1,5,4,148,149,-1,6,5,149,150,-1,7,6,150,151,-1,8,7,151,152,-1,9,8,152,153,-1,10,9,153,154,-1,11,10,154,155,-1,0,11,155,144,-1,13,12,24,25,-1,14,13,25,26,-1,15,14,26,27,-1,16,15,27,28,-1,17,16,28,29,-1,18,17,29,30,-1,19,18,30,31,-1,20,19,31,32,-1,21,20,32,33,-1,22,21,33,34,-1,23,22,34,35,-1,12,23,35,24,-1,25,24,36,37,-1,26,25,37,38,-1,27,26,38,39,-1,28,27,39,40,-1,29,28,40,41,-1,30,29,41,42,-1,31,30,42,43,-1,32,31,43,44,-1,33,32,44,45,-1,34,33,45,46,-1,35,34,46,47,-1,24,35,47,36,-1,37,36,84,85,-1,38,37,85,86,-1,39,38,86,87,-1,40,39,87,88,-1,41,40,88,89,-1,42,41,89,90,-1,43,42,90,91,-1,44,43,91,92,-1,45,44,92,93,-1,46,45,93,94,-1,47,46,94,95,-1,36,47,95,84,-1,49,48,60,61,-1,50,49,61,62,-1,51,50,62,63,-1,52,51,63,64,-1,53,52,64,65,-1,54,53,65,66,-1,55,54,66,67,-1,56,55,67,68,-1,57,56,68,69,-1,58,57,69,70,-1,59,58,70,71,-1,48,59,71,60,-1,61,60,0,1,-1,62,61,1,2,-1,63,62,2,3,-1,64,63,3,4,-1,65,64,4,5,-1,66,65,5,6,-1,67,66,6,7,-1,68,67,7,8,-1,69,68,8,9,-1,70,69,9,10,-1,71,70,10,11,-1,60,71,11,0,-1,73,72,12,13,-1,74,73,13,14,-1,75,74,14,15,-1,76,75,15,16,-1,77,76,16,17,-1,78,77,17,18,-1,79,78,18,19,-1,80,79,19,20,-1,81,80,20,21,-1,82,81,21,22,-1,83,82,22,23,-1,72,83,23,12,-1,85,84,108,109,-1,86,85,109,110,-1,87,86,110,111,-1,88,87,111,112,-1,89,88,112,113,-1,90,89,113,114,-1,91,90,114,115,-1,92,91,115,116,-1,93,92,116,117,-1,94,93,117,118,-1,95,94,118,119,-1,84,95,119,108,-1,97,96,72,73,-1,98,97,73,74,-1,99,98,74,75,-1,100,99,75,76,-1,101,100,76,77,-1,102,101,77,78,-1,103,102,78,79,-1,104,103,79,80,-1,105,104,80,81,-1,106,105,81,82,-1,107,106,82,83,-1,96,107,83,72,-1,109,108,132,133,-1,110,109,133,134,-1,111,110,134,135,-1,112,111,135,136,-1,113,112,136,137,-1,114,113,137,138,-1,115,114,138,139,-1,116,115,139,140,-1,117,116,140,141,-1,118,117,141,142,-1,119,118,142,143,-1,108,119,143,132,-1,121,120,96,97,-1,122,121,97,98,-1,123,122,98,99,-1,124,123,99,100,-1,125,124,100,101,-1,126,125,101,102,-1,127,126,102,103,-1,128,127,103,104,-1,129,128,104,105,-1,130,129,105,106,-1,131,130,106,107,-1,120,131,107,96,-1,133,132,168,169,-1,134,133,169,170,-1,135,134,170,171,-1,136,135,171,172,-1,137,136,172,173,-1,138,137,173,174,-1,139,138,174,175,-1,140,139,175,176,-1,141,140,176,177,-1,142,141,177,178,-1,143,142,178,179,-1,132,143,179,168,-1,145,144,180,181,-1,146,145,181,182,-1,147,146,182,183,-1,148,147,183,184,-1,149,148,184,185,-1,150,149,185,186,-1,151,150,186,187,-1,152,151,187,188,-1,153,152,188,189,-1,154,153,189,190,-1,155,154,190,191,-1,144,155,191,180,-1,157,156,48,49,-1,158,157,49,50,-1,159,158,50,51,-1,160,159,51,52,-1,161,160,52,53,-1,162,161,53,54,-1,163,162,54,55,-1,164,163,55,56,-1,165,164,56,57,-1,166,165,57,58,-1,167,166,58,59,-1,156,167,59,48,-1,169,168,156,157,-1,170,169,157,158,-1,171,170,158,159,-1,172,171,159,160,-1,173,172,160,161,-1,174,173,161,162,-1,175,174,162,163,-1,176,175,163,164,-1,177,176,164,165,-1,178,177,165,166,-1,179,178,166,167,-1,168,179,167,156,-1,181,180,120,121,-1,182,181,121,122,-1,183,182,122,123,-1,184,183,123,124,-1,185,184,124,125,-1,186,185,125,126,-1,187,186,126,127,-1,188,187,127,128,-1,189,188,128,129,-1,190,189,129,130,-1,191,190,130,131,-1,180,191,131,120,-1]).setCreaseAngle(0.7854)
Coordinate35 = CoordinateObject().setDEF("pPipe1GeoPoints").setPoint([0.58,0,-1.44,0.5,0.3,-1.44,0.29,0.51,-1.44,0,0.59,-1.44,-0.29,0.51,-1.44,-0.5,0.3,-1.44,-0.58,0,-1.44,-0.5,-0.3,-1.44,-0.29,-0.51,-1.44,0,-0.59,-1.44,0.29,-0.51,-1.44,0.5,-0.3,-1.44,0.34,0,1.44,0.29,0.2,1.44,0.17,0.34,1.44,0,0.4,1.44,-0.17,0.34,1.44,-0.29,0.2,1.44,-0.34,0,1.44,-0.29,-0.2,1.44,-0.17,-0.34,1.44,0,-0.4,1.44,0.17,-0.34,1.44,0.29,-0.2,1.44,0.4,0,1.44,0.34,0.23,1.44,0.2,0.4,1.44,0,0.47,1.44,-0.2,0.4,1.44,-0.34,0.23,1.44,-0.4,0,1.44,-0.34,-0.23,1.44,-0.2,-0.4,1.44,0,-0.47,1.44,0.2,-0.4,1.44,0.34,-0.23,1.44,0.46,0,1.44,0.4,0.27,1.44,0.23,0.46,1.44,0,0.53,1.44,-0.23,0.46,1.44,-0.4,0.27,1.44,-0.46,0,1.44,-0.4,-0.27,1.44,-0.23,-0.46,1.44,0,-0.53,1.44,0.23,-0.46,1.44,0.4,-0.27,1.44,0.78,0,-1.44,0.68,0.4,-1.44,0.39,0.69,-1.44,0,0.8,-1.44,-0.39,0.69,-1.44,-0.68,0.4,-1.44,-0.78,0,-1.44,-0.68,-0.4,-1.44,-0.39,-0.69,-1.44,0,-0.8,-1.44,0.39,-0.69,-1.44,0.68,-0.4,-1.44,0.68,0,-1.44,0.59,0.35,-1.44,0.34,0.6,-1.44,0,0.69,-1.44,-0.34,0.6,-1.44,-0.59,0.35,-1.44,-0.68,0,-1.44,-0.59,-0.35,-1.44,-0.34,-0.6,-1.44,0,-0.69,-1.44,0.34,-0.6,-1.44,0.59,-0.35,-1.44,0.34,0,0.99,0.29,0.2,0.99,0.17,0.34,0.99,0,0.4,0.99,-0.17,0.34,0.99,-0.29,0.2,0.99,-0.34,0,0.99,-0.29,-0.2,0.99,-0.17,-0.34,0.99,0,-0.4,0.99,0.17,-0.34,0.99,0.29,-0.2,0.99,0.46,0,0.99,0.4,0.27,0.99,0.23,0.46,0.99,0,0.53,0.99,-0.23,0.46,0.99,-0.4,0.27,0.99,-0.46,0,0.99,-0.4,-0.27,0.99,-0.23,-0.46,0.99,0,-0.53,0.99,0.23,-0.46,0.99,0.4,-0.27,0.99,0.46,0,0.07,0.4,0.23,0.07,0.23,0.4,0.07,0,0.47,0.07,-0.23,0.4,0.07,-0.4,0.23,0.07,-0.46,0,0.07,-0.4,-0.23,0.07,-0.23,-0.4,0.07,0,-0.47,0.07,0.23,-0.4,0.07,0.4,-0.23,0.07,0.62,0,0.07,0.54,0.31,0.07,0.31,0.55,0.07,0,0.63,0.07,-0.31,0.55,0.07,-0.54,0.31,0.07,-0.62,0,0.07,-0.54,-0.31,0.07,-0.31,-0.55,0.07,0,-0.63,0.07,0.31,-0.55,0.07,0.54,-0.31,0.07,0.46,0,-0.08,0.4,0.23,-0.08,0.23,0.4,-0.08,0,0.47,-0.08,-0.23,0.4,-0.08,-0.4,0.23,-0.08,-0.46,0,-0.08,-0.4,-0.23,-0.08,-0.23,-0.4,-0.08,0,-0.47,-0.08,0.23,-0.4,-0.08,0.4,-0.23,-0.08,0.62,0,-0.08,0.54,0.31,-0.08,0.31,0.55,-0.08,0,0.63,-0.08,-0.31,0.55,-0.08,-0.54,0.31,-0.08,-0.62,0,-0.08,-0.54,-0.31,-0.08,-0.31,-0.55,-0.08,0,-0.63,-0.08,0.31,-0.55,-0.08,0.54,-0.31,-0.08,0.46,0,-1.19,0.4,0.23,-1.19,0.23,0.4,-1.19,0,0.47,-1.19,-0.23,0.4,-1.19,-0.4,0.23,-1.19,-0.46,0,-1.19,-0.4,-0.23,-1.19,-0.23,-0.4,-1.19,0,-0.47,-1.19,0.23,-0.4,-1.19,0.4,-0.23,-1.19,0.62,0,-1.19,0.54,0.31,-1.19,0.31,0.55,-1.19,0,0.63,-1.19,-0.31,0.55,-1.19,-0.54,0.31,-1.19,-0.62,0,-1.19,-0.54,-0.31,-1.19,-0.31,-0.55,-1.19,0,-0.63,-1.19,0.31,-0.55,-1.19,0.54,-0.31,-1.19,0.62,0,-0.98,0.54,0.31,-0.98,0.31,0.55,-0.98,0,0.63,-0.98,-0.31,0.55,-0.98,-0.54,0.31,-0.98,-0.62,0,-0.98,-0.54,-0.31,-0.98,-0.31,-0.55,-0.98,0,-0.63,-0.98,0.31,-0.55,-0.98,0.54,-0.31,-0.98,0.46,0,-0.98,0.4,0.23,-0.98,0.23,0.4,-0.98,0,0.47,-0.98,-0.23,0.4,-0.98,-0.4,0.23,-0.98,-0.46,0,-0.98,-0.4,-0.23,-0.98,-0.23,-0.4,-0.98,0,-0.47,-0.98,0.23,-0.4,-0.98,0.4,-0.23,-0.98])
IndexedFaceSet34.setCoord(Coordinate35)
Shape33.setGeometry(IndexedFaceSet34)
Appearance36 = AppearanceObject().setUSE("CameraAppearance")
Shape33.setAppearance(Appearance36)
Switch21.addChild(Shape33)
Shape37 = ShapeObject()
IndexedFaceSet38 = IndexedFaceSetObject().setDEF("pSphere1_0Geo").setConvex(False).setCoordIndex([0,1,12,11,-1,1,2,13,12,-1,2,3,14,13,-1,3,4,15,14,-1,4,5,16,15,-1,5,6,17,16,-1,6,7,18,17,-1,7,8,19,18,-1,8,9,20,19,-1,10,0,11,21,-1,11,12,23,22,-1,12,13,24,23,-1,13,14,25,24,-1,14,15,26,25,-1,15,16,27,26,-1,16,17,28,27,-1,17,18,29,28,-1,18,19,30,29,-1,19,20,31,30,-1,21,11,22,32,-1,22,23,34,33,-1,23,24,35,34,-1,24,25,36,35,-1,25,26,37,36,-1,26,27,38,37,-1,27,28,39,38,-1,28,29,40,39,-1,29,30,41,40,-1,30,31,42,41,-1,32,22,33,43,-1,33,34,45,44,-1,34,35,46,45,-1,35,36,47,46,-1,36,37,48,47,-1,37,38,49,48,-1,38,39,50,49,-1,39,40,51,50,-1,40,41,52,51,-1,41,42,53,52,-1,43,33,44,54,-1,44,45,56,55,-1,45,46,57,56,-1,46,47,58,57,-1,47,48,59,58,-1,48,49,60,59,-1,49,50,61,60,-1,50,51,62,61,-1,51,52,63,62,-1,52,53,64,63,-1,54,44,55,65,-1,55,56,67,66,-1,56,57,68,67,-1,57,58,69,68,-1,58,59,70,69,-1,59,60,71,70,-1,60,61,72,71,-1,61,62,73,72,-1,62,63,74,73,-1,63,64,75,74,-1,65,55,66,76,-1,66,67,78,77,-1,67,68,79,78,-1,68,69,80,79,-1,69,70,81,80,-1,70,71,82,81,-1,71,72,83,82,-1,72,73,84,83,-1,73,74,85,84,-1,74,75,86,85,-1,76,66,77,87,-1,77,78,89,88,-1,78,79,90,89,-1,79,80,91,90,-1,80,81,92,91,-1,81,82,93,92,-1,82,83,94,93,-1,83,84,95,94,-1,84,85,96,95,-1,85,86,97,96,-1,87,77,88,98,-1,88,89,100,99,-1,89,90,101,100,-1,90,91,102,101,-1,91,92,103,102,-1,92,93,104,103,-1,93,94,105,104,-1,94,95,106,105,-1,95,96,107,106,-1,96,97,108,107,-1,98,88,99,109,-1,99,100,111,110,-1,100,101,112,111,-1,101,102,113,112,-1,102,103,114,113,-1,103,104,115,114,-1,104,105,116,115,-1,105,106,117,116,-1,106,107,118,117,-1,107,108,119,118,-1,109,99,110,120,-1,110,111,122,121,-1,111,112,123,122,-1,112,113,124,123,-1,113,114,125,124,-1,114,115,126,125,-1,115,116,127,126,-1,116,117,128,127,-1,117,118,129,128,-1,118,119,130,129,-1,120,110,121,131,-1,121,122,133,132,-1,122,123,134,133,-1,123,124,135,134,-1,124,125,136,135,-1,125,126,137,136,-1,126,127,138,137,-1,127,128,139,138,-1,128,129,140,139,-1,129,130,141,140,-1,131,121,132,142,-1,132,133,144,143,-1,133,134,145,144,-1,134,135,146,145,-1,135,136,147,146,-1,136,137,148,147,-1,137,138,149,148,-1,138,139,150,149,-1,139,140,151,150,-1,140,141,152,151,-1,142,132,143,153,-1,143,144,155,154,-1,144,145,156,155,-1,145,146,157,156,-1,146,147,158,157,-1,147,148,159,158,-1,148,149,160,159,-1,149,150,161,160,-1,150,151,162,161,-1,151,152,163,162,-1,153,143,154,164,-1,154,155,166,165,-1,155,156,167,166,-1,156,157,168,167,-1,157,158,169,168,-1,158,159,170,169,-1,159,160,171,170,-1,160,161,172,171,-1,161,162,173,172,-1,162,163,174,173,-1,164,154,165,175,-1,165,166,177,176,-1,166,167,178,177,-1,167,168,179,178,-1,168,169,180,179,-1,169,170,181,180,-1,170,171,182,181,-1,171,172,183,182,-1,172,173,184,183,-1,173,174,185,184,-1,175,165,176,186,-1,176,177,188,187,-1,177,178,189,188,-1,178,179,190,189,-1,179,180,191,190,-1,180,181,192,191,-1,181,182,193,192,-1,182,183,194,193,-1,183,184,195,194,-1,184,185,196,195,-1,186,176,187,197,-1,187,188,199,198,-1,188,189,200,199,-1,189,190,201,200,-1,190,191,202,201,-1,191,192,203,202,-1,192,193,204,203,-1,193,194,205,204,-1,194,195,206,205,-1,195,196,207,206,-1,197,187,198,208,-1,1,0,209,-1,2,1,209,-1,3,2,209,-1,4,3,209,-1,5,4,209,-1,6,5,209,-1,7,6,209,-1,8,7,209,-1,198,199,210,-1,199,200,210,-1,200,201,210,-1,201,202,210,-1,202,203,210,-1,203,204,210,-1,204,205,210,-1,205,206,210,-1]).setCreaseAngle(0.7854)
Coordinate39 = CoordinateObject().setDEF("pSphere1GeoPoints").setPoint([0.06,-0.43,-0.02,0.05,-0.43,-0.04,0.04,-0.43,-0.05,0.02,-0.43,-0.06,0,-0.43,-0.07,-0.02,-0.43,-0.06,-0.04,-0.43,-0.05,-0.05,-0.43,-0.04,-0.06,-0.43,-0.02,-0.07,-0.43,0,0.07,-0.43,0,0.13,-0.41,-0.04,0.11,-0.41,-0.08,0.08,-0.41,-0.11,0.04,-0.41,-0.13,0,-0.41,-0.13,-0.04,-0.41,-0.13,-0.08,-0.41,-0.11,-0.11,-0.41,-0.08,-0.13,-0.41,-0.04,-0.13,-0.41,0,0.13,-0.41,0,0.19,-0.38,-0.06,0.16,-0.38,-0.11,0.11,-0.38,-0.16,0.06,-0.38,-0.19,0,-0.38,-0.2,-0.06,-0.38,-0.19,-0.11,-0.38,-0.16,-0.16,-0.38,-0.11,-0.19,-0.38,-0.06,-0.2,-0.38,0,0.2,-0.38,0,0.24,-0.35,-0.08,0.2,-0.35,-0.15,0.15,-0.35,-0.2,0.08,-0.35,-0.24,0,-0.35,-0.25,-0.08,-0.35,-0.24,-0.15,-0.35,-0.2,-0.2,-0.35,-0.15,-0.24,-0.35,-0.08,-0.25,-0.35,0,0.25,-0.35,0,0.29,-0.3,-0.09,0.25,-0.3,-0.18,0.18,-0.3,-0.25,0.09,-0.3,-0.29,0,-0.3,-0.3,-0.09,-0.3,-0.29,-0.18,-0.3,-0.25,-0.25,-0.3,-0.18,-0.29,-0.3,-0.09,-0.3,-0.3,0,0.3,-0.3,0,0.33,-0.25,-0.11,0.28,-0.25,-0.2,0.2,-0.25,-0.28,0.11,-0.25,-0.33,0,-0.25,-0.35,-0.11,-0.25,-0.33,-0.2,-0.25,-0.28,-0.28,-0.25,-0.2,-0.33,-0.25,-0.11,-0.35,-0.25,0,0.35,-0.25,0,0.37,-0.2,-0.12,0.31,-0.2,-0.23,0.23,-0.2,-0.31,0.12,-0.2,-0.37,0,-0.2,-0.38,-0.12,-0.2,-0.37,-0.23,-0.2,-0.31,-0.31,-0.2,-0.23,-0.37,-0.2,-0.12,-0.38,-0.2,0,0.38,-0.2,0,0.39,-0.13,-0.13,0.33,-0.13,-0.24,0.24,-0.13,-0.33,0.13,-0.13,-0.39,0,-0.13,-0.41,-0.13,-0.13,-0.39,-0.24,-0.13,-0.33,-0.33,-0.13,-0.24,-0.39,-0.13,-0.13,-0.41,-0.13,0,0.41,-0.13,0,0.4,-0.07,-0.13,0.34,-0.07,-0.25,0.25,-0.07,-0.34,0.13,-0.07,-0.4,0,-0.07,-0.43,-0.13,-0.07,-0.4,-0.25,-0.07,-0.34,-0.34,-0.07,-0.25,-0.4,-0.07,-0.13,-0.43,-0.07,0,0.43,-0.07,0,0.41,0,-0.13,0.35,0,-0.25,0.25,0,-0.35,0.13,0,-0.41,0,0,-0.43,-0.13,0,-0.41,-0.25,0,-0.35,-0.35,0,-0.25,-0.41,0,-0.13,-0.43,0,0,0.43,0,0,0.4,0.07,-0.13,0.34,0.07,-0.25,0.25,0.07,-0.34,0.13,0.07,-0.4,0,0.07,-0.43,-0.13,0.07,-0.4,-0.25,0.07,-0.34,-0.34,0.07,-0.25,-0.4,0.07,-0.13,-0.43,0.07,0,0.43,0.07,0,0.39,0.13,-0.13,0.33,0.13,-0.24,0.24,0.13,-0.33,0.13,0.13,-0.39,0,0.13,-0.41,-0.13,0.13,-0.39,-0.24,0.13,-0.33,-0.33,0.13,-0.24,-0.39,0.13,-0.13,-0.41,0.13,0,0.41,0.13,0,0.37,0.2,-0.12,0.31,0.2,-0.23,0.23,0.2,-0.31,0.12,0.2,-0.37,0,0.2,-0.38,-0.12,0.2,-0.37,-0.23,0.2,-0.31,-0.31,0.2,-0.23,-0.37,0.2,-0.12,-0.38,0.2,0,0.38,0.2,0,0.33,0.25,-0.11,0.28,0.25,-0.2,0.2,0.25,-0.28,0.11,0.25,-0.33,0,0.25,-0.35,-0.11,0.25,-0.33,-0.2,0.25,-0.28,-0.28,0.25,-0.2,-0.33,0.25,-0.11,-0.35,0.25,0,0.35,0.25,0,0.29,0.3,-0.09,0.25,0.3,-0.18,0.18,0.3,-0.25,0.09,0.3,-0.29,0,0.3,-0.3,-0.09,0.3,-0.29,-0.18,0.3,-0.25,-0.25,0.3,-0.18,-0.29,0.3,-0.09,-0.3,0.3,0,0.3,0.3,0,0.24,0.35,-0.08,0.2,0.35,-0.15,0.15,0.35,-0.2,0.08,0.35,-0.24,0,0.35,-0.25,-0.08,0.35,-0.24,-0.15,0.35,-0.2,-0.2,0.35,-0.15,-0.24,0.35,-0.08,-0.25,0.35,0,0.25,0.35,0,0.19,0.38,-0.06,0.16,0.38,-0.11,0.11,0.38,-0.16,0.06,0.38,-0.19,0,0.38,-0.2,-0.06,0.38,-0.19,-0.11,0.38,-0.16,-0.16,0.38,-0.11,-0.19,0.38,-0.06,-0.2,0.38,0,0.2,0.38,0,0.13,0.41,-0.04,0.11,0.41,-0.08,0.08,0.41,-0.11,0.04,0.41,-0.13,0,0.41,-0.13,-0.04,0.41,-0.13,-0.08,0.41,-0.11,-0.11,0.41,-0.08,-0.13,0.41,-0.04,-0.13,0.41,0,0.13,0.41,0,0.06,0.43,-0.02,0.05,0.43,-0.04,0.04,0.43,-0.05,0.02,0.43,-0.06,0,0.43,-0.07,-0.02,0.43,-0.06,-0.04,0.43,-0.05,-0.05,0.43,-0.04,-0.06,0.43,-0.02,-0.07,0.43,0,0.07,0.43,0,0,-0.43,0,0,0.43,0])
IndexedFaceSet38.setCoord(Coordinate39)
Shape37.setGeometry(IndexedFaceSet38)
Appearance40 = AppearanceObject().setUSE("CameraAppearance")
Shape37.setAppearance(Appearance40)
Switch21.addChild(Shape37)
Transform20.addChild(Switch21)
Group41 = GroupObject()
Transform42 = TransformObject().setDEF("pCylinder1").setRotation([-1,0,0,0.373518]).setTranslation([-0.038462,3.596312,3.297562])
Shape43 = ShapeObject()
Appearance44 = AppearanceObject().setUSE("CameraAppearance")
Shape43.setAppearance(Appearance44)
IndexedFaceSet45 = IndexedFaceSetObject().setUSE("pCylinder1_0Geo")
Shape43.setGeometry(IndexedFaceSet45)
Transform42.addChild(Shape43)
Group41.addChild(Transform42)
Transform46 = TransformObject().setDEF("pCube1").setScale([1,0.727134,0.801457]).setTranslation([-0.030769,1.738461,1.4436])
Shape47 = ShapeObject()
Appearance48 = AppearanceObject().setUSE("CameraAppearance")
Shape47.setAppearance(Appearance48)
IndexedFaceSet49 = IndexedFaceSetObject().setUSE("pCube1_0Geo")
Shape47.setGeometry(IndexedFaceSet49)
Transform46.addChild(Shape47)
Group41.addChild(Transform46)
Transform50 = TransformObject().setDEF("pPipe1").setScale([1,1,0.569444]).setTranslation([0.015385,1.630769,-1.973274])
Shape51 = ShapeObject()
Appearance52 = AppearanceObject().setUSE("CameraAppearance")
Shape51.setAppearance(Appearance52)
IndexedFaceSet53 = IndexedFaceSetObject().setUSE("pPipe1_0Geo")
Shape51.setGeometry(IndexedFaceSet53)
Transform50.addChild(Shape51)
Group41.addChild(Transform50)
Transform54 = TransformObject().setDEF("pSphere1").setScale([1.1,1.1,0.1]).setTranslation([-0.015385,1.628515,-2.569231])
Shape55 = ShapeObject()
Appearance56 = AppearanceObject().setUSE("CameraAppearance")
Shape55.setAppearance(Appearance56)
IndexedFaceSet57 = IndexedFaceSetObject().setUSE("pSphere1_0Geo")
Shape55.setGeometry(IndexedFaceSet57)
Transform54.addChild(Shape55)
Group41.addChild(Transform54)
Transform20.addChild(Group41)
Scene13.addChild(Transform20)
X3D0.setScene(Scene13)

X3D0.toFileX3D("../out/orig/CameraShape.new.x3d")
