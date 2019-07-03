package com.nickscout.university;

import com.nickscout.university.model.Degree;
import com.nickscout.university.model.Department;
import com.nickscout.university.model.Lector;
import com.nickscout.university.repository.DepartmentRepoository;
import com.nickscout.university.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@SpringBootApplication
public class UniversityApplication {

	@Autowired
	DepartmentRepoository departmentRepoository;

	@Autowired
	LectorRepository lectorRepository;

	@PostConstruct
	public void onStart() {


	}


	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

}
