# cassandra-api-rest
A sample REST API using Spring Data for Cassandra

## Endpoints

	GET    - /cassandra/users
	DELETE - /cassandra/users
	POST   - /cassandra/users > Accepts x-www-form-urlencoded, default user "John Due"

## Docker

### Build

	docker build -t cassandra .

### Run the container

	docker run -it -d --name cassandra -v data:/var/lib/cassandra -p 9042:9042 -p 9160:9160 cassandra:latest
