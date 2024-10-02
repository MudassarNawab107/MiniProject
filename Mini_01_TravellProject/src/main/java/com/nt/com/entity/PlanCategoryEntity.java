package com.nt.com.entity;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "01_mini_category_master")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 

@SQLRestriction("rowstate >-1")
public class PlanCategoryEntity   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;
    
    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "logged_by")
    private String loggedBy;

    @Column(name = "rowstate")
    private Integer rowState;
   
}