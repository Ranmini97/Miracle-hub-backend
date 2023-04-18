package com.backend.miracle_hub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @Column(name = "supID", columnDefinition = "VARCHAR(30)", nullable = false)
    private String id;

    @Column(name = "supName", columnDefinition = "VARCHAR(40)", nullable = false)
    private String name;

    @Column(name = "company", columnDefinition = "VARCHAR(40)", nullable = false)
    private String company;

    @Column(name = "supContact", columnDefinition = "INT", nullable = false)
    private int contact;


}