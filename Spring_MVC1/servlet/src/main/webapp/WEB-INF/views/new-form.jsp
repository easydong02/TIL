<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-01-06
  Time: 오후 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%-- save는 상대경로로 진행 /를 붙이면 그냥 /save로만 날아간다.--%>
<form action="save" method="post">
  username: <input type="text" name="username" />
  age: <input type="text" name="age" />
  <button type="submit">전송</button>
</form>

</body>
</html>
