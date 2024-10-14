package com.insurance.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.insurance.binders.FormBinder;
import com.insurance.entity.CitizenInfo;
import com.insurance.repository.CitizenInfoRepo;

@Component
public class Search_Record {
	
	@Autowired
	private CitizenInfoRepo repo;
	
	public List<CitizenInfo> searchRecord(FormBinder binder) {
		CitizenInfo entity = new CitizenInfo();
		if (binder.getPlanName() != null && !binder.getPlanName().isEmpty()) {
		    entity.setPlanName(binder.getPlanName());
		}

		if (binder.getPlanStatus() != null && !binder.getPlanStatus().isEmpty()) {
		    entity.setPlanStatus(binder.getPlanStatus());
		}

		if (binder.getGender() != null && !binder.getGender().isEmpty()) {
		    entity.setGender(binder.getGender());
		}

		if (binder.getStartDate() != null && binder.getStartDate() != "") {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(binder.getStartDate(), formatter);
		    entity.setPlanStartDate(date);
		}

		if (binder.getEndDate() != null && binder.getEndDate() != "") {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(binder.getEndDate(), formatter);
		    entity.setPlanEndDate(date);
		   
		}

		
		Example<CitizenInfo> eg = Example.of(entity);
		return repo.findAll(eg);
		
	}

}
