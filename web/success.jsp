<%--
  Created by IntelliJ IDEA.
  User: Joe
  Date: 2017/11/15
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SuccessLogin</title>
</head>
<body style="text-align: center">
<form action="login" style="display: inline-table">
    <fieldset style="width: 200px">
        <legend>用户信息</legend>
        用户名:${cookie.get(username).value}<br>
        上次登陆时间:${cookie.get(lastime).value}<br>
        <br>
        <input type="submit" value="退出">
    </fieldset>
</form>
<br>

</body>
</html>
