<template>
  <div>
    <div id='screen' @click=onClickScreen :class="state">
      {{ message }}
    </div>
    <template v-if="result.length">
    평균시간 : {{ average }} ms
    <button @:click="onClickButton">리셋</button>
    </template>
  </div>
</template>

<script>
  let startTime = 0;
  let timeout = null;

  export default {
    name: "ReactionVelocity",
    data: function () {
      return {
        message: '클릭해서 시작하세요',
        state: 'waiting',
        result: []
      }
    },
    computed: {
      average() {
        return (this.result.reduce((a, c) => a + c, 0) / this.result.length) || 0
      }
    },
    methods: {
      onClickScreen() {
        if (this.state === 'waiting') {
          this.state = 'ready'
          this.message = '초록색이 되면 클릭하세요'

          timeout = setTimeout(() => {
            this.state = 'now'
            this.message = '지금 클릭하세요!!!'
            startTime = new Date();
          }, (Math.random() * 1000) + 2000)

        } else if (this.state === 'ready') {
          clearTimeout(timeout);
          this.state = 'waiting'
          this.message = '너무 성급하시군요! 초록색이 되면 클릭하세요'
        } else {
          this.result.push(new Date() - startTime)
          this.message = '초록색이 되면 클릭하세요'
          this.state = 'waiting'
        }
      },
      onClickButton() {
        this.result = []
      }
    }
  }
</script>

<style scoped>
  #screen {
    width: 200px;
    height: 300px;
    text-align: center;
    user-select: none;
  }
  #screen.waiting {
    background-color: aqua;
  }
  #screen.ready {
    background-color: red;
    color: white;
  }
  #screen.now {
    background-color: greenyellow;
  }
</style>