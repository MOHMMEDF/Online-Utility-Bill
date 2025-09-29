package com.jsp.onlineUtilityBillPayment.DTO;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String name;
	private String email;
	private String phone;
	
	@Enumerated(EnumType.STRING)//here we r assiging directly.USER
	//but from third party app user try to login then it will select role and pass in doubleQuotes
	//because it type is String
	
	private Role role=Role.USER;//here we r assinginging as USER as default through enum
	
	//now 1 user has many bills so 1 to many relation ,& we r using bidirectional then used mapped by
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Bill>bills=new ArrayList<Bill>();

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
	
	
}
