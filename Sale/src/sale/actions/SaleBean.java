package sale.actions;

/**
 * 封装销售表单的JavaBean
 */
public class SaleBean
{	
	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getNum()
	{
		return num;
	}

	public void setNum(String num)
	{
		this.num = num;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	private String type = "";
	private String num = "";
	private String code = "";
}
