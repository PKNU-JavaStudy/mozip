document.addEventListener("DOMContentLoaded", function () {
  //main - banner 스와이퍼
  var swiper = new Swiper(".bnr-swiper", {
    pagination: {
      el: ".swiper-pagination",
    },
    autoplay: {
      delay: 10000, // 시간 설정
      disableOnInteraction: false,
    },
  });

  // main - cont 스와이퍼
  var swiper = new Swiper(".new-swiper", {
    navigation: {
      nextEl: ".swiper-button-next1",
      prevEl: ".swiper-button-prev1",
    },
    slidesPerView: 2, // 한 화면에 슬라이드 2개씩
    spaceBetween: 20, // 슬라이드 간 간격
    autoplay: {
      delay: 20000, // 시간 설정
      disableOnInteraction: false,
    },
  });

  // main - 인기 프로젝트 스와이퍼
  var swiper = new Swiper(".hot-swiper", {
    navigation: {
      nextEl: ".swiper-button-next2",
      prevEl: ".swiper-button-prev2",
    },
    slidesPerView: 2, // 한 화면에 슬라이드 2개씩
    spaceBetween: 20, // 슬라이드 간 간격
    autoplay: {
      delay: 20000, // 시간 설정
      disableOnInteraction: false,
    },
  });

  // main - member 스와이퍼
  var swiper = new Swiper(".member-swiper", {
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
    slidesPerView: 3, // 한 화면에 슬라이드 3개씩
    spaceBetween: 15, // 슬라이드 간 간격
    // autoplay: {
    //   delay: 20000, // 시간 설정
    //   disableOnInteraction: false,
    // },
  });
});
