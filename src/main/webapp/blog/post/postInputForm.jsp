<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    .container table > td {
        text-align: center;
    }

    .container button[id="createBtn"] {
        width: 200px;
        text-align: center;
        margin: .25rem;
        padding: .5rem 1rem;
        text-decoration: none;
        font-weight: bold;
    }

    ul {
        padding: 16px 0;
    }

    ul li {
        display: inline-block;
        margin: 0 5px;
        font-size: 14px;
        letter-spacing: -.5px;
    }

    form {
        padding-top: 16px;
    }

    ul li.tag-item {
        padding: 4px 8px;
        background-color: #777;
        color: #000;
    }

    .tag-item:hover {
        background-color: #262626;
        color: #fff;
    }

    .del-btn {
        font-size: 12px;
        font-weight: bold;
        cursor: pointer;
        margin-left: 8px;
    }
</style>
<main class="flex-shrink-0">
    <div class="container" >
        <c:set var="action" value="${post == null ? '/post/createProc.do' : '/post/editProc.do'}"/>
        <form action="${action}" name="post_form" method="POST" onsubmit="setTags()">
            <c:if test="${post != null}">
                <input type="hidden" id="id" name="id" value="${post.id}">
            </c:if>
            <h2>글쓰기</h2>
            <table class="table table-hover">
                <tbody>
                <tr>
                    <td><input type="text" class="form-control" id="title" name="title" value="${post.title}" maxlength="40" placeholder="글 제목을 입력해주세요."></td>
                </tr>
                <input type="hidden" id="userId" name="userId" value="${sessionScope.session_id}">
                <tr>
                    <td>
                        <input type="text" id="tag" size="20" placeholder="태그입력" />
                        <input type="hidden" name="tags" value="">
                        <ul id="tag-list">
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control" id="body" name="body" value="${post.body}" maxlength="1024" style="height: 400px" placeholder="글 내용을 작성하세요."></td>
                </tr>
                </tbody>
                <tr align="right">
                    <td colspan="2">
                        <c:if test="${post eq null}">
                        <button type="submit" class="btn btn-outline-primary">등록</button>
                            <button type="button" class="btn btn-outline-primary" onclick="setTags()">확인</button>
                        </c:if>

                        <c:if test="${sessionScope.SESSION_USER_ID eq post.user.id}">
                        <button type="submit" class="btn btn-outline-warning">수정</button>
                        </c:if>

                        <c:if test="${sessionScope.SESSION_USER_ID eq post.user.id}">
                        <button type="button" class="btn btn-outline-danger" onclick="location.href='/post/deleteProc.do?id='+ ${post.id}">삭제</button>
                        </c:if>
                        <button type="button" class="btn btn-outline-secondary" onclick="location.href='/main.do'">이전</button>
                </tr>
            </table>
        </form>
        <c:if test="${post != null}">
            <jsp:include page="../comment/comments.jsp"/>
        </c:if>
    </div>
</main>

<script type="text/javascript">

    var tag = {};
    var counter = 0;
    $(document)
        .ready(function () {

            // 태그 추가
            function addTag(value) {
                tag[counter] = value; // 태그를 Object 안에 추가
                counter++; // counter 증가 삭제를 위한 del-btn 의 고유 id 가 된다.
            }

            // 최종적으로 서버에 넘길때 tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
            function marginTag() {
                return Object.values(tag)
                    .filter(function (word) {
                        return word !== "";
                    });
            }

            $("#tag")
                .on("keyup", function (e) {
                    var self = $(this);
                    console.log("keypress");
                    if (e.key === "Enter" || e.keyCode == 32) {
                        e.preventDefault();
                        var tagValue = self.val();
                        if (tagValue !== "") {
                            var result = Object.values(tag)
                                .filter(function (word) {
                                    return word === tagValue;
                                })
                            if (result.length == 0) {
                                $("#tag-list")
                                    .append("<li class='tag-item'>" + tagValue + "<span class='del-btn' idx='" + counter + "'>x</span></li>");
                                addTag(tagValue);
                                self.val("");
                            } else {
                                alert("태그값이 중복됩니다.");
                            }
                        }
                        e.preventDefault();
                    }
                });
            $(document)
                .on("click", ".del-btn", function (e) {
                    var index = $(this)
                        .attr("idx");
                    tag[index] = "";
                    $(this)
                        .parent()
                        .remove();
                });
        })

    function setTags(){
        var tags = Object.values(tag)
            .filter(function (word) {
                return word !== "";
            });
        console.log(tags);
    }
</script>
<jsp:include page="../layout/footer.jsp"/>
