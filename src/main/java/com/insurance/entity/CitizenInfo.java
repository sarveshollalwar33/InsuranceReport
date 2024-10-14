package com.insurance.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "citizen_info")
public class CitizenInfo {

	  @Id
	    @Column(name = "citizen_id")  // Correcting the field name
	    private Integer citizenId;

	    @Column(name = "benefit_amt")
	    private Double benefitAmount;

	    @Column(name = "citizen_name")
	    private String citizenName;

	    @Column(name = "denial_reason")
	    private String denialReason;

	    @Column(name = "gender")
	    private String gender;

	    @Column(name = "plan_end_date")
	    private LocalDate planEndDate;

	    @Column(name = "plan_name")
	    private String planName;

	    @Column(name = "plan_start_date")
	    private LocalDate planStartDate;

	    @Column(name = "plan_status")
	    private String planStatus;

	    @Column(name = "terminated_date")
	    private LocalDate terminatedDate;

	    @Column(name = "termination_rsn")
	    private String terminationReason;
}
