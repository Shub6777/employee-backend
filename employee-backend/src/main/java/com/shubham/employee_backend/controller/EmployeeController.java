package com.shubham.employee_backend.controller;

import com.shubham.employee_backend.model.Employee;
import com.shubham.employee_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*") // ✅ Allow access from Vercel frontend or any domain
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // GET: /api/employees
    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    // POST: /api/employees
    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return service.save(emp);
    }

    // PUT: /api/employees/{id}
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        emp.setId(id);
        return service.save(emp);
    }

    // DELETE: /api/employees/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
