package com.zettamine.isa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.isa.dbconfig.ConnectionFactory;
import com.zettamine.isa.dto.Skill;

public class smaple {

	public static void main(String[] args) throws SQLException {
	Connection con = ConnectionFactory.getDBConnection();
	
	PreparedStatement prest = con.prepareStatement("SELECT * FROM isa.skill");
	ResultSet rs = prest.executeQuery();
	List<Skill> list = new ArrayList<>();
	while(rs.next()) {
		list.add(new Skill( rs.getInt(1), rs.getString(2)));
	}
	System.out.println(list);
	}
}
