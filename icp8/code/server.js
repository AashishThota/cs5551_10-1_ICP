var express= require('express');
var app= express();
const Clarifai = require('clarifai');
const app1 = new Clarifai.App({
    apiKey: 'af3856e9bee94231b8b97914c3fa5c10'
   });
   app.get("/getDetails", (req, res, next) => {
    app1.models.predict("eeed0b6733a644cea07cf4c60f87ebb7",req.query.url).then(
        function (response) {
            console.log("hi");
            //console.log("hi");
           // console.log(response);
            var x="";
          // var result=response.data.rawData;
            //for(var results in result){
              //  x=x+results.w3c.name+":"+results.w3c.hex+"\t"+results.valueOf;
            //}
            res.send(response);
        },
        function (err) {
            console.log("error occured");
            // there was an error
            console.log(err);
        }
    );
});
app.use(express.static(__dirname+'/home'));

app.listen(3000);