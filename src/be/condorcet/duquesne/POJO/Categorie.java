package be.condorcet.duquesne.POJO;
import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.POJO.*;
import be.condorcet.duquesne.DAO.*;

import be.condorcet.duquesne.POJO.Configuration.Ticket;


public class Categorie 
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Categorie> cDAO = dao.getCategorieDAO();
	private String commentaire;
	private TypesCat type ;
	private int prix = 0;
	private int id = 0;
	
	private int nbrePlaceLibre;
	// je capte pas son utilité
	private int nbrPlaceMaximum;

	public enum TypesCat 
	{
		OR,
		ARGENT,
		DIAMANT,
		BRONZE
	};
	
	
	
	// ct par defaut 
	public Categorie() {}
	
	// ctr avec ts les attributs
	public Categorie(String commentaire, TypesCat type, int prix, int id,
			int nbrePlaceLibre, int nbrPlaceMaximum) {
		super();
		this.commentaire = commentaire;
		this.type = type;
		this.prix = prix;
		this.id = id;
		
		this.nbrePlaceLibre = nbrePlaceLibre;
		this.nbrPlaceMaximum = nbrPlaceMaximum;
	}
	// a l appel de ce ctr le nbre de place serz calculer
	public Categorie(TypesCat type, int prix, 
			Ticket place) 
	{
		
		
		this.type = type;
		this.prix = prix;
		
		
		this.calculPlace(type, place);
	}
	
	//(idCat,com,typeC,prix,nbre,nbre2
	
	
	public Categorie(int id,String comm,TypesCat type, int prix,int n1,
			int n2) 
	{
		
		this.id=id;
		this.type = type;
		this.prix = prix;
		this.commentaire=comm;
		this.nbrePlaceLibre=n1;
		this.nbrPlaceMaximum=n2;
	
	}
	
	public Categorie(int id, int prix)
		
	{
		
		
		this.prix = prix;
		
		this.id=id;
	}

// getter setter
	


	



	public Categorie(TypesCat type,int prix , Ticket place , Configuration conf)
	{
		Configuration cf= new Configuration();
		this.prix = prix;
		this.type = type;
	    cf=conf;
		this.calculPlace(type, place);
	}

	public String getCommentaire() {
		return this.commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

// pr recup l enum avec value of je dois taper en string
	public String getType() 
	{
		if(this.type.toString()==" ")
		{
			return " prob";
		}
		return this.type.toString();
	}


	public void setType(TypesCat type) 
	{
		this.type = type;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	


	public void setId(int id) {
		this.id = id;
	}


	


	public int getNbrePlaceLibre() {
		return nbrePlaceLibre;
	}


	public void setNbrePlaceLibre(int nbrePlaceLibre) {
		this.nbrePlaceLibre = nbrePlaceLibre;
	}


	public int getNbrPlaceMaximum() {
		return nbrPlaceMaximum;
	}


	public void setNbrPlaceMaximum(int nbrPlaceMaximum) {
		this.nbrPlaceMaximum = nbrPlaceMaximum;
	}
	
	
	
	
	@Override
	public String toString() {
		return " CAT:   " +   type + "   " + prix + "euros " ;
				//+ ", nbrePlaceLibre=" + nbrePlaceLibre + ", nbrPlaceMaximum=" + nbrPlaceMaximum + "]";
	}


	// diverses methodes 
	public void calculPlace(TypesCat type, Ticket place) 
	{
		// si 
		if(place == null) 
			{
				return ; //retourne à la méthode qui a appeler calcul..();
			}
		// init du nbre de place
		int nbre= 0;
		switch (place) 
		{
			case DEBOUT:
			nbre = 8000;
			break;
			case CIRQUE_ASSIS:
			if(type==null) 
			{
				return;//retourne à la méthode qui a appeler calcul..();
			}
			switch (type) 
			{
			case DIAMANT:
				nbre = 1000;
				break;
			case OR:
				nbre = 2000;
				break;
			case ARGENT:
				nbre = 1500;
				break;
			case BRONZE:
				nbre = 1500;
				break;
			}
			break;
		case CONCERT_ASSIS:
			if(type==null) 
			{
				return;//retourne à la méthode qui a appeler calcul..();
			}
			switch (type) 
			{
				case OR:
				nbre = 500;
				break;
				case ARGENT:
				nbre = 1500;
				break;
				case BRONZE:
				nbre= 3000;
				break;
			}
			break;
		

		}
		this.nbrePlaceLibre = nbre;
		// le nbre de place max est le nbre de place dispo c est logique donc elle sert a quoi??
		this.nbrPlaceMaximum = nbre;
	}
	
	

	public boolean create() 
	{
		boolean cat = cDAO.create(this);
		return cat;
	}
	// av les reservation le nbre de place va diminuer 
	public boolean catDown()
	{
		boolean majNbrePlce = cDAO.update(this);
		return majNbrePlce;
	}
	
	public List<Categorie> findAll()
	{
		return (List<Categorie>) cDAO.findAll(this);
				
	}
	
	public void display()
	{
		List<Categorie> list = this.findAll();
		 for(Categorie res : list) 
		 {
			 System.out.println(res);
			//JOptionPane.showMessageDialog(null," "+res);
		 }
	}

}
