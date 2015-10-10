package sale.sale;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import sale.business.Business;
import sale.employee.Employee;
import sale.vegetable.Vegetable;

/**
 * ����������DAO
 */
public class MidSaleDao
{	
	/**
	 * ��ȡ�������ۼ�¼
	 */
	public List getAllRecord(String identifier)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM MidSale WHERE bidentifier='" + identifier + "'";
			Query query = session.createQuery(sql);
			List list = query.list();
			tx.commit();
			return list;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println(">> sale.sale.MidSaleDao - getAllRecord");
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
	 * ����һ�����ۼ�¼
	 */
	public void addSaleRecord(MidSale saleRecord)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(saleRecord);
			tx.commit();
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println(">> sale.sale.MidSaleDao - addSaleRecord");
			e.printStackTrace();
		}
		finally
		{
			sessionFactory.close();
			session.close();
		}
	}
	
	/**
	 * ��ѯ���ۼ�¼�Ƿ����
	 */
	public boolean isExistent(String videntifier, short effective)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM MidSale WHERE videntifier='" + videntifier + "' AND effective=" + effective;
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
			System.out.println(">> sale.sale.MidSaleDao - isExistent");
			e.printStackTrace();
			return false;
		} 
		catch (Exception e)
		{
			tx.rollback();
			System.out.println(">> sale.sale.MidSaleDao - isExistent");
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