package sale.employee;

import sale.vegetable.Vegetable;

/**
 * 售货员
 */
public class Salesman extends Employee implements SellIface,ScanIface
{
	/**
	 * 标记售出
	 */
	public void markSale(Vegetable aVegetable)
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
