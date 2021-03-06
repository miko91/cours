

public class Intervenant {

	private int id;
	private String nom, prenom;
	private float tauxHoraire;
	
	public Intervenant() {
		this.setNom("");
		this.setTauxHoraire(0);
	}
	
	public Intervenant(String nom, float taux) {
		this.setNom(nom);
		this.setTauxHoraire(taux);
	}

	public Intervenant(int id, String nom, String prenom, float taux) {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setTauxHoraire(taux);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setTauxHoraire(float taux) {
		this.tauxHoraire = taux;
	}
	
	public int getId() { return this.id; }
	public String getNom() { return this.nom; }
	public String getPrenom() { return this.prenom; }
	public float getTauxHoraire() { return this.tauxHoraire; }
}
