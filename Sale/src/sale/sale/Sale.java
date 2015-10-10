package sale.sale;

import java.util.Date;

/**
 * 销售类
 */
public class Sale
{
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}

	public String getvidentifier()
	{
		return videntifier;
	}

	public void setvidentifier(String videntifier)
	{
		this.videntifier = videntifier;
	}

	public String getBidentifier()
	{
		return bidentifier;
	}

	public void setBidentifier(String bidentifier)
	{
		this.bidentifier = bidentifier;
	}

	public String getSalesman()
	{
		return salesman;
	}
	
	public void setSalesman(String salesman)
	{
		this.salesman = salesman;
	}
	
	public Date getSaleDate()
	{
		return saleDate;
	}
	
	public void setSaleDate(Date saleDate)
	{
		this.saleDate = saleDate;
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
	protected long id;
	// 蔬菜蔬菜编号
	protected String videntifier;
	// 销售网点主体码
	protected String bidentifier;
	// 售货员ID
	protected String salesman;
	// 销售时间
	protected Date saleDate;
	// 是否有效
	protected short effective;
}
