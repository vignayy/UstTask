package com.ust.Employee_info.repository;

import com.ust.Employee_info.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
    //To get employee details with respect to their grades
    List<EmployeeModel> findByGrade(Character grade);
    //To filter employees based on the salary range
    @Query("SELECT e FROM EmployeeModel e WHERE e.basicSalary BETWEEN :minSalary AND :maxSalary")
    List<EmployeeModel> findEmployeesBySalaryRange(@Param("minSalary") String minSalary, @Param("maxSalary") String maxSalary);
}
