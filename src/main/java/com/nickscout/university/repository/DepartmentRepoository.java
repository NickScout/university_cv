package com.nickscout.university.repository;

import com.nickscout.university.model.Department;
import com.nickscout.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepoository extends JpaRepository<Department, Long> {
    @Query("select d.head from Department d where d = ?1")
    Lector getHeadOfDepartment(Department department);
}
