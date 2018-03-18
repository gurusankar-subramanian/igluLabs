package com.jwt.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity for task table
 * @author Guru Sankar
 *
 */
@Entity
@Table(name="tasks")
public class Tasks {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;

	@Column
	private String date ;
	
	@Column
	private Timestamp startDate ;

	@Column
	private Timestamp endDate ;

	@Column
	private String objective ;
	
	@ManyToOne
	@JoinColumn
	private StatusMaster status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartDate() {
		if(startDate != null)
			return new SimpleDateFormat("yyyy-MM-dd").format(startDate);
		else
			return "";
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		if(endDate != null)
			return new SimpleDateFormat("yyyy-MM-dd").format(endDate);
		else
			return "";
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public StatusMaster getStatus() {
		return status;
	}

	public void setStatus(StatusMaster status) {
		this.status = status;
	}

	 
}
