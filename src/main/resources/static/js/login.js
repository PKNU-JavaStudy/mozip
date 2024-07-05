// URLSearchParams를 사용하여 URL의 쿼리 파라미터를 파싱합니다.
const params = new URLSearchParams(window.location.search);
const error = params.get('error');
const message = params.get('message');

// error가 true이면 alert로 메시지를 표시합니다.
if (error) {
    alert(decodeURIComponent(message));
}