package sale.employee;

/**
 * ְԱ��
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
	
	// ��������
	private long id;
	// ��������������
	private String bidentifier;
	// �˻�ID
	private String user;
	// �˻�����
	private char[] password;
	// �˻�Ȩ��
	private char permission;
	// �Ƿ���Ч
	private short effective;
}
