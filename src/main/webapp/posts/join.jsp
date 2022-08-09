
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/joinProc.do">
    메일주소 : <input type="text" name="email">
    비밀번호 : <input type="password" name="password">
    이름 : <input type="text" name="name">
    <button type="submit">가입하기</button>
    <button type="button" onclick="location.href='/login.do'">로그인으로</button>
</form>

</body>
</html>
