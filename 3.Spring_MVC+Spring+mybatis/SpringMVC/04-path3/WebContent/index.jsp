<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()
						+ ":" + request.getServerPort()+path+"/";
%>

<html>
<head>

	<base href="<%=basePath %>>">
	<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/test/my.do">通过Controller回到index页面</a> <br>
	访问次数： ${access}
	<img alt="picture1" src="${pageContext.request.contextPath}/images/1beauty.jpg">
	
	<a href="test/my.do">通过Controller回到index页面</a> <br>
	访问次数： ${access}
	<img alt="picture1" src="images/3beauty.jpg">
	
</body>
</html>