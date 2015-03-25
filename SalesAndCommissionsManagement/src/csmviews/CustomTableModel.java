package csmviews;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import csmeditor.Receipt;
import csmeditor.Representative;

public class CustomTableModel extends DefaultTableModel{

	private static String[] columnNames = {"Κωδικός Απόδειξης", "Ημερομηνία", "Εταιρία", "Χώρα"};

	public CustomTableModel(){
		super(columnNames, 0);
	}

	public void addRows(ArrayList<Representative> representativeInfo,int row){

		for(Receipt receipt: representativeInfo.get(row).getReceiptList()){
			Vector<String> rows = new Vector<String>();
			rows.add(Integer.toString(receipt.getReceiptId()));
			rows.add(receipt.getDate());
			rows.add(receipt.getCompany().getName());
			rows.add(receipt.getCompany().getAddress().getCountry());
			addRow(rows);
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
