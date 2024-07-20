let page = 0;

let categoryPage = 0;
let categoryCheck = false

let typePage = 0;
let typeCheck = false

let selectPage = 0;
let selectCheck = false

let searchText = '';
let searchPage = 0;

let url = '';
$(window).scroll(() => {
  let checkNum = $(window).scrollTop() - ($(document).height() - $(window).height());

  if (checkNum < 1 && checkNum > -1 && !categoryCheck && !typeCheck && !selectCheck && searchText == '') {
    page = page + 10;
    pageLoad(page);
  } else if (checkNum < 1 && checkNum > -1 && categoryCheck && !typeCheck && !selectCheck && searchText == '') {
    categoryPage = categoryPage + 10;
    filterPageLoad(categoryPage);
  } else if (checkNum < 1 && checkNum > -1 && !categoryCheck && typeCheck && !selectCheck && searchText == '') {
    typePage = typePage + 10;
    filterPageLoad(typePage);
  } else if (checkNum < 1 && checkNum > -1 && !categoryCheck && !typeCheck && selectCheck && searchText == '') {
    selectPage = selectPage + 10;
    filterPageLoad(selectPage);
  } else if (checkNum < 1 && checkNum > -1 && searchText != '' && !categoryCheck && !typeCheck && !selectCheck) {
    searchPage = searchPage + 10;
    searchPageLoad(searchPage);
  }
});

function pageLoad(page) {
  $.ajax({
    url: `/api/project?page=${page}`,
    type: "GET",
  }).done(res => {
    console.log("성공", res);
    if (res.data.length === 0) {
      alert("마지막 페이지입니다!");
    } else {
      res.data.forEach(project => {
        $('.lists').append(`
            <a href="/project/${project.id}" class="project-box">
              <span class="pj-type ${project.projectType == '사이드 프로젝트' ? 'pj' : 'study'}">${project.projectType}</span>
              <p class="title">
                <strong class="${project.status == 1 ? 'state-ing' : 'state-done'}">${project.status == 1 ? '모집 중' : '모집완료'}</strong>
                <span>${project.projectName}</span>
              </p>
              <div class="cont-wrap">
                <p class="content">${project.projectInfo}</p>
              </div>
              <ul class="pj-work">
                ${project.roleNames.map(role => `<li>${role}</li>`).join('')}
              </ul>
              <ul class="count">
                <li>${project.createTime}</li>
                <li><i class="fa-regular fa-hand"></i> ${project.subscribe}명</li>
                <li><i class="fa-solid fa-eye"></i> ${project.views}회</li>
              </ul>
            </a>
          `);
      });
    }
  }).fail(err => {
    console.log("실패", err);
  });
}

function filterPageLoad(page) {
  url = url.slice(0, url.indexOf("?")) + `?page=${page}`;

  $.ajax({
    url: url,
    type: 'GET',
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    dataType: 'json',
  }).done(res => {
    console.log("무한스크롤성공", res);
    if (res.data.length === 0) {
      alert("마지막 페이지입니다!");
    } else {
      res.data.forEach(project => {
        $('.lists').append(`
            <a href="/project/${project.id}" class="project-box">
              <span class="pj-type ${project.projectType == '사이드 프로젝트' ? 'pj' : 'study'}">${project.projectType}</span>
              <p class="title">
                <strong class="${project.status == 1 ? 'state-ing' : 'state-done'}">${project.status == 1 ? '모집 중' : '모집완료'}</strong>
                <span>${project.projectName}</span>
              </p>
              <div class="cont-wrap">
                <p class="content">${project.projectInfo}</p>
              </div>
              <ul class="pj-work">
                ${project.roleNames.map(role => `<li>${role}</li>`).join('')}
              </ul>
              <ul class="count">
                <li>${project.createTime}</li>
                <li><i class="fa-regular fa-hand"></i> ${project.subscribe}명</li>
                <li><i class="fa-solid fa-eye"></i> ${project.views}회</li>
              </ul>
            </a>
          `);
      });
    }
  }).fail(err => {
    console.log("실패", err)
  });
}

function searchPageLoad(page) {
  $.ajax({
    url: `/api/project/search`,
    type: "GET",
    data: {"keyword": searchText, "page": page},
    success: function (response) {
      if (response.data.length === 0) {
        alert("마지막 페이지입니다!");
      } else {
        response.data.forEach(project => {
          $('.lists').append(`
            <a href="/project/${project.id}" class="project-box">
              <span class="pj-type ${project.projectType == '사이드 프로젝트' ? 'pj' : 'study'}">${project.projectType}</span>
              <p class="title">
                <strong class="${project.status == 1 ? 'state-ing' : 'state-done'}">${project.status == 1 ? '모집 중' : '모집완료'}</strong>
                <span>${project.projectName}</span>
              </p>
              <div class="cont-wrap">
                <p class="content">${project.projectInfo}</p>
              </div>
              <ul class="pj-work">
                ${project.roleNames.map(role => `<li>${role}</li>`).join('')}
              </ul>
              <ul class="count">
                <li>${project.createTime}</li>
                <li><i class="fa-regular fa-hand"></i> ${project.subscribe}명</li>
                <li><i class="fa-solid fa-eye"></i> ${project.views}회</li>
              </ul>
            </a>
          `);
        });
      }
    },
    error: function (error) {
      console.log("Error: ", error);
    }
  });
}

function createValidation() {
  let member = document.querySelector(".hidden-session").textContent;
  if (member == null) {
    alert("로그인을 먼저 진행해주세요 !");
    window.location.assign("/auth/login");
  } else {
    window.location.assign("/project/create");
  }
}

