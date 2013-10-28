
public class Banque {
	
	private Compte comptes[];
	private int taille;
	
	/**
	 * Constructeur
	 */
	public Banque(int nbCompte) {
		this.setComptes(nbCompte);
		this.setTaille(0);
	}
	
	/**
	 * Setter
	 * @param Compte compte Objet Compte � rentrer dans le tableau des comptes
	 */
	public void setComptes(int nbCompte) {
		this.comptes = new Compte[nbCompte];
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	/**
	 * Getter
	 * @return Compte comptes Tableau contenant des objets Compte
	 */
	public Compte[] getComptes() {
		return this.comptes;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public void ouvrir() {
		Compte unC = new Compte();
		unC.ouvrir();
		this.comptes[this.getTaille()] = unC;
	}
	
	public void consulter() {
		for (int i = 0; i<this.getTaille(); i++) {
			this.comptes[i].afficher();
		}
	}
	
	public void fermer() {}
	public void triersolde() {}
	public void maxargent() {}
	public void moyennesolde() {}
	public void menu() {}
	
	public static void main(String[] args) {
		Banque mabanque = new Banque(50);
		mabanque.ouvrir();
		mabanque.ouvrir();
		mabanque.consulter();
	}
}
