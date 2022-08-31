<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="card-body">

    <form class="form-horizontal" action="/comment/createProc.do" name="create_comment" method="POST">
        <input type="hidden" id="postId" name="post_id" value="${param.id}">
        <input type="hidden" id="userId" name="user_id" value="${sessionScope.SESSION_USER_ID}">
        <input type="hidden" id="userIp" name="user_ip" value="${user_ip}">
        <div class="row">
            <div class="form-group col-sm-9">
                <input class="form-control input-sm" id="body" name="body" type="text" placeholder="댓글 입력...">
            </div>
            <c:if test="${sessionScope.SESSION_USER_ID eq null}">
                <div class="form-group col-sm-2">
                    <c:set var="userIp" value="${user_ip}"/>
                    <input class="form-control input-sm" type="text" readonly
                           value="${userIp}" style="background-color: #b9bbbe">
                </div>
            </c:if>
            <div class="form-group col-sm-1">
                <button type="submit" class="btn btn-outline-primary btn-block ">
                    <i class="fa fa-save"></i> 저장
                </button>
            </div>

        </div>
    </form>

</div>

<div class="card card-primary card-outline">
    <div class="card-header">
        <a href="" class="link-black text-lg"><i class="fas fa-comments margin-r-5 replyCount"></i></a>
        <div class="card-tools">
            <button type="button" class="btn primary" data-widget="collapse">
                <i class="fa fa-plus"></i>
            </button>
        </div>
    </div>
    <div class="card-body repliesDiv">
        <c:if test="${post.comments != null}">
        <table class="table table-hover" style="width: 100%">
            <colgroup>
                <col width="150px">
                <col width="50px">
                <col width="50px">
            </colgroup>
            <tr>
                <th>내용</th>
                <th>작성자</th>
                <th style="text-align: center"></th>
            </tr>
            <c:forEach var="comment" items="${post.comments}">
                <tr>
                    <td>${comment.body}</td>
                    <c:choose>
                        <c:when test="${comment.user.name ne null}">
                            <td>${comment.user.name}</td>
                        </c:when>
                        <c:otherwise>
                            <td>${comment.userIp}</td>
                        </c:otherwise>
                    </c:choose>

                    <td>
                        <div name="button" style="align-content: end; text-align: center">
                           <%-- <c:if test="${comment.user.id == sessionScope.session_id}">
                                <input type="hidden" name="postId" value="${param.id}">
                                <button type="button" class="btn btn-outline-info btn-sm"
                                        onclick="replyComment(${comment.id}, ${param.id})">답변
                                </button>
                                <button type="button" class="btn btn-outline-warning btn-sm"
                                        onclick="updateComment(${comment.id})">수정
                                </button>
                                <button type="button" class="btn btn-outline-danger btn-sm"
                                    &lt;%&ndash;onclick="location.href='/comment/deleteProc.do?commentId='+${comment.id}+'&postId='+${param.id}"&ndash;%&gt;>
                                    삭제
                                </button>
                            </c:if>--%>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach var="parentComment" items="${parentComment}">
                <tr style="">
                    <td>${parentComment.body}</td>
                    <td>${parentComment.user.name}</td>
                    <td>
                        <div name="button" style="align-content: end; text-align: center">
                            <c:if test="${parentComment.user.id == sessionScope.session_id}">
                                <input type="hidden" name="parentCommentId" value="${param.id}">
                                <button type="button" class="btn btn-outline-warning btn-sm"
                                        onclick="replyEditComment(${parentComment.id})">수정
                                </button>
                                <button type="button" class="btn btn-outline-danger btn-sm"
                                    <%--onclick="location.href='/comment/deleteProc.do?commentId='+${comment.id}+'&postId='+${param.id}"--%>>
                                    삭제
                                </button>
                            </c:if>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </c:if>
        </table>
    </div>
</div>

