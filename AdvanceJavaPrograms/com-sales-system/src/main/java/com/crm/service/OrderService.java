package com.crm.service;

import com.crm.entity.Customer;
import com.crm.entity.Order;
import com.crm.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    // ✅ Place Order
    public void placeOrder(Long customerId, List<Long> productIds) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            if (customer == null) {
                System.out.println("❌ Customer not found");
                tx.rollback();
                return;
            }

            List<Product> products = new ArrayList<>();
            double total = 0;

            for (Long pid : productIds) {
                Product p = em.find(Product.class, pid);
                if (p != null) {
                    products.add(p);
                    total += p.getPrice();
                }
            }

            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            order.setTotalAmount(total);
            order.setOrderDate(LocalDate.now());

            em.persist(order);

            tx.commit();
            System.out.println("✅ Order placed. Total = " + total);

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}