package be.condorcet.duquesne.WBUILDER;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.*;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
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

public class MenuActivity extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private JPanel panel;
	private MenuActivity activity;
	private JButton btnReservation;
	private JButton btnCommandes;
	// le menu va dependre de qui se connecte un client aura des cdes des reservations alors qu un orga aura d autres options
	public MenuActivity(Personne personne) 
	{
		this.personne = personne;
		activity = this;

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
		panel.setBounds(24, 11, 684, 384);
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
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setBounds(311, 319, 311, 40);
		panel.add(btnRetour);


		btnReservation = new JButton("MES RESERVATION");
		btnReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReservation.setBackground(Color.RED);
		btnReservation.setForeground(Color.BLACK);
		btnReservation.setBounds(41, 246, 216, 57);
		
		panel.add(btnReservation);
		
		btnCommandes = new JButton("MON PANIER");
		btnCommandes.setForeground(Color.BLACK);
		btnCommandes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCommandes.setBackground(Color.RED);
		btnCommandes.setBounds(41, 302, 216, 57);
		panel.add(btnCommandes);
								
										JLabel lblType = new JLabel("VOTRE STATUT EST  : " 
												+"" + personne.getStatut() + " "
												
												+" NOM: " +personne.getEmail()
												
												);
										lblType.setBounds(100, 11, 484, 74);
										panel.add(lblType);
										
										lblType.setHorizontalAlignment(SwingConstants.RIGHT);
										lblType.setForeground(Color.BLACK);
										lblType.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		
		
		loadMenu();

	}

	public void loadMenu() 
	{
		switch (personne.getStatut()) 
		{
		case "CLIENT":
			clientMenu();
			break;
		case "ORAGNISAEUR":

			MenuOrganisateur();
			break;
		case "MANAGER":
			//initClientDashboard();
			break;
		
		}
	}

	public void clientMenu() 
	{
		JButton btnSpectacle = new JButton("Liste des spectacles propos\u00E9s");
		btnSpectacle.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 14));
		btnSpectacle.setForeground(Color.DARK_GRAY);
		
		btnSpectacle.setBounds(20, 28, 222, 57);
		//setBounds(33, 188, 285, 45);
		panel.add(btnSpectacle);
		
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
				//ListeCommandes page = new ListeCommandes(personne);
				//page.setVisible(true);
			}
		});
		
	}

	public void MenuOrganisateur() 
	{
		JButton btnLocation = new JButton("RESERVATION DE SALLE DE SPECTACLE");
		btnLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLocation.setForeground(Color.WHITE);
		btnLocation.setBackground(Color.RED);
		
		btnLocation.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ReservationSalleSpectacle page = new ReservationSalleSpectacle(personne);
			//	page.setVisible(true);
				activity.dispose();
			}
		});
		btnLocation.setBounds(58, 74, 220, 57);
		panel.add(btnLocation);
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ReservationOrganisateur page = new ReservationOrganisateur(personne);
				//page.setVisible(true);
				activity.dispose();
			}
		});
	}
}