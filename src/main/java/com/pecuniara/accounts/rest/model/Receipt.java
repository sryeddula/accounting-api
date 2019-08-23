package com.pecuniara.accounts.rest.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "receipt")
@NamedQuery(query = "select r from Receipt r where r.companyId = :companyId", name = "receipts_by_company_id")
public class Receipt {
    @Id
    @GeneratedValue
    @ApiModelProperty(hidden=true)
    @Column(nullable = false)
    private long id;
    @ApiModelProperty(example = "2019-01-01")
    private Date date;
    private String type;
    private String description;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Double vat;
    @Column(nullable = false)
    private Double total;
    private long companyId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}
