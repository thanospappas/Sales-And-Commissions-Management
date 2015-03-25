package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import csmeditor.GeneralInformationEditor;

public class SalesCategoryCheckboxListener implements ActionListener{
	private GeneralReportViews controllView;
	public SalesCategoryCheckboxListener(GeneralReportViews view){
		controllView = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0){
		GeneralInformationEditor genInfo = new GeneralInformationEditor(controllView.selectedRepresentative);
		if(controllView.salesCategoryCheckbox.isSelected()){
			setValuesToLabels(genInfo);
		}
		else{
			setEmptyLabels();
		}
	}
	
	public void setValuesToLabels(GeneralInformationEditor genInfo){
		controllView.secondNameLabel.setText("����������:");
		controllView.secondValueLabel.setText(Double.toString(genInfo.getTrousersSales()));
		controllView.thirdNameLabel.setText("�������:");
		controllView.thirdValueLabel.setText(Double.toString(genInfo.getSkirtsSales()));
		controllView.fourthNameLabel.setText("��������:");
		controllView.fourthValueLabel.setText(Double.toString(genInfo.getShirtsSales()));
		controllView.fifthNameLabel.setText("�����:");
		controllView.fifthValueLabel.setText(Double.toString(genInfo.getCoatsSales()));
	}
	
	public void setEmptyLabels(){
		controllView.secondNameLabel.setText("");
		controllView.secondValueLabel.setText("");
		controllView.thirdNameLabel.setText("");
		controllView.thirdValueLabel.setText("");
		controllView.fourthNameLabel.setText("");
		controllView.fourthValueLabel.setText("");
		controllView.fifthNameLabel.setText("");
		controllView.fifthValueLabel.setText("");
	}

}
