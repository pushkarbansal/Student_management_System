package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mvc.user;

//jdbc:mysql://127.0.0.1:3306/?user=root
public class sqlfunction {
	private static final String delete= "delete from student  where idusers=?;";

	public final String url="jdbc:mysql://127.0.0.1:3306/users";
	public final String user="root";
	public final String pass="500076495";
	private static final String update = "update student set username = ?, gender=? ,mobile_number=?,branch=? where idusers = ?";

	public String register="insert into student(username,gender,mobile_number,branch) value(?,?,?,?)";
	public String GetData="Select * from student";
	
	
	public void registerUser(user u )
	{
		int i=0;
		Connection con=getConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(register);
			 System.out.println("updated USer:"+stmt);
				stmt.setString(1,u.getname());
				stmt.setString(2,u.getgender());// 
				stmt.setString(3,u.getnumber());//
				stmt.setString(4,u.getbranch());
				  i =stmt.executeUpdate();
				 System.out.println(stmt);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void updateuser(user u,int id)
	{
		Connection con=getConnection();
		PreparedStatement stmt;
		try {
			  stmt=con.prepareStatement(update);
		    	stmt.setString(1, u.getname());
		    	stmt.setString(2, u.getgender());
		    	stmt.setString(3, u.getnumber());
		    	stmt.setString(4, u.getbranch());
		    	stmt.setString(5,id+"");
		    	 
		    	int result=stmt.executeUpdate();
		    	 }catch(Exception e)
		    	 {
		    		 System.out.println(e);
		    	 }
	}
	
	public ResultSet getdata()
	{

		int i=0;
		Connection con=getConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery(GetData);
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
		
	
public void deleteuser(int userid)
{

	int result=0;
	 Connection con=getConnection();
	 try {
	 PreparedStatement stmt=con.prepareStatement(delete);
	 stmt.setInt(1, userid);    
	 System.out.println(stmt);

	 result=stmt.executeUpdate();
 }catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	
Connection getConnection()
	
	{
	java.sql.Connection con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection(url,user,pass);
		System.out.print(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
		
	}
	
	
}
