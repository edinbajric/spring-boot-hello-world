# spring-boot-hello-world

# docker commands used to dockerize the application: 
- docker pull mysql
- docker run -d -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test mysql 
- docker build -t app .
- docker network create spring-net 
- docker network connect spring-net mysqldb
- docker run -p 9090:8080 --name app --net spring-net -e "SPRING_PROFILES_ACTIVE=database" -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 -e MYSQ
  L_DATABASE=test app
- docker run -p 9091:8080 --name app1 --net spring-net -e "SPRING_PROFILES_ACTIVE=external" -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 -e MYS
  QL_DATABASE=test app
