// 공유하기
function copyToClipboard() {
    const url = window.location.href;

    const textArea = document.createElement('textarea');
    textArea.value = url;
    document.body.appendChild(textArea);
    textArea.focus();
    textArea.select();

    try {
        document.execCommand('copy');
        console.log('URL 복사 성공');
        alert('URL이 클립보드에 복사되었습니다!');
    } catch (err) {
        console.error('URL 복사 실패: ', err);
        alert('URL 복사에 실패했습니다. 브라우저 콘솔을 확인하세요.');
    }

    document.body.removeChild(textArea);
}

// 프로젝트 참여신청
function projectJoin(projectId) {
    // 현재 로그인한 유저의 ID
    let loginMemberId = document.querySelector(".login-member").textContent;
    let isModify = document.querySelector(".is-modify").textContent;
    let logicCheck = -1;

    // 신청자 목록에서 로그인한 멤버가 있다면 alert() 출력 후 함수 종료
    document.querySelectorAll(".member-id-list").forEach(item => {
        if (item.textContent === loginMemberId)
            logicCheck = 1;
    });

    if (logicCheck == 1)
        alert("이미 신청하셨습니다 !");
    else if(isModify == 0)
        alert("회원정보 수정이 필요합니다!");
    else {
        // 신청한 유저가 아니면 아래 로직이 실행됨.
        $.ajax({
            type: "POST",
            url: "/api/project/join",
            contentType: "application/x-www-form-urlencoded; charset=utr-8",
            data: {"memberId": loginMemberId, "projectId": projectId},
            dataType: "json"
        }).done(res => {
            console.log("통신성공!", res);
            let career;

            if (res.data.career == '1') res.data.career = '학생/취준생';
            else if (res.data.career == '2') res.data.career = '신입';
            else if (res.data.career == '3') res.data.career = '1~3년차';
            else if (res.data.career == '4') res.data.career = '3~5년차';
            else if (res.data.career == '5') res.data.career = '5년이상';
            let item =
                `
                    <div class='application-box'>
                      <div class="profile-top">
                        <div style="display: none;" class="member-id-list">${res.data.id}</div>
                        <img src="/upload/${res.data.profileImageUrl}" alt="프로필이미지">
                        <div>
                          <span class="work">${res.data.position}</span>
                          <span class="career">${res.data.career}</span>
                          <h3>${res.data.username}</h3>
                        </div>
                      </div>
                      <p class="app-date">${res.data.createdAt}</p>
                    </div>
                    `;

            $('.app-wrap').append(item);
        }).fail(error => {
            console.log("통신실패!", error);
        });
    }
}

