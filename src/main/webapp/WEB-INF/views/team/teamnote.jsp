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
  <link rel="stylesheet" href="/resources/static/css/team_note.css"/>
  <!-- js -->
  <!-- jquery -->
  <script
    src="https://code.jquery.com/jquery-3.7.1.js"
    integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
    crossorigin="anonymous"
  ></script>

  <script src="/resources/static/js/common.js"></script>
  <script defer src="/resources/static/js/kanban.js"></script>
  <script defer src="/resources/static/js/link_input.js"></script>
  <script
    type="text/javascript"
    src="https://www.gstatic.com/charts/loader.js"
  ></script>
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
<div class="top-bg"></div>
<div class="wrap team_note">
  <div class="profile-img"></div>
  <div class="note-cont">
    <h1>개발자 커뮤니티 사이트 | 개발바닥</h1>
    <div class="note-info">
      <div class="note-mem sub-title">
        <h2>👤 프로젝트 멤버</h2>
        <div class="mem-grid">
          <a href="">
            <img src="/resources/static/img/profile_sample.png" alt=""/>
            최재영
            <span>👑</span>
          </a>
          <a href="">
            <img src="/resources/static/img/profile_sample.png" alt=""/>
            이윤지
            <span><i class="fa-solid fa-xmark"></i></span>
          </a>
          <a href="">
            <img src="/resources/static/img/profile_sample.png" alt=""/>
            한지수
            <span><i class="fa-solid fa-xmark"></i></span>
          </a>
          <a href="">
            <img src="/resources/static/img/profile_sample.png" alt=""/>
            김동건
            <span><i class="fa-solid fa-xmark"></i></span>
          </a>
          <a href="">
            <img src="/resources/static/img/profile_sample.png" alt=""/>
            김철수
            <span><i class="fa-solid fa-xmark"></i></span>
          </a>
        </div>
      </div>
      <div class="note-link">
        <input type="text" id="linkInput" placeholder="링크를 입력하세요"/>
        <input
          type="text"
          id="altTextInput"
          placeholder="링크가 이동하는 곳을 입력하세요."
        />
        <button onclick="updateLink()">확인</button>

        <p id="displayArea"></p>
        <!-- <input type="text" placeholder="🔗링크를 입력하세요"> -->
      </div>
    </div>
    <div class="note-kanban sub-title">
      <h2>📝 게시판</h2>
      <div class="dropzone-wrap">
        <button id="add" class="open-modal">
          <i class="fa-solid fa-plus"></i>Add Card
        </button>
        <div class="dropzone-container">
          <div class="dropzone" id="todo">
            <div class="drop-top">
              <div class="flex">
                <h3>Todo 📝</h3>
                <span>3</span>
              </div>
            </div>
          </div>
          <div class="dropzone" id="inProgress">
            <div class="drop-top">
              <div class="flex">
                <h3>In Progress 🚀</h3>
                <span>3</span>
              </div>
            </div>
          </div>
          <div class="dropzone" id="done">
            <div class="drop-top">
              <div class="flex">
                <h3>Done ✔</h3>
                <span>3</span>
              </div>
            </div>
          </div>
        </div>
        <div class="modal-bg"></div>
        <div class="modal">
          <div class="modal-header">
            <a href="#" class="close-modal"
            ><i class="fa-solid fa-xmark"></i
            ></a>
          </div>
          <form name="board" class="modal-cont">
            <div>
              <label for="category">상태</label>
              <select name="category" id="category">
                <option value="Todo 📃">Todo 📃</option>
                <option value="In Progress 🚀">In Progress 🚀</option>
                <option value="Done ✅">Done ✅</option>
              </select>
            </div>
            <div>
              <label for="">할 일</label>
              <input
                type="text"
                name="title"
                placeholder="ex) DB테이블 작성하기"
              />
            </div>
            <div>
              <label for="">기간</label>
              <input type="text" name="daterange"/>
            </div>
            <div>
              <label for="">책임자</label>
              <select name="" id="responsible-select">
                <option value="최재영">최재영</option>
                <option value="김동건">김동건</option>
                <option value="이윤지">이윤지</option>
                <option value="한지수">한지수</option>
              </select>
            </div>
          </form>
          <div class="btn-wrap">
            <button id="createBtn">등록/수정하기</button>
          </div>
        </div>
      </div>
    </div>
    <div class="note-chart sub-title">
      <h2>📆 프로젝트 일정</h2>
      <button id="planBtn" class="modal-open02">
        <i class="fa-solid fa-plus"></i>Add Plan
      </button>
      <label
      >삭제할 작업명 :
        <select id="deleteTaskName"></select> </label
      ><br/>
      <button type="button" onclick="deleteTask()">작업 삭제</button>
      <div id="chart_div"></div>
      <div class="bg02"></div>
      <div class="modal02">
        <div class="modal-header">
          <a href="#" class="close-modal02"
          ><i class="fa-solid fa-xmark"></i
          ></a>
        </div>
        <form class="modal-cont">
          <!-- <div>
            <label for="">작업담당자</label>
            <input type="text" id="taskId" />
          </div> -->
          <div>
            <label for="">작업명</label>
            <input type="text" id="taskName"/>
          </div>
          <div>
            <label for="">작업분류</label>
            <select id="resource">
              <option selected>작업을 선택하세요</option>
              <option value="feature">Feature</option>
              <option value="fix">Fix</option>
              <option value="docs">Docs</option>
              <option value="design">Design</option>
              <option value="study">Study</option>
            </select>
          </div>
          <div>
            <label for="">시작날짜</label>
            <input type="date" id="startDate"/>
          </div>
          <div>
            <label for="">종료날짜</label>
            <input type="date" id="endDate"/>
          </div>
        </form>
        <div class="btn-wrap">
          <button id="createBtn" onclick="addTask()">등록/수정하기</button>
        </div>
      </div>
    </div>
    <div class="note-chat sub-title">
      <h2>💬 소통해요</h2>
      <div class="chatzone">
        <div class="chat other">
          <p class="name">이윤지</p>
          <div class="flex">
            <span class="talk">프로젝트 진행 사항 공유해주세요~</span>
            <b class="time">2023.05.25 오후 9시 11분</b>
          </div>
        </div>
        <div class="chat other">
          <p class="name">한지수</p>
          <div class="flex">
            <span class="talk">프론트엔드 진행 중 입니다.</span>
            <b class="time">2023.05.25 오후 9시 15분</b>
          </div>
        </div>
        <div class="chat my">
          <p class="name">최재영(나)</p>
          <div class="flex">
            <span class="talk">ERD 작성 중입니다.</span>
            <b class="time">2023.05.25 오후 9시 20분</b>
          </div>
        </div>
      </div>
      <div class="inputzone">
        <img src="" alt=""/>
        <input type="text"/>
        <button>입력하기</button>
      </div>
    </div>
  </div>
</div>
<%@ include file="../layout/footer.jsp" %>
<script>
    // 모집완료 모달
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
            resetModal();
        });

    document
        .querySelector(".close-modal-back")
        .addEventListener("click", function () {
            document.querySelector(".modal-bg").classList.remove("visible");
            document.querySelector(".modal").classList.remove("visible");
            resetModal();
        });

    // 삭제 모달
    document
        .querySelector(".open-modal02")
        .addEventListener("click", function () {
            document.querySelector(".bg02").classList.add("visible");
            document.querySelector(".modal02").classList.add("visible");
        });

    document
        .querySelector(".close-modal02-back")
        .addEventListener("click", function () {
            document.querySelector(".bg02").classList.remove("visible");
            document.querySelector(".modal02").classList.remove("visible");
        });

    document
        .querySelector(".close-modal02")
        .addEventListener("click", function () {
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

