<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	mvc/valid/view.jsp : ${errorMsg}
	
	<spring:hasBindErrors name="validVo" />
	<spring:hasBindErrors name="validJsr303Vo" />
	
	<form action="/valid/submit" method="post">
		userId : <input type="text" name="userId" value="brown"> <form:errors path="validVo.userId"/><br>
		name : <input type="text" name="name" value="브라운"> <form:errors path="validVo.name"/><br>
		password : <input type="password" name="password" value=""> <form:errors path="validVo.password"/><br>
		<input type="submit" value="전송">
	</form>
	
	
	<h3>jsr 303 validator</h3>
	<form action="/valid/submit/jsr303" method="post">
		userId : <input type="text" name="userId" value="brown"> <form:errors path="validJsr303Vo.userId"/><br>
		name : <input type="text" name="name" value="브라운"> <form:errors path="validJsr303Vo.name"/><br>
		password : <input type="password" name="password" value=""> <form:errors path="validJsr303Vo.password"/><br>
		<input type="submit" value="전송">	
	</form>
	
	
	
	
	
	

</body>
</html>