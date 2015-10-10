package sale.actions;

import sale.business.BusinessDao;
import sale.commons.Price;
import sale.commons.Today;
import sale.employee.Employee;
import sale.purchase.Purchase;
import sale.purchase.PurchaseDao;
import sale.sale.*;
import sale.vegetable.VegetableDao;

/**
 * 蔬菜采购
 */
public class PurchaseAction extends BaseAction
{
	@Override
	public void validate()
	{
		super.validate();
		if(purchaseBean.getPrice().equals(""))
			this.addFieldError("purchaseBean.price", "售价不能为空！");
		else if(purchaseBean.getCode().equals(""))
			this.addFieldError("purchaseBean.code", "蔬菜编号不能为空！");
		else if(!Price.isPrice(purchaseBean.getPrice()))
			this.addFieldError("purchaseBean.price", "标价错误！");
		else if(purchaseBean.getCode().length() != CODE_NUM_LENGTH)
			this.addFieldError("purchaseBean.code", "蔬菜编号长度不正确！");
		else
		{
			VegetableDao vDao = new VegetableDao();
			if(!vDao.isEffective(purchaseBean.getCode()))
			{
				this.addFieldError("purchaseBean.code", "蔬菜编号不存在！");
				return;
			}
			
			PurchaseDao pDao = new PurchaseDao();
			short effective = vDao.getEffective(purchaseBean.getCode());
			if(pDao.isExistent(purchaseBean.getCode(), effective))
			{
				this.addFieldError("purchaseBean.code", "蔬菜已进场！");
			}
		}
	}

	@Override
	public String execute() throws Exception
	{
		PurchaseDao pDao = new PurchaseDao();
		Employee e = (Employee)getSession().get("loginUser");
		VegetableDao vDao = new VegetableDao();
		short effective = vDao.getEffective(purchaseBean.getCode());
		Today t = new Today();
		float price = Float.parseFloat(Price.format(purchaseBean.getPrice()));
		Purchase pur = new Purchase(purchaseBean.getCode(), e.getBidentifier(), 
				e.getUser(), price, t.getToday(), effective);
		pDao.addPurchaseRecord(pur);
		
		getSession().put("purchaseSuccess", "已进场 "+purchaseBean.getCode());
		
		String business = e.getBidentifier();
		getSession().put("purchaseArray", new PurchaseSession().purchaseFormat(business));
		return SUCCESS;
	}
	
	public PurchaseBean getPurchaseBean()
	{
		return purchaseBean;
	}

	public void setPurchaseBean(PurchaseBean purchaseBean)
	{
		this.purchaseBean = purchaseBean;
	}

	private PurchaseBean purchaseBean = new PurchaseBean();
	
	// 蔬菜编号长度
	private final int CODE_NUM_LENGTH = 28;
}
