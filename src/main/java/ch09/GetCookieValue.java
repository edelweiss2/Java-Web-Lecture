package ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieValue
 */
@WebServlet("/ch09/getCookie")
public class GetCookieValue extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for (Cookie c : cookies) {
			if (c.getName().equals("hangul-test")) {
				String kValue = URLDecoder.decode(c.getValue(), "utf-8");
				System.out.println(c.getName() + ", " + kValue);
				out.print("<h1>" + c.getName() + ", " + kValue + "</h1>");
			} else {
				System.out.println(c.getName() + ", " + c.getValue());
				out.print("<h1>" + c.getName() + ", " + c.getValue() + "</h1>");
			}
		}
	}
}
