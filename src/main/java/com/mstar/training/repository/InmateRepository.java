package com.mstar.training.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mstar.training.beans.Inmate;

public interface InmateRepository extends CrudRepository<Inmate, Long> {

	public List<Inmate> findByName(String name);
	
}
