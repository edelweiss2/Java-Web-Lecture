package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gugudan
 */
@WebServlet("/ch06/gugudan")
public class Gugudan extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "<!DOCTYPE html>"
				+ "<html lang=\"ko\">"
				+ "<head>"
				+ "    <meta charset=\"UTF-8\">"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "    <title>구구단</title>"
				+ "</head>"
				+ "<body style=\"margin: 40px;\">"
				+ "    <h1>구구단</h1>"
				+ "    <hr>"
				+ "    <form action=\"/jw/ch06/gugudan\" method=\"post\">"
				+ "        출력할 구구단: <input type=\"number\" name=\"dan\"> <br><br>"
				+ "        <input type=\"submit\" value=\"확인\">"
				+ "    </form>"
				+ "</body>"
				+ "</html>";
		out.print(data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dan_ = request.getParameter("dan");
		int dan = Integer.parseInt(dan_);
		
		String data = "";
		for (int i=1; i<=9; i++) {
			data += dan + " x " + i + " = " + dan*i + "\n";
		}
		System.out.println(data);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print("<title>구구단</title>");
		out.print("</head>");
		out.print("<body style=\"margin:40px;\">");
		out.print("<h1>구구단</h1>");
		out.print("<hr>");		
		
		String[] pList = data.split("\n");
		out.print(" <h3>" + dan + "단</h3>");
		for (String p : pList) {
			out.print("		<p>" + p + "</p>");
		}
		
		out.print("<br>");
//		out.print("<button onclick=\"location.href='/jw/ch06/gugudan.html'\">재실행</button>");
		out.print("<button onclick=\"location.href='/jw/ch06/gugudan'\">재실행</button>");
		out.print("</body>");
		out.print("</html>");
	}

}
