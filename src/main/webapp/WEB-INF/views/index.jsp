<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>모집(mo.zip)</title>
  <!-- css / font -->
  <!-- 아이콘 : font-awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <!-- 슬라이드 배너 : swiper -->
  <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>

  <!-- 직접 구현한 CSS -->
  <link rel="stylesheet" href="resources/static/css/reset.css">
  <link rel="stylesheet" href="resources/static/css/reset.css">
  <link rel="stylesheet" href="resources/static/css/index.css">
  <!-- js -->
  <!-- jquery -->
  <script src="https://code.jquery.com/jquery-3.7.1.js"
          integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
          crossorigin="anonymous"></script>
  <!-- swiper -->
  <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
  <script src="resources/static/js/index.js"></script>
  <script defer src="resources/static/js/common.js"></script>
</head>

<body>
<%@ include file="layout/header.jsp" %>
<!-- main -->
<main>
  <!-- swiper -->
  <div class="swi"></div>
  <!-- container -->
  <div class="wrap">
    <div class="container">
      <h2 class="cont-h2">새로운 모집글 🎉</h2>
      <h5>새로 업데이트 된 모집글을 확인해보세요!</h5>
      <div class="swiper cont-swiper ps-l">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
        </div>
        <div class="all-page">
          <a href="recruit_list.html">모두 보기
            <i class="fa-solid fa-angle-right"></i>
          </a>
        </div>
        <div class="swiper-button-prev">
          <i class="fa-solid fa-arrow-left"></i>
        </div>
        <div class="swiper-button-next">
          <i class="fa-solid fa-arrow-right"></i>
        </div>
      </div>
    </div>
    <div class="container">
      <h2 class="cont-h2">인기 프로젝트 TOP 6 🔥</h2>
      <h5>현재 인기있는 모집글을 확인해보세요!</h5>
      <div class="swiper cont-swiper ps-l">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="cont-box">
              <p class="pj-type">사이드 프로젝트</p>
              <h1 class="pj-title">
                한달살기 프로젝트 - 백엔드 개발자님 추가 모집 중
              </h1>
              <p class="pj-content">
                현재 웹, 구글플레이스토어, 앱스토어에 출시되어있습니다.
                도시별 한달살기 정보제공 플랫폼을 만들고 있습니다.
                수익창출을 목표로 실행 중이며, 창업에 관심있는 분을 찾고
                있어요.
              </p>
              <p class="pj-use">
                <i class="fa-solid fa-circle-dollar-to-slot"></i>
                창업/수익창출
              </p>
              <ul>
                <li>조회수 6회</li>
                <li>북마크 16회</li>
              </ul>
            </div>
          </div>
        </div>
        <div class="all-page">
          <a href="recruit_list.html">모두 보기
            <i class="fa-solid fa-angle-right"></i>
          </a>
        </div>
        <div class="swiper-button-prev">
          <i class="fa-solid fa-arrow-left"></i>
        </div>
        <div class="swiper-button-next">
          <i class="fa-solid fa-arrow-right"></i>
        </div>
      </div>
    </div>
    <div class="container">
      <h2 class="cont-h2">새로운 멤버 🎊</h2>
      <h5>프로젝트를 함께 할 수 있는 새로운 멤버를 확인해보세요!</h5>
      <div class="swiper member-swiper ps-l">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <div class="member-box">
              <div class="profile-top">
                <div class="profile-img"></div>
                <div class="profile-info">
                  <h6>이윤지</h6>
                  <p>프론트엔드 개발자</p>
                </div>
              </div>
              <p class="profile-cont">
                프로젝트 구인 중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.
              </p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="member-box">
              <div class="profile-top">
                <div class="profile-img"></div>
                <div class="profile-info">
                  <h6>이윤지</h6>
                  <p>프론트엔드 개발자</p>
                </div>
              </div>
              <p class="profile-cont">
                프로젝트 구인 중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.
              </p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="member-box">
              <div class="profile-top">
                <div class="profile-img"></div>
                <div class="profile-info">
                  <h6>이윤지</h6>
                  <p>프론트엔드 개발자</p>
                </div>
              </div>
              <p class="profile-cont">
                프로젝트 구인 중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.
              </p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="member-box">
              <div class="profile-top">
                <div class="profile-img"></div>
                <div class="profile-info">
                  <h6>이윤지</h6>
                  <p>프론트엔드 개발자</p>
                </div>
              </div>
              <p class="profile-cont">
                프로젝트 구인 중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.
              </p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="member-box">
              <div class="profile-top">
                <div class="profile-img"></div>
                <div class="profile-info">
                  <h6>이윤지</h6>
                  <p>프론트엔드 개발자</p>
                </div>
              </div>
              <p class="profile-cont">
                프로젝트 구인 중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.
              </p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="member-box">
              <div class="profile-top">
                <div class="profile-img"></div>
                <div class="profile-info">
                  <h6>이윤지</h6>
                  <p>프론트엔드 개발자</p>
                </div>
              </div>
              <p class="profile-cont">
                프로젝트 구인 중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.프로젝트 구인
                중입니다.프로젝트 구인 중입니다.
              </p>
            </div>
          </div>
        </div>
        <div class="all-page">
          <!--              <a-->
          <!--                >모두 보기-->
          <!--                <i class="fa-solid fa-angle-right"></i>-->
          <!--              </a>-->
        </div>
        <div class="swiper-button-prev">
          <i class="fa-solid fa-arrow-left"></i>
        </div>
        <div class="swiper-button-next">
          <i class="fa-solid fa-arrow-right"></i>
        </div>
      </div>
    </div>
  </div>
</main>
<%@ include file="layout/footer.jsp" %>
</body>
</html>