package com.shubham.employee_backend.service;

import com.shubham.employee_backend.model.Employee;
import com.shubham.employee_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() { return repo.findAll(); }

    public Employee save(Employee emp) { return repo.save(emp); }

    public void delete(Long id) { repo.deleteById(id); }

    public Employee get(Long id) {
        return repo.findById(id).orElse(null);
    }
}
