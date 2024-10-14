package com.insurance.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.insurance.entity.CitizenInfo;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PDF_UTIL {
	
	public boolean exportPdf(HttpServletResponse resp, List<CitizenInfo> records,File f) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, resp.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		
		Paragraph p = new Paragraph("Citizens Insurance Plans");
		Paragraph p2 = new Paragraph("                                                 ");
		document.add(p);
		document.add(p2);
		
		PdfPTable table = new PdfPTable(6);
		table.addCell("Citizen ID");
	    table.addCell("Citizen Name");
	    
	    table.addCell("Plan Name");
	    table.addCell("Plan Status");
	    table.addCell("Plan Start Date");
	    table.addCell("Plan End Date");
	   
		
	   
	    
	    
	    for(CitizenInfo c : records) {
	    	table.addCell(String.valueOf(c.getCitizenId()));
		    table.addCell(c.getCitizenName());
		    
		    table.addCell(c.getPlanName());
		    table.addCell(c.getPlanStatus());
		    table.addCell(c.getPlanStartDate()+"");
		    table.addCell(c.getPlanEndDate()+"");
		  
	    }
		
	    document.add(table);
		document.close();
		//testing commit track
		
		return true;
	}

}
