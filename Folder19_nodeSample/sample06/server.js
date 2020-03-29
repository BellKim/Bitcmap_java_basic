

var http=require('http');

// Web Server Create
var server = http.createServer();

//port number => binding
var port = 8000;
server.listen(port, function(){
    //서버가 동작되었을때 실행될 구문.
   console.log("SErver Start : %d", port); 
} );

server.on('connection', function(socket){
    var addr = socket.address();
    console.log('client Connect : %s %d', addr.address, addr.port);
});

server.on('request', function(req, res){
    console.log('client 요청이 들어왔습니다.');
    res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
    res.write("<!DOCTYPE html>");
    res.write("<html>");
    res.write("<head>");
    res.write("<title>응답페이지 입니다. </title>");
    res.write("</head>");
    res.write("<body>");
    res.write("<h1>Server로부터 응답 </h1>");
    res.write("1");
    res.write("2");
    res.write("3");
    res.write("4");
    res.write("</body>");
    res.write("</html>");
    
    res.end();
    
    
});



