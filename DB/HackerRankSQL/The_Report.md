### The Report

You are given two tables: Students and Grades. Students contains three columns ID, Name and Marks.

Ketty gives Eve a task to generate a report containing three columns: Name, Grade and Mark. Ketty doesn't want the NAMES of those students who received a grade lower than 8. The report must be in descending order by grade -- i.e. higher grades are entered first. If there is more than one student with the same grade (8-10) assigned to them, order those particular students by their name alphabetically. Finally, if the grade is lower than 8, use "NULL" as their name and list them by their grades in descending order. If there is more than one student with the same grade (1-7) assigned to them, order those particular students by their marks in ascending order.

* Grades.grade < 8 이면 Null 로 표기
* Grades.grade 내림차순으로 출력
* Grades.grade 가 같으면 Name 알파벳 순서대로 출력
* Grades.grade < 8 인 출력에는 Sturdents.marks 를 오름차순으로 출력


```sql
select case when g.grade >= 8 then s.name else null end, g.grade, s.marks
from students s, grades g
where s.marks between g.min_mark and g.max_mark
order by g.grade desc, s.name, s.marks;
```