package com.commons.entity;

import java.util.Date;
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
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Transient
	private String passwordConfirm;
	
	@Column(name = "home_countryid")
	private Integer homecountryid;

	@Column(name = "home_stateid")
	private Integer homestateid;

	@Column(name = "home_cityid")
	private Integer homecityid;
	
	@Column(name = "home_zipcode")
	private String homezipcode;

	@Column(name = "office_countryid")
	private Integer officecountryid;

	@Column(name = "office_stateid")
	private Integer officestateid;

	@Column(name = "office_cityid")
	private Integer officecityid;
	
	@Column(name = "office_zipcode")
	private String officezipcode;

	@Column(name = "birthdate")
	private Date birthdate;
	
	@Column(name = "aniversarydate")
	private Date aniversarydate;
	
	@Column(name = "homeadd")
	private String homeadd;
	
	@Column(name = "offadd")
	private String offadd;
	
	@Column(name = "pancardnum")
	private String pancardnum;
	
	@Column(name = "aadharnum")
	private String aadharnum;
	
	@Column(name = "gstin")
	private String gstin;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "userroles", joinColumns = { @JoinColumn(name = "Userid") }, inverseJoinColumns = { @JoinColumn(name = "userrole_id") })
	private Set<Role> roles;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Client> client;

	public User() {
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

	public Integer getHomecountryid() {
		return homecountryid;
	}

	public void setHomecountryid(Integer homecountryid) {
		this.homecountryid = homecountryid;
	}

	public Integer getHomestateid() {
		return homestateid;
	}

	public void setHomestateid(Integer homestateid) {
		this.homestateid = homestateid;
	}

	public Integer getHomecityid() {
		return homecityid;
	}

	public void setHomecityid(Integer homecityid) {
		this.homecityid = homecityid;
	}



	public Integer getOfficecountryid() {
		return officecountryid;
	}

	public void setOfficecountryid(Integer officecountryid) {
		this.officecountryid = officecountryid;
	}

	public Integer getOfficestateid() {
		return officestateid;
	}

	public void setOfficestateid(Integer officestateid) {
		this.officestateid = officestateid;
	}

	public Integer getOfficecityid() {
		return officecityid;
	}

	public void setOfficecityid(Integer officecityid) {
		this.officecityid = officecityid;
	}

	

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getAniversarydate() {
		return aniversarydate;
	}

	public void setAniversarydate(Date aniversarydate) {
		this.aniversarydate = aniversarydate;
	}

	public String getHomeadd() {
		return homeadd;
	}

	public void setHomeadd(String homeadd) {
		this.homeadd = homeadd;
	}

	public String getOffadd() {
		return offadd;
	}

	public void setOffadd(String offadd) {
		this.offadd = offadd;
	}

	public String getPancardnum() {
		return pancardnum;
	}

	public void setPancardnum(String pancardnum) {
		this.pancardnum = pancardnum;
	}

	public String getAadharnum() {
		return aadharnum;
	}

	public void setAadharnum(String aadharnum) {
		this.aadharnum = aadharnum;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Client> getClient() {
		return client;
	}

	public void setClient(Set<Client> client) {
		this.client = client;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getHomezipcode() {
		return homezipcode;
	}

	public void setHomezipcode(String homezipcode) {
		this.homezipcode = homezipcode;
	}

	public String getOfficezipcode() {
		return officezipcode;
	}

	public void setOfficezipcode(String officezipcode) {
		this.officezipcode = officezipcode;
	}
  
}
