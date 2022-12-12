package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextInfo
 */
@WebServlet("/ch08/info")
public class ContextInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// context와 ctx는 동일
		ServletContext context = request.getServletContext();
		ServletContext ctx = getServletContext();
		
		System.out.println("MajorVersion: " + ctx.getMajorVersion());
		System.out.println("RealPath: " + ctx.getRealPath("/ch08/info"));
		System.out.println("ServerInfo: " + ctx.getServerInfo());
		System.out.println("ServletContextName: " + ctx.getServletContextName());
		
		// web.xml에 등록되어있는 초기 설정값을 읽어옴
		String menu = ctx.getInitParameter("menu");
		System.out.println("web.xml 데이터 menu: " + menu);
		
		// WEB-INF/temp/test.txt에서 데이터 읽기
		InputStream is = ctx.getResourceAsStream("/WEB-INF/temp/test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String data = "";
		while (true) {
			String temp = br.readLine();
			if(temp == null)
				break;
			data += temp;
		}
		System.out.println("File Data: " + data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
