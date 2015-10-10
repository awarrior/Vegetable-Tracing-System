package sale.actions;

import sale.employee.Employee;
import sale.employee.EmployeeDao;
import sale.sale.EndSaleDao;
import sale.sale.MidSaleDao;

/**
 * 用户登录
 */
public class LoginAction extends BaseAction
{
	@Override
	public void validate()
	{
		super.validate();
		if(loginBean.getUser().equals(""))
			this.addFieldError("loginBean.user", "用户名不能为空！");
		else if(loginBean.getPwd().length == 0)
			this.addFieldError("loginBean.pwd", "密码不能为空！");
		else if(loginBean.getType().equals(""))
			this.addFieldError("loginBean.type", "用户类型不能为空！");
		else if(!checkout(translate()))
			this.addFieldError("loginBean.user", "登录失败！");
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
	 * 检查用户登录信息
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
	 * 登录用户类型信息转换
	 */
	public char translate()
	{
		if(loginBean.getType().equals("管理员"))
			return '0';
		if(loginBean.getType().equals("采购员"))
			return '1';
		if(loginBean.getType().equals("售货员"))
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
