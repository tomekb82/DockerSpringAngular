"# DockerSpringAngular" 


Security:
----------

- default username:  'user'


DOCKER:
--------------------
./mvnw install dockerfile:build

docker build -t spring-app:dev .

docker run -d --name spring-app -p 8080:8080 spring-app:dev
