package be.condorcet.duquesne.POJO;

import java.sql.Date;

import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.DAO.*;
import be.condorcet.duquesne.POJO.*;

public class Representation {
	private final AbstractFactoryDAO dao =AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Representation> rDAO = dao.getRepresentationDAO();
	private float heureDebut;
	private float heureFin;
	private int id;
	private String dateRepresentation;
	private String commentaire;
	private Spectacle spectacle= new  Spectacle();

	public Representation(int id,String  dateRepresentation, float heureDebut2, float heureFin2) {
		this.id = id;
		this.dateRepresentation = dateRepresentation;
		this.heureDebut = heureDebut2;
		this.heureFin = heureFin2;
		
	}
	
	public Representation() {}
	

	

	public Representation(int id, float heureDebut, float heureFin, 
			String  dateRepresentation, String commentaire,Spectacle s) {
		
		this.id=id;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	
		this.dateRepresentation = dateRepresentation;
		this.commentaire = commentaire;
		this.spectacle=s;
	}

	
	
	public Representation(float heureDebut, float heureFin, 
			String dateRepresentation, String commentaire) {
		
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	
		this.dateRepresentation = dateRepresentation;
		this.commentaire = commentaire;
	}
	public Representation(int id,float heureDebut, float heureFin,
			String dateRepresentation, Spectacle s) {
	
		this.id=id;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	
		this.dateRepresentation = dateRepresentation;
		this.spectacle=s;
	}
	
	
	
	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

	public float getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(float heureDebut) {
		this.heureDebut = heureDebut;
	}

	public float getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(float heureFin) {
		this.heureFin = heureFin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateRepresentation() {
		return dateRepresentation;
	}

	public void setDateRepresentation(String dateRepresentation) {
		this.dateRepresentation = dateRepresentation;
	}

	@Override
	public String toString() {
		return " NO " + id + " date "+  dateRepresentation + "  id psect " ;
	}

	
// ou on donne id spectacle 
	public List<Representation> findAll ()
	{
		return (List<Representation>) rDAO.findAll(this);
	}
	//ca liste la totalité des repr
	public List<Representation>getAll ()
	{
		return (List<Representation>) rDAO.getAll(this);
	}
}
