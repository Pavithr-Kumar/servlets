package com.zettamine.isa.service.impl;

import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dao.impl.RecruiterDaoImpl;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.dto.Recruiter;
import com.zettamine.isa.dto.SearchCriteria;
import com.zettamine.isa.service.IsaService;

public class RecruiterServices implements IsaService<Recruiter, SearchCriteria> {

	static IsaDao recDao = new RecruiterDaoImpl();
	@Override
	public Optional<Recruiter> get(int id) {
		
		return recDao.get(id);
	}

	@Override
	public List<Recruiter> getAll() {
		
		return recDao.getAll();
	}

	@Override
	public List<Recruiter> getBySearchCriteria(SearchCriteria criteria) {
		// TODO Auto-generated method stub
		return recDao.getBySearchCriteria(criteria);
	}

	@Override
	public void save(Recruiter t) {
		// TODO Auto-generated method stub
		recDao.save(t);
	}

	@Override
	public void update(Recruiter t, String... params) {
		// TODO Auto-generated method stub
		recDao.update(t, params);
	}

	@Override
	public void delete(Recruiter t) {
		// TODO Auto-generated method stub
		recDao.delete(t);
	}
	
	public boolean verifyRecruiter(String email,String pass) {
		IsaSearchCriteria scr = new IsaSearchCriteria();
	    scr.setRecrEmail(email);
	    scr.setRecrPassword(pass);
		List<Recruiter> recrList =recDao.getBySearchCriteria(scr);
		if(recrList.size()>0)
		 return true;
		return false;
		
	}

}
