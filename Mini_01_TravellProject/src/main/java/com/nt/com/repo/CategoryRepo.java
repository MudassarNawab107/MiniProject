package com.nt.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.com.entity.PlanCategoryEntity;

import jakarta.transaction.Transactional;


public interface CategoryRepo extends JpaRepository<PlanCategoryEntity, Long> {
	
	PlanCategoryEntity findByCategoryName(String categoryName);
	
	@Modifying
    @Transactional
    @Query("UPDATE PlanCategoryEntity e SET e.rowState = -1 WHERE e.id = :id")
    void updateRowState(@Param("id") Long id);
	
	
	
	
}
