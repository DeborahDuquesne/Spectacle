package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.Commande;
import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.Spectacle;

public class ListingCommande extends JFrame 
{

	private JPanel contentPane;
	private Personne p;
	private List<Commande> allCde = new ArrayList<Commande>();
	
	private Commande laCde= new Commande();
	

	private JComboBox<Commande> sp_cm;
	
	/*liste des commandes du client */
	public ListingCommande(Personne p) 
	{
		this.p=p;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		// creation d un panel pour taper une photo en background 
		JPanel panel_1 = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/condorcet/duquesne/IMG/cde.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(0, 2, 435, 231);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		sp_cm = new JComboBox<Commande>();
		sp_cm.setBounds(10, 110, 414, 21);
		panel_1.add(sp_cm);
		
		List();
		createCombobox() ;
	}
	
	
	public Commande  createCombobox() 
	{
		//JOptionPane.showMessageDialog(null, "taille radio ."+ size.toString());
		
		for (Commande sp:
			allCde) 
		{
			sp_cm.addItem(sp);
		}		
		
		
		;
	
		return laCde=(Commande) sp_cm.getSelectedItem();
	}
	
	
	
	
	
	
	public void List() 
	{
		
		allCde = laCde.findAll();
	}

}
