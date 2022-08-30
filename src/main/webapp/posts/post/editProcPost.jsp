<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/post/createProc.do">
    제목 : <input type="text" name="title" value="${post.title}"><br>

    내용 : <textarea rows="10" cols="50" name="body">${post.body}</textarea><br>
    <button type="button" onclick="location.href='/post/editProc.do'"> 확인</button>
    <button type="button" onclick="location.href='/post/list.do'"> 취소</button>
</form>
</body>
</html>
