
public class Date {

	private int jour, mois, annee;
	
	public Date() {
		this.setJour(0);
		this.setMois(0);
		this.setAnnee(0);
	}
	
	public Date(int jour, int mois, int annee) {
		this.setJour(jour);
		this.setMois(mois);
		this.setAnnee(annee);
	}

	public void setJour(int jour) {
		this.jour = jour;
	}
	
	public void setMois(int mois) {
		this.mois = mois;
	}
	
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public int getJour() { return this.jour; }
	public int getMois() { return this.mois; }
	public int getAnnee() { return this.annee; }
	
	public String toString() {
		return this.jour + "/" + this.mois + "/" + this.annee;
	}
}
