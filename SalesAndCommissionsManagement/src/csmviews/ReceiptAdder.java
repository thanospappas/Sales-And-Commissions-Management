package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import csmeditor.Address;
import csmeditor.Company;
import csmeditor.Receipt;
import csmeditor.Representative;

public class ReceiptAdder implements ActionListener {

	private ReceiptAdderViews receiptAdderView;

	public ReceiptAdder(ReceiptAdderViews view) {

		receiptAdderView = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (isEmptyField()) {
			Receipt myReceipt = new Receipt();
			Company myCompany = new Company();
			Address myAddress = new Address();
			addReceipt(myReceipt);
			addCompany(myCompany);
			addAddress(myCompany, myAddress);
			myReceipt.setCompany(myCompany);
			addToRepresentativeList(myReceipt);
		}

	}

	private boolean isEmptyField() {
		if (receiptAdderView.receiptIdText.getText().equals("")
				|| receiptAdderView.dateText.getText().equals("")
				|| receiptAdderView.kindText.getText().equals("")
				|| receiptAdderView.salesText.getText().equals("")
				|| receiptAdderView.itemsText.getText().equals("")
				|| receiptAdderView.companyText.getText().equals("")
				|| receiptAdderView.cityText.getText().equals("")
				|| receiptAdderView.countryText.getText().equals("")
				|| receiptAdderView.streetText.getText().equals("")
				|| receiptAdderView.streetText.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Πρεπει να συμπληρωθούν όλα τα πεδία", "Σφάλμα",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private void addReceipt(Receipt myReceipt) {
		if(isNumber(receiptAdderView.receiptIdText.getText()))
			myReceipt.setReceiptId(Integer.parseInt(receiptAdderView.receiptIdText
				.getText()));
		else
			printIdWarning();
		myReceipt.setDate(receiptAdderView.dateText.getText());
		myReceipt.setKind(receiptAdderView.kindText.getText());
		myReceipt.setSales(Double.parseDouble(receiptAdderView.salesText.getText()));
		if(isNumber(receiptAdderView.itemsText
				.getText()))
			myReceipt.setItemNumber(Integer.parseInt(receiptAdderView.itemsText
					.getText()));
		else
			printItemNumberWarning();
	}
	
	private boolean isNumber(String number){
		try { 
	        Integer.parseInt(number); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
	
	private void printIdWarning(){
		JOptionPane.showMessageDialog(null,
				"Το Id πρέπει αν είναι ακέραιος", "Σφάλμα",
				JOptionPane.WARNING_MESSAGE);
	}
	
	private void printItemNumberWarning(){
		JOptionPane.showMessageDialog(null,
				"Ο αριθμός των τεμαχίων πρέπει να είναι ακέραιος", "Σφάλμα",
				JOptionPane.WARNING_MESSAGE);
	}
	
	private void addCompany(Company myCompany) {
		myCompany.setName(receiptAdderView.companyText.getText());
	}

	private void addAddress(Company myCompany, Address myAddress) {
		myAddress.setCity(receiptAdderView.cityText.getText());
		myAddress.setCountry(receiptAdderView.countryText.getText());
		myAddress.setStreet(receiptAdderView.streetText.getText());
		myAddress.setStreetNumber(receiptAdderView.numberStreetText.getText());
		myCompany.setAddress(myAddress);
	}

	private void addToRepresentativeList(Receipt myReceipt) {
		try {
			receiptAdderView.selectedRepresentative.addReceipt(myReceipt);
			ImageIcon icon = new ImageIcon("images\\tick.png");
			JOptionPane.showMessageDialog(null,
			    "Η απόδειξη προστέθηκε επιτυχώς.",
			    "Επιτυχία",
			    JOptionPane.INFORMATION_MESSAGE,
			    icon);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Η απόδειξη δεν προστέθηκε",
					"Σφάλμα", JOptionPane.WARNING_MESSAGE);
		}
	}

}
