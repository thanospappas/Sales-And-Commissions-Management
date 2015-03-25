package csmviews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import csmeditor.Representative;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneralReportViews extends JFrame {

	protected Representative selectedRepresentative;
	
	private JPanel basicPanel;
	private JPanel contentPane;
	private JPanel headerPanel;
	private JPanel informationPrinterPanel;
	protected JComboBox categoryChooserComboBox;
	protected JCheckBox salesValuesCheckbox;
	protected JCheckBox salesCategoryCheckbox; 
	private JButton saveButton;
	protected JCheckBox commissionCheckbox;
	private JLabel name;
	private JLabel afm ;
	protected JLabel firstNameLabel;
	protected JLabel secondNameLabel;
	protected JLabel thirdNameLabel;
	protected JLabel fourthNameLabel;
	protected JLabel fifthNameLabel;
	protected JLabel sixthNameLabel;
	protected JLabel nameValue;
	protected JLabel afmValue;
	protected JLabel firstValueLabel;
	protected JLabel secondValueLabel;
	protected JLabel thirdValueLabel;
	protected JLabel fourthValueLabel;
	protected JLabel fifthValueLabel;
	protected JLabel sixthValueLabel;
	protected JLabel selectedCategorySalesLabel;
	
	public GeneralReportViews(Representative chosenRepresentative) {
		setBackground(Color.WHITE);
		setTitle("\u0393\u03B5\u03BD\u03B9\u03BA\u03AE \u0391\u03BD\u03B1\u03C6\u03BF\u03C1\u03AC");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 528, 464);
		
		this.selectedRepresentative = chosenRepresentative;
		
		initContentPanePanel();
		initBasicPanel();
		initHeaderPanel();
		initInformationPrinterPanel();
		initWindowItems();
		setinformationPrinterPanelLayout();
		setBasicPanelLayout();
		setHeaderPanelLayout();
		
		
	}
	private void initWindowItems(){
		salesValuesCheckbox = new JCheckBox("Αξία Πωλήσεων");
		salesValuesCheckbox.addActionListener(new TotalSalesCheckboxListener(this));
		initLabels();
		
		saveButton = new JButton("Αποθήκευση Αναφοράς");
		saveButton.addActionListener(new SaveGeneralReportListener(this));

		salesCategoryCheckbox = new JCheckBox("Πωλήσεις για κάθε κατηγορία ενδυμάτων");
		salesCategoryCheckbox.addActionListener(new SalesCategoryCheckboxListener(this));
		commissionCheckbox = new JCheckBox("Προμήθεια που δικαιούται");
		commissionCheckbox.addActionListener(new CommissionCheckboxListener(this));
		
		
		selectedCategorySalesLabel = new JLabel("Πωλήσεις για μια συγκεκριμένη κατηγορία");
		selectedCategorySalesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		categoryChooserComboBox = new JComboBox();
		categoryChooserComboBox.addActionListener(new categoryChooserComboboxListener(this));
		categoryChooserComboBox.setModel(new DefaultComboBoxModel(new String[] {"Όλα", "Παντελόνια", "Φούστες", "Μπλούζες", "Παλτά"}));
		
		salesValuesCheckbox.setBackground(Color.WHITE);
		salesCategoryCheckbox.setBackground(Color.WHITE);
		commissionCheckbox.setBackground(Color.WHITE);
	}
	private void initLabels(){
		name = new JLabel("Όνομα:");
		afm = new JLabel("ΑΦΜ:");
		firstNameLabel = new JLabel("");
		secondNameLabel = new JLabel("");
		thirdNameLabel = new JLabel("");
		fourthNameLabel = new JLabel("");
		fifthNameLabel = new JLabel("");
		sixthNameLabel = new JLabel("");
		nameValue = new JLabel(selectedRepresentative.getName());
		afmValue = new JLabel(Integer.toString(selectedRepresentative.getAfm()));
		firstValueLabel = new JLabel("");
		secondValueLabel = new JLabel("");
		thirdValueLabel = new JLabel("");
		fourthValueLabel = new JLabel("");
		fifthValueLabel = new JLabel("");
		sixthValueLabel = new JLabel("");
	}
	
	private void initContentPanePanel(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	private void initBasicPanel(){
		basicPanel = new JPanel();
		basicPanel.setBackground(Color.WHITE);
		contentPane.add(basicPanel, BorderLayout.CENTER);
	}
	private void initHeaderPanel(){
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.WHITE);
	}
	private void initInformationPrinterPanel(){
		informationPrinterPanel = new JPanel();
		informationPrinterPanel.setBackground(Color.WHITE);
		informationPrinterPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
	}
	private void setBasicPanelLayout(){
		GroupLayout gl_basicPanel = new GroupLayout(basicPanel);
		gl_basicPanel.setHorizontalGroup(
			gl_basicPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 499, Short.MAX_VALUE)
				.addComponent(informationPrinterPanel, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
		);
		gl_basicPanel.setVerticalGroup(
			gl_basicPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_basicPanel.createSequentialGroup()
					.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(informationPrinterPanel, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
		);
		basicPanel.setLayout(gl_basicPanel);
	}
	private void setinformationPrinterPanelLayout(){
		GroupLayout gl_informationPrinterPanel = new GroupLayout(informationPrinterPanel);
		gl_informationPrinterPanel.setHorizontalGroup(
			gl_informationPrinterPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_informationPrinterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_informationPrinterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_informationPrinterPanel.createSequentialGroup()
							.addGroup(gl_informationPrinterPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(name)
								.addComponent(afm))
							.addGap(101)
							.addGroup(gl_informationPrinterPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(sixthValueLabel)
								.addComponent(fifthValueLabel)
								.addComponent(fourthValueLabel)
								.addComponent(thirdValueLabel)
								.addComponent(secondValueLabel)
								.addComponent(firstValueLabel)
								.addComponent(afmValue)
								.addComponent(nameValue)))
						.addComponent(firstNameLabel)
						.addComponent(secondNameLabel)
						.addComponent(thirdNameLabel)
						.addComponent(fourthNameLabel)
						.addComponent(fifthNameLabel)
						.addComponent(sixthNameLabel))
					.addContainerGap(297, Short.MAX_VALUE))
				.addGroup(gl_informationPrinterPanel.createSequentialGroup()
					.addContainerGap(326, Short.MAX_VALUE)
					.addComponent(saveButton)
					.addGap(29))
		);
		gl_informationPrinterPanel.setVerticalGroup(
			gl_informationPrinterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_informationPrinterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_informationPrinterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_informationPrinterPanel.createSequentialGroup()
							.addComponent(nameValue)
							.addGap(18)
							.addComponent(afmValue)
							.addGap(18)
							.addComponent(firstValueLabel)
							.addGap(18)
							.addComponent(secondValueLabel)
							.addGap(18)
							.addComponent(thirdValueLabel)
							.addGap(18)
							.addComponent(fourthValueLabel)
							.addGap(18)
							.addComponent(fifthValueLabel)
							.addGap(18)
							.addComponent(sixthValueLabel)
							.addContainerGap())
						.addGroup(gl_informationPrinterPanel.createSequentialGroup()
							.addComponent(name)
							.addGap(18)
							.addComponent(afm)
							.addGap(18)
							.addComponent(firstNameLabel)
							.addGap(18)
							.addComponent(secondNameLabel)
							.addGap(18)
							.addComponent(thirdNameLabel)
							.addGap(18)
							.addComponent(fourthNameLabel)
							.addGap(18)
							.addComponent(fifthNameLabel)
							.addGap(18)
							.addComponent(sixthNameLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
							.addComponent(saveButton)
							.addGap(21))))
		);
		informationPrinterPanel.setLayout(gl_informationPrinterPanel);
	}
	private void setHeaderPanelLayout(){
		GroupLayout gl_headerPanel = new GroupLayout(headerPanel);
		gl_headerPanel.setHorizontalGroup(
			gl_headerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headerPanel.createSequentialGroup()
					.addGroup(gl_headerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_headerPanel.createSequentialGroup()
							.addComponent(salesValuesCheckbox)
							.addGap(18)
							.addComponent(salesCategoryCheckbox)
							.addGap(13)
							.addComponent(commissionCheckbox))
						.addGroup(gl_headerPanel.createSequentialGroup()
							.addGap(43)
							.addComponent(selectedCategorySalesLabel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(categoryChooserComboBox, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_headerPanel.setVerticalGroup(
			gl_headerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headerPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_headerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(salesValuesCheckbox)
						.addComponent(commissionCheckbox)
						.addComponent(salesCategoryCheckbox))
					.addGap(8)
					.addGroup(gl_headerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(categoryChooserComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectedCategorySalesLabel))
					.addContainerGap())
		);
		headerPanel.setLayout(gl_headerPanel);
	}
	
}
