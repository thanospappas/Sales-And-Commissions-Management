package csminput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import csmeditor.Address;
import csmeditor.Company;
import csmeditor.Receipt;
import csmeditor.Representative;

public class XmlParser extends FileParser {
	private String path;
	private KindInputFactory kindInput;
	private Representative representative;
	private ArrayList<Receipt> receiptList;
	private boolean firstTime = true;
	public static final String RECEIPTID = "ReceiptID";

	public XmlParser(ArrayList<Representative> representativeList) {
		representativesList = new ArrayList<Representative>();
		representativesList = representativeList;
		representative = new Representative();
		receiptList = new ArrayList<>();
	}

	@Override
	public void readFile(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			tryToRead(br);
			br.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Το αρχείο δεν βρέθηκε",
					"Σφάλμα", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Το αρχείο δεν μπορεί να διαβαστεί", "Σφάλμα",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	private void tryToRead(BufferedReader br) throws IOException{
		String line;
		kindInput = new KindXmlInputFactory();
		while ((line = br.readLine()) != null) {
			String[] splitedLine = line.split(">");
			if (splitedLine[0].equals("<" + RECEIPTID)) {
				if (isFirtstTime() == false) {
					setRepresentativeInfo();
					kindInput = new KindXmlInputFactory();
				}	
			}
			kindInput.setRepresentative(splitedLine,representative);
		}
		setRepresentativeInfo();
		representativesList.add(representative);
	}
	
	private boolean isFirtstTime(){
		if(firstTime){
			firstTime = false;
			return true;
		}
		return false;
	}
	private void setRepresentativeInfo(){
		kindInput.setReceipts();
		receiptList.add(kindInput.getReceipt());
		representative.setReceiptList(receiptList);
	}

	@Override
	public ArrayList<Representative> getRepresentative() {
		return representativesList;
	}
	


}
