// 특정 배열의 수를 더해서 반환하는 함수, 제곱해서 반환하는 함수, 세제곱해서 반환하는 함수

function sum(arr, f) {
    if (typeof f !== 'function') {
        f = x => x;
    }
    return arr.reduce((a, x) => a += f(x), 0);
}

console.log(sum([1, 2, 3]));
console.log(sum([1, 2, 3], x => x * x));
console.log(sum([1, 2, 3], x => Math.pow(x, 3)));