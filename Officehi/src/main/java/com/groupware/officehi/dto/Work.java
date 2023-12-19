package com.groupware.officehi.dto;

import java.time.LocalTime;

import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Work {

	private Long userNo;
	private String date;
	private String arrivalTime;
	private String leaveTime;
	private String name;

	public Work() {
	}

	public Work(Long userNo, String date, String arrivalTime, String leaveTime, String name) {
		this.userNo = userNo;
		this.date = date;
		this.arrivalTime = arrivalTime;
		this.leaveTime = leaveTime;
		this.name = name;
	}

	public String getWorkTimeHour() {
		if (!(leaveTime == null)) {
			LocalTime arrival = LocalTime.parse(arrivalTime);
			LocalTime leave = LocalTime.parse(leaveTime);
			return String.valueOf(arrival.until(leave, java.time.temporal.ChronoUnit.HOURS)+"H");
		} else
			return " - ";
	}

}
