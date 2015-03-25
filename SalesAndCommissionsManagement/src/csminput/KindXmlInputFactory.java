package csminput;

import java.util.ArrayList;

import csmeditor.Address;
import csmeditor.Company;
import csmeditor.Receipt;
import csmeditor.Representative;

public class KindXmlInputFactory extends KindInputFactory{
	private Receipt myReceipt;
	private Company myCompany;
	private Address myAddress;
	private ArrayList<Receipt> receiptList;
	
	public KindXmlInputFactory(){
		myReceipt = new Receipt();
		myCompany = new Company();
		myAddress = new Address();
		receiptList = new ArrayList<Receipt>();
	}
public void setRepresentative(String[] splitedLine,Representative representative){
		
		switch (splitedLine[0]) {
		case "<" + KindInput.NAME:
			splitedLine[1] = replaceTag(KindInput.NAME, splitedLine[1]);
			representative.setName(splitedLine[1]);
			break;
		case "<" + KindInput.AFM:
			splitedLine[1] = replaceTag(KindInput.AFM, splitedLine[1]);
			representative.setAfm(Integer.parseInt(splitedLine[1].replaceAll(
					"\\s+", "")));
			break;
		case "<" + KindInput.RECEIPTID:
			splitedLine[1] = replaceTag(KindInput.RECEIPTID, splitedLine[1]);
			myReceipt.setReceiptId(Integer.parseInt(splitedLine[1].replaceAll(
					"\\s+", "")));
		case "<" + KindInput.DATE:
			splitedLine[1] = replaceTag(KindInput.DATE, splitedLine[1]);
			myReceipt.setDate(splitedLine[1]);
			break;
		case "<" + KindInput.KIND:
			splitedLine[1] = replaceTag(KindInput.KIND, splitedLine[1]);
			myReceipt.setKind(splitedLine[1].replaceAll("\\s+", ""));
			break;
		case "<" + KindInput.SALES:
			splitedLine[1] = replaceTag(KindInput.SALES, splitedLine[1]);
			myReceipt.setSales(Double.parseDouble(splitedLine[1].replaceAll(
					"\\s+", "")));
			break;
		case "<" + KindInput.ITEMS:
			splitedLine[1] = replaceTag(KindInput.ITEMS, splitedLine[1]);
			myReceipt.setItemNumber(Integer.parseInt(splitedLine[1].replaceAll(
					"\\s+", "")));
			break;
		case "<" + KindInput.COMPANY:
			splitedLine[1] = replaceTag(KindInput.COMPANY, splitedLine[1]);
			myCompany.setName(splitedLine[1]);
			break;
		case "<" + KindInput.COUNTRY:
			splitedLine[1] = replaceTag(KindInput.COUNTRY, splitedLine[1]);
			myAddress.setCountry(splitedLine[1]);
			break;
		case "<" + KindInput.CITY:
			splitedLine[1] = replaceTag(KindInput.CITY, splitedLine[1]);
			myAddress.setCity(splitedLine[1]);
			break;
		case "<" + KindInput.STREET:
			splitedLine[1] = replaceTag(KindInput.STREET, splitedLine[1]);
			myAddress.setStreet(splitedLine[1]);
			break;
		case "<" + KindInput.NUMBER:
			splitedLine[1] = replaceTag(KindInput.NUMBER, splitedLine[1]);
			myAddress.setStreetNumber(splitedLine[1].replaceAll("\\s+", ""));
			break;
		}
	}
	
	private String replaceTag(String tag, String text) {
		text = text.replaceAll("</" + tag, "");
		return text;
	}
	
	public void setReceipts(){
		myCompany.setAddress(myAddress);
		myReceipt.setCompany(myCompany);
		receiptList.add(myReceipt);	
	}

	public ArrayList<Receipt> getReceiptList(){
		return receiptList;
	}
	
	public Receipt getReceipt(){
		return myReceipt;
	}
	
	public Company getCompany(){
		return myCompany;
	}
	public Address getAddress(){
		return myAddress;
	}
	
}
