package com.tka.OrganizationSystem.entity;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter

@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor 
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	String department;
	String status;
	String phoneno;
	double salary;
	Date createddtm;
	String createdby;
	Date updateddtm;
	String updatedby;
	String emailid;
	
	
	@ManyToOne
	@JoinColumn(name="c_id")
	Country country;
	
//	By using lombok  
	
	
	
//	public Employee() {
//		
//	}
//
//	public Employee(String name, String department, String status, String phoneno, double salary, Date createddtm,
//			String createdby, Date updateddtm, String updatedby, String emailid, Country country) {
//		super();
//		this.name = name;
//		this.department = department;
//		this.status = status;
//		this.phoneno = phoneno;
//		this.salary = salary;
//		this.createddtm = createddtm;
//		this.createdby = createdby;
//		this.updateddtm = updateddtm;
//		this.updatedby = updatedby;
//		this.emailid = emailid;
//		this.country = country;
//	}
//
//
//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public String getDepartment() {
//		return department;
//	}
//
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//
//	public String getStatus() {
//		return status;
//	}
//
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//
//	public String getPhoneno() {
//		return phoneno;
//	}
//
//
//	public void setPhoneno(String phoneno) {
//		this.phoneno = phoneno;
//	}
//
//
//	public double getSalary() {
//		return salary;
//	}
//
//
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//
//
//	public Date getCreateddtm() {
//		return createddtm;
//	}
//
//
//	public void setCreateddtm(Date createddtm) {
//		this.createddtm = createddtm;
//	}
//
//
//	public String getCreatedby() {
//		return createdby;
//	}
//
//
//	public void setCreatedby(String createdby) {
//		this.createdby = createdby;
//	}
//
//
//	public Date getUpdateddtm() {
//		return updateddtm;
//	}
//
//
//	public void setUpdateddtm(Date updateddtm) {
//		this.updateddtm = updateddtm;
//	}
//
//
//	public String getUpdatedby() {
//		return updatedby;
//	}
//
//
//	public void setUpdatedby(String updatedby) {
//		this.updatedby = updatedby;
//	}
//
//
//	public String getEmailid() {
//		return emailid;
//	}
//
//
//	public void setEmailid(String emailid) {
//		this.emailid = emailid;
//	}
//
//
//	public Country getCountry() {
//		return country;
//	}
//
//
//	public void setCountry(Country country) {
//		this.country = country;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", status=" + status
//				+ ", phoneno=" + phoneno + ", salary=" + salary + ", createddtm=" + createddtm + ", createdby="
//				+ createdby + ", updateddtm=" + updateddtm + ", updatedby=" + updatedby + ", emailid=" + emailid
//				+ ", country=" + country + "]";
//	}
//	

	
	
}
