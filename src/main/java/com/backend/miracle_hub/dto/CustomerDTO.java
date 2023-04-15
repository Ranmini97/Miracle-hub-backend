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
    private String password;
    private int phone;
    private String date;
    private String dob;

    public enum Gender { M,F,O }

    @Enumerated(EnumType.STRING)
    private Customer.Gender gender;
}
