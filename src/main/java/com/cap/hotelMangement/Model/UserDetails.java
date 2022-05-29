package com.cap.hotelMangement.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UserDetails")
public class UserDetails {

	
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Id
	@Column(unique = true)
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	@Column(name = "isAdmin", nullable = false)
	private boolean admin;

	@Column(name = "isUser", nullable = false)
	private boolean user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Column(unique = true)
	private String phonenumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public boolean isAdmin() {
		return admin;

	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isUser() {
		return user;
	}

	public void setUser(boolean user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "UserDetails [Email=" + email + ", username=" + username + ", password=" + password + "]";
	}

}
