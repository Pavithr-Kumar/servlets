package com.zettamine.isa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interviewer implements IsaDto {
	private Integer interviewerId;
	private String interviewerName;
	private String interviewerEmail;
	private String interviewerSkill;
	private String remarks;

}
