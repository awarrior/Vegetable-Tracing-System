package sale.employee;

import sale.vegetable.Vegetable;

/**
 * �ɹ�Ա
 */
public class Registrar extends Employee implements PurchaseIface,ScanIface
{
	/**
	 * ȷ�Ϻϸ�
	 */
	public boolean makeSure(Vegetable aVegetable)
	{
		return true;
	}
	
	/**
	 * ���
	 */
	public void markPrice(Vegetable aVegetable, float price)
	{
		
	}
	
	/**
	 * ��ȡ�߲˱���
	 */
	public Vegetable read(String indentifier)
	{
		return null;
	}
}
