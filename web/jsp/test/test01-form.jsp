<%--
  Created by IntelliJ IDEA.
  User: 오수경
  Date: 2025-08-13
  Time: 오후 7:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testform</title>
</head>
<body>

    <form method="get" action="/jsp/test/test01.jsp">
    <h1>체격 조건 입력</h1>
    <div><input type="text" name="height"> cm <input type="text" name="weight"> kg</div>
    <button type="submit">계산</button>
    </form>

</body>
</html>
