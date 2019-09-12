<template>
  <div>
    <div id="computer" :style="computedStyleObject"></div>
    <div>
      <button @click="onClickButton('바위')">바위</button>
      <button @click="onClickButton('가위')">가위</button>
      <button @click="onClickButton('보')">보</button>
    </div>
    <div>{{ result }}</div>
    <div>현재 {{ score }} 점</div>
  </div>
</template>

<script>
  const rspCoords = {
    바위 : '0',
    가위 : '-142px',
    보: '-284px'
  };
  const scores = {
    바위 : 1,
    가위 : 0,
    보: -1
  };
  const computerChoice = (imgCoord) => {
    return Object.entries(rspCoords).find((v) => {
      return v[1] === imgCoord
    })[0]
  };


  let interval = null;
  export default {
    name: "RockScissorsPaper",
    data: function () {
      return {
        imageCoords: rspCoords.바위,
        result : '',
        score : 0,
      }
    },
    computed: {
     computedStyleObject() {
       return {
         background: `url(https://en.pimg.jp/023/182/267/1/23182267.jpg) ${this.imageCoords} 0`
       }
     }
    },
    methods: {
      changeHand() {
        interval = setInterval(() => {
          if (this.imageCoords === rspCoords.바위) {
            this.imageCoords = rspCoords.가위
          } else if (this.imageCoords === rspCoords.가위) {
            this.imageCoords = rspCoords.보
          } else if (this.imageCoords === rspCoords.보) {
            this.imageCoords = rspCoords.바위
          }
        }, 100);
      },
      onClickButton(choice) {
        clearInterval(interval);
        const myScore = scores[choice];
        const cpuScore = scores[computerChoice(this.imageCoords)]
        const diff = myScore - cpuScore;
        if (diff === 0) {
          this.result = '비김'
        } else if ([-1, 2].includes(diff)) {
          this.result = 'win'
          this.score += 1;
        } else {
          this.result = 'lose'
          this.score -= 1;
        }
        setTimeout(() => {
          this.changeHand()
        }, 1000)
      }
    },
    created() {
      console.log('created');
    },
    mounted() {
      console.log('mounted');
      this.changeHand()
    },
    beforeDestroy() {
      console.log('beforeDestroy')
      clearInterval(interval);
    }
  }
</script>

<style scoped>
  #computer {
    width: 142px;
    height: 200px;
    background-position: 0 0;
  }
</style>