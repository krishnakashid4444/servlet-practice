import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	public static Connection getConnection() {
		Connection con= null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static int save(Emp e) {
		int status=0;
		
		String qry="insert into user905.info (name,password,email,country)values(?,?,?,?)";
		
		try
		{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement(qry);
			
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			
			status=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
		
		
	}
	
	public static int update(Emp e)
	{
		int status=0;
		
		String qry="update user905.info set name=?, password=?, email=?, country=? where id=?";
		try
		{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement(qry);
			
			
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return status;
		
	}
	
	public static int delete(int id)
	{
		int status=0;
		
		String qry="delete from user905.info where id=?";
		try
		{
			Connection con=EmpDao.getConnection();
		    PreparedStatement  ps=con.prepareStatement(qry);
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
		
					
		
	}

	 public static Emp getEmployeeById(int id)
	 {
		 Emp e=new Emp();
		 
		 String qry="select * from user905.info where id=?";
		 
		 try
		 {
			Connection con=EmpDao.getConnection();
			 PreparedStatement ps=con.prepareStatement(qry);
			 ps.setInt(1,id);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
			 e.setId(rs.getInt(1));
			 e.setName(rs.getString(2));
			 e.setPassword(rs.getString(3));
			 e.setEmail(rs.getString(4));
			 e.setCountry(rs.getString(5));
			 }
			 con.close();
			 
			 
	 }
		 
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 return e;
		 
}
	 public static List<Emp> getAllEmployees(){
		 List<Emp> list=new ArrayList<Emp>();
		 
		 String qry="select * from user905.info";
		 
		 try
		 {
			 Connection con=EmpDao.getConnection();
			 PreparedStatement ps=con.prepareStatement(qry);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()){
			                     Emp e=new Emp();
				                  e.setId(rs.getInt(1));
				                  e.setName(rs.getString(2));
				                  e.setPassword(rs.getString(3));
				                  e.setEmail(rs.getString(4));
				                  e.setCountry(rs.getString(5));
				                   list.add(e);
		 }
			 con.close();
			 
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return list;
		 
		 
		 
	 }
	 
}

			 
