
INSTALL:
---------

npm install -g @angular/cli

ng new my-app

cd my-app 

ng serve --open


DOCKER:
--------

(docker images)



(docker container ls)

docker stop angular-app

docker build -t angular-app:dev .

docker run -d --name angular-app -p 4200:4200 angular-app:dev

link: https://scotch.io/tutorials/create-a-mean-app-with-angular-2-and-docker-compose#toc-dockerize-the-express-server-api
