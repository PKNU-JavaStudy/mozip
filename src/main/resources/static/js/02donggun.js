document.addEventListener('DOMContentLoaded', function () {
    // 기술 스택을 선택하는 select 요소
    const stackSelect = document.getElementById('stack');
    // select 요소의 모든 옵션을 배열로 가져오기
    const options = Array.from(stackSelect.options);
    // 이미 선택된 스킬들을 배열로 가져오기
    const memberSkills = Array.from(document.querySelectorAll("#stack-container .selected-item .projectSkill")).map(item => item.textContent.trim().replace(' x', ''));

    // 기존 옵션에서 이미 선택된 스킬을 제거
    memberSkills.forEach(skill => {
        const optionToRemove = options.find(option => option.text.trim() === skill);
        if (optionToRemove) {
            stackSelect.removeChild(optionToRemove);
        }
    });
});

document.addEventListener("DOMContentLoaded", () => {
    // 자기소개 글자 수 세기
    const introduceInput = document.getElementById('introduceInput');
    const introCount = document.getElementById('introCount');
    const maxIntroLength = 150;

    const updateIntroCount = () => {
        const currentLength = introduceInput.value.length;
        introCount.textContent = `${currentLength}/${maxIntroLength}`;
        if (currentLength > maxIntroLength) {
            introduceInput.style.border = "1px solid red";
        } else {
            introduceInput.style.border = "1px solid #D9D9D9";
        }
    };

    introduceInput.addEventListener('input', updateIntroCount);
    updateIntroCount(); // 초기 로드 시 글자 수 업데이트

    // 깃허브 글자 수 세기
    const urlInput = document.getElementById('urlInput');
    const linkCount = document.getElementById('charCount');
    const maxUrlLength = 50;

    const updateUrlCount = () => {
        const currentLength = urlInput.value.length;
        linkCount.textContent = `${currentLength}/${maxUrlLength}`;
        if (currentLength > maxUrlLength) {
            urlInput.style.border = "1px solid red";
        } else {
            urlInput.style.border = "1px solid #D9D9D9";
        }
    };

    urlInput.addEventListener('input', updateUrlCount);
    updateUrlCount(); // 초기 로드 시 글자 수 업데이트

    // 기술스택 동적으로 바꾸기
    const stackSelect = document.getElementById("stack");
    const profileForm = document.getElementById("profile-form");

    stackSelect.addEventListener("change", () => {
        handleStackSelectChange(stackSelect, "stack-container");
    });

    profileForm.addEventListener("submit", validateForm);

    function handleStackSelectChange(selectElement, containerId) {
        const selectedValue = selectElement.value;
        const selectedText = selectElement.options[selectElement.selectedIndex].text;
        const selectedIndex = selectElement.selectedIndex;

        if (selectedValue === "all" || selectedValue === "") return; // "전체" 또는 "기술스택 선택"은 처리하지 않음

        // 기존 옵션 제거
        selectElement.remove(selectElement.selectedIndex);

        // 선택된 옵션을 컨테이너에 추가
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

            // 옵션을 다시 select에 추가 (중복 확인)
            const newOption = document.createElement('option');
            newOption.value = selectedValue;
            newOption.text = selectedText;

            // 원래 위치에 다시 추가
            const existingOption = Array.from(selectElement.options).find(option => option.value === selectedValue);
            if (!existingOption) {
                selectElement.add(newOption, selectedIndex);
            }

            // 셀렉트 박스 초기화
            selectElement.selectedIndex = 0; // 첫 번째 옵션(기본값)으로 초기화
        };

        outer.appendChild(icon);
        outer.appendChild(removeBtn);
        iconContainer.appendChild(outer);

        // 셀렉트 박스 초기화
        selectElement.selectedIndex = 0; // 첫 번째 옵션(기본값)으로 초기화
    }

    function validateForm(event) {
        const skillContainer = document.getElementById('skill-container');
        const stackContainer = document.getElementById('stack-container');
        const careerSelect = document.getElementById('experience-container');

        if (careerSelect.value === "") {
            alert("경력을 선택해주세요.");
            event.preventDefault();
        } else if (skillContainer.children.length === 0) {
            alert('적어도 하나의 직군이 선택되어야 합니다.');
            event.preventDefault();
        } else if (stackContainer.children.length === 0) {
            alert('적어도 하나의 기술 스택을 선택해야 합니다.');
            event.preventDefault();
        } else {
            alert("수정이 완료되었습니다.");
        }
    }
});

// 기술 스택 제거 함수
function removeSkill(element) {
    const icon = element.parentElement;
    const iconContainer = icon.parentElement;
    const stackSelect = document.getElementById("stack");

    // 옵션을 다시 select에 추가
    const newOption = document.createElement('option');
    newOption.value = icon.id;
    newOption.text = icon.textContent.replace(" x", '').trim();

    // select에 옵션 추가 (중복 확인)
    const existingOption = Array.from(stackSelect.options).find(option => option.value === newOption.value);
    if (!existingOption) {
        stackSelect.add(newOption);
    }

    // 아이콘 제거
    iconContainer.removeChild(icon);

    // 셀렉트 박스 초기화
    stackSelect.selectedIndex = 0; // 첫 번째 옵션(기본값)으로 초기화
}
