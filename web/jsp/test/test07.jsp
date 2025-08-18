<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>검색 결과</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<%
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> map = new HashMap<String, Object>() {{ put("name", "버거킹"); put("menu", "햄버거"); put("point", 4.3); }};
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "BBQ"); put("menu", "치킨"); put("point", 3.8); }};
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "교촌치킨"); put("menu", "치킨"); put("point", 4.1); }};
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "도미노피자"); put("menu", "피자"); put("point", 4.5); }};
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "맥도날드"); put("menu", "햄버거"); put("point", 3.8); }};
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "BHC"); put("menu", "치킨"); put("point", 4.2); }};
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "반올림피자"); put("menu", "피자"); put("point", 4.3); }};
    list.add(map);

    // 검색 대상 메뉴
    String target = request.getParameter("menu");
    // 4.0 이하 제외 여부
    String filter = request.getParameter("filter");
%>

<%= filter %>
<div class="container">
    <h2 class="text-center">검색 결과</h2>
    <table class="table text-center">
        <thead>
        <tr>
            <th>메뉴</th>
            <th>상호</th>
            <th>별점</th>
        </tr>
        </thead>
        <tbody>
        <% for(Map<String, Object> store:list) {
            if(target.equals(store.get("menu"))) {
                double point = (Double)store.get("point");
                if(filter == null || point > 4.0) { %>
        <tr>
            <td><%= store.get("menu") %></td>
            <td><%= store.get("name") %></td>
            <td><%= store.get("point")%></td>
        </tr>
        <%      }
        }
        } %>
        </tbody>
    </table>
</div>

</body>
</html>