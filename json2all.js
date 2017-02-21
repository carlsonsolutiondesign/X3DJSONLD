"use strict";

// Convert X3D JSON to JAVA

process.argv.shift();
process.argv.shift();

var convertJSON = require('./convertJSON.js');

convertJSON('./PythonSerializer.js', ".py");
convertJSON('./DOMSerializer.js', ".x3d");
convertJSON('./JavaSerializer.js', ".java");