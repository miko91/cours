import java.io.IOException;
import java.util.LinkedList;

public class Magasin {

	private String name, adresse, ville, cp, tel;
	private LinkedList<String> regAchat = new LinkedList<String>();
	private LinkedList<String> regVente = new LinkedList<String>();
	private int numAchat = 0 , numVente = 0;
	private LinkedList<Produit> test = new LinkedList<Produit>();
	private boolean configured;
	private double plus = 0, moins = 0, resultat = 0, ca = 0, solde;
	public Runtime cmd;
	
	public Magasin() {
		this.setName("Non configur�");
		this.setConfigured(false);
	}
	
	public String getName() { return this.name; }
	public String getAdresse() { return this.adresse; }
	public String getVille() { return this.ville; }
	public String getCp() { return this.cp; }
	public String getTel() { return this.tel; }
	public LinkedList<String> getRegAchat() { return this.regAchat; }
	public LinkedList<String> getRegVente() { return this.regVente; }
	public int getNumAchat() { return this.numAchat; }
	public int getNumVente() { return this.numVente; }
	public boolean getConfigured() { return this.configured; }
	public double getPlus() { return this.plus; }
	public double getMoins() { return this.moins; }
	public double getResultat() { return this.resultat; }
	public double getCa() { return this.ca; }
	public double getSolde() { return this.solde; }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setConfigured(boolean conf) {
		this.configured = conf;
	}
	
	public void setNumAchat(int num) {
		this.numAchat = num;
	}
	
	public void setNumVente(int num) {
		this.numVente = num;
	}
	
	public void setPlus(double plus) {
		this.plus = plus;
	}
	
	public void setMoins(double moins) {
		this.moins = moins;
	}
	
	public void setResultat(double resultat) {
		this.resultat = resultat;
	}
	
	public void setCa(double ca) {
		this.ca = ca;
	}
	
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public void acheter(ListProd p) {
		
	}
	
	public void thread(Produit p) {
		System.out.println(p.toString());
	}
	
	public int count() {
		int i = 0;
		for (int j = 0; j < test.size(); j++) {
			i++;
		}
		return i;
	}
	
	public void voirReg(String registre) {
		String chaine = "";
		LinkedList<String> choix = new LinkedList<String>();
		if(registre == "Achat") {
			choix = this.getRegAchat();
			chaine += "\nRegistre des achats\n";
		} else if(registre == "Vente") {
			choix = this.getRegVente();
			chaine += "\nRegistre des ventes\n";
		}
		
		int temp = chaine.length();
		for(int i = 0; i < temp - 2; i++) {
			chaine += "-"; 
		}
		if(choix.isEmpty() == false) {
			for(String str : choix) {
				chaine += "\n"+str;
			}
		} else {
			chaine += "\nAucun achat n'a encore �t� effectu�";
		}
		
		System.out.println(chaine);
	}
	
	public void menu() {
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int choix;
		do {
			System.out.println("\t\tGestion du magasin\n\t\t------------------");
			System.out.println("\n\tDashBoard\n\t---------");
			System.out.println("\n\tNom : \t"+this.getName()+"\t\t\tSolde : "+this.getSolde());
			System.out.println("\n\tAdresse : \t"+this.getAdresse()+"\t\tCA : "+this.getCa());
			System.out.println("\n\tVille : \t"+this.getVille()+"\t\tVentes : "+this.getRegAchat().size());
			System.out.println("\n\tCode postal : \t"+this.getCp()+"\t\t\tAchats : "+this.getRegVente().size());
			System.out.println("\n\tT�l�phone : \t"+this.getTel()+"\t\t\tR�sultat : "+this.getSolde());
			System.out.println("\n\n\tMenu\n\t----");
			
			choix = Console.saisirInt();
			switch (choix) {
			case 1:
				
				break;

			default:
				break;
			}
		} while (choix != 0);
		
		
		
	}
}