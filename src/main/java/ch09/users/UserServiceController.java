package ch09.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class UserServiceController
 */
@WebServlet({ "/ch09/users/list", "/ch09/users/login", "/ch09/users/logout", "/ch09/users/register",
		"/ch09/users/update", "/ch09/users/delete" })
public class UserServiceController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		UserDao dao = new UserDao();
		HttpSession session = request.getSession();

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String uid = null, pwd = null, email = null, uname = null;
		User u = null;

		switch (action) {
		case "list":
			uid = request.getParameter("uid");
			pwd = request.getParameter("pwd");
			u = dao.getUserInfo(uid);

			if (u.getUid() != null) {
				if (BCrypt.checkpw(pwd, u.getPwd())) {
					session.setAttribute("uid", u.getUid());
					session.setAttribute("uname", u.getUname());

					out.print("<script>");
					out.print("alert('" + u.getUname() + "님 환영합니다." + "');");
					out.print("location.href = '" + "/jw/ch09/users/list" + "';");
					out.print("</script>");
				} else { // 패스워드가 틀린경우
					out.print("<script>");
					out.print("alert('잘못된 패스워드 입니다.');");
					out.print("location.href = '" + "/jw/ch09/users/login.html" + "';");
					out.print("</script>");
				}
			} else { // id 없음
				out.print("<script>");
				out.print("alert('회원 가입 페이지로 이동합니다.')");
				out.print("location.href = '" + "/jw/ch09/users/register.html" + "';");
				out.print("</script>");
			}
			break;
		case "login":
			uid = request.getParameter("uid");
			pwd = request.getParameter("pwd");
			u = dao.getUserInfo(uid);

			if (u.getUid() != null) {
				if (BCrypt.checkpw(pwd, u.getPwd())) {

					session.setAttribute("uid", u.getUid());
					session.setAttribute("uname", u.getUname());

					out.print("<script>");
					out.print("alert('" + u.getUname() + "님 환영합니다." + "');");
					out.print("location.href = '" + "/jw/ch09/users/list" + "';");
					out.print("</script>");
				} else { // 패스워드가 틀린경우
					out.print("<script>");
					out.print("alert('잘못된 패스워드 입니다.');");
					out.print("location.href = '" + "/jw/ch09/users/login.html" + "';");
					out.print("</script>");
				}
			} else { // id 없음
				out.print("<script>");
				out.print("alert('회원 가입 페이지로 이동합니다.')");
				out.print("location.href = '" + "/jw/ch09/users/register.html" + "';");
				out.print("</script>");
			}
			break;
		case "logout":
			System.out.println(session.getAttribute("uid"));
			System.out.println(session.getAttribute("uname"));
			session.invalidate();
			response.sendRedirect("/jw/ch09/users/list");
			break;
		case "register":
			uid = request.getParameter("uid");
			pwd = request.getParameter("pwd");
			uname = request.getParameter("uname");
			email = request.getParameter("email");

			u = dao.getUserInfo(uid);
			if (u.getUid() != null) {
				response.sendRedirect("/jw/ch09/users/list");
			} else {
				u = new User(uid, pwd, uname, email);
				dao.registerUser(u);

				response.sendRedirect("/jw/ch09/users/list");
			}
			break;
		case "update":
			if (request.getMethod().equals("GET")) {
				uid = request.getParameter("uid");
				u = dao.getUserInfo(uid);
				request.setAttribute("user", u);
				RequestDispatcher rd = request.getRequestDispatcher("/ch09/users/updateView");
				rd.forward(request, response);
			} else {
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				uname = request.getParameter("uname");
				email = request.getParameter("email");

				u = new User(uname, email);
				dao.updateUser(u);

				response.sendRedirect("/jw/ch09/users/list");
			}
			break;
		case "delete":
			uid = request.getParameter("uid");
			dao.deleteUser(uid);
			response.sendRedirect("/jw/ch09/users/list");

		default:
			System.out.println(request.getMethod() + "잘못된 경로 입니다.");
		}
	}
}
