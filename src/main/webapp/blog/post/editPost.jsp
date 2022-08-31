<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    제목 : <input type="text" name="title" value="${post.title}" readonly ><br>

    내용 : <textarea rows="10" cols="50" name="body" readonly>${post.body}</textarea><br>

    <c:if test="${post.id eq sessionScope.SESSION_USER_ID}">
        <button type="button" onclick="location.href='/post/editProc.do'"> 수정하기 </button>
    </c:if>
    <button type="button" onclick="location.href='/post/list.do'"> 뒤로가기 </button>
</body>
</html>
