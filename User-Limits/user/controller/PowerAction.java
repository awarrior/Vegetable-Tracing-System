package jyu.vtc.user.controller;

import java.util.ArrayList;
import java.util.List;

import jyu.vtc.model.Power;
import jyu.vtc.model.Role;
import jyu.vtc.user.service.AllService;
import jyu.vtc.user.vo.PowerBean;
import jyu.vtc.user.vo.RelationBean;


public class PowerAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	AllService service = new AllService();
	// 添加权限
	private PowerBean powerBean = new PowerBean();
	// 更新关系
	private RelationBean relationBean = new RelationBean();
	// 显示列表
	private List<PowerBean> powers = new ArrayList<PowerBean>();
	// 选择的处理项id
	private int selectID = -1;
	private String selectMember = "";
	// 修改权限对应权限
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

	public List<PowerBean> getPowers() {
		return powers;
	}

	public void setPowers(List<PowerBean> powers) {
		this.powers = powers;
	}

	public PowerBean getPowerBean() {
		return powerBean;
	}

	public void setPowerBean(PowerBean powerBean) {
		this.powerBean = powerBean;
	}

	public int getselectID() {
		return selectID;
	}

	public void setselectID(int selectID) {
		this.selectID = selectID;
	}

	/**
	 * 显示权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showPowers() throws Exception {
		List<Power> list = service.getPowerService().getAllPower();
		for (int i = 0; i < list.size(); i++) {
			powers.add(new PowerBean(list.get(i).getPowerId().toString(), list
					.get(i).getResource()));
		}
		getSession().put("item", "power");
		return SUCCESS;
	}

	/**
	 * 添加权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addPower() throws Exception {
		service.getPowerService().addPower(powerBean.getResource());
		showPowers();
//		System.out.println(powers.size());
		return SUCCESS;
	}

	/**
	 * 删除权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deletePower() throws Exception {
		service.getPowerService().deletePower(selectID);
		showPowers();
		return SUCCESS;
	}
	
	/**
	 * 修改权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifyPower() throws Exception {
		getSession().put("id", selectID);
		// 标题
		Power power = service.getPowerService().getPower(selectID);
		String resource = power.getResource();
		selectMember = selectID + " " + resource;
		// 列表左值
		List<Role> list = service.getRoletopowerService().getPowerRoles(power);
		for (int i = 0; i < list.size(); i++) {
			leftList.add(list.get(i).getRoleId() + "."
					+ list.get(i).getName());
		}
		// 列表右值
		list = service.getRoleService().findLeaveRoles(list);
		for (int i = 0; i < list.size(); i++) {
			rightList.add(list.get(i).getRoleId() + "."
					+ list.get(i).getName());
		}
		return SUCCESS;
	}

	/**
	 * 保存权限与角色的对应关系
	 * @return
	 * @throws Exception
	 */
	public String savePower() throws Exception {
		int id = (Integer)getSession().get("id");
		Power power = service.getPowerService().getPower(id);
		service.getRoletopowerService().updatePowers(power, relationBean.getLeft());
		selectID = id;
		modifyPower();
		return SUCCESS;
	}
}
