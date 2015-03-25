package csmeditor;

import java.util.ArrayList;

public class Representative {

	private String name;
	private int afm;
	private ArrayList<Receipt> receiptList;
	
	public Representative() {
		receiptList = new ArrayList<Receipt>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAfm() {
		return afm;
	}
	public void setAfm(int afm) {
		this.afm = afm;
	}
	public ArrayList<Receipt> getReceiptList() {
		return receiptList;
	}
	public void setReceiptList(ArrayList<Receipt> receiptList) {
		this.receiptList = receiptList;
	}
	public void addReceipt(Receipt receipt){
		receiptList.add(receipt);
	}

}
