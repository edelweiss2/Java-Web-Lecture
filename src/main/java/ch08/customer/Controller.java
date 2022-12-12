package ch08.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class controller
 */
@WebServlet(
		name = "Controller", 
		urlPatterns = { 
				"/ch08/customer/list", 
				"/ch08/customer/register", 
				"/ch08/customer/update", 
				"/ch08/customer/delete"
		})
public class Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletPath = request.getServletPath();
		CustomerDao dao = new CustomerDao();
		response.setContentType("text/html; charset=utf-8");
		
		if (servletPath.indexOf("list") > 0 ) {
			List<Customer> list = dao.getCustomers();			
			request.setAttribute("customerList", list);
			RequestDispatcher rd = request.getRequestDispatcher("/ch08/customer/listView"); //servlet context 내부에서 이동하니까 /jw/ 안붙음
			rd.forward(request, response);			
		} else if (servletPath.indexOf("register") > 0) {
			response.sendRedirect("/jw/ch08/customer/register.html"); //클라이언트 거쳐서 오니까(redirect) /jw/가 붙음
		} else if (servletPath.indexOf("update") > 0) {
			String uid = request.getParameter("uid");
			Customer c = dao.getCustomer(uid);
			request.setAttribute("customer", c);
			RequestDispatcher rd = request.getRequestDispatcher("/ch08/customer/updateView");
			rd.forward(request, response);
		} else if (servletPath.indexOf("delete") > 0) {
			String uid = request.getParameter("uid");
			dao.deleteCustomer(uid);
			response.sendRedirect("/jw/ch08/customer/list");
		} else {
			System.out.println("get 잘못된 경로 입니다.");
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletPath = request.getServletPath();
		CustomerDao dao = new CustomerDao();
		response.setContentType("text/html; charset=utf-8");
		
		if (servletPath.indexOf("register") > 0) {
			String uid = request.getParameter("uid");
			String uname = request.getParameter("uname");
			
			Customer c = dao.getCustomer(uid);
			if(c.getUid() != null)
				response.sendRedirect("/jw/ch08/customer/register.html");
			else {
				c = new Customer(uid, uname);
				dao.insertCustomer(c);
				response.sendRedirect("/jw/ch08/customer/list");
			}
		} else if (servletPath.indexOf("update") > 0) {
			String uid = request.getParameter("uid");
			String uname = request.getParameter("uname");		
			
			Customer c = new Customer(uid, uname);			
			dao.updateCustomer(c);
			response.sendRedirect("/jw/ch08/customer/list");
		} else {
			System.out.println("post 잘못된 경로 입니다.");			
		}
	}

}
