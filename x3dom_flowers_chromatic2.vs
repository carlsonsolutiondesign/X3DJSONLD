#ifdef GL_ES
  precision highp float;
#endif

attribute vec3 position;
attribute vec3 normal;
attribute vec2 texcoord;

uniform mat4 modelViewProjectionMatrix;
uniform mat4 modelViewMatrix;

uniform vec3 chromaticDispertion;
uniform float bias;
uniform float scale;
uniform float power;
uniform float a;
uniform float b;
uniform float c;
uniform float d;
uniform float tdelta;
uniform float pdelta;

varying vec3 t;
varying vec3 tr;
varying vec3 tg;
varying vec3 tb;
varying float rfac;

vec3 cart2sphere(vec3 p) {
     float r = pow(p.x*p.x + p.y*p.y + p.z*p.z, 0.5);
     float theta = acos(p.z/r);
     float phi = atan(p.y, p.x);
     return vec3(r, theta, phi);
}
     
vec3 rose(vec3 p) {
     float rho = a + b * cos(c * p.y + tdelta) * cos(d * p.z + pdelta);
     float x = rho * cos(p.z) * cos(p.y);
     float y = rho * cos(p.z) * sin(p.y);
     float z = rho * sin(p.z);
     return vec3(x, y, z);
}

vec3 rose_normal(vec3 p) {
     /* convert cartesian position to spherical coordinates */
     vec3 base = cart2sphere(p);
     /* add a little to phi */
     vec3 td = base + vec3(0.0, 0.0001, 0.0);
     /* add a little to theta */
     vec3 pd = base + vec3(0.0, 0.0, 0.0001);

     /* convert back to cartesian coordinates */
     vec3 br = rose(base);
     vec3 bt = rose(td);
     vec3 bp = rose(pd);

     return normalize(cross(bt - br, bp - br));
}

vec4 rose_position(vec3 p) {
	return vec4(rose(cart2sphere(p)), 1.0);
	/*return vec4(position, 1.0);*/
}

void main()
{
    mat4 jwc_ModelViewMatrix = modelViewMatrix;
    mat4 jwc_ModelViewProjectionMatrix = modelViewProjectionMatrix;
    mat3 mvm3=mat3(
	jwc_ModelViewMatrix[0].x,
	jwc_ModelViewMatrix[0].y,
	jwc_ModelViewMatrix[0].z,
	jwc_ModelViewMatrix[1].x,
	jwc_ModelViewMatrix[1].y,
	jwc_ModelViewMatrix[1].z,
	jwc_ModelViewMatrix[2].x,
	jwc_ModelViewMatrix[2].y,
	jwc_ModelViewMatrix[2].z
    );
    gl_Position = jwc_ModelViewProjectionMatrix * rose_position(position);

    vec3 fragNormal = mvm3*rose_normal(position);
    vec3 incident = normalize((jwc_ModelViewMatrix * rose_position(position)).xyz);
    t = reflect(incident, fragNormal)*mvm3;
    tr = refract(incident, fragNormal, chromaticDispertion.x)*mvm3;
    tg = refract(incident, fragNormal, chromaticDispertion.y)*mvm3;
    tb = refract(incident, fragNormal, chromaticDispertion.z)*mvm3;
    rfac = bias + scale * pow(0.5+0.5*dot(incident, fragNormal), power);
}
