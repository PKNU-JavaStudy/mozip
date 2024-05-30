document.addEventListener("DOMContentLoaded", function () {
  // main - cont 스와이퍼
  var swiper = new Swiper(".cont-swiper", {
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
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
