package csminput;

import java.util.ArrayList;

import csmeditor.Address;
import csmeditor.Company;
import csmeditor.Receipt;
import csmeditor.Representative;

public class KindSimpleInputFactory extends KindInputFactory {
	private Receipt myReceipt;
	private Company myCompany;
	private Address myAddress;
	private ArrayList<Receipt> receiptList;
	
	public KindSimpleInputFactory(){
		myReceipt = new Receipt();
		myCompany = new Company();
		myAddress = new Address();
		receiptList = new ArrayList<Receipt>();
	}
	
	public void setRepresentative(String[] splitedLine,Representative representative){
		
		switch (splitedLine[0]) {
		case KindInput.NAME:
			representative.setName(splitedLine[1]);
			break;
		case KindInput.AFM:
			representative.setAfm(Integer.parseInt(splitedLine[1].replaceAll(
					"\\s+", "")));
			break;
		case KindInput.RECEIPT_ID:
			myReceipt.setReceiptId(Integer.parseInt(splitedLine[1].replaceAll(
					"\\s+", "")));
		case KindInput.DATE:
			myReceipt.setDate(splitedLine[1]);
			break;
		case KindInput.KIND:
			myReceipt.setKind(splitedLine[1].replaceAll("\\s+", ""));
			break;
		case KindInput.SALES:
			myReceipt.setSales(Double.parseDouble(splitedLine[1].replaceAll(
					"\\s+", "")));
			break;
		case KindInput.ITEMS:
			myReceipt.setItemNumber(Integer.parseInt(splitedLine[1].replaceAll(
					"\\s+", "")));
			break;
		case KindInput.COMPANY:
			myCompany.setName(splitedLine[1]);
			break;
		case KindInput.COUNTRY:
			myAddress.setCountry(splitedLine[1]);
			break;
		case KindInput.CITY:
			myAddress.setCity(splitedLine[1]);
			break;
		case KindInput.STREET:
			myAddress.setStreet(splitedLine[1]);
			break;
		case KindInput.NUMBER:
			myAddress.setStreetNumber(splitedLine[1].replaceAll("\\s+", ""));
			break;
		}
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