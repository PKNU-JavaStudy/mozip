function updateLink() {
  var link = document.getElementById("linkInput").value;
  var altText = document.getElementById("altTextInput").value;

  if (link.trim() !== "" && altText.trim() !== "") {
    var displayArea = document.getElementById("displayArea");
    displayArea.innerHTML = `<a href="${link}" target="_blank">${altText}</a>`;
  } else {
    alert("링크와 대체 텍스트를 모두 입력하세요");
  }
}
