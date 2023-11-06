package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	// Model of connection

	// Params of connection
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda";
	private String user = "root";
	private String password = "6076";

	// Method of connection
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void insertContact(JavaBeans data) {
		String createSQL = "insert into contatos (nome, fone, email) values (?, ?, ?)";
		try {
			Connection con = connect();

			PreparedStatement pst = con.prepareStatement(createSQL);

			pst.setString(1, data.getNome());
			pst.setString(2, data.getFone());
			pst.setString(3, data.getEmail());

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<JavaBeans> findAll() {
		String readSQL = "select * from contatos order by nome";
		List<JavaBeans> contacts = new ArrayList<>();
		try {
			Connection con = connect();

			PreparedStatement pst = con.prepareStatement(readSQL);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String id = rs.getString(1);
				String name = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				contacts.add(new JavaBeans(id, name, fone, email));
			}
			con.close();
			return contacts;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
