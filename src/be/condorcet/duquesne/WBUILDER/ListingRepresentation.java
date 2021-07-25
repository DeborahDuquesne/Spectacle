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

import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Spectacle;

public class ListingRepresentation extends JFrame 
{

	private JPanel contentPane;
	private JPanel panel;
	private List<Representation> allRe = new ArrayList<Representation> ();
	private ListingRepresentation activity ;
	private Spectacle leSpectacle;
	private Spectacle spectacle = new Spectacle();
	private Representation r = new Representation();
	
	private Spectacle s = new Spectacle();
	private JComboBox  <Representation> Combobox ;
	
	

	private DefaultListModel<String> listModelArt = new DefaultListModel<>();
	private DefaultListModel<Representation> listModelRep = new DefaultListModel<>();
	private JScrollPane scrollPane;
	private JList<String> jListArt;
	private JList<Representation> jListRepresentation;
	private JButton btnClose;
	
	
			public ListingRepresentation(Spectacle s) 
			{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 680, 601);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				JPanel panel = new JPanel() 
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
				
				panel.setBounds(10, 11, 654, 374);
				contentPane.add(panel);
				panel.setLayout(null);
				 
				
			    Combobox = new JComboBox();
			    Combobox.setBounds(78, 28, 413, 22);
			    panel.add(Combobox);
				activity=this;
			
				
			/* selon les besoins du visu on peut choisur une jlist */ 
				displayCombo( s);
				//displayJlist( s) ;
		
		
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
 * 
 * 
 ************************************************************************************************************/
			private void displayCombo(Spectacle s) 
			{
				
				s.getListRepresentationBySpectacle();
				
				
				if(!s.getRepresentationList().isEmpty()) {
					for(Representation rep : s.getRepresentationList())
						Combobox.addItem(rep);
				
		        
					
				}

				else 
				{
					JLabel rep = new JLabel("NADA !");
			        rep.setHorizontalAlignment(SwingConstants.CENTER);
			        rep.setFont(new Font("Tahoma", Font.BOLD, 20));
					rep.setBounds(30, 360, 610, 45);
					contentPane.add(rep);
				}
			}
			
/*********************************************************************************************************
 * 
 * 									GENERATION D UNE JLIST A L AIDE DU SPECTACLE RECU 
 * 
 * 
 ************************************************************************************************************/			
			private void displayJlist(Spectacle s) 
			{
				
				s.getListRepresentationBySpectacle();
				jListRepresentation = new JList<>();
				
				if(!s.getRepresentationList().isEmpty()) {
					for(Representation rep : s.getRepresentationList())
						listModelRep.addElement(rep);
				
					jListRepresentation.setVisibleRowCount(3);
					jListRepresentation.setModel(listModelRep);
					jListRepresentation.setBounds(50, 300, 150, 100);
		        
					scrollPane = new JScrollPane(jListRepresentation, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
							ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBounds(50, 310, 500, 130);
					contentPane.add(scrollPane);   
				}

				else {
					JLabel lblNewLabel_7 = new JLabel("Aucune représentations présentes !");
			        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblNewLabel_7.setBounds(30, 360, 610, 45);
					contentPane.add(lblNewLabel_7);
				}
			}
}

