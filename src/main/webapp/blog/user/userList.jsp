<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../layout/header.jsp"/>
<style>
    html,
    body {
        height: 100%;
    }

    body {
        display: flex;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #ffffff;
    }

    .container {
        width: 1200px;
        max-width: 1200px;
        padding: 15px;
        margin: auto;
    }

    .container table {
        padding: 60px 15px 0;
    }

    .container button[id="createBtn"] {
        width: 200px;
        text-align: center;
        margin: .25rem;
        padding: .5rem 1rem;
        text-decoration: none;
        font-weight: bold;
    }
</style>
<main class="flex-shrink-0">
    <div class="container">
        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>가입일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="userList" items="${userList}" varStatus="status">
                    <tr>
                        <td>
                            <c:choose>
                                <c:when test="${userList.id eq sessionScope.SESSION_USER_ID}">
                                    <a href="/post/edit.do?id=${userList.id}">${userList.email}</a>
                                </c:when>
                                <c:otherwise>
                                    ${userList.email}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${userList.name}</td>
                        <td><fmt:formatDate pattern='MM/dd/yyyy' value='${userList.createdAt}'/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<jsp:include page="../layout/footer.jsp"/>