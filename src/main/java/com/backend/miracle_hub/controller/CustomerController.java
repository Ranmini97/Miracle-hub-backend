package com.backend.miracle_hub.controller;

import com.backend.miracle_hub.dto.CustomerDTO;
import com.backend.miracle_hub.entity.Customer;
import com.backend.miracle_hub.repo.CustomerRepo;
import com.backend.miracle_hub.service.CustomerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/getCustomers")
    public List<CustomerDTO> getCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/saveCustomer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

//    @PostMapping("/saveCustomer")
//    public Customer saveCustomer(@RequestBody @NotNull CustomerDTO customerDTO) {
//            Customer customer=new Customer(customerDTO.getId(),
//                    customerDTO.getName(),
//                    customerDTO.getEmail(),
//                    customerDTO.getPhone(),
//                    customerDTO.getDate(),
//                    customerDTO.getGender());
//            return customerRepo.save(customer);
//    }

    @PutMapping("/updateCustomer")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){

        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/deleteCustomer")
    public boolean deleteCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.deleteCustomer(customerDTO);
    }
}
