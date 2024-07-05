let ownerId = document.querySelector(".owner-id").textContent;
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

document.querySelector(".open-modal").addEventListener("click", function () {
    document.querySelector(".modal-bg").classList.add("visible");
    document.querySelector(".modal").classList.add("visible");
});

document.querySelector(".close-modal").addEventListener("click", function () {
    document.querySelector(".modal-bg").classList.remove("visible");
    document.querySelector(".modal").classList.remove("visible");
});

// 데이터 전송
document.querySelector(".submit-modal").addEventListener("click", function () {
    event.preventDefault(); // form 전송 막는 코드

    let formData = $("#createProject").serializeArray();
    let jsonData = {};

    $(formData).each(function (index, obj) {
        // 줄바꿈을 <br>로 변환
        if (obj.name === "projectInfo") {
            obj.value = obj.value.replace(/\n/g, "<br />");
        }
        jsonData[obj.name] = obj.value;
    });

    // 날짜가 오늘 날짜보다 적으면 안됨.
    let selectDate = new Date(jsonData.exceptTime);
    let today = new Date();
    today.setHours(0, 0, 0, 0);
    if (selectDate < today) {
        alert('선택하신 날짜는 오늘 날짜보다 이전입니다 !');
        document.querySelector(".modal-bg").classList.remove("visible");
        document.querySelector(".modal").classList.remove("visible");
    } else {
        jsonData.skills = [];

        document.querySelectorAll(".selected-skill").forEach((skill) => {
            jsonData.skills.push(skill.id);
        })

        jsonData.recruitRole = [];
        document.querySelectorAll(".selected-role").forEach((role) => {
            jsonData.recruitRole.push(role.id);
        })

        jsonData.ownerId = ownerId;

        $.ajax({
            type: "post",
            url: "/api/project",
            data: JSON.stringify(jsonData),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(res => { // HttpStatus 200번대
            console.log("성공", res);
            let projectId = res.data;
            alert("멤버 모집이 정상적으로 등록되었습니다.")

            window.location.assign(`/project/${projectId}`);
        }).fail(error => { // HttpStatus 200번대가 아닐때
            let errors = Object.values(JSON.parse(JSON.stringify(error.responseJSON.data))).join('\n');
            alert(errors);
        });
    }
});

document.addEventListener("click", function (event) {
    if (
        !event.target.closest(".modal, .open-modal, .open-modal02, .open-modal03")
    ) {
        document.querySelector(".modal").classList.remove("visible");
        document.querySelector(".modal-bg").classList.remove("visible");
        document.body.classList.remove("modal-open");
    }

});

