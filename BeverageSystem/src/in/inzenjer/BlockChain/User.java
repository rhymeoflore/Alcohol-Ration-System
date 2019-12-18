package in.inzenjer.BlockChain;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;
@Getter
@ToString 
public class User implements Serializable {
	String uid;
	String bevID;
	String firstname;
	String lastname;
	String age;
	String gender;
	String address;
	String phone;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBevID() {
		return bevID;
	}
	public void setBevID(String bevID) {
		this.bevID = bevID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


}
