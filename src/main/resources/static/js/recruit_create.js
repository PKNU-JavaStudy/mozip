document.addEventListener("DOMContentLoaded", () => {
    const titleInput = document.getElementById("titleInput");
    const titleCount = document.getElementById("titleCount");
    const subjectInput = document.getElementById("subject");
    const subjectCount = document.getElementById("subjectCount");
    const infoCount = document.getElementById("infoCount");
    const infoInput = document.getElementById("infoInput");
    const titleMaxLength = 50;
    const subjectMaxLength = 40;
    const infoMaxLength = 500;

    // 제목 글자수 실시간 체크
    const updateTitleCount = () => {
        const currentLength = titleInput.value.length;
        titleCount.textContent = `${currentLength}/${titleMaxLength}`;
        if (currentLength > titleMaxLength) {
            titleInput.style.border = "1px solid red";
        } else {
            titleInput.style.border = "1px solid #D9D9D9";
        }
        console.log(currentLength);
    };

    // 주제 글자수 실시간 체크
    const updateSubjectCount = () => {
        const currentLength = subjectInput.value.length;
        subjectCount.textContent = `${currentLength}/${subjectMaxLength}`;
        if (currentLength > subjectMaxLength) {
            subjectInput.style.border = "1px solid red";
        } else {
            subjectInput.style.border = "1px solid #D9D9D9";
        }
        console.log(currentLength);
    };

    // 소개 글자수 실시간 체크
    const updateInfoCount = () => {
        const currentLength = infoInput.value.length;
        infoCount.textContent = `${currentLength}/${infoMaxLength}`;
        if (currentLength > infoMaxLength) {
            infoInput.style.border = "1px solid red";
        } else {
            infoInput.style.border = "1px solid #D9D9D9";
        }
        console.log(currentLength);
    };

    titleInput.addEventListener('input', updateTitleCount);
    subjectInput.addEventListener('input', updateSubjectCount);
    infoInput.addEventListener('input', updateInfoCount);

    updateTitleCount();
    updateSubjectCount();
    updateInfoCount();

    let ownerId = document.querySelector(".owner-id").textContent;

    // 프로젝트 주제(textarea) : 1줄만 쓰게 제한
    subjectInput.addEventListener('keydown', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
        }
    });

    // 프로젝트 주제(textarea) 입력 칸 : 40자 글자 제한
    subjectInput.addEventListener('input', function () {
        if (this.value.length > 40) {
            this.value = this.value.slice(0, 40);
        }
        console.log(this.value.length);
    });

    // 프로젝트 소개(textarea) 입력 칸 : 500자 글자 제한
    infoInput.addEventListener('input', function () {
        if (this.value.length > 500) {
            this.value = this.value.slice(0, 500);
        }
        console.log(this.value.length);
    });

    document.querySelector(".open-modal").addEventListener("click", function () {
        document.querySelector(".modal-bg").classList.add("visible");
        document.querySelector(".modal").classList.add("visible");
    });

    document.querySelector(".close-modal").addEventListener("click", function () {
        document.querySelector(".modal-bg").classList.remove("visible");
        document.querySelector(".modal").classList.remove("visible");
    });

    document.querySelector(".submit-modal").addEventListener("click", function (event) {
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
            });

            jsonData.recruitRole = [];
            document.querySelectorAll(".selected-role").forEach((role) => {
                jsonData.recruitRole.push(role.id);
            });

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
                alert("멤버 모집이 정상적으로 등록되었습니다.");

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
});
