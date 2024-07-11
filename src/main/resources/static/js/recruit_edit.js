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
        titleInput.style.border = currentLength > titleMaxLength ? "1px solid red" : "1px solid #D9D9D9";
        console.log(currentLength);
    };

    // 주제 글자수 실시간 체크
    const updateSubjectCount = () => {
        const currentLength = subjectInput.value.length;
        subjectCount.textContent = `${currentLength}/${subjectMaxLength}`;
        subjectInput.style.border = currentLength > subjectMaxLength ? "1px solid red" : "1px solid #D9D9D9";
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

    document.querySelector('.submit-modal').addEventListener("click", function (event) {
        event.preventDefault(); // form 전송 막는 코드
        let formData = $("#editProject").serializeArray();
        let jsonData = {};

        $(formData).each(function (index, obj) {
            jsonData[obj.name] = obj.value;
        });

        // 날짜가 오늘 날짜보다 적으면 안됨.
        let selectDate = new Date(jsonData.exceptChangeTime);
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

            $.ajax({
                type: "patch",
                url: `/api/project/update`,
                data: JSON.stringify(jsonData),
                contentType: "application/json; charset=utf-8",
                dataType: "json"
            }).done(res => {
                console.log("통신성공", res);
                alert("멤버 모집이 정상적으로 수정되었습니다.");
                let projectId = res.data;
                window.location.assign(`/project/${projectId}`);
            }).fail(error => {
                let errors = Object.values(JSON.parse(JSON.stringify(error.responseJSON.data))).join('\n');
                alert(errors);
            });
        }
    });

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

    document.addEventListener("click", function (event) {
        if (!event.target.closest(".modal, .open-modal, .open-modal02, .open-modal03")) {
            document.querySelector(".modal").classList.remove("visible");
            document.querySelector(".modal-bg").classList.remove("visible");
            document.body.classList.remove("modal-open");
        }
    });
});
