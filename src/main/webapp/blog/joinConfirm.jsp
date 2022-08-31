
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 확인</title>
</head>
<body>
<form method="POST" action="/joinConfirmProc.do">
    <input type="hidden" name="code" value="${param.code}">
    회원가입을 축하합니다.
    <button type="submit">회원가입 확인</button>
</form>

</body>
</html>
