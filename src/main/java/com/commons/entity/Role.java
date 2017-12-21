package com.commons.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role extends AbstractEntity{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long roleid;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "userroles", joinColumns = { @JoinColumn(name = "Userid") }, inverseJoinColumns = { @JoinColumn(name = "userrole_id") })
	private Set<User> user;

	@Column(name = "role")
	private String role;
	
	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
