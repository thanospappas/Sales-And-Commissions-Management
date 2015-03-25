package csmoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import csmeditor.Receipt;
import csmeditor.Representative;

public class XmlWriter extends FileWriter {
	public static final String RECEIPTID = "ReceiptID";
	Representative selectedRepresentative;
	private PrintWriter pw;

	public XmlWriter(Representative chosenRepresentative) {
		this.selectedRepresentative = chosenRepresentative;
	}

	@Override
	public void writeFile(String path) {
		try {
			tryToWriteRepresentativeInfo(path);
			ArrayList<Receipt> receipts = selectedRepresentative
					.getReceiptList();
			writeReceiptsInfo(receipts);
			pw.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Το αρχείο '"
					+ "' δεν δημιουργήθηκε!!!", "Σφάλμα Δημιουργίας",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void tryToWriteRepresentativeInfo(String path) throws FileNotFoundException{
		pw = new PrintWriter(new File(path));
		pw.println("<" + NAME + "> " + selectedRepresentative.getName()
				+ "</" + NAME + ">");
		pw.println("<" + AFM + "> " + selectedRepresentative.getAfm()
				+ "</" + AFM + ">");
		pw.println("<Receipts>");
		
	}
	
	public void writeReceiptsInfo(ArrayList<Receipt> receipts) {
		for (Receipt receipt : receipts) {
			pw.println("<" + RECEIPTID + "> " + receipt.getReceiptId() + "</"
					+ RECEIPTID + ">");
			pw.println("<" + DATE + "> " + receipt.getDate() + "</" + DATE
					+ ">");
			pw.println("<" + KIND + "> " + receipt.getKind() + "</" + KIND
					+ ">");
			pw.println("<" + SALES + "> " + receipt.getSales() + "</" + SALES
					+ ">");
			pw.println("<" + ITEMS + "> " + receipt.getItemNumber() + "</"
					+ ITEMS + ">");
			pw.println("<" + COMPANY + "> " + receipt.getCompany().getName()
					+ "</" + COMPANY + ">");
			pw.println("<" + COUNTRY + "> "
					+ receipt.getCompany().getAddress().getCountry() + "</"
					+ COUNTRY + ">");
			pw.println("<" + CITY + "> "
					+ receipt.getCompany().getAddress().getCity() + "</" + CITY
					+ ">");
			pw.println("<" + STREET + "> "
					+ receipt.getCompany().getAddress().getStreet() + "</"
					+ STREET + ">");
			pw.println("<" + NUMBER + "> "
					+ receipt.getCompany().getAddress().getStreetNumber()
					+ "</" + NUMBER + ">");
			pw.println();
		}
	}

}
