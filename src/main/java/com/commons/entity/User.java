package com.commons.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "User")
public class User extends AbstractEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@NotEmpty(message = "Enter Firstname")
	@Column(name = "firstname")
	private String firstname;

	@NotEmpty(message = "Enter Lastname")
	@Column(name = "lastname")
	private String lastname;

	@NotEmpty(message = "Enter username")
	@Column(name = "username", unique = true)
	private String username;

	@NotEmpty(message = "Enter Email")
	@Email
	@Column(name = "email", unique = true)
	private String email;

	@NotEmpty(message = "Enter Password")
	@Column(name = "password")
	private String password;

	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "userroles", joinColumns = { @JoinColumn(name = "Userid") }, inverseJoinColumns = {
			@JoinColumn(name = "userrole_id") })
	private Set<Role> roles;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Client> client;

	public User() {
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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



	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

}
