package Application;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Entities.Vehicule;
import Library.BDD;


public class Casse {

	private LinkedList<Vehicule> lesVehicules;
	
	public Casse() {
		this.lesVehicules = new LinkedList<Vehicule>();
	}
	
	public void ajouter(Vehicule unVehicule) {
		this.lesVehicules.add(unVehicule);
	}
	
	public void setLesVehicules(LinkedList<Vehicule> liste) {
		this.lesVehicules = liste;
	}
	
	public LinkedList<Vehicule> getLesVehicules() { return this.lesVehicules; }
	
	
	
	public void chargerVehicules() {
		BDD uneBDD = new BDD("localhost", "casse", "root", "toor");
		String requete = "SELECT * FROM vehicule;";
		this.lesVehicules.clear();
		try {
			uneBDD.seConnecter();
			Statement unState = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unState.executeQuery(requete);
			while (unRes.next()) {
				int id = unRes.getInt("id_veh");
				String matricule = unRes.getString("matricule");
				String couleur = unRes.getString("couleur");
				int nbKm = unRes.getInt("km");
				int id_const = unRes.getInt("id_const");
				Vehicule unV = new Vehicule(id, matricule, couleur, nbKm, id_const);
				this.lesVehicules.add(unV);
			}
			uneBDD.seDeconnecter();
			unState.close();
			unRes.close();
		} catch (SQLException e) {
			System.out.println("Erreur de chargement");
		}
	}
	
	public void supprimer(String matricule) {
		BDD uneBDD = new BDD("localhost", "casse", "root", "toor");
		String requete = "DELETE FROM vehicule WHERE matricule = '"+matricule+"';";
		try {
			uneBDD.seConnecter();
			Statement unState = uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			uneBDD.seDeconnecter();
			unState.close();
		} catch (SQLException exp) {
			System.out.println("La suppression n'a pas fonctionnŽe :"+exp.getMessage());
		}
	}
	
	public void ajouter(String matricule, String couleur, int km, int id_const) {
		BDD uneBDD = new BDD("localhost", "casse", "root", "toor");
		String requete = "INSERT INTO vehicule (id_const, matricule, couleur, km) VALUES("+id_const+", '"+matricule+"', '"+couleur+"', "+km+");";
		try {
			uneBDD.seConnecter();
			Statement unState = uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			uneBDD.seDeconnecter();
			unState.close();
		} catch (SQLException exp) {
			System.out.println("Erreur sur l'ajout : "+exp.getMessage());
		}
	}
	
	public String toString() {
		String temp = "";
		
		for(Vehicule unV : this.getLesVehicules()) {
			temp += unV.toString();
		}
		
		return temp;
	}
	
}
