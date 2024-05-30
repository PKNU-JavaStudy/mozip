<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta
    name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
  />
  <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
  <!-- font awesome -->
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
    integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
    crossorigin="anonymous"
    referrerpolicy="no-referrer"
  />
  <link
    rel="stylesheet"
    type="text/css"
    href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"
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

  <script src="/resources/static/js/common.js"></script>
  <script defer src="/resources/static/js/kanban.js"></script>
  <script
    type="text/javascript"
    src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"
  ></script>
  <script
    type="text/javascript"
    src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"
  ></script>
  <script
    type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"
  ></script>
  <title>모집(mo.zip) - 팀노트</title>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="wrap teamnote">
  <h1>📒 팀노트</h1>
  <p>팀원들과 함께 공유하는 팀 페이지 입니다.</p>
  <div class="teamnote-list-wrap">
    <a href="team_note.html" class="show-box">
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
      </div>
    </a>
    <a href="team_note.html" class="show-box">
      <div class="img-wrap">
        <img src="/resources/static/img/showlist_sample.png" alt=""/>
      </div>
      <div class="box-text">
        <h2>
          [풀스택개발자구인] 운동인을 위한 구독형 개인 맞춤 식단도시락
          서비스
        </h2>
        <p class="sub-title">
          피트니스/다이어트 마켓을 같이 독점할 팀원을 찾습니다! '일반 및
          전문 운동인을 위한 구독형 개인맞춤 식단도시락 서비스'를 준비중인
          삼박자팀입니다.
        </p>
      </div>
    </a>
    <a href="team_note.html" class="show-box">
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
      </div>
    </a>
  </div>
</div>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>
