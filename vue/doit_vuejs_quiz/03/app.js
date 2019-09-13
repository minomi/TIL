const app = new Vue({
  el: '#app',
  data: {
    message: 'hello vue js',
    newDataValue: 'new data value',
    uid: '10',
    flag: true,
  },
  methods: {
    clickBtn() {
      console.log('hi');
    },
    eventMethod() {
      console.log('흐하흐하흐')
    }
  }
})