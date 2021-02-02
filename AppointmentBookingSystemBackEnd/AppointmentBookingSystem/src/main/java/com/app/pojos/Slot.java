package com.app.pojos;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="slots")
public class Slot  {
	
	@Id
	@Column(name="slot_id",insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slotId;
	
	@Column(length=30,nullable=false)
	private String slotName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate date;
	
	@Column(name="starting_time")
	private String startingTime;
	
	@Column(name="ending_time")
	private String endingTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "slot_status", length = 20, nullable = false)
	private Status slotstatus;
    
	@ManyToOne
	@JoinColumn(name="emp_id",nullable = false)
	private Employee Employee;

	public Slot() {
		super();
	}

	public Slot(Integer slotId, String slotName, LocalDate date, String startingTime, String endingTime,
			Status slotstatus) {
		super();
		this.slotId = slotId;
		this.slotName = slotName;
		this.date = date;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.slotstatus = slotstatus;
	}

	public Integer getSlotId() {
		return slotId;
	}

	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}

	public String getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(String endingTime) {
		this.endingTime = endingTime;
	}

	public Status getSlotstatus() {
		return slotstatus;
	}

	public void setSlotstatus(Status slotstatus) {
		this.slotstatus = slotstatus;
	}

	public Employee getEmployee() {
		return Employee;
	}

	public void setEmployee(Employee employee) {
		Employee = employee;
	}

	@Override
	public String toString() {
		return "Slot [slotId=" + slotId + ", slotName=" + slotName + ", date=" + date + ", startingTime=" + startingTime
				+ ", endingTime=" + endingTime + ", slotstatus=" + slotstatus + "]";
	}

	
	
	
}
