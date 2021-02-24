package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(value = { @NamedQuery(name = "find All" , query="from Employee"),
           @NamedQuery(name = "findByName" , query="from Employee where name=:ename")})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique= true, nullable= false)
	private int id;
	
	@Column
	private String name;
	private String mobile;
	private Double salary;
	private int age;
	
	@Version
	private Integer vCount;
	
}
