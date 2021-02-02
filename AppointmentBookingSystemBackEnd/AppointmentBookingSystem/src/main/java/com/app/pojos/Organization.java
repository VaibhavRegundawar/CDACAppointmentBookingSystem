package com.app.pojos;
import java.io.Serializable;
import java.sql.Blob;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="organizations")
public class Organization  {

	@Id
	@Column(name="org_id",insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orgId;
	
	@Column(length=30,nullable=false,unique=true)
	private String email;
	
	@Column(length=30,nullable=false)
	private String password;
	
	@Column(name="name_of_org",length=30,nullable=false)
	private String nameOfOrganization;
	
	@Column(length=30,nullable=false)
	private String mobileNo;
	
	@Column(length=30,nullable=false)
	private  String city;
	
	@Lob 
	@Column(name="org_img")
	private byte[] org_img;
	
	@Column(length = 30)
	private String imageContentType;

	
	@Column
	private int durationPerService;
	
	
	@ManyToOne
	@JoinColumn(name="orgtype",nullable = false)
	private TypeOfOrganization belongsToOrgType;




	@JsonIgnore
	@OneToMany(mappedBy = "fororganization",cascade = CascadeType.ALL)
	private List<Service> services=new ArrayList<>();
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "bookForOrganization",cascade = CascadeType.ALL)
	private List<Customer> customers=new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "appointmentOfOrg",cascade=CascadeType.ALL)
	private List<Appointment> appointments=new ArrayList<>();
	

	@JsonIgnore
	@OneToMany(mappedBy = "workForOrganization",cascade = CascadeType.ALL)
	private List<Employee> emplist=new ArrayList<>();
	
	
	public Organization() {
		super();
	}


	public Organization(Integer id, String email, String password, String nameOfOrganization, String mobileNo,
			String city, byte[] org_img, String imageContentType, int durationPerService) {
		super();
		this.orgId = id;
		this.email = email;
		this.password = password;
		this.nameOfOrganization = nameOfOrganization;
		this.mobileNo = mobileNo;
		this.city = city;
		this.org_img = org_img;
		this.imageContentType = imageContentType;
		this.durationPerService = durationPerService;
	}


	


	public Integer getOrgId() {
		return orgId;
	}


	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
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


	public String getNameOfOrganization() {
		return nameOfOrganization;
	}


	public void setNameOfOrganization(String nameOfOrganization) {
		this.nameOfOrganization = nameOfOrganization;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public byte[] getOrg_img() {
		return org_img;
	}


	public void setOrg_img(byte[] org_img) {
		this.org_img = org_img;
	}


	public String getImageContentType() {
		return imageContentType;
	}


	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}


	public int getDurationPerService() {
		return durationPerService;
	}


	public void setDurationPerService(int durationPerService) {
		this.durationPerService = durationPerService;
	}


	public TypeOfOrganization getBelongsToOrgType() {
		return belongsToOrgType;
	}


	public void setBelongsToOrgType(TypeOfOrganization belongsToOrgType) {
		this.belongsToOrgType = belongsToOrgType;
	}


	public List<Service> getServices() {
		return services;
	}


	public void setServices(List<Service> services) {
		this.services = services;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


	public List<Employee> getEmplist() {
		return emplist;
	}


	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}


	@Override
	public String toString() {
		return "Organization [id=" + orgId + ", email=" + email + ", password=" + password + ", nameOfOrganization="
				+ nameOfOrganization + ", mobileNo=" + mobileNo + ", city=" + city + ", org_img="
				+ Arrays.toString(org_img) + ", imageContentType=" + imageContentType + ", durationPerService="
				+ durationPerService + "]";
	}


	
	
}
