package jyu.vtc.user.vo;

public class UserBean {
	private String id = "";
	private String password = "";
	private String role = "";

	public UserBean() {
		super();
	}

	public UserBean(String id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
