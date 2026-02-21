package com.crm.main;

import com.crm.entity.Address;
import com.crm.service.*;
import com.crm.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.*;

public class CRMApplication {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== CRM MENU ===");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Add Product");
            System.out.println("6. Place Order");
            System.out.println("7. Raise Support Ticket");
            System.out.println("10. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Enter customer id: ");
                    Long cid = sc.nextLong();
                    sc.nextLine();

                    Address addr = new Address();

                    System.out.print("Street: ");
                    addr.setStreet(sc.nextLine());

                    System.out.print("City: ");
                    addr.setCity(sc.nextLine());

                    System.out.print("State: ");
                    addr.setState(sc.nextLine());

                    System.out.print("Zip: ");
                    addr.setZipCode(sc.nextLine());

                    customerService.addAddressToCustomer(cid, addr);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Lead name: ");
                    String lname = sc.nextLine();

                    System.out.print("Source: ");
                    String source = sc.nextLine();

                    System.out.print("Contact info: ");
                    String contact = sc.nextLine();

                    leadService.createLead(lname, source, contact);
                    break;

                case 4:
                    System.out.print("Lead id: ");
                    Long lid = sc.nextLong();

                    System.out.print("Employee id: ");
                    Long eid = sc.nextLong();

                    leadService.assignLeadToEmployee(lid, eid);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Product name: ");
                    String pname = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    productService.addProduct(pname, price);
                    break;

                case 6:
                    System.out.print("Customer id: ");
                    Long custId = sc.nextLong();

                    System.out.print("How many products: ");
                    int count = sc.nextInt();

                    List<Long> pids = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter product id: ");
                        pids.add(sc.nextLong());
                    }

                    orderService.placeOrder(custId, pids);
                    break;

                case 7:
                    System.out.print("Order id: ");
                    Long oid = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Issue description: ");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(oid, issue);
                    break;

                case 10:
                    em.close();
                    JPAUtil.close();
                    System.out.println("👋 Exiting CRM");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }
}