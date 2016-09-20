package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Vokabel;

import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtGerman;
	private JTextField txtEnglish;
	private JTabbedPane tabbedPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton toggleButton;
	private JToggleButton toggleButton_1;
	private JToggleButton toggleButton_2;
	private JToggleButton toggleButton_3;
	private JToggleButton toggleButton_4;
	private JComboBox comboBox;
	private Generator generator = new Generator();
	private List[] list;
	private JLabel lblEnd;
	private boolean de;
	private int box;
	private Vokabel currentVok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		list = generator.getLists();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblAskVokFrom = new JLabel("ask Vok from:");
		GridBagConstraints gbc_lblAskVokFrom = new GridBagConstraints();
		gbc_lblAskVokFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblAskVokFrom.gridx = 0;
		gbc_lblAskVokFrom.gridy = 0;
		panel.add(lblAskVokFrom, gbc_lblAskVokFrom);
		
		toggleButton = new JToggleButton("1");
		buttonGroup.add(toggleButton);
		GridBagConstraints gbc_toggleButton = new GridBagConstraints();
		gbc_toggleButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButton.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButton.gridx = 1;
		gbc_toggleButton.gridy = 0;
		panel.add(toggleButton, gbc_toggleButton);
		toggleButton.setSelected(true);
		
		toggleButton_1 = new JToggleButton("2");
		buttonGroup.add(toggleButton_1);
		GridBagConstraints gbc_toggleButton_1 = new GridBagConstraints();
		gbc_toggleButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButton_1.gridx = 1;
		gbc_toggleButton_1.gridy = 1;
		panel.add(toggleButton_1, gbc_toggleButton_1);
		
		toggleButton_2 = new JToggleButton("3");
		buttonGroup.add(toggleButton_2);
		GridBagConstraints gbc_toggleButton_2 = new GridBagConstraints();
		gbc_toggleButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButton_2.gridx = 1;
		gbc_toggleButton_2.gridy = 2;
		panel.add(toggleButton_2, gbc_toggleButton_2);
		
		toggleButton_3 = new JToggleButton("4");
		buttonGroup.add(toggleButton_3);
		GridBagConstraints gbc_toggleButton_3 = new GridBagConstraints();
		gbc_toggleButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButton_3.gridx = 1;
		gbc_toggleButton_3.gridy = 3;
		panel.add(toggleButton_3, gbc_toggleButton_3);
		
		toggleButton_4 = new JToggleButton("5");
		buttonGroup.add(toggleButton_4);
		GridBagConstraints gbc_toggleButton_4 = new GridBagConstraints();
		gbc_toggleButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButton_4.gridx = 1;
		gbc_toggleButton_4.gridy = 4;
		panel.add(toggleButton_4, gbc_toggleButton_4);
		
		JLabel lblIn = new JLabel("ask in:");
		GridBagConstraints gbc_lblIn = new GridBagConstraints();
		gbc_lblIn.anchor = GridBagConstraints.EAST;
		gbc_lblIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblIn.gridx = 0;
		gbc_lblIn.gridy = 5;
		panel.add(lblIn, gbc_lblIn);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"German", "English"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		panel.add(comboBox, gbc_comboBox);
		
		JButton btnGo_1 = new JButton("Go");
		btnGo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startVok();
			}

			
		});
		GridBagConstraints gbc_btnGo_1 = new GridBagConstraints();
		gbc_btnGo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGo_1.gridwidth = 2;
		gbc_btnGo_1.gridx = 0;
		gbc_btnGo_1.gridy = 6;
		panel.add(btnGo_1, gbc_btnGo_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblGerman = new JLabel("German:");
		GridBagConstraints gbc_lblGerman = new GridBagConstraints();
		gbc_lblGerman.anchor = GridBagConstraints.EAST;
		gbc_lblGerman.insets = new Insets(0, 0, 5, 5);
		gbc_lblGerman.gridx = 0;
		gbc_lblGerman.gridy = 0;
		panel_1.add(lblGerman, gbc_lblGerman);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkVok();
			}

			
		});
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.fill = GridBagConstraints.VERTICAL;
		gbc_btnGo.gridheight = 2;
		gbc_btnGo.insets = new Insets(0, 0, 5, 0);
		gbc_btnGo.gridx = 2;
		gbc_btnGo.gridy = 0;
		panel_1.add(btnGo, gbc_btnGo);
		
		JLabel lblEnglish = new JLabel("English:");
		GridBagConstraints gbc_lblEnglish = new GridBagConstraints();
		gbc_lblEnglish.anchor = GridBagConstraints.EAST;
		gbc_lblEnglish.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnglish.gridx = 0;
		gbc_lblEnglish.gridy = 1;
		panel_1.add(lblEnglish, gbc_lblEnglish);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblEnd = new JLabel("End");
		GridBagConstraints gbc_lblEnd = new GridBagConstraints();
		gbc_lblEnd.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnd.gridx = 1;
		gbc_lblEnd.gridy = 2;
		panel_1.add(lblEnd, gbc_lblEnd);
		
		JButton btnNextword = new JButton("NextWord");
		btnNextword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayVok();
			}
		});
		GridBagConstraints gbc_btnNextword = new GridBagConstraints();
		gbc_btnNextword.insets = new Insets(0, 0, 0, 5);
		gbc_btnNextword.gridx = 1;
		gbc_btnNextword.gridy = 3;
		panel_1.add(btnNextword, gbc_btnNextword);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("New tab", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblGerman_1 = new JLabel("German:");
		GridBagConstraints gbc_lblGerman_1 = new GridBagConstraints();
		gbc_lblGerman_1.anchor = GridBagConstraints.EAST;
		gbc_lblGerman_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGerman_1.gridx = 0;
		gbc_lblGerman_1.gridy = 0;
		panel_3.add(lblGerman_1, gbc_lblGerman_1);
		
		txtGerman = new JTextField();
		GridBagConstraints gbc_txtGerman = new GridBagConstraints();
		gbc_txtGerman.insets = new Insets(0, 0, 5, 5);
		gbc_txtGerman.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGerman.gridx = 1;
		gbc_txtGerman.gridy = 0;
		panel_3.add(txtGerman, gbc_txtGerman);
		txtGerman.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.VERTICAL;
		gbc_btnSave.gridheight = 2;
		gbc_btnSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 0;
		panel_3.add(btnSave, gbc_btnSave);
		
		JLabel lblEnglish_1 = new JLabel("English:");
		GridBagConstraints gbc_lblEnglish_1 = new GridBagConstraints();
		gbc_lblEnglish_1.anchor = GridBagConstraints.EAST;
		gbc_lblEnglish_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnglish_1.gridx = 0;
		gbc_lblEnglish_1.gridy = 1;
		panel_3.add(lblEnglish_1, gbc_lblEnglish_1);
		
		txtEnglish = new JTextField();
		GridBagConstraints gbc_txtEnglish = new GridBagConstraints();
		gbc_txtEnglish.insets = new Insets(0, 0, 5, 5);
		gbc_txtEnglish.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnglish.gridx = 1;
		gbc_txtEnglish.gridy = 1;
		panel_3.add(txtEnglish, gbc_txtEnglish);
		txtEnglish.setColumns(10);
		
		JButton btnList = new JButton("List");
		GridBagConstraints gbc_btnList = new GridBagConstraints();
		gbc_btnList.insets = new Insets(0, 0, 0, 5);
		gbc_btnList.gridx = 1;
		gbc_btnList.gridy = 2;
		panel_3.add(btnList, gbc_btnList);
		
		tabbedPane.setEnabledAt(1, false);
	}
	
	private void displayVok() {
		Textfields(true);
		textField.setText("");
		textField_1.setText("");
		lblEnd.setText("");
		currentVok = getRandomVok();
		if (de) {
			textField.setText(currentVok.getdt());
		} else {
			textField_1.setText(currentVok.geten());
		}
	}
	
	public void Textfields(boolean enable){
		textField.setEditable(enable);
		textField_1.setEditable(enable);
	}
	
	private Vokabel getRandomVok() {
		int random = (int) (Math.random() * list[box].size());
		Vokabel selected = (Vokabel) list[box].get(random);
		return selected;
	}
	
	public void checkVok() {

		if (currentVok.getdt().equals(textField.getText()) && currentVok.geten().equals(textField_1.getText())) {
			lblEnd.setText("richtig!! ;o)");
			Textfields(false);
//			displayVok();
		} else {
			lblEnd.setText("falsch :o(");
			Textfields(false);
		}

	}
	
	private void startVok() {
		box = getSelectedBox();
		de = true;
		if (comboBox.getSelectedIndex() == 1){
			//English
			de = false;
		}
		displayVok();
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setSelectedIndex(1);
		
	}
	
	private int getSelectedBox(){
		if (toggleButton.isSelected()){
			return 1;
		} else if (toggleButton_1.isSelected()){
			return 2;
		}else if (toggleButton_2.isSelected()){
			return 3;
		}else if (toggleButton_3.isSelected()){
			return 4;
		}else{
			return 5;
		}
		
	}
	
}
