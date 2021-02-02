package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="appointments")
public class Appointment {

	

	@Id
	@Column(name="apt_id",insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aptId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="apt_date")
	private LocalDate date;
	
	@Column(name="starting_time")
	private String startingTime;
	
	@Column(name="ending_time")
	private String endingTime;
	
	@Column(name="total_price")
	private double totalPrice;
	
	 @ManyToOne
	    @JoinColumn(name="idOrg",nullable = false)
	    private Organization appointmentOfOrg;

	 @ManyToOne
	    @JoinColumn(name="empid",nullable = false)
	    private Employee appointmentOfEmp;
	 
	 @ManyToOne
	    @JoinColumn(name="cust_id",nullable = false)
	    private Customer appointmentOfCust;
	 
	 @ManyToOne
	    @JoinColumn(name="orgtypeid",nullable = false)
	    private TypeOfOrganization appointmentOfOrgType;

	public Appointment() {
		super();
	}

	public Appointment(int aptId, LocalDate date, String startingTime, String endingTime, double totalPrice) {
		super();
		this.aptId = aptId;
		this.date = date;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.totalPrice = totalPrice;
	}

	public int getAptId() {
		return aptId;
	}

	public void setAptId(int aptId) {
		this.aptId = aptId;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Organization getAppointmentOfOrg() {
		return appointmentOfOrg;
	}

	public void setAppointmentOfOrg(Organization appointmentOfOrg) {
		this.appointmentOfOrg = appointmentOfOrg;
	}

	public Employee getAppointmentOfEmp() {
		return appointmentOfEmp;
	}

	public void setAppointmentOfEmp(Employee appointmentOfEmp) {
		this.appointmentOfEmp = appointmentOfEmp;
	}

	public Customer getAppointmentOfCust() {
		return appointmentOfCust;
	}

	public void setAppointmentOfCust(Customer appointmentOfCust) {
		this.appointmentOfCust = appointmentOfCust;
	}

	public TypeOfOrganization getAppointmentOfOrgType() {
		return appointmentOfOrgType;
	}

	public void setAppointmentOfOrgType(TypeOfOrganization appointmentOfOrgType) {
		this.appointmentOfOrgType = appointmentOfOrgType;
	}

	@Override
	public String toString() {
		return "Appointment [aptId=" + aptId + ", date=" + date + ", startingTime=" + startingTime + ", endingTime="
				+ endingTime + ", totalPrice=" + totalPrice + "]";
	}

	
	
	

	

	
     
     
}
