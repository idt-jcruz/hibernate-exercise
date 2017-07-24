package com.mstar.training.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Inmate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "INMATE_NAME", nullable = false)
	private String name;

	@Column(name = "CONTROL_NUMBER", nullable = false)
	private String controlNumber;
	
	@Column(nullable=false)
	private String inmateStatus;
	
	@ManyToOne
	@JoinColumn(name = "JAIL_ID")
	private Jail inmateJail;

	@Temporal(TemporalType.DATE)
	@Column(name = "COMMITMENT_DATE", nullable = false)
	private Date commitmentDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;
	
	private int sentenceLength;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public Jail getJail() {
		return inmateJail;
	}

	public void setJail(Jail jail) {
		this.inmateJail = jail;
	}

	public Date getCommitmentDate() {
		return commitmentDate;
	}

	public void setCommitmentDate(Date commitmentDate) {
		this.commitmentDate = commitmentDate;
	}

	public Jail getInmateJail() {
		return inmateJail;
	}

	public void setInmateJail(Jail inmateJail) {
		this.inmateJail = inmateJail;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInmateStatus() {
		return inmateStatus;
	}

	public void setInmateStatus(String inmateStatus) {
		this.inmateStatus = inmateStatus;
	}

}
