<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>모집(mo.zip) - 멤버 모집</title>
  <!-- css / font -->
  <!-- 아이콘 : font-awesome -->
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
    integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
    crossorigin="anonymous"
    referrerpolicy="no-referrer"
  />

  <!-- 직접 구현한 CSS -->
  <link rel="stylesheet" href="/resources/static/css/reset.css"/>
  <link rel="stylesheet" href="/resources/static/css/common.css"/>
  <link rel="stylesheet" href="/resources/static/css/index.css"/>
  <link rel="stylesheet" href="/resources/static/css/list.css"/>
  <!-- js -->
  <!-- jquery -->
  <script
    src="https://code.jquery.com/jquery-3.7.1.js"
    integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
    crossorigin="anonymous"
  ></script>
  <!-- swiper -->
  <script src="/resources/static/js/common.js"></script>
  <script src="/resources/static/js/index.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="wrap recruit-list">
  <div class="category">
    <h1>📃 카테고리</h1>
    <ul>
      <li class="on"><a href="#">전체</a></li>
      <li><a href="#">프론트엔드</a></li>
      <li><a href="#">백엔드</a></li>
      <li><a href="#">디자인</a></li>
      <li><a href="#">기획</a></li>
      <li><a href="#">기타</a></li>
    </ul>
    <button class="btn-write open-modal">모집글 작성하기</button>
  </div>
  <div class="project-list">
    <div class="search">
      <input
        type="text"
        placeholder="제목, 내용으로 검색"
        class="recruit-ipt"
      />
      <button><i class="fa-solid fa-magnifying-glass"></i></button>
    </div>
    <div class="list-top">
      <div class="tapmenu">
        <ul>
          <li class="on"><a href="">사이드 프로젝트</a></li>
          <li><a href="">스터디/모임</a></li>
        </ul>
      </div>
      <select class="select">
        <option value="all">전체 모집 글</option>
        <option value="ing">모집 중</option>
        <option value="done">모집 완료</option>
      </select>
    </div>
    <div class="lists">
      <a href="recruit_detail.html" class="project-box">
        <span class="tag">사이드 프로젝트</span>
        <p class="title">
          <strong class="state-ing">모집 중</strong> 엘리스 SW 4기
          모집합니다!
        </p>
        <div class="cont-wrap">
          <p class="content">
            열심히 코딩해서 멋진 개발자가 인재들을 모집합니다.열심히
            코딩해서 멋진 개발자가 인재 들을 모집합니다.열심히 코딩해서 멋진
            개발자가 인재들을 모집합니다.열심히 코딩해서 멋진 개발자가
            인재들을 모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
            모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
            모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
            모집합니다.열심히 코딩해서 멋진 개발자가 인재들을 모집합니다.
          </p>
        </div>
        <div>
          <b>프론트엔드</b>
          <b>백엔드</b>
          <b>디자인</b>
          <b>기획</b>
        </div>
        <div class="purpose">
          <p>
            <i class="fa-solid fa-briefcase"></i> 포트폴리오/직무 역량 강화
          </p>
        </div>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
        </ul>
      </a>
      <a href="recruit_detail.html" class="project-box">
        <span class="tag">사이드 프로젝트</span>
        <p class="title">
          <strong class="state-ing">모집 중</strong> 엘리스 SW 4기
          모집합니다!
        </p>
        <p class="content">
          열심히 코딩해서 멋진 개발자가 인재들을 모집합니다.열심히 코딩해서
          멋진 개발자가 인재 들을 모집합니다.열심히 코딩해서 멋진 개발자가
          인재들을 모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
          모집합니다.
        </p>
        <div>
          <b>프론트엔드</b>
          <b>백엔드</b>
          <b>디자인</b>
          <b>기획</b>
        </div>
        <div class="purpose">
          <p><i class="fa-solid fa-comments"></i> 재미/네트워킹</p>
        </div>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
        </ul>
      </a>
      <a href="recruit_detail.html" class="project-box">
        <span class="tag">사이드 프로젝트</span>
        <p class="title">
          <strong class="state-done">모집 완료</strong> 엘리스 SW 4기
          모집합니다!
        </p>
        <p class="content">
          열심히 코딩해서 멋진 개발자가 인재들을 모집합니다.열심히 코딩해서
          멋진 개발자가 인재 들을 모집합니다.열심히 코딩해서 멋진 개발자가
          인재들을 모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
          모집합니다.
        </p>
        <div>
          <b>프론트엔드</b>
          <b>백엔드</b>
          <b>디자인</b>
          <b>기획</b>
        </div>
        <div class="purpose">
          <p><i class="fa-solid fa-money-bill"></i> 창업/수익 창출</p>
        </div>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
        </ul>
      </a>
      <a href="recruit_detail.html" class="project-box">
        <span class="tag">사이드 프로젝트</span>
        <p class="title">
          <strong class="state-done">모집 완료</strong> 엘리스 SW 4기
          모집합니다!
        </p>
        <p class="content">
          열심히 코딩해서 멋진 개발자가 인재들을 모집합니다.열심히 코딩해서
          멋진 개발자가 인재 들을 모집합니다.열심히 코딩해서 멋진 개발자가
          인재들을 모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
          모집합니다.
        </p>
        <div>
          <b>프론트엔드</b>
          <b>백엔드</b>
          <b>디자인</b>
          <b>기획</b>
        </div>
        <div class="purpose">
          <p><i class="fa-solid fa-money-bill"></i> 창업/수익 창출</p>
        </div>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
        </ul>
      </a>
      <a href="recruit_detail.html" class="project-box">
        <span class="tag">사이드 프로젝트</span>
        <p class="title">
          <strong class="state-done">모집 완료</strong> 엘리스 SW 4기
          모집합니다!
        </p>
        <p class="content">
          열심히 코딩해서 멋진 개발자가 인재들을 모집합니다.열심히 코딩해서
          멋진 개발자가 인재 들을 모집합니다.열심히 코딩해서 멋진 개발자가
          인재들을 모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
          모집합니다.
        </p>
        <div>
          <b>프론트엔드</b>
          <b>백엔드</b>
          <b>디자인</b>
          <b>기획</b>
        </div>
        <div class="purpose">
          <p><i class="fa-solid fa-money-bill"></i> 창업/수익 창출</p>
        </div>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
        </ul>
      </a>
      <a href="recruit_detail.html" class="project-box">
        <span class="tag">사이드 프로젝트</span>
        <p class="title">
          <strong class="state-done">모집 완료</strong> 엘리스 SW 4기
          모집합니다!
        </p>
        <p class="content">
          열심히 코딩해서 멋진 개발자가 인재들을 모집합니다.열심히 코딩해서
          멋진 개발자가 인재 들을 모집합니다.열심히 코딩해서 멋진 개발자가
          인재들을 모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
          모집합니다.
        </p>
        <div>
          <b>프론트엔드</b>
          <b>백엔드</b>
          <b>디자인</b>
          <b>기획</b>
        </div>
        <div class="purpose">
          <p><i class="fa-solid fa-money-bill"></i> 창업/수익 창출</p>
        </div>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
        </ul>
      </a>
      <a href="recruit_detail.html" class="project-box">
        <span class="tag">사이드 프로젝트</span>
        <p class="title">
          <strong class="state-done">모집 완료</strong> 엘리스 SW 4기
          모집합니다!
        </p>
        <p class="content">
          열심히 코딩해서 멋진 개발자가 인재들을 모집합니다.열심히 코딩해서
          멋진 개발자가 인재 들을 모집합니다.열심히 코딩해서 멋진 개발자가
          인재들을 모집합니다.열심히 코딩해서 멋진 개발자가 인재들을
          모집합니다.
        </p>
        <div>
          <b>프론트엔드</b>
          <b>백엔드</b>
          <b>디자인</b>
          <b>기획</b>
        </div>
        <div class="purpose">
          <p><i class="fa-solid fa-money-bill"></i> 창업/수익 창출</p>
        </div>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
        </ul>
      </a>
    </div>
  </div>
