const mongoose = require('mongoose');

mongoose
  .connect("mongodb://mongo_db:27017/elearning", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => {
    console.log("DB Connected");
  })
  .catch((err) => console.log(err));

module.exports = mongoose;
