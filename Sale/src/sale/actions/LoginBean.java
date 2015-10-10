package sale.actions;

/**
 * 封装登录表单的JavaBean
 */
public class LoginBean
{
	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public char[] getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		char[] c = pwd.toCharArray();
		this.pwd = c;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
	private String user = "";
	private char[] pwd = {};
	private String type = "";
}
