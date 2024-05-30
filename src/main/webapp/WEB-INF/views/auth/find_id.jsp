<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>모집(mo.zip) - 아이디 찾기</title>
  <!-- font awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <!-- 직접 구현한 CSS -->
  <link rel="stylesheet" href="/resources/static/css/reset.css"/>
  <link rel="stylesheet" href="/resources/static/css/common.css"/>
  <link rel="stylesheet" href="/resources/static/css/user.css"/>

  <script defer src="/resources/static/js/header.js"></script>
  <script defer src="/resources/static/js/footer.js"></script>
  <script src="/resources/static/js/common.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<main>
  <div class="wrap flex user-title">
    <h1>아이디 찾기</h1>
    <form class="submit-box">
      <div class="input-group">
        <h2 for="name">이름</h2>
        <input type="text" id="name" class="input-padding" placeholder="이름을 입력해주세요." minlength="2" maxlength="5"
               required>
      </div>
      <div class="input-group">
        <h2 for="phoneNumber">전화번호</h2>
        <input type="text" id="phone" class="input-padding" placeholder="전화번호를 입력해주세요(-제외)" maxlength="11" required>
      </div>
      <div class="inputFind">
        <input type="submit" value="아이디 찾기" class="find-submit">
      </div>
      <div class="submit">아직 회원이 아니신가요??
        <span><a href="join.html">가입하기</a></span> <!-- 회원가입 페이지 링크 수정 -->
      </div>
      <div class="forgot">
        <a href="find_password.html">비밀번호 찾기</a></span>
      </div>
    </form>
  </div>
</main>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>