package in.inzenjer.user;

public class UserBean {
	
	
	int id;
	String firstname;
	String email;
	String password;
	String usertype;
	String bevid;

	public String getBevid() {
		return bevid;
	}
	public void setBevid(String bevid) {
		this.bevid = bevid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
}
