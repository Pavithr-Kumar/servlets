package com.zettamine.isa.view.dao;

import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dto.SearchCriteria;
import com.zettamine.isa.view.dto.IsaViewDto;

public interface IsaViewDAO <T extends IsaViewDto, S extends SearchCriteria>{

	 List<T> getAll();
	 
	 Optional<T> get(int id);
	 
	 List<T> getBySearchCriteria(S s);
}
