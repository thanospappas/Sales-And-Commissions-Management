package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import csmeditor.Representative;
import csminput.FilterChooser;
import csminput.SimpleParser;
import csmoutput.*;


public class SaveButtonListener implements ActionListener {
	ControllView controllView;


	public SaveButtonListener(ControllView view) {
		this.controllView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = controllView.represantativeList.getSelectedIndex();
		if (isRepresentativeSelected(row)) {
			Representative selectedRepresentative = controllView.representativeObjectList
					.get(row);
			ControllOutput outputControll = new ControllOutput(selectedRepresentative);
		} else {
			JOptionPane.showMessageDialog(null,
					"Δεν έχει επιλέγει κανένας αντιπρόσωπος","Σφάλμα",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private boolean isRepresentativeSelected(final int row) { 
		if (row < 0) {
			return false;
		}
		return true;
	}
	


}
