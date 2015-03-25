package csmviews;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import csmeditor.Receipt;
import csmeditor.Representative;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ReceiptUpdaterViews extends JFrame {

	private JPanel contentPane;
	protected JTextField receiptIdText;
	protected JTextField dateText;
	protected JTextField kindText;
	protected JTextField itemText;
	protected JTextField companyText;
	protected JTextField countryText;
	protected JTextField addressText;
	protected JTextField streetNumberText;
	protected Receipt selectedReceipt;
	protected Representative selectedRepresentative;
	protected JTextField cityText;
	protected JTextField salesText;
	protected ArrayList<Representative> representativesList;
	
	public ReceiptUpdaterViews(Receipt chosenReceipt,Representative chosenRepresentative,ArrayList<Representative> representativeList) {
		setTitle("\u0391\u03BD\u03B1\u03BD\u03AD\u03C9\u03C3\u03B7 \u03C0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03B9\u03CE\u03BD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 497);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.selectedReceipt = chosenReceipt;
		this.selectedRepresentative = chosenRepresentative;
		this.representativesList = representativeList;
		JLabel receiptId = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u0391\u03C0\u03CC\u03B4\u03B5\u03B9\u03BE\u03B7\u03C2");
		
		receiptIdText = new JTextField();
		receiptIdText.setColumns(10);
		
		JLabel label = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1");
		
		dateText = new JTextField();
		dateText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0395\u03AF\u03B4\u03BF\u03C2");
		
		kindText = new JTextField();
		kindText.setColumns(10);
		
		JLabel label_1 = new JLabel("\u03A4\u03B5\u03BC\u03AC\u03C7\u03B9\u03B1");
		
		itemText = new JTextField();
		itemText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u0395\u03C4\u03B1\u03B9\u03C1\u03AF\u03B1");
		
		companyText = new JTextField();
		companyText.setColumns(10);
		
		JLabel label_3 = new JLabel("\u03A7\u03CE\u03C1\u03B1");
		
		countryText = new JTextField();
		countryText.setColumns(10);
		
		JLabel label_4 = new JLabel("\u039F\u03B4\u03CC\u03C2");
		
		addressText = new JTextField();
		addressText.setColumns(10);
		
		JLabel label_5 = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2");
		
		streetNumberText = new JTextField();
		streetNumberText.setColumns(10);
		
		JButton button = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");
		button.addActionListener(new SaveButtonUpdaterViewsListener(selectedRepresentative));
		
		JButton button_1 = new JButton("\u0391\u03BD\u03B1\u03BD\u03AD\u03C9\u03C3\u03B7");
		button_1.addActionListener(new UpdaterButtonListener(this));
		
		JLabel cityName = new JLabel("\u03A0\u03CC\u03BB\u03B7");
		
		cityText = new JTextField();
		cityText.setColumns(10);
		
		JLabel label_6 = new JLabel("\u03A0\u03C9\u03BB\u03AE\u03C3\u03B5\u03B9\u03C2");
		
		salesText = new JTextField();
		salesText.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_6)
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(receiptId)
									.addComponent(label)
									.addComponent(lblNewLabel)
									.addComponent(label_2)
									.addComponent(label_5)
									.addComponent(label_4)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(cityName)
										.addComponent(label_3)))
								.addGap(42)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(addressText, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
									.addComponent(cityText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
									.addComponent(countryText, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
									.addComponent(companyText, 208, 222, Short.MAX_VALUE)
									.addComponent(streetNumberText, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(dateText)
										.addComponent(receiptIdText, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
										.addComponent(kindText)
										.addComponent(salesText)
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(itemText, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))))
								.addGap(32)))))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(18)
					.addComponent(button)
					.addGap(16))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(receiptId))
						.addComponent(receiptIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(kindText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(salesText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(itemText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(companyText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(countryText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cityName))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(addressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(streetNumberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1)
								.addComponent(button))
							.addGap(24))
						.addComponent(label_5))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setTextFields();
	}
	private void setTextFields(){
		receiptIdText.setText(Integer.toString(selectedReceipt.getReceiptId()));
		dateText.setText(selectedReceipt.getDate());
		kindText.setText(selectedReceipt.getKind());
		salesText.setText(Double.toString(selectedReceipt.getSales()));
		itemText.setText(Integer.toString(selectedReceipt.getItemNumber()));
		companyText.setText(selectedReceipt.getCompany().getName());
		countryText.setText(selectedReceipt.getCompany().getAddress().getCountry());
		cityText.setText(selectedReceipt.getCompany().getAddress().getCity());
		addressText.setText(selectedReceipt.getCompany().getAddress().getStreet());
		streetNumberText.setText(selectedReceipt.getCompany().getAddress().getStreetNumber());
		
	}
}
