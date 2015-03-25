package csmeditor;

public class Receipt {

	private String kind;
	private int receiptId;
	private String date;
	private double sales;
	private int itemNumber;
	private Company company;

	public Receipt(){
		company = new Company();
	}

	public String getKind(){
		return kind;
	}
	public void setKind(String kind){
		this.kind = kind;
	}
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId){
		this.receiptId = receiptId;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

}
