package com.insurance.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import com.insurance.binders.FormBinder;
import com.insurance.entity.CitizenInfo;

public interface CitizenInfoServiceInterface {

	public List<CitizenInfo> searchRecord(FormBinder binder);
	public List<String> getPlanNames();
	public boolean exportExcel(HttpServletResponse resp) throws IOException, MessagingException;
	public boolean exportPdf(HttpServletResponse resp) throws IOException, MessagingException;
	
	
}
