package com.backend.miracle_hub.controller;

import com.backend.miracle_hub.dto.AdminDTO;
import com.backend.miracle_hub.repo.AdminRepo;
import com.backend.miracle_hub.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v2/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    AdminRepo adminRepo;

    @GetMapping("/getAdmins")
    public List<AdminDTO> getAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping("/saveAdmin")
    public AdminDTO saveAdmin(@RequestBody AdminDTO adminDTO){
        return adminService.saveAdmin(adminDTO);
    }

//    @PostMapping("/saveAdmin")
//    public Admin saveAdmin(@RequestBody @NotNull CustomerDTO customerDTO) {
//            Admin admin=new Admin(adminDTO.getId(),
//                    adminDTO.getName(),
//                    adminDTO.getRol());
//            return adminRepo.save(admin);
//    }

    @PutMapping("/updateAdmin")
    public AdminDTO updateAdmin(@RequestBody AdminDTO adminDTO){

        return adminService.updateAdmin(adminDTO);
    }

    @DeleteMapping("/deleteAdmin")
    public boolean deleteAdmin(@RequestBody AdminDTO adminDTO){
        return adminService.deleteAdmin(adminDTO);
    }
}
