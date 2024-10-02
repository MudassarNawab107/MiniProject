package com.nt.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.com.dto.DataDTO;
import com.nt.com.entity.PlanCategoryEntity;
import com.nt.com.entity.PlanEntity;
import com.nt.com.exception.ErrorException;
import com.nt.com.service.TravelPlanMamangementServie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	TravelPlanMamangementServie travelPlanMamangementServie;

	@PostMapping("/createplancategory")
	ResponseEntity<List<PlanCategoryEntity>> saveNewCategory(@RequestBody DataDTO dataDTO) throws ErrorException {

		List<PlanCategoryEntity> allCategories = travelPlanMamangementServie.saveTravellCategories(dataDTO);
		return ResponseEntity.ok(allCategories);
	}

	@GetMapping("/deletecategory")
	ResponseEntity<String> deleteCategory(@RequestParam Long id) throws ErrorException {

		Long deleteCategory = travelPlanMamangementServie.deleteCategory(id);
		return ResponseEntity.ok(deleteCategory + " Successfully deleted!!!");
	}

	@PutMapping("/deactivateplan")
	ResponseEntity<String> updateTravelPlanStatus(@RequestBody DataDTO dataDTO) throws ErrorException {

		PlanEntity deleteCategory = travelPlanMamangementServie.updateTravelPlanStatus(dataDTO.getPlanId(),
				dataDTO.getIsPlanActive());
		if (deleteCategory.getIsPlanActive() > 0) {
			return ResponseEntity.ok(deleteCategory.getPlanName() + " Successfully activated!!!");
		}
		return ResponseEntity.ok(deleteCategory.getPlanName() + " Successfully deactivated!!!");
	}

	@PostMapping("/creatTravelleplan")
	ResponseEntity<PlanEntity> createNewPlans(@RequestBody DataDTO dataDTO) throws ErrorException {
		log.error("came inside createNewPlans ");
		PlanEntity allCategories = travelPlanMamangementServie.saveTravellPlan(dataDTO);
		return ResponseEntity.ok(allCategories);
	}

	@GetMapping("/getAllTravelleplan")
	ResponseEntity<List<PlanEntity>> getTravelleplan() throws ErrorException {

		List<PlanEntity> allActivePlanRows = travelPlanMamangementServie.findAllPlans();
		return ResponseEntity.ok(allActivePlanRows);
	}

	@GetMapping("/getAllTravelleplanById/{id}")
	ResponseEntity<PlanEntity> getTravelleplanByPlanId(@PathVariable  Long id) throws ErrorException {
		PlanEntity allActivePlanRows = travelPlanMamangementServie.getAllTravelleplanById(id);
		return ResponseEntity.ok(allActivePlanRows);
	}

}
