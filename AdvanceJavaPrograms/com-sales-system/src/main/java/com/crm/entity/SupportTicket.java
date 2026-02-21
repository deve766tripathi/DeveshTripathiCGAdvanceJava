package com.crm.entity;

import jakarta.persistence.*;

@Entity
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueDescription;

    @OneToOne
    private Order order;
    public void setOrder(Order order) { this.order = order; }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }
}