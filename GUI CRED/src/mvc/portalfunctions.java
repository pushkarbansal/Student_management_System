package mvc;

import java.sql.ResultSet;

import sql.sqlfunction;

public class portalfunctions {

	public ResultSet getdata()
	{
		sqlfunction s=new sqlfunction();
		ResultSet rs=s.getdata();
		return rs;
	}
	
	public void delete(int userid)	
	{
		sqlfunction s=new sqlfunction();
		s.deleteuser(userid);

	}
	
	
	
	
	
}
