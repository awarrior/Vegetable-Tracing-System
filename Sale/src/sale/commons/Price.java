package sale.commons;

/**
 * 价格工具类
 */
public class Price 
{
	/**
	 * 判断是否为价格格式
	 */
	public static boolean isPrice(String str)
	{
		boolean dot = false;
		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if(c>='0' && c<='9')
				continue;
			else if(c == '.' && !dot)
			{
				dot = true;
				continue;
			}
			else
				return false;
		}
		return true;
	}
	
	/**
	 * 格式化标价 - 用于显示
	 */
	public static String format(float price)
	{
		String p = Float.toString(price);
		int dot = p.indexOf('.');
		if(p.length() == dot+2)
			p += "0";
		return p;
	}
	
	/**
	 * 格式化标价 - 用于存储
	 */
	public static String format(String price)
	{
		int dot = price.indexOf('.');
		if(dot == -1)
			return price;
		if(price.length() > dot+3)
			price = price.substring(0, dot+3);
		return price;
	}
}
