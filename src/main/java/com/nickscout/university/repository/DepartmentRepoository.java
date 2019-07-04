package com.nickscout.university.repository;

import com.nickscout.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

@Repository
public interface DepartmentRepoository extends JpaRepository<Department, Long> {

    @Query(value = "select d from Department d where locate(?1, d.name) > 0")
    Set<Department> findDepartmentsByPartialName(String name);
    
    Optional<Department> findDepartmentByName(String name);

    @Query(value = "SELECT * FROM department d LIMIT ?1",
    nativeQuery = true)
    Set<Department> findAllWithLimit(int limit);

}
