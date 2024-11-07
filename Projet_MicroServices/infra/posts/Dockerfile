# Use the official MongoDB image as the base image
FROM mongo:latest

# Set the MongoDB root username and password (customize these values)
ENV MONGO_INITDB_ROOT_USERNAME=admin
ENV MONGO_INITDB_ROOT_PASSWORD=admin

# Optionally, you can specify a database name to be created on startup
ENV MONGO_INITDB_DATABASE=posts

# Expose the default MongoDB port (27017)
EXPOSE 27017