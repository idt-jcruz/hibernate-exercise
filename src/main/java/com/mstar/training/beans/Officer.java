package com.mstar.training.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Officer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "OFFICER_NAME", nullable = false)
	private String name;

	@Column(name = "OFFICER_RANK", nullable = false)
	private String rank;

	@ManyToOne
	@JoinColumn(name="JAIL_ID")
	private Jail officerJail;
	
	@OneToOne
	@JoinColumn(name = "TRUSTEE_ID")
	private Inmate inmate;

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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Inmate getInmate() {
		return inmate;
	}

	public void setInmate(Inmate inmate) {
		this.inmate = inmate;
	}

}
