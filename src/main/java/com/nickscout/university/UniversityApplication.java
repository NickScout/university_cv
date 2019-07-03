package com.nickscout.university;

import com.nickscout.university.controller.Console;
import com.nickscout.university.model.Degree;
import com.nickscout.university.model.Department;
import com.nickscout.university.model.Lector;
import com.nickscout.university.repository.DepartmentRepoository;
import com.nickscout.university.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class UniversityApplication {

	@Autowired
	DepartmentRepoository departmentRepoository;

	@Autowired
	LectorRepository lectorRepository;

	@Autowired Console c;
	@PostConstruct
	public void onStart() {
		Lector ns = new Lector();
		ns.setFirstName("Nick");
		ns.setSecondName("Scout");
		ns.setSalary(999999);
		ns.setDegree(Degree.PROFESSOR);
		lectorRepository.save(ns);
		Department ami = new Department();
		ami.setHead(ns);
		ami.setName("applied mathematics and informatics");
		ami.getLectors().add(ns);
		departmentRepoository.save(ami);

		try {
			c.showSearchResult("applied mathematics and informatics");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

}
