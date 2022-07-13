<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    <c:if test="${message != null}">
    alert("${message}");
    </c:if>

    <c:if test="${path != null}">
    window.location.href = "${path}";
    </c:if>
</script>
</body>
</html>
