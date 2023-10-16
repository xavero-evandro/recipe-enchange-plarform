# Recipe Exchange Platform

A platform built using Kotlin, Spring Boot, and other modern technologies, where users can share and exchange recipes.

## Prerequisites

- JDK 17
- Docker (for containerization)
- Gradle

## Getting Started

### Running the application locally:

1. Clone the repository:
```bash
   git clone https://github.com/your-username/recipe-enchange-platform.git
```

2. Navigate to the project directory:
```bash
   cd recipe-exchange-platform
```
3. Build the project with Gradle:
```bash
   gradle clean build
```
4. Run the application:
```bash
   java -jar build/libs/recipe-enchange-platform-0.0.1-SNAPSHOT.jar
```
The api should now be running on http://localhost:3000.

### Running the application with Docker:
1. Build the Docker image:
```bash
   docker build -t recipe-exchange-platform .
```
2. Run the Docker image:
```bash
   docker run -p 3000:3000 recipe-exchange-platform
```

### Tests
To run the tests, run the following command:
```bash
   gradle test
```

### Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

### License
[MIT](https://choosealicense.com/licenses/mit/)