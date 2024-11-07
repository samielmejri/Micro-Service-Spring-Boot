# MS-LEARNING

Project Setup and Deployment Guide
This guide will walk you through the steps to clone, build, and deploy the project using Docker Compose. Please follow the instructions below to get the project up and running.

Prerequisites
Before you begin, ensure you have the following software installed on your system:

Git
Maven
Docker
Docker Compose
Angular 

## Step 1: Clone the Project
Clone the repository to your local machine using Git:

in cmd terminal
Copy code
git clone https://github.com/abdou6666/ms-learning
cd your-project


## Step 2: Build the Project
Use Maven to build the project and Run the following command to download the frontend project dependencies. Make sure you are in the project root directory:

Maven
in cmd terminal 

mvn clean install

Nodejs
in cmd terminal 

cd events &&
npm i

cd elearning-app &&
npm i
## Step 3: Build Docker Images
Build Docker images for each project in the repository. Navigate to each project's directory and build the Docker image:

in cmd terminal
copy code
docker compose build 


## Step 4: Docker Compose
Navigate back to the root directory of the project and use Docker Compose to start the services. The provided docker-compose.yml file defines the services and their configurations:

in cmd terminal
copy code
docker-compose up 

This command will start all the services defined in the docker-compose.yml file in detached mode.


## Step 5: Testing
Once the services are up and running, you can test your application. Depending on your project and its services, open a web browser or use tools like Postman to interact with the application.

Access the services as needed using the appropriate URL, http://localhost:8081 because the api-gateway is configured in this port  . 

Run the following command to launch the frontend project: npm start

## Step 6: Stopping and Cleanup
To stop and remove the services, run the following Docker Compose command:

in cmd terminal
copy code
docker-compose down

This will stop and remove all containers defined in the docker-compose.yml file.

That's it! You've successfully cloned, built, and deployed the project using Docker Compose. Enjoy using the application!
