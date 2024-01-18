<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>객체의 사용범위(Scope)</h1>
	<hr>
	<%
	 	String pageName=(String)pageContext.getAttribute("pageName"); //동일 JSP에서만 사용 가능
	 	String requestName=(String)request.getAttribute("requestName");//동일 JSP 와 thread가 이동된 JSP에서 사용 가능
	 	String sessionName=(String)session.getAttribute("sessionName");//클라이언트가 같은 모든 JSP만 사용 가능 => 브라우저가 종료되면 소멸(session 객체가 저장되니까)
	 	String applicationName=(String)application.getAttribute("applicationName");//모든 JSP 사용 가능 => WAS가 종료되면 소멸
	%>
	
	<p>pageName = <%=pageName %></p>
	<p>requestName = <%=requestName %></p>
	<p>sessionName = <%=sessionName %></p>
	<p>applicationName = <%=applicationName %></p>
</body>
</html>