package be.condorcet.duquesne.POJO;
import be.condorcet.duquesne.DAO.*;
import be.condorcet.duquesne.POJO.*;

import java.util.List;





public class Configuration 
{
	/*idee repr ici 
	 * https://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/*/
	public enum Ticket 
	{
		DEBOUT(8000),
		CONCERT_ASSIS(5000),
		CIRQUE_ASSIS(6000);
		
		private int nbre;
		// ctr enum
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
	private String commentaire;
	private List<Categorie> categoriesList;
	private Ticket type;
	int id;
	private Spectacle spectacle;
	
	public Configuration() {}
	
	
	public Configuration(String description, String commentaire, List<Categorie> categoriesList, Ticket type, int id,
			Spectacle spectacle) {
		super();
		this.description = description;
		this.commentaire = commentaire;
		this.categoriesList = categoriesList;
		this.type = type;
		this.id = id;
		this.spectacle = spectacle;
	}


	public List<Categorie> getCategories()
	{
		return this.categoriesList;
	}
	public void setCategories(List<Categorie> categoriesList)
	{
		this.categoriesList= categoriesList;
	}
	public Configuration(int id,  String description, Ticket place , Spectacle spectacle) 
	{
		this.id = id;
		this.description = description;
		this.type = place;
		this.spectacle  = spectacle;
	}
	

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return "Configuration [description=" + description + ", commentaire=" + commentaire + ", categoriesList="
				+ categoriesList + ", type=" + type + ", id=" + id + ", spectacle=" + spectacle + "]";
	}


	public Spectacle getSpectacle() {
		return this.spectacle;
	}

	public int getTicket() 
	{
		return 150;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public boolean create() 
	{
		boolean isConfigurationCreated = cgDAO.create(this);
		return isConfigurationCreated;
	}


	public String getType() {
		if(this.type == Ticket.DEBOUT) 
			return "DEBOUT";
		else if(this.type == Ticket.CIRQUE_ASSIS)
			return "ASSIS_CIRQUE";		
		else
			return "ASSIS_CONCERT";
	}


	public void setType(Ticket type) {
		this.type = type;
	}


	
}
