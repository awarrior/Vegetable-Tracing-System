package sale.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��װ����session�Ļ�����
 */
public class BaseAction extends ActionSupport implements SessionAware
{
	public void setSession(Map session)
	{
		this.session = session;
	}
	
	public Map getSession()
	{
		return session;
	}
	
	private Map session;
}
