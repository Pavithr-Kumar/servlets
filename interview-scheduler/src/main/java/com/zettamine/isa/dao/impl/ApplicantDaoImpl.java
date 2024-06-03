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
import com.zettamine.isa.dto.Applicant;
import com.zettamine.isa.dto.IsaSearchCriteria;

public class ApplicantDaoImpl implements IsaDao<Applicant, IsaSearchCriteria> {
	
	static Connection con=null;

	public ApplicantDaoImpl() {
		con=ConnectionFactory.getDBConnection();
	}

	@Override
	public Optional<Applicant> get(int id) {
		Optional<Applicant> applicant = null;
		String query="select * from isa.applicant where active='ACTIVE' and applicant_id ="+id;
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(query);
			rs.next();
			Applicant appl = new Applicant();
			appl.setApplicantId(rs.getInt(1));
			appl.setApplicantName(rs.getString(2));
			appl.setApplicantEmail(rs.getString(3));
			appl.setApplicantPhNo(rs.getString(4));
			appl.setApplicantQualification(rs.getString(5));
			appl.setApplicantAggrePercentage(rs.getDouble(6));
			appl.setAppEducatStream(rs.getString(7));
			appl.setApplicantRemarks(rs.getString(8));
			appl.setApplicantSkill(rs.getString(9));
			System.out.println(appl);
			applicant= Optional.ofNullable(appl);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applicant;
	}

	@Override
	public List<Applicant> getAll() {
		List<Applicant> list= new ArrayList<>();
		Statement st;
		try {
			String query ="select * from isa.applicant where active='ACTIVE' order by applicant_id;";
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			Applicant appl;
			while(rs.next()) {
				 appl = new Applicant();
				appl.setApplicantId(rs.getInt(1));
				appl.setApplicantName(rs.getString(2));
				appl.setApplicantEmail(rs.getString(3));
				appl.setApplicantPhNo(rs.getString(4));
				appl.setApplicantQualification(rs.getString(5));
				appl.setApplicantAggrePercentage(rs.getDouble(6));
				appl.setAppEducatStream(rs.getString(7));
				appl.setApplicantRemarks(rs.getString(8));
				appl.setApplicantSkill(getSkillById(Integer.parseInt(rs.getString(9))));
				list.add(appl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Applicant> getBySearchCriteria(IsaSearchCriteria criteria) {
		List<Applicant> list=new ArrayList<Applicant>();
		String query ="select * from isa.applicant where  active='ACTIVE' and primary_skill="+criteria.getSkillId();
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			Applicant appl;
			while(rs.next()) {
				 appl = new Applicant();
				appl.setApplicantId(rs.getInt(1));
				appl.setApplicantName(rs.getString(2));
				appl.setApplicantEmail(rs.getString(3));
				appl.setApplicantPhNo(rs.getString(4));
				appl.setApplicantQualification(rs.getString(5));
				appl.setApplicantAggrePercentage(rs.getDouble(6));
				appl.setAppEducatStream(rs.getString(7));
				appl.setApplicantRemarks(rs.getString(8));
				appl.setApplicantSkill(getSkillById(Integer.parseInt(rs.getString(9))));
				list.add(appl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void save(Applicant t) {
		
		String query="insert into isa.applicant(applicant_name,email,phone_number,highest_qualification,"
				+ "total_aggregate,stream,remarks,primary_skill) "
				+ "values(?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, t.getApplicantName().toUpperCase());
			pst.setString(2, t.getApplicantEmail());
			pst.setString(3, t.getApplicantPhNo());
			pst.setString(4, t.getApplicantQualification());
			pst.setDouble(5, t.getApplicantAggrePercentage());
			pst.setString(6, t.getAppEducatStream());
			pst.setString(7, t.getApplicantRemarks());
			pst.setInt(8,Integer.parseInt(t.getApplicantSkill()));
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Applicant t, String... params) {
		Integer skillId=Integer.parseInt(t.getApplicantSkill());
		
		Statement st;
		try {
			String query ="update isa.applicant set applicant_name=?, email=?,  phone_number=?,"
					+ "  highest_qualification=?,  total_aggregate=?,  stream=?,"
					+ " remarks=?, primary_skill= ? where applicant_id="+t.getApplicantId();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, t.getApplicantName().toUpperCase());
			pst.setString(2, t.getApplicantEmail());
			pst.setString(3, t.getApplicantPhNo());
			pst.setString(4, t.getApplicantQualification());
			pst.setDouble(5, t.getApplicantAggrePercentage());
			pst.setString(6, t.getAppEducatStream());
			pst.setString(7, t.getApplicantRemarks());
			pst.setInt(8,Integer.parseInt(t.getApplicantSkill()));
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Applicant t) {
		try {
			String query="update isa.applicant set active='INACTIVE' where applicant_id="+t.getApplicantId();
			Statement st =con.createStatement();
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	static String getSkillById(Integer skillId) {
		
		try {
			String query="select skill_desc from isa.skill where skill_id="+skillId+";";
			Statement st =con.createStatement();
			ResultSet rs= st.executeQuery(query);
			rs.next();
			return rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	static Integer getIdBySkill(String skill) {
		
		try {
			String query="select skill_id from isa.skill where skill_desc="+skill+";";
			Statement st =con.createStatement();
			ResultSet rs= st.executeQuery(query);
			rs.next();
			System.out.println(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
