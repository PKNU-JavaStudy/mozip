<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>모집(mo.zip) - 마이페이지</title>
  <!-- font awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <!-- Custom CSS -->
  <link rel="stylesheet" href="/resources/static/css/reset.css"/>
  <link rel="stylesheet" href="/resources/static/css/common.css"/>
  <link rel="stylesheet" href="/resources/static/css/mypage.css"/>

  <script src="/resources/static/js/common.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<main>
  <div class="wrap">
    <div class="profile-container">
      <div class="profile-section">
        <a href="mypage_edit.html" class="edit-btn">마이페이지 수정</a>
        <a href="/mypage.html">
          <img src="/resources/static/img/cinnamoroll.jpeg" alt="Profile Image" class="profile-image">
        </a>
        <h1>한지수</h1>
        <p class="year">1~3년차 개발자</p>
        <p id="text-input">안녕하세요 프론트 개발자 이윤지입니다. 안녕하세요 프론트 개발자 이윤지입니다. 안녕하세요 프론트 개발자 이윤지입니다. 안녕하세요 프론트 개발자
          이윤지입니다. 안녕하세요 프론트 개발자 이윤지입니다.안녕하세요 프론트 개발자 이윤지입니다. 안녕하세요 프론트 개발자 이윤지입니다.</p>
        <a href="https://github.com/devuoon" class="github-link">
          <img src="/resources/static/img/github.png" alt="GitHub" class="github-logo"/>https://github.com/devuoon
        </a>
      </div>
      <div class="container">
        <div class="skills-section">
          <div class="skills-header">
            <p>🏷️</p>
          </div>
          <div class="tags skills">
            <span class="tag front">프론트엔드</span>
            <span class="tag back">백엔드</span>
            <span class="tag design">디자인</span>
            <span class="tag plan">기획</span>
          </div>
        </div>
        <div class="programs-section">
          <div class="skills-header">
            <p>🔧</p>
          </div>
          <div class="tags programs">
            <span class="tag react">React</span>
            <span class="tag typescript">TypeScript</span>
            <span class="tag html">HTML</span>
            <span class="tag css">CSS</span>
          </div>
        </div>
      </div>

      <hr class="underline">

      <div class="make-pj">
        <div class="header-flex">
          <h2>📄 내가 만든 프로젝트 <span class="highlight">2</span></h2>
          <select class="dropdown">
            <option>모집중</option>
            <option>모집완료</option>
            <option>프로젝트 자랑</option>
          </select>
        </div>
        <a href="/recruit_detail.html" class="pj-content">
          <div class="project-info">
            <div class="project-tag">사이드 프로젝트</div>
            <span class="time-commitment">매주 4일 10시간</span>
          </div>
          <span class="get-member"><span>모집중&emsp;</span> |&emsp;엘리스 SW 4기 모집합니다!</span>
          <span class="date">2024년 4월 30일 오후 3:50:44</span>
        </a>
        <a href="/recruit_detail.html" class="pj-content">
          <div class="project-info">
            <div class="project-tag">사이드 프로젝트</div>
            <span class="time-commitment">매주 4일 10시간</span>
          </div>
          <span class="get-member"><span>모집중&emsp;</span> |&emsp;엘리스 SW 4기 모집합니다!</span>
          <span class="date">2024년 4월 30일 오후 3:50:44</span>
        </a>
      </div>
      <div class="bookmark">
        <div class="header-flex">
          <h2>🏷️ 북마크한 글 <span class="highlight">4</span></h2>
          <select class="dropdown">
            <option>모집중</option>
            <option>모집완료</option>
            <option>프로젝트 자랑</option>
          </select>
        </div>
        <a href="/recruit_detail.html" class="pj-content">
          <div class="project-info">
            <div class="project-tag">사이드 프로젝트</div>
            <span class="time-commitment">매주 4일 10시간</span>
          </div>
          <span class="get-member"><span>모집중&emsp;</span> |&emsp;엘리스 SW 4기 모집합니다!</span>
          <span class="date">2024년 4월 30일 오후 3:50:44</span>
        </a>
        <a href="/recruit_detail.html" class="pj-content">
          <div class="project-info">
            <div class="project-tag">사이드 프로젝트</div>
            <span class="time-commitment">매주 4일 10시간</span>
          </div>
          <span class="get-member"><span>모집중&emsp;</span> |&emsp;엘리스 SW 4기 모집합니다!</span>
          <span class="date">2024년 4월 30일 오후 3:50:44</span>
        </a>
      </div>
    </div>
  </div>
  </div>
</main>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>