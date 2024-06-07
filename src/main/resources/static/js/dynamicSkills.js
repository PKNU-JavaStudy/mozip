// 기술스택 동적으로 바꾸기
document.addEventListener("DOMContentLoaded", () => {
    const skillSelect = document.getElementById("skill");
    const roleSelect = document.getElementById("role");
    const profileForm = document.getElementById("profile-form");

    skillSelect.addEventListener("change", () => {
        handleSelectChange(skillSelect, "skill-container");
    });

    roleSelect.addEventListener("change", () => {
        handleSelectChange(roleSelect, "role-container");
    });

    profileForm.addEventListener("submit", validateForm);

    function handleSelectChange(selectElement, containerId) {
        const selectedValue = selectElement.value;
        const selectedText = selectElement.options[selectElement.selectedIndex].text;
        const selectedIndex = selectElement.selectedIndex;

        if (selectedValue === "all") return; // "전체" 또는 "기술스택 선택"은 처리하지 않음

        // 기존 옵션 제거
        selectElement.remove(selectElement.selectedIndex);

        // 선택된 옵션을 컨테이너에 추가
        const iconContainer = document.getElementById(containerId);
        const icon = document.createElement('div');
        icon.textContent = selectedText;
        // containerId에 따라 클래스를 설정
        if (containerId === "skill-container") {
            icon.className = 'selected-skill';
        } else if (containerId === "role-container") {
            icon.className = 'selected-role';
        }
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
            selectElement.add(newOption, selectedIndex);

            // 셀렉트 박스 초기화
            selectElement.value = "all";
        };

        icon.appendChild(removeBtn);
        iconContainer.appendChild(icon);

        // 셀렉트 박스 초기화
        selectElement.value = "all";
    }

});