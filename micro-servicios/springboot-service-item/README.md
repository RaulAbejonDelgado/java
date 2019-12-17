Docker commands to run on terminal

#Helper
docker build -> generates the image

-t -> tag of the image

:n -> to create image versions

 . -> required at end of command to start the process

    docker build -t service-item:v1 .

#List docker images
    docker images

#Creation of docker network
    docker network create springcloud

#up docker
-p -> external port: internal-port

external port -> Set the port that service will take on system network

internal port -> Set the port that the service will take on docker network

--name -> Set docker container name

--network -> the name of the network what you want to integrate the docker image

the last parameter is the name of the docker image with the tag (this infomation can check from docker images)

    docker run -p 8002:8002 -p 8005:8005 -p 8007:8007 --name service-item --network springcloud service-item:v1

#List docker containers

    docker container ls

#Summary of the docker executions and states(started/stoped)

    docker ps -a


#Delete docker containers

    docker rm idOfDockerContainer

#Docker container help

    docker container --help

#Print docker container logs

    docker logs -f service-item
