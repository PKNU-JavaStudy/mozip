document.querySelector('.submit-modal').addEventListener("click", function () {
    event.preventDefault(); // form 전송 막는 코드
    let formData = $("#editShow").serializeArray();
    let jsonData = {};

    $(formData).each(function (index, obj) {
        jsonData[obj.name] = obj.value;
    })

    jsonData.skills = [];

    document.querySelectorAll(".selected-skill").forEach((skill) => {
        jsonData.skills.push(skill.id);
    })

    jsonData.recruitRole = [];
    document.querySelectorAll(".selected-role").forEach((role) => {
        jsonData.recruitRole.push(role.id);
    })

    let projectId = jsonData.id;

    $.ajax({
        type: "PATCH",
        url: `/api/show/${projectId}`,
        data: JSON.stringify(jsonData),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(res => { // HTTP 상태 코드 200번대일 때 호출됨
        console.log("통신성공", res);
        alert("데이터 수정완료!");
        let projectId = res.data;
        window.location.assign(`/project/show/${projectId}`);
    }).fail(error => { // HTTP 상태 코드 200번대가 아닐 때 호출됨
        alert("게시글 수정을 실패했습니다. 다시 시도해주세요."); // 서버에서 반환된 메시지 대신 고정 메시지 표시
    });
})

// // 프로젝트 주제(textarea) : 1줄만 쓰게 제한
// document.getElementById('subject').addEventListener('keydown', function (event) {
//   if (event.key === 'Enter') {
//     event.preventDefault();
//   }
// });
//
// // 프로젝트 주제(textarea) 입력 칸 : 20자 글자 제한
// document.getElementById('subject').addEventListener('input', function () {
//   if (this.value.length > 20) {
//     this.value = this.value.slice(0, 20);
//   }
// });

document.querySelector(".open-modal").addEventListener("click", function () {
    document.querySelector(".modal-bg").classList.add("visible");
    document.querySelector(".modal").classList.add("visible");
});

document.querySelector(".close-modal").addEventListener("click", function () {
    document.querySelector(".modal-bg").classList.remove("visible");
    document.querySelector(".modal").classList.remove("visible");
});

document.addEventListener("click", function (event) {
    if (
        !event.target.closest(".modal, .open-modal")
    ) {
        document.querySelector(".modal").classList.remove("visible");
        document.querySelector(".modal-bg").classList.remove("visible");
        document.body.classList.remove("modal-open");
    }
});

// 프로젝트 주제(textarea) : 1줄만 쓰게 제한
document.getElementById('subject').addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        event.preventDefault();
    }
});

// 프로젝트 주제(textarea) 입력 칸 : 20자 글자 제한
document.getElementById('subject').addEventListener('input', function () {
    if (this.value.length > 20) {
        this.value = this.value.slice(0, 20);
    }
});

// 프로젝트 자랑 수정
document.addEventListener('DOMContentLoaded', function () {
    const stackSelect = document.getElementById('stack');
    const memberSkills = Array.from(document.querySelectorAll("#stack-container .selected-item .projectSkill")).map(item => item.textContent.trim());
    const removedOptions = [];

    const options = Array.from(stackSelect.options);
    memberSkills.forEach(skill => {
        const optionToRemove = options.find(option => option.text.trim() === skill);
        if (optionToRemove) {
            removedOptions.push(optionToRemove.cloneNode(true));
            stackSelect.removeChild(optionToRemove);
        }
    });


    // 수정폼 클릭 이벤트
    const submitButton = document.getElementById("mypage-button");

    submitButton.addEventListener("click", function (event) {
        event.preventDefault();
        sendFormData();
        // if (validateForm()) {
        //     // 유효성 검사를 통과하면 AJAX 요청
        //
        // }
    });

    // stackSelect.addEventListener("change", () => {
    //     handleStackSelectChange(stackSelect, "stack-container");
    // });
});

function sendFormData() {
    let formData = $("#editShow").serializeArray();
    console.log(formData);
    let projectName = document.querySelector("#projectName").value;
    let startDate = document.querySelector("#startDate").value;
    let endDate = document.querySelector("#endDate").value;
    let projectTime = document.querySelector("#projectTime").value;
    let projectInfo = document.querySelector("#projectInfo").value;

    let jsonData = {};
    jsonData.prjectName = projectName;
    jsonData.startDate = startDate;
    jsonData.endDate = endDate;
    jsonData.projectTime = projectTime;
    jsonData.projectInfo = projectInfo;

    let skills = [];

    document.querySelectorAll(".projectSkill").forEach(item => {
        skills.push(item.textContent);
    });

    jsonData.skills = skills;

    console.log(jsonData);

    $.ajax({
        type: "PATCH",
        url: "/api/show/" + projectId,
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(res => { // HTTP 상태 코드 200번대일 때 호출됨
        console.log("성공:", res);
        alert("게시글이 성공적으로 수정되었습니다."); // 서버에서 반환된 메시지 표시
        window.location.replace(`/project/show`);
    }).fail(error => { // HTTP 상태 코드 200번대가 아닐 때 호출됨
        alert("게시글 수정을 실패했습니다. 다시 시도해주세요."); // 서버에서 반환된 메시지 대신 고정 메시지 표시
    });
}