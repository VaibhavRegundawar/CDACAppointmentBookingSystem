package com.app.pojos;
import java.io.Serializable;
import java.time.LocalTime;
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
@Table(name="services")
public class Service {

	@Id
	@Column(name="serv_id",insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serId;
	
	@Column(name="serv_name",length=30,nullable=false)
	private String serviceName;
	
	
	
	@Column
    private double price;
    

    @ManyToOne
    @JoinColumn(name="org",nullable = false)
    private Organization fororganization;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceProvided",cascade = CascadeType.ALL)
	private List<Employee> employees=new ArrayList<>(); 
    

	public Service() {
		super();
	}


	public Service(Integer id, String serviceName, double price) {
		super();
		this.serId = id;
		this.serviceName = serviceName;
		this.price = price;
	}


	

	public Integer getSerId() {
		return serId;
	}


	public void setSerId(Integer serId) {
		this.serId = serId;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Organization getFororganization() {
		return fororganization;
	}


	public void setFororganization(Organization fororganization) {
		this.fororganization = fororganization;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Service [id=" + serId + ", serviceName=" + serviceName + ", price=" + price + "]";
	}

	

	
	
	
	
}
