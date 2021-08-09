package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

import be.condorcet.duquesne.POJO.Artiste;
import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Configuration;
import be.condorcet.duquesne.POJO.Configuration.Ticket;
import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.PlanningSalle;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Reservation;
import be.condorcet.duquesne.POJO.Spectacle;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import com.toedter.components.JLocaleChooser;
import javax.swing.JTextArea;

public class ReservationSalle extends JFrame 
{

	private JPanel contentPane;
	private Personne personne;
	/*lors de la loca on a besoin type de place , des artistes et d un spectacle et d une repr*/
	Spectacle spectacle = new Spectacle();
	List<Representation> representationList = new ArrayList<Representation>();
	List<Artiste> artisteList= new ArrayList<Artiste>();
	List<Artiste> artisteSlect = new ArrayList<Artiste>();
	private Ticket place = Ticket.DEBOUT;
	// pr l add spect 
	private JTextField titre;
	private JTextField genre;
	private JTextField descrip;
	private JTextArea desSp;
	private JSpinField HD,HF;// crasse de spinner prb avec les float vive builder de merde 
	private JPanel panel;
	private JLabel labelOr, labelDiamant;
	private JLabel labelArtiste;
	private JTextPane descriptionField;
	JButton AddSpectacle;
	private int maxParPersonne;
	
	private JCalendar date,date1,date2;
	private JLabel labelHeureMin;
	private JLabel labelArtiste_2;
	private JButton addR;
	private JLabel lblNewLabel;
	private JLabel adj;
	private JLabel adj2;

	private JComboBox<Artiste> cbArtiste;
	private JButton choix;
	private ReservationSalle activity;
	private JTextField textPx;
	private JSpinner  nbreMaxClient;
	private JTextField textField_1;

	
	
