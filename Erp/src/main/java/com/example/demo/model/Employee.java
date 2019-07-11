package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="testemployee")
public class Employee{


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable = false)
	private int id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	
	@Column(name="phone",nullable=false)
	private String phone;
	
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="address",nullable=false)
     private String address;
	
	@Column(name="landline_number",nullable=false)
	private String landline_number;
	
	@Column(name="mobile_number",nullable=false)
	private String mobile_number;
	
	@Column(name="gender",nullable=false)
	private String Gender;
	
	@Column(name="permission",nullable=false)
    private String terms_conditons;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getTerms_conditons() {
		return terms_conditons;
	}
	public void setTerms_conditons(String terms_conditons) {
		this.terms_conditons = terms_conditons;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public String getLandline_number() {
		return landline_number;
	}
	public void setLandline_number(String landline_number) {
		this.landline_number = landline_number;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
