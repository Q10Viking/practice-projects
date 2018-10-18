<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	This is JSP page-1.<a href="my.do">Jump to welcome page</a> <br>
	This is JSP page-2.<a href="/my.do">Jump to welcome page</a> <br>
	This is JSP page-3.<a href="/03-path2/my.do">Jump to welcome page</a> <br>
	This is JSP page-4.<a href="${pageContext.request.contextPath}/my.do">Jump to welcome page</a> <br>
	<img alt="picture1" src="images/1beauty.jpg">
	
</body>
</html>