package com.backend.miracle_hub.controller;

import com.backend.miracle_hub.dto.SupplierDTO;
import com.backend.miracle_hub.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/supplier")
@CrossOrigin("http://localhost:3000")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/addSupplier")
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.saveSupplier(supplierDTO));
    }

    @PutMapping("/updateSupplier/{supId}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable String supId, @RequestBody SupplierDTO supplierDTO) {
        supplierDTO.setId(supId);
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.updateSupplier(supplierDTO));
    }

    @GetMapping("/getAllSuppliers")
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.getAllSuppliers());
    }

    @GetMapping("/getSupplierById/{supId}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable String supId) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.getSupplierById(supId));
    }

    @DeleteMapping("/deleteSupplier/{supId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable String supId) {
        supplierService.deleteSupplier(supId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}