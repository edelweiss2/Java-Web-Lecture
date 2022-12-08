package ch06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Params
 */
@WebServlet("/ch06/params")
public class Params extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Params.doPost() method");
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		String data = "uid: " + uid + "\n";
		data += "pwd: " + "\n";
		System.out.println(data);
	}

}
