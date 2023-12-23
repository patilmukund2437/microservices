package com.microservices.practice.user.service.serviceimpl;

import com.microservices.practice.user.service.dto.Product;
import com.microservices.practice.user.service.dto.ProductEmpVO;
import com.microservices.practice.user.service.feignclient.ProductFeignClient;
import com.microservices.practice.user.service.model.Employee;
import com.microservices.practice.user.service.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProductFeignClient productFeignClient;

    public Employee saveEmp(Employee employee) {
        System.out.println(employee);
        return employeeRepo.save(employee);
    }

    /* public ProductEmpVO getEmpDataByProdId(int id) {
         Employee employee = employeeRepo.findById(id).get();
         Product product = restTemplate.getForObject("http://product-service/product/getproduct/"+employee.getpId(), Product.class);
         ProductEmpVO productEmpVO=new ProductEmpVO();
         productEmpVO.setEmployee(employee);
         productEmpVO.setProduct(product);
         return productEmpVO;
     }*/
    public ProductEmpVO getEmpDataByProdId(int id) {
        Employee employee = employeeRepo.findById(id).get();
        Product product = productFeignClient.getProduct(employee.getpId());
        ProductEmpVO productEmpVO = new ProductEmpVO();
        productEmpVO.setEmployee(employee);
        productEmpVO.setProduct(product);
        return productEmpVO;
    }

}
