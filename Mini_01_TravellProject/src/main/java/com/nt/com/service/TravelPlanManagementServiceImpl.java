package com.nt.com.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.com.controller.CategoryController;
import com.nt.com.dto.DataDTO;
import com.nt.com.dtoMapper.DTOtoEntityMapper;
import com.nt.com.entity.PlanCategoryEntity;
import com.nt.com.entity.PlanEntity;
import com.nt.com.exception.ErrorException;
import com.nt.com.exception.UnknownPlanError;
import com.nt.com.repo.CategoryRepo;
import com.nt.com.repo.PlanRepo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TravelPlanManagementServiceImpl implements TravelPlanMamangementServie {

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	PlanRepo planRepo;

	@Autowired
	DTOtoEntityMapper dtotoEntityMapper;

	@Override
	@SneakyThrows
	public List<PlanCategoryEntity> saveTravellCategories(DataDTO dataDTO) throws ErrorException {

		PlanCategoryEntity isCategoryAlreadyPresent = categoryRepo.findByCategoryName(dataDTO.getCategoryName());
		if (isCategoryAlreadyPresent != null) {
			throw new ErrorException("CategoryName Already Existing the DB");

		}
		List<PlanCategoryEntity> result = Collections.emptyList();

		PlanCategoryEntity planCategory = new PlanCategoryEntity();
		planCategory.setCategoryName(dataDTO.getCategoryName());
		planCategory.setLoggedBy(dataDTO.getLoggedBy());
		planCategory.setLastUpdatedBy(dataDTO.getLastUpdatedBy());
		planCategory.setRowState(dataDTO.getRowState());
		PlanCategoryEntity savedCategory = categoryRepo.save(planCategory);
		if (savedCategory != null) {
			result = categoryRepo.findAll();
		}
		return result;
	}

	@Override
	@SneakyThrows
	public Long deleteCategory(Long Id) {
		categoryRepo.updateRowState(Id);
		Optional<PlanCategoryEntity> planCategoryEntity = categoryRepo.findById(Id);
		if (planCategoryEntity.isPresent()) {
			throw new ErrorException("Unable to delete the the data");
		}

		return Id;
	}

	@Override
	@SneakyThrows
	public PlanEntity updateTravelPlanStatus(Integer planId, Integer planStatus) {
		PlanEntity entityRow = new PlanEntity();
		planRepo.updatePlanStatus(planId, planStatus);
		Optional<PlanEntity> updatedPlanRow = planRepo.findById(Long.parseLong(planId.toString()));
		if (updatedPlanRow.isPresent()) {
			entityRow = updatedPlanRow.get();
		} else {
			throw new UnknownPlanError("Plan Plan with does Not Id exists");
		}
		return entityRow;
	}

	@Override
	@SneakyThrows
	public PlanEntity saveTravellPlan(DataDTO dataDTO) {
		log.error("The Plan Name is{}",dataDTO.getPlanName());
		PlanCategoryEntity rowData = categoryRepo.findByCategoryName(dataDTO.getPlanName());
		if (rowData == null) {
			throw new ErrorException("No Plan Found in DB");
		}
		PlanEntity entityRow = dtotoEntityMapper.mapPlanDTOtoPlanEntity(dataDTO);
		entityRow.setPlanCategoryId(rowData.getId());
		PlanEntity savedRow = planRepo.save(entityRow);
		return savedRow;
	}

	@Override
	public List<PlanEntity> findAllPlans() {
		return planRepo.findAll();
	}

	@Override
	@SneakyThrows
	public PlanEntity getAllTravelleplanById(Long planId) {
		Optional<PlanEntity> planRow = planRepo.findByplanId(planId);
		if(planRow.isPresent())
		{
			return planRow.get();
		}
		return null;
	}
}
