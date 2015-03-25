package csmoutput;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import csmeditor.Representative;
import csminput.FilterChooser;

public class ControllOutput {
	private Representative selectedRepresentative;
	private String path;
	private FileWriter fileWriter;
	private OutputFactory factoryOutput;
	
	public ControllOutput(Representative representative){
		this.selectedRepresentative = representative;
		int answer = chooseSaveMode();
		if(answer == -1){
			JOptionPane.showMessageDialog(null,
					"��� ���� �������� ����� ������� �����������", "������",
					JOptionPane.WARNING_MESSAGE);
		}
		else{
			createChooser();
			saveFile(answer);
		}
	}
	
	public int chooseSaveMode(){
		Object[] options = { "���� ������ ��������", "XML", };
		return JOptionPane.showOptionDialog(null,
				"�������� ����� ������� ����������� ",
				"������� ������� �����������", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
	}
	
	public void createChooser(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FilterChooser());
		fileChooser.setDialogTitle("���������� ������� ");
		fileChooser.setSelectedFile(new File(Integer
				.toString(selectedRepresentative.getAfm())
				+ "_RECEIPTS"
				+ ".txt"));
		fileChooser.setAcceptAllFileFilterUsed(false);
		int retVal = fileChooser.showSaveDialog(null);
		if (retVal == JFileChooser.APPROVE_OPTION)
			path = fileChooser.getSelectedFile().getAbsolutePath();
	}
	
	public void saveFile(int answer){
		if (path != null) {
			factoryOutput = new OutputFactory();
			fileWriter = factoryOutput.createWriter(answer, selectedRepresentative);
			fileWriter.writeFile(path);
		} 
		else {
			JOptionPane.showMessageDialog(null,
					"��� ���� �������� ��������� �����������", "������",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
