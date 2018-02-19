"# DockerSpringAngular" 


Security:
----------

- default username:  'user'


DOCKER:
--------------------

 mvn install -Dmaven.test.skip=true dockerfile:build

docker run -p 8080:8080 -t springio/demo 

