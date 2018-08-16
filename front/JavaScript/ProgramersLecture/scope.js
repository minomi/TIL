function outer() {
    var outerValue = "outer"
    function inner() {
        var innerValue = "inner";
        console.log("innerFunction scope", typeof(s), typeof(outerValue), typeof(innerValue));
    }
    inner();
    console.log("outerFunction scope", typeof(s), typeof(outerValue), typeof(innerValue));
}

var s = "static";
outer();
console.log("static scope", typeof(s), typeof(outerValue), typeof(innerValue));

