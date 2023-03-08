import javax.servlet.*;

import javax.servlet.http.*;
import java.io.*;

public class WelcomeServlet extends HttpServlet{

	public void doPost(HttpServletRequest Req, HttpServletResponse Res) throws IOException, ServletException
	{
		Res.setContentType("text.html");
		
		PrintWriter out =Res.getWriter();
		
		String name=Req.getParameter("user name");
		out.print("welcome"+name);
		
	}

}
