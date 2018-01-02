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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="Client")
public class Client extends AbstractEntity {

	@Id
	@GeneratedValue
	@Column(name="client_id")
	private long clientid;
	
	@Column(name="client_name")
	private String clientname;
	
	@Column(name="client_pannumber")
	private String pannumber;
	
	@Column(name="client_adharnumber")
	private String adharnumber;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Set<Document> documents;

	
	@Column(name="client_dob")
	private Date dateofbirth;
	
	@Column(name="department")
	private String department;
	
	
	@Column(name="mobilenumber")
	private String mobilenumber;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=false)
	private User user;


	public long getClientid() {
		return clientid;
	}


	public void setClientid(long clientid) {
		this.clientid = clientid;
	}


	public String getClientname() {
		return clientname;
	}


	public void setClientname(String clientname) {
		this.clientname = clientname;
	}


	public String getPannumber() {
		return pannumber;
	}


	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}


	public String getAdharnumber() {
		return adharnumber;
	}


	public void setAdharnumber(String adharnumber) {
		this.adharnumber = adharnumber;
	}


	public Set<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	
	

	
	
	
	
}
