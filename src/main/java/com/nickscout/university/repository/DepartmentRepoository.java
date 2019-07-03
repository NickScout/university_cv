package com.nickscout.university.repository;

import com.nickscout.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepoository extends JpaRepository<Department, Long> {
}
