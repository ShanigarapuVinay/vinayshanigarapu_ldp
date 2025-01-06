// Write a program to demonstrate how a function can be passed as a parameter to another function.
function greet(name){
    return `Hello ${name}!!`;
}
function printGreeting(greetFun, name){
    console.log(greetFun(name));
}
printGreeting(greet,"Vinay Shanigarapu");