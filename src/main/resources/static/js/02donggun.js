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

    const introduceInput = document.getElementById('introduceInput');
    const introCount = document.getElementById('introCount');
    const maxIntroLength = 150;

    const updateIntroCount = () => {
        const currentLength = introduceInput.value.length;
        introCount.textContent = `${currentLength}/${maxIntroLength}`;
        if (currentLength >= maxIntroLength) {
            introduceInput.style.border = "1px solid red";
        } else {
            introduceInput.style.border = "1px solid #D9D9D9";
        }
    };

    introduceInput.addEventListener('input', updateIntroCount);
    updateIntroCount();

    const urlInput = document.getElementById('urlInput');
    const charCount = document.getElementById('charCount');
    const maxUrlLength = 50;

    const updateUrlCount = () => {
        const currentLength = urlInput.value.length;
        charCount.textContent = `${currentLength}/${maxUrlLength}`;
        if (currentLength >= maxUrlLength) {
            urlInput.style.border = "1px solid red";
        } else {
            urlInput.style.border = "1px solid #D9D9D9";
        }
    };

    urlInput.addEventListener('input', updateUrlCount);
    updateUrlCount();

    const submitButton = document.getElementById("mypage-button");

    submitButton.addEventListener("click", function (event) {
        event.preventDefault();
        if (validateForm()) {
            // 유효성 검사를 통과하면 AJAX 요청
            sendFormData();
        }
    });

    stackSelect.addEventListener("change", () => {
        handleStackSelectChange(stackSelect, "stack-container");
    });
});

function handleStackSelectChange(selectElement, containerId) {
    const selectedValue = selectElement.value;
    const selectedText = selectElement.options[selectElement.selectedIndex].text;

    if (selectedValue === "all" || selectedValue === "") return;

    selectElement.remove(selectElement.selectedIndex);

    const iconContainer = document.getElementById(containerId);
    let outer = document.createElement('div');
    outer.className = 'selected-item';

    const icon = document.createElement('span');
    icon.className = 'projectSkill';
    icon.id = selectedValue;
    icon.textContent = selectedText;

    const removeBtn = document.createElement('span');
    removeBtn.className = 'remove-btn';
    removeBtn.textContent = ' x';
    removeBtn.onclick = () => {
        iconContainer.removeChild(outer);

        const newOption = document.createElement('option');
        newOption.value = selectedValue;
        newOption.text = selectedText;

        const existingOption = Array.from(selectElement.options).find(option => option.value === selectedValue);
        if (!existingOption) {
            selectElement.add(newOption);
        }

        selectElement.selectedIndex = 0;
    };

    outer.appendChild(icon);
    outer.appendChild(removeBtn);
    iconContainer.appendChild(outer);

    selectElement.selectedIndex = 0;
}

function validateForm() {
    const stackContainer = document.getElementById('stack-container');
    const careerSelect = document.getElementById('experience-container');
    const introduceInput = document.getElementById('introduceInput');
    const urlInput = document.getElementById('urlInput');
    const positionSelect = document.getElementById('skill');

    let valid = true;

    if (careerSelect.value === "") {
        alert("경력을 선택해주세요.");
        valid = false;
    }

    if (positionSelect.value === "") {
        alert('직군을 선택해주세요.');
        valid = false;
    }

    if (stackContainer.querySelectorAll('.selected-item').length === 0) {
        alert('적어도 하나의 기술 스택을 선택해야 합니다.');
        valid = false;
    }

    if (introduceInput.value.length >= 150) {
        alert("자기소개는 150자 이내로 입력해주세요.");
        introduceInput.style.border = "1px solid red";
        valid = false;
    }

    if (urlInput.value.length >= 50) {
        alert("깃허브 링크는 50자 이내로 입력해주세요.");
        urlInput.style.border = "1px solid red";
        valid = false;
    }

    return valid;
}

function sendFormData() {
    let formData = $("#profile-form").serializeArray();
    console.log(formData);

    let id = document.querySelector("#userId").value;
    let email = document.querySelector("#email").value;
    let career = document.querySelector("#experience-container").value;
    let githubLink = document.querySelector("#urlInput").value;
    let position = document.querySelector("#skill").value;
    let info = document.querySelector("#introduceInput").value;

    let jsonData = {};
    jsonData.memberId = id;
    jsonData.email = email;
    jsonData.career = career;
    jsonData.githubLink = githubLink;
    jsonData.position = position;
    jsonData.info = info;

    let skills = [];

    document.querySelectorAll(".projectSkill").forEach(item => {
        skills.push(item.textContent);
    });

    jsonData.skills = skills;

    console.log(jsonData);

    $.ajax({
        type: "post",
        url: "/api/member/edit",
        data: JSON.stringify(jsonData),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(res => {
        console.log("성공", res);
        window.location.href = "/member/" + id;
    }).fail(error => {
        console.log("실패", error);
    });
}