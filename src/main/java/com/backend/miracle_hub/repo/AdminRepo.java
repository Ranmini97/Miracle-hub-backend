package com.backend.miracle_hub.repo;

import com.backend.miracle_hub.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{
}



