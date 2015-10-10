package sale.purchase;

import java.util.Date;

/**
 * 采购类
 */
public class Purchase
{
	public Purchase(){}
	
	public Purchase(String videntifier, String bidentifier, String registrar,
			float price, Date purchaseDate, short effective) 
	{
		this.videntifier = videntifier;
		this.bidentifier = bidentifier;
		this.registrar = registrar;
		this.price = price;
		this.purchaseDate = purchaseDate;
		this.effective = effective;
	}

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

	public String getRegistrar()
	{
		return registrar;
	}
	
	public void setRegistrar(String registrar)
	{
		this.registrar = registrar;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public Date getPurchaseDate()
	{
		return purchaseDate;
	}
	
	public void setPurchaseDate(Date purchaseDate)
	{
		this.purchaseDate = purchaseDate;
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
	// 蔬菜小包编码
	private String videntifier;
	// 销售网点主体码
	private String bidentifier;
	// 采购员ID
	private String registrar;
	// 蔬菜价格
	private float price;
	// 采购时间
	private Date purchaseDate;
	// 是否有效
	private short effective;
}
