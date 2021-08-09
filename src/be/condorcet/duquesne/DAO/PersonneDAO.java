package be.condorcet.duquesne.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.POJO.*;

// interface DAO qui va etre implémentée
public class PersonneDAO implements DAO<Personne>
{
	protected Connection con_ = null;
	private String sql;
	// injection de dependance pour le systeme de connexion 
	public PersonneDAO(Connection con) 
	{
		con_ = con;
	}


	@Override
	public boolean delete(Personne obj) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Personne obj) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public List<?> findAll(Personne obj) 
	{
		
		return null;
	}
	// tes au debut 
	public List<Artiste> artistesFindAll()
	{
		List<Artiste> listeDesartistes = new ArrayList<Artiste>();
		
		try 
		{
			ResultSet result = this.con_
					.createStatement()
					.executeQuery("SELECT * FROM Personne_ "
							+ "WHERE \"statut\"= '" 
							+ Artiste.statut +"'" );
			/*14 ...11*/
			while(result.next()) 
			{
				listeDesartistes.add(
					new Artiste(
						
						result.getInt(1),
            			result.getString(2),
            			result.getString(3), 
            			result.getString(4),
            			result.getString(5), 
            			result.getString(6),
            			result.getString(7), 
            			result.getString(8),
            			result.getString(9),
            			
            			result.getInt("age"),
            			result.getString(10)
            			
            			
					)	
				);
				
				 
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//test debbug
		//JOptionPane.showMessageDialog( null,"taille list artiste  "+listeDesartistes.size());
		return listeDesartistes;
	}
// besoin pr la commande 
	@Override
	public Personne findById(int id) throws SQLException 
	{
		
		try {
			

			ResultSet result = this.con_
					.createStatement()
					.executeQuery("SELECT * FROM Personne_ WHERE \"id\" = "
							+ "'" + id +"'" );
							
			
			if(result.next()) 
			{
				return new Personne(result.getInt(1),
            			result.getString(2),
            			result.getString(3), 
            			result.getString(4),
            			result.getString(5), 
            			result.getString(6),
            			result.getString(7), 
            			result.getString(8),
            			result.getString(9),
            			result.getInt("age")
            			
            			
            			
            			
            			
            			
            			);  
				}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	
	// j ai des \"\" car j ai configuré ma base de données d une façon spécifique 
	
	public boolean login(Personne personne) 
	{
		try 
		{
			ResultSet result = this.con_.createStatement()
					.executeQuery("SELECT * FROM PERSONNE_ WHERE \"speudo\" = '" 
					+ personne.getSpeudo()
					+ "' AND \"statut\" ='" 
					+ personne.getStatut()
					+ "'AND \"mdp\" = '" + personne.getMdp()
					+ "'"
				);
			if (result.next()) 
			{
				return true;
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Personne find(Personne personne) 
	{
		try {
		

			ResultSet result = this.con_
					.createStatement()
					.executeQuery("SELECT * FROM Personne_ WHERE \"speudo\" = "
							+ "'" + personne.getSpeudo() +"'" );
			// test de depart 
							//+ " =  AND statut = '"+personne.getStatut()
							//+ "'AND \"Mdp\" = '" + personne.getMdp()+"'" );
			
			if(result.next()) 
			{
				return new Personne(result.getInt(1),
            			result.getString(2),
            			result.getString(3), 
            			result.getString(4),
            			result.getString(5), 
            			result.getString(6),
            			result.getString(7), 
            			result.getString(8),
            			result.getString(9),
            			result.getInt("age")
            			
            			
            			
            			
            			
            			
            			);  
				}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		return null;
	}
	// uniquement a titre de test
	public Boolean find(String pseudo, String pswd,String statut) 
	{
    	Personne p = new Personne();
    	try {
    		String sql ="SELECT * FROM Personne_ "
    				+ " =  WHERE \"speudo\" = '" + pseudo
    				+ " =  AND \"statut\" = '"+statut
    				+ "'AND \"mdp\" = '" + pswd + "'";
    		ResultSet result = this.con_.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
    ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            if(result.first())
            	p = new Personne(result.getInt("id"),
            			result.getString("speudo"),
            			result.getString("mdp"), 
            			result.getString("statut") 
            			
            			);  
            else
            	return null; // Si pas de résultat ==> retourne null sinon il renvoi valeur vide et 
            //n'est pas considérer comme null ==> Pose donc problème pour le login
    	}
    	catch(SQLException e) 
    	{
    		e.printStackTrace();
    	}
    	
    	return true;
    }
	

	
	
	
	
	
	
	
	
	/*********************************************************************************************************************************
	 *  autre technique des get pr la comande de l autre coté , a titre de test afin d essayer 
	 * @param personne
	 * @return
	 *************************************************************************************************************************************/
	public Personne find_(Personne personne)
	{
	
			try 
			{
				ResultSet result = this.con_.createStatement()
						.executeQuery("SELECT * FROM PERSONNE_ WHERE \"id\" = '" 
						+ personne.getId()
						
						+ "'"
					);
				if (result.next()) 
				{
					return new Personne(result.getInt(1),
	            			result.getString(2),
	            			result.getString(3), 
	            			result.getString(4),
	            			result.getString(5), 
	            			result.getString(6),
	            			result.getString(7), 
	            			result.getString(8),
	            			result.getString(9),
	            			result.getInt("age"));
				}

			}
			catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}
			return null;
	}
	
	public List<Personne> getAll() 
	{
		List<Personne> people=new ArrayList<Personne>();
		sql="SELECT * FROM PERSONNE_";
		try {
			ResultSet result = this.con_.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			while(result.next()) 
			{
				
				//...................test de depart effacé 
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}

		return people;
	}
	
	// fct pr creer un client
	/*INSERT INTO "STUDENT03_27"."PERSONNE_"
	 13 champs 
*/
	
	
/************************************************************************************************************************************************
 * 
 * 
 * 
 * L INSCRIPTION DU CLIENT NECESSITE TOUS LES CHAMPS DE LA TABLE PERSONNE
 * LA TABLE PERSONNE DS LA BSD COMPREND AUSSI DES CHAMPS RELATIFS A MANGER , ORGANISATEUR ET ARTISTE C EST PQ DES CHAMPS SONT MIS A NUL
 * LE CLIENT N A PAS DE NOM D ARTISTE NI DE NUM D ENTREPRISE ET ENCORE MOINS DE REFERENCE MANAGER
 * 
 * 
 * 
 * 
 * ***********************************************************************************************************************************************/	

	  public boolean create(Client obj)
	  { 
	        try
	        {
	                      
	        	PreparedStatement state = con_.prepareStatement
	        			("INSERT INTO Personne_(\"mdp\",\"speudo\",\"statut\",\"adresse\",\"telephone\""
	        					+ ",\"email\",\"prenom\",\"nom\",\"nomArtistique\",\"age\",\"nomminationEntreprise\","
	        					+ "\"nomitationManager\",\"numEntreprise\")"
	        					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        	
	            state.setString(1, obj.getMdp());
	            state.setString(2, obj.getSpeudo());
	            state.setString(3, "CLIENT");
	            
	            state.setString(4, obj.getAdresse());
	      
	            state.setString(5, obj.getTelephone());
	            state.setString(6, obj.getEmail());
	            state.setString(7, obj.getPrenom());
	            state.setString(8, obj.getNom());
	            state.setString(9, "null");
	            state.setInt(10, obj.getAge());
	            state.setString(11, "null");
	            state.setString(12, "null");
	            state.setString(13, "null");
	            
	            state.execute();
	            return true;
	        }

	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	        
	        return false;
	    }
	  /************************************************************************************************************************************************
	   * 
	   * 
	   * 
	   * L INSCRIPTION D UN ARTISTE 
	   *PAR PRINCIPE ON NE DEMANDE PAS L AGE D UN ARTISTE CA PEUT ETRE DEPLACE ET DISCRIMINATOIRE
	   *PAR CONSEQUENT LA VALEUR EST MISE A NULL
	   *ENVISAGER DE LUI ATTRIBUER UN NO ENTREPISE SI INDEPENDANT TOUT DEPEND DU CONTEXT DANS L ETAT ACTUEL LES VALEURS SONT MISES A NULLES
	   *DES MODIFICATIONS PEUVENT ETRE APPORTEES PAR LA SUITE
	   * 
	   * 
	   * 
	   * 
	   * ***********************************************************************************************************************************************/	  
	
	  
	  
	  public boolean create(Artiste obj)
	  { 
	        try
	        {
	                      
	        	PreparedStatement state = con_.prepareStatement
	        			("INSERT INTO Personne_(\"mdp\",\"speudo\",\"statut\",\"adresse\",\"telephone\""
	        					+ ",\"email\",\"prenom\",\"nom\",\"nomArtistique\",\"age\",\"nomminationEntreprise\","
	        					+ "\"nomitationManager\",\"numEntreprise\")"
	        					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        	
	            state.setString(1, obj.getMdp());
	            state.setString(2, obj.getSpeudo());
	            state.setString(3, "ARTISTE");
	            /* variable statique on la recup avec classe '.' nom variable [obj.statut] mais ca merde  donc en dur*/
	            state.setString(4, obj.getAdresse());
	      
	            state.setString(5, obj.getTelephone());
	            state.setString(6, obj.getEmail());
	            state.setString(7, obj.getPrenom());
	            state.setString(8, obj.getNom());
	            state.setString(9, obj.getNomArtistique());
	            state.setInt(10, 0);
	            state.setString(11, "null");
	            state.setString(12, "null");
	            state.setString(13, "null");
	            
	            state.execute();
	            return true;
	        }

	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	        
	        return false;
	    }
	  
	  
	  
	  /************************************************************************************************************************************************
	   * 
	   * 
	   * 
	   * L INSCRIPTION D UN ORGANISATEUR
	   *PAR PRINCIPE ON NE DEMANDE PAS L AGE D UN ARTISTE CA PEUT ETRE DEPLACE ET DISCRIMINATOIRE COMME PR ARTISTE
	   *PAR CONSEQUENT LA VALEUR EST MISE A NULL
	   *L ORGANISATEUR EST SUPOOSE ETRE UNE ENTREPRISE PAR CONSEQUENT IL POSSEDE UN NO ENTREPRISE ET UNE NOMINATION
	   *L ORGANISATEUR NE POSSEDE PAS DE REFERENCE MANAGER PAR CONSEQUENT ELLE EST A NULL
	   * 
	   * 
	   * 
	   * 
	   * ***********************************************************************************************************************************************/	  
	  
	  
	  
	  public boolean create(Organisateur obj)
	  { 
	        try
	        {
	                      
	        	PreparedStatement state = con_.prepareStatement
	        			("INSERT INTO Personne_(\"mdp\",\"speudo\",\"statut\",\"adresse\",\"telephone\""
	        					+ ",\"email\",\"prenom\",\"nom\",\"nomArtistique\",\"age\",\"nomminationEntreprise\","
	        					+ "\"nomitationManager\",\"numEntreprise\")"
	        					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        	
	            state.setString(1, obj.getMdp());
	            state.setString(2, obj.getSpeudo());
	           
	            state.setString(3,"ORGANISATEUR");
	          
	            state.setString(4, obj.getAdresse());
	      
	            state.setString(5, obj.getTelephone());
	            state.setString(6, obj.getEmail());
	            state.setString(7, obj.getPrenom());
	            state.setString(8, obj.getNom());
	            state.setString(9, "null");
	            state.setInt(10, 0);
	            state.setString(11, obj.getNominationEntreprise());
	            state.setString(12, "null");
	            state.setString(13, obj.getNumEntreprise());
	            
	            state.execute();
	            return true;
	        }

	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	        
	        return false;
	    }
	  
	  

	  /************************************************************************************************************************************************
	   * 
	   * 
	   * 
	   * L INSCRIPTION D UN MANAGER
	   *PAR PRINCIPE ON NE DEMANDE PAS L AGE D UN ARTISTE CA PEUT ETRE DEPLACE ET DISCRIMINATOIRE COMME PR ARTISTE
	   *PAR CONSEQUENT LA VALEUR EST MISE A NULL
	   *L ORGANISATEUR EST REFERENCE PAR UN NOM MANAGER 
	   *ON PEUT AUSSI ENVISAGER UN NO DE TV OU UN NOM D ENTREPRISE DE SOUS TRAITANCE DE PERSONNELS MANAGEMENT
	   *DANS L ETAT ACTUEL DES CHOSES NO ENTREPRISE ET NOMINATION ENTREPRISE SONT A NULL
	   * 
	   * 
	   * 
	   * 
	   * ***********************************************************************************************************************************************/	
	  
	  public boolean create(Manager obj)
	  { 
	        try
	        {
	                      
	        	PreparedStatement state = con_.prepareStatement
	        			("INSERT INTO Personne_(\"mdp\",\"speudo\",\"statut\",\"adresse\",\"telephone\""
	        					+ ",\"email\",\"prenom\",\"nom\",\"nomArtistique\",\"age\",\"nomminationEntreprise\","
	        					+ "\"nomitationManager\",\"numEntreprise\")"
	        					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        	
	            state.setString(1, obj.getMdp());
	            state.setString(2, obj.getSpeudo());
	           
	            state.setString(3, "MANAGER");
	          
	            state.setString(4, obj.getAdresse());
	      
	            state.setString(5, obj.getTelephone());
	            state.setString(6, obj.getEmail());
	            state.setString(7, obj.getPrenom());
	            state.setString(8, obj.getNom());
	            state.setString(9, "null");
	            state.setInt(10, 0);
	            state.setString(11, "null");
	            state.setString(12, "null");
	            state.setString(13, "null");
	            
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
	public boolean create(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List getAll(Personne object) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
