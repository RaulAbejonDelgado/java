Docker commands to run on terminal

#Helper
docker build -> generates the image

-t -> tag of the image

:n -> to create image versions

 . -> required at end of command to start the process

    docker build -t service-products:v1 .

#List docker images
    docker images

#Creation of docker network
    docker network create springcloud

#up docker
-P -> this because the port is random

--name -> Set docker container name(OPTIONAL)

--network -> the name of the network what you want to integrate the docker image

the last parameter is the name of the docker image with the tag (this infomation can check from docker images)

    docker run -P --name service-products --network springcloud service-products:v1

#List docker containers

    docker container ls

#Summary of the docker executions and states(started/stoped)

    docker ps -a


#Delete docker containers

    docker rm idOfDockerContainer

#Docker container help

    docker container --help

#Print docker container logs

    docker logs -f config-server
