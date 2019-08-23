package com.pecuniara.accounts.rest.controller;

import com.pecuniara.accounts.jpa.repository.PersistenceContext;
import com.pecuniara.accounts.rest.model.Receipt;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;


import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    //@PersistenceContext(unitName="receipts", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    public ReceiptController(){
        this.entityManager = PersistenceContext.getEm();

    }
    @RequestMapping(value = "/getReciepts", method = RequestMethod.GET)
    public List<Receipt> getReceipts(@RequestParam(name = "companyId") long companyId){
        var q = entityManager.createNamedQuery("receipts_by_company_id", Receipt.class);
        q.setParameter("companyId",companyId);
        var results = q.getResultList();
        return results;
    }
    @RequestMapping(value = "/addReceipt", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Receipt addReceipt(@RequestBody Receipt receipt){
        var tx = entityManager.getTransaction();
        tx.begin();
        try {
            entityManager.persist(receipt);
            tx.commit();
        }catch (Exception ex){
            tx.rollback();
        }
        return receipt;
    }
}
