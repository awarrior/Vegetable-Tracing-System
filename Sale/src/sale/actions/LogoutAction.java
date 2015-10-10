package sale.actions;


public class LogoutAction extends BaseAction
{
	@Override
	public String execute() throws Exception
	{
		getSession().clear();
		return SUCCESS;
	}	
}
