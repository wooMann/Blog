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
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="post" items="${postList}" varStatus="status">
                    <tr>
                        <td>${post.id}</td>
                        <td><a href="/post/edit.do?id=${post.id}">${post.title}</a></td>
                        <td>${post.user.name}</td>
                        <td><fmt:formatDate pattern='MM/dd/yyyy' value='${post.createdAt}'/></td>
                    </tr>
                </c:forEach>
                </tbody>



            </table>
            <c:if test="${sessionScope.SESSION_USER_ID ne null}">
                <tr align="right">
                    <td>
                        <button class="btn btn-outline-info" type="button" id="createBtn" onclick="location.href='/post/create.do'">
                            글쓰기
                        </button>
                    </td>
                </tr>
            </c:if>

        </div>
    </div>
</main>
<jsp:include page="../layout/footer.jsp"/>