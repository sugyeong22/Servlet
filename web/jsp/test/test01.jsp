<%--
  Created by IntelliJ IDEA.
  User: 오수경
  Date: 2025-08-13
  Time: 오후 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BMI 수치</title>
</head>
<body>
    <h1>BMI 측정 결과</h1>
    <%
        String weightStirng = request.getParameter("weight");
        String heightString = request.getParameter("height");

        int weight = Integer.parseInt(weightStirng);
        int height = Integer.parseInt(heightString);

        double bmi = weight / ((height / 100.0) * (height / 100.0));

        String result="";
        if(bmi < 18.5){
            result = "저체중";
        } else if(bmi <25){
            result="정상";
        } else if(bmi <30){
            result ="과체중";
        } else if(bmi >= 30){
            result = "비만";
        }
    %>
    <div>당신은 <%=result%> 입니다.</div>
    <div>BMI 수치 : <%=bmi%> </div>

</body>
</html>
