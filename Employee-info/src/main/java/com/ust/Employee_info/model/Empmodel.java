package com.ust.Employee_info.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empmodel {
    @Id
    @GeneratedValue

    private int empid;
    private String name;
    private String basicSalary;
    private Character grade;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", basicSalary='" + basicSalary + '\'' +
                ", grade=" + grade +
                '}';
    }
    public int hashCode() {
        return Objects.hash(empid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empmodel that = (Empmodel) o;
        return empid == that.empid && Objects.equals(name, that.name) && Objects.equals(basicSalary, that.basicSalary) && Objects.equals(grade, that.grade);
    }
}
