package sale.employee;

import sale.vegetable.Vegetable;

/**
 * 采购接口
 */
public interface PurchaseIface
{
	// 确认合格
	boolean makeSure(Vegetable aVegetable);
	// 标价
	void markPrice(Vegetable aVegetable, float price);
}
