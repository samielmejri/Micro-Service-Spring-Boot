const express = require('express');
const app = express();
const db = require('./db');
const api = require('./routes/Event');
const schedule = require('node-schedule');
const { Eureka } = require('eureka-js-client');
const cors = require('cors');

const corsOptions = {
  origin: 'http://localhost:4200', 
  methods: 'GET,HEAD,PUT,PATCH,POST,DELETE',
  credentials: true,
  optionsSuccessStatus: 204,
};

app.use(cors(corsOptions));

app.use(express.json());
app.use('/api/events', api);

const client = new Eureka({
    instance: {
      app: 'events', 
      hostName: 'events', 
      ipAddr: '192.168.144.8', 
      port: {
        '$': 3000, 
        '@enabled': true,
      },
      vipAddress: 'events', 
      dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn',
      }
    },
    eureka: {
      host: 'discovery', // Changed to match the service name defined in docker-compose
      port: 8761, 
      servicePath: '/eureka/apps/',
      maxRetries: 10,
      requestRetryDelay: 2000,
    }
});
/*const appName = 'events';
const PORT = 3000; // Replace with the desired port
const hostName = 'events'; // Replace with the correct host
const ipAddr = '192.168.144.9'; // Replace with the correct IP
const eurekaHost = 'discovery'; // This should match the name of your Eureka server container in Docker Compose
const eurekaPort = 8761; // This should match the Eureka server port

const client = new Eureka({
  instance: {
    app: appName,
    hostName: hostName,
    ipAddr: ipAddr,
    port: {
      '$': PORT,
      '@enabled': 'true',
    },
    vipAddress: appName,
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
  // Retry configuration...
  eureka: {
    host: eurekaHost,
    port: eurekaPort,
    servicePath: '/eureka/apps/',
    maxRetries: 10,
    requestRetryDelay: 2000,
  },
});*/


client.start((error) => {
  if (!error) {
    console.log('Eureka client started');
  } else {
    console.error('Eureka client could not be started', error);
  }
});

const dailyEvent = schedule.scheduleJob('0 12 * * *', async function(){
  const newEvent = new Event({ title: 'Événement Quotidien', date: Date.now() });
  await newEvent.save();
});

app.listen(3000, () => console.log('Serveur en écoute sur le port 3000'));
