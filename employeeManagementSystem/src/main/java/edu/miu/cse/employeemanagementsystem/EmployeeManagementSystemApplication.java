package edu.miu.cse.employeemanagementsystem;

import edu.miu.cse.employeemanagementsystem.model.Employee;
import edu.miu.cse.employeemanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Comparator;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeManagementSystemApplication {

    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return  args -> {
            Employee e1=new Employee("John","Doe",50000);
            Employee e2=new Employee("Jane","Dona",50000);
            Employee e3=new Employee("Alice","Smith",60000);
            Employee e4=new Employee("Bob","Brown",45000);
            employeeService.addNewEmployee(e1);
            employeeService.addNewEmployee(e2);
            employeeService.addNewEmployee(e3);
            employeeService.addNewEmployee(e4);


            System.out.println("Order By Salary:"  );

            List<Employee> empList=employeeService.findAllOrderBySalaryAndLastName();
           empList.stream()
                   .sorted(
                           Comparator
                                   .comparing(Employee::getSalary)
                                   .thenComparing(Employee::getLastName)
                   )
                   .forEach(System.out::println);


        };
    }






}
