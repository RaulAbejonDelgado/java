##Zipkin-server

## create image
	
	docker build -t zipkin-server:v1 .
	
## up image

	docker run -p 9411:9411 --name zipkin-server --network springcloud -e RABBIT_ADDRESSES=microservice-rabbitmq38:5672 -e STORAGE_TYPE=mysql -e MYSQL_USER=zipkin -e MYSQL_PASS=zipkin -e MYSQL_HOST=microservicios-mysql57 zipkin-server:v1
