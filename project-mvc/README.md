# 나만의 MVC 프레임워크 만들기

`Spring` 기능들을 `Java` 를 통해 직접 구현해보는 프로젝트 입니다.  
(`Lombok`, `Spring` 기능 최대한 배제)


## 목록

- 다양한 사칙연산 계산기 Version
  - [oop](src/main/java/com/mvc/oop)
  - [was](src/main/java/com/mvc/was)
  - [servlet](src/main/java/com/mvc/servlet)
- [JDBC 프로그래밍](src/main/java/com/mvc/jdbc)
- [MVC 프레임워크 만들기](src/main/java/com/mvc/mvc)
- [DI 프레임워크 만들기](src/main/java/com/mvc/di)


## 도커를 이용한 환경 구성

```shell
# MySQL 도커 이미지 다운로드
$ docker pull mysql:latest

# MySQL 도커 컨테이너 생성 및 실행
$ docker run --name mysql-sample-container -e MYSQL_ROOT_PASSWORD=1234 -d -p 3306:3306 mysql:latest

# 현재 실행중인 도커 컨테이너 목록 출력
$ docker ps -a

# MySQL 도커 컨테이너 접속
$ docker exec -it mysql-sample-container bash

# MySQL 접속
$ mysql -u root -p

# Database 생성
$ create database TEST_DB DEFAULT CHARACTER UTF8;
```

