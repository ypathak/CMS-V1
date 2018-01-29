package com.commons.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="countries",schema="CMSMaster")
public class Countries {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="sortname")
	private String sortname;
	
	@Column(name="name")
	private String name;

	@Column(name="phonecode")
	private int phonecode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(int phonecode) {
		this.phonecode = phonecode;
	}
	
}
