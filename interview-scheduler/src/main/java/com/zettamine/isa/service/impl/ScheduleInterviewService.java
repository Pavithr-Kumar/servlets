package com.zettamine.isa.service.impl;

import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.impl.ScheduleInterviewDaoImpl;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.dto.ScheduleInterview;
import com.zettamine.isa.view.dao.impl.IsaInterviewScheduleDaoImpl;
import com.zettamine.isa.view.dto.InterviewScheduleView;

public class ScheduleInterviewService {
	
	static ScheduleInterviewDaoImpl dao = new ScheduleInterviewDaoImpl();
	IsaInterviewScheduleDaoImpl viewDao = new IsaInterviewScheduleDaoImpl();
	
	public InterviewScheduleView get(Integer id) {
		
		Optional<InterviewScheduleView> optional = viewDao.get(id);
		return optional.get();
	}
	public ScheduleInterview getScheduledInterview(Integer id) {
		
		Optional<ScheduleInterview> optional = dao.get(id);
		return optional.get();
	}
	
	public void save(ScheduleInterview interview) {
		dao.save(interview);
	}
	
	public List<InterviewScheduleView> getAll(){
		return viewDao.getAll();
	}
	
	public List<InterviewScheduleView> getBySearchCriteria(IsaSearchCriteria criteria){
		return viewDao.getBySearchCriteria(criteria);
	}
	
	public void update(ScheduleInterview interview) {
		dao.update(interview, "");
	}
	
	public void delete(ScheduleInterview interview) {
		dao.delete(interview);
	}
}