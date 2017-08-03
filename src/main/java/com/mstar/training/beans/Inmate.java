package com.mstar.training.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mstar.training.json.JailJsonDeserializer;

/**
 *	Your score: (YES is 1 point)
 *
 *	Has Jail: YES
 *	Correct Relationship w/ Jail: YES
 *	Has Type: YES
 *	Type is Enum: YES
 *	Has Name: YES
 *	Has Control Number: YES
 *	Control Number is Unique: YES
 *	Has Commitment Date: YES
 *	Commitment Date is Timestamp: NO
 *
 *	Remarks:
 *	1. The commitment date is required for budgeting meals for an inmate (breakfast, lunch & dinner), so on the commitment date itself it is important to know if the inmate has been served all 3 meals or not.
 *
 *	Final Score: 8 of 9
 */

@Entity
public class Inmate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "INMATE_NAME", nullable = false)
	private String name;

	@Column(name = "CONTROL_NUMBER", nullable = false, unique = true)
	private String controlNumber;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private InmateType inmateType;

	@ManyToOne
	@JoinColumn(name = "JAIL_ID")
	@JsonDeserialize(using = JailJsonDeserializer.class)
	private Jail inmateJail;

	@OneToOne(mappedBy = "trustee")
	private Officer officer;

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

	public InmateType getInmateType() {
		return inmateType;
	}

	public void setInmateType(InmateType inmateType) {
		this.inmateType = inmateType;
	}

	public Officer getOfficer() {
		return officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}

	public int getSentenceLength() {
		return sentenceLength;
	}

	public void setSentenceLength(int sentenceLength) {
		this.sentenceLength = sentenceLength;
	}

}