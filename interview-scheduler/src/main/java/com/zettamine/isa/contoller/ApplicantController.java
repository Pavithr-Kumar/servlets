package com.zettamine.isa.contoller;

import java.io.IOException;
import java.util.List;

import com.zettamine.isa.dto.Applicant;
import com.zettamine.isa.dto.IsaSearchCriteria;
import com.zettamine.isa.dto.SearchCriteria;
import com.zettamine.isa.service.impl.ApplicantServices;
import com.zettamine.isa.service.impl.InterviewerServices;
import com.zettamine.isa.service.impl.SkillService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicantController
 */
public class ApplicantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		
		ApplicantServices services = new ApplicantServices();
		    RequestDispatcher rd;
		switch(action) {
		case "showall":
			SkillService skillServi = new SkillService();
			request.setAttribute("skills", skillServi.getAll());
			rd= request.getRequestDispatcher("applicants.jsp");
			List<Applicant> applicants = services.getAll();
			request.setAttribute("applicants", applicants);
			rd.include(request, response);
			break;
		case "add-new":
			SkillService skillSer = new SkillService();
			request.setAttribute("skills", skillSer.getAll());
			rd=request.getRequestDispatcher("app-details.jsp");
			rd.include(request, response);
			break;
		case "add":
			Applicant appl = getApplicant(request);
			
			services.save(appl);
			rd=request.getRequestDispatcher("/applicant?action=showall");
			rd.include(request, response);
			break;
		case "delete":
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			services.delete(services.get(id).get());
			rd=request.getRequestDispatcher("/applicant?action=showall");
			rd.include(request, response);
			break;
		case "edit":
			SkillService skillServ = new SkillService();
			request.setAttribute("skills", skillServ.getAll());
			Integer iden = Integer.parseInt(request.getParameter("id"));
			Applicant app=services.get(iden).get();
			request.setAttribute("applicant", app);
			rd=request.getRequestDispatcher("app-update-details.jsp");
			rd.include(request, response);
			break;
		case "edit-add":
			Applicant applic = getApplicant(request);
			applic.setApplicantId(Integer.parseInt(request.getParameter("id")));
			services.update(applic);
			rd=request.getRequestDispatcher("/applicant?action=showall");
			rd.include(request, response);
			break;
		case "search":
			IsaSearchCriteria search = new IsaSearchCriteria();
			SkillService skillService = new SkillService();
			request.setAttribute("skills", skillService.getAll());
			search.setSkillId(Integer.parseInt(request.getParameter("skillId")));
			request.setAttribute("applicants",services.getBySearchCriteria(search) );
			rd=request.getRequestDispatcher("applicants.jsp");
			rd.include(request, response);
			break;
		case "load":
			SkillService skillServices = new SkillService();
			request.setAttribute("skills", skillServices.getAll());
			rd=request.getRequestDispatcher("applicants.jsp");
			rd.include(request, response);
			break;
		case "schedule":
		
			SkillService skillSe = new SkillService();
			IsaSearchCriteria searchCrt = new IsaSearchCriteria();
			ApplicantServices appSer = new ApplicantServices();
			Applicant applicant = appSer.get(Integer.parseInt(request.getParameter("id"))).get();
			searchCrt.setSkillId(Integer.parseInt(applicant.getApplicantSkill()));
			InterviewerServices intSer = new InterviewerServices();
			request.setAttribute("interviewers",intSer.getBySearchCriteria(searchCrt) );
			request.setAttribute("applSkill", skillSe.getSkillById(Integer.parseInt(applicant.getApplicantSkill())));
			request.setAttribute("applicant", applicant);
			rd=request.getRequestDispatcher("schedule-interviews.jsp");
			rd.include(request, response);
			break;
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	static Applicant getApplicant(HttpServletRequest req) {
		Applicant appl = new Applicant();
		appl.setApplicantName(req.getParameter("name"));
		appl.setApplicantEmail(req.getParameter("email"));
		appl.setApplicantSkill(req.getParameter("skill"));
		appl.setApplicantPhNo(req.getParameter("phone"));
		appl.setAppEducatStream(req.getParameter("stream"));
		appl.setApplicantQualification(req.getParameter("qualification"));
		appl.setApplicantRemarks(req.getParameter("remarks"));
		//System.out.println((Double.parseDouble(req.getParameter("percentage")).getClass().getSimpleName()));
		//System.out.println(req.getParameter("percentage"));
		if(req.getParameter("percentage")!=null)
		appl.setApplicantAggrePercentage( Double.parseDouble(req.getParameter("percentage")));
		
		return appl;
	}

}
