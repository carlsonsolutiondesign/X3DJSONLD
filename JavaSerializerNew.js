let mapToMethod = require('./mapToMethod.js');
let fieldTypes = require('./fieldTypes.js');
let mapToMethod2 = {
        "Scene" : {
                "ROUTE" : "addChild",
                "IMPORT" : "addChild",
                "EXPORT" : "addChild",
                "ProtoDeclare" : "addChild",
                "ExternProtoDeclare" : "addChild"
        },
	"Billboard" : {
                "ROUTE" : "addChild"
	},
	"Anchor" : {
                "ROUTE" : "addChild"
	},
	"Switch" : {
                "ROUTE" : "addChild"
	},
	"Transform" : {
		"ProtoInstance": "addChild",
		"ROUTE": "addChild",
		"IS": "setIS",
                "ExternProtoDeclare" : "addChild",
                "IMPORT" : "addChild",
	},
	"Group" : {
		"ProtoInstance": "addChild",
		"ExternProtoDeclare": "addChild",
		"ProtoDeclare": "addChild",
		"ROUTE": "addChild",
		"IS": "setIS"
	},
	"Shape" : {
		"ProtoInstance": "setGeometry"
	},
	"ImageTexture" : {
		"IS": "setIS"
	},
	"Material" : {
		"IS": "setIS"
	},
	"Appearance" : {
		"IS": "setIS"
	},
	"HAnimJoint" : {
		"Transform" : "addChild"
	},
	"HAnimHumanoid" : {
		 "HAnimViewpoint": "addViewpoints",
        },
	"ComposedShader" : {
		"field" : "addField",
	},
        "ProtoBody" : {
                "ROUTE" : "addChild",
                "ProtoDeclare" : "addChild"
        },
	"Script" : {
		"field" : "addField",
		"IS": "setIS"
	},
        "Text" : {
		"IS": "setIS"
        },
        "GeoLocation" : {
                "ROUTE" : "addChild",
                "ExternProtoDeclare" : "addChild"
        },
	"MetadataSet" : {
		"ProtoInstance" : "setMetadata"
	}
};

Object.assign(mapToMethod, {
});

for (map in mapToMethod2) {
        Object.assign(mapToMethod[map], mapToMethod2[map]);
}


