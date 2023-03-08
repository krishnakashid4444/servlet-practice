import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyFilter implements Filter {
	
	FilterConfig config;

	public void init(FilterConfig config) throws ServletException 
	{
		this.config=config;
	}
	
	public void doFilter(ServletRequest Req, ServletResponse Res,FilterChain chain) throws IOException,ServletException
	{
		PrintWriter pw=Res.getWriter();
		
		String s=config.getInitParameter("construction");
		
		if(s.equals("yes"))
		{
			pw.print("page is under construction");
		}
		else
		{
			chain.doFilter(Req,Res);   // send request to the next resource
		}
		
		
	}
	public void destroy() {};

}
