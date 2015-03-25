package csminput;

import java.util.ArrayList;

import csmeditor.Representative;

public class InputFactory {
	public static final int XML = 1;
	public static final int SIMPLE_FILE = 2;
	
	public FileParser createParser(int parserType,ArrayList<Representative> representativeList){
		if(parserType == XML){
			return  new XmlParser(representativeList);
		}
		return new SimpleParser(representativeList);
	}
}