	public ReservationSalle(Personne org) 
	{
		
			activity = this;

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 562, 698);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			panel = new JPanel() 
			{
				public void paintComponent(Graphics g) {
					Image img = Toolkit.getDefaultToolkit()
							.getImage(MainActivity
							.class.getResource("/be/condorcet/duquesne/IMG/rs.jpg"));
							g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			panel.setBounds(0, 11, 536, 683);
			contentPane.add(panel);
			panel.setLayout(null);

			JButton btnR = new JButton("REVENIR AU MENU ");
			btnR.setBackground(Color.DARK_GRAY);
			btnR.setForeground(Color.WHITE);
			btnR.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) {
					MenuActivity page = new MenuActivity(personne);
					page.setVisible(true);
					activity.dispose();
				}
			});
			btnR.setBounds(0, 620, 258, 27);
			panel.add(btnR);

			JLabel title = new JLabel("DATE DEBUT: ");
			title.setHorizontalAlignment(SwingConstants.LEFT);
			title.setForeground(Color.RED);
			title.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
			title.setBounds(31, 66, 205, 20);
			panel.add(title);

			titre = new JTextField();
			titre.setBounds(116, 2, 295, 20);
			panel.add(titre);
			titre.setColumns(10);

			JLabel labelTitre = new JLabel("SPECTACLE:");
			labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitre.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 13));
			labelTitre.setForeground(Color.RED);
			labelTitre.setBounds(0, 2, 104, 20);
			panel.add(labelTitre);

			

			
			
			

			JLabel labelPrix = new JLabel("Prix");
			labelPrix.setHorizontalAlignment(SwingConstants.CENTER);
			labelPrix.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 14));
			labelPrix.setForeground(Color.BLACK);
			labelPrix.setBounds(10, 546, 90, 27);
			panel.add(labelPrix);

			
			JLabel nbre = new JLabel("Nombre Max par client");
			nbre.setHorizontalAlignment(SwingConstants.CENTER);
			nbre.setBounds(31, 278, 131, 26);
			panel.add(nbre);
			
			nbreMaxClient = new JSpinner();
			nbreMaxClient.setBounds(31, 303, 102, 20);
			panel.add(nbreMaxClient);
			
			JLabel lblNewLabel_1 = new JLabel("Type configuration");
			lblNewLabel_1.setForeground(Color.RED);
			lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(355, 465, 183, 20);
			panel.add(lblNewLabel_1);
			
			textPx = new JTextField();
			textPx.setBounds(0, 571, 104, 20);
			panel.add(textPx);
			textPx.setColumns(10);
			
			JButton add = new JButton("AJOUTER");
			add.setBackground(Color.DARK_GRAY);
			add.setBounds(265, 620, 273, 27);
			panel.add(add);
			add.addActionListener(e -> 
			{
				
				//addRepresentation();
				//JOptionPane.showMessageDialog(null, "representation ajoutée ");
				
			});
			
			date = new JCalendar();
			date.setBounds(31, 107, 205, 153);
			panel.add(date);
			date2 = new JCalendar();
			date2.setBounds(279, 107, 205, 153);
			panel.add(date2);
			
			JLocaleChooser localeChooser = new JLocaleChooser();
			localeChooser.setBounds(31, 89, 205, 20);
			panel.add(localeChooser);
			
			JLabel lblNewLabel_2 = new JLabel("ARTISTE");
			lblNewLabel_2.setForeground(Color.RED);
			lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(373, 278, 127, 20);
			panel.add(lblNewLabel_2);

			JComboBox cbConfig = new JComboBox();
			cbConfig.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 11));

			cbConfig.setModel(new DefaultComboBoxModel(Ticket.values()));

			cbConfig.setBounds(355, 479, 180, 26);
			panel.add(cbConfig);
			cbConfig.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					place = (Ticket) cbConfig.getSelectedItem();
					
				}
			});
			
			AddSpectacle = new JButton("Ajouter Spectacle");
			AddSpectacle.setBounds(421, 2, 117, 20);
			panel.add(AddSpectacle);
			
			AddSpectacle.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					addSpectacle() ;
					
				}
			});
			
			
			try
			{
				String titre_ = titre.getText();
				 spectacle.setLibel(titre_);
				 Spectacle oki = spectacle.check();
				// JOptionPane.showMessageDialog(null, "id spect selon libel "+spectacle.check());
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			artisteList() ;
			createArtistes() ;
			
			
		
		}
	
	/*  LISTE D  ARTISTES */
	
	private void artisteList() 
	{
		// liste de ts es artistes
		Personne personne= new Personne();/*****/
		artisteList = personne.findAllArtiste();
				
		choix = new JButton("CHOISIR");
		choix.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 11));
		choix.setForeground(Color.BLACK);
		choix.setBackground(Color.DARK_GRAY);
		choix.setBounds(233, 281, 102, 26);
		choix.addActionListener(new ActionListener() 
		{
			/* l org fera des choix d artistes qui seront ajoutés a la liste des choix d artistes */ 
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Artiste artiste = (Artiste) cbArtiste.getSelectedItem();
				artisteSlect.add(artiste);
				//pr ne pas les choisir deux fois on les supprme de la selecttion on peut pas etre deux fois au meme endroit en tte logique 
				cbArtiste.removeItem(cbArtiste.getSelectedItem());
			}
		});
		panel.add(choix);
		setIdArtiste(artisteList);
	}

	private void setIdArtiste(List<Artiste> artistes)
	{
		cbArtiste = null;
		cbArtiste = new JComboBox<Artiste>();
		for (Artiste artiste : artistes) 
		{
			cbArtiste.addItem(artiste);
		}
		cbArtiste.setBounds(337, 296, 201, 27);
		panel.add(cbArtiste);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 351, 224, 56);
		panel.add(textArea_1);
		
		JLabel lblNewLabel_3 = new JLabel("DESCRIPTION REPRESENTATION");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 334, 224, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENRE : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(0, 28, 63, 27);
		panel.add(lblNewLabel_4);
		
		genre = new JTextField();
		genre.setBounds(62, 30, 148, 20);
		panel.add(genre);
		genre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Description Spectacle");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(220, 32, 148, 19);
		panel.add(lblNewLabel_5);
		
		desSp = new JTextArea();
		desSp.setBounds(341, 44, 194, 36);
		panel.add(desSp);
		
		JLabel lblNewLabel_6 = new JLabel("Heure Debut");
		lblNewLabel_6.setBounds(10, 402, 92, 20);
		panel.add(lblNewLabel_6);
		
		JLabel HeureFin = new JLabel("Heure Fin");
		HeureFin.setBounds(172, 402, 92, 20);
		panel.add(HeureFin);
		
	   
		
		adj = new JLabel("Aujourd'hui: ");
		adj.setBounds(295, 368, 211, 14);
		panel.add(adj);
		adj.setText(date.getDate().toString());
		
		adj2 = new JLabel("Aujourd'hui: ");
		adj2.setBounds(295, 393, 211, 14);
		panel.add(adj2);
		adj2.setText(date2.getDate().toString());
		
		/***********************************************************************************************************************
		 * 
		 * 			PAS DE MEILLEUR SYSTEME POUR LE CHOIX DES DATES
		 * 			ENVISAGER SWITCH DES DATES POUR BIEN DISSOCIER DATE DEBUT ET DATE FIN 
		 * 
		 * ********************************************************************************************************************/
		date.addPropertyChangeListener(new PropertyChangeListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) 
			{
				adj.setText(date.getDate().toLocaleString());
			}
		});
		date2.addPropertyChangeListener(new PropertyChangeListener() 
		{
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) 
			{
				adj2.setText(date2.getDate().toLocaleString());
			}
		});
		
		
		
		setR();
		if(setR())
		{
			//JOptionPane.showMessageDialog(null, "add R oki ");
		}
		
		
		
		
		
		
		

	}
	/*		AJOUT ARTISTE 			*/
	
	private void createArtistes() 
	{
		for (Artiste artiste : artisteSlect) 
		{
			
			artiste.setSpect(spectacle);

			artiste.create();
		}
	}
	
	private boolean addSpectacle() 
	{
		//INSERT INTO Spectacle_(\"libel\",\"genre\",\"description\",\"nbrePlaceParClient\")"
		String titre_ = titre.getText();
		String genre_= genre.getText();
		String description_=desSp.getText();
		spectacle.setLibel(titre_);
		spectacle.setGenre(genre_);
		spectacle.setDescription(description_);
		spectacle.setNombrePlaceParClient((Integer) nbreMaxClient.getValue());
		
		spectacle.create();
		
		
		
		// fctionne
		return true;
	}
	
	
	private Date getDate() 
	{
		java.util.Date day = date.getDate();
		return new java.sql.Date(day.getTime());
	}
	
	
	
	private boolean setR() 
	{
		addR = new JButton("Ajouter representation");
		addR.setForeground(Color.BLACK);
		addR.setBackground(Color.WHITE);
		addR.setBounds(247, 427, 180, 27);
		addR.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				float heureD= HD.getValue();	
				float heureF=  HF.getValue() ;
				java.util.Date u = date.getDate();
				
				
				java.sql.Date date = new java.sql.Date(u.getTime());
				
				
				representationList.add(new Representation
						(date, heureD, heureF, spectacle));

				
						
			}
		});
		panel.add(addR);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 515, 90, 20);
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(97, 515, 102, 20);
		panel.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(157, 515, 117, 20);
		panel.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(220, 515, 129, 20);
		panel.add(spinner_3);
		
		JLabel lblNewLabel_7 = new JLabel("DIAMANT");
		lblNewLabel_7.setBounds(21, 491, 63, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("ARGENT");
		lblNewLabel_8.setBounds(116, 491, 46, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("OR");
		lblNewLabel_9.setBounds(285, 491, 46, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("BRONZE");
		lblNewLabel_10.setBounds(204, 491, 46, 14);
		panel.add(lblNewLabel_10);
		
		JButton addP = new JButton("planning");
		addP.setBounds(437, 429, 89, 23);
		panel.add(addP);
		
		
		HD = new JSpinField();
		HD.setBounds(0, 433, 121, 20);
		panel.add(HD);
		
		HF = new JSpinField();
		HF.setBounds(97, 433, 139, 20);
		panel.add(HF);
		
		
		
		JLabel dateFin = new JLabel("DATE FIN: ");
		dateFin.setForeground(Color.RED);
		dateFin.setBounds(283, 92, 201, 14);
		panel.add(dateFin);
		addP.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					addPlanning();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				activity.dispose();
			}
		});
		
		
		
		
		
		
		return true;
	}
	private void addRepresentation()
	{
		for (Representation representation : representationList)
		{
			representation.create();
		}
	}
	
	
	private PlanningSalle addPlanning() throws ParseException
	{
		// pr obtenir la date ou l on fait la reserva de salle
		Date date = getDate();
		Date date2=getDate();
		String d1=adj.getText();
		
		
		
		//public PlanningSalle( Date dateFin, Date dateDebut, Date dateReservation,Spectacle spectacle) 
		PlanningSalle p= new PlanningSalle(date2,date,date,spectacle);
				//(date, spectacle);
		p.create();
		return p;
	}

	private void creerReservation(PlanningSalle planningSalle) {
		Reservation reservation = new Reservation(0, 0, 0, planningSalle, this.personne);
		//reservation.setPrix(getDate());
		reservation.create();
	}
}
	
		

