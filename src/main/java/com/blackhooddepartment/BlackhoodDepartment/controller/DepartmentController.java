package com.blackhooddepartment.BlackhoodDepartment.controller;

import com.blackhooddepartment.BlackhoodDepartment.entity.Department;
import com.blackhooddepartment.BlackhoodDepartment.error.DepartmentNotFoundException;
import com.blackhooddepartment.BlackhoodDepartment.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of Department Controller");
        //DepartmentService service=new DepartmentServiceImpl();
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/department")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartment of Department Controller");
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentId(departmentId);
    }
    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }
    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return  departmentService.updateDepartmentById(departmentId,department);
    }
    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
