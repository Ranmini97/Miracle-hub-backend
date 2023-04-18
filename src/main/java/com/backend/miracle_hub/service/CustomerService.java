package com.backend.miracle_hub.service;

import com.backend.miracle_hub.ResourceNotFoundException;
import com.backend.miracle_hub.dto.CustomerDTO;
import com.backend.miracle_hub.entity.Customer;
import com.backend.miracle_hub.repo.CustomerRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
        private CustomerRepo customerRepo;

        @Autowired
        private ModelMapper modelMapper;

        public CustomerDTO saveCustomer(CustomerDTO customerDTO){
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return customerDTO;
        }

        public List<CustomerDTO> getAllCustomers(){
            List<Customer> customerList = customerRepo.findAll();
            return modelMapper.map(customerList, new TypeToken<List<CustomerDTO>>(){}.getType());
        }

        public CustomerDTO updateCustomer(CustomerDTO customerDTO){
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return customerDTO;
        }

        public boolean deleteCustomer(CustomerDTO customerDTO){
            customerRepo.delete(modelMapper.map(customerDTO, Customer.class));
            return true;
        }

    public CustomerDTO getCustomerById(int customerId) throws ResourceNotFoundException {
        Optional<Customer> customerOptional = customerRepo.findById(customerId); //Optional is a java class in java.util package. used as a return type for methods that may or may not return a value.
        if (((Optional<?>) customerOptional).isPresent()) { //isPresent() is a utility method. check the presence of a value, and access it if present.
            Customer customer = customerOptional.get();
            return modelMapper.map(customer, CustomerDTO.class); //mapping the Customer object to a CustomerDTO
        } else {
            throw new ResourceNotFoundException("Customer not found with id: " + customerId);
        }
    }
}
