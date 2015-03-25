package csminput;

import java.util.ArrayList;

import csmeditor.Address;
import csmeditor.Company;
import csmeditor.Receipt;
import csmeditor.Representative;

public abstract class KindInputFactory {
	
	public abstract void setRepresentative(String[] splitedLine,Representative representative);
	public abstract void setReceipts();
	public abstract ArrayList<Receipt> getReceiptList();
	public abstract Receipt getReceipt();
	public abstract Company getCompany();
	public abstract Address getAddress();
	
}
