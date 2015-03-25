package csmoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import csmeditor.GeneralReportInfo;

public class SimpleGeneralInfoWriter extends GeneralInfoWriter{
	
	private GeneralReportInfo generalInfo;
	private PrintWriter pw;

	public SimpleGeneralInfoWriter(GeneralReportInfo genInfo){
		this.generalInfo = genInfo;

	}

	@Override
	public void writeFile(String path){
		try {
			pw = new PrintWriter(new File(path));
			pw.println("Name: " + generalInfo.getName());
			pw.println("AFM: " + generalInfo.getAfm());
			pw.println("Total Sales : " + generalInfo.getTotalSales());
			pw.println("Trousers Sales:  " + generalInfo.getTousersSales());
			pw.println("Skirts Sales: " + generalInfo.getSkirtsSales());
			pw.println("Shirts Sales: " + generalInfo.getShirtsSales());
			pw.println("Coats Sales: " + generalInfo.getCoatsSales());
			pw.println("Commission: " + generalInfo.getCommissionSales());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
