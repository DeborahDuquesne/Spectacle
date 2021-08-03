package be.condorcet.duquesne.POJO;


import java.sql.Date;

import java.util.Calendar;
import java.util.List;

import be.condorcet.duquesne.DAO.*;
import be.condorcet.duquesne.POJO.*;

public class Reservation {
	private final AbstractFactoryDAO dao =AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Reservation> reservationDAO = dao.getReservationDAO();
	private int id ;
	private float acompte;
	private float solde;
	private float prix;
	private String statut = "actif";
	private String commentaire;
	private Personne organisateur;
	private PlanningSalle planningSalle;

	
	
	
	public Reservation(float acompte ,float solde , 
			float prix,String statut, PlanningSalle planningSalle , Personne organisateur) {
		this.acompte = acompte;
		this.solde = solde;
		this.prix = prix;
		this.statut=statut;
		this.organisateur = organisateur;
		this.planningSalle = planningSalle;
	}
	public float getAcompte() {
		return acompte;
	}
	public void setAcompte(float acompte) {
		this.acompte = acompte;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Reservation() {
	}
	
	public Reservation(float i, float j, float k,
			PlanningSalle planningSalle, Personne personne) 
	{
		this.acompte = i;
		this.solde = j;
		this.prix = k;
		
		this.organisateur=personne;
		this.planningSalle = planningSalle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrixByday(Date jourReserv) 
	{
		/*4.500 € si J est vendredi ou samedi 
 			3.000 pour les autres jours.*/
		int j=jourReserv.getDay();
		/*5 e j c est vendredi et 6 e samedi */ 
		if(j== 5 || j== 6) 
		{ 
			this.prix = 4500;
		}
		/* les autres jours */
		else
		{
			this.prix = 3000;
		}
	}
	public String getStatut() 
	{
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Personne getOrganisateur() {
		return organisateur;
	}
	public void setOrganisateur(Personne organisateur) {
		this.organisateur = organisateur;
	}
	public PlanningSalle getPlanningSalle() {
		return planningSalle;
	}
	
	public void setPlanningSalle(PlanningSalle planningSalle) {
		this.planningSalle = planningSalle;
	}
	public List<Reservation> findAll() {
		return  (List<Reservation>) reservationDAO.findAll(this);
	}
	
	@Override
	public String toString() {
		return "Reservation [acompte=" + acompte + ", solde=" + solde + ", prix=" + prix + ", statut=" + statut
				+ ", commentaire=" + commentaire + "]";
	}
	
	
	public boolean create() {		
		return reservationDAO.create(this);
	}
	
}
