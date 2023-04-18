package com.backend.miracle_hub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {
    @Id
    @Column(name = "userName", columnDefinition = "VARCHAR(15)", nullable = false)
    private String userName;

    @Column(name = "password", columnDefinition = "VARCHAR(15)", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cID", referencedColumnName = "cID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adID", referencedColumnName = "adID")
    private Admin admin;
}