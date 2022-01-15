const { MongoClient } = require("mongodb");

const uri =
  "mongodb+srv://liorc955:Aa123456@cluster0.xyuz3.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

  const client = new MongoClient(uri);

  module.exports = client;

