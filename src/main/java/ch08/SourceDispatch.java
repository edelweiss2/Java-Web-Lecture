package ch08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SourceDispatch
 */
@WebServlet("/ch08/src4")
public class SourceDispatch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/ch08/src4 doGet()");
		RequestDispatcher rd = request.getRequestDispatcher("/ch08/dst4?msg=한글");
		rd.forward(request, response);		// 서버에서 서버사이로 이동, 클라이언트 들리지않음
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
