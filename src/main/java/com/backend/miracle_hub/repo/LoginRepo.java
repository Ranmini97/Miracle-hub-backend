package com.backend.miracle_hub.repo;

import com.backend.miracle_hub.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login,String>{
        }