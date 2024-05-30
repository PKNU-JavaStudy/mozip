<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>모집(mo.zip) - 프로젝트 자랑</title>
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
  <script src="/resources/static/js/index.js"></script>
  <script src="/resources/static/js/common.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="wrap">
  <div class="show-top">
    <div class="search">
      <input
        type="text"
        placeholder="제목, 내용으로 검색"
        class="recruit-ipt"
      />
      <button><i class="fa-solid fa-magnifying-glass"></i></button>
    </div>
    <div class="show-flex">
      <div class="tapmenu">
        <ul>
          <li class="on"><a href="">사이드 프로젝트</a></li>
          <li><a href="">스터디/모임</a></li>
        </ul>
      </div>
      <select class="select">
        <option value="new">최신순</option>
        <option value="old">오래된순</option>
        <option value="hot">인기순</option>
        <option value="save">북마크순</option>
      </select>
    </div>
  </div>
  <div class="show-lists">
    <a href="show_detail.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p>
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
        <ul class="lang">
          <li>React</li>
          <li>Java</li>
          <li>HTML</li>
          <li>CSS</li>
        </ul>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
          <li>🏷 12회</li>
        </ul>
      </div>
    </a>
    <a href="show_detail.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p>
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
        <ul class="lang">
          <li>React</li>
          <li>Java</li>
          <li>HTML</li>
          <li>CSS</li>
        </ul>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
          <li>🏷 12회</li>
        </ul>
      </div>
    </a>
    <a href="show_detail.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p>
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
        <ul class="lang">
          <li>React</li>
          <li>Java</li>
          <li>HTML</li>
          <li>CSS</li>
        </ul>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
          <li>🏷 12회</li>
        </ul>
      </div>
    </a>
    <a href="show_detail.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p>
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
        <ul class="lang">
          <li>React</li>
          <li>Java</li>
          <li>HTML</li>
          <li>CSS</li>
        </ul>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
          <li>🏷 12회</li>
        </ul>
      </div>
    </a>
    <a href="show_detail.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p>
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
        <ul class="lang">
          <li>React</li>
          <li>Java</li>
          <li>HTML</li>
          <li>CSS</li>
        </ul>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
          <li>🏷 12회</li>
        </ul>
      </div>
    </a>
    <a href="show_detail.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p>
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
        <ul class="lang">
          <li>React</li>
          <li>Java</li>
          <li>HTML</li>
          <li>CSS</li>
        </ul>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
          <li>🏷 12회</li>
        </ul>
      </div>
    </a>
    <a href="show_detail.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p>
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
        <ul class="lang">
          <li>React</li>
          <li>Java</li>
          <li>HTML</li>
          <li>CSS</li>
        </ul>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
          <li>🏷 12회</li>
        </ul>
      </div>
    </a>
    <a href="show_detail.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p>
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
        <ul class="lang">
          <li>React</li>
          <li>Java</li>
          <li>HTML</li>
          <li>CSS</li>
        </ul>
        <ul class="count">
          <li>💬 8개</li>
          <li>👁‍🗨 28회</li>
          <li>🏷 12회</li>
        </ul>
      </div>
    </a>
  </div>
  <div class="btn-wrap">
    <a href="show_create.html" class="write-btn"><span>✏</span></a>
  </div>
</div>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>
