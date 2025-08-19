<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="ko">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<head>
    <meta charset="utf-8">
    <title>SK</title>
</head>
<body>
    <%
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>() {{ put("ch", "5"); put("name", "SBS"); put("category", "지상파"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "7"); put("name", "KBS2"); put("category", "지상파"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "9"); put("name", "KBS1"); put("category", "지상파"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "11"); put("name", "MBC"); put("category", "지상파"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "54"); put("name", "OCN"); put("category", "영화"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "56"); put("name", "Screen"); put("category", "영화"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "57"); put("name", "Mplex"); put("category", "영화"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "30"); put("name", "KBS 드라마"); put("category", "드라마"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "32"); put("name", "MBC 드라마"); put("category", "드라마"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "34"); put("name", "Olive"); put("category", "드라마"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "3"); put("name", "tvN"); put("category", "예능"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "28"); put("name", "MBC Every1"); put("category", "예능"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "48"); put("name", "JTBC2"); put("category", "예능"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "49"); put("name", "E채널"); put("category", "예능"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "120"); put("name", "SPOTV"); put("category", "스포츠"); }};
        list.add(map);
        map = new HashMap<String, String>() {{ put("ch", "121"); put("name", "KBSN 스포츠"); put("category", "스포츠"); }};
        list.add(map);
    %>
    <div id="wrap">
        <header class ="head mt-5">
            <h1 class="text-danger text-center">Sk broadband IPTV</h1>
        </header>
        <nav class="nav bg-danger option d-flex justify-content-center align-items-end">
            <ul class="nav nav-fill font-weigth-bold">
                <il class="nav-item"><a class="nav-link text-white" href="http://localhost:8080/jsp/test/iptv/test09.jsp">전체</a></il>
                <il class="nav-item"><a class="nav-link text-white" href="http://localhost:8080/jsp/test/iptv/test09.jsp?filter=지상파">지상파</a></il>
                <il class="nav-item"><a class="nav-link text-white" href="http://localhost:8080/jsp/test/iptv/test09.jsp?filter=드라마">드라마</a></il>
                <il class="nav-item"><a class="nav-link text-white" href="http://localhost:8080/jsp/test/iptv/test09.jsp?filter=예능">예능</a></il>
                <il class="nav-item"><a class="nav-link text-white" href="http://localhost:8080/jsp/test/iptv/test09.jsp?filter=영화">영화</a></il>
                <il class="nav-item"><a class="nav-link text-white" href="http://localhost:8080/jsp/test/iptv/test09.jsp?filter=스포츠">스포츠</a></il>

            </ul>
        </nav>
        <section class="">
            <table class="table text-center">
                <thead>
                    <tr>
                        <th>채널</th>
                        <th>채널명</th>
                        <th>카테고리</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    String filter = request.getParameter("filter");
                    for(Map<String, String> tv : list){
                        if(filter == null){
                %>
                <tr>
                    <td><%=tv.get("ch")%></td>
                    <td><%=tv.get("name")%></td>
                    <td><%=tv.get("category")%></td>
                </tr>
                <% } else if(tv.get("category").equals(filter)){
                            //if(filter == null || tv.get("category").equals(filter))
                %>
                    <tr>
                        <td><%=tv.get("ch")%></td>
                        <td><%=tv.get("name")%></td>
                        <td><%=tv.get("category")%></td>
                    </tr>
                <% }
                    }%>
                </tbody>
            </table>
        </section>
        <footer class="footer">
            <div class="text-center font-weigth-bold text-dark mt-5">
                <div>Copyright © Sk broadband IPTV 2025</div>
            </div>
        </footer>
    </div>
</body>
</html>
