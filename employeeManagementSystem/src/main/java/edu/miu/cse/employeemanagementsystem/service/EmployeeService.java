package edu.miu.cse.employeemanagementsystem.service;

import edu.miu.cse.employeemanagementsystem.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> addNewEmployee(Employee employee);

    Optional<Employee> findEmployeeByFirstName(String firstName);

    void deleteEmployee(String firstName);

    Optional<Employee> modifyEmployeeFirstName(String firstName, Employee employee);

    List<Employee> findAllOrderBySalaryAndLastName();

}
