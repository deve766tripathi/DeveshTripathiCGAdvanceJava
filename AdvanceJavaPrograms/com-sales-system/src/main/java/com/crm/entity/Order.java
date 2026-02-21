package com.crm.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private double totalAmount;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products = new ArrayList<>();
}