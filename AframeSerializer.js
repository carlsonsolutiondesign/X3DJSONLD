"use strict";

var xmldom = require('xmldom');
var DOMImplementation = new xmldom.DOMImplementation();
var XMLSerializer = new xmldom.XMLSerializer();

function AframeSerializer () {
};

AframeSerializer.prototype = {
	serializeToString : function(json, element, clazz, mapToMethod, fieldTypes) {
		var docType = DOMImplementation.createDocumentType("html");
		var document = DOMImplementation.createDocument(null, "html", docType);
		var aframeelement = document.getElementsByTagNameNS(null, "html")[0];
		let x3d = this.parseObject(document, "body", fieldTypes, json);
		aframeelement.appendChild(x3d);
		var xml = '<?xml version="1.0" encoding="'+json.X3D["encoding"]+'"?>\n';
		xml += XMLSerializer.serializeToString(aframeelement);
		console.log(xml);
		return xml;
	},
		/*
	parseSubObject : function(attrType, type, values) {
		return values.join(" ");
		if (attrType.startsWith("MF")) {
			let newArray = [];
			for (let j = 0; j < values.length;) {
				let newObject = {};
				for (let letter in type) {
					newObject[type[letter]] = parseFloat(values[j++]);
				}
				newArray.push(newObject);
			}
			return newArray;

		} else {
			let newObject = {};
			let j = 0;
			for (let letter in type) {
				newObject[type[letter]] = parseFloat(values[j++]);
			}
			return newObject;
		}
	},
	parseSubArray : function(attrType, numpersub, values) {
		return values.join(" ");
		if (numpersub > 1 && attrType.startsWith("MF")) {
			let newArrays = [];
			for (let j = 0; j < values.length;) {
				let newArray = [];
				for (let i = 0; i < numpersub; i++) {
					if (attrType === "MFString") {
						newArray[i] = values[j++];
					} else {
						newArray[i] = parseFloat(values[j++]);
					}
				}
				newArrays.push(newArray);
			}
			return newArrays;
		} else if (numpersub === 0) { // index
			let newArrays = [];
			let newArray = [];
			let i = 0;
			for (let j = 0; j < values.length;) {
				if (values[j] == -1) {
					newArrays.push(newArray);
					newArray = [];
					j++;
					i = 0;
				} else {
					if (attrType === "MFString") {
						newArray[i++] = values[j++];
					} else {
						newArray[i++] = parseFloat(values[j++]);
					}
				}
			}
			return newArrays;
		} else {
			return values;
		}
	},
		*/
	jsonCopy : function(from) {
		return JSON.parse(JSON.stringify(from));
	},
	componentsToAttributes : function(element, components) {
		let componentCollector = {};
		for (let component in components) {
			if (typeof componentCollector[component] === 'undefined') {
				componentCollector[component] = [];
			}
			console.log("	component", component);
			let properties = components[component];
			let props = componentCollector[component];
			for (let property in properties) {
				console.log("		property", property,properties[property]);
				if (property !== "element") {
					let p = property+": "+properties[property];
					props.push(p);
				}
			}
			console.log("Setting attribute",component,"to", props.join("; "));
		}
		for (let component in componentCollector) {
			let props = componentCollector[component];
			element.setAttribute(component, props.join("; "));
		}
	},
	elementToComponentMap(name, attr, components, component, json, field, value) {
		console.log("value is", value);
		let map = {
			/* name
			 * 	attribute
			 * 		component
			 *			property: (value or function)
			 */
			Box: {
				element: { geometry : { primitive: "box"}},
				size: {
					geometry: { 
						width: function (json, field, value) {
							return value[0];
						},
						height: function (json, field, value) {
							return value[1];
						},
						depth: function (json,field, value) {
							return value[2];
						}
					}
				}
			},
			Circle2D : {
				element: { geometry : { primitive: "circle"}}, 
				radius : { geometry: { radius: value, } },
				subdivision: { geometry: { segments: value } }
			},
			Arc2D : {
				element: { geometry : { primitive: "circle"}}, 
				radius : { geometry: { radius: value } },
				startAngle: {
					geometry: {
						thetaStart: function (json, field, value) {
							return value * 180 / Math.PI;
						}
					}
				},
				endAngle: {
					geometry: {
						thetaLength: function (json, field, value) {
							return value * 180 / Math.PI;
							return (json["@endAngle"] - json["@startAngle"]) * 180 / Math.PI;
						}
					}
				}
			},
			Cone : {
				element: { geometry : { primitive: "cone"}}, 
				bottomRadius : { geometry: { radiusBottom: value } },
				bottom : { geometry: { openEnded: !value } },
				height : { geometry: { height: value } }
			},
			Cylinder : {
				element: { geometry : { primitive: "cylinder"}},
				radius : { geometry: { radius: value } },
				bottom : { geometry: { openEnded: value } },
				top : { geometry: { openEnded: !value } },
				height : { geometry: { height: value } },
				subdivision: { geometry: { segmentsRadial: value } }
			},
			Disk2D: {
				element: { geometry: { primitive: "ring"}},
			},
			Plane: {
				element: { geometry : { primitive: "plane"}},
			},
			Sphere: {
				element: { geometry : { primitive: "sphere"}},
			},
			Text: {
				element: { geometry : { primitive: "text"}},
			},
			Torus: {
				element: { geometry : { primitive: "torus"}},
			},
			ImageTexture: {
				element: parentElement,
				url: { material : { src: value[0] }},  // get first URL.
			},
			Group: {
				element: "a-entity"
			},
			MovieTexture: {
				element: "a-video"
			},
			Scene: {
				element: "a-scene"
			},
			Shape: {
				element: "a-entity"
			},
			Transform: {
				element: "a-entity"
			},
			body: {
				element: "body"
			},
			X3D: {
				element: "div"
			},
		};
		let mapComponents;
		if (typeof map[name] !== 'undefined') {
			mapComponents = map[name][attr];
			console.log("Found", name, attr, JSON.stringify(mapComponents));
		}
		if (typeof mapComponents === 'object' && typeof component !== 'undefined') {
			for (let mapComponent in mapComponents) {
				console.log("map comp", mapComponent);
				let properties = mapComponents[mapComponent];
				for (let property in properties) {
					if (typeof components !== 'undefined') {
						if (typeof components[component] === 'undefined') {
							components[component] = {};
						}

						if (typeof properties[property] === 'function' || typeof value !== 'undefined') {
							// we only copy those attributes for one property, so the other properties don't get wiped out.
							components[component][property] = properties[property](json, field, value);
						} else {
							components[component][property] = properties[property];
						}
						console.log("component value is ", components[component][property]);
					}
					console.log("prop", property, "comps", JSON.stringify(components));
				}
			}
			return map[name];
		} else {
			return map[name];
		}
	},
	getValueFromJsonField(json, field, attrType) {
		let value = "";
		/*
		if (json[field] === 'NULL') {
			value = null;
		} else if (attrType === "SFString") {
			value = json[field];
		} else if (attrType === "SFInt32") {
			value = json[field];
		} else if (attrType === "SFFloat") {
			value = json[field];
		} else if (attrType === "SFDouble") {
			value = json[field];
		} else if (attrType === "SFBool") {
			value = json[field];
		} else if (attrType === "MFString") {
			value = this.parseSubArray(attrType, 1, json[field]);
		} else if (attrType === "MFInt32") {
			if (field.endsWith("Index")) {
				value = this.parseSubArray(attrType, 0, json[field]);
			} else {
				value = this.parseSubArray(attrType, 1, json[field]);
			}
		} else if (
			attrType === "MFImage"||
			attrType === "SFImage") {
			value = this.parseSubArray(attrType, 1, json[field]);
		} else if (
			attrType === "SFColor"||
			attrType === "MFColor") {
			value = this.parseSubObject(attrType, "rgb", json[field]);
		} else if (
			attrType === "SFColorRGBA"||
			attrType === "MFColorRGBA") {
			value = this.parseSubObject(attrType, "rgba", json[field]);
		} else if (
			attrType === "SFVec2d"||
			attrType === "MFVec2d"||
			attrType === "SFVec2f"||
			attrType === "MFVec2f") {
			value = this.parseSubObject(attrType, "xy", json[field]);
		} else if (
			attrType === "SFVec3d"||
			attrType === "MFVec3d"||
			attrType === "SFVec3f"||
			attrType === "MFVec3f") {
			value = this.parseSubObject(attrType, "xyz", json[field]);
		} else if (
			attrType === "SFVec4d"||
			attrType === "MFVec4d"||
			attrType === "SFVec4f"||
			attrType === "MFVec4f") {
			value = this.parseSubObject(attrType, "xyzw", json[field]);
		} else if (
			attrType === "SFRotation"||
			attrType === "MFRotation") {
			value = this.parseSubObject(attrType, "xyzw", json[field]);
		} else if (
			attrType === "SFMatrix3d"||
			attrType === "MFMatrix3d"||
			attrType === "SFMatrix3f"||
			attrType === "MFMatrix3f") {
			value = this.parseSubArray(attrType, 9, json[field]);
		} else if (
			attrType === "SFMatrix4d"||
			attrType === "MFMatrix4d"||
			attrType === "SFMatrix4f"||
			attrType === "MFMatrix4f") {
			value = this.parseSubArray(attrType, 16, json[field]);
		} else if (
			attrType === "MFFloat") {
			value = this.parseSubArray(attrType, 1, json[field]);
		} else if (
			attrType === "MFDouble") {
			value = this.parseSubArray(attrType, 1, json[field]);
		} else if (attrType === "MFBool") {
			value = this.parseSubArray(attrType, 1, json[field]);
		} else {
		*/
			value = json[field];
		// }
		return value;
	},
	parseObject : function(document, name, fieldTypes, json) {
		let element;

		let components = {};
		let parentComponents = {};
		let aframe = this.elementToComponentMap(name, "element", components, "geometry"); // we don't need JSON as these are hard-coded
		console.log("Aframe is", aframe, "for", name);
		if (typeof aframe === 'undefined') {
			element = document.createElement(name+"U-a-entity");
			// this is an unimplemented node
		} else if (typeof aframe.element === 'undefined') {
			// this node has no element
			element = document.createElement(name+"A-a-entity");
		} else if (typeof aframe.element === 'string') {
			// this is a partially implemented node
			element = document.createElement(aframe.element);
		} else if (typeof aframe === 'object') {
			// this is a primitive geometry
			element = document.createElement("a-entity");
		}
		
		if (typeof element === 'undefined') {
			console.error("couldn't create element for ", name);
		} else {
			// console.error("element ", name);
		}
		for (let field in json) {
			if (field.startsWith("@")) {
				let attr = field.substr(1);
				if ((attr === "profile" || attr === "version") && aframe.element === "div") {
					continue;
				}
				if (attr === "string" && name === "Text") {
					attr = "value"
				}
				if (attr === "translation" && name === "Transform") {
					attr = "position"
				}
				if (attr === "xmlns:xsd" || attr === "xsd:noNamespaceSchemaLocation") {
					continue;
				}
				/*
				if (attr !== 'containerField') {
					// look at object model
					let attrType = "SFString";
					if (typeof fieldTypes[name] !== 'undefined') {
						attrType = fieldTypes[name][attr];
					}

					// let value = this.getValueFromJsonField(json, field, attrType);
				*/
					let value = json[field];
					this.elementToComponentMap(name, attr, components, "geometry", json, field, value);
					this.elementToComponentMap(name, attr, parentComponents, "material", json, field, value);

					element.setAttribute(attr, value);
				/*
				}
				*/
			} else if (field === "#comment") {
				element.appendChild(document.createComment(json[field]));
			} else if (field === "#sourceText") {
				element.appendChild(document.createCDATASection(json[field].join("\r\n").replace(/'([^'\r]*)\n([^']*)'/g, "'$1\\n$2'")));

			} else {
				let node = json[field];
				if (typeof node === 'object') {
					let containerElement = this.parseObject(document, field, fieldTypes, node);

					let ct = containerElement.nodeName || "-";
					let nct = parseInt(ct.trim());
					let ict = ct.startsWith("-") || !isNaN(nct); // illegal if true
					if (ict) {
						let children = Array.prototype.slice.call(containerElement.childNodes);
						// skip the immediete child
						for (let child = 0; child < children.length; child++) {
							if (typeof children[child] !== 'undefined') {
								// console.log("Append 1", children[child].nodeName, "parent", field);
								element.appendChild(children[child]);
								element.components = element.components.concat(children[child].parentComponents);
							}
							// console.log("looping");
						}
					} else if (name) {
						// console.log("Append 2", containerElement.nodeName, field);
						element.appendChild(containerElement);
						element.components = element.components.concat(containerElement.parentComponents);
					}
				}
			}
		}
		// now add the collected components as attributes.
		element.components = element.components.concat(element.parentComponents);
		element.parentComponents = parentComponents; // STORE IT IN DOM (BAD)
		this.componentsToAttributes(element, components);
		return element;
	}
}


if (typeof module === 'object')  {
	module.exports = AframeSerializer;
}