package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="employees")
public class Employee  {

	@Id
	@Column(name="emp_id",insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	@Column(length=30,nullable=false,unique=true)
	private String email;
	
	@Column(length=30,nullable=false)
	private String password;
	
	@Column(name="first_name",length=30,nullable=false)
	private String firstName;
	
	@Column(name="last_name",length=30,nullable=false)
	private String lastName;
	
	@Column(name="gender",nullable=false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="mobile_no",length=30,nullable=false)
	private String mobileNo;
	
	 @ManyToOne
	    @JoinColumn(name="orgid",nullable = false)
	    private Organization workForOrganization;
	 
	 @ManyToOne
	    @JoinColumn(name="serv_id",nullable = false)
	    private Service serviceProvided; 
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "Employee",cascade = CascadeType.ALL)
		private List<Slot> slots=new ArrayList<>();
	
	 @JsonIgnore
	@OneToMany(mappedBy = "appointmentOfEmp",cascade=CascadeType.ALL)
	private List<Appointment> appointments =new ArrayList<>();

	public Employee() {
		super();
	}

	public Employee(Integer id, String email, String password, String firstName, String lastname, Gender gender,
			String mobileNo) {
		super();
		this.empId = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastname;
		this.gender = gender;
		this.mobileNo = mobileNo;
	}

	

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Organization getWorkForOrganization() {
		return workForOrganization;
	}

	public void setWorkForOrganization(Organization workForOrganization) {
		this.workForOrganization = workForOrganization;
	}

	public Service getServiceProvided() {
		return serviceProvided;
	}

	public void setServiceProvided(Service serviceProvided) {
		this.serviceProvided = serviceProvided;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Employee [id=" + empId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastname=" + lastName + ", gender=" + gender + ", mobileNo=" + mobileNo + "]";
	}

    

	
	 

	
	 
	 
}
