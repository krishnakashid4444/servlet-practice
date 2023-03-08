import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class login extends HttpServlet {
	
	public void doPost(HttpServletRequest Req, HttpServletResponse Res ) throws IOException, ServletException
	{
		Res.setContentType("text/html");
		PrintWriter pw=Res.getWriter();
		
		String name=Req.getParameter("user name");
		String pass=Req.getParameter("pass");
		
		if(pass.equals("servlet"))
		{
			RequestDispatcher rd=Req.getRequestDispatcher("servlet2");
			rd.forward(Req,Res);
			
		}
		else
		{
			pw.print("sorry wrong input");
			RequestDispatcher rd=Req.getRequestDispatcher("/index.html");
			rd.include(Req,Res);
			
			
		}
	}

	

}
