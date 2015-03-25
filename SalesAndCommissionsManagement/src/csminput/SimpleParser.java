package csminput;

import csmeditor.Address;
import csmeditor.Company;
import csmeditor.Receipt;
import csmeditor.Representative;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SimpleParser extends FileParser {
	private KindInputFactory kindInput;
	private Representative representative;
	private ArrayList<Receipt> receiptList;
	private boolean firstTime = true;
	
	public SimpleParser(ArrayList<Representative> representativeList) {
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
		kindInput = new KindSimpleInputFactory();
		while ((line = br.readLine()) != null) {
			String[] splitedLine = line.split(":");
			if (splitedLine[0].equals(RECEIPT_ID)) {
				if (isFirtstTime() == false) {
					setRepresentativeInfo();
					kindInput = new KindSimpleInputFactory();
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
	
	public ArrayList<Representative> getRepresentative() {
		return representativesList;
	}
	
	private void setRepresentativeInfo(){
		kindInput.setReceipts();
		receiptList.add(kindInput.getReceipt());
		representative.setReceiptList(receiptList);
	}


}
