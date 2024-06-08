package com.ust.Employee_info.controller;

import com.ust.Employee_info.model.Empmodel;
import com.ust.Employee_info.Empservice.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmpService employeeService;

    @PostMapping("/createemployee")
    public Empmodel createEmployee(@RequestBody Empmodel employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/getemployees")
    public List<Empmodel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getemp/{id}")
    public Empmodel getEmployeeid(@PathVariable int id){
        return employeeService.getEmployeeid(id);
    }

    @DeleteMapping("/delemp/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateemp/{id}")
    public Empmodel updateEmployee(@PathVariable int id,@RequestBody Empmodel employeeModel){
        return employeeService.updateEmployee(id, employeeModel);
    }

    @GetMapping("/grade/{grade}")
    public List<Empmodel> getEmployeesByGrade(@PathVariable Character grade) {
        return employeeService.getEmployeesByGrade(grade);
    }

    @GetMapping("/salary")
    public List<Empmodel> getEmployeesBySalaryRange(@RequestParam String minSalary, @RequestParam String maxSalary) {
        return employeeService.getEmployeesBySalaryRange(minSalary, maxSalary);
    }
}
