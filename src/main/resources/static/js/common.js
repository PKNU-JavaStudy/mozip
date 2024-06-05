document.addEventListener("DOMContentLoaded", function () {
  const topBtn = document.querySelector(".top-btn");
  const header = document.querySelector("#header");

  // top 버튼 애니메이션
  const scrollTopBtn = () => {
    topBtn.addEventListener("click", function (e) {
      e.preventDefault();
      window.scrollTo({ top: 0, behavior: "smooth" });
    });
    return topBtn;
  };

  window.addEventListener("scroll", function () {
    const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    const scrollOffset = 200; // 요소의 높이를 직접 지정

    if (scrollTop < scrollOffset) {
      header.style.boxShadow = "none";
    } else {
      header.style.boxShadow = "0px 0px 5px 3px rgba(0, 0, 0, 0.16)";
    }
  });

  document.body.append(scrollTopBtn());
});

// 로그인 서브메뉴 나타내기
$(".member li").click(function () {
  if ($(this).hasClass("active")) {
    $(this).children().css("display", "none");
    $(this).removeClass("active");
  } else {
    $(".member li").removeClass("active");
    $(this).addClass("active");
    $(this).children().css("display", "block");
  }
});
