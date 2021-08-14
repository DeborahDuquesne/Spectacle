package be.condorcet.duquesne.POJO;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.DAO.AbstractFactoryDAO;
import be.condorcet.duquesne.DAO.PersonneDAO;

// possibiit� de la taper en abstract mais alors on sait pas instancier et ca complique encore plus!!!!!!!!!!!!!!!
public class Personne 
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO
			.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	protected Connection con_ = null;
	
	protected final PersonneDAO pDAO = dao.getPersonneDAO();
	// protected car classe mere 
	protected int id;
	protected String mdp;
	protected String speudo;
	protected String adresse;
	protected String prenom;
	protected String statut;
	protected String nom;
	protected String telephone;
	protected String email;
	protected int age;
	
	
	private  List<Commande> clientCde1 = new ArrayList<Commande>();
	
	public List<Commande> getClientCde1() {
		return clientCde1;
	}
	public void setClientCde1(List<Commande> clientCde1) {
		this.clientCde1 = clientCde1;
	}



	private Commande cde;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
// ctr avec ts les arg
	public Personne(Integer id, String statut, String mdp, String speudo, String adresse, String prenom,
			String nom,String telephone,String email,int age)  
	{
		
		
		this.id = id;
		this.speudo = speudo;
		this.adresse = adresse;
		this.prenom = prenom;
		this.nom = nom;
		this.statut = statut;
		this.telephone=telephone;
		this.email=email;
		this.age=age;
	}
	public Personne(Integer id, String statut, String mdp, String speudo, String adresse, String prenom,
			String nom,String telephone,String email)  
	{
		
		
		this.id = id;
		this.speudo = speudo;
		this.adresse = adresse;
		this.prenom = prenom;
		this.nom = nom;
		this.statut = statut;
		this.telephone=telephone;
		this.email=email;
	
	}
	
	public Personne(int id, String s,String n,String statut)

	{
		this.id=id;
		this.speudo=s;
		this.mdp=mdp;
		this.statut=statut;
	}
	public Personne( String s,String mdp,String t,String a ,String e,String n, String p, int age)

	{
		
		this.speudo=s;
		this.mdp=mdp;
		this.telephone=t;
		this.adresse=a;
		this.email=e;
		this.nom=n;
		this.prenom=p;
		this.age=age;
	}
	
	public Personne( String s,String mdp,String t,String a ,String e,String n, String p)

	{
		
		this.speudo=s;
		this.mdp=mdp;
		this.telephone=t;
		this.adresse=a;
		this.email=e;
		this.nom=n;
		this.prenom=p;
		
	}
	
	
	public Personne() {}
	
	
	public Personne( String pseudo,String mdp, String statut)

	{
		
		this.speudo=pseudo;
		this.mdp=mdp;
		this.statut=statut;
	}
	
	public Personne( String pseudo,String mdp, String nom,String prenom,String adresse,int age)

	{
		
		this.speudo=pseudo;
		this.mdp=mdp;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.age=age;
		
	}
	
// pr liste client cdes 

public Personne(int id,String nom2, String prenom2, String email2, String statut2) 
	{
	    this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.statut=statut;
	
	}
/*test a cause des crasses de cde*/
public Personne(int id, String nom) 
{
	this.id=id;
	this.nom=nom;
}	
public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	

	
	// setter getter gen�r� par alt shift + s 

	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getMdp()
	{
		return mdp;
	}
	public void setMdp(String mdp) 
	{
		this.mdp = mdp;
	}
	public String getSpeudo() 
	{
		return speudo;
	}
	public void setSpeudo(String speudo) 
	{
		this.speudo = speudo;
	}
	public String getAdresse() 
	{
		return adresse;
	}
	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}
	public String getPrenom()
	{
		return prenom;
	}
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) 
	{
		this.statut = statut;
	}
	public String getTelephone() 
	{
		return telephone;
	}
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}
	public String getNom() 
	{
		return nom;
	}
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	
	@Override
	public String toString() 
	{
		return " id=" + id + ", mdp=" + mdp + ", speudo=" + speudo + ", adresse=" + adresse
				+ ", prenom=" + prenom + ", statut=" + statut + ", nom=" + nom +
				", telephone=" + telephone  ;
	}
	// methode pour l inscription qui sera redefenie ds artiste, etc 
	public boolean register() 
	{
		
		return false;
	}
	// soit comme ca soit en bool 
	public Personne loginCheck(String pseudo,String psw) 
	{
		if(pseudo!=null && psw!=null)
		{
			List<Personne> listP= pDAO.getAll();
			for(int i=0;i<listP.size();i++) 
			{
				if(listP.get(i).getSpeudo().equals(pseudo.toLowerCase()))
				{
					if(listP.get(i).getMdp().equals(psw))
					{
						return listP.get(i);
					}
				}
			}
			
		}
		return null;
	}
	public int check_log(String p,String m,String s)
	{
		List<Personne> P= pDAO.getAll();
		for(int i=0;i<P.size();i++) 
		{
			if(P.get(i).getSpeudo().equals(p.toLowerCase()))
			{
				return 2;
			}
			else if(P.get(i).getMdp().equals(m))
			{
				return 3;
			}
			else if (P.get(i).getStatut().equals(s))
			{
				return 4;
			}
		}
		
		return 1;
		
	}
	
	
	
	public boolean login() 
	{
		return this.pDAO.login(this);
	}
	/*liste des personnes par statut 	artiste*/
	
	
	public List<Artiste> findAllArtiste()
	{
		return this.pDAO. artistesFindAll();
	}
	
	 public Personne Log(String p,String m)

     {
		 if(p!=null && m!=null)
			{
				List<Personne> listP= pDAO.getAll();
				for(int i=0;i<listP.size();i++) 
				{
					if(listP.get(i).getSpeudo().equals(p.toLowerCase()))
					{
						if(listP.get(i).getMdp().equals(m))
						{
							return listP.get(i);
						}
					}
				}
				
			}
		 return null;
     }
	
  // methode de connexion
	
	
		public Personne find()  
		{
			return this.pDAO.find(this);
		}
// recherch d une personne par l id
		public Personne findById(int id ) throws SQLException
		{
			return this.pDAO.findById(this.id);
		}
		
		
		
		
		
	}
