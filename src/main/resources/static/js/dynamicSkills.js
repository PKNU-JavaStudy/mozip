document.addEventListener("DOMContentLoaded", () => {
    const skillSelect = document.getElementById("skill");
    const maxSkills = 6;

    skillSelect.addEventListener("change", () => {
        handleSelectChange(skillSelect, "skill-container");
    });

    function handleSelectChange(selectElement, containerId) {
        const selectedValue = selectElement.value;
        const selectedText = selectElement.options[selectElement.selectedIndex].text;
        const selectedIndex = selectElement.selectedIndex;

        if (selectedValue === "all") return; // "전체" 또는 "기술스택 선택"은 처리하지 않음

        const iconContainer = document.getElementById(containerId);
        const currentCount = iconContainer.getElementsByClassName('selected-skill').length;

        // 모집 기술스택 6개로 제한
        if (currentCount >= maxSkills) {
            alert("모집글의 최대 기술스택은 6개 입니다 !");
            selectElement.value = "all";
            return;
        }

        // 기존 옵션 제거
        selectElement.remove(selectElement.selectedIndex);

        // 선택된 옵션을 컨테이너에 추가
        const icon = document.createElement('div');
        icon.textContent = selectedText;
        icon.className = 'selected-skill';
        icon.id = selectedValue;

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