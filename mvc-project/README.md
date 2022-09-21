# 나만의 MVC 프레임워크 만들기

## 도커를 이용한 환경 구성하기

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

## 목록

- 학점 계산기
- 인사관리 시스템
- 사칙연산 계산기
  - oop
  - was
  - servlet
