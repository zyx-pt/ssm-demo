<%--
  Created by IntelliJ IDEA.
  User: zhengyx
  Date: 2020/9/21
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统文件上传</h3>

    <form action="/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" /><br/>
        <input type="submit" value="上传" />
    </form>

    <h3>Springmvc文件上传</h3>

    <form action="/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" /><br/>
        <input type="submit" value="上传" />
    </form>

    <h3>跨服务器文件上传</h3>

    <form action="/fileupload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" /><br/>
        <input type="submit" value="上传" />
    </form>
</body>
</html>