</div>
<!-- 모집글 작성 모달창 -->
<div class="modal-bg"></div>
<div class="modal">
  <div class="modal-header">
    <a href="#" class="close-modal"><i class="fa-solid fa-xmark"></i></a>
  </div>
  <h3>작성할 프로젝트 타입을 골라주세요.</h3>
  <div class="button-wrap">
    <button class="type01">
      <a href="recruit_create.html">사이드 프로젝트<i class="fa-solid fa-chevron-right"></i></a>
    </button>
    <button class="type02">
      <a href="recruit_create.html">스터디/모임<i class="fa-solid fa-chevron-right"></i></a>
    </button>
  </div>
</div>
<%@ include file="../layout/footer.jsp" %>
<script>
    // 모집글 작성 모달창
    document
        .querySelector(".open-modal")
        .addEventListener("click", function () {
            document.querySelector(".modal-bg").classList.add("visible");
            document.querySelector(".modal").classList.add("visible");
        });

    document
        .querySelector(".close-modal")
        .addEventListener("click", function () {
            document.querySelector(".modal-bg").classList.remove("visible");
            document.querySelector(".modal").classList.remove("visible");
        });

    document.addEventListener("click", function (event) {
        if (
            !event.target.closest(
                ".modal, .open-modal, .open-modal02, .open-modal03"
            )
        ) {
            document.querySelector(".modal").classList.remove("visible");
            document.querySelector(".modal-bg").classList.remove("visible");
            document.body.classList.remove("modal-open");
        }
    });
</script>
</body>
</html>
