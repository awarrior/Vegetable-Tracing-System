package sale.employee;

import sale.vegetable.Vegetable;

/**
 * 采购员
 */
public class Registrar extends Employee implements PurchaseIface,ScanIface
{
	/**
	 * 确认合格
	 */
	public boolean makeSure(Vegetable aVegetable)
	{
		return true;
	}
	
	/**
	 * 标价
	 */
	public void markPrice(Vegetable aVegetable, float price)
	{
		
	}
	
	/**
	 * 读取蔬菜编码
	 */
	public Vegetable read(String indentifier)
	{
		return null;
	}
}
