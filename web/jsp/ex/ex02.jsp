<%--
  Created by IntelliJ IDEA.
  User: 오수경
  Date: 2025-08-13
  Time: 오후 7:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>정보</title>
</head>
<body>
    <%
        // 이름과 생년월일을 전달 받고, 이름과 나이를 html로 구성
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");

        int year = Integer.parseInt(birthday.substring(0,4));
        int age = 2025 - year + 1;
    %>

    <h3>정보</h3>

    <table border="1">
        <tr>
            <th>이름</th>
            <td><%= name%></td>
        </tr>
        <tr>
            <th>나이</th>
            <td><%= age%></td>
        </tr>
    </table>

</body>
</html>
