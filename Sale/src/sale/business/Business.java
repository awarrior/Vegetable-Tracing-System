package sale.business;

public class Business
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

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
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
	// 销售网点主体码
	private String identifier;
	// 销售网点名称
	private String name;
	// 销售网点地址
	private String address;
	// 是否有效
	private short effective;
}
