package edu.miu.cse.employeemanagementsystem.service.Impl;

import edu.miu.cse.employeemanagementsystem.model.Employee;
import edu.miu.cse.employeemanagementsystem.repository.EmployeeRepository;
import edu.miu.cse.employeemanagementsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> addNewEmployee(Employee employee) {
        Employee saveEmployee=employeeRepository.save(employee);
        return Optional.of(saveEmployee);
    }

    @Override
    public Optional<Employee> findEmployeeByFirstName(String firstName) {
        employeeRepository.findByFirstName(firstName);
        return Optional.empty();
    }

    @Override
    public void deleteEmployee(String firstName) {
        employeeRepository.findByFirstName(firstName)
                .ifPresent(employee -> employeeRepository.delete(employee));
    }

    @Override
    public Optional<Employee> modifyEmployeeFirstName(String firstName, Employee employee) {
        Optional<Employee> foundEmployee=employeeRepository.findByFirstName(firstName);
        foundEmployee.ifPresent(employee1 -> employee1.setFirstName(employee.getFirstName()));
        return Optional.empty();
    }

    @Override
    public List<Employee> findAllOrderBySalaryAndLastName() {
        return employeeRepository.findAllOrderBySalaryAndLastName();
    }
}
