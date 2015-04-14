package bean;

public class User {
	private Integer id;
	private String name;
	private String status;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
