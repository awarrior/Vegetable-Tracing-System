package sale.vegetable;

import java.util.Date;

/**
 * �߲���
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

	// ��������
	private long id;
	// �߲�С������
	private String identifier;
	// �߲�����
	private String name;
	// ��ע
	private String note;
	// �Ƿ���Ч
	private short effective;
}
