package com.crm.service;

import com.crm.entity.Order;
import com.crm.entity.SupportTicket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    // ✅ Raise Ticket
    public void raiseTicket(Long orderId, String issueDescription) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Order order = em.find(Order.class, orderId);

            if (order != null) {

                SupportTicket ticket = new SupportTicket();
                ticket.setOrder(order);
                ticket.setIssueDescription(issueDescription);

                em.persist(ticket);

                tx.commit();
                System.out.println("✅ Support ticket raised");

            } else {
                System.out.println("❌ Order not found");
            }

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}