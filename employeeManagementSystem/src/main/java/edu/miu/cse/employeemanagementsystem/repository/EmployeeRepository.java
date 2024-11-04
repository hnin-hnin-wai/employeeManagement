package edu.miu.cse.employeemanagementsystem.repository;

import edu.miu.cse.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Optional<Employee> findByFirstName(String firstName);


    @Query("select e from Employee e order by e.salary asc,e.lastName desc")
    List<Employee> findAllOrderBySalaryAndLastName();

}
