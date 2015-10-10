package jyu.vtc.user.service;

public class AllService
{
	private PowerService powerService = new PowerService();
	private RoleService roleService = new RoleService();
	private RoletopowerService roletopowerService = new RoletopowerService();
	private UserService userService = new UserService();

	public PowerService getPowerService()
	{
		return powerService;
	}

	public void setPowerService(PowerService powerService)
	{
		this.powerService = powerService;
	}

	public RoleService getRoleService()
	{
		return roleService;
	}

	public void setRoleService(RoleService roleService)
	{
		this.roleService = roleService;
	}

	public RoletopowerService getRoletopowerService()
	{
		return roletopowerService;
	}

	public void setRoletopowerService(RoletopowerService roletopowerService)
	{
		this.roletopowerService = roletopowerService;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
}
