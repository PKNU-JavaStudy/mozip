<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>모집(mo.zip) - 로그인</title>
  <!-- font awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <!-- 직접 구현한 CSS -->
  <link rel="stylesheet" href="/resources/static/css/reset.css"/>
  <link rel="stylesheet" href="/resources/static/css/common.css"/>
  <link rel="stylesheet" href="/resources/static/css/user.css"/>

  <script src="/resources/static/js/common.js"></script>
  <script defer src="/resources/static/js/join_effect.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<main>
  <div class="wrap flex user-title">
    <h1>로그인</h1>
    <form class="submit-box" action="index.html">
      <!-- 로그인 데이터를 처리할 서버의 URL -->
      <div class="input-group">
        <h2 for="email">이메일</h2>
        <input type="email" id="email" placeholder="mozip@mozip.com" required>
      </div>
      <div class="input-group">
        <h2 for="password">비밀번호</h2>
        <input type="password" id="password" placeholder="비밀번호를 입력하세요." minlength="5" required>
      </div>
      <div class="inputLogin">
        <input type="submit" value="로그인" class="inputLogin">
      </div>
      <div class="separator">또는</div> <!-- 시각적 구분선 추가 -->
      <div class="kakaoLogin">
        <input type="submit" value="카카오 로그인" class="kakao">
      </div>
      <div class="submit">아직 회원이 아니신가요??
        <span><a href="join.html">가입하기</a></span> <!-- 회원가입 페이지 링크 수정 -->
        <br>
      </div>
      <div class="forgot">
        <ul>
          <li><a href="find_id.html">아이디 찾기</a></li>
          <li><a href="find_password.html">비밀번호 찾기</a></li>
        </ul>
      </div>
    </form>
  </div>
</main>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>