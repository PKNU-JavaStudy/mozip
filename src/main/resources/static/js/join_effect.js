// 회원가입 유효성 js
// 변수 선언
const form = document.getElementById("signup-form"); // 전체 폼
const submit = document.getElementById("join-submit"); // 회원가입 버튼
const requiredCheckBoxes = Array.from(document.querySelectorAll(".required")); // 모든 필수 체크박스
const agreeAllCheckBox = document.getElementById("agreeAll"); // 모두 동의 체크박스
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // 이메일 정규식
const namePattern = /^.{2,5}$/; // 이름 정규식 (2~5자리)
const phoneNumberPattern = /^010\d{8}$/; // 휴대폰 번호 정규식

// 입력이 올바른지 확인
function checkFieldValidity(input) {
  let isValid = true;
  const value = input.value.trim();

  if (input.id === "name") {
    isValid = namePattern.test(value);
  } else if (input.id === "email") {
    isValid = emailPattern.test(value);
  } else if (input.id === "phone-number") {
    isValid = phoneNumberPattern.test(value);
  } else if (input.id === "password" || input.id === "confirm-password") {
    const password = document.getElementById("password").value.trim();
    const confirmPassword = document
      .getElementById("confirm-password")
      .value.trim();
    isValid =
      password.length >= 5 &&
      (input.id !== "confirm-password" || password === confirmPassword);
  }

  if (isValid) {
    input.style.borderColor = "#c3c3c3";
  } else {
    input.style.borderColor = "red";
  }
}

// 모두 동의 체크박스
function toggleAll(source) {
  const checkboxes = document.querySelectorAll('input[type="checkbox"]');
  checkboxes.forEach((checkbox) => {
    checkbox.checked = source.checked;
  });
  checkSubmitState();
}

// 모든 필수 박스가 선택되었는지 확인
function checkSubmitState() {
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const phoneNumber = document.getElementById("phone-number").value.trim();
  const password = document.getElementById("password").value.trim();
  const checkPassword = document
    .getElementById("confirm-password")
    .value.trim();

  // 모든 필수 입력 필드가 채워져 있는지 확인
  const allFieldsFilled =
    name && email && phoneNumber && password && checkPassword;

  submit.disabled = !(allChecked && allFieldsFilled);
}

// 필수 체크박스 변경 시 이벤트 리스너
requiredCheckBoxes.forEach((checkbox) => {
  checkbox.addEventListener("change", checkSubmitState);
});

// 입력 필드 변경 시 이벤트 리스너
document
  .querySelectorAll(
    "#name, #email, #phone-number, #password, #confirm-password"
  )
  .forEach((input) => {
    input.addEventListener("input", () => {
      checkFieldValidity(input);
      checkSubmitState();
    });
  });

// 폼 제출 이벤트 리스너
submit.addEventListener("click", function () {
  event.preventDefault();
  // 입력 필드 확인
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const phoneNumber = document.getElementById("phone-number").value.trim();
  const password = document.getElementById("password").value.trim();
  const checkPassword = document
    .getElementById("confirm-password")
    .value.trim();
  const allChecked = requiredCheckBoxes.every((checkbox) => checkbox.checked);

  document
    .querySelectorAll(
      "#name, #email, #phone-number, #password, #confirm-password"
    )
    .forEach((input) => {
      checkFieldValidity(input);
    });

  // 각 필드 유효성 검사 및 테두리 색상 변경
  document
    .querySelectorAll(
      "#name, #email, #phone-number, #password, #confirm-password"
    )
    .forEach((input) => {
      checkFieldValidity(input);
      if (input.style.borderColor === "red") {
        isFormValid = false;
      }
    });

  if (!name || !email || !phoneNumber || !password || !checkPassword) {
    alert("모든 입력 칸을 작성해 주세요.");
    return;
  }
  if (!namePattern.test(name)) {
    alert("이름이 올바르지 않습니다. ");
    return;
  }
  if (!emailPattern.test(email)) {
    alert("유효한 이메일을 입력해 주세요.");
    return;
  }
  if (!phoneNumberPattern.test(phoneNumber)) {
    alert("유효한 전화번호를 입력해 주세요.");
    return;
  }
  if (password !== checkPassword) {
    alert("비밀번호가 일치하지 않습니다.");
    return;
  }
  if (!allChecked) {
    alert("필수 이용약관 동의를 해주세요.");
    return;
  }
  alert("회원가입이 완료되었습니다.");
  window.location.href = "login.html";
});

// 초기 상태에서 제출 버튼 비활성화
checkSubmitState();
