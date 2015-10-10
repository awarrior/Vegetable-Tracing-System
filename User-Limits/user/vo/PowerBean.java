package jyu.vtc.user.vo;

public class PowerBean {
	private String id = "";
	private String resource = "";

	public PowerBean() {
		super();
	}

	public PowerBean(String id, String resource) {
		super();
		this.id = id;
		this.resource = resource;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

}
