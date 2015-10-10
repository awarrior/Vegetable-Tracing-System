package jyu.vtc.user.service;

import java.util.ArrayList;
import java.util.List;

import jyu.vtc.model.HibernateSessionFactory;
import jyu.vtc.model.Power;
import jyu.vtc.model.Role;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoleService {
	private AllDAO allDAO = new AllDAO();

	public AllDAO getAllDAO() {
		return allDAO;
	}

	public void setAllDAO(AllDAO allDAO) {
		this.allDAO = allDAO;
	}

	/**
	 * 获取所有角色
	 * 
	 * @return
	 */
	public List<Role> getAllRole() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		List<Role> list = allDAO.getRoleDAO().findAll();
		tx.commit();

		session.close();
		return list;
	}

	/**
	 * 添加角色
	 * 
	 * @param resource
	 */
	public void addRole(String name) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		System.out.println("smile:) add role " + name);
		allDAO.getRoleDAO().save(new Role(name, null, null));
		tx.commit();

		session.close();
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 */
	public void deleteRole(int id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		System.out.println("smile:) delete id " + id);
		Role role = (Role) allDAO.getRoleDAO().findById(id);
		allDAO.getRoleDAO().delete(role);
		tx.commit();

		session.close();
	}

	/**
	 * 获取角色对象
	 * 
	 * @param id
	 * @return
	 */
	public Role getRole(int id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		Role role = (Role)allDAO.getRoleDAO().findById(id);
//		System.out.println("smile:) get role " + id + "." + role.getName());
		tx.commit();

		session.close();
		return role;
	}
	
	/**
	 * 获取剩余角色
	 * 
	 * @param preList
	 * @return
	 */
	public List<Role> findLeaveRoles(List<Role> preList) {
//		Session session = HibernateSessionFactory.getSession();
//		Transaction tx = session.beginTransaction();

//		tx.begin();
		List<Role> all = getAllRole();
		List<Role> leave = new ArrayList<Role>();
		for (int i = 0; i < all.size(); i++) {
			boolean flag = true;
			for (int j = 0; j < preList.size(); j++) {
				if (all.get(i).getRoleId().equals(preList.get(j).getRoleId())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				leave.add(all.get(i));
			}
		}
		System.out.println("smile:) get " + leave.size() + " left roles");
//		tx.commit();

//		session.close();
		return leave;
	}
}
