package org.jenith.java.controller;

import com.codoid.products.exception.FilloException;
import org.jenith.java.entity.Employee;
import org.jenith.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmployee")
    public String getEmployeeName() {
        return "Zenith";
    }

    @GetMapping("/readCSVFile")
    public Map<String, String> readCSVFile() throws FilloException {
        return employeeService.readCSVFile();
    }

    @GetMapping("/updateCSVFile")
    public Map<String, String> updateCSVFile() throws FilloException {
        return employeeService.updateCSVFile();
    }
}
