package sale.vegetable;

import java.util.Date;

/**
 * 蔬菜类
 */
public class Vegetable
{	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNote()
	{
		return note;
	}
	
	public void setNote(String note)
	{
		this.note = note;
	}
	
	public short getEffective()
	{
		return effective;
	}

	public void setEffective(short effective)
	{
		this.effective = effective;
	}

	// 代理主键
	private long id;
	// 蔬菜小包编码
	private String identifier;
	// 蔬菜名称
	private String name;
	// 备注
	private String note;
	// 是否有效
	private short effective;
}
