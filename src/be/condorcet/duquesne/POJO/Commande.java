package be.condorcet.duquesne.POJO;

import java.util.ArrayList;
import java.util.List;

import be.condorcet.duquesne.DAO.*;

public class Commande 
{
	
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Commande> commandeDAO = dao.getCommandeDAO();
	
	
	public static enum payement 
	{ 
		VISA,
		PAYPAL,
		SEPA ,
		PAYCONIQ
	}
	/*sepa  // 7j ca   option  ne  reste 
	proposée que jusqu’à 20 jours calendrier avant la date du spectacle choisi 
	pour éviter tout retard avec la poste */
	public static enum livraison 
	{ 
		SUR_PLACE,
		TIMBRE_PRIOR,
		ENVOIE_SECURISE    // 10 e 
	}
	private List<Place> places = new ArrayList<Place>();
	private int id;
	private payement modeDePayement;
	private livraison modeDeLivraison;
	private float total;
	private String precisionCde;
	/******************************************************************************************
	 * 
	 * SELON LE SCHEMA UML LA COMMANDE EST EN RAPPORT AVEC UNE OU DES PLACES 
	 * C EST PAS DANS CDE QU ON TAPE PERSONNE OU QUE SAIS JE 
	 * 
	 *****************************************************************************************/
	Place placeCdee;
	
	public Commande(List<Place> places, int id, 
			payement modeDePayement, livraison modeDeLivraison, float total,
			String precisionCde, Place placeCdee) {
		
		this.places = places;
		this.id = id;
		this.modeDePayement = modeDePayement;
		this.modeDeLivraison = modeDeLivraison;
		this.total = total;
		this.precisionCde = precisionCde;
		this.placeCdee = placeCdee;
	}
	public Commande() {}
	
	public int getId() {
		return id;
	}
	
	
	
	public Commande(payement modeDePayement,
			String precis, 
			livraison modeDeLivraison, 
			float total, 
			Personne p) 
	{
		this.modeDePayement = modeDePayement;
		this.modeDeLivraison = modeDeLivraison;
		this.total=total;
		p=new Personne();
	}
	
	


	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	public List<Place> getPlaces() {
		return this.places;
	}
	
	public String getPrecisionCde() 
	{
		if(this.precisionCde==null || this.precisionCde==" ")
		{
			return "aucune precision pr cette cde ";
		}
		else
		return precisionCde;
	}
	public void setPrecisionCde(String precisionCde) {
		this.precisionCde = precisionCde;
	}
	public Place getPlaceCdee() {
		return placeCdee;
	}
	public void setPlaceCdee(Place placeCdee) {
		this.placeCdee = placeCdee;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getModeDePayement() 
	{
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
		if(this.modeDeLivraison == modeDeLivraison.ENVOIE_SECURISE) 
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
	public void setCout(float total) 
	{
		this.total=total;
	}
	
	public void augmenterCout(float coutSupplementaire) 
	{
		this.total += coutSupplementaire;
	}
	
	
	
	
	

	
	public List<Commande> findAll()
	{
		return (List<Commande>) this.commandeDAO.findAll(this);
	}
	@Override
	public String toString() 
	{
		return "N° "+this.id + "[ " + this.modeDeLivraison + " ]"+  "  [ "  +this.modeDePayement + " ] " 
				+"  "+  this.getPrecisionCde();
	}


	public boolean create() 
	{
		return this.commandeDAO.create(this);
	}
}
