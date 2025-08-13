<%--
  Created by IntelliJ IDEA.
  User: 오수경
  Date: 2025-08-13
  Time: 오후 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post method</title>
</head>
<body>
    <%
        String nickname = request.getParameter("nickname");

        // 좋아하는 동물 하나를 전달 받고 보여준다.
        // 고양이, 강아지, 호랑이
        String animal = request.getParameter("animal");

        // 좋아하는 과일 하나를 전달 받고 보여준다.
        // 바나나, 딸기, 복숭아
        String fruit = request.getParameter("fruit");

    %>

    <h1><%=nickname%></h1>
    <h3><%= animal%></h3>
    <h3><%= fruit%></h3>

</body>
</html>
