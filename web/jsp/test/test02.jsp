<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 오수경
  Date: 2025-08-13
  Time: 오후 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>날짜 시간 출력</title>
</head>
<body>

    <%
        String result = request.getParameter("result");

        Date now = new Date();

        String answer = "";
        if(result.equals("day")){
            SimpleDateFormat formatter = new SimpleDateFormat("오늘 날짜 yyyy년 M월 d일");
            answer = formatter.format(now);
        } else if(result.equals("time")){
            SimpleDateFormat formatter = new SimpleDateFormat("현재 시간 HH시 mm분 ss초");
            answer = formatter.format(now);
        }
    %>

    <h1><%=answer%></h1>


</body>
</html>
