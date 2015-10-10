package sale.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sale.sale.EndSale;
import sale.sale.EndSaleDao;
import sale.sale.MidSale;
import sale.sale.MidSaleDao;

/**
 * 销售session格式化类
 */
public class SaleSession
{
	/**
	 * 返回所有格式化的经销商销售记录
	 */
	public ArrayList<SalePresent> midSaleFormat(String identifier)
	{
		List list = new MidSaleDao().getAllRecord(identifier);
		ArrayList<SalePresent> array = new ArrayList<SalePresent>();
		for(int i=0; i<list.size(); i++)
		{
			MidSale sale = (MidSale)list.get(i);
			String date = new SimpleDateFormat("yyyy-MM-dd").format(sale.getSaleDate());
			array.add(new SalePresent(sale.getvidentifier(), sale.getSalesman(), date, sale.getSaleBIdentifier()));
		}
		return array;
	}
	
	/**
	 * 返回所有格式化的零售商销售记录
	 */
	public ArrayList<SalePresent> endSaleFormat(String identifier)
	{
		List list = new EndSaleDao().getAllRecord(identifier);
		ArrayList<SalePresent> array = new ArrayList<SalePresent>();
		for(int i=0; i<list.size(); i++)
		{
			EndSale sale = (EndSale)list.get(i);
			String date = new SimpleDateFormat("yyyy-MM-dd").format(sale.getSaleDate());
			array.add(new SalePresent(sale.getvidentifier(), sale.getSalesman(), date, sale.getSaleBooth()));
		}
		return array;
	}
}

/**
 * 封装呈现销售信息类
 */
class SalePresent
{
	public SalePresent(){}

	public SalePresent(String identifier, String salesman, String date, String salePlace)
	{
		this.identifier = identifier;
		this.salesman = salesman;
		this.date = date;
		this.salePlace = salePlace;
	}

	public String getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getSalesman()
	{
		return salesman;
	}

	public void setSalesman(String salesman)
	{
		this.salesman = salesman;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getSalePlace()
	{
		return salePlace;
	}

	public void setSalePlace(String salePlace)
	{
		this.salePlace = salePlace;
	}

	// 蔬菜编号
	private String identifier;
	// 售货员
	private String salesman;
	// 销售日期
	private String date;
	// 销售点
	private String salePlace;
}
