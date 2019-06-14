Implemented a data structure for Least Recently Used (LRU) cache service. 

Software requirement:
1)JDK 1.8

2)Spring Boot 2.1.5

Our application supported the following operations: get and put service exposed by REST API.

Steps to follow:
Step 1) Import the Spring boot project to Eclipse IDE

Step 2) Run "LRUCacheServiceApplication.java" which is located at "LRUCacheService/src/main/java/com/lru/application/".

Step3 ) Perform following operations sequentially to get the expected output in Postman or through console.

curl XPUT http://cache.service/api/v1/put/1 -d "value=400"
200
{
}

curl XPUT http://localhost:8080/api/v1/put/2 -d "value=800"
200
{
}

curl XGET http://localhost:8080/api/v1/get/1
200
{
  key: 1,
  value: 400
}

curl XPUT http://localhost:8080/api/v1/put/3 -d "value=1200"  //evicts key=2
200
{
  key: 2,
  value: 800
}

curl XGET http://localhost:8080/api/v1/get/2
404

curl XPUT http://localhost:8080/api/v1/put/4 -d "value=1600"  //evicts key=1
200
{
  key: 1,
  value: 400
}

curl XGET http://localhost:8080/api/v1/get/1
404

curl XGET http://localhost:8080/api/v1/get/3
200
{
  key: 3,
  value: 1200
}

curl XGET http://localhost:8080/api/v1/get/4
200
{
  key: 4,
  value: 1600
}

Note: Deafult port of tomcat is 8080

Additional Information:


