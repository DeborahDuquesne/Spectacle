package be.condorcet.duquesne.POJO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.DAO.*;


public class Spectacle {
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Spectacle> spectacleDAO = dao.getSpectacleDAO();
	private Configuration configuration=new Configuration();// important sinon valeur nulle
	private int id;
	private String libel;
	private int nombrePlaceParClient;
	private String description;
	private String genre;
	private String urlImg;
	private Representation rep;
	// prendre les representations corr au spectacle
	List<Representation> reList = new LinkedList<>();
	List<Spectacle> re = new LinkedList<>();
	
	
	
	
	public Spectacle() 
	{
		
	};
	public Spectacle(int id) {
		this.id=id;
	};

	public Spectacle(String libel, int nombrePlaceParClient,String genre) {
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.genre=genre;
	}
	public Spectacle(String libel, int nombrePlaceParClient) {
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
	}
	public Spectacle(String libel,String genre,String urlImg,String description,int nombrePlaceParClient) 
	{
		
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.genre=genre;
		this.urlImg=urlImg;
		this.description=description ;
		
	}
	public Spectacle(int id,String libel,String genre,String urlImg,String description,int nombrePlaceParClient) 
	{
		this.id=id;
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.genre=genre;
		this.urlImg=urlImg;
		this.description=description ;
		
	}
	

	public Spectacle(int id, String libel)
	{
		this.id=id;
		this.libel = libel;
		
	}

	
	public Representation getRep() 
	{
		rep = new Representation();
		return this.rep;
	}

	public void setRep(Representation rep) {
		this.rep = rep;
	}

	public String getDescription() {
		return description;
	}
	

	public List<Representation> getReList() {
		return reList;
	}
	public void setReList(List<Representation> reList) {
		this.reList = reList;
	}
	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibel() {
		return libel;
	}

	public void setLibel(String libel) {
		this.libel = libel;
	}

	public int getNombrePlaceParClient() {
		return nombrePlaceParClient;
	}

	public void setNombrePlaceParClient(int nombrePlaceParClient) {
		this.nombrePlaceParClient = nombrePlaceParClient;
	}

	public String getGenre() 
	{
		if(this.genre==null || this.genre==" ")
		{
			return "non indiqué";
		}
		else
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() 
	{
		rep= new Representation();// j ai du fre des test 
		return libel + "   " + this.getGenre(); // j utilise le getter car jai des genre nuls ainsi ça affiche un msg
		//  + "  " + rep.getId(); test 
	}
	

	public boolean create() {
		return this.spectacleDAO.create(this);

	}
// ca liste tous les spectacles 
	public List<Spectacle> findAll_ ()
	{
		return (List<Spectacle>) spectacleDAO.getAll(this);
				//.findAll(this);
	}
	public List<Spectacle> findAll()
	{
		return (List<Spectacle>) spectacleDAO.findAll(this);
				//.findAll(this);
	}
	
	
	
	public List<Representation> getRepresentationList(){
		return reList;
	}
	

	public void display()
	{
		 List<Representation> list = rep.findAll();
		 for(Representation res : list) 
		 {
			 System.out.println(res);
			// JOptionPane.showMessageDialog(null," "+res);
		 }
	}
	public void getListRepresentationBySpectacle()
	{
		rep = new Representation();
		// ca renvoie ttes les repre
        List<Representation> list = rep.findAll();
      
      //  JOptionPane.showMessageDialog( null,"taille liste repre ds spect .fd all"  +rep.findAll().size());
      
        for(Representation res : list) 
        {
        	if(res.getSpectacle().getId()==this.id)
        		this.reList.add(res);
        	}
        		
        	//JOptionPane.showMessageDialog(null,"relist de getlistby  "+reList);
        	//JOptionPane.showMessageDialog( null,"res.getspect.getid "+res.getSpectacle().getId());
        	//JOptionPane.showMessageDialog( null,"res.getSpectacle().getId() == this.id "+(res.getSpectacle().getId() == this.id));
        	
        }
        
        
	}
		


