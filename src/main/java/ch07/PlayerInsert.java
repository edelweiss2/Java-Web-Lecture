package ch07;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayerInsert
 */
@WebServlet("/ch07/registerPlayer")
public class PlayerInsert extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		PlayerDao dao = new PlayerDao();
		
		Player p = dao.getPlayer(backNumber);
		if(p.getName() != null)
			response.sendRedirect("/jw/ch07/registerPlayer.html");
		else {
			p = new Player(backNumber, name);
			dao.insertPlayer(p);
		
			response.sendRedirect("/jw/ch07/playerList");
		}
	}

}
