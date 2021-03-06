import java.util.LinkedList;


public class Projet {
	
	private int id;
	private String nom;
	private Date debut, fin;
	private float prixFactureMO;
	private LinkedList<Mission> missions;
	private MissionManager manM = new MissionManager(new BDD("localhost", "projet", "root", "toor"));
	

	public Projet() {
		this.setId(0);
		this.setNom("");
		this.setDebut(new Date());
		this.setFin(new Date());
		this.setPrixFactureMO(0);
		this.setMissions(new LinkedList<Mission>());
	}
	
	public Projet(int id, String nom, Date debut, Date fin, float prix) {
		this.setId(id);
		this.setNom(nom);
		this.setDebut(debut);
		this.setFin(fin);
		this.setPrixFactureMO(prix);
		this.loadMission();
	}
	
	public Projet(int id, String nom, Date debut, Date fin, float prix, LinkedList<Mission> missions) {
		this.setId(id);
		this.setNom(nom);
		this.setDebut(debut);
		this.setFin(fin);
		this.setPrixFactureMO(prix);
		this.setMissions(missions);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	
	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	public void setPrixFactureMO(float prix) {
		this.prixFactureMO = prix;
	}
	
	public void setMissions(LinkedList<Mission> missions) {
		this.missions = missions;
	}
	
	public int getId() { return this.id; }
	public String getNom() { return this.nom; }
	public Date getDebut() { return this.debut; }
	public Date getFin() { return this.fin; }
	public float getPrixFactureMO() { return this.prixFactureMO; }
	public LinkedList<Mission> getMissions() { return this.missions; }
	
	
	
	/**
	 * Fonction retournant le cumul des couts de toutes les missions du projet
	 * @return float cumul
	 */
	private float cumulCoutMO() {
		float cumul = 0, taux;
		int nbh;
		for(int i = 0; i < this.missions.size(); i++) {
			nbh = this.missions.get(i).nbHeuresEffectuees();
			taux = this.missions.get(i).getExecutant().getTauxHoraire();
			cumul += nbh * taux;
		}		
		return cumul;
	}
	
	/**
	 * Fonction retournant la marge brut
	 * @return float marge
	 */
	public float margeBruteCourante() {
		return this.prixFactureMO - this.cumulCoutMO();
	}
	
	/**
	 * Fonction qui permet de supprimer une mission en v�rifiant qu'elle existe
	 * @param uneM Mission La mission � supprimer
	 * @return boolean Vrai ou faux
	 */
	public boolean supprimer_mission(Mission uneM) {
		boolean result;
		if(this.missions.contains(uneM)) {
			this.missions.remove(uneM);
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	/**
	 * Fonction permettant de retourn�
	 * @param nbh
	 * @return
	 */
	public LinkedList<Mission> les_missions_max_heures(int nbh) {
		LinkedList<Mission> lesMissions = new LinkedList<Mission>();
		for(Mission uneM : this.missions) {
			if (uneM.nbHeuresEffectuees() > nbh) {
				lesMissions.add(uneM);
			}
		}
		return lesMissions;
	}
	
	public String intervenant_max_heures() {
		int test = 0, index = 0;
		for(Mission uneM : this.missions) {
			if(uneM.nbHeuresEffectuees() > test) {
				test = uneM.nbHeuresEffectuees();
				index = this.missions.indexOf(uneM);
			}
		}
		return this.missions.get(index).getExecutant().getNom();
	}
	
	public void saisir() {
		System.out.println("\nNom du projet : ");
		this.setNom(Console.saisirString());
		System.out.println("\nDate de d�but (Exemple : 01/01/1970) : ");
		String date = Console.saisirString();
		String test[] = date.split("/");
		Date debut = new Date(Integer.parseInt(test[0]), Integer.parseInt(test[1]), Integer.parseInt(test[2]));
		this.setDebut(debut);
	}
	
	public void loadMission() {
		this.manM.setSql("SELECT * FROM mission WHERE id_p = " + this.id);
		this.missions = this.manM.getList();
	}
	
	public void voir() {
		System.out.println("\n\t\tProjet : " + this.nom);
		System.out.println("\n\tD�but : " + this.debut.toString() + "\tFin : " + this.fin.toString());
		System.out.println("\n\tPrix factur� : " + this.prixFactureMO);
		System.out.println("\n\tMissions :");
		for(Mission mission : this.missions) {
			System.out.println("\n\t\t" + mission.getNom());
			System.out.println("\n\t\t" + mission.getDescription());
			System.out.println("\n\t\t" + mission.getNbHeuresPrevues() + " h");
			System.out.println("\n\t\t" + mission.getExecutant().getNom());
		}
	}
}
