package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import csmeditor.GeneralReportInfo;
import csminput.FilterChooser;
import csmoutput.GeneralInfoWriter;
import csmoutput.OutputFactory;
import csmoutput.SimpleGeneralInfoWriter;
import csmoutput.SimpleWriter;
import csmoutput.XmlGeneralInfoWriter;
import csmoutput.XmlWriter;

public class SaveGeneralReportListener implements ActionListener {
	private GeneralReportViews generalView;
	private GeneralInfoWriter generalInfoWriter;
	private GeneralReportInfo selectedInfo;
	private String path;
	
	public SaveGeneralReportListener(GeneralReportViews view) {
		generalView = view;
		selectedInfo = new GeneralReportInfo();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setAttributes();
		int answer = chooseSaveMode();
		if (answer == -1) {
			JOptionPane.showMessageDialog(null,
					"Δεν έχει επιλέγει μορφή αρχείου αποθήκευσης", "Σφάλμα",
					JOptionPane.WARNING_MESSAGE);
		} else {
			createChooser();
			saveFile(answer);
		}
	}

	private void setAttributes() {
		selectedInfo.setName(generalView.nameValue.getText());
		selectedInfo.setAfm(generalView.afmValue.getText());
		String value;
		if(!((value = generalView.firstValueLabel.getText()).isEmpty())){
			selectedInfo.setTotalSales(Double.parseDouble(value));
		}
		
		if(!((value = generalView.secondValueLabel.getText()).isEmpty())){
			selectedInfo.setTousersSales(Double
					.parseDouble(value));
		}
		if(!((value = generalView.thirdValueLabel.getText()).isEmpty())){
			selectedInfo.setSkirtsSales(Double
					.parseDouble(value));
		}
		if(!((value = generalView.fourthValueLabel.getText()).isEmpty())){
			selectedInfo.setShirtsSales(Double
					.parseDouble(value));
		}

		if(!((value = generalView.fifthValueLabel.getText()).isEmpty())){
			selectedInfo.setCoatsSales(Double
					.parseDouble(value));
		}
		if(!((value = generalView.sixthValueLabel.getText()).isEmpty())){
			selectedInfo.setCommissionSales(Double
					.parseDouble(value));
		}
	}
	
	private int chooseSaveMode(){
		Object[] options = { "Απλό αρχείο κειμένου", "XML", };
		return JOptionPane.showOptionDialog(null,
				"Επιλέξτε μορφή αρχείου αποθήκευσης ",
				"Επιλογή αρχείου Αποθήκευσης", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
	}
	
	public void createChooser(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FilterChooser());
		fileChooser.setDialogTitle("Αποθήκευση Αρχείου ");
		fileChooser.setSelectedFile(new File(Integer
				.toString(generalView.selectedRepresentative.getAfm())
				+ "_SALES"
				+ ".txt"));
		fileChooser.setAcceptAllFileFilterUsed(false);
		int retVal = fileChooser.showSaveDialog(null);
		if (retVal == JFileChooser.APPROVE_OPTION)
			path = fileChooser.getSelectedFile().getAbsolutePath();
	}
	
	public void saveFile(int answer){
		if (path != null && answer == 0) {
			generalInfoWriter = new SimpleGeneralInfoWriter(selectedInfo);
			generalInfoWriter.writeFile(path);
		} else if (path != null && answer == 1) {
			generalInfoWriter = new XmlGeneralInfoWriter(selectedInfo);
			generalInfoWriter.writeFile(path);
		} else {
			JOptionPane.showMessageDialog(null,"Δεν έχει επιλέγει τοποθεσία αποθήκευσης", "Σφάλμα",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
