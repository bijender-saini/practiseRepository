package com.saini.enity;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {
	


}
