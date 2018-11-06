// 배열 안의 함수는 작업 셋 파이프라인을 구성하는데 좋은 패턴이다.
// 작업 단계를 쉽게 수정 가능하기 때문이다.

const sin = Math.sin;
const cos = Math.cos;
const theta = Math.PI / 4;
const zoom = 2;
const offset = [1, -3];

const graphicPipeline = [
    function rotate(p) {
        return {
            x : p.x * cos(theta) - p.y * sin(theta),
            y : p.x * sin(theta) + p.y * cos(theta),
        };
    },
    function scale(p) {
        return {
            x : p.x * zoom,
            y : p.y * zoom,
        }
    },
    function translate(p) {
        return {
            x : p.x + offset[0],
            y : p.y + offset[1],
        }
    },
];

const point = {x : 1, y : 1};
let p = point;
for (let i = 0 ; i < graphicPipeline.length ; i++) {
    p = graphicPipeline[i](p);
}
console.log(p);
