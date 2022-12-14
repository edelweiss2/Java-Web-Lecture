package ch09.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class Controller
 */
//@WebServlet(
//		name = "UserController", 
//		urlPatterns = { 
////				"/ch09/users/list", 
////				"/ch09/users/login",
////				"/ch09/users/logout",
////				"/ch09/users/register",
////				"/ch09/users/update",
////				"/ch09/users/delete"
//		})
public class Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();
		UserDao dao = new UserDao();
		HttpSession session = request.getSession();
		
		if (requestUri.contains("list")) {
			List<User> list = dao.listUsers();
			request.setAttribute("userList", list);
			RequestDispatcher rd = request.getRequestDispatcher("/ch09/users/listView");
			rd.forward(request, response);
		}  else if (requestUri.contains("logout")) {
			System.out.println(session.getAttribute("uid"));
			System.out.println(session.getAttribute("uname"));
			session.invalidate();
			response.sendRedirect("/jw/ch09/users/list");
		} else if (requestUri.contains("register")){
			response.sendRedirect("/jw/ch09/users/register.html");
		} else if (requestUri.contains("update")) {
			String uid = request.getParameter("uid");
			User u = dao.getUserInfo(uid);
			request.setAttribute("user", u);
			RequestDispatcher rd = request.getRequestDispatcher("/ch09/users/updateView");
			rd.forward(request, response);
		} else if (requestUri.contains("delete")) {
			String uid = request.getParameter("uid");
			dao.deleteUser(uid);
			response.sendRedirect("/jw/ch09/users/list");
		} else {
			System.out.println("get 잘못된 경로 입니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();
		UserDao dao = new UserDao();
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (requestUri.contains("login")) {
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			User u = dao.getUserInfo(uid);
			
			if(u.getUid() != null) {
				
				if(BCrypt.checkpw(pwd, u.getPwd())) {
				
				session.setAttribute("uid", u.getUid());
				session.setAttribute("uname", u.getUname());
				
				out.print("<script>");
				out.print("alert('" + u.getUname() + "님 환영합니다." + "');");
				out.print("location.href = '" + "/jw/ch09/users/list" + "';");
				out.print("</script>");
				} else {		//패스워드가 틀린경우
					out.print("<script>");
					out.print("alert('잘못된 패스워드 입니다.');");
					out.print("location.href = '" + "/jw/ch09/users/login.html" + "';");
					out.print("</script>");
				}
			} else {	// id 없음
				out.print("<script>");
				out.print("alert('회원 가입 페이지로 이동합니다.')");
				out.print("location.href = '" + "/jw/ch09/users/register.html"+ "';");
				out.print("</script>");
			}
			
		} else if (requestUri.contains("register")) {
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			String uname = request.getParameter("uname");
			String email = request.getParameter("email");
			
			User u = dao.getUserInfo(uid);
			if (u.getUid() != null) {
				response.sendRedirect("/jw/ch09/users/list");
			} else {
				u = new User(uid, pwd, uname, email);
				dao.registerUser(u);
				
				response.sendRedirect("/jw/ch09/users/list");
			}
			
		} else if (requestUri.contains("update")) {
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			String uname = request.getParameter("uname");
			String email = request.getParameter("email");
			
			User u = new User(uid, pwd, uname, email);
			dao.updateUser(u);
			
			response.sendRedirect("/jw/ch09/users/list");
		} else {
			System.out.println("post 잘못된 경로 입니다.");
		}
	}

}
