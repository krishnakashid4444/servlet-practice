

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String RollNo=request.getParameter("roll");
		int roll=Integer.valueOf(RollNo);
		
		String qry="select * from result.info where RollNo=?";
	
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306?user=root&password=root");
		
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setInt(1,roll);
		
		out.print("<table width=50% border=1>");
		out.print("<caption>Result:</caption>");
		
		ResultSet rs=ps.executeQuery();
	
		/* Printing column names */
		ResultSetMetaData rsmd=rs.getMetaData();
		int total=rsmd.getColumnCount();
		out.print("<tr>");
		for(int i=1;i<=total;i++)
		{
			out.print("<th>"+rsmd.getColumnName(i)+"</th>");
		
		}
		
		out.print("</tr>");
		
		/* Printing result */
		
		while(rs.next())
		{
			out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
		
	
		}

		out.print("</table>");
	
		}catch  (Exception e2) {e2.printStackTrace();}
		
		finally{out.close();}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
