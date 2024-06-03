package com.zettamine.isa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant implements IsaDto {
	private Integer applicantId;
	private String applicantName;
	private String applicantEmail;
	private String applicantSkill;
	private String applicantPhNo;
	private String appEducatStream;
	private String applicantQualification;
	private String applicantRemarks;
	private Double applicantAggrePercentage;
	

}
