package sale.commons;

import java.util.Date;

/**
 * 今日日期类
 */
public class Today
{
	public Date getToday()
	{
		return today;
	}

	public void setToday(Date today)
	{
		this.today = today;
	}

	private Date today = new Date();
}
