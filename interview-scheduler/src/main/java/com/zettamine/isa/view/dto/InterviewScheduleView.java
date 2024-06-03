package com.zettamine.isa.view.dto;

import java.sql.Date;
import java.sql.Time;

import com.zettamine.isa.dto.SearchCriteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewScheduleView implements IsaViewDto, SearchCriteria{
	
	private Integer scheduleId;
	private String applicantName;
	private String interviewName;
	private String recruiterName;
	private Date scheduleDate;
	private Time scheduleTime;
	private String status;

}
