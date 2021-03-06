package Entities;

public class Vehicule {

	private String matricule, couleur;
	private int id, nbKm, id_const;
	
	public Vehicule() {
		this.setId(0);
		this.setMatricule("");
		this.setCouleur("");
		this.setNbKm(0);
		this.setId_const(0);
	}
	
	public Vehicule(String mat, String cou, int km, int id_const) {
		this.setMatricule(mat);
		this.setCouleur(cou);
		this.setNbKm(km);
		this.setId_const(id_const);
	}
	
	public Vehicule(int id, String mat, String cou, int km, int id_const) {
		this.setId(id);
		this.setMatricule(mat);
		this.setCouleur(cou);
		this.setNbKm(km);
		this.setId_const(id_const);
	}

	
	
	public String getMatricule() { return this.matricule; }
	public String getCouleur() { return this.couleur; }
	public int getId() { return this.id; }
	public int getNbKm() { return this.nbKm; }
	public int getId_const() { return this.id_const; }
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNbKm(int km) {
		this.nbKm = km;
	}
	
	public void setId_const(int id) {
		this.id_const = id;
	}
	
	public String toString() {
		String temp = "";
		
		temp += "\n"+this.getMatricule();
		temp += "\t"+this.getCouleur();
		temp += "\t"+this.getNbKm();
		temp += "\t"+this.getId_const();
		
		return temp;
	}
}
