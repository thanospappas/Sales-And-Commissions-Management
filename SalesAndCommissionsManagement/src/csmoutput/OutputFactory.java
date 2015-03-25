package csmoutput;

import csmeditor.Representative;

public class OutputFactory {
	
	public static final int XML = 0;
	public static final int SIMPLE_FILE = 1;
	
	public FileWriter createWriter(int mode,Representative selectedRepresentative){
		if(mode == XML)
			return new XmlWriter(selectedRepresentative);
		return new SimpleWriter(selectedRepresentative);
	}
}
