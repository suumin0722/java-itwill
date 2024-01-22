<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 학생번호를 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 [displayStudent.jsp] 문서를 요청할
수 있는 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>  
<%
	//전달값이 없는 경우에 대한 응답 처리 - 비정상적인 요청
	if (request.getParameter("no")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
  		return;
	}

	
	int no=Integer.parseInt(request.getParameter("no"));
	
	int rows=StudentDAO.getDAO().deleteStudent(no);
	
	if(rows>0) {//삭제행 있는 경우
		response.sendRedirect("displayStudent.jsp");
		
	} else {//삭제행이 없는 경우 - 비정삭인 요청
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

  %>
