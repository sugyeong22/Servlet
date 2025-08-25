<%@ page import="com.sudal.common.MysqlService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>urlList</title>
</head>
<body>
<%
    MysqlService mysqlService = MysqlService.getInstance();

    mysqlService.connect();
    List<Map<String,Object>> resultList = mysqlService.select("SELECT * FROM `link`;");

    mysqlService.disconnect();
%>
    <h3>사이트 리스트</h3>

    <table border="1">
        <thead>
            <tr>
                <th>사이트</th>
                <th>사이트 주소</th>
            </tr>
        </thead>
        <tbody>
        <% for(Map<String, Object> list : resultList){%>
            <tr>
                <td><%= list.get("name")%></td>
                <td><%= list.get("url")%></td>
            </tr>
        <%}%>
        </tbody>
    </table>

</body>
</html>
