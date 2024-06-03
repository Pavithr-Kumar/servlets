package com.zettamine.isa.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dao.impl.IsaSkillDaoImpl;
import com.zettamine.isa.dto.SearchCriteria;
import com.zettamine.isa.dto.Skill;
import com.zettamine.isa.service.IsaService;

public class SkillService implements IsaService<Skill, SearchCriteria> {

	static IsaSkillDaoImpl dao = new IsaSkillDaoImpl();
	@Override
	public Optional<Skill> get(int id) {
		Optional<Skill>skillbyId = null;
		skillbyId   = dao.get(id);
		return skillbyId;
	}

	@Override
	public List<Skill> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Skill> getBySearchCriteria(SearchCriteria criteria) {
		return null;
	}

	@Override
	public void save(Skill t) {
		dao.save(t);
	}
	
	public Integer save(Skill t,boolean returnval) {
		return dao.save(t,returnval);
	}

	@Override
	public void update(Skill t, String... params) {
		dao.update(t, params);
		
	}

	@Override
	public void delete(Skill t) {
		dao.delete(t);
	}
	public Integer getIdBySkill(String skill) {
		return dao.getIdBySkill(skill);
	}
	public String getSkillById(Integer id) {
		return dao.getSkillById(id);
	}
}
