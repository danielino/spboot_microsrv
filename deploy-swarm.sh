#!/bin/bash

STACK_NAME=${1:-spboot}
REDIRECT='2>&1 > /dev/null'

echo "deploying stack $STACK_NAME"


function build_test_image(){
    cd test
    docker build -t test:latest . 
    cd ..
}

function deploy_stack(){
    echo "remove previous stack"
    docker stack rm $STACK_NAME 
    sleep 10
    echo "deploy docker stack"
    docker stack deploy --compose-file=swarm-compose.yml $STACK_NAME 
}

build_test_image
deploy_stack
