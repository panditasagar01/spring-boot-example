#!/bin/bash

set -e

REMOTE_USERNAME="..."
REMOTE_HOST="..."
IMAGE_REPOSITORY="boot_demo"

function upload_image_if_needed {
	if [[ $(ssh $REMOTE_USERNAME@$REMOTE_HOST "docker images $IMAGE_REPOSITORY | grep $1 | tr -s ' ' | cut -d ' ' -f 3") != $(docker images $IMAGE_REPOSITORY | grep $1 | tr -s ' ' | cut -d ' ' -f 3) ]]
	then
		echo "$1 image changed, updating..."
		docker save $IMAGE_REPOSITORY:$1 | bzip2 | pv | ssh $REMOTE_USERNAME@$REMOTE_HOST 'bunzip2 | docker load'
	else
		echo "$1 image did not change"
	fi
}

function build_image {
	docker build -t $IMAGE_REPOSITORY:$1 $2
}

build_image bootimg

#upload_image_if_needed bootimg

#ssh -tt $REMOTE_USERNAME@$REMOTE_HOST << EOF
#docker rm -f ${IMAGE_REPOSITORY}_bootimg || true

docker run -d --name ${IMAGE_REPOSITORY}_bootimg $IMAGE_REPOSITORY:bootimg
echo $IMAGE_REPOSITORY:bootimg
exit
EOF