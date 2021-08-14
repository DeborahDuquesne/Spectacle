package be.condorcet.duquesne.POJO;
import be.condorcet.duquesne.DAO.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Configuration 
{
	/*idee repr ici 
	 * https://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/*/
	public enum Ticket 
	{
		/*j attribue un nbre a la variable de l anum */
		DEBOUT(8000),
		CONCERT_ASSIS(5000),
		CIRQUE_ASSIS(6000);
		
		private int nbre;
		// ctr enum pr a l appel recup e nbre 
		private Ticket(final int nbre) 
		{
			this.nbre = nbre;
		}
		 public int getNbre() 
		 {
		        return nbre;
		 }
	}
	
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Configuration> cgDAO = dao.getConfigurationDAO();
	private String description;// libel
	private String libel;
	private List<Categorie> categoriesList;
	private Categorie cat = new Categorie();
	private Ticket type;
	
	int id;
	//private Spectacle spectacle;
	
	public Configuration() {}
	
	//pr test les req 
	public Configuration( int id,String description, 
			String libel, 
			List<Categorie> categoriesList, Ticket type)
			//Spectacle spectacle) 
{
		
		this.description = description;
		this.libel=libel;
		this.categoriesList = categoriesList;
		this.type = type;
		this.id = id;
		//this.spectacle = spectacle;
	}

	public Configuration( String description, Ticket type, Spectacle spectacle) 
			{
			super();
			this.description = description;
			
			
			this.type = type;
		
			//this.spectacle = spectacle;
			}
	public List<Categorie> getCategories()
	{
		
		return this.categoriesList;
	}
	public Categorie getCat() 
	{
		return this.cat;
	}


	public void setCat(Categorie cat) 
	{
		this.cat = cat;
	}


	public void setCategories(List<Categorie> categoriesList)
	{
		this.categoriesList= categoriesList;
	}
	public Configuration(int id,  String description, Ticket place,String libel ) 
	{
		this.id = id;
		this.description = description;
		this.type = place;
		this.libel=libel;
		
	}
	
	
	public Configuration(int id,  String description, Ticket place,String libel,Categorie cat  ) 
	{
		this.id = id;
		this.description = description;
		this.type = place;
		this.libel=libel;
		this.cat=cat;
		
	}
	
	

	public String getLibel() {
		return libel;
	}

	public void setLibel(String libel) {
		this.libel = libel;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString()
	
	{
		
		
		return " Cat list " 
				+ categoriesList + ", type=" + type + " " ;//+
				//", id cfg " + id + " "+
				//"id cat " + "  "+cat.getId() +  " " 
				//;
	}


	

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public boolean create() 
	{
		 boolean oki= cgDAO.create(this);
		 return oki;
		
	}


	public String getType() {
		if(this.type == Ticket.DEBOUT) 
			return "DEBOUT";
		else if(this.type == Ticket.CIRQUE_ASSIS)
			return "CIRQUE_ASSIS";		
		else
			return "CONCERT_ASSIS";
	}


	public void setType(Ticket type) {
		this
		
		.type = type;
	}
	// config spect cat 
	public List<Configuration> findAll()
	{
		return (List<Configuration>) cgDAO.findAll(this);
				
	}
	
	public void display()
	{
		Spectacle s = new Spectacle();
		 List<Configuration> list = this.findAll();
		 for(Configuration res : list) 
		 {
			 System.out.println(res);
			//JOptionPane.showMessageDialog(null," "+res);
		 }
		// JOptionPane.showMessageDialog(null,"id config  "+s.getConfiguration().getId());
	}
	
	
	
	
	
}
