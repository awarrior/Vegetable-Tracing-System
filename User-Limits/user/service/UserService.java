package jyu.vtc.user.service;

import java.util.List;

import jyu.vtc.model.HibernateSessionFactory;
import jyu.vtc.model.Role;
import jyu.vtc.model.User;
import jyu.vtc.model.UserDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {
	private AllDAO allDAO = new AllDAO();

	public AllDAO getAllDAO() {
		return allDAO;
	}

	public void setAllDAO(AllDAO allDAO) {
		this.allDAO = allDAO;
	}

	/**
	 * 检查有效性
	 * 
	 * @param user
	 */
	public boolean checkValidity(String name, char[] password) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		boolean returnValue = false;
		tx.begin();
		UserDAO userDao = allDAO.getUserDAO();
		User user = userDao.findById(name);
		if (user != null) {
			char[] cmp = user.getPassword().toCharArray();
			if (cmp.length == password.length) {
				int i = 0;
				for (; i < cmp.length; i++) {
					if (cmp[i] != password[i]) {
						System.out.println("smile:) password is error");
						returnValue = false;
						break;
					}
				}
				if (i == cmp.length) {
					System.out.println("smile:) id and password is correct");
					returnValue = true;
				}
			} else {
				System.out.println("smile:) password is error");
				returnValue = false;
			}
		} else {
			System.out.println("smile:) id is error");
			returnValue = false;
		}
		tx.commit();

		session.close();
		return returnValue;
	}

	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	public List<User> getAllUser() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		List<User> list = allDAO.getUserDAO().findAll();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).getRole().getName();
		}
		tx.commit();

		session.close();
		return list;
	}

	/**
	 * 添加用户
	 * 
	 * @param resource
	 */
	public void addUser(String id, String password, String roleid) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		System.out.println("smile:) add id " + id);
		// roleid的格式为: 1.salesman
		// 以.为分隔符
		roleid = roleid.substring(0, roleid.indexOf('.'));
		Role role = allDAO.getRoleDAO().findById(Integer.parseInt(roleid));
		allDAO.getUserDAO().save(new User(id, role, password));
		tx.commit();

		session.close();
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void deleteUser(String id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		System.out.println("smile:) delete id " + id);
		User user = (User) allDAO.getUserDAO().findById(id);
		allDAO.getUserDAO().delete(user);
		tx.commit();

		session.close();
	}

	/**
	 * 获取用户对象
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(String id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		User user = (User) allDAO.getUserDAO().findById(id);
		// System.out.println("smile:) get role " + id + "." + role.getName());
		tx.commit();

		session.close();
		return user;
	}

	/**
	 * 更新用户
	 * 
	 * @param id
	 * @param password
	 * @param role
	 */
	public void updateUser(String id, String password, String roleid) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		User user = (User) allDAO.getUserDAO().findById(id);
		user.setPassword(password);
		roleid = roleid.substring(0, roleid.indexOf('.'));
		Role role = allDAO.getRoleDAO().findById(Integer.parseInt(roleid));
		user.setPassword(password);
		user.setRole(role);
		System.out.println("smile:) update user " + id);
		tx.commit();

		session.close();
	}
}
