# Training Metrics Services

## Getting Started

### Prerequisites

- Java 11 
- Maven 
- Docker 
- Docker Compose 

### Build

1. Clone the repo

```sh
git clone https://github.com/luisramilian95/luis-ramirez-training-metrics-service.git
```

- **Run with make**

1. Go to the project 

```sh
cd luis-ramirez-training-metrics-service
```

2. Configure the values of `config.env`
3. In case you don't have a postgres database run the command

```sh
make build_db
```

4. Run the command `make` to start.

```sh
make
```

- **Run docker-compose**


1. Go to the project

```sh
cd luis-ramirez-training-metrics-service
```

2. Package the project with the docker profile 

```sh
./mvnw clean package -Pdocker
```

3. Run with docker-compose

```sh
docker-compose up --build 
```


## Usage

### Services 

- **Swagger** [Test](http://localhost:8080/metrics/swagger-test.html)

- **Person Resolution Metrics** 

| Path                                                                | Method | Description                             |
|---------------------------------------------------------------------|--------|-----------------------------------------|
| http://localhost:8080/metrics/person-resolution-metrics/{id}        | GET    | Get PersonResolutionMetric by id        |
| http://localhost:8080/metrics/person-resolution-metrics?start=&end= | GET    | Get PersonResolutionMetric by timestamp |
| http://localhost:8080/metrics/person-resolution-metrics             | POST   | Save a PersonResolutionMetric           |


```json
{
  "id": 0,
  "timestamp": "2022-07-28T16:02:40.205Z",
  "individualMatches": 0,
  "householdMatches": 0,
  "nonMatches": 0,
  "errors": 0,
  "endpoint": "string"
}
```

- **Batch Loader Metrics**

| Path                                                           | Method | Description                  |
|----------------------------------------------------------------|--------|------------------------------|
| http://localhost:8080/metrics/batch-loader-metrics/{id}        | GET    | Get BatchLoader by id        |
| http://localhost:8080/metrics/batch-loader-metrics?start=&end= | GET    | Get BatchLoader by timestamp |
| http://localhost:8080/metrics/batch-loader-metrics             | POST   | Save a BatchLoader           |

```json
{
  "id": 0,
  "timestamp": "2022-07-28T16:08:24.852Z",
  "fileName": "string",
  "created": "2022-07-28T16:08:24.852Z",
  "pickedUp": "2022-07-28T16:08:24.852Z",
  "processed": "2022-07-28T16:08:24.852Z",
  "records": 0
}
```

> **_NOTE:_**  All dates are in ISO date time format
