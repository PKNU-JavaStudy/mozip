

// function handleStackSelectChange(selectElement, containerId) {
//     const selectedValue = selectElement.value;
//     const selectedText = selectElement.options[selectElement.selectedIndex].text;
//
//     if (selectedValue === "all" || selectedValue === "") return;
//
//     selectElement.remove(selectElement.selectedIndex);
//
//     const iconContainer = document.getElementById(containerId);
//     let outer = document.createElement('div');
//     outer.className = 'selected-item';
//
//     const icon = document.createElement('span');
//     icon.className = 'projectSkill';
//     icon.id = selectedValue;
//     icon.textContent = selectedText;
//
//     const removeBtn = document.createElement('span');
//     removeBtn.className = 'remove-btn';
//     removeBtn.textContent = ' x';
//     removeBtn.onclick = () => {
//         iconContainer.removeChild(outer);
//
//         const newOption = document.createElement('option');
//         newOption.value = selectedValue;
//         newOption.text = selectedText;
//
//         const existingOption = Array.from(selectElement.options).find(option => option.value === selectedValue);
//         if (!existingOption) {
//             selectElement.add(newOption);
//         }
//
//         selectElement.selectedIndex = 0;
//     };
//
//     outer.appendChild(icon);
//     outer.appendChild(removeBtn);
//     iconContainer.appendChild(outer);
//
//     selectElement.selectedIndex = 0;
// }

// function validateForm() {
//     const stackContainer = document.getElementById('stack-container');
//     const careerSelect = document.getElementById('experience-container');
//     const introduceInput = document.getElementById('introduceInput');
//     const urlInput = document.getElementById('urlInput');
//     const positionSelect = document.getElementById('skill');
//
//     let valid = true;
//
//     if (careerSelect.value === "") {
//         alert("경력을 선택해주세요.");
//         valid = false;
//     }
//
//     if (positionSelect.value === "") {
//         alert('직군을 선택해주세요.');
//         valid = false;
//     }
//
//     if (stackContainer.querySelectorAll('.selected-item').length === 0) {
//         alert('적어도 하나의 기술 스택을 선택해야 합니다.');
//         valid = false;
//     }
//
//     if (introduceInput.value.length >= 150) {
//         alert("자기소개는 150자 이내로 입력해주세요.");
//         introduceInput.style.border = "1px solid red";
//         valid = false;
//     }
//
//     if (urlInput.value.length >= 50) {
//         alert("깃허브 링크는 50자 이내로 입력해주세요.");
//         urlInput.style.border = "1px solid red";
//         valid = false;
//     }
//
//     return valid;
// }