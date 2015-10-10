package sale.employee;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * ��ԱDAO
 */
public class EmployeeDao implements EmployeeDaoIface
{	
	@Override
	/**
	 * ��ȡһ����������Ĺ�Ա
	 */
	public List getEmployees(String identifier)
	{
		
		return null;
	}

	@Override
	/**
	 * ��ȡһ����Ա
	 */
	public Employee getEmployee(String user)
	{
		return null;
	}

	@Override
	/**
	 * ƥ���Ա��Ϣ
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
	 * ����һ����Ա
	 */
	public void addEmployee(Employee employee)
	{
		
		
	}

	@Override
	/**
	 * ɾ��һ����Ա
	 */
	public void delEmployee(Employee employee)
	{
		
		
	}
	
	public static Configuration config = new Configuration().configure();
}
