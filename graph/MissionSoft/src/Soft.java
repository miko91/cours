import java.io.IOException;
import java.util.LinkedList;


public class Soft {

	private String nom;
	private LinkedList<Projet> lesProjets = new LinkedList<Projet>();
	private LinkedList<Intervenant> lesInter = new LinkedList<Intervenant>();
	private String title;
	private BDD sql;
	private ProjetManager manP;
	
	public Soft() {
		this.setNom("MissionSoft");
		this.setTitle(	"\t\t@|||||||||||||||||||||||||||||||||@\n" +
						"\t\t@||        Menu principal       ||@\n" +
						"\t\t@|||||||||||||||||||||||||||||||||@\n" +
						"\t\t" + this.nom + "\n");
		this.sql = new BDD("localhost", "projet", "root", "toor");
		this.manP = new ProjetManager(sql);
		this.loadData();
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNom() { return this.nom; }
	public String getTitle() { return this.title; }
	public LinkedList<Projet> getLesProjets() { return this.lesProjets; }
	
	public float getFacturationTotale() {
		float cumul = 0;
		for(Projet p : this.lesProjets) {
			cumul += p.getPrixFactureMO();
		}
		return cumul;
	}
	
	public void gestionProjet() {
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int choix;
		do {
			System.out.println(this.title);
			System.out.println("\n\tGestion des projets\n\t---------");
			System.out.println("\n\t1) Nouveau projet");
			if (this.lesProjets.size() > 0) {
				System.out.println("\n\t2) G�rer les projets");
			}
			System.out.println("\n\t0) Quitter");
			choix = Console.saisirInt();
			switch (choix) {
			case 1:Projet unP = new Projet();unP.saisir();this.lesProjets.add(unP);
				break;
			case 2:if(this.lesProjets.size() > 0 ) this.listProjet();
				break;
			default:
				break;
			}
		} while (choix != 0);
	}
	
	public void listProjet() {
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int choix;
		do {
			System.out.println(this.title);
			System.out.println("\n\tListe des projets\n\t---------");
			for(int i = 0; i < this.lesProjets.size(); i++) {
				System.out.println("\n\t" + (i+1) + ") " + this.lesProjets.get(i).getNom());
			}
			System.out.println("\n\t0) Quitter");
			System.out.println("\n\tSaisir le num�ro du projet � voir/modifier");
			choix = Console.saisirInt();
			for(int i = 0; i < this.lesProjets.size(); i++) {
				if(choix == (i+1)) {
					this.lesProjets.get(i).voir();
				}
			}
		} while (choix != 0);
	}
	
	public void gestionInter() {
		
	}
	
	public void run() {
		try {
			Process p = Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		int choix;
		do {
			System.out.println(this.title);
			System.out.println("\n\tDashBoard\n\t---------");
			System.out.println("\n\tProjets : \t"+this.lesProjets.size()+"\t\tFacturation totale : "+this.getFacturationTotale() + " �");
			System.out.println("\n\tIntervenants : \t"+this.lesInter.size());
			System.out.println("\n\n\tMenu\n\t----");
			System.out.println("\n\t1) Gestion des projets \t\t2) Gestion des intervenants");
			System.out.println("\n\t0) Quitter");
			choix = Console.saisirInt();
			switch (choix) {
			case 1:this.gestionProjet();
				break;
			case 2:this.gestionInter();
				break;
			default:
				break;
			}
		} while (choix != 0);	
	}
	
	public void loadData() {
		this.lesProjets = this.manP.getList();
	}
	
	/**
	 * Main, cr�ation d'un objet Soft, execution du soft
	 * @param args
	 */
	public static void main(String args[]) {
		Soft unS = new Soft();
		unS.run();
	}

}
