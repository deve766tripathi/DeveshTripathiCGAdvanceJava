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
    public void setCustomer(Customer customer) { this.customer = customer; }

    public void setProducts(List<Product> products) { this.products = products; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
}