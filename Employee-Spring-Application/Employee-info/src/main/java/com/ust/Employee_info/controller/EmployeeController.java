package com.ust.Employee_info.controller;

import com.ust.Employee_info.model.EmployeeModel;
import com.ust.Employee_info.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createemployee")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/getemployees")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getemp/{id}")
    public EmployeeModel getEmployeeid(@PathVariable int id){
        return employeeService.getEmployeeid(id);
    }

    @DeleteMapping("/delemp/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateemp/{id}")
    public EmployeeModel updateEmployee(@PathVariable int id,@RequestBody EmployeeModel employeeModel){
        return employeeService.updateEmployee(id, employeeModel);
    }

    @GetMapping("/grade/{grade}")
    public List<EmployeeModel> getEmployeesByGrade(@PathVariable Character grade) {
        return employeeService.getEmployeesByGrade(grade);
    }

    @GetMapping("/salary")
    public List<EmployeeModel> getEmployeesBySalaryRange(@RequestParam String minSalary, @RequestParam String maxSalary) {
        return employeeService.getEmployeesBySalaryRange(minSalary, maxSalary);
    }

}
