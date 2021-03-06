package VIews;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accueil extends JPanel{
	
	private LinkedList<JPanel> liste = new LinkedList<JPanel>();
	private LinkedList<JButton> boutons = new LinkedList<JButton>();

	public Accueil() {
		initAccueil();
	}

	public Accueil(LayoutManager arg0) {
		super(arg0);
		initAccueil();
	}
	
	public LinkedList<JButton> getBoutons() { return this.boutons; }
	
	private void initAccueil() {
		this.setName("Accueil");
		
		// D�finition du titre
		JLabel title = new JLabel("Bienvenue dans la gestion de la casse");
		JPanel panTitle = new JPanel();
		panTitle.add(title);
		this.add(panTitle, BorderLayout.NORTH);
		
		// Ajout de contenu vide sur les cot�s
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(new JPanel(), BorderLayout.EAST);
		
		// Ajout du contenu central
		JPanel panCenter = new JPanel();
		this.liste.add(new JPanel(new GridLayout(2, 2)));
		this.boutons.add(new JButton("Voir liste"));
		this.boutons.add(new JButton("Ajouter"));
		this.boutons.add(new JButton("Supprimer"));
		this.boutons.add(new JButton("A propos"));
		int i = 1;
		for(JButton button : this.boutons) {
			button.setSize(100, 70);
			this.liste.add(new JPanel());
			this.liste.get(i).add(button);
			this.liste.get(0).add(this.liste.get(i));
			i++;
		}
		panCenter.add(this.liste.get(0));
		this.add(panCenter, BorderLayout.CENTER);

		// Ajout d'un bouton quitter en bas
		this.boutons.add(new JButton("Quitter"));
		JPanel panFoo = new JPanel();
		for(JButton button : this.boutons) {
			if(button.getText().equals("Quitter")) {
				panFoo.add(button);
			}
		}
		this.add(panFoo, BorderLayout.SOUTH);
	}

}
