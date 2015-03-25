package csmviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import csminput.ControllInput;

public class LoadButtonListener implements ActionListener {

	private String path;
	private ControllView controllView;

	public LoadButtonListener(ControllView view){
		controllView = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FileChooser fileSelector = new FileChooser();
		path = fileSelector.getPath();
		if(path == null)
			JOptionPane.showMessageDialog(null, "Δεν έχει επιλέγει κανένα αρχείο","Προσοχή",JOptionPane.WARNING_MESSAGE);
		String location = getPath();
		controllView.filePath.setText(location);
		ControllInput loader = new ControllInput(path,controllView.representativeObjectList);
		controllView.representativeObjectList = loader.getRepresentatives();
		DefaultListModel<String> modelList = new DefaultListModel<String>();
		for (int i = 0; i < controllView.representativeObjectList.size(); i++)
			modelList.addElement(controllView.representativeObjectList.get(i).getName());
		controllView.represantativeList.setModel(modelList);
	}

	public String getPath(){
		return path;
	}
}
