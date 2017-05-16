function convertJsonToStl(json) {
	var LDNodeList = [];
	var LDNode = initializeLDNode(json, "X3D");
	LDNodeList.push(LDNode);
	LDNodeList = toNormals(json, LDNodeList, LDNode);
	if (LDNodeList !== null) {
		var transform = Matrix.translation(0,0,0);
		var output = [];
		transformLDNodesToTriangles(LDNodeList[0], output, transform);
		return output.join("\r\n")+"\r\n";
	} else {
		return null;
	}
}


function initializeLDNode(json, obj) {
	var LDNode = {};
	LDNode.USE = json[obj]["@USE"];
	LDNode.DEF = json[obj]["@DEF"];
	LDNode.nodeName = obj;
	return LDNode;
}
function findLDNodeInList(use, LDNodeList) {
	if (typeof use !== 'undefined') {
		for (var g in LDNodeList) {
			var LDNode = LDNodeList[g];
			if (LDNode.DEF === use) {
				console.log("Found USE", use, "returning", LDNode);
				return LDNode;
			}
		}
	}
	return null;
}

function toNormals(json, LDNodeList, ParentNode) {
	var LDNode = LDNodeList.length === 0 ? null : LDNodeList[LDNodeList.length-1];
	var nodeDispatchTable = {
		IndexedFaceSet : function(obj, LDNode) {
			LDNode.normalPerVertex = true;
			LDNode.kid = true;
			LDNode.geometry = true;
		},
		IndexedTriangleSet : function(obj, LDNode) {
			LDNode.normalPerVertex = true;
			LDNode.kid = true;
			LDNode.geometry = true;
		},
		IndexedTriangleStripSet : function(obj, LDNode) {
			LDNode.normalPerVertex = true;
			LDNode.kid = true;
			LDNode.geometry = true;
		},
		IndexedTriangleFanSet : function(obj, LDNode) {
			LDNode.normalPerVertex = true;
			LDNode.kid = true;
			LDNode.geometry = true;
		},
		IndexedLineSet : function(obj, LDNode) {
			LDNode.geometry = false;
		},
		Normal : function(obj, LDNode) {
			LDNode.child = "Normal";
		},
		Coordinate : function(obj, LDNode) {
			LDNode.child = "Coordinate";
		},
		Transform : function(obj, LDNode) {
			LDNode.kid = true;
		}
	}
	var fieldDispatchTable = {
		"@scale" : function(obj, LDNode) {
			LDNode.scale = Matrix.scale(obj[0], obj[1], obj[2]);
			console.log("Scaling", LDNode.scale);
		},
		"@rotation" : function(obj, LDNode) {
			LDNode.quaternion = Matrix.quaternion(obj[0], obj[1], obj[2], obj[3]);
			console.log("Rotating", LDNode.scale);
		},
		"@translation" : function(obj, LDNode) {
			LDNode.translation = Matrix.translation(obj[0], obj[1], obj[2]);
			console.log("Translating", LDNode.scale);
		},
		"@normalPerVertex" : function(obj, LDNode) {
			LDNode.normalPerVertex = obj;
		},
		"@vector" : function(obj, LDNode) {
			var len = obj.length / 3;
			LDNode.vector = [];
			for (var o = 0, off = -1; o < len; o++) {
				if (typeof LDNode.vector[o] === 'undefined') {
					LDNode.vector[o] = [];
				}
				LDNode.vector[o][0] = obj[++off];
				LDNode.vector[o][1] = obj[++off];
				LDNode.vector[o][2] = obj[++off];
			}
		},
		"@point" : function(obj, LDNode) {
			var len = obj.length / 3;
			LDNode.point = [];
			for (var o = 0, off = -1; o < len; o++) {
				if (typeof LDNode.point[o] === 'undefined') {
					LDNode.point[o] = [];
				}
				LDNode.point[o][0] = obj[++off];
				LDNode.point[o][1] = obj[++off];
				LDNode.point[o][2] = obj[++off];
			}
		},
		"@normalIndex" : function(obj, LDNode) {
			var f = 0;
			LDNode.normalIndex = [];
			for (var o = 0; o < obj.length; o++) {
				if (obj[o] == -1 || LDNode.normalPerVertex === false) {
					f++;
				} else {
					if (typeof LDNode.normalIndex[f] === 'undefined') {
						LDNode.normalIndex[f] = [];
					}
					LDNode.normalIndex[f].push(obj[o]);
				}
			}
		},
		"@coordIndex" : function(obj, LDNode) {
			var f = 0;
			LDNode.coordIndex = [];
			for (var o = 0; o < obj.length; o++) {
				if (obj[o] == -1) {
					f++;
				} else {
					if (typeof LDNode.coordIndex[f] === 'undefined') {
						LDNode.coordIndex[f] = [];
					}
					LDNode.coordIndex[f].push(obj[o]);
				}
			}
		},
		"@index" : function(obj, LDNode) {
			LDNode.index = [];
			var f = -1;
			switch(LDNode.nodeName) {
			case 'IndexedTriangleSet':
				for (var o = 0; o < obj.length; o++) {
					if (o % 3 === 0) {
						f++;
					}
					if (typeof LDNode.index[f] === 'undefined') {
						LDNode.index[f] = [];
					}
					LDNode.index[f].push(obj[o]);
				}
				break;
			case 'IndexedTriangleStripSet':
				for (var o = 2; o < obj.length; o++) {
					if (obj[o] == -1) {
						o += 3;
						if (o >= obj.length) {
							break;
						}
					}
					f++;
					LDNode.index[f] = [];
					LDNode.index[f].push(obj[o-2]);
					LDNode.index[f].push(obj[o-1]);
					LDNode.index[f].push(obj[o]);
				}
				break;
			case 'IndexedTriangleFanSet':
				var center = 0;
				for (var o = 2; o < obj.length; o++) {
					if (obj[o] == -1) {
						center = o+1;
						o += 3;
						if (o >= obj.length) {
							break;
						}
					}
					f++;
					LDNode.index[f] = [];
					LDNode.index[f].push(obj[center]);
					LDNode.index[f].push(obj[o-1]);
					LDNode.index[f].push(obj[o]);
				}
				break;
			}
		}
	}
	for (var obj in json) {
		if (typeof nodeDispatchTable[obj] !== 'undefined') {
			var LDNode = findLDNodeInList(json[obj]["@USE"], LDNodeList);
			if (LDNode === null) {
				LDNode = initializeLDNode(json, obj);
				LDNodeList.push(LDNode);
				nodeDispatchTable[obj](json[obj], LDNode); // further initialization
			}
			if (LDNode.child) {
				ParentNode[LDNode.child] = LDNode;
			}
			if (LDNode.kid) {
				if (typeof ParentNode.kids === 'undefined') {
					ParentNode.kids = [];
				}
				if (ParentNode !== LDNode) {
					ParentNode.kids.push(LDNode);
				}
			}
		}
		if (typeof fieldDispatchTable[obj] !== 'undefined') {
			fieldDispatchTable[obj](json[obj], LDNode);
		}
		if (typeof json[obj] === 'object') {
			LDNodeList = toNormals(json[obj], LDNodeList, LDNode);
		}
	}
	return LDNodeList;
}

