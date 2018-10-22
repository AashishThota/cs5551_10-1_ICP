var express=require("express");
var app=express();
var MongoClient=require('mongodb').MongoClient;
var cors = require('cors');
var bodyParser = require("body-parser");
var pass="Sairam4@"
var url="mongodb://users:sairam4@ds135993.mlab.com:35993/practice";
app.use(express.static(__dirname+'/Home'));
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.post("/register",function (req ,res) {
    MongoClient.connect(url, function(err, client) {
        console.log("hi");
        if(err)
        {
            console.log(err);
            res.write("Failed, Error while connecting to Database");
            res.end();
        }
        var db= client.db("practice");
        insertDocument(db, req.body, function() {
            res.write("Successfully inserted");
            res.end();
        });
    });
}
);
var insertDocument= function(db, data, callback){
db.collection('users').insertOne(data,function(err, result){
    if(err)
        {
            res.write("Registration Failed, Error While Registering");
            res.end();
        }
        
})
}
app.get("/list", function(req,res){
   MongoClient.connect(url,function(err,client){
       if(err){
           console.log(err);
        
       }
       else{
           var db=client.db("practice");
           db.collection('users').find().toArray(function(err,result){
               if(err){
                   console.log(err);
                    res.send(err);
               }
               console.log(result);
               res.send(result);
           });
           
       }
   }) 
})
app.post("/search",function(req,res){
   // console.log(req.body);
    MongoClient.connect(url,function(err,client){
        if(err){
            console.log("hello error");
            console.log(err);
         
        }
        else{
            var db=client.db("practice");
           var searchString = {};
        searchString['major'] ={ $eq:  req.body.searchTerm } ;
console.log(req.body.searchTerm);
        db.collection('users').find(searchString).toArray(function (err, result) {
            if (err) {
                console.log(err);
                res.write("fetching  students failed");
                res.end();
            } else {
console.log("hi");
                res.send(JSON.stringify(result));
            }
        });
        }
    }) 
});
app.listen(3000);