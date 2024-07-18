// 필터링 함수
function filterProjects(filterValue) {
    const projects = document.querySelectorAll('.pj-content.bookmark');
    let visibleCount = 0; // 표시되는 프로젝트의 수

    projects.forEach(project => {
        const status = project.getAttribute('data-status');

        // 전체
        if (filterValue === 'all') {
            project.style.display = 'block';
            visibleCount++;
        }
        // 모집완료
        else if (filterValue === '0') {
            if (status === '0') {
                project.style.display = 'block';
                visibleCount++;
            } else {
                project.style.display = 'none';
            }
        }
        // 모집중
        else if (filterValue === '1') {
            if (status === '1') {
                project.style.display = 'block';
                visibleCount++;
            } else {
                project.style.display = 'none';
            }
        }
    });

    // 북마크한 프로젝트가 없을 때 메시지 표시
    const notProjectMessage = document.querySelector('.notbookmark');
    // 북마크한 프로젝트가 없다면
    if (visibleCount === 0) {
        if (!notProjectMessage) {
            const messageDiv = document.createElement('div');
            messageDiv.className = 'notbookmark';
            messageDiv.innerHTML = '<p><i class="fa-solid fa-circle-exclamation"></i> 북마크한 프로젝트가 아직 없습니다</p>';
            document.querySelector('.keep').appendChild(messageDiv);
            // 북마크한 프로젝트가 있다면 스타일을 block으로
        } else {
            notProjectMessage.style.display = 'block';
        }
        // 북마크한 프로젝트가 있다면
    } else {
        // 메시지를 none
        if (notProjectMessage) {
            notProjectMessage.style.display = 'none';
        }
    }

    // 북마크한 글의 갯수 표시
    document.querySelector('.bookmark-count').textContent = visibleCount;
}

// 필터 선택시 핸들러
function handleBookmarkFilter(event) {
    let selectedValue = event.target.value;
    filterProjects(selectedValue);
}

// 초기 로드 시 전체 북마크 프로젝트를 표시
document.addEventListener('DOMContentLoaded', function() {
    filterProjects('all');
});
