package com.zettamine.isa.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleInterview implements IsaDto {
	private Integer scheduleId;
	private Integer applicantId;
	private Integer interviewerId;
	private Integer recruiterId;
	private Date scheduledDate;
	private Time scheduledTime;
	private Status interviewStatus;

}