FROM node:18
RUN npm install -g nodemon

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 3000 
EXPOSE 27017

# Démarrez l'application
CMD ["npm" , "run" , "start"]
