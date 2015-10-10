package sale.employee;

/**
 * 职员类
 */
public class Employee
{
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getBidentifier()
	{
		return bidentifier;
	}
	
	public void setBidentifier(String bidentifier)
	{
		this.bidentifier = bidentifier;
	}
	
	public String getUser()
	{
		return user;
	}
	
	public void setUser(String user)
	{
		this.user = user;
	}
	
	public char[] getPassword()
	{
		return password;
	}
	
	public void setPassword(char[] password)
	{
		this.password = password;
	}
	
	public char getPermission()
	{
		return permission;
	}
	
	public void setPermission(char permission)
	{
		this.permission = permission;
	}
	
	public short getEffective()
	{
		return effective;
	}
	
	public void setEffective(short effective)
	{
		this.effective = effective;
	}
	
	// 代理主键
	private long id;
	// 销售网点主体码
	private String bidentifier;
	// 账户ID
	private String user;
	// 账户密码
	private char[] password;
	// 账户权限
	private char permission;
	// 是否有效
	private short effective;
}
