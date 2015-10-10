package sale.actions;

/**
 * 封装管理表单的JavaBean
 */
public class AdminBean
{	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public String getOperate() 
	{
		return operate;
	}
	
	public void setOperate(String operate) 
	{
		this.operate = operate;
	}
	
	public String getUser() 
	{
		return user;
	}
	
	public void setUser(String user) 
	{
		this.user = user;
	}
	
	public String getPwd() 
	{
		return pwd;
	}
	
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}
	
	public String getRpwd() 
	{
		return rpwd;
	}
	
	public void setRpwd(String rpwd) 
	{
		this.rpwd = rpwd;
	}
	
	private String type = "";
	private String operate = "";
	private String user = "";
	private String pwd = "";
	private String rpwd = "";
}
