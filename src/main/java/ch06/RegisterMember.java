package ch06;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class regMember
 */
@WebServlet("/ch06/regMember")
public class RegisterMember extends HttpServlet {
	private static final String[] GENDER_LIST = {"남자", "여자"};	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");		
		
		String data = "uid: " + uid + "\n";		
		data += "pwd: " + pwd + "\n";
		data += "pwd2: " + pwd2 + "\n";
		data += "이름: " + name + "\n";
		data += "생일: " + birthday + "\n";
		data += "성별: " + GENDER_LIST[Integer.parseInt(gender)] + "\n";
		for(String hobby: hobbies) {
			data += "취미: " + hobby + "\n";
		}
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print("<title>회원 가입</title>");
		out.print("</head>");
		out.print("<body style=\"margin:40px;\">");
		out.print("<h1>회원 가입</h1>");
		out.print("<hr>");		
		
		String[] ulList = data.split("\n");
		out.print(" <ul>");
		for (String li : ulList) {
			out.print("		<li>" + li + "</li>");
		}
		out.print(" </ul>");
		
		out.print("<br>");
		out.print("<button onclick=\"location.href='/jw/ch06/registerMember.html'\">재실행</button>");
		out.print("</body>");
		out.print("</html>");
		
	}
}
