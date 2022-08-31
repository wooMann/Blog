<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>
<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/main.do">Woo</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/post/list.do">POST</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/list.do">USER</a>
                    </li>
                </ul>

                <c:if test="${sessionScope.SESSION_USER_ID == null}">
                    <button class="btn btn-outline-success m-1" type="button" onclick="location.href='/login.do'">
                        로그인
                    </button>
                    <button class="btn btn-outline-danger m-1" type="button" onclick="location.href='/join.do'">
                        회원가입
                    </button>
                </c:if>

                <c:if test="${sessionScope.SESSION_USER_ID != null}">
                    <input type="hidden" id="id" value="${sessionScope.SESSION_USER_ID}">
                    ${sessionScope.SESSION_USER_NAME} 님 환영 합니다.
                    <button type="button" class="btn btn-outline-warning m-1"
                            onclick="location.href='/user/edit.do?id=${sessionScope.SESSION_USER_ID}'">회원정보
                    </button>
                    <button type="button" class="btn btn-outline-danger m-1" onclick="location.href='/logout.do'">로그아웃
                    </button>
                </c:if>
            </div>
        </div>
    </nav>
</header>


