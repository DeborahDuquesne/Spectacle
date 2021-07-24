package be.condorcet.duquesne.DAO;

import java.sql.Connection;





import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import be.condorcet.duquesne.POJO.*;





public class SpectacleDAO implements DAO<Spectacle> 
{

	protected Connection connect = null;
	private Statement stmt=null;
	
	public SpectacleDAO(Connection conn) 
	{
		connect = conn;
	}

	@Override
	public boolean create(Spectacle spectacle)
	{
		try {
			String insertSQL = "INSERT INTO Spectacle_ VALUES(null,'" + spectacle.getLibel()+ "','"
					+ spectacle.getNombrePlaceParClient() + "')";

			PreparedStatement statement = connect.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					spectacle.setId((int) generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
/************************************************************************************************************
 * PREMIER FINDALL SANS JOINTURE A TITRE DE TEST 
 * 
 * public List findAll(Spectacle s) 
	{
		
		List<Spectacle> liste = new ArrayList<Spectacle>();
			Statement stm = null;
			ResultSet rs = null;
			try
			{
				String sql = "Select * From spectacle_ ";
				//rs = stm.executeQuery(sql);
				rs=this.connect.createStatement().executeQuery(sql);
				while(rs.next())
				{
				// on peut bosser avec le nom des champs aussi c est au choix
					liste.add(new Spectacle(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6)
							)
							);		
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return liste;
		}
 * 
 * 
 * 
 * 
 * 
 * */	
	
/***************************************************************************************************************
 * 
 * 
 * UN SPECTACLE PROPOSE DES REPRESENTATION ON A DONC UNE JOINTURE 
 * DES REPRESENTATION ONT DES CONFIG ON A UNE AUTRE JOINTURE
 * ET LES CONFIG ON DES CATEGORIES
 * ON DOIT TOUT LIER ENSEMBLE 
 * 
 * 
 * **************************************************************************************************************/
	


	
	@Override
	public List findAll(Spectacle s) 
	{
	
		List<Spectacle> liste = new ArrayList<Spectacle>();
		
		
		List<Representation> reservList= new ArrayList<Representation>();
		
		
			Statement stm = null;
			ResultSet rs = null;
			
			
			try
			{
				String sql = "Select * From spectacle_ inner join representation_"
						+ " on spectacle_.\"id\"=representation_.\"fk_spect\"";
			
				rs=this.connect.createStatement().executeQuery(sql);
				while(rs.next())
				{
				
							/*
	
					liste.add(new Spectacle(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6)
							)
							);		
					*/
					
					int ids=Integer.parseInt(rs.getString(1));
					String libel=rs.getString(2);
					String genre=rs.getString(3);
					String urlImg=rs.getString(4);
					String desc=rs.getString(5);
					int nbreP =rs.getInt(6);	
					
					
					Spectacle sp =new Spectacle(libel,genre,urlImg,desc,nbreP);
					
					
					
					String comm = rs.getString(7);
					String  date =rs.getString(8);
				
					int idR = Integer.parseInt(rs.getString(7));
					float heureD =  Float.parseFloat(rs.getString(9));
					float heureF =Float.parseFloat(rs.getString(10));

					Representation rep =new Representation (idR,heureD,heureF,date,comm,sp);
					
					liste.add(sp);
					
					reservList.add(rep);
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			
			return liste;
		}
	@Override
	public List getAll(Spectacle s) 
	{
		
		List<Spectacle> liste = new ArrayList<Spectacle>();
		List<Reservation> reservList= new ArrayList<Reservation>();
			Statement stm = null;
			ResultSet rs = null;
			try
			{
				String sql = "Select * From spectacle_ ";
				//rs = stm.executeQuery(sql);
				rs=this.connect.createStatement().executeQuery(sql);
				while(rs.next())
				{
				// on peut bosser avec le nom des champs aussi c est au choix
					liste.add(new Spectacle(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6)
							)
							);		
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return liste;
		}
	
	@Override
	public boolean delete(Spectacle obj) {
		return false;
	}

	@Override
	public boolean update(Spectacle obj) {
		return false;
	}

	@Override
	public Spectacle find(Spectacle obj) {
		return null;
	}


	
	@Override
	public Spectacle findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
