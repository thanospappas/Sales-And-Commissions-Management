package csminput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import csmeditor.Representative;
import csmviews.FileChooser;

public class ControllInput {
	public static final int XML = 1;
	public static final int SIMPLE_FILE = 2;
	private FileParser fileParser;
	private ArrayList<Representative> representativeList;
	
	public ControllInput(String path,ArrayList<Representative> representative) {
		representativeList = new ArrayList<Representative>();
		representativeList = representative;
		InputFactory factoryInput = new InputFactory();
		if(path != null){
			fileParser = factoryInput.createParser(checkInputFormat(path),representativeList);
			fileParser.readFile(path);
			representativeList = fileParser.getRepresentative();
		}
	}

	public int checkInputFormat(String path) {
		try {
			if(isXml(path))
				return XML;
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Το αρχείο δεν μπορεί να διαβαστεί", "Σφάλμα",
					JOptionPane.ERROR_MESSAGE);
		}
		return SIMPLE_FILE;
	}
	
	public boolean isXml(String path) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		while((line = reader.readLine()) != null){
			String[] splittedLine = line.split("\\s+");
			if (splittedLine[0].contains("<Name>")){
				reader.close();
				return true;
			}
		}
		reader.close();
		return false;
	}
	
	public ArrayList<Representative> getRepresentatives(){
		return representativeList;
	}
}
