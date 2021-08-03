package be.condorcet.duquesne.WBUILDER;
import be.condorcet.duquesne.POJO.*;

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

public class test extends JFrame {

	private JPanel contentPane;


	private DefaultListModel<String> listModelArt = new DefaultListModel<>();
	private DefaultListModel<Representation> listModelRep = new DefaultListModel<>();
	private JScrollPane scrollPane;
	private JList<String> jListArt;
	private JList<Representation> jListRepresentation;
	private JButton btnClose;
	private JLabel zz,mm,ww;
	private Personne personne;
	
	
	private Spectacle s = new Spectacle();
	
	
	private Representation r = new Representation();
	private JComboBox<Spectacle> Spp;
	private JComboBox <Representation>rere;
	private test activity;
	private   JLabel deux,trois;
	
	public test()//Spectacle s ) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		activity = this;
		//initFrame(1);
        
        mm = new JLabel("Configuration :");
        mm.setBounds(142, 143, 329, 20);
        contentPane.add(mm);
       
        
        deux = new JLabel("deu");
        deux.setBounds(22, 174, 427, 25);
        contentPane.add(deux);
        
       trois = new JLabel("trois");
        trois.setBounds(433, 102, 221, 30);
        contentPane.add(trois);
        
       
        Spp = new JComboBox<Spectacle>();
		Spp.setBounds(10, 39, 559, 21);
		contentPane.add(Spp);
		
		JButton repB = new JButton("REPRESENTATION");
		repB.setBounds(455, 71, 178, 23);
		contentPane.add(repB);
		
		 zz = new JLabel("ffffffffffffffffffffffffffffffffffffffffffffff");
		zz.setBounds(10, 75, 269, 14);
		contentPane.add(zz);
		
		 ww = new JLabel("New label");
		ww.setBounds(10, 100, 251, 14);
		contentPane.add(ww);
		
		JLocaleChooser localeChooser = new JLocaleChooser();
		localeChooser.setBounds(70, 221, 446, 20);
		contentPane.add(localeChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.getSpinner().setBackground(Color.LIGHT_GRAY);
		yearChooser.setBounds(80, 252, 127, 43);
		contentPane.add(yearChooser);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setBackground(Color.LIGHT_GRAY);
		monthChooser.setBounds(285, 252, 231, 43);
		contentPane.add(monthChooser);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(70, 201, 445, 20);
		contentPane.add(dateChooser);
		
		JDayChooser dayChooser = new JDayChooser();
		dayChooser.getDayPanel().setBackground(Color.PINK);
		dayChooser.setBounds(70, 295, 446, 241);
		contentPane.add(dayChooser);
		repB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ListingRepresentation page = new ListingRepresentation (createCombobox() ,personne);
				page.setVisible(true);
				activity.dispose();
			}
		});
		
		init();
		
		//ssdisplayRepresentationFrame(s);
		createCombobox() ;
		
	
	}
	
	
	
	private void displayRepresentationFrame(Spectacle s) {
		
		s.getListRepresentationBySpectacle();
		jListRepresentation = new JList<>();
		
		if(!s.getRepresentationList().isEmpty()) {
			for(Representation rep : s.getRepresentationList())
				listModelRep.addElement(rep);
		
			jListRepresentation.setVisibleRowCount(3);
			jListRepresentation.setModel(listModelRep);
			jListRepresentation.setBounds(50, 300, 150, 100);
        /*
         * A AJOUTER SI PREFERENCE DE LA JLIST CAR AU  PLUS LA LISTE EST GDE AU PLUS IL FAUT DE LA PLACE 
         * 
			scrollPane = new JScrollPane(jListRepresentation, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(50, 310, 500, 130);
			contentPane.add(scrollPane);*/   
		}

		else {
			JLabel lblNewLabel_7 = new JLabel("Aucune représentations présentes !");
	        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_7.setBounds(30, 360, 610, 45);
			contentPane.add(lblNewLabel_7);
		}
	}
	
	
	
	
	
	
	
	public Spectacle  createCombobox() 
	{
		Spp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
			}
		});
		
		
		//JOptionPane.showMessageDialog(null, "taille radio ."+ size.toString());
		for (Spectacle  sp: allSpectacles) 
		{
			Spp.addItem(sp);
			
		}		
		// JOptionPane.showMessageDialog( null,"item id ."+currentSpectacle); // test
		
		;
	
		return s =(Spectacle) Spp.getSelectedItem();
	}
	
	
	
	
	
	
	
	
	
	/*
	
	public Spectacle  createList() 
	{
		SpectacleCombox = new JComboBox<Spectacle>();
		SpectacleCombox.setBounds(10, 37, 321, 21);
		
		SpectacleCombox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
				String id= s.toString();
			//JOptionPane.showMessageDialog(null, "select combo  ."+id);
				//+ s.toString());// ici je recup id 
			}
		});
		contentPane.add(SpectacleCombox);
		
		
		for (Spectacle sp : s.findAll_()) 
		{
			SpectacleCombox.addItem(sp);
		}		
	return 	s = (Spectacle) SpectacleCombox.getSelectedItem();
	//	JOptionPane.showMessageDialog(null, "select combo  ."+ s.toString());	
	}
	*/
	
	public void setId()
	{
	//selection de l item
		s= (Spectacle) Spp.getSelectedItem();
		
		Representation r= new Representation();
		r.findAll();
		
		
		//dateDebutLabel.setText(currentSpectacle.getPlanning().getdateDebutReservation().toString() + " - 12:00");
		//dateFinLabel.setText(currentSpectacle.getPlanning().getDateFinReservation().toString() + " - 12:00");
		deux.setText("no de psectacle :  "+Integer.toString(s.getId()));
		
			
		//.getPlanning().getSpectacle().getConfiguration().getDescription());
		
		trois.setText("GENRE: "+s.getGenre());
		mm.setText("nbre: "+ s.getNombrePlaceParClient());
		ww.setText("description: "+s.getDescription());
		
		
		
		
	}
	private List<Spectacle> allSpectacles = new ArrayList<Spectacle>();
	private List<Representation> allRe = new ArrayList<Representation> ();
	public void init() 
	{
		Spectacle spectacle = new Spectacle();
		allSpectacles = spectacle.findAll_();
	}
}
