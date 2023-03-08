

import javax.servlet.http.*;

import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.*;
import java.io.*;


public class Demoserlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest Req, HttpServletResponse Res) throws IOException, ServletException
	{
		Res.setContentType("text/html");
		PrintWriter pw=Res.getWriter();
		
		String name = Req.getParameter("name");
				pw.println("welcome"+name);
				pw.close();
				
	}

	

}
