package com.crm.main;

import com.crm.service.CustomerService;
import com.crm.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.Scanner;

public class CRMApplication {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        CustomerService customerService = new CustomerService(em);
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== CRM MENU ===");
            System.out.println("1. Register Customer");
            System.out.println("10. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    customerService.registerCustomer(
                            "John Doe",
                            "john@gmail.com",
                            "9999999999");
                    break;

                case 10:
                    em.close();
                    JPAUtil.close();
                    System.exit(0);
            }
        }
    }
}