package com.mstar.training.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mstar.training.beans.Officer;

public interface OfficerRepository extends CrudRepository<Officer, Long> {

	public List<Officer> findByName(String name);
	
}
