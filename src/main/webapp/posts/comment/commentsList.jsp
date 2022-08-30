<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<div class="card"> <!--댓글쓰기 창-->
    <form action="@{/auth/commentswrite}" method="post">
        <input type="hidden" id="comentuserid" name="comentuserid" value="${session.userinfo.id}"/>
        <input type="hidden" id="comentpostid" name="comentpostid" value="${post.id}"/>
        <div class="card-body">
            <textarea id="reply-content" name="comentcontent" class="form-control" rows="1"> </textarea>
        </div>
        <div class="card-footer">
            <button type="submit" class="btn btn-primary">등록</button>
        </div>
    </form>
</div>

<div class="card">
    <div class="card-header"> 댓글 목록</div>

    <ul id="reply-box" class="list-group">
        <c:forEach var="comments" items="${post.comments}">
            <tr>
                <li class="list-group-item d-flex justify-content-between">
                    <div text="${comments.comment}"></div>
                    <div class="d-flex">
                        <div class="font-italic"><span>작성자 : <i text=${comments.user.username}></i></span> &nbsp;
                        </div>

                        <!--   <tr th:if= "${comments.user.id == authinfo.user.id}"> &lt;!&ndash;댓글작성유저만 삭제버튼이 나오게한다&ndash;&gt;
                                   <button onclick="index.replyDelete(${board.id},${reply.id})" class="badge">삭제</button>
                               </tr>-->
                    </div>
                </li>
            <tr>
        </c:forEach>
    </ul>

</div>
</body>
</html>
