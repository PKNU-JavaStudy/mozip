// 공유하기 버튼
function copyToClipboard() {
    const url = window.location.href;
    navigator.clipboard.writeText(url).then(() => {
        alert('URL이 클립보드에 복사되었습니다 !');
    }).catch(err => {
        console.error('URL 복사 실패: ', err);
    });
}

// 좋아요 수 실시간으로 증감하는 로직(비동기 방식)
function projectLike(projectId) {
    let memberId = document.querySelector(".loginMember").textContent;
    let data = {};
    data.memberId = memberId;
    data.projectId = projectId;
    // data.key = value -> data{ key: value}

    if (memberId == 0)   // 로그인이 되어있지 않을 때
        alert("로그인이 필요합니다 !");
    else {       // 로그인이 되어있을 때
        // 좋아요 로직 시작
        $.ajax({
            type: "POST",
            url: "/api/like",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(res => { // HttpStatus 200번대(로드 성공)
            let likeCount = res.data;// 서버에서 최종 세팅된 좋아요수

            $("#topLiveLike").text(likeCount + '개')
            $("#liveLike").text(likeCount); // Id값이 liveLike 인 태그의 자식 요소에 text 값을 삽입

        }).fail(error => { // HttpStatus 200번대가 아닐때(로드 실패)
            console.log(error);
            alert(error.responseJSON.msg);
        });
    }
}

// 북마크 눌렀을 때 실시간으로 색이 변하게 하는 로직(북마크 중이면 main_color, 북마크를 안하면 색 없음 / 비동기 방식)
function projectBookmark(projectId) {
    let memberId = document.querySelector(".loginMember").textContent;
    console.log("memberId:", memberId); // memberId가 올바르게 설정되었는지 확인
    let data = {};
    data.memberId = memberId;
    data.projectId = projectId;
    // data.key = value -> data{ key: value}

    if (memberId == 0)   // 로그인이 되어있지 않을 때
        alert("로그인이 필요합니다 !");
    else {       // 로그인이 되어있을 때
        // 북마크 로직 시작
        $.ajax({
            type: "POST",
            url: "/api/keep",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(res => { // HttpStatus 200번대(로드 성공)
            console.log("성공");

            if (res.data == 1) { // 서버 응답에 북마크 상태 포함한다고 가정
                // 북마크가 추가된 경우
                $(".keep").css("background-color", "var(--main-color)");
                $(".keep").css("border", "1px solid var(--main-color)");
                $(".keep").css("color", "white");
                $(".keep").html('<i class="fa-regular fa-bookmark" style="color: white;"></i> 북마크');
                alert("북마크가 추가되었습니다!");
            } else if (res.data == 0) {
                // 북마크가 취소된 경우
                $(".keep").css("background-color", "white");
                $(".keep").css("color", "var(--main-color)");
                $(".keep").css("border", "1px solid var(--main-color)");
                $(".keep").html('<i class="fa-regular fa-bookmark" style="color: var(--main-color);"></i> 북마크');

                alert("북마크가 취소되었습니다!");
            }

        }).fail(error => { // HttpStatus 200번대가 아닐때(로드 실패)

            console.log(error);
            alert("실패..");
        });
    }
}

document.querySelector(".open-modal").addEventListener("click", function () {
    document.querySelector(".modal-bg").classList.add("visible");
    document.querySelector(".modal").classList.add("visible");
});

document.querySelector(".close-modal").addEventListener("click", function () {
    document.querySelector(".modal-bg").classList.remove("visible");
    document.querySelector(".modal").classList.remove("visible");
});

document.querySelector(".close-modal-back").addEventListener("click", function () {
    document.querySelector(".modal-bg").classList.remove("visible");
    document.querySelector(".modal").classList.remove("visible");
});

document.addEventListener("click", function (event) {
    if (
        !event.target.closest(".modal, .open-modal, .open-modal02, .modal02")
    ) {
        document.querySelector(".modal").classList.remove("visible");
        document.querySelector(".modal-bg").classList.remove("visible");

        document.body.classList.remove("modal-open");
    }
});

// 프로젝트 자랑 삭제
function ajaxDelete(projectId) {
    $.ajax({
        type: "DELETE",
        url: "/api/show/" + projectId,
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(res => { // HTTP 상태 코드 200번대일 때 호출됨
        console.log("성공:", res);
        alert("게시글이 성공적으로 삭제되었습니다."); // 서버에서 반환된 메시지 표시
        window.location.replace(`/project/show`);
    }).fail(error => { // HTTP 상태 코드 200번대가 아닐 때 호출됨
        alert("게시글 삭제를 실패했습니다. 다시 시도해주세요."); // 서버에서 반환된 메시지 대신 고정 메시지 표시
    });
}