let JavaSerializer = {};
JavaSerializer.serializeToString = function(json, element, clazz) {
	/*
	for (let a in element.attributes) {
		let attrs = element.attributes;
		let attributeName = attrs[a].nodeName;
		if (attributeName === "version" && attrs[a].nodeValue !== "3.3") {
			console.log(clazz, attrs[a].nodeValue);
			return;
		}
	}
	*/

	let str = "";
	let pc = clazz.replace(/-|\.| /g, "$")
	let c = pc.lastIndexOf("/");
	let clz = pc.substr(c+1);
	clz = clz.replace(/^([0-9].*|default$)/, "_$1")
	let pkg = pc.substr(0, c).replace(/\//g, ".").trim();

	if (pkg.length > 0) {
		str += "package "+pkg+";\n";
	}
	str += "import org.web3d.x3d.jsail.*;\n";
	str += "import org.web3d.x3d.jsail.CADGeometry.*;\n";
	str += "import org.web3d.x3d.jsail.Core.*;\n";
	str += "import org.web3d.x3d.jsail.CubeMapTexturing.*;\n";
	str += "import org.web3d.x3d.jsail.DIS.*;\n";
	str += "import org.web3d.x3d.jsail.EnvironmentalEffects.*;\n";
	str += "import org.web3d.x3d.jsail.EnvironmentalSensor.*;\n";
	str += "import org.web3d.x3d.jsail.EventUtilities.*;\n";
	str += "import org.web3d.x3d.jsail.Followers.*;\n";
	str += "import org.web3d.x3d.jsail.Geometry2D.*;\n";
	str += "import org.web3d.x3d.jsail.Geometry3D.*;\n";
	str += "import org.web3d.x3d.jsail.Geospatial.*;\n";
	str += "import org.web3d.x3d.jsail.Grouping.*;\n";
	str += "import org.web3d.x3d.jsail.HAnim.*;\n";
	str += "import org.web3d.x3d.jsail.Interpolation.*;\n";
	str += "import org.web3d.x3d.jsail.KeyDeviceSensor.*;\n";
	str += "import org.web3d.x3d.jsail.Layering.*;\n";
	str += "import org.web3d.x3d.jsail.Layout.*;\n";
	str += "import org.web3d.x3d.jsail.Lighting.*;\n";
	str += "import org.web3d.x3d.jsail.NURBS.*;\n";
	str += "import org.web3d.x3d.jsail.Navigation.*;\n";
	str += "import org.web3d.x3d.jsail.Networking.*;\n";
	str += "import org.web3d.x3d.jsail.ParticleSystems.*;\n";
	str += "import org.web3d.x3d.jsail.Picking.*;\n";
	str += "import org.web3d.x3d.jsail.PointingDeviceSensor.*;\n";
	str += "import org.web3d.x3d.jsail.Rendering.*;\n";
	str += "import org.web3d.x3d.jsail.RigidBodyPhysics.*;\n";
	str += "import org.web3d.x3d.jsail.Scripting.*;\n";
	str += "import org.web3d.x3d.jsail.Shaders.*;\n";
	str += "import org.web3d.x3d.jsail.Shape.*;\n";
	str += "import org.web3d.x3d.jsail.Sound.*;\n";
	str += "import org.web3d.x3d.jsail.Text.*;\n";
	str += "import org.web3d.x3d.jsail.Texturing3D.*;\n";
	str += "import org.web3d.x3d.jsail.Texturing.*;\n";
	str += "import org.web3d.x3d.jsail.Time.*;\n";
	str += "import org.web3d.x3d.jsail.VolumeRendering.*;\n";
	str += "import org.web3d.x3d.jsail.fields.*;\n";
	str += "import org.web3d.x3d.sai.*;\n";
	str += "import org.web3d.x3d.sai.CADGeometry.*;\n";
	str += "import org.web3d.x3d.sai.Core.*;\n";
	str += "import org.web3d.x3d.sai.CubeMapTexturing.*;\n";
	str += "import org.web3d.x3d.sai.DIS.*;\n";
	str += "import org.web3d.x3d.sai.EnvironmentalEffects.*;\n";
	str += "import org.web3d.x3d.sai.EnvironmentalSensor.*;\n";
	str += "import org.web3d.x3d.sai.EventUtilities.*;\n";
	str += "import org.web3d.x3d.sai.Followers.*;\n";
	str += "import org.web3d.x3d.sai.Geometry2D.*;\n";
	str += "import org.web3d.x3d.sai.Geometry3D.*;\n";
	str += "import org.web3d.x3d.sai.Geospatial.*;\n";
	str += "import org.web3d.x3d.sai.Grouping.*;\n";
	str += "import org.web3d.x3d.sai.HAnim.*;\n";
	str += "import org.web3d.x3d.sai.Interpolation.*;\n";
	str += "import org.web3d.x3d.sai.KeyDeviceSensor.*;\n";
	str += "import org.web3d.x3d.sai.Layering.*;\n";
	str += "import org.web3d.x3d.sai.Layout.*;\n";
	str += "import org.web3d.x3d.sai.Lighting.*;\n";
	str += "import org.web3d.x3d.sai.NURBS.*;\n";
	str += "import org.web3d.x3d.sai.Navigation.*;\n";
	str += "import org.web3d.x3d.sai.Networking.*;\n";
	str += "import org.web3d.x3d.sai.ParticleSystems.*;\n";
	str += "import org.web3d.x3d.sai.Picking.*;\n";
	str += "import org.web3d.x3d.sai.PointingDeviceSensor.*;\n";
	str += "import org.web3d.x3d.sai.Rendering.*;\n";
	str += "import org.web3d.x3d.sai.RigidBodyPhysics.*;\n";
	str += "import org.web3d.x3d.sai.Scripting.*;\n";
	str += "import org.web3d.x3d.sai.Shaders.*;\n";
	str += "import org.web3d.x3d.sai.Shape.*;\n";
	str += "import org.web3d.x3d.sai.Sound.*;\n";
	str += "import org.web3d.x3d.sai.Text.*;\n";
	str += "import org.web3d.x3d.sai.Texturing3D.*;\n";
	str += "import org.web3d.x3d.sai.Texturing.*;\n";
	str += "import org.web3d.x3d.sai.Time.*;\n";
	str += "import org.web3d.x3d.sai.VolumeRendering.*;\n";
	str += "public class "+clz+" {\n";
	str += "	public static void main(String[] args) {\n";
	str += JavaSerializer.subSerializeToString(element);
        str += ";\n        ConfigurationProperties.setShowDefaultAttributes(true);\n";
        str += "        ConfigurationProperties.setIndentCharacter(ConfigurationProperties.indentCharacter_DEFAULT);\n";
        str += "        ConfigurationProperties.setIndentIncrement(ConfigurationProperties.indentIncrement_DEFAULT);\n";
        str += "        ConfigurationProperties.setX3dCanonicalForm();\n";
        str += "        ConfigurationProperties.initialize();\n";

	str += "	ConfigurationProperties.setXsltEngine(ConfigurationProperties.XSLT_ENGINE_nativeJava);\n";

	str += "	X3D0.toFileJSON(args[0]);\n";
	str += "	}\n";
	str += "}\n";
	return str;
}

function printParentChild(element, n, node, cn) {
	let addpre = ".set";
	if (cn > 0 && node.nodeName !== 'IS') {
		addpre = ".add";
	}

	let method = node.nodeName;
	if (typeof mapToMethod[element.nodeName] === 'object') {
		if (typeof mapToMethod[element.nodeName][node.nodeName] === 'string') {
			addpre = ".";
			method = mapToMethod[element.nodeName][node.nodeName];
		}
	} else if (typeof mapToMethod[element.nodeName] === 'string') {
		addpre = ".";
		method = mapToMethod[element.nodeName];
	}
	let cf = false;
	for (let a in node.attributes) {
		let attrs = node.attributes;
		try {
			parseInt(a);
			if (attrs.hasOwnProperty(a) && attrs[a].nodeType == 2) {
				let cfmethod = attrs[a].nodeName;
				if (cfmethod === 'containerField') {
					cf = true;
					method = attrs[a].nodeValue;
				}
			}
		} catch (e) {
			console.error(e);
		}
	}
	if (!cf) {
		return "\t".repeat(n)+addpre+method+"(";
	} else {
		method = "set"+method.charAt(0).toUpperCase() + method.slice(1);
		return "\t".repeat(n)+"."+method+"(";
	}
}

JavaSerializer.subSerializeToString = function(element, n, grandparent, gn) {
	n = n || 0;
	let str = "";
	if (n === 0) {
		str += "\t".repeat(n)+element.nodeName+"Object "+element.nodeName+n+" = new "+element.nodeName+"Object()\n";
        }
	for (let cn in element.childNodes) {
		let node = element.childNodes[cn];
		if (element.childNodes.hasOwnProperty(cn) && node.nodeType == 1) {
			str += printParentChild(element, n, node, cn);
			str += 'new '+node.nodeName+'Object()\n';
			str += JavaSerializer.subSerializeToString(node, n+1, element, n);
			str += "\t".repeat(n)+")\n";
		} else if (element.childNodes.hasOwnProperty(cn) && node.nodeType == 8) {
			str += "\t".repeat(n)+'.addComments(new CommentsBlock("'+node.nodeValue.replace(/"/g, '\\"')+'"))\n';
		} else if (element.childNodes.hasOwnProperty(cn) && node.nodeType == 4) {
			str += "\t".repeat(n)+'.setSourceCode("'+node.nodeValue.replace(/"/g, '\\"').replace(/\\n'/, "\\n'").split("\r\n").join('\\n\"+\n\"')+'")\n';
		}
	}
	let fieldAttrType = "";
	for (let a in element.attributes) {
		let attrs = element.attributes;
		try {
			parseInt(a);
			if (attrs.hasOwnProperty(a) && attrs[a].nodeType == 2) {
				let attr = attrs[a].nodeName;
				if (attr == "type") {
					fieldAttrType = attrs[a].nodeValue;
				}
			}
		} catch (e) {
			console.error(e);
		}
	}
	for (let a in element.attributes) {
		let attrs = element.attributes;
		try {
			parseInt(a);
			if (attrs.hasOwnProperty(a) && attrs[a].nodeType == 2) {
				let attr = attrs[a].nodeName;
				if (attr == "xmlns:xsd" || attr == "xsd:noNamespaceSchemaLocation") {
					continue;
				}
				if (attr === 'containerField') {
					/*
					*/
				} else {
					let method = attr;
					// look at object model
					let attrType = fieldTypes[element.nodeName][attr];

					// str += "attrType "+attrType+" FAT "+fieldAttrType+" "+attrs[a].nodeValue+"\n";
					// but if it's NULL, look at the field type
					if (attrs[a].nodeValue === 'NULL' &&
					   (fieldAttrType === "SFNode"  ||
					    fieldAttrType === "MFNode")) {
						method = "clearChildren";
					} else {
						method = "set"+method.charAt(0).toUpperCase() + method.slice(1);
					}
					str += "\t".repeat(n)+"."+method+"(";
					if (attrs[a].nodeValue === 'NULL') {
						str += "";
					} else if (attrType === "SFString") {
						str += '"'+attrs[a].nodeValue.replace(/\\?"/g, "&quot;")+'"';
					} else if (attrType === "SFInt32") {
						str += attrs[a].nodeValue;
					} else if (attrType === "SFFloat") {
						str += attrs[a].nodeValue+"f";
					} else if (attrType === "SFDouble") {
						str += attrs[a].nodeValue+"d";
					} else if (attrType === "SFBool") {
						str += attrs[a].nodeValue
					} else if (attrType === "MFString") {
						str += "new String[] {\""+attrs[a].nodeValue.split('" "').join('","').replace(/"/g, '\\"')+"\"}";
					} else if (
						attrType === "MFInt32"||
						attrType === "MFImage"||
						attrType === "SFImage") {
						str += "new int[] {"+attrs[a].nodeValue.split(' ').join(',')+"}";
					} else if (
						attrType === "SFColor"||
						attrType === "MFColor"||
						attrType === "SFColorRGBA"||
						attrType === "MFColorRGBA"||
						attrType === "SFVec2f"||
						attrType === "SFVec3f"||
						attrType === "SFVec4f"||
						attrType === "MFVec2f"||
						attrType === "MFVec3f"||
						attrType === "MFVec4f"||
						attrType === "SFMatrix3f"||
						attrType === "SFMatrix4f"|
						attrType === "MFMatrix3f"||
						attrType === "MFMatrix4f"|
						attrType === "SFRotation"|
						attrType === "MFRotation"|
						attrType === "MFFloat") {
						str += "new float[] {"+attrs[a].nodeValue.split(' ').join('f,')+"f}";
					} else if (
						attrType === "SFVec2d"||
						attrType === "SFVec3d"||
						attrType === "SFVec4d"|
						attrType === "MFVec2d"||
						attrType === "MFVec3d"||
						attrType === "MFVec4d"|
						attrType === "SFMatrix3d"||
						attrType === "SFMatrix4d"|
						attrType === "MFMatrix3d"||
						attrType === "MFMatrix4d"|
						attrType === "MFDouble") {
						str += "new double[] {"+attrs[a].nodeValue.split(' ').join('d,')+"d}";
					} else if (attrType === "MFBool") {
						str += "new boolean[] {"+attrs[a].nodeValue.split(' ').join(',')+"}";
					} else {
						str += attrs[a].nodeValue;
					}
					str += ")\n";
				}
			}
		} catch (e) {
			console.error(e);
		}
		attrType = "";
	}
	return str;
}


module.exports = JavaSerializer;