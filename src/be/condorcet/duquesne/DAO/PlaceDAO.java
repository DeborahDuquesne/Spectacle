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
/*INSERT INTO "STUDENT03_27"."PLACE_"
 *  ("prix", "fk_commande", "fk_representation", "type_place") VALUES ('500', '181', '101', 'OR')
*/

	@Override
	public boolean create(Place Place) 
	{
		return false;
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
