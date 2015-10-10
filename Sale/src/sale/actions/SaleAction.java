package sale.actions;

import sale.business.BusinessDao;
import sale.commons.Today;
import sale.employee.Employee;
import sale.purchase.PurchaseDao;
import sale.sale.*;
import sale.vegetable.VegetableDao;

/**
 * 蔬菜销售
 */
public class SaleAction extends BaseAction
{
	@Override
	public void validate()
	{
		super.validate();
		if(saleBean.getType().equals(""))
			this.addFieldError("saleBean.type", "售出点类型不能为空！");
		else if(saleBean.getNum().equals(""))
			this.addFieldError("saleBean.num", "售出点编号不能为空！");
		else if(saleBean.getCode().equals(""))
			this.addFieldError("saleBean.code", "蔬菜编号不能为空！");
		else if(saleBean.getType().equals("批发商") && 
				saleBean.getNum().length()!= MIDSALE_NUM_LENGTH)
			this.addFieldError("saleBean.num", "售出点编号长度不正确！");
		else if(saleBean.getCode().length() != CODE_NUM_LENGTH)
			this.addFieldError("saleBean.code", "蔬菜编号长度不正确！");
		else
		{
			if(saleBean.getType().equals("批发商"))
			{
				BusinessDao dao = new BusinessDao();
				if(!dao.isEffective(saleBean.getNum()))
				{
					this.addFieldError("saleBean.num", "销售网点编号不存在！");
					return;
				}
			}
			
			VegetableDao vDao = new VegetableDao();
			if(!vDao.isEffective(saleBean.getCode()))
			{
				this.addFieldError("saleBean.code", "蔬菜蔬菜编号不存在！");
				return;
			}
			
			PurchaseDao pDao = new PurchaseDao();
			short effective = vDao.getEffective(saleBean.getCode());
			if(!pDao.isExistent(saleBean.getCode(), effective))
			{
				this.addFieldError("saleBean.code", "蔬菜尚未登记采购！");
				return;
			}
			
			if(saleBean.getType().equals("批发商"))
			{
				MidSaleDao mDao = new MidSaleDao();
				if(mDao.isExistent(saleBean.getCode(), effective))
					this.addFieldError("saleBean.code", "蔬菜已销售！");
			}
			else if(saleBean.getType().equals("零售商"))
			{
				EndSaleDao eDao = new EndSaleDao();
				if(eDao.isExistent(saleBean.getCode(), effective))
					this.addFieldError("saleBean.code", "蔬菜已销售！");
			}
		}
	}

	@Override
	public String execute() throws Exception
	{
		VegetableDao vDao = new VegetableDao();
		short effective = vDao.getEffective(saleBean.getCode());
		
		if(saleBean.getType().equals("批发商"))
		{
			MidSaleDao dao = new MidSaleDao();
			Employee e = (Employee)getSession().get("loginUser");
			Today t = new Today();
			MidSale sale = new MidSale(saleBean.getCode(), e.getBidentifier(), 
					e.getUser(), t.getToday(), saleBean.getNum(), effective);
			dao.addSaleRecord(sale);
			
			vDao.increase(saleBean.getCode());
		}
		else if(saleBean.getType().equals("摊位号"))
		{
			EndSaleDao dao = new EndSaleDao();
			Employee e = (Employee)getSession().get("loginUser");
			Today t = new Today();
			EndSale sale = new EndSale(saleBean.getCode(), e.getBidentifier(), 
					e.getUser(), t.getToday(), saleBean.getNum(), effective);
			dao.addSaleRecord(sale);
		}
		else return INPUT;
		
		getSession().put("saleSuccess", "已售出 "+saleBean.getCode());
		
		Employee e = (Employee)getSession().get("loginUser");
		String business = e.getBidentifier();
		getSession().put("midSaleArray", new SaleSession().midSaleFormat(business));
		getSession().put("endSaleArray", new SaleSession().endSaleFormat(business));
		return SUCCESS;
	}
	
	public SaleBean getSaleBean()
	{
		return saleBean;
	}

	public void setSaleBean(SaleBean saleBean)
	{
		this.saleBean = saleBean;
	}

	private SaleBean saleBean = new SaleBean();
	
	// 经销商主体码编号长度
	private final int MIDSALE_NUM_LENGTH = 9;
	// 蔬菜编号长度
	private final int CODE_NUM_LENGTH = 28;
}
