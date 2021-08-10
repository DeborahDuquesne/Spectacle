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
	protected Connection con_ = null;
	private Statement stmt=null;
	
	public PlanningSalleDAO(Connection conn) 
	{
		con_= conn;
	}
/*
INSERT INTO "STUDENT03_27"."PLANNINGSALLE_" 
("dateDebut", "dateFin", "fk_spect", "dateReserv") VALUES ('2023-05-12', '2020-05-19', '7', '2021-06-01')

Validation (commit) effectuée

*/
	@Override
	public boolean create(PlanningSalle p) 
	{
		try 
		{
	           
		        	PreparedStatement state = con_.prepareStatement
		        			("INSERT INTO PLANNINGSALLE_(\"dateDebut\",\"dateFin\",\"fk_spect\",\"dateReserv\")"
		        					
	
		        					+ "VALUES (?,?,?,?)");
		        		state.setString(1, p.getdateDebutReservation().toString());
			            state.setString(2, p.getDateFinReservation().toString());
			            state.setInt(3,p.getSpectacle().getId());
			            state.setString(4, p.getDateReservation().toString());
			            state.execute();
			            return true;
		}

			        catch(SQLException e)
			        {
			            e.printStackTrace();
			        }
			        
			        return false;
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
	
	@Override
	public boolean create(PlanningSalle obj, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
	
	
	

}
