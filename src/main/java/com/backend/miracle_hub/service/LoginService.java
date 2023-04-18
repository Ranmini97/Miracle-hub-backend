package com.backend.miracle_hub.service;

import com.backend.miracle_hub.ResourceNotFoundException;
import com.backend.miracle_hub.dto.CustomerDTO;
import com.backend.miracle_hub.dto.LoginDTO;
import com.backend.miracle_hub.entity.Login;
import com.backend.miracle_hub.repo.LoginRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private CustomerService customerService;


    @Autowired
    private ModelMapper modelMapper;

    public LoginDTO saveLogin(LoginDTO loginDTO){
        loginRepo.save(modelMapper.map(loginDTO, Login.class));
        return loginDTO;
    }

    public LoginDTO updateLogin(LoginDTO loginDTO){
        loginRepo.save(modelMapper.map(loginDTO, Login.class));
        return loginDTO;
    }

    public List<LoginDTO> getAllLoginDetails(){
        List<Login> loginDetailList = loginRepo.findAll();
        return modelMapper.map(loginDetailList, new TypeToken<List<LoginDTO>>(){}.getType());
    }

    public boolean deleteLogin(LoginDTO loginDTO){
        loginRepo.delete(modelMapper.map(loginDTO, Login.class));
        return true;
    }

    public boolean validateUser(LoginDTO loginDTO) throws ResourceNotFoundException {
        Login login = loginRepo.findById(loginDTO.getUserName() + loginDTO.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid username or password"));
        if (login.getCustomer() != null) {
            CustomerService customerService = new CustomerService();
            CustomerDTO customer = customerService.getCustomerById(login.getCustomer().getId());
            if (customer != null && customer.getPassword().equals(loginDTO.getPassword())) {
                return true;
            }
        }
        if (login.getAdmin() != null) {
            if (login.getAdmin().getRole().equals(loginDTO.getPassword())) {
                return true;
            }
        }
        return false;
    }



}