function vector_product(u, v) {
	return [ u[1] * v[2] - u[2] * v[1], u[2] * v[0] - u[0] * v[2], u[0] * v[1] - u[1] * v[0] ];
}

function normalize(v) {
	var norm = Math.sqrt(v[0]*v[0] + v[1]*v[1] + v[2]*v[2]);
	return [ v[0]/norm, v[1]/norm, v[2]/norm ];
}

function triangle_normal(a, b, c) {
	var ba = [a[0] - b[0], a[1] - b[1], a[2] - b[2]];
	var bc = [c[0] - b[0], c[1] - b[1], c[2] - b[2]];
	baxbc = vector_product(ba, bc);
	return normalize(baxbc);
}

function printSFVec3f(prefix, x, y, z, output, transform) {
	var finaltransform = transform.copy();
	var point = finaltransform.matvecmult(new Matrix(x, y, z, 1))
	output.push([prefix, point[0], point[1], point[2]].join(" "));
}
function IndexedTriangle(LDNode, output, transform) {
	if (typeof LDNode.index === 'object') {
		output.push("solid "+(LDNode.DEF || LDNode.nodeName));
		for (var face in LDNode.index) { // each face
			var f = LDNode.index[face];
			// normalPerVertex == false
			if (typeof LDNode.Normal === 'undefined') {
				// compute the normal for the face with 3 points
				var normal = triangle_normal(
					LDNode.Coordinate.point[f[0]],
					LDNode.Coordinate.point[f[1]],
					LDNode.Coordinate.point[f[2]],
					output,
					transform);
				printSFVec3f("  facet normal",
					normal[0],
					normal[1],
					normal[2],
					output,
					transform);
			} else {
				printSFVec3f("  facet normal",
					LDNode.Normal.vector[f[0]][0],
					LDNode.Normal.vector[f[0]][1],
					LDNode.Normal.vector[f[0]][2],
					output,
					transform);
			}
			output.push("    outer loop");
			// v = 0, 1, 2
			for (var v = 0; v < 3; v++) {
				printSFVec3f("      vertex",
					LDNode.Coordinate.point[f[v]][0],
					LDNode.Coordinate.point[f[v]][1],
					LDNode.Coordinate.point[f[v]][2],
					output,
					transform);
			}
			output.push("    endloop");
			output.push("  endfacet");
		}
		output.push("endsolid "+(LDNode.DEF || LDNode.nodeName));
	}
}

