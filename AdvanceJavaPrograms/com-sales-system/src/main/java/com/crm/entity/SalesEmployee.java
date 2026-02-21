package com.crm.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class SalesEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "employee")
    private List<Lead> leads = new ArrayList<>();
}