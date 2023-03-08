import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HelloServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest Req, HttpServletResponse Res)throws IOException,ServletException
	{
		Res.setContentType("text/html");
		PrintWriter pw=Res.getWriter();
		pw.print("<br> welcome to servlet</br>");
				
	}

	

}
