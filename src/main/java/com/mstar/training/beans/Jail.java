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

/**
 * 	Your score: (YES is 1 point)
 *
 *	Has Name: YES
 *	Has Address: YES
 *	Has Type: NO
 *	Type is Enum: N/A
 *	Has Region: YES
 *	Region is Enum: YES
 *  Has Capacity: YES
 *  Has Officers: YES
 *  Correct Relationship w/ Officers: YES
 *  Has Inmates: YES
 *  Correct Relationship w/ Inmates: YES
 *  
 *  Remarks:
 *  1. The type of the Jail was specified in the first paragraph specifically, '...and operation of all district, city and municipal jails in the Philippines...'
 *  
 *  Final Score: 9 of 11
 *
 */

@Entity
public class Jail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private int capacity;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
