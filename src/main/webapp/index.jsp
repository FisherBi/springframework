<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    request.setAttribute("path", basePath);
%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World123!</h2>
<a href="#">请先登陆</a>
<a href="/addUser.html">添加用户</a>
</body>
</html>
