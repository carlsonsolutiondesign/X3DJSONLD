"use strict";

var jsonlint = require("jsonlint");

const DOUBLE_SUFFIX = 'd';
const FLOAT_SUFFIX = 'f';

function DOM2JSONSerializer() {
}


DOM2JSONSerializer.prototype = {
	serializeToString : function(json, element, clazz, mapToMethod, fieldTypes) {
		var str = "";
		str += '{';
		str += this.printMethod(element, fieldTypes, "", 0);
		str += '}\n';

		try {
			str = JSON.stringify(jsonlint.parse(str), null, 2);
		} catch (e) {
			console.log(str, clazz, e);

		}
		return str;
	},

	printSubArray: function (values, j, trail) {
		return '['+values.join(j)+trail+']';
	},

	printMethod: function (node, fieldTypes, par, n) {
		var str = "";
		var cf = false;
		for (var a in node.attributes) {
			var attrs = node.attributes;
			try {
				parseInt(a);
				if (attrs.hasOwnProperty(a) && attrs[a].nodeType == 2) {
					var attr = attrs[a].nodeName;
					if (attr === 'containerField') {
						str += '  '.repeat(n)+'"-'+attrs[a].nodeValue+'" : {\n';
						cf = true;
					}
				}
			} catch (e) {
			}
		}
		if (par === "-children") {
			cf = true;
			str += '  '.repeat(n)+'{ "'+node.nodeName+'":';;
		} else if (par === "") {
			str += '  '.repeat(n)+'"'+node.nodeName+'":';
		}
		str += '  '.repeat(n)+'{\n';
		str += this.subSerializeToString(node, fieldTypes, n+1);
		str += '  '.repeat(n)+'}\n';
		if (cf) {
			str += '  '.repeat(n)+'}\n';
		}
		return str;
	},

	printComment: function (node, par, n) {
		var str = "";
		var cf = false;
		if (par === "-children") {
			cf = true;
			str += '  '.repeat(n)+'{ "'+node.nodeName+'":';
		} else if (par === "") {
			str += '  '.repeat(n)+'"'+node.nodeName+'":';
		}
		
		str += "\""+(node.nodeValue.
			replace(/\\/g, '\\\\').
			replace(/"/g, '\\"').
			replace(/\n/g, '\\n'))+"\"";
		if (cf) {
			str += '}\n';
		}
		return str;
	},

	printSourceText: function (node, par, n) {
		var str = "";
		var cf = false;
		if (par === "-children") {
			cf = true;
			str += '  '.repeat(n)+'{ "#sourceText":';
		} else if (par === "") {
			str += '  '.repeat(n)+'"#sourceText":';
		}
		str +=  '["'+node.nodeValue.split("\r\n").map(
			function(x) { return x.
					        replace(/\\/g, '\\\\').
						replace(/"/g, '\\"').
						replace(/\t/g, '\\t')
							;
			}).join('",\n"')+'"]';
		if (cf) {
			str += '}\n';
		}
		return str;
	},

	subSerializeToString : function(element, fieldTypes, n) {
		var fieldAttrType = "";
		for (var a in element.attributes) {
			var attrs = element.attributes;
			try {
				parseInt(a);
				if (attrs.hasOwnProperty(a) && attrs[a].nodeType == 2) {
					var attr = attrs[a].nodeName;
					if (attr == "type") {
						fieldAttrType = attrs[a].nodeValue;
					}
				}
			} catch (e) {
				console.error(e);
			}
		}
		var attrType = "";
		var object = [];
		for (var a in element.attributes) {
			var attrs = element.attributes;
			try {
				parseInt(a);
				if (attrs.hasOwnProperty(a) && attrs[a].nodeType == 2) {
					var attr = attrs[a].nodeName;
					var method = attr;
					if (attr === 'containerField') {
						continue;
					}
					// look at object model
					var attrType = "SFString";
					try {
						attrType = fieldTypes[element.nodeName][attr];
					} catch (e) {
						console.error("Missing", attr, "in fieldTypes.js element", element.nodeName, " = ", fieldTypes[element.nodeName], "setting to SFString");
					}

					if (attrs[a].nodeValue === 'NULL' &&
					   (fieldAttrType === "SFNode"  ||
					    fieldAttrType === "MFNode")) {
						method = "-children";
					}
					var attrstr = '  '.repeat(n)+'"@'+method+'":';
					if (attrs[a].nodeValue === 'NULL') {
						attrstr += "null";
					} else if (attrType === "SFString") {
						attrstr += '"'+attrs[a].nodeValue.replace(/\\?"/g, "\\\"")+'"';
					} else if (attrType === "SFInt32" ||
					           attrType === "SFFloat" ||
					           attrType === "SFDouble" ||
					           attrType === "SFBool") {
						attrstr += attrs[a].nodeValue;
					} else if (attrType === "MFString") {
						attrstr += this.printSubArray(
							attrs[a].nodeValue.
								replace(/([^\\]| )\\\\( |[^\\"])/g, "$1\\\\$2").
								replace(/([^\\]| )\\\\\\\\([^\\"]| )/g, "$1\\\\\\\\\\\\\\\\$2").
								replace(/\\\\\\\\"/g, '\\\\"').
								replace(/\\\\"/g, '\\\\\\"').
								replace(/\t/g, '\\t').
								replace(/&/g, "&amp;").
								split(/"[ ,]+"/),
							'","', '');
					} else if (
						attrType === "MFInt32"||
						attrType === "MFImage"||
						attrType === "SFImage"||
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
						attrType === "SFMatrix4f"||
						attrType === "MFMatrix3f"||
						attrType === "MFMatrix4f"||
						attrType === "SFRotation"||
						attrType === "MFRotation"||
						attrType === "MFFloat"||
						attrType === "SFVec2d"||
						attrType === "SFVec3d"||
						attrType === "SFVec4d"||
						attrType === "MFVec2d"||
						attrType === "MFVec3d"||
						attrType === "MFVec4d"||
						attrType === "SFMatrix3d"||
						attrType === "SFMatrix4d"||
						attrType === "MFMatrix3d"||
						attrType === "MFMatrix4d"||
						attrType === "MFDouble") {
						attrstr += this.printSubArray(attrs[a].nodeValue.split(/[ ,]+/), ',', '');
					} else {
						attrstr += '"'+attrs[a].nodeValue.replace(/\\?"/g, "\\\"")+'"';
					}
					object.push(attrstr);
				}
			} catch (e) {
				console.error(e);
			}
			attrType = "";
		}
		var childstr = "";
		var children = {};
		var par = "";
		var childpar = false;
		var route = [];
		for (var cn in element.childNodes) {
			var node = element.childNodes[cn];
			if ( typeof node.nodeName !== "undefined" &&
			    node.nodeName !== "meta" &&
			    node.nodeName !== "field" &&
			    node.nodeName !== "fieldValue" &&
			    node.nodeName !== "connect" &&
			    node.nodeName !== "ROUTE" &&
			    typeof children[node.nodeName] !== 'undefined') {
				childpar = true;
			}
			children[node.nodeName] = true;

		}
		var attrchildren = false;
		if (element.nodeName === "X3D" ||
			element.nodeName === "Appearance" ||
			element.nodeName === "ComposedCubeMapTexture" ||
			element.nodeName === "TextureBackground" ||
			element.nodeName === "Sound" ||
			element.nodeName === "IndexedFaceSet" ||
			element.nodeName === "ProtoDeclare" ||
			element.nodeName === "Text" ||
			element.nodeName === "Collision" ||
			element.nodeName === "Shape") {
			attrchildren = true;

		}
		var chilluns = [];
		var chillins = [];
		var pc = false;
		for (var cn in element.childNodes) {
			var node = element.childNodes[cn];
			if (element.childNodes.hasOwnProperty(cn) && node.nodeType == 1) {
				if (par !== node.nodeName && (
					par === "meta" ||
					par === "field" ||
					par === "fieldValue" ||
					par === "connect" ||
					par === "ROUTE")) {
					if (par === "ROUTE") {
						route.push(this.printParChilluns(par, chilluns, n+1));
					} else {
						object.push(this.printParChilluns(par, chilluns, n+1));
					}
					chilluns = [];
				}
				if (node.nodeName === "meta" ||
				    node.nodeName === "field" ||
				    node.nodeName === "fieldValue" ||
				    node.nodeName === "connect" ||
				    node.nodeName === "ROUTE") {
					par = node.nodeName;
					chilluns.push(this.printMethod(node, fieldTypes, par, n+1));
				} else if (attrchildren) {
					object.push(this.printMethod(node, fieldTypes, par, n+1));
				} else {
					chillins.push(this.printMethod(node, fieldTypes, childpar ? "-children" : "", n+1));
				}
			} else if (element.childNodes.hasOwnProperty(cn) && node.nodeType == 8) {
				chillins.push(this.printComment(node, childpar ? "-children" : "", n+1));
			} else if (element.childNodes.hasOwnProperty(cn) && node.nodeType == 4) {
				chillins.push(this.printSourceText(node, childpar ? "-children" : "", n+1));
			}
		}
		if (chillins.length > 0) {
			object.push(this.printParChilluns(childpar ? "-children" : "", chillins, n+1));
		}
		if (chilluns.length > 0) {
			if (par === "ROUTE") {
				route.push(this.printParChilluns(par, chilluns, n+1));
			} else {
				object.push(this.printParChilluns(par, chilluns, n+1));
			}
		}
		return object.concat(route).join(',\n');
	},

	printParChilluns : function(par, chilluns, n) {
		var str = "";
		if (par !== "") {
			str += '  '.repeat(n)+'"'+par+'": [\n';
			str += '  '.repeat(n)+chilluns.join(",");
			str += '  '.repeat(n)+']\n';
		} else {
			str += '  '.repeat(n)+chilluns.join(",");
		}
		return str;
	}
};


if (typeof module === 'object')  {
	module.exports = DOM2JSONSerializer;
}