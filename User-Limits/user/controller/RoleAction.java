package jyu.vtc.user.controller;

import java.util.ArrayList;
import java.util.List;

import jyu.vtc.model.Power;
import jyu.vtc.model.Role;
import jyu.vtc.user.service.AllService;
import jyu.vtc.user.vo.RelationBean;
import jyu.vtc.user.vo.RoleBean;

public class RoleAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	AllService service = new AllService();
	// 添加角色
	private RoleBean roleBean = new RoleBean();
	// 更新关系
	private RelationBean relationBean = new RelationBean();
	// 显示列表
	private List<RoleBean> roles = new ArrayList<RoleBean>();
	// 选择的处理项id
	private int selectID = -1;
	private String selectMember = "";
	// 修改角色对应权限
	private List<String> leftList = new ArrayList<String>();
	private List<String> rightList = new ArrayList<String>();

	public RelationBean getRelationBean() {
		return relationBean;
	}

	public void setRelationBean(RelationBean relationBean) {
		this.relationBean = relationBean;
	}

	public int getSelectID() {
		return selectID;
	}

	public void setSelectID(int selectID) {
		this.selectID = selectID;
	}

	public String getSelectMember() {
		return selectMember;
	}

	public void setSelectMember(String selectMember) {
		this.selectMember = selectMember;
	}

	public List<String> getLeftList() {
		return leftList;
	}

	public void setLeftList(List<String> leftList) {
		this.leftList = leftList;
	}

	public List<String> getRightList() {
		return rightList;
	}

	public void setRightList(List<String> rightList) {
		this.rightList = rightList;
	}

	public List<RoleBean> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBean> roles) {
		this.roles = roles;
	}

	public RoleBean getRoleBean() {
		return roleBean;
	}

	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}

	/**
	 * 显示权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showRoles() throws Exception {
		List<Role> list = service.getRoleService().getAllRole();
		for (int i = 0; i < list.size(); i++) {
			roles.add(new RoleBean(list.get(i).getRoleId().toString(), list
					.get(i).getName()));
		}
		getSession().put("item", "role");
		return SUCCESS;
	}

	/**
	 * 添加权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addRole() throws Exception {
		service.getRoleService().addRole(roleBean.getName());
		showRoles();
		return SUCCESS;
	}

	/**
	 * 删除权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteRole() throws Exception {
		service.getRoleService().deleteRole(selectID);
		showRoles();
		return SUCCESS;
	}

	/**
	 * 修改角色
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifyRole() throws Exception {
		getSession().put("id", selectID);
		// 标题
		Role role = service.getRoleService().getRole(selectID);
		String name = role.getName();
		selectMember = selectID + " " + name;
		// 列表左值
		List<Power> list = service.getRoletopowerService().getRolePowers(role);
		for (int i = 0; i < list.size(); i++) {
			leftList.add(list.get(i).getPowerId() + "."
					+ list.get(i).getResource());
		}
		// 列表右值
		list = service.getPowerService().findLeavePowers(list);
		for (int i = 0; i < list.size(); i++) {
			rightList.add(list.get(i).getPowerId() + "."
					+ list.get(i).getResource());
		}
		return SUCCESS;
	}

	/**
	 * 保存角色与权限的对应关系
	 * @return
	 * @throws Exception
	 */
	public String saveRole() throws Exception {
		int id = (Integer)getSession().get("id");
		Role role = service.getRoleService().getRole(id);
		service.getRoletopowerService().updatePowers(role, relationBean.getLeft());
		selectID = id;
		modifyRole();
		return SUCCESS;
	}
}
