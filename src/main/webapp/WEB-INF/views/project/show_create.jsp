<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
  <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
  <!-- font awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <!-- 직접 구현한 CSS -->
  <link rel="stylesheet" href="/resources/static/css/reset.css"/>
  <link rel="stylesheet" href="/resources/static/css/common.css"/>
  <link rel="stylesheet" href="/resources/static/css/index.css"/>
  <link rel="stylesheet" href="/resources/static/css/create.css"/>
  <!-- js -->
  <!-- jquery -->
  <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
          crossorigin="anonymous"></script>

  <script src="/resources/static/js/common.js"></script>
  <title>모집(mo.zip) - 프로젝트 자랑 작성</title>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<main>
  <div class="wrap flex">
    <form action="#" method="post">
      <span class="pj-type">프로젝트 자랑 작성</span>
      <div class="sc-header">
        <div class="sc-header-img">
          <p class="sc-title title-dist">썸네일</p>
          <div id="image_container">
            <div class="sc-thumbnail-box" onchange="setThumbnail(event);">
              <label for="file">
                <div class="btn-upload">파일 업로드하기</div>
              </label>
              <input type="file" name="file" id="file"/>
            </div>
          </div>
        </div>
        <div class="sc-header-text">
          <div>
            <div class="sc-title-box">
              <p class="sc-title">프로젝트 제목</p>
              <p class="sc-length">0/50</p>
            </div>
            <input class="sc-input title" type="text" name="title" maxlength="50"
                   placeholder="프로젝트 제목을 입력해주세요.(50자 이내)"/>
          </div>
          <div>
            <div class="sc-title-box">
              <p class="sc-title">프로젝트 주제</p>
              <p class="sc-length">0/20</p>
            </div>
            <input id="subject" class="sc-input" type="text" name="summarize" maxlength="150"
                   placeholder="프로젝트 주제에 대해 설명해주세요.(20자 이내)"/>
          </div>
        </div>
      </div>
      <div class="sc-content">
        <p class="sc-title title-dist">내용</p>
        <textarea rows="20"></textarea>
      </div>
      <div class="sc-github-link">
        <div class="sc-title-box-inline">
          <p class="sc-title title-dist">깃허브 레포지토리 링크</p>
          <a class="sc-url-length">0/100</a>
        </div>
        <input class="sc-url" type="text" name="title" maxlength="100" placeholder="URL을 입력해주세요"/>
      </div>
      <div class="sc-stack show-create">
        <p class="s-title">기술 스택</p>
        <span class="stack-item">React <i class="fa-solid fa-xmark"></i></span>
        <div class="stack-list">
          <select class="select">
            <option value="all">기술스택 선택</option>
            <option value="Java">Java</option>
            <option value="C++">C++</option>
            <option value="C#">C#</option>
            <option value="Python">Python</option>
            <option value="Spring">Spring</option>
            <option value="HTML">HTML</option>
            <option value="CSS">CSS</option>
            <option value="JS">JS</option>
            <option value="React">React</option>
            <option value="Vue.js">Vue.js</option>
            <option value="Angular">Angular</option>
            <option value="Flutter">Flutter</option>
            <option value="React Native">React Native</option>
            <option value="Flask">Flask</option>
            <option value="Node.js">Node.js</option>
            <option value="TypeScript">TypeScript</option>
          </select>
        </div>
      </div>
      <div class="sc-member-list">
        <div class="sc-title-box">
          <p class="sc-title">참여 멤버</p>
          <p class="members-length">4/10</p>
        </div>
        <div class="members">
          <ul>
            <li><img src="/resources/static/img/java_icon.png"/><span class="member-name">최재영</span></li>
            <li><img src="/resources/static/img/java_icon.png"/><span class="member-name">이윤지</span></li>
            <li><img src="/resources/static/img/java_icon.png"/><span class="member-name">김동건</span></li>
            <li><img src="/resources/static/img/java_icon.png"/><span class="member-name">한지수</span></li>
          </ul>
        </div>
      </div>
      <button class="sh-btn btn-write">
        <a href="show_list.html">작성완료</a>
      </button>
    </form>
  </div>
</main>
<%@ include file="../layout/footer.jsp" %>
<script>
    // 프로젝트 주제(textarea) 입력 칸 : 20자 글자 제한
    document.getElementById('subject').addEventListener('input', function () {
        if (this.value.length > 20) {
            this.value = this.value.slice(0, 20);
        }
    });

    // TODO : 수정 필요
    function setThumbnail(event) {
        let reader = new FileReader();

        reader.onload = function (event) {
            let img = document.createElement("img");
            img.setAttribute("src", event.target.result);
            img.setAttribute("width", "210px");
            img.setAttribute("height", "210px");
            document.querySelector(".sc-thumbnail-box").appendChild(img);
        };

        reader.readAsDataURL(event.target.files[0]);
    }
</script>
</body>
</html>