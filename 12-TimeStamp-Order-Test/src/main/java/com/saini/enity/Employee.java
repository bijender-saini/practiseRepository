package com.saini.enity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	private String address;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createdOn;
	
	
	private Integer escalationTime;
	
	@Column(columnDefinition = "timestamp default current_timestamp",insertable = false,updatable = false)
//	@CreationTimestamp
	private Timestamp createdOn;
   

}