function transformLDNodesToTriangles(LDNode, output, parentTransform) {
	var dispatchTable = {
		IndexedFaceSet: function(LDNode, output, transform) {
			if (typeof LDNode.coordIndex === 'object') {
				output.push("solid "+(LDNode.DEF || LDNode.nodeName));
				for (var face in LDNode.coordIndex) { // each face
					var f = LDNode.coordIndex[face];
			// just pick a close vector for now, average later
					if (typeof LDNode.normalIndex === 'undefined') {
						var normal = triangle_normal(
							LDNode.Coordinate.point[f[0]] || [ 1, 0, 0 ],
							LDNode.Coordinate.point[f[1]] || [ 0, 1, 0 ],
							LDNode.Coordinate.point[f[2]] || [ 0, 0, 1 ]);
						printSFVec3f("  facet normal",
							normal[0],
							normal[1],
							normal[2],
							output,
							transform);
					} else {
						var fn = LDNode.normalIndex[face];
						printSFVec3f("  facet normal",
							LDNode.Normal.vector[fn[0]][0] || 0, 
							LDNode.Normal.vector[fn[0]][1] || 0,
							LDNode.Normal.vector[fn[0]][2] || 1,
							output,
							transform);
					}
					output.push("    outer loop");
					for (var v in f) {
						if (typeof LDNode.Coordinate.point[f[v]] !== 'undefined') {
							printSFVec3f("      vertex",
								LDNode.Coordinate.point[f[v]][0] || 0,
								LDNode.Coordinate.point[f[v]][1] || 0,
								LDNode.Coordinate.point[f[v]][2] || 1,
								output,
								transform);
						}
					}
					output.push("    endloop");
					output.push("  endfacet");
				}
				output.push("endsolid "+(LDNode.DEF || LDNode.nodeName));
			}
		},
		IndexedTriangleSet: IndexedTriangle,
		IndexedTriangleStripSet: IndexedTriangle,
		IndexedTriangleFanSet: IndexedTriangle
	};
	for (var k in LDNode.kids) {
		var CNode = LDNode.kids[k];

		var transform = parentTransform.copy();
		if (CNode.translation) {
			transform = transform.matmatmult(CNode.translation);
		}
		if (CNode.quaternion) {
			transform = transform.matmatmult(CNode.quaternion);
		}
		if (CNode.scale) {
			transform = transform.matmatmult(CNode.scale);
		}
		// only print out geometry
		if (CNode.geometry) {
			dispatchTable[CNode.nodeName](CNode, output, transform);
		}
		transformLDNodesToTriangles(CNode, output, transform);
	}
}