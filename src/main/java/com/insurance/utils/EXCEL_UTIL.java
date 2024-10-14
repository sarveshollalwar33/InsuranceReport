package com.insurance.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.insurance.entity.CitizenInfo;

@Component
public class EXCEL_UTIL {

	public boolean exportExcel(HttpServletResponse resp, List<CitizenInfo> records, File f) throws IOException {
		//hssf will work with xls file extension
				//Xssf will work with xlxs extension
				Workbook workbook = new HSSFWorkbook();
				Sheet sheet = workbook.createSheet();
				Row headerRow = sheet.createRow(0);
				//Set HEader row column names:
				
				headerRow.createCell(0).setCellValue("Citizen ID");
			    headerRow.createCell(1).setCellValue("Citizen Name");
			    headerRow.createCell(2).setCellValue("Gender");
			    headerRow.createCell(3).setCellValue("Plan Name");
			    headerRow.createCell(4).setCellValue("Plan Status");
			    headerRow.createCell(5).setCellValue("Plan Start Date");
			    headerRow.createCell(6).setCellValue("Plan End Date");
			    headerRow.createCell(7).setCellValue("Benefit Amount");
			    headerRow.createCell(8).setCellValue("Denial Reason");
			    
			    
			    
			    int dataRowIndex = 1;
			    for(CitizenInfo c : records) {
			    	Row row = sheet.createRow(dataRowIndex);
			    	row.createCell(0).setCellValue(c.getCitizenId());
				    row.createCell(1).setCellValue(c.getCitizenName());
				    row.createCell(2).setCellValue(c.getGender());
				    row.createCell(3).setCellValue(c.getPlanName());
				    row.createCell(4).setCellValue(c.getPlanStatus());
				    if(null!=c.getPlanStartDate()) {
				    row.createCell(5).setCellValue(c.getPlanStartDate());
				    }else {
				    row.createCell(5).setCellValue("NA");	
				    }
				    if(null!=c.getPlanEndDate()) {
				    row.createCell(6).setCellValue(c.getPlanEndDate());
				    }else {
				    row.createCell(6).setCellValue("NA");
				    }
				    if(null!= c.getBenefitAmount()) {
				    	row.createCell(7).setCellValue(c.getBenefitAmount());
				    }else {
				        row.createCell(7).setCellValue("NA");
				    }
				    row.createCell(8).setCellValue(c.getDenialReason());
			    	dataRowIndex++;	
			    }
			    
			    FileOutputStream fos = new FileOutputStream("InsuranceReport.xls");
				workbook.write(fos);
				//workbook.close();
				workbook.write(resp.getOutputStream());
				
				
				FileOutputStream fos2 = new FileOutputStream(f);
				workbook.write(fos2);
                fos2.close();
				workbook.close();
				return true;
	}
}
