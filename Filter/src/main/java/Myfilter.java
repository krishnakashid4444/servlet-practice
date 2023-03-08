import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myfilter implements Filter{
	
	public void init(FilterConfig arg0) throws ServletException
	{
		
	}
	
	public void doFilter(ServletRequest Req, ServletResponse Res,FilterChain chain)throws IOException,ServletException
	{
		PrintWriter pw=Res.getWriter();
		pw.print("filter is invoke before");
		
		
		chain.doFilter(Req,Res);  // sends request to the next resource
		
		pw.print("Filter is invoke after");
		
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

	
}
