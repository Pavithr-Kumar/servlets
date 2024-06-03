package com.zettamine.isa.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dbconfig.ConnectionFactory;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.dto.Recruiter;

public class RecruiterDaoImpl implements IsaDao<Recruiter, IsaSearchCriteria> {
	
	private Connection con = null;
	private PreparedStatement pst = null;

	public RecruiterDaoImpl() {
		 con = ConnectionFactory.getDBConnection();
		
	}

	@Override
	public Optional<Recruiter> get(int id) {
		
		return Optional.empty();
	}

	@Override
	public List<Recruiter> getAll() {
		return null;
	}

	
	@Override
	public void save(Recruiter t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Recruiter t, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Recruiter t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Recruiter> getBySearchCriteria(IsaSearchCriteria criteria) {
		
		
		String query ="select * from isa.recruiter where email=? and password=?;";
		
		List<Recruiter> recrList= new ArrayList<>();
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, criteria.getRecrEmail());
			pst.setString(2, criteria.getRecrPassword());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Recruiter recr = new Recruiter();
				recr.setRecruiterEmail(rs.getString(2));
				recr.setRecruiterPass(rs.getString(3));
				recrList.add(recr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recrList;
	}

}
