package csmoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import csmeditor.Receipt;
import csmeditor.Representative;
import csmviews.ControllView;

public class SimpleWriter extends FileWriter{

	private Representative selectedRepresentative;
	private PrintWriter pw;
	
	public SimpleWriter(Representative chosenRepresentative){
		this.selectedRepresentative = chosenRepresentative;
	}
	@Override
	public void writeFile(String path) {
		try {
			tryToWriteRepresentativeInfo(path);
			ArrayList<Receipt> receipts = selectedRepresentative.getReceiptList();
			writeReceiptsInfo(receipts);
			pw.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Το αρχείο '" + "' δεν δημιουργήθηκε!!!","Σφάλμα Δημιουργίας",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void tryToWriteRepresentativeInfo(String path) throws FileNotFoundException{
		pw = new PrintWriter(new File(path));
		pw.println(NAME + ": " + selectedRepresentative.getName());		
		pw.println(AFM + ": " + selectedRepresentative.getAfm());
		pw.println("Receipts:");
	}
	
	public void writeReceiptsInfo(ArrayList<Receipt> receipts){
		for(Receipt receipt: receipts){
			pw.println(RECEIPT_ID + ": " + receipt.getReceiptId());
			pw.println(DATE + ": " + receipt.getDate());
			pw.println(KIND + ": " + receipt.getKind());
			pw.println(SALES + ": " + receipt.getSales());
			pw.println(ITEMS + ": " + receipt.getItemNumber());
			pw.println(COMPANY + ": " + receipt.getCompany().getName());
			pw.println(COUNTRY + ": " + receipt.getCompany().getAddress().getCountry());
			pw.println(CITY + ": " + receipt.getCompany().getAddress().getCity());
			pw.println(STREET + ": " + receipt.getCompany().getAddress().getStreet());
			pw.println(NUMBER + ": " + receipt.getCompany().getAddress().getStreetNumber());
			pw.println();
		}
	}
}
