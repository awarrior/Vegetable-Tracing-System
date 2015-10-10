package sale.sale;

import java.util.Date;

/**
 * 经销商销售类
 */
public class MidSale extends Sale
{
	public MidSale(){}
	
	public MidSale(String videntifier, String bidentifier, String salesman, 
			Date saleDate, String saleBIdentifier, short effective)
	{
		this.videntifier = videntifier;
		this.bidentifier = bidentifier;
		this.salesman = salesman;
		this.saleDate = saleDate;
		this.saleBIdentifier = saleBIdentifier;
		this.effective = effective;
	}
	
	public String getSaleBIdentifier()
	{
		return saleBIdentifier;
	}

	public void setSaleBIdentifier(String saleBIdentifier)
	{
		this.saleBIdentifier = saleBIdentifier;
	}

	// 下一销售网点主体码
	private String saleBIdentifier;
}
