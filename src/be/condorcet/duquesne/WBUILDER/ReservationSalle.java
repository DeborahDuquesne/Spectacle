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

public class ReservationSalle extends JFrame 
{

	private JPanel contentPane;
	private Personne personne;
	/*lors de la loca on a besoin type de place , des artistes et d un spectacle et d une repr*/
	Spectacle spectacle = new Spectacle();
	List<Representation> representationList = new ArrayList<Representation>();
	List<Artiste> artisteList= new ArrayList<Artiste>();
	List<Artiste> artisteChoix = new ArrayList<Artiste>();
	private Ticket place = Ticket.DEBOUT;
	
	private JTextField titreField;
	private JPanel panel;
	private JLabel labelOr, labelDiamant;
	private JLabel labelArtiste;
	private JTextPane descriptionField;
	
	private int maxParPersonne;
	
	private JCalendar calendar;
	private JLabel labelHeureMin;
	private JLabel labelArtiste_2;
	private JButton addRepresentationBtn;
	private JLabel lblNewLabel;
	private JComboBox<Artiste> comboBoxArtiste;
	private JButton addArtisteBtn;
	private ReservationSalle activity;
	private JTextField textField;

	
	
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
			panel.setBounds(0, 0, 536, 672);
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
			btnR.setBounds(0, 635, 501, 26);
			panel.add(btnR);

			JLabel title = new JLabel("DATE:");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setForeground(Color.BLACK);
			title.setFont(new Font("Dialog", Font.BOLD, 15));
			title.setBounds(10, 50, 273, 27);
			panel.add(title);

			titreField = new JTextField();
			titreField.setBounds(211, 7, 327, 32);
			panel.add(titreField);
			titreField.setColumns(10);

			JLabel labelTitre = new JLabel("SPECTACLE:");
			labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitre.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
			labelTitre.setForeground(Color.BLACK);
			labelTitre.setBounds(0, 7, 201, 32);
			panel.add(labelTitre);

			

			JComboBox comboBox = new JComboBox();

			comboBox.setModel(new DefaultComboBoxModel(Ticket.values()));

			comboBox.setBounds(338, 545, 180, 26);
			panel.add(comboBox);
			comboBox.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					place = (Ticket) comboBox.getSelectedItem();
					
				}
			});
			
			

			JLabel labelPrix = new JLabel("Prix");
			labelPrix.setHorizontalAlignment(SwingConstants.CENTER);
			labelPrix.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 14));
			labelPrix.setForeground(Color.BLACK);
			labelPrix.setBounds(0, 564, 160, 26);
			panel.add(labelPrix);

			
			JLabel nbre = new JLabel("Nombre Max par client");
			nbre.setHorizontalAlignment(SwingConstants.CENTER);
			nbre.setBounds(31, 496, 252, 26);
			panel.add(nbre);
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(31, 533, 102, 20);
			panel.add(spinner);
			
			JLabel lblNewLabel_1 = new JLabel("Type configuration");
			lblNewLabel_1.setBounds(338, 496, 160, 20);
			panel.add(lblNewLabel_1);
			
			textField = new JTextField();
			textField.setBounds(29, 589, 104, 20);
			panel.add(textField);
			textField.setColumns(10);

			

		
		

		

			

			

			

		
		}
	}
	
		

