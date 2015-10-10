package jyu.vtc.user.service;

import jyu.vtc.model.PowerDAO;
import jyu.vtc.model.RoleDAO;
import jyu.vtc.model.RoletopowerDAO;
import jyu.vtc.model.UserDAO;

public class AllDAO {
	private UserDAO userDAO = new UserDAO();
	private PowerDAO powerDAO = new PowerDAO();
	private RoleDAO roleDAO = new RoleDAO();
	private RoletopowerDAO roletopowerDAO = new RoletopowerDAO();

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public PowerDAO getPowerDAO() {
		return powerDAO;
	}

	public void setPowerDAO(PowerDAO powerDAO) {
		this.powerDAO = powerDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public RoletopowerDAO getRoletopowerDAO() {
		return roletopowerDAO;
	}

	public void setRoletopowerDAO(RoletopowerDAO roletopowerDAO) {
		this.roletopowerDAO = roletopowerDAO;
	}

}
