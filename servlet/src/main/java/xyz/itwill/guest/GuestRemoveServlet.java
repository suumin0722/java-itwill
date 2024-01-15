package xyz.itwill.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;

@WebServlet("/guest/remove.itwill")
public class GuestRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달값이 없는 경우
		if(request.getParameter("num")==null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		int rows=GuestDAO.getDAO().deleteGuest(num);
		
		if(rows>0) {//삭제된 게시글이 있는 경우
			response.sendRedirect("list.itwill");
			
		} else {//삭제된 게시글이 없는 경우(=글번호 잘못됨) - 비정삭인 요청
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
		
		
	}

}
