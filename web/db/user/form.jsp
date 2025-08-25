<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>사용자 추가</title>
</head>
<body>

<form method="post" action="/db/user/create">
    <label>이름 : </label><input type="text" name="name"> <br>
    <label>생년월일 : </label><input type="text" name="birthday"> <br>
    <label>이메일 : </label><input type="text" name="email"> <br>
    <label>자기소개</label> <br>
    <textarea rows="5" cols="30" name="introduce"></textarea><br>
    <button type="submit">추가</button>
</form>

</body>
</html>