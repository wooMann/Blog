<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        if (${not empty sessionScope.SESSION_USER_ID}) {
            location.href = '/main.do'
        }
    });
</script>
<body>
<form method="POST" action="/loginProc.do">
    메일주소 : <input type="text" name="email">
    비밀번호 : <input type="password" name="password">
    <button type="submit">로그인</button>
    <button type="button" onclick="location.href='/join.do'">가입하러가기</button>
</form>


</body>
</html>
