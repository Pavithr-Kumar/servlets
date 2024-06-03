package com.zettamine.isa.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IsaSearchCriteria implements SearchCriteria {
	//search criteria for the recruiter
		private Integer recrId;
		private String recrName;
		private String recrEmail;
		private String recrPassword;
		
		
		//search criteria for the skill
		private Integer skillId;
		private String skill_desc;
		
		//search criteria for the interviewer
		private Integer interviewerId;
		private String interviewerName;
		
		//search criteria for the applicant
		private Integer applicantId;
		private String applicantName;
		
		private Integer scheduleId;
		private Date fromDate;
		private Date toDate;
	

	

}
