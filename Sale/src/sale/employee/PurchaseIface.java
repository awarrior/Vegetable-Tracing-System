package sale.employee;

import sale.vegetable.Vegetable;

/**
 * �ɹ��ӿ�
 */
public interface PurchaseIface
{
	// ȷ�Ϻϸ�
	boolean makeSure(Vegetable aVegetable);
	// ���
	void markPrice(Vegetable aVegetable, float price);
}
