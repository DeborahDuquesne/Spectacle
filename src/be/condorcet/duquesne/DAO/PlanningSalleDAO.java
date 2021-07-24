package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import be.condorcet.duquesne.POJO.PlanningSalle;

public class PlanningSalleDAO  implements DAO<PlanningSalle> 

{
	protected Connection connect = null;
	private Statement stmt=null;
	
	public PlanningSalleDAO(Connection conn) 
	{
		connect = conn;
	}

	@Override
	public boolean create(PlanningSalle planningSalle) {
		try {
			String insertSQL ="INSERT INTO PlanningSalle_ VALUES(null,'"
					+planningSalle.getdateDebutReservation()
					+"','"
					+planningSalle.getDateFinReservation()
					+"','"
					+planningSalle.getSpectacle().getId()
					+"','"
					+planningSalle.getdateDebutReservation()
					+"')";
			PreparedStatement statement = connect.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					planningSalle.setId((int) generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
			
		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean delete(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlanningSalle find(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAll(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll(PlanningSalle object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanningSalle findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	

}
