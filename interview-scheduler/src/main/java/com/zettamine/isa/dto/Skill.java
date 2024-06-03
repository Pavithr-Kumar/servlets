package com.zettamine.isa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill implements IsaDto{
	private Integer skillId;
	private String skillDsec;
	

}
