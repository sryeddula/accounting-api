package com.pecuniara.accounts.rest.model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @ApiModelProperty(hidden=true)
    @Column(nullable=false)
    @GeneratedValue
    private long id;
    //@Column(name = "name", nullable = false)
    private  String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //@Column(name = "content")
    private  String content;

}
