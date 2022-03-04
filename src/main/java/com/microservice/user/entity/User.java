package com.microservice.user.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Voter_master",uniqueConstraints=
	@UniqueConstraint(columnNames={ "aadhaarCardNo"}))
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private long voterId;
	private String name;
	private Date DOB;
	private String aadhaarCardNo;
	private String Password;
	private Boolean status;


}
