package com.zettamine.isa.service.impl;

import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.impl.InterviewerDaoImpl;
import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.service.IsaService;

public class InterviewerServices implements IsaService<Interviewer, IsaSearchCriteria> {
	
	InterviewerDaoImpl inDao =null;
	public InterviewerServices() {
		inDao = new InterviewerDaoImpl();
	}

	@Override
	public Optional<Interviewer> get(int id) {
		// TODO Auto-generated method stub
		return inDao.get(id);
	}

	@Override
	public List<Interviewer> getAll() {
		// TODO Auto-generated method stub
		return inDao.getAll();
	}

	@Override
	public List<Interviewer> getBySearchCriteria(IsaSearchCriteria criteria) {
		// TODO Auto-generated method stub
		return inDao.getBySearchCriteria(criteria);
	}

	@Override
	public void save(Interviewer t) {
		 inDao.save(t);
		
	}

	@Override
	public void update(Interviewer t, String... params) {
		inDao.update(t, params);
		
	}

	@Override
	public void delete(Interviewer t) {
		inDao.delete(t);
		
	}

}
