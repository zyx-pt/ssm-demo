<%--
  Created by IntelliJ IDEA.
  User: zhengyongxian
  Date: 2020/10/7
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
</head>
<body>
    <a href="account/findAll">访问查询账户</a>

    <form action="account/saveAccount" method="post">
        姓名：<input type="text" name="name" /><br/>
        金额：<input type="text" name="money" /><br/>
        <input type="submit" value="保存"/><br/>
    </form>

</body>
</html>
