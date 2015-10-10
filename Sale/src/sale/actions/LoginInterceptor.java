package sale.actions;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * µÇÂ¼À¹½ØÆ÷
 */
public class LoginInterceptor extends MethodFilterInterceptor
{
	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception
	{
		LoginAction action = (LoginAction)invocation.getAction();
		if(action.translate() == '2')
			System.out.println("hello");
		final String result = invocation.invoke();
		return result;
	}
}
