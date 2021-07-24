package be.condorcet.duquesne.POJO;

import java.util.ArrayList;
import java.util.List;

import be.condorcet.duquesne.DAO.*;

public class Commande {
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Commande> commandeDAO = dao.getCommandeDAO();
	
	public static enum payement { 
		VISA,
		PAYPAL,
		SEPA
	}
	public static enum livraison { 
		SUR_PLACE,
		TIMBRE_PRIOR,
		ENVOIE_SECURISEE
	}
	private List<Place> places = new ArrayList<Place>();
	private int id;
	private payement modeDePayement;
	private livraison modeDeLivraison;
	private float total;
	private String precisionCde;
	private Personne personne;
	public int getId() {
		return id;
	}
	public Commande() {
	}
	public Commande(payement modeDePayement, livraison modeDeLivraison, float total, Personne personne) {
		this.modeDePayement = modeDePayement;
		this.modeDeLivraison = modeDeLivraison;
		this.total=total;
		this.personne = personne;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	public List<Place> getPlaces() {
		return this.places;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModeDePayement() {
		if(this.modeDePayement == modeDePayement.PAYPAL) 
			return "PAYPAL";
		else if(this.modeDePayement == modeDePayement.VISA)
			return "VISA";		
		else
			return "SEPA";
	}
	public void setModeDePayement(payement modeDePayement) {
		this.modeDePayement = modeDePayement;
	}
	public String getModeDeLivraison() {
		if(this.modeDeLivraison == modeDeLivraison.ENVOIE_SECURISEE) 
			return "ENVOIE_SECURISEE";
		else if(this.modeDeLivraison == modeDeLivraison.TIMBRE_PRIOR)
			return "TIMBRE_PRIOR";		
		else
			return "SUR_PLACE";
	}
	public void setModeDeLivraison(livraison modeDeLivraison) {
		this.modeDeLivraison = modeDeLivraison;
	}
	public float getTotal() {
		return total;
	}
	public void setCout(float total) {
		this.total=total;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public void augmenterCout(float coutSupplementaire) {
		this.total += coutSupplementaire;
	}
	
	public boolean create() {
		return this.commandeDAO.create(this);
	}
	
	public List<Commande> findAll(){
		return (List<Commande>) this.commandeDAO.findAll(this);
	}
	@Override
	public String toString() {
		return "N° "+this.id + " " + this.modeDeLivraison + " "+ this.modeDePayement;
	}
}
