package com.mstar.training.beans;

public enum Region {
	
	NCR("National Capital Region"),
	REGION_I("Ilocos Region"),
	CAR("Cordillera Administrative Region"),
	REGION_XII("SOCCSKSARGEN"),
	ARMM("Autonomous Region in Muslim Mindanao");

    private final String regionName;   
    
	private Region(String regionName) {
		this.regionName = regionName;
    }
	
	public boolean equalsName(String otherName) {
	    return regionName.equals(otherName);
	}

	public String toString() {
		return this.regionName;
	}
}
