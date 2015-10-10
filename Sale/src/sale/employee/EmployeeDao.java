package sale.employee;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * 雇员DAO
 */
public class EmployeeDao implements EmployeeDaoIface
{	
	@Override
	/**
	 * 获取一个销售网点的雇员
	 */
	public List getEmployees(String identifier)
	{
		
		return null;
	}

	@Override
	/**
	 * 获取一个雇员
	 */
	public Employee getEmployee(String user)
	{
		return null;
	}

	@Override
	/**
	 * 匹配雇员信息
	 */
	public Employee checkout(String user, char[] password, char permission)
	{
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String sql = "FROM Employee WHERE permission=" + permission + " AND user='" + user + "'";
			Query query = session.createQuery(sql);
			List list = query.list();
			if(!list.isEmpty())
			{
				Employee e = (Employee)list.get(0);
				if(e.getEffective() == 0)
					return null;
				char[] pwd = e.getPassword();
				if(pwd.length == password.length)
				{
					for(int i=0; i<pwd.length; i++)
					{
						if(pwd[i] != password[i])
						{
							return null;
						}
					}
					return e;
				}
			}
			tx.commit();
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println(">> sale.employee.EmployeeDao - checkout");
			e.printStackTrace();
		}
		finally
		{
			sessionFactory.close();
			session.close();
		}
		return null;
	}

	@Override
	/**
	 * 增加一个雇员
	 */
	public void addEmployee(Employee employee)
	{
		
		
	}

	@Override
	/**
	 * 删除一个雇员
	 */
	public void delEmployee(Employee employee)
	{
		
		
	}
	
	public static Configuration config = new Configuration().configure();
}
