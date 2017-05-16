#!/bin/sh


# Run the Test Suite

# accepts files with .x3d extension
export PROCESSORS=${PROCESSORS-8}

. ./classpath

javac RunSaxon.java
python classes.py

(ls "$@" | grep -v intermediate | grep -v "\.new") | xargs -P $PROCESSORS java RunSaxon ---overwrite | xargs -P $PROCESSORS ${NODE} json2all.js

for i in `(ls "$@" | grep -v intermediate | grep -v "\.new") | sed 's/\.x3d$/.x3d.new/'| sed 's/\/c\/x3d-code\/www.web3d.org/www_web3d_org/'`
do
	${NODE} xmldiff.js `dirname $i  | sed 's/.\/www_web3d_org/\/c\/x3d-code\/www.web3d.org/'`/`basename $i .x3d.new`.x3d $i
done

(ls "$@" | grep -v intermediate | grep -v "\.new") | sed 's/\.x3d$/.java/' | sed 's/\/c\/x3d-code\/www.web3d.org/www_web3d_org/' | xargs ls -d | xargs -L 1 -P $PROCESSORS javac -J-Xss1g -J-Xmx4g
(ls "$@" | grep -v intermediate | grep -v "\.new") | sed 's/\.x3d$/.class/' | sed 's/\/c\/x3d-code\/www.web3d.org/www_web3d_org/' | xargs ls -d | sed 's/\.class$//' | sed 's/^\.*\///' | xargs -L 1 -P $PROCESSORS java -d64 -Xss1g -Xmx4g

for NEW in `(ls "$@" | grep -v intermediate | grep -v "\.new") | sed 's/\.x3d$/.new.json/'| sed 's/\/c\/x3d-code\/www.web3d.org/www_web3d_org/'`
do
	JSON=`dirname $NEW | sed 's/www_web3d_org/\/c\/x3d-code\/www.web3d.org/' `/`basename $NEW .new.json`.json
	if [ -e $NEW ]
	then if [ -n "`${NODE} jsondiff.js $JSON $NEW`" ]
		then
			${NODE} jsondiff.js $JSON $NEW
		fi
	fi
done

for i in `(ls "$@") | sed 's/\.x3d$/.new.json.intermediate.x3d/'| sed 's/\/c\/x3d-code\/www.web3d.org/www_web3d_org/'`
do
	${NODE} xmldiff.js `dirname $i  | sed 's/.\/www_web3d_org/\/c\/x3d-code\/www.web3d.org/'`/`basename $i .new.json.intermediate.x3d`.x3d $i
done

(ls "$@" | grep -v intermediate | grep -v "\.new") | sed "s/\.x3d$/.sail.js/" | sed 's/\/c\/x3d-code\/www.web3d.org/www_web3d_org/' | xargs -L 1 -P $PROCESSORS jjs -J-Xss1g -J-Xmx4g -cp "${NASHORN_CLASSPATH}"

for i in `(ls "$@" | grep -v intermediate | grep -v "\.new") | sed 's/\.x3d$/.new.x3d/'| sed 's/\/c\/x3d-code\/www.web3d.org/www_web3d_org/'`
do
	X3D=`dirname $i | sed 's/www_web3d_org/\/c\/x3d-code\/www.web3d.org/' `/`basename $i .new.x3d`.X3d
	if [ -e $i ]
	then
		if [ -n "`${NODE} xmldiff.js $X3D $i`" ]
		then
			${NODE} xmldiff.js $X3D $i
		fi
	fi
done