// 프로젝트 삭제
function deleteProject(projectId) {
    $.ajax({
        type: "DELETE",
        url: "/api/show/" + projectId,
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(res => { // HTTP 상태 코드 200번대일 때 호출됨
        console.log("성공:", res);
        alert("게시글이 성공적으로 삭제되었습니다."); // 서버에서 반환된 메시지 표시
        window.location.replace(`/project`);
    }).fail(error => { // HTTP 상태 코드 200번대가 아닐 때 호출됨
        alert("게시글 삭제를 실패했습니다. 다시 시도해주세요."); // 서버에서 반환된 메시지 대신 고정 메시지 표시
    });
}

// 멤버추가버튼
function memberInvite(memberId, projectId) {
    console.log(memberId);
    $.ajax({
        type: "post",
        url: "/api/email",
        contentType: "application/x-www-form-urlencoded; charset=utr-8",
        data: {"memberId": memberId, "projectId": projectId},
        dataType: "json",
    }).done(res => {
        console.log("통신성공!", res);
        let receiveId = res.data;
        // receiveId 가 1이면 멤버초대 , -1이면 초대한멤버
        if(receiveId == 1)
            alert("이미 초대한 멤버입니다!");
        else
            alert("멤버초대 이메일을 전송하였습니다 !")
    }).fail(error => {
        console.log("통신실패!", error);
        alert("멤버초대를 실패하셨습니다 !");
    });
}

// 프로젝트 모집완료
function recruitDone(projectId) {
    console.log(projectId);
    $.ajax({
        type: "patch",
        url: '/api/recruit/done',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: {"projectId": projectId},
        dataType: "json"
    }).done(res => {
        console.log(res);
        if (res.data == 1) {
            // 모집완료
            $("#btnRecruitDone").css("background-color", "var(--gray-font2)");
            $("#btnRecruitDone").css("color", "color: #fff;");
            $("#btnRecruitDone").text("모집완료");
            $(".state-ing").text("모집완료")
            $("#modalTitle").html("모집완료를 취소하시겠습니까?");
            $("#modalBtn").html("모집완료 취소하기");
            document.querySelector(".modal-bg").classList.remove("visible");
            document.querySelector(".modal").classList.remove("visible");
        } else {
            // 모집완료 취소
            $("#btnRecruitDone").css("background-color", "var(--main-color)");
            $("#btnRecruitDone").css("color", "color: #fff;");
            $("#btnRecruitDone").text("모집완료 하기");
            $(".state-ing").text("모집 중")
            $("#modalTitle").html("모집을 완료하시겠습니까?");
            $("#modalBtn").html("모집 완료하기");
            document.querySelector(".modal-bg").classList.remove("visible");
            document.querySelector(".modal").classList.remove("visible");
        }
    }).fail(error => {
        console.log("통신실패!", error);
    })
}

// 북마크 눌렀을 때 실시간으로 색이 변하게 하는 로직(북마크 중이면 main_color, 북마크를 안하면 색 없음 / 비동기 방식)
function projectBookmark(projectId) {
    let memberId = document.querySelector(".login-member").textContent;
    console.log("memberId:", memberId); // memberId가 올바르게 설정되었는지 확인
    let data = {
        memberId: memberId,
        projectId: projectId
    };

    if (memberId == 0) { // 로그인이 되어있지 않을 때
        alert("로그인이 필요합니다 !");
    } else { // 로그인이 되어있을 때
        // 서버에 북마크 추가/취소 요청
        $.ajax({
            type: "POST",
            url: "/api/keep",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(res => { // HttpStatus 200번대(로드 성공)
            console.log("성공", res);

            if (res.data == 1) { // 서버 응답에 북마크 상태 포함한다고 가정
                // 북마크가 추가된 경우
                if (confirm("북마크를 추가하시겠습니까?")) {
                    $(".keep").css("background-color", "var(--main-color)");
                    $(".keep").css("border", "1px solid var(--main-color)");
                    $(".keep").css("color", "white");
                    $(".keep").html('<i class="fa-regular fa-bookmark" style="color: white;"></i> 북마크');
                    alert("북마크가 추가되었습니다!");
                } else {
                    // 추가 요청을 취소했을 경우, 서버에 취소 요청을 보내야 할 수 있습니다.
                    reverseBookmark(data);
                }
            } else if (res.data == 0) {
                // 북마크가 취소된 경우
                if (confirm("북마크를 취소하시겠습니까?")) {
                    $(".keep").css("background-color", "white");
                    $(".keep").css("color", "var(--main-color)");
                    $(".keep").css("border", "1px solid var(--main-color)");
                    $(".keep").html('<i class="fa-regular fa-bookmark" style="color: var(--main-color);"></i> 북마크');
                    alert("북마크가 취소되었습니다!");
                } else {
                    // 취소 요청을 취소했을 경우, 서버에 추가 요청을 보내야 할 수 있습니다.
                    reverseBookmark(data);
                }
            }
        }).fail(error => { // HttpStatus 200번대가 아닐때(로드 실패)
            console.log(error);
            alert("실패..");
        });
    }
}

// 북마크 추가/취소 요청을 반대로 처리하는 함수
function reverseBookmark(data) {
    data.addBookmark = data.addBookmark ? false : true;

    $.ajax({
        type: "POST",
        url: "/api/keep",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(res => {
        console.log("반대 작업 성공", res);
    }).fail(error => {
        console.log("반대 작업 실패", error);
        alert("작업을 되돌리는 중 실패했습니다.");
    });
}

// 모집완료 모달
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

// 삭제 모달
document.querySelector(".open-modal02").addEventListener("click", function () {
    document.querySelector(".bg02").classList.add("visible");
    document.querySelector(".modal02").classList.add("visible");
});

document.querySelector(".close-modal02-back").addEventListener("click", function () {
    document.querySelector(".bg02").classList.remove("visible");
    document.querySelector(".modal02").classList.remove("visible");
});

document.querySelector(".close-modal02").addEventListener("click", function () {
    document.querySelector(".bg02").classList.remove("visible");
    document.querySelector(".modal02").classList.remove("visible");
});

// 바깥영역 클릭 시 종료
document.addEventListener("click", function (event) {
    if (
        !event.target.closest(".modal, .open-modal, .open-modal02, .modal02")
    ) {
        document.querySelector(".modal").classList.remove("visible");
        document.querySelector(".modal-bg").classList.remove("visible");

        document.querySelector(".modal02").classList.remove("visible");
        document.querySelector(".bg02").classList.remove("visible");

        document.body.classList.remove("modal-open");
    }
});