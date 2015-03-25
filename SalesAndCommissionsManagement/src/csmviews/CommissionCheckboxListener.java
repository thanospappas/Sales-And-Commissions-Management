package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import csmeditor.GeneralInformationEditor;

public class CommissionCheckboxListener implements ActionListener{

	private GeneralReportViews generalView;

	public CommissionCheckboxListener(GeneralReportViews view){
		this.generalView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		GeneralInformationEditor genInfo = new GeneralInformationEditor(generalView.selectedRepresentative);
		if(generalView.commissionCheckbox.isSelected()){
			generalView.sixthNameLabel.setText("Προμήθεια:");
			generalView.sixthValueLabel.setText(Double.toString(genInfo.getCommission()));
		}
		else{
			generalView.sixthNameLabel.setText("");
			generalView.sixthValueLabel.setText("");
		}
	}

}
