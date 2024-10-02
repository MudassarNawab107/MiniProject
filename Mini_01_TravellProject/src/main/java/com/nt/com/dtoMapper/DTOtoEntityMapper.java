package com.nt.com.dtoMapper;

import org.springframework.stereotype.Component;

import com.nt.com.dto.DataDTO;
import com.nt.com.entity.PlanEntity;

@Component
public class DTOtoEntityMapper {

	PlanEntity planEntity = new PlanEntity();

	public PlanEntity mapPlanDTOtoPlanEntity(DataDTO dataDTO) {
		planEntity.setPlanName(dataDTO.getPlanName());
		planEntity.setPlanDescription(dataDTO.getPlanDescription());
		planEntity.setPlanBudget(dataDTO.getPlanBudget());
		planEntity.setIsPlanActive(dataDTO.getIsPlanActive());
		planEntity.setRowState(dataDTO.getRowState());
		planEntity.setLoggedBy(dataDTO.getLoggedBy());
		planEntity.setLastUpdatedBy(dataDTO.getLastUpdatedBy());
		return planEntity;

	}

}
