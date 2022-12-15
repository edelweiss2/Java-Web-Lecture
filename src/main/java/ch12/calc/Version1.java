package ch12.calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Version1
 */
@WebServlet("/ch12/calc/ver1")
public class Version1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", 0);
		RequestDispatcher rd = request.getRequestDispatcher("/ch12/calc/ver1.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("op");
		
		int result = 0;
		switch (op) {
		case "+" :
			result = num1 + num2; break;
		case "-" :
			result = num1 - num2; break;
		case "*" :
			result = num1 * num2; break;
		case "/" :
			result = num1 / num2; break;
		default :
			result = Integer.MAX_VALUE;
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/ch12/calc/ver1.jsp");
		rd.forward(request, response);
	}

}
