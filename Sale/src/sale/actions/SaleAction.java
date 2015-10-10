package sale.actions;

import sale.business.BusinessDao;
import sale.commons.Today;
import sale.employee.Employee;
import sale.purchase.PurchaseDao;
import sale.sale.*;
import sale.vegetable.VegetableDao;

/**
 * �߲�����
 */
public class SaleAction extends BaseAction
{
	@Override
	public void validate()
	{
		super.validate();
		if(saleBean.getType().equals(""))
			this.addFieldError("saleBean.type", "�۳������Ͳ���Ϊ�գ�");
		else if(saleBean.getNum().equals(""))
			this.addFieldError("saleBean.num", "�۳����Ų���Ϊ�գ�");
		else if(saleBean.getCode().equals(""))
			this.addFieldError("saleBean.code", "�߲˱�Ų���Ϊ�գ�");
		else if(saleBean.getType().equals("������") && 
				saleBean.getNum().length()!= MIDSALE_NUM_LENGTH)
			this.addFieldError("saleBean.num", "�۳����ų��Ȳ���ȷ��");
		else if(saleBean.getCode().length() != CODE_NUM_LENGTH)
			this.addFieldError("saleBean.code", "�߲˱�ų��Ȳ���ȷ��");
		else
		{
			if(saleBean.getType().equals("������"))
			{
				BusinessDao dao = new BusinessDao();
				if(!dao.isEffective(saleBean.getNum()))
				{
					this.addFieldError("saleBean.num", "���������Ų����ڣ�");
					return;
				}
			}
			
			VegetableDao vDao = new VegetableDao();
			if(!vDao.isEffective(saleBean.getCode()))
			{
				this.addFieldError("saleBean.code", "�߲��߲˱�Ų����ڣ�");
				return;
			}
			
			PurchaseDao pDao = new PurchaseDao();
			short effective = vDao.getEffective(saleBean.getCode());
			if(!pDao.isExistent(saleBean.getCode(), effective))
			{
				this.addFieldError("saleBean.code", "�߲���δ�Ǽǲɹ���");
				return;
			}
			
			if(saleBean.getType().equals("������"))
			{
				MidSaleDao mDao = new MidSaleDao();
				if(mDao.isExistent(saleBean.getCode(), effective))
					this.addFieldError("saleBean.code", "�߲������ۣ�");
			}
			else if(saleBean.getType().equals("������"))
			{
				EndSaleDao eDao = new EndSaleDao();
				if(eDao.isExistent(saleBean.getCode(), effective))
					this.addFieldError("saleBean.code", "�߲������ۣ�");
			}
		}
	}

	@Override
	public String execute() throws Exception
	{
		VegetableDao vDao = new VegetableDao();
		short effective = vDao.getEffective(saleBean.getCode());
		
		if(saleBean.getType().equals("������"))
		{
			MidSaleDao dao = new MidSaleDao();
			Employee e = (Employee)getSession().get("loginUser");
			Today t = new Today();
			MidSale sale = new MidSale(saleBean.getCode(), e.getBidentifier(), 
					e.getUser(), t.getToday(), saleBean.getNum(), effective);
			dao.addSaleRecord(sale);
			
			vDao.increase(saleBean.getCode());
		}
		else if(saleBean.getType().equals("̯λ��"))
		{
			EndSaleDao dao = new EndSaleDao();
			Employee e = (Employee)getSession().get("loginUser");
			Today t = new Today();
			EndSale sale = new EndSale(saleBean.getCode(), e.getBidentifier(), 
					e.getUser(), t.getToday(), saleBean.getNum(), effective);
			dao.addSaleRecord(sale);
		}
		else return INPUT;
		
		getSession().put("saleSuccess", "���۳� "+saleBean.getCode());
		
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
	
	// �������������ų���
	private final int MIDSALE_NUM_LENGTH = 9;
	// �߲˱�ų���
	private final int CODE_NUM_LENGTH = 28;
}
