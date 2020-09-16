const express = require("express");
const bodyParser = require("body-parser");
let script = require("./script.js");
const app = express();
app.use(bodyParser.urlencoded({
    extended: true
}));
app.get("/", function (req, res) {
    res.sendFile(__dirname + "/index.html");
});
app.post("/", function (req, res)
{
    var operator = script.displayRadioValue(); 
    var date = script.calculate(req.body.date1, req.body.date2, operator);
    res.render('index', { calculate: date });

});
app.listen(3000, function () {
    console.log("Server is running on port 3000")
}
);