package ch08;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SourceRedirect
 */
@WebServlet("/ch08/src1")
public class SourceRedirect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/ch08/src1 doGet()");
		
		String msg = "SourceRedirect, 한글 메세지";
		msg = URLEncoder.encode(msg, "utf-8");		//주소창으로 한글을 보낼때는 반드시 인코딩 해줘야함
		System.out.println(msg);
		
		request.setAttribute("addr", "서울시 광진구 구의동");
		
		HttpSession session = request.getSession();
		session.setAttribute("addr", "서울시 광진구 구의동");
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("addr", "서울시 광진구 구의동");
		response.sendRedirect("/jw/ch08/dst1?msg=" + msg);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
