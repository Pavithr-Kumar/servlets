package com.zettamine.isa.view.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dbconfig.ConnectionFactory;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.view.dao.IsaViewDAO;
import com.zettamine.isa.view.dto.InterviewScheduleView;

public class IsaInterviewScheduleDaoImpl implements IsaViewDAO<InterviewScheduleView, IsaSearchCriteria>{

	private Connection conn = null;
	private static PreparedStatement presat = null;
	
	public IsaInterviewScheduleDaoImpl() {
		conn = ConnectionFactory.getDBConnection();
	}
	@Override
	public List<InterviewScheduleView> getAll() {
		 
		List<InterviewScheduleView> isvList = new ArrayList<>();
		String querey = "SELECT * FROM isa.schedule_view order by schedule_id";
		try {
			presat = conn.prepareStatement(querey);
			
			ResultSet rs = presat.executeQuery();
			while(rs.next()) {
				int scheduleId = rs.getInt(1);
				String appName = rs.getString(2);
				String intrvwrName = rs.getString(3);
				String rcutName = rs.getString(4);
				Date interDate = rs.getDate(5);
				Time interTime = rs.getTime(6);
				String status = rs.getString(7);
				isvList.add(new InterviewScheduleView(scheduleId, appName, intrvwrName, 
													rcutName, interDate, interTime, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isvList;
	}

	@Override
	public Optional<InterviewScheduleView> get(int id) {
		String querey = "SELECT * FROM isa.schedule_view WHERE schedule_id =?";
		Optional<InterviewScheduleView> isvOpt = Optional.empty();
		try {
			presat = conn.prepareStatement(querey);
			presat.setInt(1, id);
			ResultSet rs = presat.executeQuery();
			if(rs.next()) {
				int scheduleId = rs.getInt(1);
				String appName = rs.getString(2);
				String intrvwrName = rs.getString(3);
				String rcutName = rs.getString(4);
				Date interDate = rs.getDate(5);
				Time interTime = rs.getTime(6);
				String status = rs.getString(7);
				isvOpt = Optional.ofNullable(new InterviewScheduleView(scheduleId, appName, intrvwrName, 
													rcutName, interDate, interTime, status));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isvOpt;
	}

	@Override
	public List<InterviewScheduleView> getBySearchCriteria(IsaSearchCriteria criteria) {
		StringBuilder buildQuere = new StringBuilder("SELECT * FROM isa.schedule_view WHERE");
		String querey = "";
		List<InterviewScheduleView> srcList = new ArrayList<>();
		
		if (criteria.getScheduleId() != null) {
			buildQuere.append(" schedule_id ="+criteria.getScheduleId() +" AND");
		} else {
			if (criteria.getApplicantName() != null) {
				buildQuere.append(" applicant_name like " + "'%" +criteria.getApplicantName() +"%' AND");
			}
			if (criteria.getInterviewerName() != null) {
				buildQuere.append(" interviewer_name like " + "'%" +criteria.getInterviewerName() +"%' AND");
			}
			if (criteria.getRecrName() != null) {
				buildQuere.append(" recruiter_name like " +"'%" +criteria.getRecrName() +"%' AND");
			}
			if (criteria.getFromDate() != null && criteria.getToDate() != null) {
				buildQuere.append(" interview_date BETWEEN" + " '" +criteria.getFromDate() +"' AND '" + criteria.getToDate()+"'");
			}
		}
		querey = buildQuere.toString();
		if (querey.endsWith(" WHERE")) {
			querey = querey.substring(0, querey.length() - 6);
		} else if (querey.endsWith(" AND")) {
			querey = querey.substring(0, querey.length() - 4);
		}
		System.out.println(querey);
		
		try {
			presat = conn.prepareStatement(querey);
			ResultSet rs = presat.executeQuery();
				while (rs.next()) {
					int scheduleId = rs.getInt(1);
					String appName = rs.getString(2);
					String intrvwrName = rs.getString(3);
					String rcutName = rs.getString(4);
					Date interDate = rs.getDate(5);
					Time interTime = rs.getTime(6);
					String status = rs.getString(7);
					srcList.add(new InterviewScheduleView(scheduleId, appName, intrvwrName, rcutName, interDate, interTime,
							status));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("srcList"  +srcList);
		return srcList;
	}
}
		
	
