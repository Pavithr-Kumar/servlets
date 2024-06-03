package com.zettamine.isa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruiter implements IsaDto {
	private Integer recruiterId;
	private String recruiterName;
	private String recruiterEmail;
	private String recruiterPass;

}
