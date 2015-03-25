package csmviews;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import csminput.FilterChooser;

public class FileChooser extends JDialog {

	private String path;

	public FileChooser() {
		UIManager.put("FileChooser.cancelButtonText", "’κυρο");
		UIManager.put("FileChooser.lookInLabelText","Αναζήτηση σε"); 
		UIManager.put("FileChooser.filesOfTypeLabelText","Φίλτρο"); 
		UIManager.put("FileChooser.fileNameLabelText","Όνομα Αρχείου"); 
		UIManager.put("FileChooser.acceptAllFileFilterText","Φίλτρο"); 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FilterChooser());
		fileChooser.setDialogTitle("’νοιγμα Αρχείου");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setApproveButtonText("’νοιγμα");

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
