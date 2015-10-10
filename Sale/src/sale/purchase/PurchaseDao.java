package sale.purchase;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import sale.business.Business;
import sale.employee.Employee;
import sale.sale.EndSale;
import sale.vegetable.Vegetable;

/**
 * 采购DAO
 */
public class PurchaseDao
{
	/**
	 * 获取所有采购记录
	 */
	public List getAllRecord(String identifier)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM Purchase WHERE bidentifier='" + identifier + "'";
			Query query = session.createQuery(sql);
			List list = query.list();
			tx.commit();
			return list;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println(">> sale.purchase.PurchaseDao - getAllRecord");
			e.printStackTrace();
		}
		finally
		{
			sessionFactory.close();
			session.close();
		}
		return null;
	}
	
	/**
	 * 增加一条采购记录
	 */
	public void addPurchaseRecord(Purchase purchaseRecord)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(purchaseRecord);
			tx.commit();
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println(">> sale.purchase.PurchaseDao - addPurchaseRecord");
			e.printStackTrace();
		}
		finally
		{
			sessionFactory.close();
			session.close();
		}
	}
	
	/**
	 * 查询采购记录是否存在
	 */
	public boolean isExistent(String videntifier, short effective)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM Purchase WHERE videntifier='" + videntifier + "' AND effective=" + effective;
			Query query = session.createQuery(sql);
			List list = query.list();
			if(!list.isEmpty())
			{
				if(list.size() != 1)
					throw new Exception();
				tx.commit();
				return true;
			}
			else
			{
				tx.commit();
				return false;
			}
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println(">> sale.purchase.PurchaseDao - isExistent");
			e.printStackTrace();
			return false;
		} 
		catch (Exception e)
		{
			tx.rollback();
			System.out.println(">> sale.purchase.PurchaseDao - isExistent");
			System.out.println(">> list.size() > 1");
			e.printStackTrace();
			return false;
		}
		finally
		{
			sessionFactory.close();
			session.close();
		}
	}
	
	public static Configuration config = new Configuration().configure();
}
