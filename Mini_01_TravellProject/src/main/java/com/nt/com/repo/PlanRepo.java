package com.nt.com.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.com.entity.PlanEntity;

import jakarta.transaction.Transactional;

public interface PlanRepo extends JpaRepository<PlanEntity, Long>  {

	@Modifying
    @Transactional
    @Query("UPDATE PlanEntity e SET e.isPlanActive = :status WHERE e.planId = :id")
    void updatePlanStatus(@Param("id") Integer id ,@Param("status") Integer status  );

	Optional<PlanEntity> findByplanId(Long planId);
	
}
