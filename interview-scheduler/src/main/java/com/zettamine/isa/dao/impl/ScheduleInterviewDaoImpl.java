package com.zettamine.isa.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dbconfig.ConnectionFactory;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.dto.ScheduleInterview;
import com.zettamine.isa.dto.Status;

public class ScheduleInterviewDaoImpl implements IsaDao<ScheduleInterview, IsaSearchCriteria> {
	
	private Connection con = null;
	private PreparedStatement presat = null;
	
	public ScheduleInterviewDaoImpl() {
		con = ConnectionFactory.getDBConnection();
	}

	@Override
	public Optional<ScheduleInterview> get(int id) {
		
		Optional<ScheduleInterview> schedIntrOpt = Optional.empty();
		try {
			presat  = con.prepareStatement("SELECT * FROM isa.interview_schedule WHERE schedule_id = ?");
			presat.setInt(1, id);
			ResultSet rs = presat.executeQuery();
			while(rs.next()) {
				int scheduleId = rs.getInt(1);
				int applicantId = rs.getInt(2);
				int interviewerId = rs.getInt(3);
				int recruiterId = rs.getInt(4);
				Date date = rs.getDate(5);
				Time time = rs.getTime(6);
				Status status = Status.valueOf(rs.getString(7));
				schedIntrOpt = Optional.ofNullable(new ScheduleInterview(scheduleId, applicantId, interviewerId, recruiterId, date, time, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedIntrOpt;
	}

	@Override
	public List<ScheduleInterview> getAll() {
		
		List<ScheduleInterview> siList = new ArrayList<>();
		try {
			presat = con.prepareStatement("SELECT * FROM isa.interview_schedule ORDER BY schedule_id;");
			ResultSet rs = presat.executeQuery();
			while(rs.next()) {
				int scheduleId = rs.getInt(1);
				int applicantId = rs.getInt(2);
				int interviewerId = rs.getInt(3);
				int recruiterId = rs.getInt(4);
				Date date = rs.getDate(5);
				Time time = rs.getTime(6);
				Status status = Status.valueOf(rs.getString(7));
				siList.add(new ScheduleInterview(scheduleId, applicantId, interviewerId, recruiterId, 
												 date, time, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return siList;
	}

	@Override
	public List<ScheduleInterview> getBySearchCriteria(IsaSearchCriteria criteria) {
		
		List<ScheduleInterview> siList = new ArrayList<>();
		String querey = "SELECT * FROM isa.interview_schedule WHERE";
			if(criteria.getApplicantId() != null) {
				querey += " applicant_id =" +criteria.getApplicantId() + " AND";
			}
			if(criteria.getInterviewerId() != null) {
				querey += " interviewer_id =" +criteria.getInterviewerId() + " AND";
			}
			if(criteria.getRecrId() != null) {
				querey += " recruiter_id ="+criteria.getRecrId() + " AND";
			}
			if(criteria.getFromDate() != null  && criteria.getToDate() !=null) {
				querey += " interview_date BETWEEN" + "'"+criteria.getFromDate()+"'" +" AND " + "'"+criteria.getToDate()+"'";
			}
			
			if(querey.endsWith(" AND")) {
				querey = querey.substring(0, querey.length() -4);
			}
			else if(querey.endsWith(" WHERE")) {
				querey = querey.substring(0, querey.length() -6);
			}
		
			try {
				presat = con.prepareStatement(querey);
				ResultSet rs = presat.executeQuery();
				
				while(rs.next()) {
					int scheduleId = rs.getInt(1);
					int applicantId = rs.getInt(2);
					int interviewerId = rs.getInt(3);
					int recruiterId = rs.getInt(4);
					Date date = rs.getDate(5);
					Time time = rs.getTime(6);
					Status status = Status.valueOf(rs.getString(7));
					siList.add(new ScheduleInterview(scheduleId, applicantId, interviewerId, recruiterId,
													 date, time, status));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return siList;
	}

	@Override
	public void save(ScheduleInterview t) {
		String quere = "INSERT INTO isa.interview_schedule(applicant_id, interviewer_id, recruiter_id, interview_date, "
						+ "interview_time, status) "
						+ "VALUES(?,?,?,?,?,?)";	
		try {
			presat = con.prepareStatement(quere);
			
			presat.setInt(1, t.getApplicantId());
			presat.setInt(2, t.getInterviewerId());
			presat.setInt(3, t.getRecruiterId());
			presat.setDate(4, t.getScheduledDate());
			presat.setTime(5, t.getScheduledTime());
			presat.setString(6, t.getInterviewStatus().getValue());
			
			presat.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(ScheduleInterview t, String... params) {
		
		String quere ="UPDATE isa.interview_schedule "
					+ "SET applicant_id = ?, interviewer_id = ?, recruiter_id = ?, interview_date = ?,  " 
					+ "interview_time  = ?, status = ? "
					+ "WHERE schedule_id = ?";
		try {
			presat = con.prepareStatement(quere);
			
			presat.setInt(1, t.getApplicantId());
			presat.setInt(2, t.getInterviewerId());
			presat.setInt(3, t.getRecruiterId());
			presat.setDate(4, t.getScheduledDate());
			presat.setTime(5, t.getScheduledTime());
			presat.setString(6, t.getInterviewStatus().getValue());
			
			presat.setInt(7, t.getScheduleId());
			presat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(ScheduleInterview t) {
		try {
			System.out.println(t);
			presat = con.prepareStatement("DELETE FROM isa.interview_schedule WHERE schedule_id = ?");
			presat.setInt(1, t.getScheduleId());
			presat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}