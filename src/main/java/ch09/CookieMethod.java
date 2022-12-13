package ch09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieMethod
 */
@WebServlet("/ch09/cookieMethod")
public class CookieMethod extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "";
		for (Cookie c : cookies) {
			data = "<p>Name: " + c.getName() + ", Value: " + c.getValue();
			data += ", Path: " + c.getPath() + ", MaxAge: " + c.getMaxAge();
			data += ", Domain: " + c.getDomain() + "</p>";
		}
		out.print(data);
	}

}
