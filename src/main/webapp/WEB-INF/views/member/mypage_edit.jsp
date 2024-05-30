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
  <script defer src="/resources/static/js/02donggun.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<main>
  <div class="wrap flex">
    <div class="edit-section">
      <img src="/resources/static/img/cinnamoroll.jpeg" alt="Profile Image" class="profile-image">
      <div class="form-container">
        <form id="profile-form" action="mypage.html">
          <div class="edit-group">
            <h2>이름</h2>
            <input type="text" id="name" disabled>
          </div>
          <div class="form-group">
            <div class="input-group">
              <h2>경력 <span class="required">*</span></h2>
              <div class="radio" id="experience-container">
                <label><input type="radio" name="experience" value="1" required>학생 / 취업준비생 </label>
                <label><input type="radio" name="experience" value="2" required>신입</label>
                <label><input type="radio" name="experience" value="3" required>1~3년차</label>
                <label><input type="radio" name="experience" value="4" required>3~5년차</label>
                <label><input type="radio" name="experience" value="5" required>5년이상</label>
              </div>
            </div>
            <div class="introduce">
              <h2>자기소개</h2>
              <textarea class="introduce-input" style="resize: none" type="text" name="title"
                        maxlength="312" placeholder="자기소개를 입력해주세요."></textarea>
            </div>
            <div class="link">
              <h2>깃허브 레포지토리 링크<span id="charCount" class="maxlength">0/100</span></h2>
              <input id="urlInput" class="sc-input" style="resize: none" type="text" name="title" maxlength="100"
                     placeholder="URL을 입력하세요."/>
            </div>
            <h2 class="section">원하는 직군 <span class="required">*</span></h2>
            <div class="select-skills" id="skill-container">
              <!--아이콘 들어가는 곳-->
            </div>
            <select id="skill">
              <option value="">--선택--</option>
              <option value="frontend">프론트엔드</option>
              <option value="backend">백엔드</option>
              <option value="designer">디자이너</option>
              <option value="planner">기획자</option>
            </select>

            <h2 class="section">기술 스택 <span class="required">*</span></h2>
            <div class="select-programs" id="stack-container">
              <!--아이콘 들어가는 곳-->
            </div>
            <select id="stack">
              <option value="">--선택--</option>
              <option value="java">Java</option>
              <option value="C++">C++</option>
              <option value="C#">C#</option>
              <option value="python">Python</option>
              <option value="html">HTML</option>
              <option value="typescript">TypeScript</option>
              <option value="css">Css</option>
              <option value="js">JS</option>
              <option value="spring">Spring</option>
              <option value="react">React</option>
              <option value="vue">Vue.js</option>
              <option value="git">Git</option>
              <option value="angular">Angular</option>
              <option value="flask">Flask</option>
              <option value="flutter">Flutter</option>
              <option value="react_native">React_native</option>
              <option value="node">Node.js</option>
            </select>
            <input type="submit" id="mypage-submit" value="완료" class="complete">
          </div>
        </form>
      </div>
    </div>
  </div>
</main>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>