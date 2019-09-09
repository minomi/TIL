<template>
  <div>
    <h1> {{ result }} </h1>
    <form @submit.prevent="onSubmitForm">
      <input ref="answer" type="number" minlength="421" maxlength="4" v-model="value">
      <button type="submit">입력</button>
    </form>
    <div>시도 : {{ tryCount }}</div>
  </div>
</template>
<script>
  export default {
    data : function() {
      return {
        number: Math.floor(1000 + Math.random() * 9000).toString(),
        result : '',
        value : '',
        tryCount : '',
        strike: 0,
        ball: 0
      }
    },
    methods : {
      onSubmitForm() {
        // 자리, 숫자 같으면 스트라이크
        // 숫자 만 같으면 볼
        this.strike = 0;
        this.ball = 0;

        for (let i = 0 ; i < this.number.length ; i++) {
          if (this.number.charAt(i) === this.value.charAt(i)) {
            this.strike += 1;
            continue;
          }
          if (this.number.includes(this.value.charAt(i))) {
            this.ball += 1;
          }
        }

        if (this.strike === 4) {
          this.result = `정답 : ${this.number}`
          this.number = Math.floor(1000 + Math.random() * 9000).toString()
        }

        this.result = `strike : ${this.strike}, ball : ${this.ball}`
      }
    }
  }
</script>
<style>

</style>