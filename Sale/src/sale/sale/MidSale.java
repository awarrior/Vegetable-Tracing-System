package sale.sale;

import java.util.Date;

/**
 * ������������
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

	// ��һ��������������
	private String saleBIdentifier;
}
