package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import csmeditor.Receipt;
import csmeditor.Representative;

public class GeneralInfoButtonListener  implements ActionListener{
	private ControllView controllView;
	
	public GeneralInfoButtonListener(ControllView view){
		controllView = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = controllView.represantativeList.getSelectedIndex();
		if(row < 0){
			JOptionPane.showMessageDialog(null, "Δεν έχει επιλέγει κανένας αντιπρόσωπος","Σφάλμα",JOptionPane.WARNING_MESSAGE);
		}
		else{
			Representative selectedRepresentative = controllView.representativeObjectList.get(row);
			for(Receipt receipt: selectedRepresentative.getReceiptList()){
			}
			GeneralReportViews generalReportView = new GeneralReportViews(selectedRepresentative);
		}
	}

}
