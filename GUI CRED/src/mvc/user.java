package mvc;

public class user {
	String name;
	String branch;
	String number;
	String gender;
	
	public user(String a,String b,String c,String d)
	{
		name=a;
		branch=b;
		number=c;
		gender=d;
	}
	
	
	public String getname()
	{
		return this.name;
		
	}
	public String getbranch()
	{
		return this.branch;
		
	}
	public String getnumber()
	{
		return this.number;
		
	}
	public String getgender()
	{
		return this.gender;
		
	}
}
