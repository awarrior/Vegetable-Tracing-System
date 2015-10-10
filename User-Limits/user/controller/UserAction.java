package jyu.vtc.user.controller;

import java.util.ArrayList;
import java.util.List;

import jyu.vtc.model.Power;
import jyu.vtc.model.Role;
import jyu.vtc.model.User;
import jyu.vtc.user.service.AllService;
import jyu.vtc.user.vo.UserBean;

public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	AllService service = new AllService();
	// 添加用户
	private UserBean userBean = new UserBean();
	// 显示列表
	private List<UserBean> users = new ArrayList<UserBean>();
	// 选择的处理项id
	private String selectID = "";
	private String selectMember = "";
	// 显示角色可选列表
	private List<String> roles = new ArrayList<String>();

	public String getSelectMember() {
		return selectMember;
	}

	public void setSelectMember(String selectMember) {
		this.selectMember = selectMember;
	}

	public String getSelectID() {
		return selectID;
	}

	public void setSelectID(String selectID) {
		this.selectID = selectID;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * 显示用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showUsers() throws Exception {
		List<User> list = service.getUserService().getAllUser();
		for (int i = 0; i < list.size(); i++) {
			users.add(new UserBean(list.get(i).getUserId().toString(), list
					.get(i).getRole().getName()));
		}
		// 角色选项添加
		List<Role> rlist = service.getRoleService().getAllRole();
		for (int j = 0; j < rlist.size(); j++) {
			roles.add(rlist.get(j).getRoleId() + "." + rlist.get(j).getName());
		}
		getSession().put("item", "user");
		return SUCCESS;
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUser() throws Exception {
		service.getUserService().addUser(userBean.getId(),
				userBean.getPassword(), userBean.getRole());
		showUsers();
		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteUser() throws Exception {
		service.getUserService().deleteUser(selectID);
		showUsers();
		return SUCCESS;
	}

	/**
	 * 修改用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifyUser() throws Exception {
		getSession().put("id", selectID);
		// 标题
		User user = service.getUserService().getUser(selectID);
		String role = user.getRole().getName();
		selectMember = selectID + " " + role;
		// 列表
		List<Role> list = service.getRoleService().getAllRole();
		for (int j = 0; j < list.size(); j++) {
			roles.add(list.get(j).getRoleId() + "." + list.get(j).getName());
		}
		return SUCCESS;
	}

	/**
	 * 保存用户修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveUser() throws Exception {
		String id = (String) getSession().get("id");
		service.getUserService().updateUser(id, userBean.getPassword(),
				userBean.getRole());
		selectID = id;
		modifyUser();
		return SUCCESS;
	}
}
