<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
    //session 객체에 저장된 권한 관련 속성값을 MemberDTO 객체로 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	//비로그인 상태의 사용자 또는 일반 사용자가 JSP 문서를 요청한 경우에 대한 응답 처리 - 비정상적인 요청
	if(loginMember==null || loginMember.getMemberStatus()!=9) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}
--%>
<%@include file="/security/admin_check.jspf" %>    
<h1>관리자 메인 페이지</h1>