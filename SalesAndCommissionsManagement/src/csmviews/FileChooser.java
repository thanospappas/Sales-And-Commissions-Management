package csmviews;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import csminput.FilterChooser;

public class FileChooser extends JDialog {

	private String path;

	public FileChooser() {
		UIManager.put("FileChooser.cancelButtonText", "�����");
		UIManager.put("FileChooser.lookInLabelText","��������� ��"); 
		UIManager.put("FileChooser.filesOfTypeLabelText","������"); 
		UIManager.put("FileChooser.fileNameLabelText","����� �������"); 
		UIManager.put("FileChooser.acceptAllFileFilterText","������"); 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FilterChooser());
		fileChooser.setDialogTitle("������� �������");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setApproveButtonText("�������");

		int retVal = fileChooser.showOpenDialog(null);
		if(retVal == JFileChooser.APPROVE_OPTION){
			path = fileChooser.getSelectedFile().getAbsolutePath();
		}
		else{
			path = null;
		}
		System.out.println("path is:" + path);
	}

	public String getPath(){
		return path;
	}

}
