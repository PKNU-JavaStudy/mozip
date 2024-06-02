// 자기소개 글자 수 세기
const introduceInput = document.getElementById('introduceInput');
const introCount = document.getElementById('introCount');

introduceInput.addEventListener('input', () => {
    const currentLength = introduceInput.value.length;
    introCount.textContent = `${currentLength}/150`;
    // 글자수가 넘어가면 border 색 교체
    if (currentLength >= 150) {
        introduceInput.style.border = "1px solid red";
    } else {
        introduceInput.style.border = "1px solid #D9D9D9";
    }
});

// 깃허브 글자 수 세기
const urlInput = document.getElementById('urlInput');
const linkCount = document.getElementById('charCount');

urlInput.addEventListener('input', () => {
    const currentLength = urlInput.value.length;
    linkCount.textContent = `${currentLength}/50`;
    if (currentLength >= 50) {
        urlInput.style.border = "1px solid red";
    } else {
        urlInput.style.border = "1px solid #D9D9D9";
    }
});

// 기술스택 동적으로 바꾸기
document.addEventListener("DOMContentLoaded", () => {
    const skillSelect = document.getElementById("skill");
    const stackSelect = document.getElementById("stack");
    const profileForm = document.getElementById("profile-form");

    skillSelect.addEventListener("change", () => {
        handleSelectChange(skillSelect, "skill-container");
    });

    stackSelect.addEventListener("change", () => {
        handleSelectChange(stackSelect, "stack-container");
    });

    profileForm.addEventListener("submit", validateForm);

    function handleSelectChange(selectElement, containerId) {
        const selectedValue = selectElement.value;
        const selectedText = selectElement.options[selectElement.selectedIndex].text;
        const selectedIndex = selectElement.selectedIndex;

        if (selectedValue === "all" || selectedValue === "") return; // "전체" 또는 "기술스택 선택"은 처리하지 않음

        // 기존 옵션 제거
        selectElement.remove(selectElement.selectedIndex);

        // 선택된 옵션을 컨테이너에 추가
        const iconContainer = document.getElementById(containerId);
        const icon = document.createElement('div');
        icon.className = 'selected-item';
        icon.id = selectedValue;
        icon.textContent = selectedText;

        const removeBtn = document.createElement('span');
        removeBtn.className = 'remove-btn';
        removeBtn.textContent = 'x';
        removeBtn.onclick = () => {
            iconContainer.removeChild(icon);

            // 옵션을 다시 select에 추가
            const newOption = document.createElement('option');
            newOption.value = selectedValue;
            newOption.text = selectedText;

            // 원래 위치에 다시 추가
            if (selectedIndex >= selectElement.length) {
                selectElement.add(newOption);
            } else {
                selectElement.add(newOption, selectedIndex);
            }

            // 셀렉트 박스 초기화
            selectElement.selectedIndex = 0; // 첫 번째 옵션(기본값)으로 초기화
        };

        icon.appendChild(removeBtn);
        iconContainer.appendChild(icon);

        // 셀렉트 박스 초기화
        selectElement.selectedIndex = 0; // 첫 번째 옵션(기본값)으로 초기화
    }

    function validateForm(event) {
        // 폼 검증 로직을 여기에 추가합니다.
        event.preventDefault();
        alert("폼이 제출되었습니다.");
    }


    function validateForm(event) {
        const skillContainer = document.getElementById('skill-container');
        const stackContainer = document.getElementById('stack-container');
        const careerSelect = document.getElementById('experience-container');

        if (careerSelect.value === "") {
            alert("경력을 선택해주세요.");
            event.preventDefault();
        }
        else if (skillContainer.children.length === 0) {
            alert('적어도 하나의 직군이 선택되어야 합니다.');
            event.preventDefault();
        }
        else if (stackContainer.children.length === 0) {
            alert('적어도 하나의 기술 스택을 선택해야 합니다.');
            event.preventDefault();
        }
        else {
            alert("수정이 완료되었습니다.");
        }
    }
});
