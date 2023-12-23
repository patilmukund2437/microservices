package com.microservices.practice.user.service.controller;

import com.microservices.practice.user.service.dto.ProductEmpVO;
import com.microservices.practice.user.service.model.Employee;
import com.microservices.practice.user.service.serviceimpl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeSrvice;

    @PostMapping("/addemp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employee = employeeSrvice.saveEmp(employee);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping("/getemp/{id}")
    public ResponseEntity<ProductEmpVO> getEmpDataByProdId(@PathVariable("id") int id) {
        ProductEmpVO productEmpVO = employeeSrvice.getEmpDataByProdId(id);
        return ResponseEntity.status(HttpStatus.OK).body(productEmpVO);
    }

}
