package com.backend.miracle_hub.repo;

import com.backend.miracle_hub.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepo extends JpaRepository<Supplier, String>{
}