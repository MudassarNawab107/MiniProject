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
@Table(name = "01_mini_plans")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@SQLRestriction("rowstate >-1")
public class PlanEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long planId;

    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(name = "plan_description")
    private String planDescription;

    @Column(name = "plan_category_id")
    private Long planCategoryId;

    @Column(name = "plan_budget")
    private Float planBudget;

    @Column(name = "is_plan_active")
    private Integer isPlanActive;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "logged_by")
    private String loggedBy;

    @Column(name = "rowstate")
    private Integer rowState;
   
}