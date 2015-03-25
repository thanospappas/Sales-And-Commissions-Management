package csmviews;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import csmeditor.Representative;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class ControllView extends JFrame {
	private ArrayList<String> filesPathList;
	protected ArrayList<Representative> representativeObjectList;
	
	private CustomTableModel fieldsTableModel;
	protected JTable receiptInfoTable;
	protected JTextField filePath;
	private JMenuBar basicMenuBar;
	private JMenu fileMenu;
	private JMenuItem saveMenuItem;
	private JMenuItem exitMenuItem;
	private JMenu editMenu;
	private JMenu helpMenu;
	private JPanel toolBar;
	private JMenuBar menuBar;
	private JButton generalReportButton;
	private JButton newReceiptsAdderButton;
	private JButton updateInformationButton;
	private JButton loadButton;
	private JPanel contentPane;
	private JPanel basicPanel;
	private JPanel representativeInfoPane;
	private JPanel representativeListPane;
	private JLabel locationText;
	private JPanel receiptInfoPane;
	private JPanel representativePane;
	protected JList represantativeList;
	private JLabel representativeInformation;
	private JLabel representativeName;
	private JLabel representativeAFM;
	protected JLabel nameValue;
	private JLabel tableTitle;
	private JScrollPane scrollPane;
	private JMenuItem openMenuItem;
	protected JLabel afmValue;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControllView frame = new ControllView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControllView() {
		setTitle("Διαχείριση Πωλήσεων και Προμηθειών");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 602);
		initialize();
		createMenu();
		createToolBar();
		createBasicWindow();
	}
	private void initialize(){
		filesPathList = new ArrayList<>();
		representativeObjectList = new ArrayList<Representative>();
	}
	private void createMenu(){
		basicMenuBar = new JMenuBar();
		setJMenuBar(basicMenuBar);
		
		fileMenu = new JMenu("\u0391\u03C1\u03C7\u03B5\u03AF\u03BF");
		basicMenuBar.add(fileMenu);
		fileMenu.setHorizontalAlignment(SwingConstants.LEFT);
		
		openMenuItem = new JMenuItem("\u0386\u03BD\u03BF\u03B9\u03B3\u03BC\u03B1");
		fileMenu.add(openMenuItem);
		
		openMenuItem.addActionListener(new LoadButtonListener(this));
		
		saveMenuItem = new JMenuItem("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");
		saveMenuItem.addActionListener(new SaveButtonListener(this));
		fileMenu.add(saveMenuItem);
		
		exitMenuItem = new JMenuItem("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		exitMenuItem.addActionListener(new ExitMenuItem());
		fileMenu.add(exitMenuItem);
		
		editMenu = new JMenu("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1");
		basicMenuBar.add(editMenu);
		
		helpMenu = new JMenu("\u0392\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1");
		basicMenuBar.add(helpMenu);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	
	}
	private void createToolBar(){
		toolBar = new JPanel();
		contentPane.add(toolBar, BorderLayout.NORTH);
		toolBar.setLayout(new GridLayout(0, 1, 0, 0));
		
		menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		generalReportButton = new JButton("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7 \u0393\u03B5\u03BD\u03B9\u03BA\u03AE\u03C2 \u0391\u03BD\u03B1\u03C6\u03BF\u03C1\u03AC\u03C2");
		generalReportButton.addActionListener(new GeneralInfoButtonListener(this));
		
		menuBar.add(generalReportButton);
		
		newReceiptsAdderButton = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039D\u03AD\u03C9\u03BD \u0391\u03C0\u03BF\u03B4\u03B5\u03AF\u03BE\u03B5\u03C9\u03BD");
		newReceiptsAdderButton.addActionListener(new NewReceiptAdderButtonListener(this));
		menuBar.add(newReceiptsAdderButton);
		
		updateInformationButton = new JButton("\u0391\u03BD\u03B1\u03BD\u03AD\u03C9\u03C3\u03B7 \u03A0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03B9\u03CE\u03BD");
		updateInformationButton.addActionListener(new UpdateButtonView(this));
		menuBar.add(updateInformationButton);
		
		JButton button = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7 \u0391\u03BD\u03C4\u03B9\u03C0\u03C1\u03BF\u03C3\u03CE\u03C0\u03BF\u03C5");
		button.addActionListener(new SaveButtonListener(this));
		menuBar.add(button);
	}
	private void createBasicWindow(){

		
		basicPanel = new JPanel();
		basicPanel.setBackground(Color.WHITE);
		contentPane.add(basicPanel, BorderLayout.CENTER);
		
		representativeInfoPane = new JPanel();
		representativeInfoPane.setBackground(Color.WHITE);
		
		representativeListPane = new JPanel();
		representativeListPane.setBackground(Color.WHITE);
		GroupLayout gl_basicPanel = new GroupLayout(basicPanel);
		gl_basicPanel.setHorizontalGroup(
			gl_basicPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_basicPanel.createSequentialGroup()
					.addComponent(representativeListPane, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(representativeInfoPane, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_basicPanel.setVerticalGroup(
			gl_basicPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_basicPanel.createSequentialGroup()
					.addGroup(gl_basicPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_basicPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(representativeListPane, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
							.addGap(11))
						.addComponent(representativeInfoPane, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
					.addGap(0))
		);
		
		locationText = new JLabel("\u03A4\u03BF\u03C0\u03BF\u03B8\u03B5\u03C3\u03AF\u03B1");
		
		filePath = new JTextField();
		filePath.setColumns(10);
		
		loadButton = new JButton("\u03A6\u03CC\u03C1\u03C4\u03C9\u03C3\u03B7");
		loadButton.addActionListener(new LoadButtonListener(this));

		
		
		representativePane = new JPanel();
		representativePane.setBackground(Color.WHITE);
		representativePane.setBorder(new TitledBorder(null, "\u039B\u03AF\u03C3\u03C4\u03B1 \u0391\u03BD\u03C4\u03B9\u03C0\u03C1\u03BF\u03C3\u03CE\u03C0\u03C9\u03BD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_representativeListPane = new GroupLayout(representativeListPane);
		gl_representativeListPane.setHorizontalGroup(
			gl_representativeListPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_representativeListPane.createSequentialGroup()
					.addGroup(gl_representativeListPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_representativeListPane.createSequentialGroup()
							.addGap(27)
							.addComponent(locationText)
							.addGap(18)
							.addComponent(filePath, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
						.addGroup(gl_representativeListPane.createSequentialGroup()
							.addContainerGap(146, Short.MAX_VALUE)
							.addComponent(loadButton)))
					.addContainerGap())
				.addComponent(representativePane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
		);
		gl_representativeListPane.setVerticalGroup(
			gl_representativeListPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_representativeListPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_representativeListPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationText)
						.addComponent(filePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(loadButton)
					.addGap(18)
					.addComponent(representativePane, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
		);
		
		represantativeList = new JList();
		represantativeList.setBorder(new LineBorder(Color.LIGHT_GRAY));
		represantativeList.setFixedCellHeight(25);
		represantativeList.addMouseListener(new MouseListClicked(this));
		
		GroupLayout gl_representativePane = new GroupLayout(representativePane);
		gl_representativePane.setHorizontalGroup(
			gl_representativePane.createParallelGroup(Alignment.LEADING)
				.addComponent(represantativeList, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
		);
		gl_representativePane.setVerticalGroup(
			gl_representativePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_representativePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(represantativeList, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
		);
		representativePane.setLayout(gl_representativePane);
		representativeListPane.setLayout(gl_representativeListPane);
		
		representativeInformation = new JLabel("\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u0391\u03BD\u03C4\u03B9\u03C0\u03C1\u03BF\u03C3\u03CE\u03C0\u03BF\u03C5");
		
		representativeName = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");
		
		representativeAFM = new JLabel("\u0391\u03A6\u039C:");
		
		nameValue = new JLabel("");
		
		receiptInfoPane = new JPanel();
		receiptInfoPane.setBackground(Color.WHITE);
		
		afmValue = new JLabel("");
		GroupLayout gl_representativeInfoPane = new GroupLayout(representativeInfoPane);
		gl_representativeInfoPane.setHorizontalGroup(
			gl_representativeInfoPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_representativeInfoPane.createSequentialGroup()
					.addGroup(gl_representativeInfoPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_representativeInfoPane.createSequentialGroup()
							.addGap(156)
							.addComponent(representativeInformation))
						.addGroup(gl_representativeInfoPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_representativeInfoPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_representativeInfoPane.createSequentialGroup()
									.addComponent(representativeName)
									.addGap(18)
									.addComponent(nameValue))
								.addGroup(gl_representativeInfoPane.createSequentialGroup()
									.addComponent(representativeAFM)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(afmValue))))
						.addGroup(gl_representativeInfoPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(receiptInfoPane, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_representativeInfoPane.setVerticalGroup(
			gl_representativeInfoPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_representativeInfoPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(representativeInformation)
					.addGap(18)
					.addGroup(gl_representativeInfoPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(representativeName)
						.addComponent(nameValue))
					.addGap(22)
					.addGroup(gl_representativeInfoPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(representativeAFM)
						.addComponent(afmValue))
					.addGap(83)
					.addComponent(receiptInfoPane, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addContainerGap())
		);
		receiptInfoPane.setLayout(new BorderLayout(0, 0));
		
		tableTitle = new JLabel("\u0391\u03C0\u03BF\u03B4\u03B5\u03AF\u03BE\u03B5\u03B9\u03C2");
		tableTitle.setBackground(Color.WHITE);
		tableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		receiptInfoPane.add(tableTitle, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		receiptInfoPane.add(scrollPane, BorderLayout.CENTER);
		
		receiptInfoTable = new JTable();
		receiptInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		receiptInfoTable.setRowHeight(30);
		fieldsTableModel = new CustomTableModel();
	//	fieldsTableModel.addRows();
		receiptInfoTable.setModel(fieldsTableModel);
		scrollPane.setViewportView(receiptInfoTable);
		
		
		representativeInfoPane.setLayout(gl_representativeInfoPane);
		basicPanel.setLayout(gl_basicPanel);
	}
	private void setPath(String path){
		filesPathList.add(path);
	}
}
