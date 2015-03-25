package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import csmeditor.Address;
import csmeditor.Company;
import csmeditor.Receipt;

public class UpdaterButtonListener implements ActionListener{
	private ReceiptUpdaterViews receiptView;
	public UpdaterButtonListener(ReceiptUpdaterViews view){
		receiptView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Receipt> receiptList = receiptView.selectedRepresentative.getReceiptList();
		for(Receipt receipt: receiptList){
			if(receipt == receiptView.selectedReceipt){
				updateFields(receiptList.indexOf(receipt),receiptList );
			}
		}
		showSuccessMessage();
	}
	
	private void updateFields(int index,ArrayList<Receipt> receiptList ){
		Receipt myReceipt = new Receipt();
		Company myCompany = new Company();
		Address myAddress = new Address();

		myReceipt.setReceiptId(Integer.parseInt(receiptView.receiptIdText.getText()));
		myReceipt.setDate(receiptView.dateText.getText());
		myReceipt.setKind(receiptView.kindText.getText());
		myReceipt.setSales(Double.parseDouble(receiptView.salesText.getText()));
		myReceipt.setItemNumber(Integer.parseInt(receiptView.itemText.getText()));
		myCompany.setName(receiptView.companyText.getText());
		myAddress.setCountry(receiptView.countryText.getText());
		myAddress.setCity(receiptView.cityText.getText());
		myAddress.setStreet(receiptView.addressText.getText());
		myAddress.setStreetNumber(receiptView.streetNumberText.getText());
		myCompany.setAddress(myAddress);
		myReceipt.setCompany(myCompany);
		int representativeIndex = receiptView.representativesList.indexOf(receiptView.selectedRepresentative);
		receiptList.set(index, myReceipt);
		
	}
	
	private void showSuccessMessage(){
		File currentDirFile = new File("");
		String helper = currentDirFile.getAbsolutePath();
		ImageIcon icon = new ImageIcon(helper + "\\src\\images\\tick.png");
			JOptionPane.showMessageDialog(null,"Η απόδειξη προστέθηκε επιτυχώς.",
			    "Επιτυχία",
			    JOptionPane.INFORMATION_MESSAGE,
			    icon);
	}

}
