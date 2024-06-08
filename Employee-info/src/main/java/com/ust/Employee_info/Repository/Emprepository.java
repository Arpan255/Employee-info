package com.ust.Employee_info.Repository;

import com.ust.Employee_info.model.Empmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface Emprepository extends JpaRepository<Empmodel, Integer> {
    List<Empmodel> findByGrade(Character grade);
    //To filter employees based on the salary range
    @Query("SELECT e FROM EmployeeModel e WHERE e.basicSalary BETWEEN :minSalary AND :maxSalary")
    List<Empmodel> findEmployeesBySalaryRange(@Param("minSalary") String minSalary, @Param("maxSalary") String maxSalary);

}
