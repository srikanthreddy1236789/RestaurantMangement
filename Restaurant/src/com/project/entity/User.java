package com.project.entity;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.*;



@Entity
@Table(name="User")

public class User {
	@Id
	@Column(name="UserId")
	
	private int userid;
	@Column(name="UserName")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="Address")
	private String address;
	@Column(name="PhoneNumber")
	private String phonenumber;
	@OneToMany(mappedBy = "userobj",cascade=CascadeType.ALL)
	private List<OrderedItem> oderitemlst;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public List<OrderedItem> getOderitemlst() {
		return oderitemlst;
	}
	public void setOderitemlst(List<OrderedItem> oderitemlst) {
		this.oderitemlst = oderitemlst;
	}
	

}
