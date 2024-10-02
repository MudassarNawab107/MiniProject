package com.nt.com.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CommonColumn {

	@Column(name = "lastupdated")
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "logged_by")
    private String loggedBy;

    @Column(name = "loggeddate")
    @Temporal(TemporalType.DATE)
    private Date  loggeddate ;
}
