// TODO : 파일명 수정 필요

// 자기소개 글자 수 세기
const urlInput = document.getElementById('urlInput');
const charCount = document.getElementById('charCount');

urlInput.addEventListener('input', () => {
    const currentLength = urlInput.value.length;
    charCount.textContent = `${currentLength}/100`;
});

// 마이페이지 수정 원하는 직군, 기술 스택 동적으로 띄우기
function addSkillOrRole(selectId, containerId, className) {
    document.getElementById(selectId).addEventListener('change', function () {
        const value = this.value;
        const text = this.options[this.selectedIndex].text;

        // 같은 옵션값을 누르면 삭제
        const existIcon = document.getElementById(value);
        if (existIcon) {
            existIcon.parentNode.removeChild(existIcon);
            this.value = '';
            return;
        }

        // 이미 추가된 경우 중복 추가 방지
        if (document.getElementById(value)) return;

        const iconContainer = document.getElementById(containerId);

        const icon = document.createElement('div');
        icon.className = 'skill';  // 동적으로 설정
        icon.className = 'stack';  // 동적으로 설정
        icon.id = value;
        icon.textContent = text;

        const removeBtn = document.createElement('span');
        removeBtn.className = 'remove';
        removeBtn.textContent = '  x';
        removeBtn.onclick = function () {
            iconContainer.removeChild(icon);
        };

        icon.appendChild(removeBtn);
        iconContainer.appendChild(icon);

        // 셀렉트 박스 초기화
        this.value = '';
    });
}


document.getElementById('profile-form').addEventListener('submit', validateForm);

addSkillOrRole('stack', 'stack-container');
addSkillOrRole('skill', 'skill-container');

// 직군, 스택 필수 선택
function validateForm(event) {
    const careerContainer = document.getElementById('experience-container');
    const skillContainer = document.getElementById('skill-container');
    const stackContainer = document.getElementById('stack-container');

    const careerSelected = careerContainer.querySelector('input[type="radio"]:checked');

    if (!careerSelected) {
        alert("경력칸을 선택해주세요.");
        event.preventDefault();
    }
    if (skillContainer.children.length === 0) {
        alert('적어도 하나의 직군이 선택해야 합니다,.');
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
