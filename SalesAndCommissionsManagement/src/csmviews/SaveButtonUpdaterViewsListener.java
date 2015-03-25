package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import csmeditor.Representative;
import csminput.FilterChooser;
import csmoutput.FileWriter;
import csmoutput.SimpleWriter;
import csmoutput.XmlWriter;

public class SaveButtonUpdaterViewsListener implements ActionListener {
	private Representative selectedRepresentative;
	private String path;
	private FileWriter fileWriter;

	public SaveButtonUpdaterViewsListener(Representative chosenRepresentative) {
		selectedRepresentative = chosenRepresentative;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Custom button text
		Object[] options = { "Απλό αρχείο κειμένου", "XML", };
		int n = JOptionPane.showOptionDialog(null,
				"Επιλέξτε μορφή αρχείου αποθήκευσης ",
				"Επιλογή αρχείου Αποθήκευσης",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[1]);
		if (n == -1) {
			JOptionPane.showMessageDialog(null,
					"Δεν έχει επιλέγει μορφή αρχείου αποθήκευσης", "Σφάλμα",
					JOptionPane.WARNING_MESSAGE);
		} else {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FilterChooser());
			fileChooser.setDialogTitle("Αποθήκευση Αρχείου ");
			fileChooser.setSelectedFile(new File(Integer
					.toString(selectedRepresentative.getAfm())
					+ "_RECEIPTS"
					+ ".txt"));
			fileChooser.setAcceptAllFileFilterUsed(false);
			int retVal = fileChooser.showSaveDialog(null);
			if (retVal == JFileChooser.APPROVE_OPTION)
				path = fileChooser.getSelectedFile().getAbsolutePath();
			if (path != null && n == 0) {
				fileWriter = new SimpleWriter(selectedRepresentative);
				fileWriter.writeFile(path);
			} else if (path != null && n == 1) {
				fileWriter = new XmlWriter(selectedRepresentative);
				fileWriter.writeFile(path);
			} else {
				JOptionPane.showMessageDialog(null,
						"Δεν έχει επιλέγει τοποθεσία αποθήκευσης", "Σφάλμα",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
