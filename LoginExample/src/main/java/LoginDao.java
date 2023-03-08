import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	public static boolean validate (String Name,String Pass){
		boolean status=false;
		
		String qry="select * from userreg.info where Name=? and Pass=?";
		
		
		try{
			
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306?user=root&password=root");
		
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setString(1,Name);
		ps.setString(2,Pass);
		
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
}


