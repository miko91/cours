import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



public class ProjetManager extends Manager {

	public ProjetManager(BDD uneBdd) {
		super(uneBdd);
		
	}
	
	public LinkedList<Projet> getList() {
		LinkedList<Projet> liste = new LinkedList<Projet>();
		this.setSql("SELECT * FROM projet;");
		
		try {
			// Connexion � la BDD
			this.getConnexion().seConnecter();
			
			// Execution de la requ�te
			Statement state = this.getConnexion().getMaConnexion().createStatement();
			ResultSet result = state.executeQuery(this.getSql());
			
			// Boucle pour remplir le tableau avec de nouveau v�hicules
			while(result.next()) {
				int id = result.getInt("id_p");
				String nom = result.getString("nom");
				String str = result.getString("debut");
				String temp [] = str.split("-");
				Date debut = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
				str = result.getString("fin");
				Date fin = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
				str = result.getString("prixFactureMO");
				float prixFactureMO = Float.parseFloat(str);
				Projet projet = new Projet(id, nom, debut, fin, prixFactureMO);
				liste.add(projet);
			}
			
			// Fermeture de la connexion, de l'�tat et du r�sultat
			this.getConnexion().seDeconnecter();
			state.close();
			result.close();
			
		} catch (SQLException e) {
			//System.out.println("\nErreur de construction du tableau : "+e.getMessage());
			System.out.println(e.getMessage());
		}
		
		return liste;
	}

}
