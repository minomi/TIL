#### npm 관련 명령어

```
express learn-sequelize --view=pug
npm i
npm i sequelize pg pg-hstore
npm i sequelize-cli
sequelize init
```

`app.js` 에 다음 라인 추가
```javascript
var sequelize = require('./models').sequelize;
// ./models/index.js 값을 참조 index.js 는 생략 가능
sequelize.sync();
// 실행시 알아서 db 와 연동
```

#### Sequelize 쿼리

##### 데이터 삽입 (insert)

insert into users (name, age, married, comment) 
values ('minho', 24, false, 'gogo'); 
```javascript
User.create({
    name: 'minho',
    age: 24,
    married: false,
    comment: 'gogo'
});
```





