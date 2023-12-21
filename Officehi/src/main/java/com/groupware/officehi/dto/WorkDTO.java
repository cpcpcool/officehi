package com.groupware.officehi.dto;

import java.time.LocalTime;

import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class WorkDTO {

	private Long userNo;
	private String date;
	private String arrivalTime;
	private String leaveTime;
	private String name;

	public String getWorkTimeHour() {
		if (leaveTime != null) {
			LocalTime arrival = LocalTime.parse(arrivalTime);
			LocalTime leave = LocalTime.parse(leaveTime);
			return String.valueOf(arrival.until(leave, java.time.temporal.ChronoUnit.HOURS)+"H");
		} else
			return " - ";
	}

}
