package ch08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerUpdateController
 */
@WebServlet("/ch08/updateCustomer")
public class CustomerUpdateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		
		CustomerDao dao = new CustomerDao();
		Customer c = dao.getCustomer(uid);
		
		request.setAttribute("customer", c);
		RequestDispatcher rd = request.getRequestDispatcher("/ch08/updateView");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");		
		
		Customer c = new Customer(uid, uname);
		CustomerDao dao = new CustomerDao();
		dao.updateCustomer(c);
		
		response.sendRedirect("/jw/ch08/customer");
	}

}
