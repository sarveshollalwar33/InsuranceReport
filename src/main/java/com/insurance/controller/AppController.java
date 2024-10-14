package com.insurance.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.insurance.binders.FormBinder;
import com.insurance.entity.CitizenInfo;
import com.insurance.service.CitizenInfoService;

@Controller
public class AppController {

	@Autowired
	private CitizenInfoService service;
	
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse resp) throws IOException, MessagingException {
		resp.setContentType("application/pdf");
		resp.addHeader("Content-Disposition", "attachment;filename=InsuranceReport.pdf");
		service.exportPdf(resp);
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse resp) throws IOException, MessagingException {
		resp.setContentType("application/octet-stream");
		resp.addHeader("Content-Disposition", "attachment;filename=InsuranceReport.xls");
		service.exportExcel(resp);
	}
	
	@GetMapping("/")
	public String welcomePage(Model model) {
		List<String> names = service.getPlanNames();
		model.addAttribute("planNames", names);
		 model.addAttribute("formBinder", new FormBinder());
		 
		return "index";
	}
	 
	@PostMapping("/search")
	public String searchRecords(FormBinder formBinder, Model model ) {
		 System.out.println(formBinder);
		 List<CitizenInfo> formResult = service.searchRecord(formBinder);
		 System.out.println(formResult);
		 model.addAttribute("formResult", formResult);
		 List<String> names = service.getPlanNames();
		 model.addAttribute("planNames", names);
		    return "index";
	}
	
}
