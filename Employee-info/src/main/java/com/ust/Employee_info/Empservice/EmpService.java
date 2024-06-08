package com.ust.Employee_info.Empservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Employee_info.model.Empmodel;
import com.ust.Employee_info.Repository.Emprepository;

import java.util.List;
@Service
public class EmpService {
    @Autowired
    private Emprepository repo;

    public List<Empmodel> getAllEmployees() {
        return repo.findAll();
    }

    public Empmodel getEmployeeid(int id) {
        return repo.findById(id).orElse(null);
    }

    public Empmodel createEmployee(Empmodel employee) {
        return repo.save(employee);
    }

    public String deleteEmployee(int empid) {
        repo.deleteById(empid);
        return "Employee deleted with id " + empid;
    }


    public Empmodel updateEmployee(int empid, Empmodel employeeDetails) {
        Empmodel employee = repo.findById(empid).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setBasicSalary(employeeDetails.getBasicSalary());
            employee.setGrade(employeeDetails.getGrade());
            return repo.save(employee);
        }
        return null;
    }

    //To get employee details with respect to their grades
    public List<Empmodel> getEmployeesByGrade(Character grade) {
        return repo.findByGrade(grade);
    }
    //To filter employees based on the salary range
    public List<Empmodel> getEmployeesBySalaryRange(String minSalary, String maxSalary) {
        return repo.findEmployeesBySalaryRange(minSalary, maxSalary);
    }
}
