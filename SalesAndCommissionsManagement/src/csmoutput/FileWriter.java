package csmoutput;

import java.util.ArrayList;

import csmeditor.Representative;

public abstract class FileWriter {
	
	public static final String NAME = "Name";
	public static final String AFM  = "AFM";
	public static final String RECEIPT_ID = "Receipt ID";
	public static final String DATE = "Date";
	public static final String KIND = "Kind";
	public static final String SALES = "Sales";
	public static final String ITEMS = "Items";
	public static final String COMPANY = "Company";
	public static final String COUNTRY = "Country";
	public static final String CITY = "City";
	public static final String STREET = "Street";
	public static final String NUMBER = "Number";

	protected ArrayList<Representative> representativesList;

	public abstract void writeFile(String path);

}
