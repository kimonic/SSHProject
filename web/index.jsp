<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/5
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <div align="center">整合SSH框架第一次启动成功!</div><br><br>
  <div align="center"><h2>用户登陆</h2></div><br><br>
  <div align="center">
      <form id="form1" method="post" action="loginBean.action">
      用户名:<input type="text" name="name" id="name"><br><br>
      密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" id="password"><br><br>
      <input type="submit" value="登陆"> &nbsp;&nbsp;&nbsp; <input type="reset" value="重置">
          &nbsp;&nbsp;&nbsp; <input type="button" value="注册" onclick="">
      </form>
  </div>


  </body>
</html>
