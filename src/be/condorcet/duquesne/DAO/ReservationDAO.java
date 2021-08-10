package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import be.condorcet.duquesne.POJO.*;

public class ReservationDAO implements DAO<Reservation> {

	protected Connection con_= null;

	public ReservationDAO(Connection con) {
		con_ = con;
	}

	
	/* INSERT INTO "STUDENT03_27"."RESERVATION_" 
	 * ("acompte", "solde", "statut", "commentaire", "
	 * prix", "fk_pers", "fk_planS") VALUES ('150', '500', '
	 * ENREGISTRE', 'null', '500', '26', '42')
*/
	
	
	@Override
	public boolean create(Reservation obj)
	{
		try
        {
                      
        	PreparedStatement state = con_.prepareStatement
        			("INSERT INTO Reservation_(\"acompte\",\"solde\",\"statut\","
        					+ "\"commentaire\",\"prix\""
        					+ ",\"fk_pers\",\"fk_planS\")"
        					
        					
        					+ "VALUES (?,?,?,?,?,?,?)");
        	//Float.parseFloat(rs.getString(9));
        	state.setFloat(1, obj.getAcompte());
            state.setFloat(2, obj.getSolde());
            state.setString(3, obj.getStatut());
            
            state.setString(4, obj.getCommentaire());
      
            state.setFloat(5, obj.getPrix());
            state.setInt(6, obj.getOrganisateur().getId());
            state.setInt(7, obj.getPlanningSalle().getId());
           
            
            state.execute();
            return true;
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return false;

	}
	/************************************************************************************************
	 * 
	 * 					test de depart car double lien avc spect 
	 * 
	 ******************* ****************************************************************************/
	public List<Representation> findAll_(Representation representation) 
	{
		List<Representation> rlist= new ArrayList<Representation>();
	
		String sql = "Select * From representation_ inner join Spectacle_"
				+ " on spectacle_.\"id\"=representation_.\"fk_spect\"";
		
		try {
			ResultSet rs = this.con_.createStatement()					
					.executeQuery(sql);
							

			
			while (rs.next()) 
			
			{
				//le spectacle 
				Spectacle s = new Spectacle(
						rs.getInt(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						
						rs.getInt(12)
						);
			
				
				
				int rId = Integer.parseInt(rs.getString(1));
				String date  =rs.getString(2);
				int heureDebut = (int) Float.parseFloat(rs.getString(3));
				int heureFin = (int) Float.parseFloat(rs.getString(4));
				
				
				
				Representation r= new Representation(rId,heureDebut,heureFin, date,s);
				// ajout de la repre a la liste
				rlist.add(r);
									
				
						
			}

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//JOptionPane.showMessageDialog( null,"taille list represendao findAll avc pk spec  "+rlist.size());
    	
		return rlist;
	}
	@Override
	public boolean delete(Reservation obj) 
	{
		return false;
	}

	@Override
	public boolean update(Reservation obj) 
	{
		return false;
	}

	
	@Override
	public List<Reservation> findAll(Reservation reservation) 
	{
		return null;
		
	}

	@Override
	public Reservation find(Reservation obj) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation findById(int id) throws SQLException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll(Reservation object) 
	{
		// TODO Auto-generated method stub
		return null;
	}


	


	@Override
	public boolean create(Reservation obj, int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
