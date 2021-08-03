package be.condorcet.duquesne.WBUILDER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Commande;
import be.condorcet.duquesne.POJO.Commande.livraison;
import be.condorcet.duquesne.POJO.Commande.payement;
import be.condorcet.duquesne.POJO.Configuration;
import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.Place;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Reservation;

public class Achatactivity extends JFrame 
{
/****************************************************************
 * 				VARIABLES
 * ************************************************************/
	private JPanel contentPane;
/******************************************************************************************
 * 
 * 
 * POUR INSERER DANS LES TABLES CDES ET PLACES ON A BESOIN DE /
 * 			fk cde
 * 			fk representation
 * 			fk config pr chopper id cat
 * 			fk personne 
 * 
 * *****************************************************************************************/	
	private Personne personne;
	private Reservation currentSpectacle;
	private Representation  representation;
	private Achatactivity activity;
	private Commande commande;
	private Configuration configuration;
	private float prix ;
	
	
	private JPanel panel;
	private ButtonGroup modeLivraison = new ButtonGroup();
	private ButtonGroup modePaiement = new ButtonGroup();
	private JRadioButton rdbtnLivraisonSurPlace,
	rdbtnLivraisonTimbre, 
	rdbtnLivraisonEnvoieSecu, 
	rdbtnPaiementVisa,
	rdbtnPaiementPaypal,
	rdbtnPaiementSEPA,
	rdbtnPaiementPayconiq,
	rdbtnBc;
	
	
	private JLabel lblPrix;
	private JLabel lblPrixValue;
	private JLabel lblNewLabel_1;
	private boolean isClicked = false;
	private JButton btnRetou;
	
	int nbrBronze, nbrArgent, nbrOr , nbrDiamant , nbrBase;

