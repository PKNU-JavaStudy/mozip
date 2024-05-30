<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
  <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
  <title>모집(mo.zip) - 멤버모집 작성</title>
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
  <script src="https://code.jquery.com/jquery-3.7.1.js"
          integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

  <script src="/resources/static/js/common.js"></script>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<main>
  <div class="wrap flex">
    <div class="rc-input">
      <form action="#" method="post">
        <span class="pj-type">사이드 프로젝트</span>
        <input id="title" class="rc-title" type="text" placeholder="제목을 입력하세요"/>

        <div class="rc-summarize">
          <p class="s-title">주제</p>
          <textarea id="subject" rows="1" cols="30" placeholder="주제를 30자 내로 써주세요 ~"></textarea>
        </div>

        <div class="rc-role">
          <p class="s-title">모집 역할</p>
          <div class="rc-checkbox">
            <input type="checkbox" id="front" name="frontend"/>
            <label for="front">프론트엔드</label>
            <input type="checkbox" id="back" name="backend"/>
            <label for="back">백엔드</label>
            <input type="checkbox" id="designer" name="designer"/>
            <label for="designer">디자인</label>
            <input type="checkbox" id="manager" name="manager"/>
            <label for="manager">기획</label>
            <input type="checkbox" id="etc" name="etc"/>
            <label for="etc">기타</label>
          </div>
        </div>
        <div class="rc-purpose">
          <p class="s-title">목적</p>
          <div class="rc-checkbox">
            <input type="radio" id="portfolio" name="purpose"/>
            <label for="portfolio">포트폴리오/직무 역량 강화</label>
            <input type="radio" id="founded" name="purpose"/>
            <label for="founded">창업/수익 창출</label>
            <input type="radio" id="fun" name="purpose"/>
            <label for="fun">재미/네트워킹</label>
          </div>
        </div>
        <div class="rc_time">
          <p class="s-title">참여 시간</p>
          <div class="rc-checkbox">
            <input type="radio" id="4time" name="time"/>
            <label for="4time">매주 4시간 이하</label>
            <input type="radio" id="10time" name="time"/>
            <label for="10time">매주 4 - 10 시간</label>
            <input type="radio" id="10timeover" name="time"/>
            <label for="10timeover">매주 10시간 이상</label>
          </div>
        </div>
        <div class="rc-project-info">
          <p class="s-title">소개</p>
          <textarea cols="40" rows="5" placeholder="프로젝트를 소개하는 글을 써주세요 ~"></textarea>
        </div>
        <div class="rc-stack">
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
        <button class="open-modal btn-write" type="button">작성완료</button>
        <!-- 모달창 -->
        <div class="modal-bg"></div>
        <div class="modal">
          <div class="modal-header">
            <a href="#" class="close-modal"><i class="fa-solid fa-xmark"></i></a>
          </div>
          <h3>모집글을 등록하시겠습니까?</h3>
          <div class="button-wrap">
            <button class="close-modal">돌아가기</button>
            <!-- TODO: <button class="submit-modal" type="submit"> 백엔드 연결 후 수정 -->
            <button class="submit-modal">
              등록하기
            </button>
          </div>
        </div>
      </form>
    </div>
    <div class="rc-info">
      <div class="rc-title-info">
        제목은 프로젝트를 직관적으로 알 수 있게<br/>
        작성해주세요 (50자이내)
      </div>
      <div class="rc-title-info summarize">
        어떤 프로젝트인지 이해하기 쉽도록 명확하고 간결하게
        요약해주세요(150자이내)
      </div>
      <div class="advice">
        <div class="advice-step1">
          ✅ 소개에는 이런 내용이 있으면 좋아요👇
        </div>
        <div class="advice-step2">
          <ul>
            <li>어떤 프로젝트인지</li>
            <li>프로젝트를 기획한 배경</li>
            <li>프로젝트 목적, 달성하고 싶은 목표</li>
            <li>모집하고 싶은 역할과 인원수</li>
            <li>프로젝트 진행 방식</li>
          </ul>
        </div>
        <div class="advice-step3">
          이미 진행 중인 프로젝트라면, 현재 구성원과 진행상황을 알려주세요
        </div>
      </div>
    </div>
  </div>
</main>
<%@ include file="../layout/footer.jsp" %>
<script>
    // 프로젝트 주제(textarea) : 1줄만 쓰게 제한
    document.getElementById('subject').addEventListener('keydown', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
        }
    });

    // 프로젝트 주제(textarea) 입력 칸 : 20자 글자 제한
    document.getElementById('subject').addEventListener('input', function () {
        if (this.value.length > 30) {
            this.value = this.value.slice(0, 30);
        }
    });

    // 프로젝트 제목 : 1줄만 쓰게 제한
    document.getElementById('title').addEventListener('keydown', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
        }
    });
    // 프로젝트 제목 입력칸 : 50자 글자 제한
    document.getElementById('title').addEventListener('input', function () {
        if (this.value.length > 50) {
            this.value = this.value.slice(0, 50);
        }
    });

    document.querySelector(".open-modal").addEventListener("click", function () {
        document.querySelector(".modal-bg").classList.add("visible");
        document.querySelector(".modal").classList.add("visible");
    });

    document.querySelector(".close-modal").addEventListener("click", function () {
        document.querySelector(".modal-bg").classList.remove("visible");
        document.querySelector(".modal").classList.remove("visible");
    });

    document.addEventListener("click", function (event) {
        if (
            !event.target.closest(".modal, .open-modal, .open-modal02, .open-modal03")
        ) {
            document.querySelector(".modal").classList.remove("visible");
            document.querySelector(".modal-bg").classList.remove("visible");
            document.body.classList.remove("modal-open");
        }
    });
</script>
</body>
</html>