package com.commons.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Document")
public class Department {

	@Id
	@GeneratedValue
	@Column(name="document_id")
	private int id;
	
	
	@Column(name="document_name")
	private String documentname;
	
	@Column(name="document_type")
	private String documenttype;
	
	@Column(name="documentfile",length=100000)
	private byte[] documentfile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id",nullable=false)
	private Client client;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumentname() {
		return documentname;
	}

	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}

	public String getDocumenttype() {
		return documenttype;
	}

	public void setDocumenttype(String documenttype) {
		this.documenttype = documenttype;
	}

	public byte[] getDocumentfile() {
		return documentfile;
	}

	public void setDocumentfile(byte[] documentfile) {
		this.documentfile = documentfile;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
