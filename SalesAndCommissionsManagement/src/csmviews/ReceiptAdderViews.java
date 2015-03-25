package csmviews;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import csmeditor.Representative;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceiptAdderViews extends JFrame {

	private JPanel basicPanel;
	protected JTextField receiptIdText;
	protected JTextField dateText;
	protected JTextField kindText;
	protected JTextField salesText;
	protected JTextField itemsText;
	protected JTextField companyText;
	protected JTextField countryText;
	protected JTextField cityText;
	protected JTextField streetText;
	protected JTextField numberStreetText;
	protected JButton addButton;
	private JLabel receiptIdLabel; 
	private JLabel dateLabel;
	private JLabel kindLabel;
	private JLabel salesLabel;
	private JLabel itemsLabel;
	private JLabel companyLabel;
	private JLabel countryLabel;
	private JLabel cityLabel;
	private JLabel streetLabel;
	private JLabel numberLabel;
	
	protected Representative selectedRepresentative;

	public ReceiptAdderViews(Representative chosenRepresentative) {
		setTitle("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039D\u03AD\u03C9\u03BD \u0391\u03C0\u03BF\u03B4\u03B5\u03AF\u03BE\u03B5\u03C9\u03BD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 508, 492);
		
		selectedRepresentative = chosenRepresentative;
		
		basicPanel = new JPanel();
		basicPanel.setBackground(Color.WHITE);
		basicPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(basicPanel);
		
		receiptIdLabel = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u0391\u03C0\u03CC\u03B4\u03B5\u03B9\u03BE\u03B7\u03C2");
		
		dateLabel = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1");
		
		kindLabel = new JLabel("\u0395\u03AF\u03B4\u03BF\u03C2");
		
		salesLabel = new JLabel("\u03A0\u03C9\u03BB\u03AE\u03C3\u03B5\u03B9\u03C2");
		
		itemsLabel = new JLabel("\u03A4\u03B5\u03BC\u03AC\u03C7\u03B9\u03B1");
		
		companyLabel = new JLabel("\u0395\u03C4\u03B1\u03B9\u03C1\u03AF\u03B1");
		
		countryLabel = new JLabel("\u03A7\u03CE\u03C1\u03B1");
		
		cityLabel = new JLabel("\u03A0\u03CC\u03BB\u03B7");
		
		streetLabel = new JLabel("\u039F\u03B4\u03CC\u03C2");
		
		numberLabel = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2");
		
		receiptIdText = new JTextField();
		receiptIdText.setColumns(10);
		
		dateText = new JTextField();
		dateText.setColumns(10);
		
		kindText = new JTextField();
		kindText.setColumns(10);
		
		salesText = new JTextField();
		salesText.setColumns(10);
		
		itemsText = new JTextField();
		itemsText.setColumns(10);
		
		companyText = new JTextField();
		companyText.setColumns(10);
		
		countryText = new JTextField();
		countryText.setColumns(10);
		
		cityText = new JTextField();
		cityText.setColumns(10);
		
		streetText = new JTextField();
		streetText.setColumns(10);
		
		numberStreetText = new JTextField();
		numberStreetText.setColumns(10);
		
		addButton = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		addButton.addActionListener(new ReceiptAdder(this));
		
		GroupLayout gl_basicPanel = new GroupLayout(basicPanel);
		gl_basicPanel.setHorizontalGroup(
			gl_basicPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_basicPanel.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(receiptIdLabel)
						.addComponent(dateLabel)
						.addComponent(kindLabel)
						.addComponent(salesLabel)
						.addComponent(itemsLabel)
						.addComponent(companyLabel)
						.addComponent(countryLabel)
						.addComponent(cityLabel)
						.addComponent(streetLabel)
						.addComponent(numberLabel))
					.addGap(76)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(numberStreetText)
						.addComponent(streetText)
						.addComponent(cityText)
						.addComponent(countryText)
						.addComponent(companyText)
						.addComponent(itemsText)
						.addComponent(salesText)
						.addComponent(kindText)
						.addComponent(dateText)
						.addComponent(receiptIdText, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(80, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_basicPanel.createSequentialGroup()
					.addContainerGap(375, Short.MAX_VALUE)
					.addComponent(addButton)
					.addGap(18))
		);
		gl_basicPanel.setVerticalGroup(
			gl_basicPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_basicPanel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(receiptIdLabel)
						.addComponent(receiptIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateLabel)
						.addComponent(dateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(kindLabel)
						.addComponent(kindText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(salesLabel)
						.addComponent(salesText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemsLabel)
						.addComponent(itemsText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(companyLabel)
						.addComponent(companyText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(countryLabel)
						.addComponent(countryText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cityLabel)
						.addComponent(cityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(streetLabel)
						.addComponent(streetText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(numberLabel)
						.addComponent(numberStreetText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(addButton)
					.addContainerGap())
		);
		basicPanel.setLayout(gl_basicPanel);
	}
}
