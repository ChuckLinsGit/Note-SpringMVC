<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1" import="java.util.*"%>
<!-- 使用el需要引入jar包 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	Welcom jsp

	${messgae}
	${requestScope.message}
	
	${param.pname}
	${param.page}
	
	${param.name}
	${param.age}
	${param.mobile}
	
	<%=(String)session.getAttribute("pname")%>
	
	<%=session.getAttribute("page")%>
	
	
</body>
</html>