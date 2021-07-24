package be.condorcet.duquesne.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.condorcet.duquesne.POJO.Place;


public class PlaceDAO implements DAO<Place> {
	protected Connection connect = null;

	public PlaceDAO(Connection conn) {
		connect = conn;
	}


	@Override
	public boolean create(Place Place) {
		try {
			this.connect
			.createStatement()
			.executeUpdate("INSERT INTO Place VALUES("
					+ "null,'" 
					+ Place.getPrix()
					+ "','"
					+ Place.getCommande().getId()
					+ "','"
					+ Place.getRepresentation().getId()
					+ "','"
					+ Place.getType_categorie()
					+ "')"
				);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Place find(Place obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAll(Place obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll(Place object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
