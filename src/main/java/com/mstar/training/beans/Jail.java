package com.mstar.training.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String jailName;

	@Column(nullable = false)
	private String jailAddress;

	@Column(nullable = false)
	private int jailCapacity;

	@Enumerated(EnumType.STRING)
	private Region region;

	@OneToMany(mappedBy = "officerJail")
	private List<Officer> officers;

	@OneToMany(mappedBy = "inmateJail")
	private List<Inmate> inmates;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJailName() {
		return jailName;
	}

	public void setJailName(String jailName) {
		this.jailName = jailName;
	}

	public String getJailAddress() {
		return jailAddress;
	}

	public void setJailAddress(String jailAddress) {
		this.jailAddress = jailAddress;
	}

	public int getJailCapacity() {
		return jailCapacity;
	}

	public void setJailCapacity(int jailCapacity) {
		this.jailCapacity = jailCapacity;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Officer> getOfficers() {
		return officers;
	}

	public void setOfficers(List<Officer> officers) {
		this.officers = officers;
	}

	public List<Inmate> getInmates() {
		return inmates;
	}

	public void setInmates(List<Inmate> inmates) {
		this.inmates = inmates;
	}

}
