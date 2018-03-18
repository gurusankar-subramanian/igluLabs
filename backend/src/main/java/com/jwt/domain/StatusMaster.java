package com.jwt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for status master table
 * @author Guru Sankar
 *
 */
@Entity
@Table(name="status_master")
public class StatusMaster {

	@Id
	private Long id ;

	@Column
	private String statusCode ;

	@Column
	private String statusDescription ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	
	
}
