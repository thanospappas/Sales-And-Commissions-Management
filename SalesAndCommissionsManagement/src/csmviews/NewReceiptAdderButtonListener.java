package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class NewReceiptAdderButtonListener implements ActionListener {

	private ControllView controllView;

	public NewReceiptAdderButtonListener(ControllView view) {
		controllView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = controllView.represantativeList.getSelectedIndex();
		if (row < 0) {
			JOptionPane.showMessageDialog(null,
					"Δεν έχει επιλέγει κανένας αντιπρόσωπος", "Σφάλμα",
					JOptionPane.WARNING_MESSAGE);
		} else {
			ReceiptAdderViews receiptAdder = new ReceiptAdderViews(
					controllView.representativeObjectList.get(row));
		}
	}
}
