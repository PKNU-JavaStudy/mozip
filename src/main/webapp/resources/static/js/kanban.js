// 칸반보드 daterange 함수
$(function () {
  // 현재 날짜를 구합니다.
  var today = moment();
  // 오늘 날짜부터 7일 후의 날짜를 구합니다.
  var endDate = moment().add(7, "days");
  // Date Range Picker를 초기화합니다.
  $('input[name="daterange"]').daterangepicker({
    startDate: today,
    endDate: endDate,
    locale: {
      format: "YYYY.MM.DD",
    },
    opens: "left",
  });

  // 기본 값으로 오늘 날짜부터 7일 후의 날짜를 설정합니다.
  $('input[name="daterange"]').val(
    today.format("YYYY.MM.DD") + " ~ " + endDate.format("YYYY.MM.DD")
  );
});

document.getElementById("createBtn").addEventListener("click", function () {
  const category = document.getElementById("category").value;
  const title = document.querySelector('input[name="title"]').value;
  const daterange = document.querySelector('input[name="daterange"]').value;
  const select = document.getElementById("responsible-select");
  const card = document.createElement("div");
  card.className = "card";

  const selectedOption = select.options[select.selectedIndex].text;
  const responsibleHTML = `<span class="responsible">${selectedOption}</span>`;

  card.innerHTML = `
        <h4>${title}</h4>
        <div>
        <span>👨‍💻 ${selectedOption} | </span>
        <span>📆 ${daterange}</span>
        </div>
        <button class="delete-btn"><i class="fa-solid fa-xmark"></i></button>`;

  console.log(selectedOption);
  if (category === "Todo 📃") {
    document.getElementById("todo").appendChild(card);
  } else if (category === "In Progress 🚀") {
    document.getElementById("inProgress").appendChild(card);
  } else if (category === "Done ✅") {
    document.getElementById("done").appendChild(card);
  }

  card.querySelector(".delete-btn").addEventListener("click", function () {
    card.remove();
  });

  alert("카드를 등록하시겠습니까?");
  document.querySelector(".modal-bg").classList.remove("visible");
  document.querySelector(".modal").classList.remove("visible");
  resetModal();
});

function resetModal() {
  document.querySelector('input[name="title"]').value = "";
  document.getElementById("responsible-select").selectedIndex = 0;
}
