package xyz.itwill.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//게시글을 전달받아 GUEST 테이블에 행으로 변경하고 게시글 목록페이지(/guest/list.itwill)를 
//요청하기 위한 URL 주소를 응답하는 서블릿
//=> 게시글 입력페이지(/guest/modifyForm.itwill)의 form 태그를 사용해 POST 방식으로 요청한 서블릿
@WebServlet("/guest/modify.itwill")
public class GuestModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		GuestDTO guest=new GuestDTO();
		guest.setNum(num);
		guest.setWriter(writer);
		guest.setSubject(subject);
		guest.setContent(content);
		
		GuestDAO.getDAO().updateGuest(guest);
		
		response.sendRedirect("list.itwill");
		
	}

}
