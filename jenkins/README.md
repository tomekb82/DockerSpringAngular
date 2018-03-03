

docker pull jenkins

docker run -dp 18080:8080 --name jenkins -v C:/jenkins:/var/jenkins_home -t jenkins

http://localhost:18080
user:admin
passwd: in file '/c/jenkins/secrets/initialAdminPassword'

Intall plugins:
-GitLab
-Maven integration plugin


Save conatiner state:
docker commit <container_id> gitlab_with_user_and_fe_proj


GITLAB:
---------
- integrations:
http://10.0.75.1:18080/project/angularApp

