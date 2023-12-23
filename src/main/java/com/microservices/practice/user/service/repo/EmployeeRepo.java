package com.microservices.practice.user.service.repo;

import com.microservices.practice.user.service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee ,Integer> {

}
