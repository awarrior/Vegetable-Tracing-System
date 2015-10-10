package sale.actions;

import sale.employee.Employee;
import sale.employee.EmployeeDao;
import sale.sale.EndSaleDao;
import sale.sale.MidSaleDao;

/**
 * �û���¼
 */
public class LoginAction extends BaseAction
{
	@Override
	public void validate()
	{
		super.validate();
		if(loginBean.getUser().equals(""))
			this.addFieldError("loginBean.user", "�û�������Ϊ�գ�");
		else if(loginBean.getPwd().length == 0)
			this.addFieldError("loginBean.pwd", "���벻��Ϊ�գ�");
		else if(loginBean.getType().equals(""))
			this.addFieldError("loginBean.type", "�û����Ͳ���Ϊ�գ�");
		else if(!checkout(translate()))
			this.addFieldError("loginBean.user", "��¼ʧ�ܣ�");
	}
	
	@Override
	public String execute() throws Exception
	{
		getSession().put("loginUser", employee);
		switch(translate())
		{
		case '0':
			return "admin";
		case '1':
			getSession().put("purchaseArray", new PurchaseSession().purchaseFormat(employee.getBidentifier()));
			return "purchase";
		case '2':
			getSession().put("midSaleArray", new SaleSession().midSaleFormat(employee.getBidentifier()));
			getSession().put("endSaleArray", new SaleSession().endSaleFormat(employee.getBidentifier()));
			return "sale";
		default:
			return "input";
		}
	}
	
	/**
	 * ����û���¼��Ϣ
	 */
	private boolean checkout(char permission)
	{
		EmployeeDao dao = new EmployeeDao();
		employee = dao.checkout(loginBean.getUser(), loginBean.getPwd(), permission);
		if(employee != null)
		{
			loginBean.setPwd("");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * ��¼�û�������Ϣת��
	 */
	public char translate()
	{
		if(loginBean.getType().equals("����Ա"))
			return '0';
		if(loginBean.getType().equals("�ɹ�Ա"))
			return '1';
		if(loginBean.getType().equals("�ۻ�Ա"))
			return '2';
		return 'x';
	}
	
	public LoginBean getLoginBean()
	{
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean)
	{
		this.loginBean = loginBean;
	}

	private LoginBean loginBean = new LoginBean();
	
	private Employee employee;
}
