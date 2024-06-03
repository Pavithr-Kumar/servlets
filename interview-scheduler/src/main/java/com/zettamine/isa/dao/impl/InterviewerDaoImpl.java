package com.zettamine.isa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dbconfig.ConnectionFactory;
import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.dto.Skill;

public class InterviewerDaoImpl implements IsaDao<Interviewer, IsaSearchCriteria> {

	private static Connection con = null;
	private PreparedStatement presat = null;
	private IsaSkillDaoImpl skillDao = new IsaSkillDaoImpl();
	
	public  InterviewerDaoImpl() {
		
		con = ConnectionFactory.getDBConnection();
	}
	
	@Override
	public Optional<Interviewer> get(int id){
		IsaSkillDaoImpl skillDao = new IsaSkillDaoImpl();
		Optional<Interviewer> interviewerOpt = null;
				try {
			presat = con.prepareStatement("SELECT * FROM isa.interviewer WHERE active='ACTIVE' and interviewer_id = ?");
			presat.setInt(1, id);
			ResultSet rs = presat.executeQuery();
			while(rs.next()) {
				int intId = rs.getInt(1);
				String name = rs.getString(2).toUpperCase();
				String email = rs.getString(3);
				String skill = skillDao.getSkillById(rs.getInt(4));
				String remarks = rs.getString(5);
				interviewerOpt = Optional.ofNullable(new Interviewer(intId, name, email,skill,remarks));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return interviewerOpt;
	}

	@Override
	public List<Interviewer> getAll() {
		
		List<Interviewer> intList = new ArrayList<>();
		try {
			presat =con.prepareStatement("SELECT * FROM isa.interviewer where active='ACTIVE' order by interviewer_id");
			ResultSet rs = presat.executeQuery();
			while(rs.next()) {
				int intId = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String skill = skillDao.getSkillById(rs.getInt(4));
				String remarks =rs.getString(5);
				intList.add(new Interviewer(intId, name, email,skill,remarks));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return intList;
	}

	@Override
	public List<Interviewer> getBySearchCriteria(IsaSearchCriteria criteria) {

		List<Interviewer> intList = new ArrayList<>();
		
		try {
			presat = con.prepareStatement("SELECT * FROM isa.interviewer  where active='ACTIVE' and primary_skill = ?");
			System.out.println(criteria.getSkillId());
			presat.setInt(1, criteria.getSkillId());
			ResultSet rs = presat.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String skill = skillDao.getSkillById(rs.getInt(4));
				String remarks=rs.getString(5);
				
				intList.add(new Interviewer(id, name, email,skill,remarks));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return intList;
	}

	@Override
	public void save(Interviewer t) {
		try {
			presat = con.prepareStatement("INSERT INTO isa.interviewer(interviewer_name, email, primary_skill)"
					+ "VALUES(?,?,?)");
			presat.setString(1, t.getInterviewerName());
			presat.setString(2, t.getInterviewerEmail());
			presat.setInt(3, Integer.parseInt(t.getInterviewerSkill()));
			presat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Interviewer t, String... params) {
		try {
			presat = con.prepareStatement("UPDATE isa.interviewer set interviewer_name = ?,  email =? ,primary_skill = ?"
					+ " WHERE interviewer_id = ?");
			presat.setString(1, t.getInterviewerName().toUpperCase());
			presat.setString(2, t.getInterviewerEmail());
			presat.setInt(3, Integer.parseInt(t.getInterviewerSkill()));
			presat.setInt(4, t.getInterviewerId());
			presat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Interviewer t) {
		
		try {
			presat = con.prepareStatement("update  isa.interviewer set active='ACTIVE' WHERE interviewer_id = ?");
			presat.setInt(1,t.getInterviewerId());
			presat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}