load('X3Dautoclass.js');
var ConfigurationProperties = Packages.org.web3d.x3d.jsail.ConfigurationProperties;
ConfigurationProperties.showDefaultAttributes = false;
ConfigurationProperties.xsltEngine = ConfigurationProperties.XSLT_ENGINE_nativeJava;
ConfigurationProperties.deleteIntermediateFiles = false;
ConfigurationProperties.setStripTrailingZeroes(true);
      var X3D0 =  new X3DObject().setProfile("Interchange").setVersion("3.0")
      .setHead(new headObject()
        .addMeta(new metaObject().setName("title").setContent("rgb_alpha.x3d"))
        .addMeta(new metaObject().setName("Image").setContent("rgb_alpha-front.jpg"))
        .addMeta(new metaObject().setName("Image").setContent("rgb_alpha-rear.jpg"))
        .addMeta(new metaObject().setName("Image").setContent("rgb_alpha-top.jpg"))
        .addMeta(new metaObject().setName("Image").setContent("rgb_alpha-bottom.jpg"))
        .addMeta(new metaObject().setName("reference").setContent("http://www.nist.gov/vrml.html"))
        .addMeta(new metaObject().setName("reference").setContent("http://www.itl.nist.gov/div897/ctg/vrml/vrml.html"))
        .addMeta(new metaObject().setName("creator").setContent("http://www.itl.nist.gov/div897/ctg/vrml/members.html"))
        .addMeta(new metaObject().setName("disclaimer").setContent("This file was provided by the National Institute of Standards and Technology, and is part of the X3D Conformance Test Suite, available at http://www.nist.gov/vrml.html The information contained within this file is provided for use in establishing conformance to the ISO VRML97 Specification. Conformance to this test does not imply recommendation or endorsement by the National Institute of Standards and Technology. This software can be redistributed and/or modified freely provided that any derivative works bear some notice that they are derived from it, and any modified versions bear some notice that they have been modified."))
        .addMeta(new metaObject().setName("info").setContent("Correct definition and compliance of this conformance scene is maintained by the X3D Working Group, http://www.web3d.org/working-groups/x3d"))
        .addMeta(new metaObject().setName("translator").setContent("Michael Kass NIST, Don Brutzman NPS"))
        .addMeta(new metaObject().setName("translated").setContent("21 January 2001"))
        .addMeta(new metaObject().setName("modified").setContent("16 January 2011"))
        .addMeta(new metaObject().setName("description").setContent("Test browser ability to map a RGB plus alpha opacity to geometry. A checkerboard of four colored squares: lower left (red), lower right (transparent), uppser left (transparent) and upper right (red) map onto the faces of all geometry. For the sphere, the texture should cover the entire surface, and wrap counterclockwise from the back of the sphere. For the cone, the texture should wrap counterclockwise (from above) starting at the back of the cone. A circle cutout of the texture is applied right side up to the base of the cone when the cone is tilted toward the -z axis. For the cylinder, the texture should wrap counterclockwise (from above) starting at the back of the cylinder. A circle cutout of the texture is applied right side up to the top and bottom caps of the cylinder. For the box, the texture should be applied right side up in its entirety to each face of the box."))
        .addMeta(new metaObject().setName("identifier").setContent("http://www.web3d.org/x3d/content/examples/ConformanceNist/Appearance/PixelTexture/rgb_alpha.x3d"))
        .addMeta(new metaObject().setName("generator").setContent("Vrml97ToX3dNist, http://ovrt.nist.gov/v2_x3d.html"))
        .addMeta(new metaObject().setName("generator").setContent("X3D-Edit 3.3, https://savage.nps.edu/X3D-Edit"))
        .addMeta(new metaObject().setName("license").setContent("../../license.html")))
      .setScene(new SceneObject()
        .addChild(new NavigationInfoObject().setType(Java.to(["EXAMINE","WALK","FLY","ANY"], Java.type("java.lang.String[]"))))
        .addChild(new GroupObject()
          .addChild(new TransformObject().setTranslation(Java.to([6.14221,0.0694613,-0.000999451], Java.type("float[]")))
            .addChild(new ShapeObject()
              .setAppearance(new AppearanceObject()
                .setMaterial(new MaterialObject())
                .setTexture(new PixelTextureObject().setDEF("RgbOpacityCheckerboard").setImage(Java.to([2,2,4,4278190335,4294901760,4294901760,4278190335], Java.type("int[]")))))
              .setGeometry(new BoxObject())))
          .addChild(new TransformObject().setTranslation(Java.to([-4.85443,0.0694381,-0.00149918], Java.type("float[]")))
            .addChild(new ShapeObject()
              .setAppearance(new AppearanceObject()
                .setMaterial(new MaterialObject())
                .setTexture(new PixelTextureObject().setUSE("RgbOpacityCheckerboard")))
              .setGeometry(new SphereObject())))
          .addChild(new TransformObject().setTranslation(Java.to([-1.47341,0.036672,-0.00175095], Java.type("float[]")))
            .addChild(new ShapeObject()
              .setAppearance(new AppearanceObject()
                .setMaterial(new MaterialObject())
                .setTexture(new PixelTextureObject().setUSE("RgbOpacityCheckerboard")))
              .setGeometry(new ConeObject())))
          .addChild(new TransformObject().setTranslation(Java.to([2.31094,0.0694206,-0.00187683], Java.type("float[]")))
            .addChild(new ShapeObject()
              .setAppearance(new AppearanceObject()
                .setMaterial(new MaterialObject())
                .setTexture(new PixelTextureObject().setUSE("RgbOpacityCheckerboard")))
              .setGeometry(new CylinderObject())))))      ;
    X3D0.toFileX3D("../new/json/rgb_alpha.new.x3d");
