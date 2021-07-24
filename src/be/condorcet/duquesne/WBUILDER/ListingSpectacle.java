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

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import java.awt.TextArea;

public class ListingSpectacle extends JFrame 
{

	private JPanel contentPane;
	private Personne personne;
	
	
	private Spectacle leSpectacle = new Spectacle();
	private Representation repr=new Representation ();
	private Reservation reserv =new Reservation ();
	
	private JButton btnRetour;
	private ListingSpectacle activity;
	private JComboBox<Reservation> reservationsCombobox;
	private JComboBox<Spectacle> SpectacleCombox;
	JLabel titreLabel;
	private JTextArea config;
	private JTextArea textADescription ;
	
	private JLabel lblNewLabel;
	private JButton btnSelectSpectacle;
	private List<Spectacle> allSpectacles = new ArrayList<Spectacle>();
	private JLabel noSpectacle;
	private JLabel representation= new JLabel();
	private JLabel rep;
	private TextArea textAreaDescription;
	
	private JLabel lblGenre;

	public ListingSpectacle(Personne personne) 
	{
		this.personne = personne;
		// on va chercher les spectacles
		find();
		activity = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(20, 109, 431, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		config = new JTextArea();
		config.setEditable(false);
		config.setLineWrap(true);
		config.setToolTipText("");
		config.setWrapStyleWord(true);
		config.setText("Lorem ipsum");
		config.setBackground(Color.LIGHT_GRAY);
		config.setBounds(21, 60, 212, 29);
		panel.add(config);
		//pr afficher le titre choisi sur la page
		titreLabel = new JLabel("SPECTACLE:");
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		titreLabel.setBounds(32, 15, 356, 29);
		panel.add(titreLabel);
		//pour afficher le no de spectacle donc l id
		noSpectacle = new JLabel("   ");
		noSpectacle.setToolTipText("no du spectacle");
		noSpectacle.setHorizontalAlignment(SwingConstants.RIGHT);
		noSpectacle.setFont(new Font("Tahoma", Font.BOLD, 23));
		noSpectacle.setBounds(311, 0, 110, 44);
		panel.add(noSpectacle);
		
		lblNewLabel = new JLabel("-");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel.setBounds(208, 169, 43, 34);
		panel.add(lblNewLabel);
		
		btnSelectSpectacle = new JButton("POURSUIVRE");
		btnSelectSpectacle.setBackground(Color.DARK_GRAY);
		btnSelectSpectacle.setForeground(Color.WHITE);
		btnSelectSpectacle.setBounds(154, 204, 119, 21);
		btnSelectSpectacle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ListRepresentation page = new ListRepresentation(leSpectacle,personne);
				//page.setVisible(true);
				activity.dispose();
			}
		});
		panel.add(btnSelectSpectacle);
		
		rep = new JLabel("cc");
		rep.setBounds(10, 100, 165, 24);
		panel.add(rep);
		
		lblGenre = new JLabel("Genre: ");
		lblGenre.setBounds(10, 145, 136, 29);
		panel.add(lblGenre);
		
		
		
		textAreaDescription = new TextArea();
		textAreaDescription.setBounds(243, 113, 145, 50);
		panel.add(textAreaDescription);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_1.setBounds(0, 0, 451, 26);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		btnRetour = new JButton("Retour");
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setBounds(353, 60, 88, 26);
		btnRetour.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				activity.dispose();
			}
		});
		contentPane.add(btnRetour);
		createList();
	}
	public void createList() 
	{
		SpectacleCombox = new JComboBox<Spectacle>();
		SpectacleCombox.setBounds(10, 37, 321, 21);
		SpectacleCombox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
			}
		});
		contentPane.add(SpectacleCombox);
		for (Spectacle sp : allSpectacles) 
		{
			SpectacleCombox.addItem(sp);
		}		
		leSpectacle = (Spectacle) SpectacleCombox.getSelectedItem();
	}
	
	public void setId()
	{
	//selection de l item
		leSpectacle= (Spectacle) SpectacleCombox.getSelectedItem();
		titreLabel.setText(leSpectacle.getLibel());
		
		
		//dateDebutLabel.setText(currentSpectacle.getPlanning().getdateDebutReservation().toString() + " - 12:00");
		//dateFinLabel.setText(currentSpectacle.getPlanning().getDateFinReservation().toString() + " - 12:00");
		noSpectacle.setText("Ref :  "+Integer.toString(leSpectacle.getId()));
		
		config.setText("configuration: " +leSpectacle
			.getConfiguration().getDescription());
			
		//.getPlanning().getSpectacle().getConfiguration().getDescription());
		rep.setText(" date "+repr.getDateRepresentation());
		lblGenre.setText("GENRE: "+leSpectacle.getGenre());
		textAreaDescription.setText("DESCRIPTION: "+ leSpectacle.getDescription());
		
		
	}
	
	
	
	public void find() 
	{
		Spectacle s = new Spectacle();
		allSpectacles =s.findAll_();
	}
}
