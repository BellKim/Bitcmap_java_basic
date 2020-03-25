var http = require('http');
var fs = require('fs');
var express = require('express');   // console 에서 >> npm install express

var app = express();
var server = http.createServer(app);

server.listen(8000, function(){

    console.log('웹 서버 가동중...');
});

app.get('/', function(req, res){
    console.log('/index 접속성공!');
    fs.readFile(__dirname + "/index.html", function(err,data){
        res.writeHead(200, {'content-Type':'text/html; charset=utf-8'});
        res.write(data);
        res.end();
    })
});

app.get('/main', function(req, res){
    console.log('/main 접속성공!');
    fs.readFile(__dirname + "/main.html", function(err,data){
        res.writeHead(200, {'content-Type':'text/html; charset=utf-8'});
        res.write(data);
        res.end();
    })
});