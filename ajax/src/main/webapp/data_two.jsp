<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달값을  --%>

<%
	String id=request.getParameter("id");
	String name=request.getParameter("name");
%>
<%=name%>[<%=id%>]님, 환영합니다.