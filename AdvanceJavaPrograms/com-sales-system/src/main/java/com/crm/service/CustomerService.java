package com.crm.service;

import com.crm.entity.Customer;
import com.crm.entity.Address;
import jakarta.persistence.*;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public void registerCustomer(String name, String email, String phone) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer c = new Customer();
            c.setName(name);
            c.setEmail(email);
            c.setPhone(phone);

            em.persist(c);

            tx.commit();
            System.out.println("Customer Registered!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
    public void addAddressToCustomer(Long customerId, Address address) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            if (customer != null) {
                customer.setAddress(address);
                em.merge(customer);
                System.out.println("✅ Address added to customer");
            } else {
                System.out.println("❌ Customer not found");
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}