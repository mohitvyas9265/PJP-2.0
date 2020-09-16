let U = require("./calculator.js");
var express = require('express');
var app = express();

app.set('view engine','ejs')
app.use(express.static(__dirname+ '/public'))
var bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));

app.get('/', function (req, res) {
    res.render("home",{
    	output:'',
    	date:'',
    	function:''
    });
});

app.post('/', function (req, res) {
    var str = U.processDate(req.body.Date,req.body.Function);
    console.log(str);
    res.render("home", {
    	output:str,
    	date:req.body.Date,
    	f: req.body.Function
    });
});

var server = app.listen(5000, function () {
    console.log('Node server is running..');
});