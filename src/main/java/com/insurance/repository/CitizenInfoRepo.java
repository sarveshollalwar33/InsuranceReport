package com.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.entity.CitizenInfo;

public interface CitizenInfoRepo extends JpaRepository<CitizenInfo, Long> {
	
	@Query("select distinct c.planName from CitizenInfo c")
    public List<String> getPlanNames();

}
