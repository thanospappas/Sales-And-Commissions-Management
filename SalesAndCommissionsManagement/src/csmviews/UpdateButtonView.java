package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

import csmeditor.Receipt;
import csmeditor.Representative;

public class UpdateButtonView implements ActionListener {
	private ControllView controllView;

	public UpdateButtonView(ControllView view) {
		this.controllView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int row = controllView.receiptInfoTable.getSelectedRow();
		int representativeRow = controllView.represantativeList
				.getSelectedIndex();
		if (representativeRow < 0) {
			JOptionPane.showMessageDialog(null,
					"Δεν έχει επιλέγει αντιπρόσωπος", "Σφάλμα",
					JOptionPane.WARNING_MESSAGE);
		} else if (row < 0) {
			JOptionPane.showMessageDialog(null,
					"Δεν έχει επιλέγει απόδειξη", "Σφάλμα",
					JOptionPane.WARNING_MESSAGE);
		} else {
			Representative selectedRepresentative = controllView.representativeObjectList
					.get(representativeRow);

			String selectedReceiptId = (String) controllView.receiptInfoTable
					.getValueAt(row, 0);
			String selectedDate = (String) controllView.receiptInfoTable
					.getValueAt(row, 1);
			String selectedCompany = (String) controllView.receiptInfoTable
					.getValueAt(row, 2);

			for (Receipt receipt : selectedRepresentative.getReceiptList()) {
				if (Integer.toString(receipt.getReceiptId()).equals(
						selectedReceiptId)
						&& receipt.getDate().equals(selectedDate)
						&& receipt.getCompany().getName()
								.equals(selectedCompany)) {
					ReceiptUpdaterViews receiptUpdater = new ReceiptUpdaterViews(
							receipt, selectedRepresentative,
							controllView.representativeObjectList);
				}
			}
		}

	}

}
