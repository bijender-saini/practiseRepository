package com.saini.runner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.saini.enity.Employee;
import com.saini.enity.EmployeeRepository;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public void run(String... args) throws Exception {

		Employee e1 = new Employee();

		e1.setName("Bijender");
		e1.setAddress("UP");
		e1.setEscalationTime(1);

		Employee e2 = new Employee();

		e2.setName("Raj");
		e2.setAddress("Goa");
		e2.setEscalationTime(2);
		Employee e3 = new Employee();

		e3.setName("Sanju");
		e3.setAddress("Bihar");
		e3.setEscalationTime(2);
		Employee e4 = new Employee();

		e4.setEscalationTime(1);
		e4.setName("Rohan");
		e4.setAddress("Panjab");
		Employee e5 = new Employee();

		e5.setName("Mohan");
		e5.setEscalationTime(1);
		e5.setAddress("Sohna");
		Employee e6 = new Employee();

		e6.setName("Sanjana");
		e6.setAddress("Mumbai");
		e6.setEscalationTime(2);

		employeeRepo.saveAll(Arrays.asList(e1, e2,e3,e4,e5,e6));

//		Employee e7=new Employee();
////		
//		e7.setName("Tannu");
//		e7.setAddress("Sikkim");
//		e7.setCreatedOn(new Date());

//		employeeRepo.save(e7);

		List<Employee> list = employeeRepo.findAll();

		System.out.println(list);

		System.out.println("-----------------------------");

		list.sort((s1, s2) -> s2.getCreatedOn().compareTo(s1.getCreatedOn()));

		System.out.println("Asecending order ");
		System.out.println(list);

		list.sort((s1, s2) -> s1.getCreatedOn().compareTo(s2.getCreatedOn()));
		System.out.println("Descending order");

		System.out.println(list);

	}
	
	
	
	@Scheduled(cron = "* * * * * *")
	void getMessage() {
		
		List<Employee> findAll = employeeRepo.findAll();
		findAll.stream().forEach(emp->{
			if(emp.getEscalationTime()<2) {
				System.out.println("message send "+new Date());
				System.out.println(emp);
				
			}
		});
	}
	
	

}
