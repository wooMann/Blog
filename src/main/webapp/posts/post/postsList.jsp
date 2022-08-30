
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table  style="text-align: center">
    <colgroup>
        <col width="50px">
        <col width="180px">
        <col width="200px">
        <col width="100px">

    </colgroup>
    <thead>
    <tr>
        <th><input type="checkbox" name="checked_all"/></th>
        <th>제목</th>
        <th>작성자</th>
        <th>날짜</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="postList" items="${postList}" >
        <tr>
            <td class="txt-center">
                <input type="checkbox" id="id" name="idx[]" value="${postList.id}"/>
            </td>
            <td><a href="/post/edit.do?id=${postList.id}">${postList.title}</a></td>
            <td>${postList.user.name}</td>
            <td>${postList.createdAt}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<button type="button" onclick="location.href = '/post/create.do'"> 글쓰러가기 </button>
</body>
</html>
