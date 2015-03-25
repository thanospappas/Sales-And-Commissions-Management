package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import csmeditor.GeneralInformationEditor;

public class TotalSalesCheckboxListener implements ActionListener{

	private GeneralReportViews generalView;

	public TotalSalesCheckboxListener(GeneralReportViews view){
		this.generalView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GeneralInformationEditor genInfo = new GeneralInformationEditor(generalView.selectedRepresentative);
		if(generalView.salesValuesCheckbox.isSelected()){
			generalView.firstNameLabel.setText("Σύνολο:");
			generalView.firstValueLabel.setText(Double.toString(genInfo.getTotalSales()));
		}
		else{
			generalView.firstNameLabel.setText("");
			generalView.firstValueLabel.setText("");
		}
	}

}
