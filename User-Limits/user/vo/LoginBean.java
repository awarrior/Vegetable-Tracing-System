package jyu.vtc.user.vo;

public class LoginBean
{
	private String name = "";
	private char[] password = {};

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public char[] getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		char[] c = password.toCharArray();
		this.password = c;
	}

}
