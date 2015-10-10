package jyu.vtc.user.controller;


public class ExitAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception
	{
		getSession().clear();
		return SUCCESS;
	}
}
