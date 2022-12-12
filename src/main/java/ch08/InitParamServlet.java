package ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(
		urlPatterns = { 
				"/ch08/init", 
				"/ch08/init2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@web.com", description = "관리자 email"), 
				@WebInitParam(name = "tel", value = "010-2345-6789", description = "관리자 tel")
		})
public class InitParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		String servletPath = request.getServletPath();
		System.out.println(email);
		System.out.println(tel);
		System.out.println(servletPath);
		
		if(servletPath.indexOf("init2")>=0)
			System.out.println("init2에서 처리해주어야 하는일");
		else
			System.out.println("init에서 처리해주어야 하는일");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
