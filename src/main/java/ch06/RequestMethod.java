package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestMethod
 */
@WebServlet("/ch06/reqMethod")
public class RequestMethod extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();		// jw
		String method = request.getMethod();				// get
		String requestUri = request.getRequestURI();		// /jw/ch06/reqMethod
		String serverName = request.getServerName();		// localhost
		String servletPath = request.getServletPath();		// /ch06/reqMethod
		String pathInfo = request.getPathInfo();			// null
		
		String data = "contextPath: " + contextPath + "\n";
		data += "method: " + method + "\n";
		data += "requestUri: " + requestUri + "\n";
		data += "serverName: " + serverName + "\n";
		data += "servletPath: " + servletPath + "\n";
		data += "pathInfo: " + pathInfo + "\n";
		System.out.println(data);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print("<title>Document</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>HttpServletRequest의 다양한 Method</h1>");
		out.print("<hr>");
		
//		out.print(data);
		String[] ulList = data.split("\n");
		out.print(" <ul>");
		for (String li : ulList) {
			out.print("		<li>" + li + "</li>");
		}
		out.print(" </ul>");
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
