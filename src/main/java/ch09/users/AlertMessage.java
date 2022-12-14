package ch09.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlertMessage
 */
@WebServlet("/ch09/users/alertMsg")
public class AlertMessage extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String msg = (String) request.getAttribute("msg");
		String url = (String) request.getAttribute("url");
		String data = "<!DOCTYPE html>"
				+ "<html lang=\"ko\">"
				+ "<head>"
				+ "    <meta charset=\"UTF-8\">"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "    <title>알림 메세지</title>"
				+ "    <link rel=\"stylesheet\" href=\"http://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css\"/>"
				+ "    <link rel=\"stylesheet\" href=\"http://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css\"/>"
				+ "    <script src=\"http://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js\"></script>"
				+ "</head>"
				+ "<body>"
				+ "    <script>";
		data += "alertify.alert('" + msg + "', function() {";
		data += "            alertify.message('OK');";
		data += "location.href = '" + url + "';";
		data += "        });"
				+ "    </script>"
				+ "</body>"
				+ "</html>";
		out.print(data);
	}

}