Build an image from the Dockerfile assign it a name.

$ docker build -t eg_postgresql .

Run the PostgreSQL server container (in the foreground):

$ docker run --rm -P --name pg_test eg_postgresql

There are 2 ways to connect to the PostgreSQL server. We can use Link Containers, or we can access it from our host (or the network).

1.

$ docker run --rm -t -i --link pg_test:pg eg_postgresql bash

postgres@7ef98b1b7243:/$ psql -h $PG_PORT_5432_TCP_ADDR -p $PG_PORT_5432_TCP_PORT -d docker -U docker --password

2.

psql -h localhost -p 49153 -d docker -U docker --password


CREATE TABLE customer(
    id BIGINT PRIMARY KEY NOT NULL,
        firstname VARCHAR(100),
	    lastname VARCHAR(100)
	    );
