package sale.vegetable;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 蔬菜DAO
 */
public class VegetableDao
{
	/**
	 * 判断蔬菜编号是否存在及有效
	 */
	public boolean isEffective(String videntifier)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM Vegetable WHERE videntifier='" + videntifier + "'";
			Query query = session.createQuery(sql);
			List list = query.list();
			if(!list.isEmpty())
			{
				if(list.size() != 1)
					throw new Exception();
				Vegetable e = (Vegetable)list.get(0);
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
			System.out.println(">> sale.vegetable.VegetableDao - isEffective");
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
	
	/**
	 * 查询蔬菜编号对应的effective属性
	 */
	public short getEffective(String videntifier)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Boolean errorSelect = true;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM Vegetable WHERE videntifier='" + videntifier + "'";
			Query query = session.createQuery(sql);
			List list = query.list();
			if(list.size() == 1)
			{
				Vegetable e = (Vegetable)list.get(0);
				if(e.getEffective() == 0)
				{
					errorSelect = false;
					throw new Exception();
				}
				else
				{
					tx.commit();
					return e.getEffective();
				}
			}
			else
			{
				throw new Exception();
			}
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println(">> sale.vegetable.VegetableDao - isEffective");
			e.printStackTrace();
			return -1;
		} 
		catch (Exception e)
		{
			tx.rollback();
			System.out.println(">> sale.vegetable.VegetableDao - isEffective");
			if(errorSelect)
				System.out.println(">> list.size() != 1");
			else
				System.out.println(">> e.getEffective() == 0");
			e.printStackTrace();
			return -1;
		}
		finally
		{
			sessionFactory.close();
			session.close();
		}
	}
	
	/**
	 * effective属性自加
	 */
	public void increase(String videntifier)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM Vegetable WHERE videntifier='" + videntifier + "'";
			Query query = session.createQuery(sql);
			List list = query.list();
			if(list.size() == 1)
			{
				Vegetable v = (Vegetable)list.get(0);
				short e = v.getEffective();
				if(e != 0)
				{
					e++;
					v.setEffective(e);
					session.update(v);
					tx.commit();
				}
			}
			else
			{
				throw new Exception();
			}
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println(">> sale.vegetable.VegetableDao - increase");
			e.printStackTrace();
		} 
		catch (Exception e)
		{
			tx.rollback();
			System.out.println(">> sale.vegetable.VegetableDao - increase");
			System.out.println(">> list.size() > 1");
			e.printStackTrace();
		}
		finally
		{
			sessionFactory.close();
			session.close();
		}
	}
	
	public static Configuration config = new Configuration().configure();
}