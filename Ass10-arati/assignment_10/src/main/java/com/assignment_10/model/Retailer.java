package com.assignment_10.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Retailer {


	@Column(name = "RETAILER_ID")
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	int retailerId;

	@Column(name = "RETAILER_NAME")
	@NotNull(message = "Retailer name cannot be empty")
	@NotBlank(message = "Retailer name cannot be empty")
	@Size(min = 2, max = 12, message = "Retailer name should be atleast 2 chars and atmost 12 chars")
	String RetailerName;

	@Column(name = "RETAILER_CONTACT")
	@Size(min = 10, max = 12, message = "Retailer contact should be atleast 10 digit and atmost 12 digit")
	@Pattern(regexp = "^\\d{10}$")
    String RetailerContact;

	@Column(name = "RETAILER_EMAIL")
	@Email
	@Pattern(regexp = "^(.+)@(\\S+)$")
	String RetailerEmail;

	
	@Column(name = "RETAILER_ADDRESS")
	String RetailerAddress;
	
		
}
