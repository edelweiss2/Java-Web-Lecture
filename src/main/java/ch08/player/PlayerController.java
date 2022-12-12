package ch08.player;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Controller
 */
@WebServlet(
		name = "PlayerController", 
		urlPatterns = { 
				"/ch08/player/list", 
				"/ch08/player/register", 
				"/ch08/player/update", 
				"/ch08/player/delete"
		})
public class PlayerController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletPath = request.getServletPath();
		PlayerDao dao = new PlayerDao();
		response.setContentType("text/html; charset=utf-8");
		
		if (servletPath.indexOf("list") > 0 ) {
			List<Player> list = dao.getPlayers();			
			request.setAttribute("playerList", list);
			RequestDispatcher rd = request.getRequestDispatcher("/ch08/player/listView"); //servlet context 내부에서 이동하니까 /jw/ 안붙음
			rd.forward(request, response);			
		} else if (servletPath.indexOf("register") > 0) {
			response.sendRedirect("/jw/ch08/player/register.html"); //클라이언트 거쳐서 오니까(redirect) /jw/가 붙음
		} else if (servletPath.indexOf("update") > 0) {
			String backNumber_ = request.getParameter("backNumber");
			int backNumber = Integer.parseInt(backNumber_);
			Player p = dao.getPlayer(backNumber);
			request.setAttribute("player", p);
			RequestDispatcher rd = request.getRequestDispatcher("/ch08/player/updateView");
			rd.forward(request, response);
		} else if (servletPath.indexOf("delete") > 0) {
			String backNumber_ = request.getParameter("backNumber");
			int backNumber = Integer.parseInt(backNumber_);
			dao.deletePlayer(backNumber);
			response.sendRedirect("/jw/ch08/player/list");
		} else {
			System.out.println("get 잘못된 경로 입니다.");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletPath = request.getServletPath();
		PlayerDao dao = new PlayerDao();
		response.setContentType("text/html; charset=utf-8");
		
		if (servletPath.indexOf("register") > 0) {
			String backNumber_ = request.getParameter("backNumber");
			int backNumber = Integer.parseInt(backNumber_);
			String name = request.getParameter("name");
			String position = request.getParameter("position");
			String bDay_ = request.getParameter("bDay");
			LocalDate bDay = LocalDate.parse(bDay_);
			String height_ = request.getParameter("height");
			int height = Integer.parseInt(height_);
			
			Player p = dao.getPlayer(backNumber);
			if(p.getName() != null)
				response.sendRedirect("/jw/ch08/player/register.html");
			else {
				p = new Player(backNumber, name, position, bDay, height);
				dao.insertPlayer(p);
			
				response.sendRedirect("/jw/ch08/player/list");
			}
		} else if (servletPath.indexOf("update") > 0) {
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
			dao.updatePlayer(p);
			
			response.sendRedirect("/jw/ch08/player/list");
		} else {
			System.out.println("post 잘못된 경로 입니다.");			
		}
	}

}
