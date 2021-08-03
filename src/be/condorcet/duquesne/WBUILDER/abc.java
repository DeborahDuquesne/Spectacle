package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Spectacle;
import javax.swing.JTextField;

public class abc extends JFrame 
{

	private JPanel contentPane;
	
	private JPanel panel;
	private List<Representation> allRe = new ArrayList<Representation> ();
	private abc activity ;
	private Spectacle leSpectacle;
	private Spectacle spectacle = new Spectacle();
	private Representation r = new Representation();
	private Personne personne;
	JLabel un,deux,trois;
	
	private Spectacle s = new Spectacle();
	private JComboBox  <Spectacle> Combobox ;
	
	

	private DefaultListModel<String> listModelArt = new DefaultListModel<>();
	private DefaultListModel<Representation> listModelRep = new DefaultListModel<>();
	private JScrollPane scrollPane;
	private JList<String> jListArt;
	private JList<Representation> jListRepresentation;
	private JButton btnClose;
	private JTextField heureD;
	private JTextField heureF;
	private JTextField date;
	private JTextField nb;
	private JTextField config;
	private JButton btnPlace;
	
	
			public abc() 
			{
				activity= this;
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 680, 601);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				JPanel nbre = new JPanel() 
				{
					public void paintComponent(Graphics g) 
					{
						Image img = Toolkit.getDefaultToolkit()
								.getImage(MainActivity.class
										.getResource("/be/condorcet/duquesne/IMG/show.jpg")
										);
						g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
					}
				};
				
				nbre.setBounds(10, 11, 654, 540);
				contentPane.add(nbre);
				nbre.setLayout(null);
				 
				
			    Combobox = new JComboBox<Spectacle>();
			    Combobox.setBounds(10, 28, 634, 22);
			    nbre.add(Combobox);
			    
			    un = new JLabel("New label");
			    un.setBounds(31, 105, 367, 22);
			    nbre.add(un);
			    
			    deux = new JLabel("New label");
			    deux.setBounds(31, 156, 389, 22);
			    nbre.add(deux);
			    
			   trois = new JLabel("New label");
			    trois.setBounds(31, 230, 255, 14);
			    nbre.add(trois);
			  
			    
			   
				
				
				
			
				
			
				displayCombo( );
				
		
		
			}
			
		
/************************************************************************************************************************************************
 * 
 * 
 * 				SYSTEME JLIST ET COMBOX SONT FONCTIONNELS 
 * 				LE JLIST EST MOINS JOLI 
 * 				
 * 
 * 
 * 		
 ******************************************************************************************************************************************************/
			
			
		
			
/**********************************************************************************************************
 * 
 * 									GENERATION D UN COMBO A L AIDE DU SPECTACLE RECU 
 * 									PlaceActivity recevra cet objet afin de lier representation et place sur les frames
 * 
 ************************************************************************************************************/
			private void displayCombo() 
			{
				
				
				List < Spectacle> t= new ArrayList<>();
				t=s.findAll();
				Combobox.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						activity.setId();
					}
				});
				// modif 27 07 en llist 2
				
					for(Spectacle rep : t)
						Combobox.addItem(rep);
				
		        
					
				
		 s= (Spectacle) Combobox.getSelectedItem();
			}
			





/*********************************************************************************************************
 * 
 * 									GENERATION D UNE JLIST A L AIDE DU SPECTACLE RECU 
 * 
 * 
 ************************************************************************************************************/			
		
			
			
/********************************************************************************************************************************************
 * 
 * 
 * 		FONCTION QUI PERMET D AFFICHER LES DIFFERENTES DONNEES DES REPRESENTATIONS DS DES LABELS
 * 
 * 
 * **********************************************************************************************************************************************
 */
			public void setId()
			{
				s= (Spectacle) Combobox.getSelectedItem();
				//r.findAll();
				
				
			un.setText("description : "+s.getDescription());
			deux.setText("genre  : "+s.getGenre());
			trois.setText("titre  "+s.getLibel());
					//.toString() + " - 12:00");
				//dateFinLabel.setText(currentSpectacle.getPlanning().getDateFinReservation().toString() + " - 12:00");
				//deux.setText("no de psectacle :  "+Integer.toString(s.getId()));
				
					
				//.getPlanning().getSpectacle().getConfiguration().getDescription());
				
				
				
				
				
			}	
}

