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
import com.zettamine.isa.dto.Skill;
import com.zettamine.isa.dto.SearchCriteria;

public class IsaSkillDaoImpl implements IsaDao<Skill, SearchCriteria> {
	private Connection con = null;
	private PreparedStatement presat = null;

	public IsaSkillDaoImpl() {
		
		con =ConnectionFactory.getDBConnection();
	}
	@Override
	public Optional<Skill> get(int id)  {
		Optional<Skill> skill = null;
		try {
			presat=con.prepareStatement("SELECT * FROM isa.skill WHERE skill_id = ?");
			presat.setInt(1, id);
			ResultSet rs = presat.executeQuery();
			while(rs.next()) {
				int skillId = rs.getInt(1);
				String skillDesc = rs.getString(2).toUpperCase();
				skill = Optional.ofNullable(new Skill(skillId, skillDesc));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return skill;
	}

	@Override
	public List<Skill> getAll() {
		
		List<Skill> skillList = new ArrayList<Skill>();
		try {
			presat = con.prepareStatement("SELECT * FROM isa.skill order by skill_id");
			ResultSet rs = presat.executeQuery();
			while(rs.next()) {
				
				Integer skillId = rs.getInt(1);
				String skillDesc= rs.getString(2);
				skillList.add(new Skill(skillId,skillDesc));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return skillList;
	}

	@Override
	public List<Skill> getBySearchCriteria(SearchCriteria criteria) {
		
		return null;
	}

	@Override
	public void save(Skill skill) {
		String query ="insert into isa.skill(skill_desc) values(?)";
		try {
			presat = con.prepareStatement(query);
			presat.setString(1, skill.getSkillDsec());
			presat.executeUpdate();
		} catch (SQLException e) {
		}
	}
	
	public Integer save(Skill skill, boolean returnval) {
		
		String query ="insert into isa.skill(skill_desc) values(?)";
		Integer i=null;
		try {
			presat = con.prepareStatement(query);
			presat.setString(1, skill.getSkillDsec().toUpperCase());
			i=presat.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			i=0;
			return i;
		}
		return i;
	}

	@Override
	public void update(Skill t, String... params) {
	}

	@Override
	public void delete(Skill skill) {
		
		String query ="DELETE from isa.skill WHERE skill_id= ?";
		try {
			presat=con.prepareStatement(query);
			presat.setInt(1, skill.getSkillId());
			presat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public String getSkillById(Integer skillId) {
		
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
	public Integer getIdBySkill(String skill) {
		
		try {
			String query="select skill_id from isa.skill where skill_desc="+skill+";";
			Statement st =con.createStatement();
			ResultSet rs= st.executeQuery(query);
			if(rs.next()) {
				
				System.out.println(rs);
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
