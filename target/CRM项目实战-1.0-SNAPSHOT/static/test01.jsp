<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/9
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
        $.ajax({
            url:"",
            data:{

            },
            type:"",
            dataType:"",
            success:function (rs) {

            }
        })

</body>
</html>
