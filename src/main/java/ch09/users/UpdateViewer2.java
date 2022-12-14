package ch09.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateView2
 */
@WebServlet("/ch09/users/updateView")
public class UpdateViewer2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User u = (User)request.getAttribute("user");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "<!DOCTYPE html>"
				 	+ "<html lang=\"ko\">" 
				 	+ "<head>"
				 	+ "    <meta charset=\"UTF-8\">"
				 	+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				 	+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				 	+ "    <title>회원 수정</title>"
				 	+ "    <style>"
				 	+ "        td { text-align: center; padding: 3px; }"
				 	+ "    </style>"
				 	+ "</head>"
				 	+ "<body style=\"margin: 40px;\">"
				 	+ "    <h1>회원 수정</h1>"
				 	+ "    <hr>"
				 	+ "    <form action=\"/jw/ch09/users/update\" method=\"post\">";
		data += "<input type=\"hidden\" name=\"uid\" value=\"" + u.getUid() + "\">";
		data += "        <table>"
				+ "            <tr>"
				+ "                <td>아이디:</td>";
		data += "<td><input type=\"text\" name=\"uid\" value=\"" + u.getUid() + "\" disabled></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td>이름:</td>";
		data += "<td><input type=\"text\" name=\"uname\" value=\"" + u.getUname() + "\"></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td>이메일:</td>";
		data += "<td><input type=\"email\" name=\"email\" value=\"" + u.getEmail() + "\"></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td colspan=\"2\"><input type=\"submit\" value=\"수정\">"
				+ "                <input type=\"reset\" value=\"취소\"></td>"
				+ "            </tr>"
				+ "        </table>"
				+ "    </form>"
				+ "</body>"
				+ "</html>";
				 	
		out.print(data);
	}

}
