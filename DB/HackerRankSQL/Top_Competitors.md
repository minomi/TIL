### Top Competitors

Julia just finished conducting a coding contest, and she needs your help assembling the leaderboard! Write a query to print the respective hacker_id and name of hackers who achieved full scores for more than one challenge. Order your output in descending order by the total number of challenges in which the hacker earned a full score. If more than one hacker received full scores in same number of challenges, then sort them by ascending hacker_id.

* 하나의 챌린지에서 풀 스코어를 받은 hacker id, name 출력
* 풀 스코어를 받은 챌린지 숫자의 내림차순으로 출력
* 챌린지 숫자가 같다면 hacker_id의 오름차순으로 정렬

```sql
select h.hacker_id, h.name
from Hackers h, Challenges c, Submissions s, Difficulty d
where h.hacker_id = s.hacker_id and
      c.challenge_id = s.challenge_id and 
      d.difficulty_level =  c.difficulty_level and
      s.score = d.score
group by h.hacker_id, h.name
having count(s.score) > 1
order by count(s.score) desc, h.hacker_id;
```