package jyu.vtc.user.service;

import java.util.ArrayList;
import java.util.List;

import jyu.vtc.model.HibernateSessionFactory;
import jyu.vtc.model.Power;
import jyu.vtc.model.Role;
import jyu.vtc.model.Roletopower;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoletopowerService {
	private AllDAO allDAO = new AllDAO();

	public AllDAO getAllDAO() {
		return allDAO;
	}

	public void setAllDAO(AllDAO allDAO) {
		this.allDAO = allDAO;
	}

	/**
	 * 获取角色对应的权限
	 * 
	 * @param roleObject
	 * @return
	 */
	public List<Power> getRolePowers(Role roleObject) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		System.out.println("smile:) get powers to role "
				+ roleObject.getRoleId());
		List<Roletopower> rlist = allDAO.getRoletopowerDAO().findByProperty(
				"role", roleObject);
		List<Power> plist = new ArrayList<Power>();
		for (int i = 0; i < rlist.size(); i++) {
			plist.add(rlist.get(i).getPower());
			rlist.get(i).getPower().getResource();
		}
		tx.commit();

		session.close();
		return plist;
	}
	
	/**
	 * 获取权限对应的角色
	 * 
	 * @param roleObject
	 * @return
	 */
	public List<Role> getPowerRoles(Power powerObject) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		System.out.println("smile:) get roles to power "
				+ powerObject.getPowerId());
		List<Roletopower> plist = allDAO.getRoletopowerDAO().findByProperty(
				"power", powerObject);
		List<Role> rlist = new ArrayList<Role>();
		for (int i = 0; i < plist.size(); i++) {
			rlist.add(plist.get(i).getRole());
			plist.get(i).getRole().getName();
		}
		tx.commit();

		session.close();
		return rlist;
	}

	/**
	 * 更新角色权限对应关系
	 * 
	 * @param role
	 * @param left
	 */
	public void updatePowers(Role role, String[] left) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		List<Roletopower> list = allDAO.getRoletopowerDAO().findByProperty(
				"role", role);
		for (int i = 0; i < list.size(); i++) {
			boolean flag = false;
			for (int j = 0; j < left.length; j++) {
				String idStr = left[j].substring(0, left[j].indexOf('.'));
				if (list.get(i).getPower().getPowerId()
						.equals(Integer.parseInt(idStr))) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				Roletopower roletopower = (Roletopower) allDAO
						.getRoletopowerDAO().findById(list.get(i).getListId());
				allDAO.getRoletopowerDAO().delete(roletopower);
			}
		}
		if (left.length > list.size()) {
			int listLen = list.size();
			for (int i = 0; i < left.length; i++) {
				boolean flag = false;
				String id = left[i].substring(0, left[i].indexOf('.'));
				for (int j = 0; j < list.size(); j++) {
					if (id.equals(list.get(j).getPower().getPowerId()
							.toString())) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					Power power = (Power) allDAO.getPowerDAO().findById(
							Integer.parseInt(id));
					allDAO.getRoletopowerDAO().attachDirty(
							(new Roletopower(power, role)));
					listLen++;
				}
				if (listLen == left.length) {
					break;
				}
			}
		}
		System.out.println("smile:) update " + role.getRoleId() + " "
				+ role.getName() + " new powers");
		tx.commit();

		session.close();
	}
	
	/**
	 * 更新权限角色对应关系
	 * 
	 * @param power
	 * @param left
	 */
	public void updatePowers(Power power, String[] left) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		tx.begin();
		List<Roletopower> list = allDAO.getRoletopowerDAO().findByProperty(
				"power", power);
		for (int i = 0; i < list.size(); i++) {
			boolean flag = false;
			for (int j = 0; j < left.length; j++) {
				String idStr = left[j].substring(0, left[j].indexOf('.'));
				if (list.get(i).getRole().getRoleId()
						.equals(Integer.parseInt(idStr))) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				Roletopower roletopower = (Roletopower) allDAO
						.getRoletopowerDAO().findById(list.get(i).getListId());
				allDAO.getRoletopowerDAO().delete(roletopower);
			}
		}
		if (left.length > list.size()) {
			int listLen = list.size();
			for (int i = 0; i < left.length; i++) {
				boolean flag = false;
				String id = left[i].substring(0, left[i].indexOf('.'));
				for (int j = 0; j < list.size(); j++) {
					if (id.equals(list.get(j).getRole().getRoleId()
							.toString())) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					Role role = (Role) allDAO.getRoleDAO().findById(
							Integer.parseInt(id));
					allDAO.getRoletopowerDAO().attachDirty(
							(new Roletopower(power, role)));
					listLen++;
				}
				if (listLen == left.length) {
					break;
				}
			}
		}
		System.out.println("smile:) update " + power.getPowerId() + " "
				+ power.getResource() + " new roles");
		tx.commit();

		session.close();
	}
}
