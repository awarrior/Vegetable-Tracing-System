package sale.commons;

import java.util.Date;

/**
 * ����������
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
