Vue.component('child-component', {
  props: ['propsdata'],
  template: '<p>{{ propsdata }}</p>'
});

Vue.component('sibling-component', {
  props: ['propsdata'],
  template: '<p>This is sibling component, props : {{ propsdata }}</p>'
})

new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!',
    anotherMessage: '안녕 Vue!'
  }
})