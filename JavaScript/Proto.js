function person(name,age){
    this.name=name
    this.age=age
}

let p1=new person("harish",25);

console.log(p1)

console.log(p1.prototype)

let p2={
    name:"kumar",
    age:34
}

console.log(p2)

