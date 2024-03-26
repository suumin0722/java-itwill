<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JavaScript(jQuery)를 사용하여 클라이언트에서 입력값 검증 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>사원등록</h1>
	<hr>
	<%-- url 태그를 사용하여 웹자원의 경로를 절대경로로 제공받아 속성값으로 저장 --%>
	<c:url var="url" value="/valid/html"/>
	<form action="${url }" method="post">
	<table>
		<tr>
			<td>아이디</td>		
			<td>
			<input type="text" name="id" id="id">
			<span id="idMsg" class="error"></span> 
			</td>		
		</tr>
		<tr>
			<td>비밀번호</td>		
			<td>
			<input type="text" name="passwd" id="passwd">
			<span id="passwdMsg" class="error"></span>
			</td>		
		</tr>
		<tr>
			<td>이름</td>		
			<td>
			<input type="text" name="name" id="name">
			<span id="nameMsg" class="error"></span>
			</td>		
		</tr>
		<tr>
			<td>이메일</td>		
			<td>
			<input type="text" name="email" id="email">
			<span id="emailMsg" class="error"></span>
			</td>		
		</tr>
		<tr>
			<td>성별</td>		
			<td>
			남자<input type="radio" name="gender" value="남자" class="gender">
			여자<input type="radio" name="gender" value="여자" class="gender">
			<span id="genderMsg" class="error"></span>
			</td>		
		</tr>
		<tr>
			<td>
			<button type="submit">등록</button>
			</td>
		</tr>
	</table>	
	</form>
	
	<script type="text/javascript">
	$("#registerForm").submit(function() {
		var validResult=true;
		
		$(".error").hide();
		
		var idReg="/^[a-zA-Z]\w{5,19}$/g"
		if($("#id").val()=="") {
			$("#idMsg").html("아이디를 입력해 주세요.");
			validResult=false;
		} else if(!idReg.test($("#id").val())) {
			$("#idMsg").html("아이디를 형식에 맞게 입력해 주세요.");
			validResult=false;
		}
		
		$(".error").show();
		
		return validResult;
	});
	</script>
</body>
</html>