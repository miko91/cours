package Menus;
import java.util.LinkedList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MyMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private LinkedList<JMenu> menus = new LinkedList<JMenu>();
	private LinkedList<JMenuItem> items = new LinkedList<JMenuItem>();

	public MyMenu() {
		initMyMenu();
	}
	
	public LinkedList<JMenu> getMenus() { return this.menus; }
	public LinkedList<JMenuItem> getItems() { return this.items; }
	
	public void initMyMenu() {
		// Ajout des menus
		this.menus.add(new JMenu("Fichiers"));
		this.menus.add(new JMenu("Produits"));
		this.menus.add(new JMenu("Archive"));
		this.menus.add(new JMenu("Aide"));
		
		// Ajout des items
		this.items.add(new JMenuItem("Tableau de bord"));
		this.items.add(new JMenuItem("Etat des stocks"));
		this.items.add(new JMenuItem("Quitter"));
		this.items.add(new JMenuItem("Acheter un produit"));
		this.items.add(new JMenuItem("Vendre un produit"));
		this.items.add(new JMenuItem("Registre des achats"));
		this.items.add(new JMenuItem("Registre des ventes"));
		this.items.add(new JMenuItem("Configuration"));
		this.items.add(new JMenuItem("A propos"));
		
		// Conception des menus
		this.menus.get(0).add(this.items.get(0));
		this.menus.get(0).add(this.items.get(1));
		this.menus.get(0).add(this.items.get(2));
		this.menus.get(1).add(this.items.get(3));
		this.menus.get(1).add(this.items.get(4));
		this.menus.get(2).add(this.items.get(5));
		this.menus.get(2).add(this.items.get(6));
		this.menus.get(3).add(this.items.get(7));
		this.menus.get(3).add(this.items.get(8));
		
		for(JMenu m : this.menus) {
			this.add(m);
		}
	}

}
