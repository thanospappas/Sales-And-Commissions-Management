package csmviews;
import csminput.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenuItem implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	
}
