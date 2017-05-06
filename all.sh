#!/bin/bash

. ./classpath

# Run examples through test process

export PROCESSORS=1
# ls ./*.x3d | xargs -P 8 ./several.sh
find /c/x3d-code/www.web3d.org/x3d/content/examples/ -name '*.x3d' | xargs -P $PROCESSORS ./several.sh

