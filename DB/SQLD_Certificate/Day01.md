### Day 01

#### Oracle 설치

OS X 을 사용하고 있기 때문에 Oracle를 사용하기 위해 Docker 를 사용함.

#### DDL, DML, DCL, TCL 에 대해 공부함

각 명령어 종류들에 어떤 명령어들이 있고,언제 쓰는지는 알고 있었지만.
DDL 같은 경우 문법이 많이 헷갈렸음. <br/>
SQL Plus 를 이용해 테이블을 생성해보고 제약사항도 줘 보면서 연습함 <br/>

#### 외래키 지정시 delete, insert action
몰랐던 것들 

* delete
	* `Restrict` : Child 테이블에 PK 값이 없는 경우만 Parent 삭제 허용
* insert 
	* `Depenent` : Parent 테이블에 PK 가 존재할 때만 Child 입력 허용

#### Truncate vs Delete vs Drop
|       DROP        |     TRUNCATE      |      DELETE      |
| :------: | :----------: | :--------: |
| DDL | DDL | DML |
| Rollback 불가능 | Rollback 불가능 | Rollback 불가능 |
| Auto Commit | Auto Commit | Auto Commit |
| 테이블이 사용했던 Storage 모두 Release | 테이블이 사용했던 Storate 중 최초 테이블 생성시 할당된 Storage 만 남기고 Relaese | 데이터를 모두 Delete 해도 사용했던 Storate 는 Release 되지 않음 |
| 테이블의 정의 자체를 완전히 삭제 | 테이블을 최초 생송된 초기상태로 만듦 | 데이터만 삭제 |

DROP 과 TRUNCATE 는 로그가 남지 않는다

#### DBMS 의 Null 처리
Oracle 에 insert 값으로 '' 를 넣으면 Null 로 처리된다.
Null 을 포함한 연산을 할 경우 결과도 Null 이다.

#### SQL 기본 40문제 품

* DDL 문제 풀때 Not Null  신경 쓰고, 제약사항이 중복으로 추가되지 않는지 확인하자
