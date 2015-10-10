package jyu.vtc.user.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	// private AllService allService = new AllService();
	//
	// public AllService getAllService() {
	// return allService;
	// }
	//
	// public void setAllService(AllService allService) {
	// this.allService = allService;
	// }
	private Map session;

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

}
