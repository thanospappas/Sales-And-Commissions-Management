package csmoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import csmeditor.GeneralReportInfo;

public class XmlGeneralInfoWriter extends GeneralInfoWriter{

	private GeneralReportInfo generalInfo;
	private PrintWriter pw;

	public XmlGeneralInfoWriter(GeneralReportInfo genInfo){
		this.generalInfo = genInfo;
	}

	@Override
	public void writeFile(String path) {
		try {
			pw = new PrintWriter(new File(path));
			pw.println("<Name> " + generalInfo.getName() + "</Name>");
			pw.println("<AFM> " + generalInfo.getAfm() + "</AFM>");
			pw.println("<TotalSales> " + generalInfo.getTotalSales() + "</TotalSales>");
			pw.println("<TrousersSales>  " + generalInfo.getTousersSales() + "</TrousersSales>");
			pw.println("<SkirtsSales> " + generalInfo.getSkirtsSales() + "</SkirtsSales>");
			pw.println("<ShirtsSales> " + generalInfo.getShirtsSales() + "</ShirtsSales>" );
			pw.println("<CoatsSales> " + generalInfo.getCoatsSales() + "</CoatsSales>");
			pw.println("<Commission> " + generalInfo.getCommissionSales() + "</Commission>");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
