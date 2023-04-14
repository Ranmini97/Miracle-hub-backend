package com.backend.miracle_hub.dto;

import com.backend.miracle_hub.entity.Customer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private int id;
    private String name;
    private String email;
    private int phone;
    private String date;

    public enum Gender { M,F }

    @Enumerated(EnumType.STRING)
    private Customer.Gender gender;
}
