<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>모집(mo.zip) - 멤버모집 상세</title>
  <!-- css / font -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
  <link rel="stylesheet" href="/resources/static/css/reset.css">
  <link rel="stylesheet" href="/resources/static/css/common.css">
  <link rel="stylesheet" href="/resources/static/css/detail.css">
  <!-- js -->
  <script src="https://code.jquery.com/jquery-3.7.1.js"
          integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
  <script src="/resources/static/js/index.js"></script>
  <script src="/resources/static/js/common.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<!-- main -->
<main>
  <div class="wrap flex">
    <div class="content">
      <div class="main-contents">
        <div class="title-wrap">
          <span class="tag">사이드 프로젝트</span>
          <p class="title">
            <strong class="state-ing">모집 중</strong> 엘리스 SW 4기
            모집합니다!
          </p>
        </div>
        <!-- <p class="title">
    <strong class="state-done">모집 완료</strong> 엘리스 SW 4기
    모집합니다!
  </p> -->
        <div class="info-wrap">
          <ul class="count">
            <li>2024년 4월 30일</li>
            <li>💬 8개</li>
            <li>👁‍🗨 28회</li>
          </ul>
          <!-- ul 안에 li태그 말고는 넣지 말기 -->
          <a href="" class="share-Btn"><i class="fa-solid fa-share-nodes"></i>공유하기</a>
        </div>
        <!-- <input type="text" id="urlInput" value=""> -->
        <!-- <div class="copy-message" id="copyMessage">페이지 URL이 복사되었습니다!</div> -->
        <p class="title-contents first">프로젝트 주제</p>
        <p class="content">
          열심히 코딩해서 멋진 개발자가 인재들을 모집합니다. 많은 지원바랍니다!열심히 코딩해서 멋진 개발자가
          인재들을 모집합니다.
        </p>
        <p class="title-contents">모집 역할</p>
        <!-- ul - li 은 한세트 -->
        <ul class="recruit-icon">
          <li><i class="fa-solid fa-desktop"></i>프론트엔드</li>
          <li><i class="fa-solid fa-server"></i>백엔드</li>
          <li><i class="fa-solid fa-wand-magic-sparkles"></i>디자인</li>
          <li><i class="fa-solid fa-paste"></i>기획</li>
          <li><i class="fa-solid fa-envelopes-bulk"></i>기타</li>
        </ul>
        <p class="title-contents">프로젝트에 필요한 필수 기술 스택</p>
        <ul class="stack-icon">
          <li><img src="/resources/static/img/java_icon.png"></li>
          <li class="java_icon"> Java</li>
          <li><img src="/resources/static/img/Cplus_icon.png"></li>
          <li class="Cplus_icon"> C++</li>
          <li><img src="/resources/static/img/Csharp_icon.png"></li>
          <li class="Csharp_icon"> C#</li>
          <li><img src="/resources/static/img/python_icon.png"></li>
          <li class="python_icon"> Python</li>
          <li><img src="/resources/static/img/html_icon.png"></li>
          <li class="html_icon"> HTML</li>
          <li><img src="/resources/static/img/typeScript_icon.png"></li>
          <li class="typeScript_icon"> TypeScript</li>
        </ul>
        <ul class="stack-icon">
          <li><img src="/resources/static/img/css_icon.png"></li>
          <li class="css_icon"> CSS</li>
          <li><img src="/resources/static/img/js_icon.png"></li>
          <li class="js_icon"> JS</li>
          <li><img src="/resources/static/img/spring_icon.png"></li>
          <li class="spring_icon"> Spring</li>
          <li><img src="/resources/static/img/react_icon.png"></li>
          <li class="react_icon"> React</li>
          <li><img src="/resources/static/img/vueJs_icon.png"></li>
          <li class="vueJs_icon"> Vue.js</li>
          <li><img src="/resources/static/img/git_icon.png"></li>
          <li class="git_icon"> Git</li>
        </ul>
        <ul class="stack-icon">
          <li><img src="/resources/static/img/Angular_icon.png"></li>
          <li class="Angular_icon"> Angular</li>
          <li><img src="/resources/static/img/Flask_icon.png"></li>
          <li class="Flask_icon"> Flask</li>
          <li><img src="/resources/static/img/Flutter_icon.png"></li>
          <li class="Flutter_icon"> Flutter</li>
          <li><img src="/resources/static/img/react_native_icon.png"></li>
          <li class="react_icon"> react_native</li>
          <li><img src="/resources/static/img/NodeJs_icon.png"></li>
          <li class="NodeJs_icon"> Node.js</li>
        </ul>
        <p class="title-contents">목적</p>
        <ul class="recruit-icon">
          <li><i class="fa-solid fa-cubes-stacked"></i>역량 키우기</li>
          <li><i class="fa-solid fa-briefcase"></i>포트폴리오</li>
          <li><i class="fa-solid fa-house-laptop"></i>취미</li>
          <li><i class="fa-regular fa-comment-dots"></i>소통 및 커뮤니티</li>
        </ul>
        <p class="title-contents">참여시간</p>
        <ul class="recruit-icon">
          <li><i class="fa-regular fa-hourglass-half"></i>매주 4시간 이하</li>
          <li><i class="fa-regular fa-hourglass-half"></i>매주 4 ~ 10시간</li>
          <li><i class="fa-regular fa-hourglass-half"></i>매주 10시간 이상</li>
        </ul>
        <p class="title-contents">프로젝트 소개</p>
        <p class="content bottom">
          인원: 200명<br><br>
          모집일: 2024년 4월 30일 ~ 2024년 5월 28일<br><br>
          코딩테스트: 2024년 6월 14일<br><br>
          합격자 발표: 2024년 6월 28일<br><br>
          개발자 꿈나무들의 많은 신청 바랍니다~
        </p>
        <p class="title-contents">🖐 저요저요! </strong><i class="fa-solid fa-circle-info"></i>
        <div class="app-wrap">
          <div class="application-box">
            <div class="profile-top">
              <img src="/resources/static/img/profile_sample.png" alt="">
              <div>
                <h3>이윤지</h3>
                <p>프론트엔드 개발자</p>
              </div>
              <button class="addmem-button add">멤버 추가</button>
            </div>
            <p class="comment">
              지원하고 싶어요~!
            <p class="box-count">2024년 4월 30일</p>
            </p>
          </div>
          <div class="application-box">
            <div class="profile-top">
              <img src="/resources/static/img/profile_sample.png" alt="">
              <div>
                <h3>이윤지</h3>
                <p>프론트엔드 개발자</p>
              </div>
              <button class="addmem-button done">멤버</button>
            </div>
            <p class="comment">
              지원하고 싶어요~!
            <p class="box-count">2024년 4월 30일</p>
            </p>
          </div>
          <div class="application-box">
            <div class="profile-top">
              <img src="/resources/static/img/profile_sample.png" alt="">
              <div>
                <h3>이윤지</h3>
                <p>프론트엔드 개발자</p>
              </div>
              <button class="addmem-button done">멤버</button>
            </div>
            <p class="comment">
              지원하고 싶어요~!
            <p class="box-count">2024년 4월 30일</p>
            </p>
          </div>
        </div>
        <div class="aplly-box">
          <div class="profile-pic">
            <img src="/resources/static/img/profile_sample.png" alt="">
          </div>
          <input type="text" class="comment-write" placeholder=" ex) 프로젝트 함께하고 싶어요~ "></input>
          <!-- <div class="comment-write"></div> -->
          <button class="aplly-try">지원하기</button>
        </div>
      </div>
    </div>
    <div class="right-box">
      <div class="profile-box">
        <img src="/resources/static/img/profile_sample.png" alt="">
        <h3>이윤지</h3>
        <p>안녕하세요 프론트엔드 개발자 이윤지 입니다.</p>
      </div>
      <button class="right-btn bookmark"><i class="fa-regular fa-bookmark"></i>북마크</button>
      <button class="right-btn confirm open-modal">모집완료 하기</button>

      <div class="edit-btn">
        <a href="recruit_create.html">
          <button class="right-btn mod_btn">수정</button>
        </a>
        <button class="right-btn del_btn open-modal02">삭제</button>
      </div>
      <span>👩‍👦‍👦 현재 참여 인원 5명</span>
    </div>
    <!-- 모달창 -->
    <div class="modal-bg">
    </div>
    <div class="modal">
      <div class="modal-header">
        <a href="#" class="close-modal"><i class="fa-solid fa-xmark"></i></a>
      </div>
      <h3>모집을 완료하시겠습니까?</h3>
      <div class="button-wrap">
        <button class="close-modal-back">돌아가기</button>
        <button class="submit-modal" type="submit">모집 완료하기</button>
      </div>
    </div>
    <div class="modal-bg bg02">
    </div>
    <div class="modal02">
      <div class="modal-header">
        <a href="#" class="close-modal02"><i class="fa-solid fa-xmark"></i></a>
      </div>
      <h3>게시글을 삭제하시겠습니까?</h3>
      <p>삭제 후에는 게시글을 되돌릴 수 없습니다.</p>
      <div class="button-wrap">
        <button class="close-modal02-back">돌아가기</button>
        <button class="submit-modal" type="submit">삭제하기</button>
      </div>
    </div>
  </div>
