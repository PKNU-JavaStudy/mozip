const renderFooter = () => {
  const footer = document.createElement("footer");
  footer.innerHTML = `
  <button class="top-btn"><i class="fa-solid fa-arrow-up"></i></button>
  <div class="footer-in">
    <a href="/index.html">
      <img src="./img/logo.png" alt="logo" />
    </a>
    <div>
    <strong>(주)모집 | </strong>
    <span><strong>사업자번호 </strong> 499-81-00612 | </span>
    <span><strong>대표자 </strong>최재영 김동건 이윤지 한지수</span>
    <br/>
    <span class="footer-address">
      <strong>주소 </strong>부산광역시 남구 용당동 산73-2 산학협력관 41동 | 
    </span>
    <span class="footer-mail"><strong>E-mail </strong>mozip@mozip.com</span>
    <br/>
    <span class="footer-reserved">© 2024 mozip. All rights reserved</span>
  </div>
  `;
  return footer;
};
document.body.append(renderFooter());
