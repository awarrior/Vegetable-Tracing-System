package sale.purchase;

import java.util.Date;

/**
 * �ɹ���
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

	// ��������
	private long id;
	// �߲�С������
	private String videntifier;
	// ��������������
	private String bidentifier;
	// �ɹ�ԱID
	private String registrar;
	// �߲˼۸�
	private float price;
	// �ɹ�ʱ��
	private Date purchaseDate;
	// �Ƿ���Ч
	private short effective;
}
