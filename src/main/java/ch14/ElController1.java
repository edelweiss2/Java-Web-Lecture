package ch14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ElController1
 */
@WebServlet("/ch14/el1")
public class ElController1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		application.setAttribute("aName", "어플리케이션");
		session.setAttribute("sName", "세션");
		request.setAttribute("name", "리퀘스트");
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/object.jsp?id=1&name=hong");
		rd.forward(request, response);
	}

}