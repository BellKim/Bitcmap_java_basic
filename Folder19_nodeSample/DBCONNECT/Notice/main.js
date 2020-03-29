var http=require("http");
var fs = require('fs');
var express=require('express');
var oracledb = require('oracledb');
var ejs = require('ejs');
var app = express();
oracledb.autoCommit = true;

var server = http.createServer(app);

var dbconn;
// Parameter 
var bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended:true}));

//db connection
oracledb.getConnection({
    user:'hr',
    password:'hr',
    host:'localhost',
    database:'xe'

}, function(err, conn){
    if(err) console.log('접속실패 : ' + err);

    console.log('db접속성공 ');
    dbconn = conn;

});

app.get('/', function(req, res){
    fs.readFile(__dirname+"/write.html", function(err, data){
        console.log('write.html  접속성공');
        res.writeHead(200, {'content-Type':'text/html; charset=utf-8'});
        res.write(data);
        res.end();
    });
});

app.post('/regist', function(req, res){
    console.log('/regist 접속 성공');

    //parameter -> data 수집 
    var writer = req.body.writer;   // ge tparameter    //파라미터를 받아올 수 있다. 
    var title= req.body.title;
    var content = req.body.content;     //req.params.writer;     //=> get 방식이다. 

    console.log('writer : '+ writer);
    console.log('title : '+ title);
    console.log('content : '+ content);

    dbconn.execute("insert into notice(writer, title, content) "+
                    "values('" +writer+ "' , '" +title+  "', '" +content+ "')"
                    , function(err, result){
                        if(err){
                            console.log(" error is exist "+err);
                        }else{
                            console.log("등록 성공 ");
                            //list 이동 
                            res.redirect("list");       //sendRedirect
                        }
                    });

});

app.get('/list', function(req, res){
    console.log("/list 접속 성공 ");
    //db에서 데이터를  뽑아간다.
    dbconn.execute("select * from notice",{} ,{outFormat:oracledb.OBJECT} , function(err, result){
        if(err){
            console.log('조회 중 에러 발생 ' + err);
        }
        console.log(result);
        console.log('result.rows:' + result.rows);

        //String 변경
        var json = JSON.stringify(result.rows);

        //json변경
        var arr=JSON.parse(json);
        console.log(arr);

        fs.readFile(__dirname + "/list.ejs", "utf-8", function(err, res){
            if(err){
                console.log('조회 중 에러 발생 ' + err);
            }

            res.writeHead(200, {'content-Type':'text/html; charset=utf-8'});
            
            res.end(ejs.render(data, {arrlist:arr}));

        });
        
    });

    
});


server.listen(8000, function(){
    console.log('웹 서버 동작중......');
});


