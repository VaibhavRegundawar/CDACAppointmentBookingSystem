package com.app.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="customers")
public class Customer  {
	
	@Id
	@Column(name="cust_id",insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cstId;
	

	
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
	    @JoinColumn(name="_orgid")
	    private Organization bookForOrganization;
	
	 @JsonIgnore
	@OneToMany(mappedBy = "appointmentOfCust",cascade=CascadeType.ALL)
	private List<Appointment> appointments =new ArrayList<>();

	public Customer() {
		super();
	}

	public Customer(Integer id, String email, String password, String firstName, String lastName, Gender gender,
			String mobileNo) {
		super();
		this.cstId = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNo = mobileNo;
	}

	

	public Integer getCstId() {
		return cstId;
	}

	public void setCstId(Integer cstId) {
		this.cstId = cstId;
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

	public Organization getBookForOrganization() {
		return bookForOrganization;
	}

	public void setBookForOrganization(Organization bookForOrganization) {
		this.bookForOrganization = bookForOrganization;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Customer [id=" + cstId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", mobileNo=" + mobileNo + "]";
	}

	 

	
	 
	
	 
	 
}
