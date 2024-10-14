package com.insurance.binders;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FormBinder {

	private String planName;
    private String planStatus;
    private String gender;
   
    private String startDate;
    
    private String endDate;
	
	
}
