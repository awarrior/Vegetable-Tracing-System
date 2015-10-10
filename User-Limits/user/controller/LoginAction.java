package jyu.vtc.user.controller;

import jyu.vtc.user.service.AllService;
import jyu.vtc.user.vo.LoginBean;


public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	AllService service = new AllService();
	private LoginBean loginBean = new LoginBean();

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String execute() throws Exception {
		if (service.getUserService().checkValidity(loginBean.getName(),
				loginBean.getPassword()))
			return SUCCESS;
		else
			return ERROR;
	}
}
