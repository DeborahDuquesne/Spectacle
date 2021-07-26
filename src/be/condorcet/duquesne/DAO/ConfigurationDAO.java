package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Configuration;
import be.condorcet.duquesne.POJO.Reservation;
import be.condorcet.duquesne.POJO.Spectacle;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;
import be.condorcet.duquesne.POJO.Configuration.Ticket;


public class ConfigurationDAO implements DAO<Configuration> 
{

	protected Connection connect = null;
	private Statement stmt=null;
	
	public  ConfigurationDAO(Connection conn) 
	{
		connect = conn;
	}

	@Override
	public boolean create(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Configuration find(Configuration obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*public Configuration(String description, String commentaire, List<Categorie> categoriesList, Ticket type, int id,
			Spectacle spectacle)*/
	@Override
	public List<Configuration> findAll(Configuration obj)
	{
		List<Configuration> liste = new ArrayList<Configuration>();
		
		Statement stm = null;
		ResultSet rs = null;
			try
			{
				String sql = " select * from config_ inner join spectacle_ on  spectacle_.\"id\" =  config_.\"fk_spect\""
						+ "inner join categorie_ on categorie_.\"fk_config\"= config_.\"id\"";
				rs=this.connect.createStatement().executeQuery(sql);
				while(rs.next())
				{
				List<Categorie> categories = new ArrayList<Categorie>();
				
				int idCat = Integer.parseInt(rs.getString(12));
				String com = rs.getString(13);
				TypesCat typeC= TypesCat.valueOf(rs.getString(14));
				int prix = (int) Float.parseFloat(rs.getString(15));
				int n1 = (int) Float.parseFloat(rs.getString(16));
				int n2= (int) Float.parseFloat(rs.getString(17));
				
			
				
				
				
				//typ px cong place
			// CRETAION DE LA CATEGORI QU ON VA ALLER AFFECTER A LA CONFIG DU   SPECTACLE             		
				
				Categorie categorie =new Categorie(com,typeC,prix,idCat,n1, n2) ;
						
						
				categorie.setNbrePlaceLibre(n1);
				categorie.setNbrPlaceMaximum(n2);
				categorie.setCommentaire(com);
				categorie.setId(idCat);
				categories.add(categorie);
				
				

				
				
					/*  NE PAS TAPER N IMPRTE QUOI DS LA BASE SINON CA PLANTE SI ENUM CIRQUE_ASSIS pas taper 	ASSIS_CIRQUE ex declenchee */
					int idC = Integer.parseInt(rs.getString(1));
					Ticket type= Ticket.valueOf(rs.getString(2));
					String comms= rs.getString(3);
					String description = rs.getString(4);
					//id,decr,type, spectacle
					
				
					Configuration config = new Configuration(idC, description, type,comms,categorie);
					// attribution de la cat a la conf 
					config.setCategories(categories);
					
					//11 champs 
					liste.add(config);
					
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return liste;
	}

	@Override
	public List getAll(Configuration object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
