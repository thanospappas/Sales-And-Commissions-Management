package csminput;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FilterChooser extends FileFilter {
	private String acceptedExtension = "txt";

	@Override
	public boolean accept(File file) {
		if(file.isDirectory())
			return true;
		return isAccepted(file);
	}

	@Override
	public String getDescription() {
		return "txt File";
	}

	private boolean isAccepted(File file){
		String fileName = file.getName();
		int i = fileName.lastIndexOf('.');
		if(i > 0 && i < fileName.length()-1) {
			String ext = fileName.substring(i+1).toLowerCase();
			if ( ext.equals(acceptedExtension ))
				return true;
		}
		return false;
	}
}
