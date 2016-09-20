

import javax.swing.JApplet;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;



public class Frame extends JApplet {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private Vokabellist vl = new Vokabellist();
	private Vokabel[] list = vl.getlist();
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean de = true;
	private Vokabel currentVok;
	private JLabel lblEnd;

	public Frame() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblDe = new JLabel("De");
		GridBagConstraints gbc_lblDe = new GridBagConstraints();
		gbc_lblDe.anchor = GridBagConstraints.EAST;
		gbc_lblDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblDe.gridx = 0;
		gbc_lblDe.gridy = 0;
		panel_1.add(lblDe, gbc_lblDe);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkVok();
			}
		});
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.fill = GridBagConstraints.VERTICAL;
		gbc_btnGo.gridheight = 2;
		gbc_btnGo.insets = new Insets(0, 0, 5, 0);
		gbc_btnGo.gridx = 3;
		gbc_btnGo.gridy = 0;
		panel_1.add(btnGo, gbc_btnGo);

		JLabel lblEn_1 = new JLabel("En");
		GridBagConstraints gbc_lblEn_1 = new GridBagConstraints();
		gbc_lblEn_1.anchor = GridBagConstraints.EAST;
		gbc_lblEn_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEn_1.gridx = 0;
		gbc_lblEn_1.gridy = 1;
		panel_1.add(lblEn_1, gbc_lblEn_1);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 1;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		lblEnd = new JLabel("End");
		GridBagConstraints gbc_lblEnd = new GridBagConstraints();
		gbc_lblEnd.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnd.gridwidth = 4;
		gbc_lblEnd.gridx = 0;
		gbc_lblEnd.gridy = 2;
		panel_1.add(lblEnd, gbc_lblEnd);

		JRadioButton rdbtnEn = new JRadioButton("En");
		rdbtnEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		buttonGroup.add(rdbtnEn);
		GridBagConstraints gbc_rdbtnEn = new GridBagConstraints();
		gbc_rdbtnEn.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEn.gridx = 1;
		gbc_rdbtnEn.gridy = 3;
		panel_1.add(rdbtnEn, gbc_rdbtnEn);

		JRadioButton rdbtnDe = new JRadioButton("De");
		rdbtnDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rdbtnDe);
		rdbtnDe.setSelected(true);
		GridBagConstraints gbc_rdbtnDe = new GridBagConstraints();
		gbc_rdbtnDe.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDe.gridx = 2;
		gbc_rdbtnDe.gridy = 3;
		panel_1.add(rdbtnDe, gbc_rdbtnDe);

		JButton btnNewVokable = new JButton("new vokable");
		btnNewVokable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayVok();
			}
		});
		GridBagConstraints gbc_btnNewVokable = new GridBagConstraints();
		gbc_btnNewVokable.gridwidth = 4;
		gbc_btnNewVokable.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewVokable.gridx = 0;
		gbc_btnNewVokable.gridy = 4;
		panel_1.add(btnNewVokable, gbc_btnNewVokable);

		JPanel panel = new JPanel();
		GridBagLayout gBagLayout = new GridBagLayout();
		gBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gBagLayout);
		tabbedPane.addTab("New tab", null, panel, null);

		JLabel lblDt = new JLabel("dt:");
		GridBagConstraints gbc_lblDt = new GridBagConstraints();
		gbc_lblDt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDt.gridx = 0;
		gbc_lblDt.gridy = 0;
		panel.add(lblDt, gbc_lblDt);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridheight = 2;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 0;
		panel.add(btnSave, gbc_btnSave);

		JLabel lblEn = new JLabel("en:");
		GridBagConstraints gbc_lblEn = new GridBagConstraints();
		gbc_lblEn.insets = new Insets(0, 0, 5, 5);
		gbc_lblEn.gridx = 0;
		gbc_lblEn.gridy = 1;
		panel.add(lblEn, gbc_lblEn);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JButton btnLoadList = new JButton("load List");
		GridBagConstraints gbc_btnLoadList = new GridBagConstraints();
		gbc_btnLoadList.gridwidth = 3;
		gbc_btnLoadList.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoadList.gridx = 0;
		gbc_btnLoadList.gridy = 2;
		panel.add(btnLoadList, gbc_btnLoadList);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panel.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		btnLoadList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initTable();

			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vl.addtoList((new Vokabel(textField.getText(), textField_1.getText())));
			}
		});
		displayVok();
	}

	public void checkVok() {

		if (currentVok.getdt().equals(textField_2.getText()) && currentVok.geten().equals(textField_3.getText())) {
			lblEnd.setText("richtig!! ;o)");
			displayVok();
		} else {
			lblEnd.setText("falsch :o(");
		}

	}

	private void displayVok() {
		currentVok = getRandomVok();
		if (de) {
			textField_2.setText(currentVok.getdt());
		} else {
			textField_3.setText(currentVok.geten());
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
