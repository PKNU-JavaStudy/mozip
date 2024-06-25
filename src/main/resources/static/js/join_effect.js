$(document).ready(function () {
    const emailPattern = /^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/; // 이메일 정규식
    const phoneNumberPattern = /^010\d{8}$/; // 휴대폰 번호 정규식

    // 모두 동의 체크박스
    function toggleAll(source) {
        const checkboxes = $('input[type="checkbox"]');
        checkboxes.prop('checked', source.checked);
    }

    // 이메일, 전화번호 및 비밀번호 확인 유효성 검사
    function checkFieldValidity(input) {
        let isValid = true;
        const value = input.val().trim();

        if (input.attr("id") === "email") {
            isValid = emailPattern.test(value);
        } else if (input.attr("id") === "phone-number") {
            isValid = phoneNumberPattern.test(value);
        } else if (input.attr("id") === "confirm-password") {
            const password = $("#password").val().trim();
            isValid = (password === value);
        }

        if (isValid) {
            input.css("border-color", "#c3c3c3");
        } else {
            input.css("border-color", "red");
        }
    }

    $('#agreeAll').change(function () {
        toggleAll(this);
    });

    $('#email, #phone-number, #confirm-password').on('input', function () {
        checkFieldValidity($(this));
    });

    $('#signup-form').submit(function (event) {
        event.preventDefault(); // 폼 제출 막기

        const email = $('#email').val().trim();
        const phoneNumber = $('#phone-number').val().trim();
        const password = $('#password').val().trim();
        const confirmPassword = $('#confirm-password').val().trim();

        const requiredCheckboxes = $('.required');
        const allChecked = requiredCheckboxes.toArray().every(checkbox => checkbox.checked);

        if (!allChecked) {
            alert("모든 필수 항목에 동의해 주세요 !");
            return;
        }

        if (!emailPattern.test(email)) {
            alert("이메일 형식이 아닙니다 !");
            return;
        }

        if (!phoneNumberPattern.test(phoneNumber)) {
            alert("휴대폰 번호 형식이 아닙니다 !");
            return;
        }

        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다 !");
            return;
        }

        // AJAX 요청으로 폼 데이터 전송
        const formData = {
            email: email,
            password: password,
            username: $('#name').val().trim(),
            phone: phoneNumber
        };

        console.log("전송할 데이터: ", formData); // 서버로 전송되는 데이터 확인용 로그

        $.ajax({
            type: "POST",
            url: "/auth/join",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formData),
            dataType: "json",
            success: function (response) {
                if (response.success) {
                    alert("회원가입이 완료되었습니다 !");
                    window.location.assign(`/auth/login`)
                }
            },
            error: function (xhr, status, error) {
                console.log("Error:", xhr.responseJSON.msg);
                alert(xhr.responseJSON.msg);
            }
        });
    });
});
