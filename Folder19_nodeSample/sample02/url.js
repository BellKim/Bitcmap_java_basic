console.log("hello");
//url, parameter 

var url = require('url');   //import java.lang.util.ArrayList;
var addr='http://localhost:8090/default.html?year=2020&month=3';

var q = url.parse(addr, true);

console.log(q.host);
console.log(q.pathname);
console.log(q.search);

var qdata = q.query;
console.log(qdata);
console.log(qdata.year);







