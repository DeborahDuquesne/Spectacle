package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;
import be.condorcet.duquesne.POJO.Client;
import be.condorcet.duquesne.POJO.Commande;
import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.Place;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Spectacle;
import be.condorcet.duquesne.POJO.Commande.livraison;
import be.condorcet.duquesne.POJO.Commande.payement;

public class CommandeDAO  implements DAO<Commande> 
{
	protected Connection connect = null;
	private Statement stmt=null;
	/*ctr qui instancie la connect */
	public  CommandeDAO(Connection conn) 
	{
		connect = conn;
	}
	
	
	//pr creer la cde j ai pas le choix j ai fait milles test et si on suit les liens on a pas le choix..
	PersonneDAO p =new PersonneDAO(this.connect);
	// la personne est le client qui cree la cde 
	
	

	@Override
	public boolean delete(Commande obj) 
	{
		
		return false;
	}

	@Override
	public boolean update(Commande obj) 
	{
		
		return false;
	}

	@Override
	public Commande find(Commande obj) 
	{
		
		return null;
	}
/*select * from commande_ inner join personne_ 
 * on commande_."fk_pers" = personne_."id" inner join place_ on Commande_."id"=place_."fk_commande";;*/
	
	/*la personne commande de places 3 tables jointes */
	@Override
	public List<Commande> findAll(Commande commande) 
	{
		List<Commande> cdes = new ArrayList<Commande>();
		Personne p= new Personne();

		try 
		{
			String sql = "select * from commande_ inner join personne_"
					+ " on commande_.\"fk_pers\" = personne_.\"id\""
				
					+ "inner join place_ on Commande_.\"id\"=place_.\"fk_commande\"";
			
			
			ResultSet rs = this.connect.createStatement().executeQuery(sql);
		
			while (rs.next()) 
			{
				payement paie= payement.valueOf(rs.getString(2));
				String preci= rs.getString(3);
				livraison mL= livraison.valueOf(rs.getString(4));
				Float t= rs.getFloat(5);
				
						/*trouver un truc pr id personne */
				
				cdes.add(new Commande(paie,preci,mL,t,null));
						
						
			}

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cdes;

	}

	@Override
	public List getAll(Commande object) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande findById(int id) throws SQLException 
	{
		
			return null;
		
	}

/*IMPOSSIBLE DE CREER UN COMMANDE SANS L ID DE LA PERSONNE
 * LES AUTRES ONT FAIT DES DOUBLES LIENS 
 * PAS D ID PAS DE CDE 
 * PAS DE LIEN PAS D ID
 * J AI TOUT ESSAYE IMPOSSIBLE DE CHEZ IMPOSSIBLE 
 * 
	
	/*INSERT INTO "STUDENT03_27"."COMMANDE_" 
	 * ("modePaiement", "precisionCde", "modeLivraison", "total", "fk_pers") VALUES ('SEPA', 'neant', 'SUR_PLACE', '525', '30')
*/
	
	@Override
	public boolean create(Commande obj) 
	{
		Personne p = new Personne();
		
		/*
		ResultSet result = this.connect
				.createStatement()
				.executeQuery("SELECT * FROM Personne_ WHERE \"id\" = "
						+ "'" + "qque chose qui exisre pas ds cde er qui rend impossible la req de merde " +"'" );
		*/
		
		PreparedStatement prepare = null;
		String sql = "INSERT INTO Commande_ VALUES("
				+ obj.getModeDePayement()+ "','" + obj.getModeDeLivraison()+ "','"
				+ obj.getPrecisionCde() + "','" +
				+ obj.getTotal()+ "','" +p.getId()+ "','"
				+ "')";
		try
        {
			prepare = connect.prepareStatement(sql);
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }   
        return true;
		
	
	}
/*
	/*INSERT INTO "STUDENT03_27"."COMMANDE_" 
	 * ("modePaiement", "precisionCde", "modeLivraison", "total", "fk_pers") VALUES ('SEPA', 'neant', 'SUR_PLACE', '525', '30')*/
	@Override
	public boolean create(Commande c,int id)
	{
		
		try 
		{
			PreparedStatement state = connect.prepareStatement
        			("INSERT INTO Commande_(\"modePaiement\",\"precisionCde\",\"modeLivraison\",\"total\",\"fk_pers\")"
        					

        					+ "VALUES (?,?,?,?,?)");
        		state.setString(1, c.getModeDePayement());
	            state.setString(2, c.getPrecisionCde());
	            state.setString(3,c.getModeDeLivraison());
	            state.setFloat(4, c.getTotal());
	            state.setInt(5, id);
	            state.execute();

			
		}

		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
		
		
	}

	
	


}
