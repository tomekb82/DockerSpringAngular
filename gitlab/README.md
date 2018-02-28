docker pull gitlab/gitlab-ce

docker run -d -p 443:443 -p 8080:80 -p 2222:22 --name gitlab --restart always -v /opt/gitlab/config:/etc/gitlab -v /opt/gitlab/logs:/var/log/gitlab -v /opt/gitlab/data:/var/opt/gitlab gitlab/gitlab-ce





login to gitlab:
http://localhost:8080

create project

clone new repo:
git clone http://localhost:8080/tomekb82/angularApp.git
