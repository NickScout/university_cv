package com.nickscout.university;

import com.nickscout.university.view.Console;
import com.nickscout.university.repository.DepartmentRepoository;
import com.nickscout.university.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.*;
import java.util.Properties;


@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class UniversityApplication {

	@Autowired
	DepartmentRepoository departmentRepoository;

	@Autowired
	LectorRepository lectorRepository;

	@Autowired Console c;
	@PostConstruct
	public void onStart() {


		c.start();

	}


	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}


}
