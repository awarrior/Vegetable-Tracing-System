package sale.sale;

import java.util.Date;

/**
 * ������
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

	// ��������
	protected long id;
	// �߲��߲˱��
	protected String videntifier;
	// ��������������
	protected String bidentifier;
	// �ۻ�ԱID
	protected String salesman;
	// ����ʱ��
	protected Date saleDate;
	// �Ƿ���Ч
	protected short effective;
}
