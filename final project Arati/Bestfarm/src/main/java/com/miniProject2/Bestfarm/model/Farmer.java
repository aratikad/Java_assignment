package com.miniProject2.Bestfarm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Farmer {

	@Column(name = "FARMER_ID")
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	int farmerId;

	@NotNull(message = "Farmer name cannot be empty")
	@NotBlank(message = "Farmer name cannot be empty")
	@Size(min = 8, max = 40, message = "Farmer name should be atleast 8 chars and atmost 12 chars")
	String fname;

	@Min(18)
	@Max(value = 125, message = "age in between 18 & 125")
	public int age;


	public String gender;

	public Farmer() {

	}


	public Farmer(String fname, int age,String gender) {
		this.fname = fname;
		this.age = age;
		this.gender=gender;
		
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getFarmerId() {
			return farmerId;
	}


}
