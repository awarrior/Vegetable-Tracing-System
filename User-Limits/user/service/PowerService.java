package jyu.vtc.user.service;

import java.util.ArrayList;
import java.util.List;

import jyu.vtc.model.HibernateSessionFactory;
import jyu.vtc.model.Power;
import jyu.vtc.model.Role;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PowerService {
	private AllDAO allDAO = new AllDAO();

	public AllDAO getAllDAO() {
		return allDAO;
	}

	public void setAllDAO(AllDAO allDAO) {
		this.allDAO = allDAO;
	}

	/**
	 * 获取所有权限
	 * 
	 * @return
	 */
	public List<Power> getAllPower() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		List<Power> list = allDAO.getPowerDAO().findAll();
		tx.commit();

		session.close();
		return list;
	}

	/**
	 * 添加权限
	 * 
	 * @param resource
	 */
	public void addPower(String resource) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		System.out.println("smile:) add resource " + resource);
		allDAO.getPowerDAO().save(new Power(resource, null));
		tx.commit();

		session.close();
	}

	/**
	 * 删除权限
	 * 
	 * @param id
	 */
	public void deletePower(int id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		System.out.println("smile:) delete id " + id);
		Power power = (Power) allDAO.getPowerDAO().findById(id);
		allDAO.getPowerDAO().delete(power);
		tx.commit();

		session.close();
	}

	/**
	 * 获取剩余权限
	 * 
	 * @param preList
	 * @return
	 */
	public List<Power> findLeavePowers(List<Power> preList) {
//		Session session = HibernateSessionFactory.getSession();
//		Transaction tx = session.beginTransaction();

//		tx.begin();
		List<Power> all = getAllPower();
		List<Power> leave = new ArrayList<Power>();
		for (int i = 0; i < all.size(); i++) {
			boolean flag = true;
			for (int j = 0; j < preList.size(); j++) {
				if (all.get(i).getPowerId().equals(preList.get(j).getPowerId())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				leave.add(all.get(i));
			}
		}
		System.out.println("smile:) get " + leave.size() + " left powers");
//		tx.commit();

//		session.close();
		return leave;
	}
	
	/**
	 * 获取权限对象
	 * 
	 * @param id
	 * @return
	 */
	public Power getPower(int id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		Power power = (Power)allDAO.getPowerDAO().findById(id);
//		System.out.println("smile:) get role " + id + "." + role.getName());
		tx.commit();

		session.close();
		return power;
	}
}
