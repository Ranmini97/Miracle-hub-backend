package com.backend.miracle_hub.service;

import com.backend.miracle_hub.dto.SupplierDTO;
import com.backend.miracle_hub.entity.Supplier;
import com.backend.miracle_hub.repo.SupplierRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper modelMapper;

    public SupplierDTO saveSupplier(SupplierDTO supplierDTO){
        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
        supplierRepo.save(supplier);
        return supplierDTO;
    }

    public SupplierDTO updateSupplier(SupplierDTO supplierDTO){
        Optional<Supplier> supplier = supplierRepo.findById(supplierDTO.getId());
        if(supplier.isPresent()){
            Supplier updatedSupplier = modelMapper.map(supplierDTO, Supplier.class);
            supplierRepo.save(updatedSupplier);
            return supplierDTO;
        } else {
            return null;
        }
    }

    public List<SupplierDTO> getAllSuppliers(){
        List<Supplier> supplierList = supplierRepo.findAll();
        return modelMapper.map(supplierList, new TypeToken<List<SupplierDTO>>(){}.getType());
    }

    public boolean deleteSupplier(String id){
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if(supplier.isPresent()){
            supplierRepo.delete(supplier.get());
            return true;
        } else {
            return false;
        }
    }

    public SupplierDTO getSupplierById(String id) {
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if (supplier.isPresent()) {
            return modelMapper.map(supplier.get(), SupplierDTO.class);
        } else {
            return null;
        }
    }
}