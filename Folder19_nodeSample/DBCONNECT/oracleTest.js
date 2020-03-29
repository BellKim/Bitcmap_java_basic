/*

MySql, MongoDB, -> node.js

*/

var oracleDB = require('oracledb');

var config = {
    connectString:"localhost/xe",       //ip 입력
    user:"hr",
    password:"hr"
}

oracleDB.getConnection(config,(err, conn) => {
    if(err){
        console.log('접속에 실패했습니다.', err);
        return;
    } else {
        console.log("접속 성공!");
        
    }



});