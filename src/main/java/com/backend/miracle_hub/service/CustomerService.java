package com.backend.miracle_hub.service;

import com.backend.miracle_hub.dto.CustomerDTO;
import com.backend.miracle_hub.entity.Customer;
import com.backend.miracle_hub.repo.CustomerRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
        private CustomerRepo customerRepo;
    //
    //    public void saveAll(List<Event> events) {
    //        eventRepository.saveAll(events);
    //    }
    //
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

}
