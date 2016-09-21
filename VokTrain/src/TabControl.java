import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.Vokabel;

import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class TabControl extends JFrame {

	private Vokabellist vl = new Vokabellist();
	private Vokabel[] list = vl.getlist();
	private boolean de = true;
	private Vokabel currentVok;
	private JLabel lblEnd;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JRadioButton rdbtnDe;
	private JRadioButton rdbtnEn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabControl frame = new TabControl();
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
	public TabControl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Trainer", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDe = new JLabel("De");
		GridBagConstraints gbc_lblDe = new GridBagConstraints();
		gbc_lblDe.anchor = GridBagConstraints.EAST;
		gbc_lblDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblDe.gridx = 0;
		gbc_lblDe.gridy = 0;
		panel.add(lblDe, gbc_lblDe);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
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
		gbc_btnGo.gridx = 3;
		gbc_btnGo.gridy = 0;
		panel.add(btnGo, gbc_btnGo);
		
		JLabel lblEn = new JLabel("En");
		GridBagConstraints gbc_lblEn = new GridBagConstraints();
		gbc_lblEn.anchor = GridBagConstraints.EAST;
		gbc_lblEn.insets = new Insets(0, 0, 5, 5);
		gbc_lblEn.gridx = 0;
		gbc_lblEn.gridy = 1;
		panel.add(lblEn, gbc_lblEn);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblEnd = new JLabel("End");
		GridBagConstraints gbc_lblEnd = new GridBagConstraints();
		gbc_lblEnd.gridwidth = 2;
		gbc_lblEnd.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnd.gridx = 1;
		gbc_lblEnd.gridy = 2;
		panel.add(lblEnd, gbc_lblEnd);
		
		rdbtnDe = new JRadioButton("De");
		rdbtnDe.setSelected(true);
		buttonGroup.add(rdbtnDe);
		GridBagConstraints gbc_rdbtnDe = new GridBagConstraints();
		gbc_rdbtnDe.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDe.gridx = 1;
		gbc_rdbtnDe.gridy = 3;
		panel.add(rdbtnDe, gbc_rdbtnDe);
		
		rdbtnEn = new JRadioButton("En");
		buttonGroup.add(rdbtnEn);
		GridBagConstraints gbc_rdbtnEn = new GridBagConstraints();
		gbc_rdbtnEn.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEn.gridx = 2;
		gbc_rdbtnEn.gridy = 3;
		panel.add(rdbtnEn, gbc_rdbtnEn);
		
		JButton btnNewVokable = new JButton("new Vokable");
		btnNewVokable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayVok();
			}
		});
		GridBagConstraints gbc_btnNewVokable = new GridBagConstraints();
		gbc_btnNewVokable.gridwidth = 2;
		gbc_btnNewVokable.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewVokable.gridx = 1;
		gbc_btnNewVokable.gridy = 4;
		panel.add(btnNewVokable, gbc_btnNewVokable);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Management", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblDe_1 = new JLabel("De:");
		GridBagConstraints gbc_lblDe_1 = new GridBagConstraints();
		gbc_lblDe_1.anchor = GridBagConstraints.EAST;
		gbc_lblDe_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDe_1.gridx = 0;
		gbc_lblDe_1.gridy = 0;
		panel_1.add(lblDe_1, gbc_lblDe_1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText() != "" && textField_3.getText() != ""){
				vl.addtoList((new Vokabel(textField_2.getText(), textField_3.getText(),0)));
				textField_2.setText("");
				textField_3.setText("");
			}}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 2;
		gbc_btnSave.fill = GridBagConstraints.VERTICAL;
		gbc_btnSave.gridheight = 2;
		gbc_btnSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 0;
		panel_1.add(btnSave, gbc_btnSave);
		
		JLabel lblEn_1 = new JLabel("En:");
		GridBagConstraints gbc_lblEn_1 = new GridBagConstraints();
		gbc_lblEn_1.anchor = GridBagConstraints.EAST;
		gbc_lblEn_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEn_1.gridx = 0;
		gbc_lblEn_1.gridy = 1;
		panel_1.add(lblEn_1, gbc_lblEn_1);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 1;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnLoadlist = new JButton("loadList");
		btnLoadlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initTable();
			}
		});
		
		JLabel lblSort = new JLabel("Sort:");
		GridBagConstraints gbc_lblSort = new GridBagConstraints();
		gbc_lblSort.gridwidth = 2;
		gbc_lblSort.insets = new Insets(0, 0, 5, 5);
		gbc_lblSort.gridx = 2;
		gbc_lblSort.gridy = 2;
		panel_1.add(lblSort, gbc_lblSort);
		GridBagConstraints gbc_btnLoadlist = new GridBagConstraints();
		gbc_btnLoadlist.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoadlist.gridx = 1;
		gbc_btnLoadlist.gridy = 3;
		panel_1.add(btnLoadlist, gbc_btnLoadlist);
		
		JButton btnSort = new JButton("De");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				vl.sortList(true);
				Arrays.sort(list, new DEComparator());
				
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.insets = new Insets(0, 0, 5, 5);
		gbc_btnSort.gridx = 2;
		gbc_btnSort.gridy = 3;
		panel_1.add(btnSort, gbc_btnSort);
		
		JButton btnSort_1 = new JButton("En");
		btnSort_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				vl.sortList(false);
				Arrays.sort(list, new ENComparator());
			}
		});
		GridBagConstraints gbc_btnSort_1 = new GridBagConstraints();
		gbc_btnSort_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnSort_1.gridx = 3;
		gbc_btnSort_1.gridy = 3;
		panel_1.add(btnSort_1, gbc_btnSort_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		displayVok();
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
	
	public void Textfields(boolean enable){
		textField.setEditable(enable);
		textField_1.setEditable(enable);
	}

	private void displayVok() {
		Textfields(true);
		textField.setText("");
		textField_1.setText("");
		lblEnd.setText("");
		currentVok = getRandomVok();
		if (rdbtnDe.isSelected()) {
			textField.setText(currentVok.getdt());
		} else if(rdbtnEn.isSelected()){
			textField_1.setText(currentVok.geten());
		}
	}

	private Vokabel getRandomVok() {
		int random = (int) (Math.random() * vl.getnum());
		Vokabel selected = list[random];
		return selected;
	}

	public void initTable() {
		list = vl.getlist();
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Deutsch", "Englisch" });

		for (Vokabel v : list) {
			if (v != null) {
				model.addRow(new Object[] { v.getdt(), v.geten() });
			}
		}

		table.setModel(model);
		repaint();
	}
}
