package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DestRedirect
 */
@WebServlet("/ch08/dst1")
public class DestRedirect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String msg = request.getParameter("msg");
		
		String addr = (String)request.getAttribute("addr");
		
		HttpSession session = request.getSession();
		String sessAddr = (String)session.getAttribute("addr");
		
		ServletContext ctx = getServletContext();
		String ctxAddr = (String)ctx.getAttribute("addr");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>sendRedirect를 이용한 화면이동 </h1>");
		out.print("<h1>" + msg + "</h1>");
		out.print("<h1>Request: " + addr + "</h1>");
		out.print("<h1>Session: " + sessAddr + "</h1>");	
		out.print("<h1>Application: " + ctxAddr + "</h1>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
