## mozip 프로젝트

### 프로젝트 기획서
- **프로젝트 명** : mo.zip(모두의 프로젝트)
- **프로젝트 소개** : 개발자와 취준생들이 모여 프로젝트를 함께 할 수 있는 협업 플랫폼으로 다양한 프로젝트에 참여하며 실력을 키우고 경험을 쌓을 수 있습니다.
- **프로젝트 기간** : 2024년 5월 2일 ~ 2024년 6월 11일
- **프로젝트 인원** : 4명
- **프로젝트 목표** : IT 및 디자인 프로젝트의 협업을 촉진하고, 전문가들과 인재들이 모여 창의적이고 효율적인 팀워크를 구현할 수 있도록 지원하는 플랫폼 제작

### 개발인원별 역할

|최재영(백엔드 리더)|김동건(풀스택)|이윤지(프론트 리더)|한지수(풀스택)|
|---|---|---|---|
|---|---|---|---|
|---|---|---|---|
|---|---|---|---|
|---|---|---|---|
|---|---|---|---|


### 기술스택
|Language|Backend|Frontend|Database|Configuration|Build Tool|Collaboration Tool|
|---|---|---|---|---|---|---|
|<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">|<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">|<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">|<img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">|<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">|<img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Ajax&logoColor=white">|<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">|
|<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">||<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">||||<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Ajax&logoColor=white">|
|||<img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">|||||
|||<img src="https://img.shields.io/badge/Ajax-000000?style=for-the-badge&logo=Ajax&logoColor=white">|||||

### 의존성 및 라이브러리
- Spring Web 
- Lombok
- SpringBoot DevTools
- MyBatis Framework
- JDBC API
- Oracle Driver
- Validation
- Thymeleaf
- Java Mail Sender
- jQuery
- Ajax
- jbcrypt

### ERD
![mozip.png](/src/main/resources/static/img/mozip.png)

### 구현 기능
  ##### 프로젝트 생성
  - 회원가입
    - 유효성 검사
      - 이메일 형식
      - 비밀번호 / 비밀번호 확인 일치
      - 모든 항목에 다 기입
      - 필수 동의사항 선택
  - 로그인
    - 비밀번호 틀리면 경고창
    - <- 카카오 로그인 보류 ->
  - 메인화면
    - 새로운 모집글
      - 생성일 기준으로 내림차순
      - *프로젝트 생성 후 바뀐 화면 확인*
    - 인기 모집글
      - 조회 수 기준으로 내림차순
    - 새로운 멤버
      - 마이페이지 수정 내역이 있는 멤버 중 생성일 기준으로 내림차순
      - 마이페이지를 수정하지 않으면 새로운 멤버에 뜨지 않음
      - *마이페이지 수정 후 바뀐 화면 확인*
  - 마이페이지
    - 마이페이지 수정 전 아무런 정보 없는 것을 확인
    - 내가 만든 프로젝트 / 북마크 한 글 없는 것 확인
    - 마이페이지 수정
    - *북마크 / 프로젝트 생성 후 바뀐 화면 확인*
  - 모집페이지
    - 분야별 카테고리
      - 백/프론트/디자인/기획
      - 스터디/프로젝트
      - 셀렉트 필터
      - 검색 필터
    - 모집글 작성
      - 글자 수 제한
      - 스택 등 선택하지 않으면 글 작성 안됨
    - 마이페이지 - 내가 만든 프로젝트
      - 북마크(내가 작성한 글이라도 나중에 여러개가 만들어졌을 때 보고싶을 수 있기 때문에 본인 글도 북마크 가능)
      - 수정
      - 모집 완료 / 모집완료 취소
  ##### 프로젝트 신청
  - 로그인
    - 프로젝트 모집
      - 좋아요
      - 북마크
      - 조회수
      - *참가 신청 후 상단 카운터 확인*
  - 프로젝트 자랑
    - 모집글과 비슷
    - 깃허브 링크(팀노트에 있는 링크를 가져오기 때문에 팀노트가 완성 되면 깃허브 링크는 자동으로 연동)
  
  ##### 모집 과정
  - 모집 글 올리기
  - 글 작성자 아이디에서 멤버 추가 버튼을 누르기
  - 신청자가 본인 메일로 들어가서 신청 승낙 메일 확인
  - *모집 글에 인원 수가 늘어난 것을 확인*

  
### 보완할 점
- AOP(AOP(Aspect Orientied Programming, 관점 지향 프로그래밍) : 주 기능(회원가입, 로그인 등)이 아닌 부가기능(입력값 검증)같은 전처리,후처리 기능을 AOP로 바꿔서 구현하는것.
- 공유하기 버튼(현재 사용자가 보고있는 글의 url을 클립보드에 복사하여 공유할 수 있도록 하기)
- 신청자 메일에서 페이지 연동(멤버 신청 후 메일 확인했을 때 버튼 누르면 해당 게시글의 링크로 바로가기)
- 카카오 로그인
- 팀노트
- 프로젝트 자랑페이지 검색필터(시간 부족..)
