var http=require('http');

var fs = require('fs');

http.createServer(function(req, res){
    //file read <- html파일을 읽는다.
    fs.readFile(__dirname + '/demo.html', function(err, data){
        if(err) console.log(err);
        console.log('readFile success');
        if(req.method == 'GET'){
            res.writeHead(200, {'content-Type':'text/html; charset=utf-8'});
            res.write(data);
            res.end();
        }
    });
}).listen(8000);