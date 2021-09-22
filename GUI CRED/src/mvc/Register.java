package mvc;

import sql.sqlfunction;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class Register {
	user u;
	
	public Register(user u)
	{
		this.u=u;
		sqlfunction s1=new sqlfunction();
		s1.registerUser(u);
	}


	
}

