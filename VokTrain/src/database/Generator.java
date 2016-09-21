package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import data.Vokabel;
import net.proteanit.sql.DbUtils;

public class Generator {

	private Connection connection;

	public List[] getLists() {
		connection = sqliteConnection.dbConnection();
		List[] list = new ArrayList[7];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Vokabel>();
		}

		try {
			String querry = "select * from VokableList";

			PreparedStatement pst = connection.prepareStatement(querry);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Vokabel vok = new Vokabel(rs.getString("DE"), rs.getString("EN"), rs.getInt("FOLDER"));
				list[vok.getBox()].add(vok);
			}
			rs.close();
			pst.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	}

	public void setVokBox(Vokabel currentVok, int i) {
		try {
			String querry = "UPDATE VokableList SET FOLDER = ? WHERE DE = ? AND EN = ?";

			PreparedStatement pst = connection.prepareStatement(querry);
			pst.setInt(1, i);
			pst.setString(2, currentVok.getdt());
			pst.setString(3, currentVok.geten());

			pst.execute();

			pst.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void addVokable(Vokabel v) {
		try {

			String querry = "insert into VokableList (DE,EN,FOLDER) values (?,?,?)";
			// String querry = "DROP TABLE books"; to remove Table and
			// CREATE TABLE books (author, title, publication, pages, price); to
			// create a Table
			PreparedStatement pst = connection.prepareStatement(querry);
			pst.setString(1, v.getdt());
			pst.setString(2, v.geten());
			pst.setInt(3, v.getBox());

			pst.execute();

			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public TableModel getTableModel(String order) {
		TableModel model = null;
		try {
			// SELECT * FROM VokableList ORDER BY DE ASC;
			String querry = "select * from VokableList " + order;
//			System.out.println(querry);
			PreparedStatement pst = connection.prepareStatement(querry);
			ResultSet rs = pst.executeQuery();
			model = DbUtils.resultSetToTableModel(rs);
			rs.close();
			pst.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return model;
	}

	public void deleteItem(Vokabel v) {

		try {

			String querry = "delete from VokableList where DE = ? AND EN = ?";
			PreparedStatement pst = connection.prepareStatement(querry);
			pst.setString(1, v.getdt());
			pst.setString(2, v.geten());
			pst.execute();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public ArrayList<Vokabel> getFullList() {
		connection = sqliteConnection.dbConnection();
		ArrayList<Vokabel> list = new ArrayList<Vokabel>();
		try {
			String querry = "select * from VokableList";

			PreparedStatement pst = connection.prepareStatement(querry);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Vokabel vok = new Vokabel(rs.getString("DE"), rs.getString("EN"), rs.getInt("FOLDER"));
				list.add(vok);
			}
			rs.close();
			pst.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	}

}
