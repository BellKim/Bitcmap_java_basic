

//variable
var item = 'apple';
exports.item=item;

//function
var getName = function(){
    console.log(item + " 입니다. ");
}
exports.getName=getName;

//object
var obj = {
    name:'banana',
    price:2500,
    store:'myMarket'
}
exports.obj=obj;



