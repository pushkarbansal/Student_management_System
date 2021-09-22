package mvc;
import sql.sqlfunction;

public class update {

	public update(user u,int id)
	{
		sqlfunction s=new sqlfunction();
		s.updateuser(u,id);
	}
	
}
