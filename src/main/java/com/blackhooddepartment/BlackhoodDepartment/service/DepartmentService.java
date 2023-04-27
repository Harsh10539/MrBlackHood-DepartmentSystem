package com.blackhooddepartment.BlackhoodDepartment.service;



import com.blackhooddepartment.BlackhoodDepartment.entity.Department;
import com.blackhooddepartment.BlackhoodDepartment.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentId(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
