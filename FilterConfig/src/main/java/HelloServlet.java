import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest Req,HttpServletResponse Res)throws IOException,ServletException
	{
		Res.setContentType("text/html");
		PrintWriter pw=Res.getWriter();
		
		pw.print("<br>Welcome to Servlet</br>");
		
	}

	

}
