package ch07;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayerUpdate
 */
@WebServlet("/ch07/updatePlayer")
public class PlayerUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String backNumber_ = request.getParameter("backNumber");
		int backNumber = Integer.parseInt(backNumber_);
		
		PlayerDao dao = new PlayerDao();
		Player p = dao.getPlayer(backNumber);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "<!DOCTYPE html>"
				+ "<html lang=\"ko\">"
				+ "<head>"
				+ "    <meta charset=\"UTF-8\">"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "    <title>Update Player</title>"
				+ "    <style>"
				+ "        td { text-align: center; padding: 3px;}"
				+ "    </style>"
				+ "</head>"
				+ "<body style=\"margin: 40px;\">"
				+ "    <h1>선수 수정</h1>"
				+ "    <hr>"
				+ "    <form action=\"/jw/ch07/updatePlayer\" method=\"post\"> "
				+ "        <table>"
				+ "            <tr>"
				+ "                <td>등번호</td>";
		data += " <td><input type=\"text\" name=\"backNumber\" value=\""+ p.getBackNumber() +"\"></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td>선수 이름</td>";
		data += "<td><input type=\"text\" name=\"name\" value=\""+p.getName() +"\"></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td>포지션</td>";
		data += "  <td><input type=\"text\" name=\"position\" value=\""+p.getPosition()+"\" ></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td>생일</td>";
		data += "<td><input type=\"text\" name=\"bDay\" value=\""+p.getBday().toString() +"\" ></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td>키</td>";
		data += "<td><input type=\"text\" name=\"height\" value=\""+p.getHeight()+"\" ></td>";
		data += "            </tr>"
				+ "            <tr>"
				+ "                <td colspan=\"2\"><input type=\"submit\" value=\"수정\"></td>"
				+ "            </tr>"
				+ "        </table>"
				+ "    </form>   "
				+ "</body>"
				+ "</html>";
		out.print(data);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String backNumber_ = request.getParameter("backNumber");
		int backNumber = Integer.parseInt(backNumber_);
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		String bDay_ = request.getParameter("bDay");
		LocalDate bDay = LocalDate.parse(bDay_);
		String height_ = request.getParameter("height");
		int height = Integer.parseInt(height_);
		
		Player p = new Player(backNumber, name, position, bDay, height);
		PlayerDao dao = new PlayerDao();
		dao.updatePlayer(p);
		
		response.sendRedirect("/jw/ch07/playerList");
	}

}
