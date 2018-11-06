/**
 *
 * 윤년인지 아닌지 판단하는 함수
 * 이 함수는 호출한 시간에 따라서 다른 결과를 반환한다.
 * 즉 side effect 가 발생할 수 있다.
 * @returns {boolean}
 */
function isCurrentLeapYear() {
    const year = new Date().getFullYear();
    if (year % 4 !== 0) return false;
    else if (year % 100 !== 0) return true;
    else return year % 400 === 0;
}

console.log(isCurrentLeapYear());


/**
 * 입력이 같으면 결과가 항상 같다. side effect 가 존재하지 않는 순수한 함
 * @param year
 * @returns {boolean}
 */
function isLeapYear(year) {
    if (year % 4 !== 0) return false;
    else if (year % 100 !== 0) return true;
    else return year % 400 === 0;
}

console.log(isLeapYear(2018));

const colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];
let colorIdx = -1;

/**
 * 입력이 같아도 결과가 항상 다르고 외부변수인 colorIdx 를 바꾸는 side effect 가 존재함.
 * @returns {string}
 */
function getNextRainbowColor_worst() {
    if (++colorIdx >= colors.length) colorIdx = 0;
    return colors[colorIdx];
}

console.log(getNextRainbowColor_worst());
console.log(getNextRainbowColor_worst());
console.log(getNextRainbowColor_worst());

/**
 * 외부변수를 클로저로 감쌌다. 하지만 여전히 프로그램의 여러 부분에서 이 함수를 호출하면 문제가 생긴다.
 */
const getNextRainbowColor = (function () {
    const colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];
    let colorIdx = -1;
    return function () {
        if (++colorIdx >= colors.length) colorIdx = 0;
        return colors[colorIdx];
    };
})();

console.log(getNextRainbowColor());
console.log(getNextRainbowColor());
console.log(getNextRainbowColor());

/**
 * 이터레이터를 사용했다. 함수를 호출할 때 마다 매번 다른 이터레이터를 반환해 side effect 를 제거했다.
 * 이 이터레이터들을 서로를 간섭하지 않는다.
 * @returns {*}
 */
function getNextRainbowColor_best() {
    const colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];
    let colorIdx = -1;
    return {
        next() {
            if (++colorIdx >= colors.length) colorIdx = 0;
            return {value: colors[colorIdx], done: false};
        }
    }
}

const rainbowIterator = getNextRainbowColor_best();
console.log(rainbowIterator.next().value);
console.log(rainbowIterator.next().value);
console.log(rainbowIterator.next().value);