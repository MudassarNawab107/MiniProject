package com.nt.com.service;

import java.util.List;

import com.nt.com.dto.DataDTO;
import com.nt.com.entity.PlanCategoryEntity;
import com.nt.com.entity.PlanEntity;
import com.nt.com.exception.ErrorException;

public interface TravelPlanMamangementServie {

	
	List<PlanCategoryEntity> saveTravellCategories(DataDTO dataDTO) throws ErrorException;
	Long deleteCategory(Long Id);
	PlanEntity updateTravelPlanStatus(Integer planId, Integer isPlanActive);
	PlanEntity saveTravellPlan(DataDTO dataDTO);
	List<PlanEntity> findAllPlans();
	PlanEntity getAllTravelleplanById(Long planId);
	
}