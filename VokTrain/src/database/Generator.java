package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.Vokabel;

public class Generator {

	private Connection connection;

	public List[] getLists() {
		connection = sqliteConnection.dbConnection();
		List[] list = new ArrayList[5];
		
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

}
