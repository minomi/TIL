#### SQLite 마스터북을 읽고 이해가 안가거나, 중요하다고 생각하는 부분을 인터넷 자료, 개인적인 생각과 함께 정리

#### 책에서 예제로 사용하는 DB Scheme

``` sql
CREATE TABLE contacts ( id INTEGER PRIMARY KEY,
                        name text NOT NULL COLLATE NOCASE,
                        phone text NOT NULL DEFAULT 'UNKNOWN',
                        UNIQUE (name,phone),
                        CHECK(length(phone)>=7) );
```

``` sql
CREATE TABLE episodes (
  id integer primary key,
  season int,
  name text );
```

``` sql
CREATE TABLE food_types(
  id integer primary key,
  name text );
```

``` sql
CREATE TABLE foods(
  id integer primary key,
  type_id integer,
  name text );
```

``` sql
CREATE TABLE foods_episodes(
  food_id integer,
  episode_id integer );
```
