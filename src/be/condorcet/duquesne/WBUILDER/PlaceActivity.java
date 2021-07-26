package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.*;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;
import be.condorcet.duquesne.POJO.Configuration.Ticket;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import com.toedter.components.JSpinField;
import javax.swing.JTextField;

public class PlaceActivity extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Representation> allRepresentation = new ArrayList<Representation>();
	private Categorie catItem;
	Configuration configItem;
	private Reservation reserve;
	private Representation representation;
	private JComboBox<Categorie> CatCombo;
	private JButton btnRetour;
	private PlaceActivity activity;
	private JButton btnSelectSpectacle;
	private JPanel panel;
	private JSpinField spinnerBronze, spinnerArgent, spinnerOr, spinnerDiamant;
	private JLabel lblDiamant, lblBronze, lblArgent, lblOr;
	private JLabel lblBase;
	private JSpinField spinnerBase;
	private JComboBox<Configuration> configCombo;
	private List<Place> places = new ArrayList<Place>();
	private Commande commande = new Commande();
	private Spectacle spectacle = new Spectacle();

	public PlaceActivity(Representation r, Personne personne) 
	{
		this.representation=r;
		this.personne = personne;
	
		activity=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 140, 681, 324);
		contentPane.add(panel);
		panel.setLayout(null);

		btnSelectSpectacle = new JButton("Confirmer");
		btnSelectSpectacle.setBackground(Color.DARK_GRAY);
		btnSelectSpectacle.setForeground(Color.WHITE);
		btnSelectSpectacle.setBounds(318, 198, 103, 27);
		btnSelectSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		panel.add(btnSelectSpectacle);
		lblBronze = new JLabel("Bronze");
		lblBronze.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArgent = new JLabel("Argent");
		lblArgent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOr = new JLabel("Or");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiamant = new JLabel("Diamant");
		lblDiamant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinnerBronze = new JSpinField();
		spinnerArgent = new JSpinField();
		spinnerOr = new JSpinField();
		spinnerDiamant = new JSpinField();
		lblBase = new JLabel("Normale");
		lblBase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBase.setBounds(39, 198, 103, 27);
		panel.add(lblBase);
		spinnerBase = new JSpinField();
		spinnerBase.setBounds(151, 200, 80, 25);
		panel.add(spinnerBase);
		lblBronze.setBounds(39, 52, 87, 27);
		lblArgent.setBounds(39, 89, 87, 27);
		spinnerArgent.setBounds(151, 89, 80, 27);
		spinnerOr.setBounds(151, 126, 80, 27);
		spinnerBronze.setBounds(151, 52, 80, 27);
		lblDiamant.setBounds(39, 163, 87, 27);
		spinnerDiamant.setBounds(151, 163, 80, 27);
		lblOr.setBounds(39, 126, 87, 27);
		panel.add(lblBronze);
		panel.add(spinnerBronze);
		panel.add(lblArgent);
		panel.add(spinnerArgent);
		panel.add(spinnerOr);
		panel.add(lblDiamant);
		panel.add(lblOr);
		panel.add(spinnerDiamant);
		spinnerBronze.setMinimum(0);
		spinnerArgent.setMinimum(0);
		spinnerOr.setMinimum(0);
		spinnerDiamant.setMinimum(0);
		spinnerBase.setMinimum(0);
		
		
		btnRetour = new JButton("Quitter");
		btnRetour.setBounds(318, 161, 88, 26);
		panel.add(btnRetour);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setBackground(Color.DARK_GRAY);
		configCombo = new JComboBox<Configuration>();
		configCombo.setBounds(10, 35, 681, 32);
		contentPane.add(configCombo);
		configCombo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblNewLabel = new JLabel("CONFIGUARTION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(125, 11, 294, 25);
		contentPane.add(lblNewLabel);
		CatCombo = new JComboBox<Categorie>();
		CatCombo.setBounds(10, 109, 691, 32);
		contentPane.add(CatCombo);
		
		JLabel lblNewLabel_1 = new JLabel("CATEGORIE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(125, 78, 321, 25);
		contentPane.add(lblNewLabel_1);
		CatCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activity.setIdCat();
			}
		});
		catItem= (Categorie) CatCombo.getSelectedItem();
		configCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activity.setIdConfig();
			}
		});
		configItem= (Configuration) configCombo .getSelectedItem();
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activity.dispose();
			}
		});

		createBtnRetour();
		createCatCombobox();
		createConfigCombobox() ;
		
		
	}

	


	



	public void createCatCombobox() 
	{
		List<Categorie> cat= new  ArrayList<Categorie>();
		// selection de tt sans condi
		Categorie c= new Categorie();
		cat= c.findAll();
		for (Categorie ct : cat) 
		{
			CatCombo.addItem(ct);
		}
	}
	public void createConfigCombobox() 
	{
		List<Configuration> cfg= new  ArrayList<Configuration>();
		// selection de tt sans condi
		Configuration c= new Configuration();
		cfg= c.findAll();
		for (Configuration ct : cfg) 
		{
			configCombo .addItem(ct);
		}
	}
	public void setIdCat() 
	{
		catItem=(Categorie) CatCombo.getSelectedItem();

	}
	public void setIdConfig() 
	{
		configItem=(Configuration)configCombo.getSelectedItem();

	}

	public void createBtnRetour() {
	}

	
	
	public void initCat() 
	{
		Categorie c= new Categorie();
		List<Categorie> cat= new  ArrayList<Categorie>();
		// selection de tt sans condi
		cat= c.findAll();
	}
}
