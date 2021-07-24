package be.condorcet.duquesne.POJO;

import java.util.List;

import be.condorcet.duquesne.DAO.AbstractFactoryDAO;
import be.condorcet.duquesne.DAO.PersonneDAO;
// classe enfant qui herite de la classe personne
public class Artiste extends Personne
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	
	protected final PersonneDAO pDAO = dao.getPersonneDAO();
	private String nomArtistique;
	public final static String statut = "ARTISTE";
	private Spectacle spect;
	private Personne artiste;
	public Artiste() 
	{
		super();
		
	}
	
	
	


	public Artiste(Integer id, String statut, String mdp, String speudo, String adresse, String prenom, String nom,
			String telephone, String email, int age) {
		super(id, statut, mdp, speudo, adresse, prenom, nom, telephone, email, age);
		// TODO Auto-generated constructor stub
	}


	public  Artiste(String pseudo, String mdp, String nom, String prenom, 
			String adresse, int age,String nomArtistique) 
	{
		super(pseudo, mdp, nom, prenom, adresse, age);
		this.nomArtistique=nomArtistique;
		
	}

	public  Artiste(String s, String mdp, String t, String a, String e, String n, String p,String nomA)
	{
		super(s, mdp, t, a, e, n, p);
		this.nomArtistique=nomA;
		
		// TODO Auto-generated constructor stub
	}
	public String getNomArtistique() {
		return nomArtistique;
	}
	public void setNomArtistique(String nomArtistique) {
		this.nomArtistique = nomArtistique;
	}
	public Spectacle getSpect() {
		return spect;
	}
	public void setSpect(Spectacle spect) {
		this.spect = spect;
	}
	public Personne getArtiste() {
		return artiste;
	}
	public void setArtiste(Personne artiste) {
		this.artiste = artiste;
	}
	
	@Override
	public String toString() 
	{
		return "Artiste [nomArtistique=" + nomArtistique + "]";
	}
	
	
	@Override
	public boolean register() 
	{
		return pDAO.create(((Artiste) this));
	}





	public static List<Artiste> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
	
}
