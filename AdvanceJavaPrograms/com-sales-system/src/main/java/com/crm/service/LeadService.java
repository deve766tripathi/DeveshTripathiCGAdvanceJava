package com.crm.service;

import com.crm.entity.Lead;
import com.crm.entity.SalesEmployee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em) {
        this.em = em;
    }

    // ✅ Create Lead
    public void createLead(String name, String source, String contactInfo) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Lead lead = new Lead();
            lead.setName(name);
            lead.setSource(source);
            lead.setContactInfo(contactInfo);

            em.persist(lead);

            tx.commit();
            System.out.println("✅ Lead created");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ Assign Lead to Employee
    public void assignLeadToEmployee(Long leadId, Long empId) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee emp = em.find(SalesEmployee.class, empId);

            if (lead != null && emp != null) {
                lead.setEmployee(emp);
                em.merge(lead);
                System.out.println("✅ Lead assigned to employee");
            } else {
                System.out.println("❌ Lead or Employee not found");
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}