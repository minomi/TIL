function setName(name) {
    console.log(this);
    this.name = name;
}

let obj1 = {setName: setName};
let obj2 = {setName: setName};

setName("Window");
obj1.setName("Object 1");
obj2.setName("Object 2");

console.log(obj1, obj2);