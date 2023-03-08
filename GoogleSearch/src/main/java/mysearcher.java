import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class mysearcher extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest Req, HttpServletResponse Res) throws IOException, ServletException
	{
		String name=Req.getParameter("name");
		Res.sendRedirect("https://www.google.co.in/#q="+name);
	}

	
}
