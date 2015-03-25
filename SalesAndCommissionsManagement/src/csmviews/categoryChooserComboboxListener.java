package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import csmeditor.GeneralInformationEditor;

public class categoryChooserComboboxListener implements ActionListener{
	
	private GeneralReportViews generalView;
	public categoryChooserComboboxListener(GeneralReportViews view){
		generalView = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		GeneralInformationEditor genInfo = new GeneralInformationEditor(generalView.selectedRepresentative);
		String selectedCategory =  (String) generalView.categoryChooserComboBox.getSelectedItem();
		switch (selectedCategory) {
		case "����������":
			generalView.secondNameLabel.setText("����������:");
			generalView.secondValueLabel.setText(Double.toString(genInfo.getTrousersSales()));
			clearTheRest(2);
			break;
		case "�������":
			generalView.thirdNameLabel.setText("�������:");
			generalView.thirdValueLabel.setText(Double.toString(genInfo.getSkirtsSales()));
			clearTheRest(3);
			break;
		case "��������":
			generalView.fourthNameLabel.setText("��������:");
			generalView.fourthValueLabel.setText(Double.toString(genInfo.getShirtsSales()));
			clearTheRest(4);
			break;
		case "�����":
			generalView.fifthNameLabel.setText("�����:");
			generalView.fifthValueLabel.setText(Double.toString(genInfo.getCoatsSales()));
			clearTheRest(5);
			break;
		case "���":
			setAllCategories(genInfo);
			break;
		}
	}
	
	private void clearTheRest(int number) {
		if(number == 2){
			generalView.thirdNameLabel.setText("");
			generalView.thirdValueLabel.setText("");
			generalView.fourthNameLabel.setText("");
			generalView.fourthValueLabel.setText("");
			generalView.fifthNameLabel.setText("");
			generalView.fifthValueLabel.setText("");
		}
		else if(number == 3){
			generalView.secondNameLabel.setText("");
			generalView.secondValueLabel.setText("");
			generalView.fourthNameLabel.setText("");
			generalView.fourthValueLabel.setText("");
			generalView.fifthNameLabel.setText("");
			generalView.fifthValueLabel.setText("");
		}
		else if(number == 4){
			generalView.thirdNameLabel.setText("");
			generalView.thirdValueLabel.setText("");
			generalView.secondNameLabel.setText("");
			generalView.secondValueLabel.setText("");
			generalView.fifthNameLabel.setText("");
			generalView.fifthValueLabel.setText("");
		}
		else{
			generalView.thirdNameLabel.setText("");
			generalView.thirdValueLabel.setText("");
			generalView.fourthNameLabel.setText("");
			generalView.fourthValueLabel.setText("");
			generalView.secondNameLabel.setText("");
			generalView.secondValueLabel.setText("");
		}
	}
	private void setAllCategories(GeneralInformationEditor genInfo){
		generalView.secondNameLabel.setText("����������:");
		generalView.secondValueLabel.setText(Double.toString(genInfo.getTrousersSales()));
		generalView.thirdNameLabel.setText("�������:");
		generalView.thirdValueLabel.setText(Double.toString(genInfo.getSkirtsSales()));
		generalView.fourthNameLabel.setText("��������:");
		generalView.fourthValueLabel.setText(Double.toString(genInfo.getShirtsSales()));
		generalView.fifthNameLabel.setText("�����:");
		generalView.fifthValueLabel.setText(Double.toString(genInfo.getCoatsSales()));
	}

}




