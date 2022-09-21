<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<style>
    .form-userEdit {
        width: 600px;
        max-width: 600px;
        padding: 15px;
        margin: auto;
    }

    .form-userEdit .form-floating:focus-within {
        z-index: 2;
    }

    .form-userEdit input[id="email"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    .form-userEdit input[id="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    .form-userEdit input[id="name"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        if (${not empty sessionScope.SESSION_USER_ID}) {
            location.href = '/main.do'
        }
    });
</script>
<jsp:include page="layout/header.jsp"/>


<main class="form-userEdit">
    <div class="container">
        <h3 class="text-center">회원정보</h3>

        <form id="user_edit_form" method="post" action="/loginProc.do">
            <div class="form-floating">
                <input type="text" class="form-control rounded" id="email" name="email" value="">
                <label for="email">Email Address</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control rounded" id="password" name="password">
                <label for="password">Password</label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
            <button class="w-100 btn btn-lg btn-success" type="button" onclick="location.href='/join.do'">회원가입</button>

        </form>
    </div>
</main>
<jsp:include page="layout/footer.jsp"/>

