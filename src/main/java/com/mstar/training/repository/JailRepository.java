package com.mstar.training.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mstar.training.beans.Jail;

public interface JailRepository extends CrudRepository<Jail, Long> {

	public List<Jail> findByName(String name);
}
