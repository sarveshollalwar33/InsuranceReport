package com.insurance.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.binders.FormBinder;
import com.insurance.entity.CitizenInfo;
import com.insurance.repository.CitizenInfoRepo;
import com.insurance.utils.EXCEL_UTIL;
import com.insurance.utils.EmailUtil;
import com.insurance.utils.PDF_UTIL;
import com.insurance.utils.Search_Record;

@Service
public class CitizenInfoService implements CitizenInfoServiceInterface {

	@Autowired
	CitizenInfoRepo repo;
	@Autowired
	private EmailUtil emailUtil;
	@Autowired
	private EXCEL_UTIL excelUtil;
	@Autowired
	private PDF_UTIL pdfUtil;
	@Autowired
	private Search_Record searchRecord;
	
	@Override
	public List<CitizenInfo> searchRecord(FormBinder binder){
		List<CitizenInfo> list = searchRecord.searchRecord(binder);
		return list;
	}
	
	@Override
	public List<String> getPlanNames(){
		List<String> list = repo.getPlanNames();
		return list;
	}

	@Override
	public boolean exportExcel(HttpServletResponse resp) throws IOException, MessagingException {
		List<CitizenInfo> records = repo.findAll();
		File f = new File("ExcelReport.xls");
		excelUtil.exportExcel(resp,records, f);
		emailUtil.sendMail("Hii Shriyash", "<h1>SHIRIN</h1>", "hiteshmeshram1407@gmail.com",f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse resp) throws IOException, MessagingException {
		File f = new File("Insurance.pdf");
		 List<CitizenInfo> records = repo.findAll();
		 pdfUtil.exportPdf(resp,records,f);
		 emailUtil.sendMail("Hii Shriyash", "<h1>SHIRIN</h1>", "hiteshmeshram1407@gmail.com",f);
		 f.delete();
		 return true;
		
	}

}
