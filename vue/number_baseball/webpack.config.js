const path = require('path')
const VueLoaderPlugin = require('vue-loader/lib/plugin')

// Webpack 은 왜 쓰는가? => 수백 수천 개의 js 파일들을 하나로 효율적으로 관리하기 위해서
module.exports = {
  mode: 'development',
  devtool: 'eval',
  resolve: {
    extensions: ['.js', '.vue'],
  },
  // webpack 이 entry 를 보고 뭔가 작업을 시작하다가
  entry: {
    // 엔트리 포인트, 시작점, 하나로 합칠때 결과 파일
    app: path.join(__dirname, 'main.js')
  },
  // js 가 아닌 파일을 만나면 module.rules 를 참고하여 작업을 진행한다.
  module: {
    // webpack 의 핵심, 어떻게 js 파일을 합칠지 정의
    rules: [{
      test: /.vue$/,
      use: 'vue-loader'
    }]
  },
  // output 으로 결과를 내놓기 전에 뭔가 후 처리?? 할거
  plugins: [
    new VueLoaderPlugin()
  ],
  output: {
    filename: '[name].js',
    path: path.join(__dirname, 'dist')
  }
}