// 카테고리 및 타입 필터링 함수
function filterProjects(filterType, filterValue) {
  reset();

  if (filterType === 'category') {
    categoryCheck = true;
    url = `/api/project/${filterValue}?page=${categoryPage}`; // 카테고리
  } else if (filterType === 'type') {
    typeCheck = true;
    url = `/api/project/type/${filterValue}?page=${typePage}`; // 프로젝트 타입
  } else if (filterType === 'status') {
    selectCheck = true;
    url = `/api/project/select/${filterValue}?page=${selectPage}`; // 셀렉트박스
  }

  // 스타일 변경
  if (filterType === 'category') {
    document.querySelectorAll('.category ul li').forEach(item => item.classList.remove('on'));
    document.querySelectorAll('.tapmenu ul li').forEach(item => item.classList.remove('on'));
    document.getElementById(getCategoryId(filterValue)).classList.add('on');
    document.getElementById(getTypeId('all')).classList.add('on');

  } else if (filterType === 'type') {
    document.querySelectorAll('.tapmenu ul li').forEach(item => item.classList.remove('on'));
    document.querySelectorAll('.category ul li').forEach(item => item.classList.remove('on'));
    document.getElementById(getTypeId(filterValue)).classList.add('on');
    document.getElementById(getCategoryId('all')).classList.add('on');
  } else if (filterType === 'status') {
    document.querySelector('.select').value = filterValue;
  }

  $.ajax({
    url: url,
    type: 'GET',
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    dataType: 'json',
  }).done(res => {
    console.log("성공", res);
    if (res.data.length === 0) {
      $('.lists').append('<p class="search-null">프로젝트가 존재하지 않습니다. 다시 검색해주세요.</p>');
    } else {
      $('.lists').empty();// 기존 리스트 초기화
      res.data.forEach(project => {
        $('.lists').append(`
            <a href="/project/${project.id}" class="project-box">
              <span class="pj-type ${project.projectType == '사이드 프로젝트' ? 'pj' : 'study'}">${project.projectType}</span>
              <p class="title">
                <strong class="${project.status == 1 ? 'state-ing' : 'state-done'}">${project.status == 1 ? '모집 중' : '모집완료'}</strong>
                <span>${project.projectName}</span>
              </p>
              <div class="cont-wrap">
                <p class="content">${project.projectInfo}</p>
              </div>
              <ul class="pj-work">
                ${project.roleNames.map(role => `<li>${role}</li>`).join('')}
              </ul>
              <ul class="count">
                <li>${project.createTime}</li>
                <li><i class="fa-regular fa-hand"></i> ${project.subscribe}명</li>
                <li><i class="fa-solid fa-eye"></i> ${project.views}회</li>
              </ul>
            </a>
          `);
      });
    }
  }).fail(err => {
    console.log("실패", err)
  });
}

function getCategoryId(categoryName) {
  switch (categoryName) {
    case 'all':
      return 'all';
    case '풀스택':
      return 'etc';
    case '프론트엔드':
      return 'frontend';
    case '백엔드':
      return 'backend';
    case '디자인':
      return 'design';
    case '기획':
      return 'manager';
    default:
      return 'all';
  }
}

function getTypeId(typeName) {
  switch (typeName) {
    case 'all':
      return 'typeAll';
    case '사이드 프로젝트':
      return 'typeSide';
    case '스터디 모임':
      return 'typeStudy';
    default:
      return '';
  }
}

function handleSelectFilter(event) {
  let selectedValue = event.target.value;
  filterProjects('status', selectedValue);
}

function searchProjects() {
  reset();
  searchText = document.querySelector(".recruit-ipt").value;
  $('.lists').empty();  // 기존 리스트 초기화
  $.ajax({
    url: `/api/project/search?page=0`,
    type: "GET",
    data: {"keyword": searchText},
    success: function (response) {
      $('.lists').empty();
      if (response.data.length === 0) {
        $('.lists').append('<p class="search-null">프로젝트가 존재하지 않습니다. 다시 검색해주세요.</p>');
      } else {
        response.data.forEach(project => {
          $('.lists').append(`
            <a href="/project/${project.id}" class="project-box">
              <span class="pj-type ${project.projectType == '사이드 프로젝트' ? 'pj' : 'study'}">${project.projectType}</span>
              <p class="title">
                <strong class="${project.status == 1 ? 'state-ing' : 'state-done'}">${project.status == 1 ? '모집 중' : '모집완료'}</strong>
                <span>${project.projectName}</span>
              </p>
              <div class="cont-wrap">
                <p class="content">${project.projectInfo}</p>
              </div>
              <ul class="pj-work">
                ${project.roleNames.map(role => `<li>${role}</li>`).join('')}
              </ul>
              <ul class="count">
                <li>${project.createTime}</li>
                <li><i class="fa-regular fa-hand"></i> ${project.subscribe}명</li>
                <li><i class="fa-solid fa-eye"></i> ${project.views}회</li>
              </ul>
            </a>
          `);
        });
      }
    },
    error: function (error) {
      console.log("Error: ", error);
    }
  });
}

function clearSearch() {
  document.querySelector(".recruit-ipt").value = '';
  searchProjects('');
}

function handleKeyDown(event) {
  if (event.key === 'Enter') {
    searchProjects(event.target.value);
  }
}

function reset() {
  page = 0;
  categoryPage = 0;
  categoryCheck = false;
  typePage = 0;
  typeCheck = false;
  selectPage = 0;
  selectCheck = false;
  searchText = '';
  searchPage = 0;
  url = '';
}

// 이벤트 리스너 추가
document.querySelector(".recruit-ipt").addEventListener('keydown', handleKeyDown);
document.querySelector(".search-remove").addEventListener('click', clearSearch);