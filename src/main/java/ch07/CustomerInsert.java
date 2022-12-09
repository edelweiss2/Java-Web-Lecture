package ch07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CuustomerInsert
 */
@WebServlet("/ch07/registerCustomer")
public class CustomerInsert extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		
		CustomerDao dao = new CustomerDao();
		
		Customer c = dao.getCustomer(uid);
		if(c.getUid() != null)
			response.sendRedirect("/jw/ch07/registerCustomer.html");
		else {
			c = new Customer(uid, uname);
			dao.insertCustomer(c);
		
			response.sendRedirect("/jw/ch07/customerList");
		}
	}

}