	public Achatactivity(Representation representation,
			Personne personne, 
			Commande commande , 
			Configuration configuration)
	{
		activity=this;
		this.representation = representation;
		this.personne = personne;
		this.commande = commande;
		this.configuration = configuration;
		this.commande=commande;
		commande= new Commande();// a modif 
		prix = commande.getTotal();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel= new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/condorcet/duquesne/IMG/s.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(10, 60, 431, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		

		JButton btnAcheter = new JButton("Acheter");
		btnAcheter.setBackground(Color.DARK_GRAY);
		btnAcheter.setForeground(Color.WHITE);
		btnAcheter.setBounds(24, 225, 138, 40);
		btnAcheter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				payer();
			}
		});
		panel.add(btnAcheter);
		
		
		
		rdbtnLivraisonSurPlace = new JRadioButton("Sur place");
		rdbtnLivraisonSurPlace.setBackground(Color.LIGHT_GRAY);
		rdbtnLivraisonSurPlace.setBounds(24, 54, 121, 21);
		panel.add(rdbtnLivraisonSurPlace);

		rdbtnLivraisonTimbre = new JRadioButton("Envoir avec imbre prior");
		rdbtnLivraisonTimbre.setBackground(Color.LIGHT_GRAY);
		rdbtnLivraisonTimbre.setBounds(24, 86, 179, 21);
		panel.add(rdbtnLivraisonTimbre);

		rdbtnLivraisonEnvoieSecu = new JRadioButton("Envoie s\u00E9curis\u00E9 ( + \u20AC10 ) ");
		rdbtnLivraisonEnvoieSecu.setBackground(Color.LIGHT_GRAY);
		rdbtnLivraisonEnvoieSecu.setBounds(24, 117, 179, 21);
		rdbtnLivraisonEnvoieSecu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				activity.isClicked = !isClicked;
				if(isClicked) 
				{
					
					prix=prix+ 10;
					lblPrixValue.setText(Float.toString(prix));
				}
				else 
				{
				
					lblPrixValue.setText(Float.toString(prix));
				}
				
			}
		});
		panel.add(rdbtnLivraisonEnvoieSecu);

		rdbtnPaiementVisa = new JRadioButton("VISA");
		rdbtnPaiementVisa.setBackground(Color.LIGHT_GRAY);
		rdbtnPaiementVisa.setBounds(266, 54, 103, 21);
		panel.add(rdbtnPaiementVisa);

		rdbtnPaiementPaypal = new JRadioButton("PAYPALL");
		rdbtnPaiementPaypal.setBackground(Color.LIGHT_GRAY);
		rdbtnPaiementPaypal.setBounds(266, 86, 103, 21);
		panel.add(rdbtnPaiementPaypal);

		rdbtnPaiementSEPA = new JRadioButton("SEPA");
		rdbtnPaiementSEPA.setToolTipText(" \u00E0 effectuer dans les 7 jours calendrier, sinon les tickets");
		rdbtnPaiementSEPA.setBackground(Color.LIGHT_GRAY);
		rdbtnPaiementSEPA.setBounds(266, 117, 155, 21);
		panel.add(rdbtnPaiementSEPA);
		rdbtnPaiementPayconiq = new JRadioButton("PAYCONIQ");
		rdbtnPaiementPayconiq.setBackground(Color.LIGHT_GRAY);
		rdbtnPaiementPayconiq.setBounds(266, 141, 109, 23);
		panel.add(rdbtnPaiementPayconiq);
		
		rdbtnBc = new JRadioButton("BANCONTACT");
		rdbtnBc.setBackground(Color.LIGHT_GRAY);
		rdbtnBc.setBounds(260, 164, 109, 23);
		panel.add(rdbtnBc);

		JLabel lblNewLabel = new JLabel("Mode de livraison");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 30, 187, 18);
		panel.add(lblNewLabel);

		JLabel lblModeDePaiment = new JLabel("Mode de paiment");
		lblModeDePaiment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModeDePaiment.setBounds(266, 30, 155, 18);
		panel.add(lblModeDePaiment);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_1.setBounds(0, 0, 451, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel labelTitre = new JLabel("Paiement");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(10, 0, 429, 39);
		labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelTitre.setForeground(UIManager.getColor("ToggleButton.highlight"));
		panel_1.add(labelTitre);
		
		btnRetou = new JButton("Quitter");
		btnRetou.setBackground(Color.DARK_GRAY);
		btnRetou.setForeground(Color.WHITE);
		btnRetou.setBounds(353, 15, 88, 26);
		btnRetou.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				activity.dispose();
			}
		});
		panel_1.add(btnRetou);

		modeLivraison.add(rdbtnLivraisonTimbre);
		modeLivraison.add(rdbtnLivraisonSurPlace);
		modeLivraison.add(rdbtnLivraisonEnvoieSecu);
		modePaiement.add(rdbtnPaiementSEPA);
		modePaiement.add(rdbtnPaiementPaypal);
		modePaiement.add(rdbtnPaiementVisa);
		modePaiement.add(rdbtnPaiementPayconiq);
		
		lblPrix = new JLabel("Prix : ");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrix.setBounds(58, 162, 45, 21);
		panel.add(lblPrix);
		
		lblPrixValue = new JLabel("");
		lblPrixValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrixValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrixValue.setBounds(125, 163, 90, 21);
		panel.add(lblPrixValue);
		lblPrixValue.setText(Float.toString(commande.getTotal()));
		
		lblNewLabel_1 = new JLabel("( +5 \u20AC de frais de dossier )");
		lblNewLabel_1.setBounds(41, 187, 155, 13);
		panel.add(lblNewLabel_1);
		
		
		
	}

	public void payer() 
	{
		// 5 euros de frais de dossier recu en param des couts des billets
		this.commande.augmenterCout(5);
		/*en fct de ce qui sera choisi on attribue la valeur de paiement et
		 * de livraison a la cde*/
		if (rdbtnLivraisonTimbre.isSelected()) 
		{
			this.commande.setModeDeLivraison(livraison.TIMBRE_PRIOR);
		} 
		else if (rdbtnLivraisonSurPlace.isSelected()) 
		{
			this.commande.setModeDeLivraison(livraison.SUR_PLACE);
		} 
		else 
		{
			this.commande.setModeDeLivraison(livraison.ENVOIE_SECURISE);
		}

		if (rdbtnPaiementSEPA.isSelected()) 
		{
			this.commande.setModeDePayement(payement.SEPA);
		} 
		else if (rdbtnPaiementPaypal.isSelected()) 
		{
			this.commande.setModeDePayement(payement.PAYPAL);
		} 
		else if (rdbtnPaiementPayconiq.isSelected()) 
		{
			this.commande.setModeDePayement(payement.PAYCONIQ);
		} 
		else 
		{
			this.commande.setModeDePayement(payement.VISA);
		}
		
		
		boolean oki =
				this.commande.create();
		
		if(oki) 
		{
			createPlaces();
			//decomptePlace() ; // prob avc les jointures ca fonctionne pas 
			
			FinalActivityPlace page = new FinalActivityPlace();
			page.setVisible(true);
			activity.dispose();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "prob non géré car teop compliqyé a ce stade !");
		}
	}
	public void createPlaces() 
	{
		 nbrBase = 0;
		 nbrOr = 0;
		 nbrArgent = 0;
		 nbrDiamant = 0;
		 nbrBronze = 0;

		for(Place place : this.commande.getPlaces()) 
		{
			switch(place.getType_categorie()) 
			{
				
				case BRONZE : 
						nbrBronze++;
					break;
				case ARGENT : 
						nbrArgent++;
					break;
				case OR : 
						nbrOr++;
					break;
				case DIAMANT : 
						nbrDiamant++;
					break;
			}// insert place ( id,prix,fkcde,fkrepre,typepalce)
			place.create();
		}
		
	}
	public void decomptePlace() 
	{
		List<Categorie> categories = null;//configuration.getCategories();
		
		for(Categorie categorie : categories) 
		{
			//categorie.
			//setConfiguration(configuration);
			switch(categorie.getType())
			{
		
			case "BRONZE" : 
				for(int i = 0 ; i < nbrBronze ; i ++) categorie.catDown();
				break;
			case "ARGENT" : 
				for(int i = 0 ; i < nbrArgent ; i ++) categorie.catDown();
				break;
			case "OR" : 
				for(int i = 0 ; i < nbrOr ; i ++) categorie.catDown();
				break;
			case "DIAMANT" : 
				for(int i = 0 ; i < nbrDiamant ; i ++) categorie.catDown();
				break;
		}
		
		}
		
		
	}
}
