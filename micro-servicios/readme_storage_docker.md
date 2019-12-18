#Image creation 
#Download mySql docker image

go to -> hub.docker.com

search -> mysql

check the mysql version and check docker command

	docker pull mysql:5.7
	
check if you have mysql service down or change the mysql docker image port

	service mysql stop

#up docker
-p -> external port: internal-port

external port -> Set the port that service will take on system network

internal port -> Set the port that the service will take on docker network

--name -> Set docker container name

--network -> the name of the network what you want to integrate the docker image

-e -> enviroment variables 

the last parameter is the name of the docker image with the tag (this infomation can check from docker images)

    docker run -p 3306:3306 --name microservicios-mysql57 --network springcloud -e MYSQL_USER=root -e MYSQL_ROOT_PASSWORD=adminadmin -e MYSQL_DATABASE=db_springboot_cloud -d mysql:5.7
    
    
#Download postgresql docker image

go to -> hub.docker.com

search -> postgresql

check the mysql version and check docker command

	docker pull postgres:9.5-alpine
	
check if you have mysql service down or change the mysql docker image port

	service postgresql stop

#up docker
-p -> external port: internal-port

external port -> Set the port that service will take on system network

internal port -> Set the port that the service will take on docker network

--name -> Set docker container name

--network -> the name of the network what you want to integrate the docker image

-e -> enviroment variables 

the last parameter is the name of the docker image with the tag (this infomation can check from docker images)

    docker run -p 5432:5432 --name microservicios-postgres95 --network springcloud -e POSTGRES_USER=rul -e POSTGRES_PASSWORD=hiphop35 -e POSTGRES_DB=db_springboot_cloud -d postgres:9.5-alpine


#RAbbitMQ

	docker pull rabbitmq:3.8-management-alpine
	
	docker run -p 15672:15672 -p 5672:5672 --name microservice-rabbitmq38 --network springcloud -d rabbitmq:3.8-management-alpine
