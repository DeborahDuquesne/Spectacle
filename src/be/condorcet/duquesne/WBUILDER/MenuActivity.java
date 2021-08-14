package be.condorcet.duquesne.WBUILDER;


import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import be.condorcet.duquesne.POJO.*;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class MenuActivity extends JFrame 
{

	private Spectacle s;
	
	
	private JPanel contentPane;
	private Personne personne;
	private JPanel panel;
	private MenuActivity activity;
	
	private  JButton btnCommandes= new JButton();
	private JButton btnReservation = new JButton();
	
	
	private JComboBox <Artiste> ArtistesCb;;
	private JComboBox <Spectacle> SpectacleC;;
	
	
	private JComboBox <Representation> representationsCb;
	// le menu va dependre de qui se connecte un client aura des cdes des reservations alors qu un orga aura d autres options
	
	public MenuActivity(Personne personne) 
	{
		this.personne = personne;
		activity = this;
		
		ArtistesCb= new JComboBox<Artiste>();
		representationsCb= new JComboBox<Representation>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel() 
		{
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity
						.class.getResource("/be/condorcet/duquesne/IMG/s2.jpg"));
						g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(20, -13, 662, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		
	
		JButton btnRetour = new JButton("DECONNEXION");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainActivity page = new MainActivity();
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnRetour.setForeground(Color.BLACK);
		btnRetour.setBackground(Color.RED);
		btnRetour.setBounds(445, 322, 207, 57);
		panel.add(btnRetour);


		
								
	JLabel lblType = new JLabel("BONJOUR  : " 
		+" " + personne.getStatut() + "  "
	+" " +personne.getEmail()
												
           );
	lblType.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
	lblType.setForeground(Color.WHITE);
lblType.setBounds(92, 11, 563, 74);
panel.add(lblType);

/* test debug                     
JButton test = new JButton("tttt");
test.setBounds(467, 143, 89, 23);
panel.add(test);
test.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent arg0) 
	{
		JOptionPane.showMessageDialog(null,"relist de getlistby  "+personne.getId());
		JOptionPane.showMessageDialog(null,"relist de getlistby  "+personne.getNom());
		JOptionPane.showMessageDialog(null,"relist de getlistby  "+personne.getSpeudo());
		
	}
});
 */

loadMenu();

	}

								
	
	

	public void loadMenu() 
	{
		switch (personne.getStatut()) 
		{
			case "CLIENT":
				clientMenu();
				break;
			case "ORGANISATEUR":
	
				MenuOrganisateur();
				break;
			case "MANAGER":
				ManagerMenu() ;
				break;
			
		}
	}
	
	public void MenuOrganisateur()
	{
		// org 
		
				JButton btnSalle = new JButton("RESERVATION DE SALLE DE SPECTACLE");
				 btnSalle.setFont(new Font("Tahoma", Font.BOLD, 14));
				 btnSalle.setForeground(Color.WHITE);
				 btnSalle.setBackground(Color.RED);
				
				 btnSalle.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						/*l orga loue des salles cette page les configure*/
						
						ReservationSalle page = new ReservationSalle(personne);
						page.setVisible(true);
						activity.dispose();
					}
				});
				 btnSalle.setBounds(10, 209, 362, 46);
				panel.add( btnSalle);
				btnReservation.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
	}
	public void ManagerMenu() 
	{
		
	}
	public void clientMenu()
	{
	
		btnCommandes = new JButton("MON PANIER");
		btnCommandes.setForeground(Color.BLACK);
		btnCommandes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCommandes.setBackground(Color.RED);
		btnCommandes.setBounds(0, 322, 214, 57);
		panel.add(btnCommandes);

		JButton btnSpectacle = new JButton("Liste des spectacles propos\u00E9s");
		btnSpectacle.setBackground(Color.RED);
		btnSpectacle.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 14));
		btnSpectacle.setForeground(Color.BLACK);
		
		btnSpectacle.setBounds(10, 129, 341, 67);
		//setBounds(33, 188, 285, 45);
		panel.add(btnSpectacle);
		
		btnReservation=new JButton("MES RESERVATIONS");
		btnReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReservation.setBackground(Color.RED);
		btnReservation.setForeground(Color.BLACK);
		btnReservation.setBounds(206, 322, 244, 57);
		
		panel.add(btnReservation);
		btnSpectacle .addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{//
				ListingSpectacle page = new ListingSpectacle (personne);
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnCommandes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ListingCommande page = new ListingCommande(personne);
				page.setVisible(true);
				activity.dispose();
			}
		});
		
	}
}