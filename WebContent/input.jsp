<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${ex.message}
	<form action="${pageContext.request.contextPath }/nstest/for.do" method="post" enctype="multipart/form-data">
		<!-- 使用文本框表单标签，不用id，用name才能被识别
		注解式开发以及请求转发和重定向所需input
		姓名<input type="text" name="name"/><br/>
		年龄<input type="text" name="age"/><br/>
		学校<input type="text" name="school.sname"/>
		
		异常处理和类型转换所需input
		 姓名<input type="text" name="age" value="${page }"/>${ageMessage }<br/>
		 日期<input type="text" name="date" value="${pdate }"/>${dateMessage }<br/>
		 <input type="submit" value="submit"/><br/>
		 
		 数据校验
		${nameMessage }姓名<input type="text" name="name"/><br/>
		${ageMessage } 年龄<input type="text" name="age"/><br/>
		${mobileMessage }手机号<input type="text" name="mobile"/><br/> -->
		<%-- 单个文件
	     文件<input type="file" name="img" >${fileMessage }<br/> --%>
	     
	     文件1<input type="file" name="imgs" >${file1Message }<br/>
	     文件2<input type="file" name="imgs" >${file2Message }<br/>
	     文件3<input type="file" name="imgs" >${file3Message }<br/>
		  <input type="submit" value="上传"/>
	</form>
</body>
</html>