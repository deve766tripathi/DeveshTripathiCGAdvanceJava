package com.crm.service;

import com.crm.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    // ✅ Add Product
    public void addProduct(String name, double price) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);

            em.persist(product);

            tx.commit();
            System.out.println("✅ Product added");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}