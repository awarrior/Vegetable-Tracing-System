package sale.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sale.commons.Price;
import sale.purchase.Purchase;
import sale.purchase.PurchaseDao;
import sale.sale.EndSale;
import sale.sale.EndSaleDao;
import sale.sale.MidSale;
import sale.sale.MidSaleDao;

/**
 * �ɹ�session��ʽ����
 */
public class PurchaseSession
{
	/**
	 * �������и�ʽ������������ɹ���¼
	 */
	public ArrayList<PurchasePresent> purchaseFormat(String identifier)
	{
		List list = new PurchaseDao().getAllRecord(identifier);
		ArrayList<PurchasePresent> array = new ArrayList<PurchasePresent>();
		for(int i=0; i<list.size(); i++)
		{
			Purchase pur = (Purchase)list.get(i);
			String date = new SimpleDateFormat("yyyy-MM-dd").format(pur.getPurchaseDate());
			String price = Price.format(pur.getPrice());
			array.add(new PurchasePresent(pur.getvidentifier(), pur.getRegistrar(), date, price));
		}
		return array;
	}
}

/**
 * ��װ���ֲɹ���Ϣ��
 */
class PurchasePresent
{
	public PurchasePresent(){}

	public PurchasePresent(String identifier, String registrar, String date, String price) 
	{
		this.identifier = identifier;
		this.registrar = registrar;
		this.date = date;
		this.price = price;
	}

	public String getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getRegistrar()
	{
		return registrar;
	}

	public void setRegistrar(String registrar)
	{
		this.registrar = registrar;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	// �߲˱��
	private String identifier;
	// �ɹ�Ա
	private String registrar;
	// �ɹ�����
	private String date;
	// ���ۼ۸�
	private String price;
}