</main>
<%@ include file="../layout/footer.jsp" %>
<script>
    // 모집완료 모달
    document.querySelector(".open-modal").addEventListener("click", function () {
        document.querySelector(".modal-bg").classList.add("visible");
        document.querySelector(".modal").classList.add("visible");
    });

    document.querySelector(".close-modal").addEventListener("click", function () {
        document.querySelector(".modal-bg").classList.remove("visible");
        document.querySelector(".modal").classList.remove("visible");
    });

    document.querySelector(".close-modal-back").addEventListener("click", function () {
        document.querySelector(".modal-bg").classList.remove("visible");
        document.querySelector(".modal").classList.remove("visible");
    });

    // 삭제 모달
    document.querySelector(".open-modal02").addEventListener("click", function () {
        document.querySelector(".bg02").classList.add("visible");
        document.querySelector(".modal02").classList.add("visible");
    });

    document.querySelector(".close-modal02-back").addEventListener("click", function () {
        document.querySelector(".bg02").classList.remove("visible");
        document.querySelector(".modal02").classList.remove("visible");
    });

    document.querySelector(".close-modal02").addEventListener("click", function () {
        document.querySelector(".bg02").classList.remove("visible");
        document.querySelector(".modal02").classList.remove("visible");
    });

    // 바깥영역 클릭 시 종료
    document.addEventListener("click", function (event) {
        if (
            !event.target.closest(".modal, .open-modal, .open-modal02, .modal02")
        ) {
            document.querySelector(".modal").classList.remove("visible");
            document.querySelector(".modal-bg").classList.remove("visible");

            document.querySelector(".modal02").classList.remove("visible");
            document.querySelector(".bg02").classList.remove("visible");

            document.body.classList.remove("modal-open");
        }
    });
</script>
</body>
</html>