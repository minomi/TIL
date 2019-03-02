const coffees = [
    '에스프레소',
    '아메리카노',
    '카페라떼',
    '카푸치노',
];

const coffeeIter = coffees.values();

console.log(coffeeIter.next());
console.log(coffeeIter.next());
console.log(coffeeIter.next());
console.log(coffeeIter.next());
console.log(coffeeIter.next());

class Log {
    constructor() {
        this.messaages = [];
    }

    add(message) {
        this.messaages.push({message : message, time : Date.now()});
    }

    [Symbol.iterator]() {
        return this.messaages.values();
    }
}

function sleep (time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}

const iteratorLogs = async function () {
    const logs = new Log();
    logs.add('로그 1');
    sleep(500).then(() => logs.add('로그 2'));
    sleep(1000).then(() => logs.add('로그 3'));
    sleep(1500).then(() => logs.add('로그 4'));
    sleep(2000).then(() => logs.add('로그 5'));
    sleep(2500).then(() => {
        for (const log of logs) {
            console.log(log);
        }
    });
};

class FiboSeq {
    [Symbol.iterator]() {
        let a = 0, b = 1;
        return {
            next() {
                const rval = {value: b, done: false};
                b += a;
                a = rval.value;
                return rval;
            }
        }
    }
}

const fibo = new FiboSeq();
for (const val of fibo) {
    if (val > 100) {
        break;
    }
    console.log(val);
}

function *gen() {
    yield 1;
    yield 2;
    yield 3;
    yield 4;
    yield 5;
    yield 6;
}

const it = gen();
console.log(it.next());
console.log(it.next());
console.log(it.next());
console.log(it.next());
console.log(it.next());
console.log(it.next());
console.log(it.next());

function countdown(seconds) {
    return new Promise((resolve, reject) => {
        for (let i = seconds ; i >= 0 ; i--) {
            setTimeout(() => {
                if (i === 3 || i === 1) {
                    return reject(new Error('Error'));
                }
                if (i > 0) {
                    console.log(i + '...');
                    return;
                }
                resolve();
            }, (5 - i) * 1000);
        }
    });
}

countdown(5)
    .then(() => {
        console.log('go');
    })
    .catch(e => {
        console.log(e);
    });

function nfcall(f, ...args) {
    return new Promise(((resolve, reject) => {
        f.call(null, ...args, (err, ...args) => {
            if (err) return reject(err);
            resolve(args.length < 2 ? args[0] : args);
        })
    }));
}

function ptimeout(delay) {
    return new Promise(function (resolve, reject) {
        setTimeout(resolve, delay);
    })
}


