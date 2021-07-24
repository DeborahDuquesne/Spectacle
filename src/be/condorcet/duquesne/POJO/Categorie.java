package be.condorcet.duquesne.POJO;
import java.sql.Date;

import be.condorcet.duquesne.POJO.*;
import be.condorcet.duquesne.DAO.*;

import be.condorcet.duquesne.POJO.Configuration.Ticket;


public class Categorie 
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Categorie> cDAO = dao.getCategorieDAO();

	public enum TypesCat 
	{
		OR,
		ARGENT,
		DIAMANT,
		BRONZE
	};
	private String commentaire;
	private TypesCat type;
	private int prix = 0;
	private int id = 0;
	private Configuration configuration;
	private int nbrePlaceLibre;
	// je capte pas son utilit�
	private int nbrPlaceMaximum;
	
	
	// ct par defaut 
	public Categorie() {}
	
	// ctr avec ts les attributs
	public Categorie(String commentaire, TypesCat type, int prix, int id, Configuration configuration,
			int nbrePlaceLibre, int nbrPlaceMaximum) {
		super();
		this.commentaire = commentaire;
		this.type = type;
		this.prix = prix;
		this.id = id;
		this.configuration = configuration;
		this.nbrePlaceLibre = nbrePlaceLibre;
		this.nbrPlaceMaximum = nbrPlaceMaximum;
	}
	// a l appel de ce ctr le nbre de place serz calculer
	public Categorie(TypesCat type, int prix, Configuration configuration,
			Ticket place) 
	{
		
		this.commentaire = commentaire;
		this.type = type;
		this.prix = prix;
		
		this.configuration = configuration;
		this.calculPlace(type, place);
	}
	

// getter setter
	


	


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

// pr recup l enum avec value of je dois taper en string
	public String getType() {
		return type.toString();
	}


	public void setType(TypesCat type) {
		this.type = type;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Configuration getConfiguration() {
		return configuration;
	}


	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
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
		return "Categorie [type=" + type + ", prix=" + prix + ", id=" + id + ", configuration=" + configuration
				+ ", nbrePlaceLibre=" + nbrePlaceLibre + ", nbrPlaceMaximum=" + nbrPlaceMaximum + "]";
	}


	// diverses methodes 
	public void calculPlace(TypesCat type, Ticket place) 
	{
		// si 
		if(place == null) 
			{
				return ; //retourne � la m�thode qui a appeler calcul..();
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
				return;//retourne � la m�thode qui a appeler calcul..();
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
				return;//retourne � la m�thode qui a appeler calcul..();
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
	public boolean update()
	{
		boolean majNbrePlce = cDAO.update(this);
		return majNbrePlce;
	}
	
	

}
