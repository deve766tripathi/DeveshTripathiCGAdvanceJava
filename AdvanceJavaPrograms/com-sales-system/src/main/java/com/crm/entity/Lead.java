package com.crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long id;

    private String name;
    private String source;
    private String contactInfo;

    @ManyToOne
    private SalesEmployee employee;
}