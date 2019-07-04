package com.nickscout.university.controller;

import com.nickscout.university.model.Department;
import com.nickscout.university.repository.DepartmentRepoository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentRepoository departmentRepoository;

    @GetMapping (value = "/department/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        Optional<Department> optionalDepartment = departmentRepoository.findById(id);
        if (optionalDepartment.isPresent()) {
            return new ResponseEntity<>(optionalDepartment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value = "/department/")
    public ResponseEntity<Set<Department>> getAllDepartments(@RequestParam int limit) {
        Set<Department> departments = departmentRepoository.findAllWithLimit(limit);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PostMapping (value = "/department/")
    public ResponseEntity<Department> postDepartment(@RequestBody Department department) {
        if (department != null) {
            departmentRepoository.save(department);
            return new ResponseEntity<>(department, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping (value = "/department/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable Long id) {
        departmentRepoository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
