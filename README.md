## mozip 프로젝트

### 프로젝트 기획서

- **프로젝트 명** : mo.zip(모든 프로젝트의 집합소/ 개발자 모집)
- **프로젝트 소개** : 개발자와 취준생들이 모여 프로젝트를 함께 할 수 있는 협업 플랫폼으로 다양한 프로젝트에 참여하며 실력을 키우고 경험을 쌓을 수 있습니다.
- **프로젝트 기간** : 2024년 5월 2일 ~ 2024년 7월 5일
- **프로젝트 인원** : 4명
- **프로젝트 목표** : IT 및 디자인 프로젝트의 협업을 촉진하고, 전문가들과 인재들이 모여 창의적이고 효율적인 팀워크를 구현할 수 있도록 지원하는 플랫폼 제작

### 팀원 간 소통 (게더타운)

![20240610_145319](https://github.com/PKNU-JavaStudy/mozip_backend/assets/104570636/e0d7251a-42b8-4f4a-ae10-9bd19f3a43fc)

### 개발인원별 역할(수정필요)

| 최재영(백엔드 리더)  | 김동건(풀스택)       | 이윤지(프론트 리더)      | 한지수(풀스택)                     |
|--------------|----------------|------------------|------------------------------|
| 퍼블리싱 및 프론트엔드 | 퍼블리싱 및 프론트엔드   | UI 세팅 및 퍼블리싱     | 퍼블리싱 및 프론트엔드                 |
| 백엔드 서버 구축    | 회원가입           | 프론트엔드 구축         | 프로젝트 상세 데이터 로드(HTML Form 통신) |
| 백엔드 세팅       | 아이디 찾기         | 퍼블리싱 및 프론트엔드 셋팅  | 게시물 조회수 기능                   |
| 로그인 및 로그아웃   | 마이페이지 상세       | 프로젝트 검색 기능       | 게시물 좋아요 기능                   |
| 프로젝트모집 조건 필터 | 기술스택 아이콘 동적 구현 | 프로젝트모집&자랑 리스트 구현 | 게시물 북마크 기능                   |
| 프로젝트모집 수정/삭제 | 마이페이지 수정       | 프로젝트모집 작성        | 프로젝트 자랑 상세페이지                |
| 이미지 업로드 구현   | 프론트엔드 유효성검사    | 프로젝트자랑 수정/삭제     | 팀 노트 리스트                     |
| 이메일 전송 기능    | 개발 산출물 정리      | 더미데이터 세팅         | 개발 산출물 정리                    |

### 기술스택

| Language                                                                                                       | Backend                                                                                                          | Frontend                                                                                               | Database                                                                                                 | Configuration                                                                                    | Build Tool                                                                                           | Collaboration Tool                                                                                     |
|----------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">             | <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">           | <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">   | <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">   | <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> | <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Ajax&logoColor=white"> | <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> |
| <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> | <img src="https://img.shields.io/badge/security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"> | <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">      | <img src="https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=Mybatis&logoColor=white"> |                                                                                                  |                                                                                                      | <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Ajax&logoColor=white">   |
|                                                                                                                |                                                                                                                  | <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> |                                                                                                          |                                                                                                  |                                                                                                      |                                                                                                        |
|                                                                                                                |                                                                                                                  | <img src="https://img.shields.io/badge/Ajax-000000?style=for-the-badge&logo=Ajax&logoColor=white">     |                                                                                                          |                                                                                                  |                                                                                                      |                                                                                                        |

### 의존성 및 라이브러리

- `Spring Web`
- `Lombok`
- `SpringBoot DevTools`
- `MyBatis Framework`
- `JDBC API`
- `MySQL Driver`
- `Validation`
- `Thymeleaf`
- `Java Mail Sender`
- `jQuery`
- `AOP`
- `Spring Security`
- `OAuth2 Client`

### ERD

![mozip.png](/src/main/resources/static/img/mozip.png)

### 구현 기능(수정필요)
#### 프로젝트 생성
- 회원가입
    - 유효성 검사
        - 이메일 형식 / 중복 검사
        - 비밀번호 / 비밀번호 확인 일치
        - 모든 항목에 다 기입
        - 필수 동의사항 선택
- 로그인
    - 비밀번호 틀리면 경고창
- 메인화면
    - 새로운 모집글
        - 생성일 기준으로 내림차순
        - ***프로젝트 생성 후 바뀐 화면 확인***
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
    - ***북마크 / 프로젝트 생성 후 바뀐 화면 확인***
- 모집페이지
    - 분야별 카테고리
        - 백/프론트/디자인/기획
        - 스터디/프로젝트
        - 모집 현황 필터
        - 검색 필터
    - 모집글 작성
        - 글자 수 제한
        - 스택 등 선택하지 않으면 글 작성 안됨
    - 마이페이지 - 내가 만든 프로젝트
        - 북마크(내가 작성한 글이라도 나중에 여러개가 만들어졌을 때 보고싶을 수 있기 때문에 본인 글도 북마크 가능)
        - 수정
        - 모집 완료 / 모집완료 취소

#### 프로젝트 신청
- 로그인
    - 프로젝트 모집
        - 좋아요
        - 북마크
        - 조회수
        - ***참가 신청 후 상단 카운터 확인***
- 프로젝트 자랑
    - 모집글과 비슷
    - 깃허브 링크(팀노트에 있는 링크를 가져오기 때문에 팀노트가 완성 되면 깃허브 링크는 자동으로 연동)

#### 모집 과정
- 모집 글 올리기
- 글 작성자 아이디에서 멤버 추가 버튼을 누르기
- 신청자가 본인 메일로 들어가서 신청 승낙 메일 확인
- ***모집 글에 인원 수가 늘어난 것을 확인***

#### AOP 구현
- AOP(Aspect Orientied Programming, 관점 지향 프로그래밍) : 주 기능이 아닌 부가기능은 AOP 로 묶어서 구현
- 컨트롤러 단에서 하는 유효성검사(Validation)을 AOP로 묶어서 따로 구현
    ```java
    @Component
    @Aspect
    public class ValidationAdvice {
    
        @Around("execution(* com.mozip.web.api.*Controller.*(..))")
        public Object apiValidation(ProceedingJoinPoint joinPoint) throws Throwable {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof BindingResult) {
                    BindingResult bindingResult = (BindingResult) arg;
                    if (bindingResult.hasErrors()) {
                        Map<String, String> errorMap = new HashMap<>();
                        for (FieldError error : bindingResult.getFieldErrors()) {
                            errorMap.put(error.getField(), error.getDefaultMessage());
                        }
                        throw new CustomValidationApiException("유효성 검사 실패함", errorMap);
                    }
                }
            }
            return joinPoint.proceed();
        }
        // 생략...
    }
    ```
#### AWS - RDS
- `AWS Lightsail` 을 통해 `MySql` 데이터베이스를 연동하여 하나의 데이터베이스 여러 팀원들이 공유하여 작업

#### 카카오 API 로그인
- `OAuth2 client` 를 통해 카카오 로그인 구현
- 카카오 API 를 통해 사용자 닉네임과, 프로필 이미지를 받아와서 강제로 회원가입 시켜서 시큐리티 세션에 저장
    ```java
    @RequiredArgsConstructor
    @Service
    public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    
        private final AuthRepository authRepository;
    
        @Override
        public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            OAuth2User oAuth2User = super.loadUser(userRequest);
            Object attributes = oAuth2User.getAttributes().get("properties");
            Map<String, Object> properties = (Map<String, Object>) attributes;
    
    
            String email = properties.get("nickname") + "@kakao.com";
    
            if (authRepository.findByEmail(email) != null) { // 이전에 가입 했던 유저
                Member member = authRepository.findMember(email).orElseThrow(() -> {
                    throw new CustomException("가입하신 회원정보가 없습니다!");
                });
                return new PrincipalDetails(member, properties);
            } else { // 처음 가입하는 유저
                String username = (String) properties.get("nickname");
                String password = bCryptPasswordEncoder.encode((String) properties.get("nickname"));
                String phone = "01000000000";
    
                JoinMemberDto joinMemberDto = JoinMemberDto.builder().email(email).password(password).username(username).phone(phone).build();
                authRepository.joinMember(joinMemberDto, Role.USER.getValue());
    
                Member member = authRepository.findMember(email).orElseThrow(() -> {
                    throw new CustomException("가입하신 회원정보가 없습니다!");
                });
                return new PrincipalDetails(member, properties);
            }
        }
    }
    ```


### 앞으로 남은 작업 및 보완
- 공유하기 버튼(현재 사용자가 보고있는 글의 url을 클립보드에 복사하여 공유할 수 있도록 하기)
- 신청자 메일에서 페이지 연동(멤버 신청 후 메일 확인했을 때 버튼 누르면 해당 게시글의 링크로 바로가기)
- 프로젝트 자랑페이지 검색필터
- 회원탈퇴
- 무한 스크롤
- 프로젝트 배포(AWS Lightsail 이용)
- 사람인 API 

