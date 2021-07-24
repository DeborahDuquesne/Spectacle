package be.condorcet.duquesne.POJO;

import be.condorcet.duquesne.DAO.AbstractFactoryDAO;
import be.condorcet.duquesne.DAO.PersonneDAO;

public class Manager extends Personne
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	protected final PersonneDAO pDAO = dao.getPersonneDAO();
	
	public final static String statut = "MANAGER";
	private int id;
	
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Manager(int id, String s, String mdp, String statut) {
		super(id, s, mdp, statut);
		// TODO Auto-generated constructor stub
	}




	public Manager(Integer id, String statut, String mdp, String speudo, String adresse, String prenom, String nom,
			String telephone, String email, int age) {
		super(id, statut, mdp, speudo, adresse, prenom, nom, telephone, email, age);
		// TODO Auto-generated constructor stub
	}




	public Manager(Integer id, String statut, String mdp, String speudo, String adresse, String prenom, String nom,
			String telephone, String email) {
		super(id, statut, mdp, speudo, adresse, prenom, nom, telephone, email);
		// TODO Auto-generated constructor stub
	}




	public Manager(String pseudo, String mdp, String nom, String prenom, String adresse, int age) {
		super(pseudo, mdp, nom, prenom, adresse, age);
		// TODO Auto-generated constructor stub
	}




	public Manager(String s, String mdp, String t, String a, String e, String n, String p, int age) {
		super(s, mdp, t, a, e, n, p, age);
		// TODO Auto-generated constructor stub
	}




	public Manager(String s, String mdp, String t, String a, String e, String n, String p) {
		super(s, mdp, t, a, e, n, p);
		// TODO Auto-generated constructor stub
	}




	public Manager(String pseudo, String mdp, String statut) {
		super(pseudo, mdp, statut);
		// TODO Auto-generated constructor stub
	}




	@Override
	public boolean register() 
	{
		return pDAO.create(((Manager) this));
	}
	
	
	
}
