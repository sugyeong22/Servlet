<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 기본 문법</title>
</head>
<body>
    <h3>기본 문법</h3>
    <!-- html 주석 -->
    <%-- jsp 주석 --%>

    <%-- 1부터 10까지의 합을 h3 태그로 표시 --%>
    <%
        int sum = 0;
        for(int i = 1 ; i <= 10 ; i++) {
            sum += i;
        }
    %>

    <h3>1~10 까지의 합 : <%=sum%></h3>

    <input type="text" value="<%=sum%>">
    <<%=sum%>>

    <div><%=sum*2%></div>

    <h3>리스트 다루기</h3>
    <%
        // 동물 이름 리스트
        List<String> animalList = new ArrayList<>();

        animalList.add("고양이");
        animalList.add("강아지");
    %>

    <ul>
        <li><%= animalList.get(0)%></li>
        <li><%= animalList.get(1)%></li>
    </ul>

    <h3>메서드 만들기</h3>
    <%!
        // Hello World를 리턴하는 메서드
        public String getHelloWorld(){
            return "Hello World";
        }
    %>>

    <%
        String message = getHelloWorld();
    %>

    <h3><%= message%></h3>
    <h3><%= getHelloWorld()%></h3>

</body>
</html>
