<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	//비로그인 상태의 사용자인 경우 - 비정상적인 요청
	if(loginUserinfo==null) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	if(request.getParameter("userid")==null) {//전달값이 없는 경우 - 비정상적인 요청
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	String userid=request.getParameter("userid");
	
	UserinfoModelOneDAO.getDAO().deleteUserinfo(userid);
	
	
	//로그인 상태의 사용자 아이디와 삭제 처리된 사용자 아이디가 같은 경우
	if(loginUserinfo.getUserid().equals(userid)) {//관리자가 자신의 회원정보를 삭제한 경우
		response.sendRedirect("user_logout.action.jsp");
	} else {
		response.sendRedirect("user_list.jsp");
	}
%>
