

docker pull jenkins

docker run -dp 18080:8080 --name jenkins -v $PWD/jenkins:/var/jenkins_home -t jenkins

http://localhost:18080


Intall plugins:
-GitLab
-Maven integration plugin
