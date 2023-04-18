package com.backend.miracle_hub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
    @Id
    @Column(name = "adId", columnDefinition = "VARCHAR(40)", nullable = false)
    private int id;
    @Column(name = "adName", columnDefinition = "VARCHAR(40)", nullable = false)
    private String name;
    @Column(name = "role", columnDefinition = "VARCHAR(40)", nullable = false)
    private String role;


}
