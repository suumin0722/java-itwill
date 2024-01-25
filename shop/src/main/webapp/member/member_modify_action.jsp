<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%-- 회원정보를 전달받아 MEMBER 테이블의 행을 변경하고 [/member/member_mypage.jsp] 문서를
요청하기 위한 URL 주소를 전달하여 응답하는 JSP 문서 --%>  
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%@include file="/security/login_check.jspf" %>    
<%
	//JSP 문서를 GET 방식으로 요청한 경우에 대한 응답 처리 - 비정상적인 요청
	if(request.getMethod().equals("GET")) {
		//클라이언트가 아닌 요청 JSP 문서에게 URL 주소를 전달하므로 페이지 이동 불가능
		//response.sendRedirect(request.getContextPath()+"/error/error_400.jsp");
		//return;
		
		//request 내장객체의 속성값으로 URL 주소 저장하여 요청 JSP 문서(index.jsp)에서 
		//URL 주소를 제공받아 클라이언트에게 전달하여 응답
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}

	//전달값을 반환받아 저장
	int memberNum=Integer.parseInt((request.getParameter("memberNum")));
	String passwd=request.getParameter("passwd");
	//전달받은 비밀번호를 암호화 처리한 후 변수에 저장
	if(passwd==null || passwd.equals("")) {//전달값(비밀번호)이 없는 경우 
		//현재로그인 사용자의 비밀번호를 변수에 저장 - 기존 비밀번호 유지
		passwd=loginMember.getPasswd();
	} else {//전달값(비밀번호)이 있는 경우 
		//전달값을 암호화 처리하여 변수에 저장 - 새로운 비밀번호 변경
		passwd=Utility.encrypt(passwd);
	}
	
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile1")+"-"+request.getParameter("mobile2")
		+"-"+request.getParameter("mobile3");
	String zipcode=request.getParameter("zipcode");
	String address1=request.getParameter("address1");
	String address2=request.getParameter("address2");
	
	//MemberDTO 객체를 생성하여 전달값으로 필드값 변경
	MemberDTO member=new MemberDTO();
	member.setMemberNum(memberNum);
	member.setPasswd(passwd);
	member.setName(name);
	member.setEmail(email);
	member.setMobile(mobile);
	member.setZipcode(zipcode);
	member.setAddress1(address1);
	member.setAddress2(address2);
	
	//회원정보를 전달받아 MEMBER 테이블에 저장된 행을 변경하고 변경행의 개수를 반환하는
	//MemberDAO 클래스의 메소드 호출
	MemberDAO.getDAO().updateMember(member);
	
	//session 객체에 저장된 권한 관련 속성값(회원정보 - MemberDTO 객체) 변경
	session.setAttribute("loginMember", MemberDAO.getDAO().selectMemberByNum(memberNum));
	
	//페이지 이동
	request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=member&worker=member_mypage");
%>