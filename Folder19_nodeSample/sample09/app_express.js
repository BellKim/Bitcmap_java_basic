var http = require('http');
var fs = require('fs');
var express = require('express');
 var app = express();

 var server = http.createServer(app);

 var server = http.createServer(app);

//view를 설정한다.
 app.set('views', __dirname+ '/views');

//css
var myCss = {
    style:fs.readFileSync(__dirname+'/css/style.cs', 'utf-8')
}

app.get('/', function(req, res){        //npm install ejs
    res.render('index.ejs',
    {
        title:'제목입니다.',
        mycss:myCss
    }
    );
});

server.listen(8000, function(){
    console.log('웹 서버 동작중.... ');

});









