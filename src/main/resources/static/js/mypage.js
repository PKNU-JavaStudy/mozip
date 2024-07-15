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

    // 프로젝트 목록
    const visibleProjects = document.querySelectorAll('.pj-content.bookmark[style="display: block;"]');
    const notProjectMessage = document.querySelector('.notproject');

    if (visibleProjects.length === 0) {
        notProjectMessage.style.display = 'block';
    } else {
        notProjectMessage.style.display = 'none';
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
