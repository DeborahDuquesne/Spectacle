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

import javax.swing.JOptionPane;

import be.condorcet.duquesne.POJO.*;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;
import be.condorcet.duquesne.POJO.Configuration.Ticket;

public class SpectacleDAO implements DAO<Spectacle> 
{

	protected Connection connect = null;
	private Statement stmt=null;
	public SpectacleDAO(Connection conn) 
	{
		connect = conn;
	}
/*INSERT INTO "STUDENT03_27"."SPECTACLE_" ("libel", 
 * "genre", "description", 
 * "nbrePlaceParClient") VALUES ('marc lavoine', 'acoustique varié', 'a decouvrir', '5000')
*/
	@Override
	public boolean create(Spectacle spectacle)
	{
		try {
			String insertSQL = "INSERT INTO Spectacle_ VALUES("
		+ spectacle.getLibel()+ "','" + spectacle.getGenre()+ "','"
		+ spectacle.getNombrePlaceParClient() + "')";

			PreparedStatement statement = connect.prepareStatement
					(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int oki = statement.executeUpdate();

			if (oki == 0) 
			{
				throw new SQLException("prob d insert ");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) 
			{
				if (generatedKeys.next()) 
				{
					spectacle.setId((int) generatedKeys.getLong(1));
				} else {
					throw new SQLException("prob pas d id");
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
 * ET LES CONFIG ONt DES CATEGORIES
 * ON DOIT TOUT LIER ENSEMBLE 
 * 
 * 
 * **************************************************************************************************************/
	

	@Override
	public List<Spectacle> findAll(Spectacle s) 
	{
		List<Spectacle> liste = new ArrayList<Spectacle>();
		List<Categorie> categories = new ArrayList<Categorie>();
		List<Representation> reservList= new ArrayList<Representation>();
		
		// liste a titre de test 
		
		
			Statement stm = null;
			ResultSet rs = null;
			
			try
			{
				String sql = "Select * From spectacle_ inner join representation_"
				+ " on spectacle_.\"id\"=representation_.\"fk_spect\" inner join  config_ on spectacle_.\"id\" \r\n"
				+ "= config_.\"fk_spect\""
				+ "INNER JOIN Categorie_ ON Config_.\"id\" =  categorie_.\"fk_config\"";
						
			
				rs=this.connect.createStatement().executeQuery(sql);
				while(rs.next())
				{
				
				

					
					
					 
					
/* ******************************************************************************************************************************************************
 * 
 * 
 *           
 *          		  DATA REPRESENTATION 
 *          LE SPECTABLE AURA UNE OU PLS REPRESENTATION
 *          EX LARA FABIAN AURA UN SPECTACLE LUNDI JEUDI ET SAMEDI IL FAUT DONC ALLER LES CHERCHER 
 *          LIAISON DE SPECTACLE AVEC REPRESENTION 
 *          
 *           
 *           
 **************************************************************************************************************************************************/
  
 
					int idR = Integer.parseInt(rs.getString(7));
					String comm = rs.getString(11);
					String  date =rs.getString(8);
				
					
					float heureD =  Float.parseFloat(rs.getString(9));
					float heureF =Float.parseFloat(rs.getString(10));

					Representation rep =new Representation (idR,heureD,heureF,date,comm);
					// pr test
					
					
/**************************************************************************************************************************************************
 * 
 *            
 *            
 *            		         
 *   						 CATEGORIE 
 *   						LE SPECTACLE DISPOSE DE CONFIGURTION QUI ELLES MEMES CONTIENNENT DES CATEGORIES 
 *   						EX SI ON CHOISIT ASSIS CIRQUE ON AURA DES CAT OR ARGENT ETC 
 *            
 *            
 ***************************************************************************************************************************************************/
					
					int idCat = Integer.parseInt(rs.getString(18));
					String commt= rs.getString(19);
					int prix = (int) Float.parseFloat(rs.getString(21));
					int nbrPlaceLibre = (int) Float.parseFloat(rs.getString(22));
					int nbrePlaceMax = (int) Float.parseFloat(rs.getString(23));
					//typ px cong place
					
		/*          CRETAION DE LA CATEGORI QU ON VA ALLER AFFECTER A LA CONFIG DU   SPECTACLE             */			
					
					Categorie categorie = new Categorie();
					categorie.setNbrePlaceLibre(nbrePlaceMax);
					categorie.setNbrPlaceMaximum(nbrePlaceMax);
					categorie.setCommentaire(commt);
					categorie.setId(idCat);
					categories.add(categorie);
					
					
/*****************************************************************************************************************************************************************
 * 
 * 
 * 
 * 							 DATA CATEGORIE DE LA CONFIG
 * 							LE SPECTACLE DISPOSE DE DIFFERENTES CONFIGIRATIONS IL FAUT DONC LIER LES TABLES AFIN DE LES CHERCHER 
 * 
 * 
 * 
 * 
 *****************************************************************************************************************************************************/
					
					/*     DATA   CONFIGURATION                                 */
					int idC = Integer.parseInt(rs.getString(13));
					Ticket type= Ticket.valueOf(rs.getString(14));
					String description = rs.getString(16);
					String comment= rs.getString(15);
					//id,decr,type, spectacle
					Configuration config = new Configuration(idC, description, type,comment);
					// attribution de la cat a la conf 
					config.setCategories(categories);
					
					
/************************************************************************************************************************************************                 
 * 								 DATA SPECTACLE                                                                                                         
 * 		
 *   				ATTRIBUTS DE LA TABLE SPECTACLE 
 *   
 *   
 *   
 *  ********************************************************************************************************************************************/
 
					
					int ids=Integer.parseInt(rs.getString(1));
					String libel=rs.getString(2);
					String genre=rs.getString(3);
					String urlImg=rs.getString(4);
					String desc=rs.getString(5);
					int nbreP =rs.getInt(6);	
					
					
					Spectacle sp= new Spectacle(ids,libel,genre,urlImg,desc,nbreP,rep,config);
					sp.setRep(rep);
					sp.setConfiguration(config);
					sp.setId(ids);
					
			
					
					liste.add(sp);
					
					
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			for(Spectacle res : liste) 
			 {
				// System.out.println(res);
				// JOptionPane.showMessageDialog(null," specDAO"+res);
			 }
			
			return liste;
		}
	/*simple requete dans la  table spectacle pr des besoins de test */
	
	
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
			for(Spectacle cf : liste) 
	        {
	        	
	        	//JOptionPane.showMessageDialog(null,"list    " +cf);
	        		
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
