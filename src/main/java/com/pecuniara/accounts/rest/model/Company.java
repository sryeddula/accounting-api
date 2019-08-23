package com.pecuniara.accounts.rest.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "company")
@NamedQuery(query = "select c from Company c where c.name like  '%:companyId%'", name = "company_search_by_keyword")
public class Company {
    @Id
    @GeneratedValue
    @ApiModelProperty(hidden=true)
    @Column(nullable = false)
    private long id;
    private long companyNumber;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(long companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
