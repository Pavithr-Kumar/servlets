package com.zettamine.isa.service.impl;

import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.impl.ApplicantDaoImpl;
import com.zettamine.isa.dto.Applicant;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.service.IsaService;

public class ApplicantServices implements IsaService<Applicant, IsaSearchCriteria> {
	
	ApplicantDaoImpl appDao ;
	public ApplicantServices() {
		appDao = new ApplicantDaoImpl();
		
	}

	@Override
	public Optional<Applicant> get(int id) {
		// TODO Auto-generated method stub
		return appDao.get(id);
	}

	@Override
	public List<Applicant> getAll() {
		// TODO Auto-generated method stub
		return appDao.getAll();
	}

	@Override
	public List<Applicant> getBySearchCriteria(IsaSearchCriteria criteria) {
		
		return appDao.getBySearchCriteria(criteria);
	}

	@Override
	public void save(Applicant t) {
		appDao.save(t);
		
	}

	@Override
	public void update(Applicant t, String... params) {
		appDao.update(t, params);
		
	}

	@Override
	public void delete(Applicant t) {
		appDao.delete(t);
		
	}

}
