package sale.sale;

import java.util.Date;

/**
 * ������������
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

	// ����̯λ��
	private String saleBooth;
}
