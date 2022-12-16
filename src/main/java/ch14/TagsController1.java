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
@WebServlet("/ch14/tags1")
public class TagsController1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address addr1 = new Address(12345, "서울", "한국");
		Address addr2 = new Address(34567, "용인", "한국");
		Member m1 = new Member(101, "홍길동", addr1);
		Member m2 = new Member(102, "김자바", addr2);
		
		request.setAttribute("m1", m1);
		request.setAttribute("m2", m2);
		
		Member[] members = {m1, m2};
		request.setAttribute("members", members);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/tags.jsp");
		rd.forward(request, response);
	}

}