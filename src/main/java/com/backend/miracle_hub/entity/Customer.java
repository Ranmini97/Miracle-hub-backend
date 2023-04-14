package com.backend.miracle_hub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cId", columnDefinition = "INT", nullable = false)
    private int id;
    @Column(name = "cName", columnDefinition = "VARCHAR(40)", nullable = false)
    private String name;
    @Column(name = "email", columnDefinition = "VARCHAR(40)", nullable = false)
    private String email;
    @Column(name = "cPhone", columnDefinition = "INT")
    private int phone;
    @Column(name = "regDate", columnDefinition = "DATE")
    private String date;

    public enum Gender { M,F }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "ENUM('M','F')", nullable = true)
    private Gender gender;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
