### MySQL 쿼리문에서의 정규식

레코드의 문자열 데이터를 select 할 때, where 절 안에서 정규식을 사용할 수 있습니다. <br/>

[HackerRank SQL Weather Observation Station 12](https://www.hackerrank.com/challenges/weather-observation-station-12/problem)


```SQL
SELECT distinct city
FROM station
WHERE city REGEXP '^[^aeiou].*[^aeiou]$';
```
