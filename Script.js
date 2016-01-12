// X3D JSON Script expander
packages = {};

function Script(package, name) {
	this.setters = {};
	this.getters = {};
	if (typeof package === 'undefined' || package.name === "") {
		if (typeof name === 'undefined') {
			this.name = "";
		} else {
			this.name = name;
		}
	} else {
		if (typeof name === 'undefined') {
			this.name = package.name;
		} else {
			this.name = package.name+'.'+name;
		}
	}
	packages[this.name] = this;
}

Script.prototype.find = function (name) {
	return packages[name];
}


function zapSource(object) {
	if (typeof object === "object") {
		for (p in object) {
			if (p === '#sourceText') {
				delete object[p];
			} else {
				zapSource(object[p]);
			}
		}
	}
}
function processScripts(object, classes, package, routecode) {
	if (typeof package === 'undefined') {
		classes.push('var X3DJSON = {');
	}
	package = package || new Script();
	var p;
	if (typeof object === "object") {
		for (p in object) {
			if (typeof object[p] === 'undefined') {
				continue;
			}
			var name = object[p]["@name"];
			if (typeof name === 'undefined') {
				name = object[p]["@DEF"];
			}
			if (p.toLowerCase() === 'script') {
				var script = new Script(package, name);
				processFields(object[p]['field'], classes, script);
				processSource(object[p]['#sourceText'], classes, script);
				// zap original source because we don't need it
				classes.push('},');
				processScripts(object[p], classes, script, routecode);
				// delete object[p]['#sourceText'];
			} else if (p.toLowerCase() === 'route') {
				processRoute(object[p], routecode, package);
			} else if (p.toLowerCase() === '@use') {
				var name = object["@USE"];
				object["@USE"] = name;
				// object[p] is not an object
			} else if (p.toLowerCase() === '@def') {
				var name = object["@DEF"];
				object["@DEF"] = name;
				// object[p] is not an object
			} else {
				processScripts(object[p], classes, package, routecode);
			}
		}
	}
}

function processRoute(route, classes, package) {
	var fromNode = route["@fromNode"];
	var fromField = route["@fromField"];
	var toNode = route["@toNode"];
	var toField = route["@toField"];
	if (typeof package.find(toNode) === 'undefined') {
		classes.push('if (!$(".'+toNode+'")) console.log("undefined '+toNode+'");');
		var  to = '$(".'+toNode+'").attr("'+toField+'",';
	} else {
		var  to = 'X3DJSON.' +toNode+'.'+toField+'(';
	}
	if (typeof package.find(fromNode) === 'undefined') {
		classes.push('if (!$(".'+fromNode+'")) console.log("undefined '+fromNode+'");');
		var  from = '$(".'+fromNode+'").attr("'+fromField+'")';
	} else {
		if (fromField.indexOf("_changed") > 0) {
			var from = 'X3DJSON.' +fromNode+'.'+fromField+'()';
		} else {
			var from = 'X3DJSON.' +fromNode+'.'+fromField+'_changed()';
		}
	}
	classes.push('\t'+to+from+');');
}

function processFields(fields, classes, package) {
	var f;
	var initializers = [];
	var values = {};
	var indent = '\t';
	var types = {};
	for (f in fields) {
		var object = fields[f];
		var name = object["@name"];
		types[name] = object["@type"];
		switch(object['@accessType']) {
		case 'initializeOnly':
			// these should be in order, so it's an array
			initializers.push(name);
			values[name] = object["@value"];
			break;
		case 'inputOutput':
			// setters should be looked up by name
			package.setters[name] = object;
			package.getters[name] = object;
			values[name] = object["@value"];
			break;
		case 'inputOnly':
			// setters should be looked up by name
			package.setters[name] = object;
			values[name] = object["@value"];
			break;
		case 'outputOnly':
			package.getters[name] = object;
			values[name] = undefined;
			break;
		default:
			break;
		}
	}

	classes.push(package.name +  ' : {');
	// classes.push(indent+'setters = {};');
	// classes.push(indent+'getters = {};');
	for (var v in values) {
		// classes.push(types[v]);
		if (typeof values[v] !== 'undefined') {
			if (types[v].indexOf("MF") === 0 || types[v].indexOf("SFMatrix") === 0 || types[v].indexOf("SFVec") === 0 || types[v] === 'SFRotation') {
				classes.push(indent + v + ' : ['+ values[v] + '],');
			} else {
				classes.push(indent + v + ' : '+ values[v] + ',');
			}
		} else if (typeof package.setters[v] === 'undefined') {
			classes.push(indent+ v +  '_changed : function () { return this.' + v +  '; },');
		}
	}
}

function processSource(lines, classes, package) {
	if (typeof lines !== 'undefined') {
		var functions = lines.join("\n").split("function");
		var f;
		for (var f = 1; f < functions.length; f++) {  // skip ecmascript:
			var func = functions[f];
			var sp = func.indexOf('(');
			var name = func.substr(0, sp).trim();
			var funcvar = name;  //  a non setter function
			if (typeof package.setters[name] !== 'undefined') {
				funcvar = name; // a setter function
			}
			var body = func.substr(sp);
			for (var n in package.getters) {
				body = body.replace(new RegExp(n, 'g'), "this."+n);
				body = body.replace(/new (MF[A-Za-z0-9]+|SFMatrix[A-Za-z0-9]+|SFVec[234][df]|SFRotation)[ 	]*\(([^;]*)\)[ 	]*;/g, '[$2];');
				//body = body.replace(/&amp;/g, '&');
				//body = body.replace(/&lt;/g, '<');
				//body = body.replace(/&gt;/g, '>');
			}
			classes.push('\t'+funcvar + ' : function ' + body + ',');
		}
	}
}

if (typeof module === 'object')  {

	module.exports = {
		'processScripts' : processScripts
	};

}
