## mozip 프로젝트

### Stack
- 프로그래밍언어 : Java17
- 서버: SpringBoot 3.2.5
- 템플릿 엔진 : Thymeleaf 3.1.2
- 데이터베이스 : Oracle DB 21c
- 개발 도구 : IntelliJ , DBeaver, Postman
- 빌드도구 : Gradle 8.7
- 형상관리 도구 : Git
- 협업 도구 : Github, Notion

### Dependency
- Spring Web
- Lombok
- SpringBoot DevTools
- MyBatis Framework
- Oracle Driver
- Validation
- Thymeleaf

### ERD(초안)
![mozip.png](/src/main/resources/static/img/mozip.png)
### DB 최초 세팅
- 계정 생성(system 계정으로 접속 후 명령어 입력)
    ```sql
    CREATE USER username IDENTIFIED BY password;
    GRANT CONNECT, RESOURCE, DBA TO mozip;
    COMMENT;
    ```
