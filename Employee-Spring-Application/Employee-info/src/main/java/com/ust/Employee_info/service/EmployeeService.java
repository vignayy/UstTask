package com.ust.Employee_info.service;

import com.ust.Employee_info.model.EmployeeModel;
import com.ust.Employee_info.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<EmployeeModel> getAllEmployees() {
        return repo.findAll();
    }

    public EmployeeModel getEmployeeid(int id) {
        return repo.findById(id).orElse(null);
    }

    public EmployeeModel createEmployee(EmployeeModel employee) {
        return repo.save(employee);
    }

    public String deleteEmployee(int empid) {
        repo.deleteById(empid);
        return "Employee deleted with id " + empid;
    }


    public EmployeeModel updateEmployee(int empid, EmployeeModel employeeDetails) {
        EmployeeModel employee = repo.findById(empid).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setBasicSalary(employeeDetails.getBasicSalary());
            employee.setGrade(employeeDetails.getGrade());
            return repo.save(employee);
        }
        return null;
    }

    //To get employee details with respect to their grades
    public List<EmployeeModel> getEmployeesByGrade(Character grade) {
        return repo.findByGrade(grade);
    }
    //To filter employees based on the salary range
    public List<EmployeeModel> getEmployeesBySalaryRange(String minSalary, String maxSalary) {
        return repo.findEmployeesBySalaryRange(minSalary, maxSalary);
    }



}
