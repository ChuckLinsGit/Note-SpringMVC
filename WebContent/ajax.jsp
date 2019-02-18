<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			
			$.ajax({
				url:"nstest/return.do",//ajax请求资源路径
				//datatype:"json",传递Object类型的对象时需要指定数据类型为json，因为该种数据使用json为载体
				//data:{},{name:"龙傲天",age:23},ajax请求携带参数
				
				success:function(data){//成功返回时
				/* var json=eval("("+data+")");解析json对象，除去括号
					alter(json);
					alert(data.stu1.name+"  "+data.stu2.name); */
					$(data).each(function(index){
						alert(data[index].name+"  "+data[index].age);
					})
				},
				 error: function(XMLHttpRequest, textStatus, errorThrown) {
                     alert(XMLHttpRequest.status);
                     alert(XMLHttpRequest.readyState);
                     alert(textStatus);
                 },
                 complete: function(XMLHttpRequest, textStatus) {
                     this; // 调用本次AJAX请求时传递的options参数
                 }
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<button>提交AJAX请求</button>
</body>
</html>