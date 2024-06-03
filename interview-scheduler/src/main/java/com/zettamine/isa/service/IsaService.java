package com.zettamine.isa.service;

import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dto.IsaDto;
import com.zettamine.isa.dto.SearchCriteria;

public interface IsaService<T extends IsaDto, S extends SearchCriteria> {
	
	Optional<T> get(int id);

	List<T> getAll();

	List<T> getBySearchCriteria(S criteria);

	void save(T t);

	void update(T t, String...params);

	void delete(T t); 
	
	

}
