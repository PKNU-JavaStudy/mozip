const renderHeader = () => {
  const header = document.createElement("header");
  header.innerHTML = `
  <div class="header-in">
    <nav>
      <a href="/index.html">
        <img src="./img/logo.png" alt="logo" />
      </a>
      <ul class="menu">
        <li><a href="/recruit_list.html">멤버 모집</a></li>
        <li><a href="/show_list.html">프로젝트 자랑</a></li>
        <li><a href="/team_note_list.html">팀 노트</a></li>
      </ul>
    </nav>
    <ul class="member">
      <li><a href="../login.html">로그인</a></li>
      <li><a href="../join.html">회원가입</a></li>
    </ul>
  </div>
  `;
  return header;
};
document.body.prepend(renderHeader());
