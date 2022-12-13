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
				+ "    <title>Register User</title>"
				+ "    <style>"
				+ "        td { text-align: center; padding: 3px;}"
				+ "    </style>"
				+ "</head>"
				+ "<body style=\"margin: 40px;\">"
				+ "    <h1>사용자 등록</h1>"
				+ "    <hr>"
				+ "    <form action=\"/jw/ch09/users/update\" method=\"post\">        "
				+ "        <table>"
				+ "            <tr>"
				+ "                <td>UID</td>";
		data += "<td><input type=\"text\" name=\"uid\" value=\""+ u.getUid() +"\"></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td>PWD</td>";
		data += "<td><input type=\"text\" name=\"pwd\" value=\""+ u.getPwd()+"\"></td>";
		data += "</tr>"
				+ "            <tr>"
				+ "                <td>이름</td>";
		data += "<td><input type=\"text\" name=\"name\" value=\""+u.getUname()+"\" ></td>";
		data += "</tr>"
				+ "            <tr>"
				+ "                <td>Email</td>";
		data += "<td><input type=\"text\" name=\"email\" value=\""+u.getEmail()+"\" ></td>";
		data += " </tr>";						
		data += "            <tr>"
				+ "                <td colspan=\"2\"><input type=\"submit\" value=\"사용자등록\"></td>"
				+ "            </tr>"
				+ "        </table>"
				+ "    </form>"
				+ "</body>"
				+ "</html>";
		out.print(data);
	}

}
