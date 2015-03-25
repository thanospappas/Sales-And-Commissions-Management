package csmviews;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import csmeditor.Representative;

public class MouseListClicked implements MouseListener {

	private ControllView controllView;
	public MouseListClicked(ControllView view){
		controllView = view;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row = controllView.represantativeList.getSelectedIndex();
		Representative tempRepresentative = controllView.representativeObjectList.get(row);
		controllView.nameValue.setText(tempRepresentative.getName());
		controllView.afmValue.setText(Integer.toString(tempRepresentative.getAfm()));
		updateTable(row);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
	public void updateTable(int row){
		CustomTableModel methodsTableModel = new CustomTableModel();
		methodsTableModel.addRows(controllView.representativeObjectList,row);
	    controllView.receiptInfoTable.setModel(methodsTableModel);
	}
}
