package ch14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ElController1
 */
@WebServlet("/ch14/el2")
public class ElController2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] fruits = {"감", "귤", "배"};
		request.setAttribute("fruits", fruits);
		
		List<String> list = new ArrayList<>();
		list.add("축구");list.add("야구");list.add("배구");
		request.setAttribute("list", list);
		
		Map<String, Object> map = new HashMap<>();
		map.put("key", "el"); map.put("value", 3);
		request.setAttribute("map", map);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/collection.jsp");
		rd.forward(request, response);
	}

}