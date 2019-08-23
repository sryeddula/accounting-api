package com.pecuniara.accounts.rest.controller;

import com.pecuniara.accounts.jpa.Helper;
import com.pecuniara.accounts.rest.model.Company;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Company> search(@RequestParam(name = "q") String q){
        var query = Helper.entityManager.createNamedQuery("company_search_by_keyword", Company.class);
        return query.getResultList();
    }

}
