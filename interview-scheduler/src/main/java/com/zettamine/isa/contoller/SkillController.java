package com.zettamine.isa.contoller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dto.Skill;
import com.zettamine.isa.service.impl.SkillService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SkillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SkillService service =new SkillService();
		String action=request.getParameter("action");
		RequestDispatcher rd = request.getRequestDispatcher("skills.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("/skill?action=showall");
		switch(action) {
		case "showall":
			List<Skill> skills= service.getAll();
			request.setAttribute("skills", skills);
			rd.include(request, response);
			break;
		case "delete":
			Integer id=Integer.parseInt( request.getParameter("id"));
			SkillService ser = new SkillService();
			Optional<Skill> optional = ser.get(id);
			ser.delete(optional.get());
			rd2.include(request, response);
			break;
		case "add":
			String newSkill=request.getParameter("skill");
			Skill skill = new Skill();
			skill.setSkillDsec(newSkill);
			Integer count = service.save(skill,true);
			
			request.setAttribute("count", count);
			rd2.include(request, response);
			break;
			
			
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
