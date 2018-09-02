function makeCounterFunction(initValue) {
    var count = initValue;

    function increase() {
        count++;
        console.log(count);
    }
    return increase;
}


var counter1 = makeCounterFunction(0);
var counter2 = makeCounterFunction(10);


counter1(); // 1
counter2(); // 11

counter1(); // 2
counter2(); // 12

counter1(); // 3
counter1(); // 4


