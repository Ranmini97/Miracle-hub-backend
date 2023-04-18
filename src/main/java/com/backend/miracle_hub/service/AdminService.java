package com.backend.miracle_hub.service;

import com.backend.miracle_hub.dto.AdminDTO;
import com.backend.miracle_hub.entity.Admin;
import com.backend.miracle_hub.repo.AdminRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AdminDTO saveAdmin(AdminDTO adminDTO){
        adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        return adminDTO;
    }

    public List<AdminDTO> getAllAdmins(){
        List<Admin> customerList = adminRepo.findAll();
        return modelMapper.map(customerList, new TypeToken<List<AdminDTO>>(){}.getType());
    }

    public AdminDTO updateAdmin(AdminDTO customerDTO){
        adminRepo.save(modelMapper.map(customerDTO, Admin.class));
        return customerDTO;
    }

    public boolean deleteAdmin(AdminDTO customerDTO){
        adminRepo.delete(modelMapper.map(customerDTO, Admin.class));
        return true;
    }

}
