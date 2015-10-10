package sale.business;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * 销售网点DAO
 */
public class BusinessDao
{
	/**
	 * 判断销售网点是否存在及有效
	 */
	public boolean isEffective(String identifier)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM Business WHERE identifier='" + identifier + "'";
			Query query = session.createQuery(sql);
			List list = query.list();
			if(!list.isEmpty())
			{
				if(list.size() != 1)
					throw new Exception();
				Business e = (Business)list.get(0);
				if(e.getEffective() == 0)
				{
					tx.commit();
					return false;
				}
				else
				{
					tx.commit();
					return true;
				}
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
			System.out.println(">> sale.employee.EmployeeDao - isEffective");
			e.printStackTrace();
			return false;
		}
		catch (Exception e)
		{
			tx.rollback();
			System.out.println(">> sale.vegetable.VegetableDao - isEffective");
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
