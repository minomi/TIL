MySQL 에 명령을 하기 위해서는 MySQL과 커넥션이 성립되어야 합니다.
MySQL에 로그인해서 커넥션을 만들 수 있습니다.

```
mysql -u root // 로그

Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 2 // 커넥션이 만들어졌습니다.
Server version: 5.7.22 Homebrew

Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> // MySQL에 명령을 하여 데이터베이스를 작업을 할 수 있습니다.
mysql> ...
mysql> quit // MySQL 로그아웃 (커넥션 종료, 세션 종료)
Bye
```

MySQL과 커넥션을 만들기 위해서는 [user] / [password] 가 필요합니다.

이 커넥션 사이에 MySQL과 다양한 작업을 하게 되는데 이 커넥션의 시작과, 종료까지의 단위를 Session이라고 말합니다.

데이터베이스는 여러명의 사용자와 동시에 커넥션을 맺어서 병행처리를 수행할 수 있습니다.
