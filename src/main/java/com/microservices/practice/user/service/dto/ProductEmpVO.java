package com.microservices.practice.user.service.dto;

import com.microservices.practice.user.service.model.Employee;

public class ProductEmpVO {
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

   private Employee employee;
   private Product product;
}
