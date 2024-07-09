$(document).ready(function() {
    $('#findIdForm').on('submit', function(e) {
        e.preventDefault();
        $.ajax({
            type: 'POST',
            url: '/auth/findId',
            data: $(this).serialize(),
            success: function(response) {
                $('body').html(response);  // 서버로부터 받은 스크립트를 실행
            }
        });
    });
});