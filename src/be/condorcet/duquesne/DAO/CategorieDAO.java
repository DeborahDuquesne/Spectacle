package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Configuration;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;

public class CategorieDAO implements DAO<Categorie> 
{

	protected Connection connect = null;
	private Statement stmt=null;
	
	public  CategorieDAO(Connection conn) 
	{
		connect = conn;
	}
	@Override
	public boolean create(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Categorie find(Categorie obj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Categorie> findAll(Categorie obj) {

		List<Categorie> liste = new ArrayList<Categorie>();
			Statement stm = null;
			ResultSet rs = null;
			try
			{
				String sql = "Select * From categorie_ ";
				//rs = stm.executeQuery(sql);
				rs=this.connect.createStatement().executeQuery(sql);
				while(rs.next())
				{
					
					int idCat = Integer.parseInt(rs.getString(1));
					String com = rs.getString(2);
					TypesCat typeC= TypesCat.valueOf(rs.getString(3));
					int prix = (int) Float.parseFloat(rs.getString(4));
					int nbre = (int) Float.parseFloat(rs.getString(5));
					int nbre2 = (int) Float.parseFloat(rs.getString(6));
				// on peut bosser avec le nom des champs aussi c est au choix
					liste.add(new Categorie(idCat,com,typeC,prix,nbre,nbre2
							
							
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
	public List getAll(Categorie object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Categorie findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean create(Categorie obj, int id) {
		// TODO Auto-generated method stub
		return false;
	}
}


