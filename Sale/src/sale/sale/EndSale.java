package sale.sale;

import java.util.Date;

/**
 * 零售商销售类
 */
public class EndSale extends Sale
{
	public EndSale(){}
	
	public EndSale(String videntifier, String bidentifier, String salesman, 
			Date saleDate, String saleBooth, short effective)
	{
		this.videntifier = videntifier;
		this.bidentifier = bidentifier;
		this.salesman = salesman;
		this.saleDate = saleDate;
		this.saleBooth = saleBooth;
		this.effective = effective;
	}
	
	public String getSaleBooth()
	{
		return saleBooth;
	}

	public void setSaleBooth(String saleBooth)
	{
		this.saleBooth = saleBooth;
	}

	// 销售摊位号
	private String saleBooth;
}
