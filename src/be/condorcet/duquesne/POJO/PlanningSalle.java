package be.condorcet.duquesne.POJO;

import java.sql.Date;
import java.util.Calendar;

import be.condorcet.duquesne.DAO.*;

public class PlanningSalle {
	private final AbstractFactoryDAO dao =AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<PlanningSalle> planningSalleDAO = dao.getPlanningSalleDAO();
	private int id = 0;
	private Spectacle spectacle;
	private Date dateFin;
	private Date dateDebut;

	

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public PlanningSalle(Date dateReservation , Spectacle spectacle) {
		this.dateDebut = dateReservation;
		this.dateFin= setDateFin();
		this.spectacle = spectacle;
	}



	public boolean create() {
		return this.planningSalleDAO.create(this);
	}

	public Date getdateDebutReservation() {
		return this.dateDebut;
	}
	public Date getDateFinReservation() {
		return this.dateFin;
	}
	
	public Date setDateFin() {
		Calendar c = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(c.getTimeInMillis());
		c.setTime(startDate);
		c.add(Calendar.DATE, 1);
		return new java.sql.Date(c.getTimeInMillis());
	}

	
	public Spectacle getSpectacle() {
		return this.spectacle;
	}
}
