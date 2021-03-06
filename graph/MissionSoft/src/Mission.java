

import java.util.HashMap;
import java.util.LinkedList;

public class Mission {

	private int id;
	private String nom, description;
	private int nbHeuresPrevues;
	private HashMap<Date, Integer> releveHoraire;
	private Intervenant executant;
	private float temp;
	private IntervenantManager manI = new IntervenantManager(new BDD("localhost", "projet", "root", "toor"));
	
	public Mission() {
		this.setNom("");
		this.setDescription("");
		this.setNbHeuresPrevues(0);
		this.setReleveHoraire(new HashMap<Date, Integer>());
		this.setExecutant(new Intervenant());
	}
	
	public Mission(int id, String nom, String desc, int nbh, float inter) {
		this.setNom(nom);
		this.setDescription(desc);
		this.setNbHeuresPrevues(nbh);
		this.loadIntervenant();
		this.temp = inter;
	}
	
	public Mission(String nom, String desc, int nbh, HashMap<Date, Integer> releve, Intervenant executant) {
		this.setNom(nom);
		this.setDescription(desc);
		this.setNbHeuresPrevues(nbh);
		this.setReleveHoraire(releve);
		this.setExecutant(executant);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public void setNbHeuresPrevues(int nbh) {
		this.nbHeuresPrevues = nbh;
	}
	
	public void setReleveHoraire(HashMap<Date, Integer> releve) {
		this.releveHoraire = releve;
	}
	
	public void setExecutant(Intervenant executant) {
		this.executant = executant;
	}
	
	public int getId() { return this.id; }
	public String getNom() { return this.nom; }
	public String getDescription() { return this.description; }
	public int getNbHeuresPrevues() { return this.nbHeuresPrevues; }
	public HashMap<Date, Integer> getReleveHoraire() { return this.releveHoraire; }
	public Intervenant getExecutant() { return this.executant; }
	
	public void ajoutReleve(Date uneDate, int nbh) {
		if (this.releveHoraire.containsKey(uneDate) == true) {
			nbh += this.releveHoraire.get(uneDate);
		}
		if (nbh <= 8) {
			this.releveHoraire.put(uneDate, new Integer(nbh));
		} else {
			this.releveHoraire.put(uneDate, new Integer(8));
		}
	}

	public int nbHeuresEffectuees() {
		int nbh = 0;
		for (Date uneDate : this.releveHoraire.keySet()) {
			nbh += this.releveHoraire.get(uneDate);
		}
		return nbh;
	}
	
	public void loadIntervenant() {
		this.manI.setSql("SELECT * FROM intervenant WHERE id_i = " + this.temp);
		if(this.manI.getList().size() > 0) {
			this.setExecutant(this.manI.getList().get(0));
		} else {
			this.setExecutant(new Intervenant());
		}
		//this.setExecutant(this.manI.getList().get(0));	
	}
}
